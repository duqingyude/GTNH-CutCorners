import cn.elytra.gtnh.cutcorners.strate.util.ResearchStationHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test cases for complicated special values.
 */
public class TestSpecialValueAccessors {

    @Test
    public void testResearchStationSV() {
        int value = 0;

        Assertions.assertEquals(0, ResearchStationHelper.getAmp(value));
        Assertions.assertEquals(0, ResearchStationHelper.getMinComputation(value));

        value += 100 << 16; // set 100 to min computation

        Assertions.assertEquals(0, ResearchStationHelper.getAmp(value));
        Assertions.assertEquals(100, ResearchStationHelper.getMinComputation(value));

        value += 200;

        Assertions.assertEquals(200, ResearchStationHelper.getAmp(value));
        Assertions.assertEquals(100, ResearchStationHelper.getMinComputation(value));

        // value = (minComp) 100 & (amp) 200

        Assertions.assertEquals((((value >> 16) << 16) + 12), ResearchStationHelper.getSpecialValueAtAmp(value, 12));
        Assertions.assertEquals(((99 << 16) | 200), ResearchStationHelper.getSpecialValueAtMinComputation(value, 99));
    }

}
