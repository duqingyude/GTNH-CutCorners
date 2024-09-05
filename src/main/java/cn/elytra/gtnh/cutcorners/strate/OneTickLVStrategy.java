package cn.elytra.gtnh.cutcorners.strate;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.wohaopa.GTNHModify.mixins.late.gregtech.EyeOfHarmonyRecipeAccessor;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_Recipe;

@Deprecated
public class OneTickLVStrategy extends OneTickStrategy {

    private static final int RECIPE_LV = (int) TierEU.RECIPE_LV;

    @Override
    public int getMaxProgressTime(Object instance, int original) {
        return super.getMaxProgressTime(instance, original);
    }

    @Override
    public void updateGTRecipe(GT_Recipe recipe) {
        super.updateGTRecipe(recipe);
        recipe.mEUt = RECIPE_LV;
    }

    @Override
    public void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
        super.updateAssemblyLineRecipe(recipe);
        recipe.mEUt = RECIPE_LV;
    }

    @Override
    public void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
        super.updateEOHRecipe(recipe);
        EyeOfHarmonyRecipeAccessor r = (EyeOfHarmonyRecipeAccessor) recipe;
        r.set_euStartCost(RECIPE_LV);
    }
}
