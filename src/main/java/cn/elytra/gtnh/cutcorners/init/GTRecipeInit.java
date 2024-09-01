package cn.elytra.gtnh.cutcorners.init;

import cn.elytra.gtnh.cutcorners.CutCorners;
import com.github.technus.tectech.TecTech;
import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.technus.tectech.recipe.TecTechRecipeMaps;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GT_Recipe;
import kubatech.api.helpers.ReflectionHelper;

import java.util.HashMap;

public class GTRecipeInit {

    public static void init() {
        updateGeneralRecipes();
        updateAssemblyLineRecipes();
        updateEOHRecipes();
    }

    private static void updateGeneralRecipes() {
        RecipeMap.ALL_RECIPE_MAPS.forEach((s, map) -> {
            map.getAllRecipes().forEach(recipe -> CutCorners.getStrategy().updateGTRecipe(recipe));
        });
    }

    private static void updateAssemblyLineRecipes() {
        GT_Recipe.GT_Recipe_AssemblyLine.sAssemblylineRecipes.forEach((recipe) -> {
            CutCorners.getStrategy().updateAssemblyLineRecipe(recipe);
        });
    }

    private static void updateEOHRecipes() {
        TecTechRecipeMaps.eyeOfHarmonyRecipes.getAllRecipes().forEach(recipe -> {
            CutCorners.getStrategy().updateGTRecipe(recipe);
        });

        var recipeMap = ReflectionHelper.<HashMap<String, EyeOfHarmonyRecipe>>getField(TecTech.eyeOfHarmonyRecipeStorage, "recipeHashMap");
        recipeMap.forEach((s, recipe) -> {
            CutCorners.getStrategy().updateEOHRecipe(recipe);
        });
    }

}
