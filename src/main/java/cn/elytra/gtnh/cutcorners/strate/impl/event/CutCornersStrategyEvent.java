package cn.elytra.gtnh.cutcorners.strate.impl.event;

import cn.elytra.gtnh.cutcorners.strate.ICutCornerStrategy;
import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import gregtech.api.util.GT_Recipe;
import mods.railcraft.api.crafting.IBlastFurnaceRecipe;
import mods.railcraft.api.crafting.ICokeOvenRecipe;
import net.minecraft.item.ItemStack;

public class CutCornersStrategyEvent implements ICutCornerStrategy {

    public void updateGTRecipe(GT_Recipe recipe) {
        CutCornersEventDispatchHelper.onGTRecipe(recipe);
    }

    public void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
        CutCornersEventDispatchHelper.onAssemblyLineRecipe(recipe);
    }

    public void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
        CutCornersEventDispatchHelper.onEyeOfHarmonyRecipe(recipe);
    }

    @Override
    public void updateResearchStationRecipe(GT_Recipe recipe) {
        CutCornersEventDispatchHelper.onResearchStationRecipe(recipe);
    }

    public void updateFurnaceRecipe_size(ItemStack stackIn, ItemStack stackOut) {
        // noop
    }

    public int getMaxFurnaceSmeltingTime(int original) {
        return CutCornersEventDispatchHelper.getFurnaceDuration(original);
    }

    public int getBotaniaSpreaderPingbackTicks(int original) {
        return CutCornersEventDispatchHelper.getBotaniaSpreadPingback(original);
    }

    public int getMaxProgressTime(Object instance, int original) {
        return CutCornersEventDispatchHelper.getGTMaxProgressTime(instance, original);
    }

    public int getThaumcraftFurnaceSmeltingTime(int original) {
        return CutCornersEventDispatchHelper.getTCFurnaceSmeltingTime(original);
    }

    public int getThaumcraftNodeRegenerationTime(int original) {
        return CutCornersEventDispatchHelper.getTCNodeRegenerationTime(original);
    }

    public void updateRailcraftCokeOvenRecipe(ICokeOvenRecipe recipe) {
        CutCornersEventDispatchHelper.onCokeOvenRecipe(recipe);
    }

    public void updateRailcraftBlastFurnaceRecipe(IBlastFurnaceRecipe recipe) {
        CutCornersEventDispatchHelper.onBlastFurnaceRecipe(recipe);
    }

}
