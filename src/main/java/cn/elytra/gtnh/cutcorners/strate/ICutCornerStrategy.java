package cn.elytra.gtnh.cutcorners.strate;

import cn.elytra.gtnh.cutcorners.strate.impl.event.CutCornersEventDispatchHelper;
import cn.elytra.gtnh.cutcorners.strate.impl.event.CutCornersStrategyEvent;
import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import gregtech.api.util.GT_Recipe;
import mods.railcraft.api.crafting.IBlastFurnaceRecipe;
import mods.railcraft.api.crafting.ICokeOvenRecipe;
import net.minecraft.item.ItemStack;

/**
 * The strategy of how to work with modifications.
 * <p>
 * Methods naming starting with <i>update</i> are mostly invoked once per recipe on game load completion, which they are
 * not changing before next game restart.
 * <p>
 * Others are dynamically invoked during the machine updates.
 * They are changeable while the game is still running, but it is not recommended!
 * <p>
 * It is recommended to combine many strategies with {@link CutCornersStrategyEvent},
 * by listening to its events dispatched from {@link CutCornersEventDispatchHelper#CC_EVENTS CutCorners Event Bus}.
 *
 * @see CutCornerStrategies
 */
public interface ICutCornerStrategy {

    /**
     * Modify the {@link GT_Recipe}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateGTRecipe(GT_Recipe recipe) {
    }

    /**
     * Modify the {@link GT_Recipe.GT_Recipe_AssemblyLine}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
    }

    /**
     * Modify the {@link EyeOfHarmonyRecipe}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
    }

    /**
     * Modify the {@link GT_Recipe Research Station GT_Recipe}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateResearchStationRecipe(GT_Recipe recipe) {
    }

    /**
     * Modify the input and output of furnace recipes.
     * <p>
     * You should make modification directly on the itemstack references, like editing sizes.
     * <p>
     * It should be invoked once per recipe on game load completion.
     *
     * @param stackIn  the input itemstack
     * @param stackOut the output itemstack
     */
    default void updateFurnaceRecipe_size(ItemStack stackIn, ItemStack stackOut) {
    }

    /**
     * Return the max smelting time (working duration) of furnaces.
     * It will be invoked on furnace updates.
     */
    default int getMaxFurnaceSmeltingTime(int original) {
        return original;
    }

    /**
     * Return the pingback ticks of Botania spreaders.
     * It will be invoked on spreader updates.
     */
    default int getBotaniaSpreaderPingbackTicks(int original) {
        return original;
    }

    /**
     * Return the max progress time of GregTech machines.
     * It will be invoked on machine updates.
     *
     * @param instance the reference instance of the GregTech machine.
     *                 You can make conditions based on this instance.
     */
    default int getMaxProgressTime(Object instance, int original) {
        return original;
    }

    /**
     * Return the smelting time of Thaumcraft Furnaces.
     * It will be invoked on TC furnace updates.
     */
    default int getThaumcraftFurnaceSmeltingTime(int original) {
        return original;
    }

    /**
     * Return the node regeneration time of Thaumcraft Nodes.
     * It will be invoked on TC node updates.
     */
    default int getThaumcraftNodeRegenerationTime(int original) {
        return original;
    }

    /**
     * Modify the {@link ICokeOvenRecipe}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateRailcraftCokeOvenRecipe(ICokeOvenRecipe recipe) {
    }

    /**
     * Modify the {@link IBlastFurnaceRecipe}.
     * It should be invoked once per recipe on game load completion.
     */
    default void updateRailcraftBlastFurnaceRecipe(IBlastFurnaceRecipe recipe) {
    }

}
