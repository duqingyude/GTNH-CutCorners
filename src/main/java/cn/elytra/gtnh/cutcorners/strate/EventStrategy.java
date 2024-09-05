package cn.elytra.gtnh.cutcorners.strate;

import cn.elytra.gtnh.cutcorners.strate.event.CutCornersEvents;
import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import gregtech.api.util.GT_Recipe;
import mods.railcraft.api.crafting.IBlastFurnaceRecipe;
import mods.railcraft.api.crafting.ICokeOvenRecipe;
import net.minecraft.item.ItemStack;

public class EventStrategy implements ICutCornerStrategy {

    public void updateGTRecipe(GT_Recipe recipe) {
        CutCornersEvents.onGTRecipe(recipe);
    }

    public void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
        CutCornersEvents.onAssemblyLineRecipe(recipe);
    }

    public void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
        CutCornersEvents.onEyeOfHarmonyRecipe(recipe);
    }

    @Override
    public void updateResearchStationRecipe(GT_Recipe recipe) {
        CutCornersEvents.onResearchStationRecipe(recipe);
    }

    public void updateFurnaceRecipe_size(ItemStack stackIn, ItemStack stackOut) {
        // noop
    }

    public int getMaxFurnaceSmeltingTime(int original) {
        return CutCornersEvents.getFurnaceDuration(original);
    }

    public int getBotaniaSpreaderPingbackTicks(int original) {
        return CutCornersEvents.getBotaniaSpreadPingback(original);
    }

    public int getMaxProgressTime(Object instance, int original) {
        return CutCornersEvents.getGTMaxProgressTime(instance, original);
    }

    public int getThaumcraftFurnaceSmeltingTime(int original) {
        return CutCornersEvents.getTCFurnaceSmeltingTime(original);
    }

    public int getThaumcraftNodeRegenerationTime(int original) {
        return CutCornersEvents.getTCNodeRegenerationTime(original);
    }

    public void updateRailcraftCokeOvenRecipe(ICokeOvenRecipe recipe) {
        CutCornersEvents.onCokeOvenRecipe(recipe);
    }

    public void updateRailcraftBlastFurnaceRecipe(IBlastFurnaceRecipe recipe) {
        CutCornersEvents.onBlastFurnaceRecipe(recipe);
    }

}
