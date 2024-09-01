package cn.elytra.gtnh.cutcorners.strate;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.wohaopa.GTNHModify.mixins.late.gregtech.EyeOfHarmonyRecipeAccessor;
import gregtech.api.util.GT_Recipe;

public class ReducedDurationStrategy implements ICutCornerStrategy {

    public int reducedBy = 100;

    @Override
    public void updateGTRecipe(GT_Recipe recipe) {
        recipe.mDuration /= reducedBy;
    }

    @Override
    public void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
        recipe.mDuration /= reducedBy;
    }

    @Override
    public void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
        EyeOfHarmonyRecipeAccessor r = (EyeOfHarmonyRecipeAccessor) recipe;
        r.set_miningTimeSeconds(r.get_miningTimeSeconds() / reducedBy);
    }

    @Override
    public int getMaxFurnaceSmeltingTime(int original) {
        return original / reducedBy;
    }

    @Override
    public int getBotaniaSpreaderPingbackTicks(int original) {
        return original / reducedBy;
    }

    @Override
    public int getMaxProgressTime(Object instance, int original) {
        return original / reducedBy;
    }

    @Override
    public int getThaumcraftFurnaceSmeltingTime(int original) {
        return original / reducedBy;
    }

    @Override
    public int getThaumcraftNodeRegenerationTime(int original) {
        return original / reducedBy;
    }
}
