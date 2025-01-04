package cn.elytra.gtnh.cutcorners.util;

public class MaskUtils {

	/*
	So, I'm writing this before I forget what the heck is this.

	This is a kind of tool to manipulate the values combined into one integer or long value, like
	Special Values of Research Station recipes.

	Its higher 16 bits is for Min Computation, and the lower 16 bits is for Amperage, like:

	0000_0000_0001_0000_0000_0000_0000_1000
	|-       16       -||-       16      -|
	                   ^ splits here

	* The Min Computation part is:
		0000_0000_0001_0000 (decimal 16)
	* The Amperage part is:
		0000_0000_0000_1000 (decimal 8)

	So you are going to have a MaskOperator like:
	* for higher Min Computation:
		new MaskOperator(16, 16)
	* for lower Amperage:
		new MaskOperator(16, 0)

	And changes the Special Values with the provided methods of MaskOperator.

	For example, I want to change the Amperage to 8, I will do:
		specialValue = (new MaskOperator(16, 0)).toValueInt(specialValue, 8);
	And if I want to change the Min Computation to 25, I will do:
		specialValue = (new MaskOperator(16, 16)).toValueInt(specialValue, 25);

	 */
	public static class MaskOperator {

		private final int bitCount;
		private final int bitOffset;

		private final long maskLong;
		private final long maxValueLong;

		private final int maskInt;
		private final int maxValueInt;

		private boolean allowInteger = true;

		public MaskOperator(int bitCount, int bitOffset) {
			this(bitCount, bitOffset, false);
		}

		public MaskOperator(int bitCount, int bitOffset, boolean supportsInteger) {
			this.bitCount = bitCount;
			this.bitOffset = bitOffset;

			this.maskLong = ((1L << (bitCount + bitOffset))) - (1L << (bitOffset));
			this.maxValueLong = (1L << bitCount) - 1;

			if(maskLong >> 32 != 0) { // greater than integer, long only
				if(supportsInteger) {
					throw new IllegalArgumentException("the mask is too big to fit in integer mode");
				}
				this.allowInteger = false;

				this.maskInt = 0;
				this.maxValueInt = 0;
			} else {
				this.maskInt = (int) maskLong;
				this.maxValueInt = (int) maxValueLong;
			}
		}

		@Override
		public String toString() {
			return "MaskOperator{bits=" + bitCount + ", offset=" + bitOffset + ", mask=" + Long.toString(maskLong, 2) + "}";
		}

		private long zero(long value) {
			return value & ~maskLong;
		}

		private long offset(long value) {
			if(value > maxValueLong) {
				throw new IllegalArgumentException("the value is too big: " + value + " > " + maxValueLong);
			}
			return value << bitOffset;
		}

		public long setValue(long whole, int part) {
			return (zero(whole) | offset(part));
		}

		public long toValue(long whole) {
			return ((whole & maskLong) >> bitOffset);
		}

		private int zeroInt(int value) {
			return value & ~maskInt;
		}

		private int offsetInt(int value) {
			if(value > maxValueInt) {
				throw new IllegalArgumentException("the value is too big: " + value + " > " + maxValueInt);
			}
			return value << bitOffset;
		}

		public int toValueInt(int whole, int part) {
			if(!allowInteger) throw new IllegalStateException("integer not allowed");
			return (zeroInt(whole) | offsetInt(part));
		}

		public int getValueInt(int whole) {
			if(!allowInteger) throw new IllegalStateException("integer not allowed");
			return ((whole & maskInt) >> bitOffset);
		}
	}

}
