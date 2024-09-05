package cn.elytra.gtnh.cutcorners.init;

import cn.elytra.gtnh.cutcorners.CutCorners;
import com.github.technus.tectech.TecTech;
import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.technus.tectech.recipe.TecTechRecipeMaps;
import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GT_Recipe;
import kubatech.api.helpers.ReflectionHelper;

import java.util.HashMap;

public class GTRecipeInit {

    public static void init() {
        updateGeneralRecipes();
        updateAssemblyLineRecipes();
        updateEOHRecipes();
        updateResearchStationRecipes();
    }

    private static void updateGeneralRecipes() {
        RecipeMap.ALL_RECIPE_MAPS.forEach((s, map) -> {
            if (map == GoodGeneratorRecipeMaps.naquadahReactorFuels) return;
            CutCorners.LOG.info("Updating GT_Recipe Map: {}", map.unlocalizedName);
            map.getAllRecipes().forEach(recipe -> CutCorners.getStrategy().updateGTRecipe(recipe));
        });
    }

    private static void updateAssemblyLineRecipes() {
        CutCorners.LOG.info("Updating Assembly Line Recipes");
        GT_Recipe.GT_Recipe_AssemblyLine.sAssemblylineRecipes.forEach((recipe) -> CutCorners.getStrategy().updateAssemblyLineRecipe(recipe));
    }

    private static void updateEOHRecipes() {
        CutCorners.LOG.info("Updating Eye of Harmony Recipes");
        TecTechRecipeMaps.eyeOfHarmonyRecipes.getAllRecipes().forEach(recipe -> CutCorners.getStrategy().updateGTRecipe(recipe));

        var recipeMap = ReflectionHelper.<HashMap<String, EyeOfHarmonyRecipe>>getField(TecTech.eyeOfHarmonyRecipeStorage, "recipeHashMap");
        recipeMap.forEach((s, recipe) -> CutCorners.getStrategy().updateEOHRecipe(recipe));
    }

    private static void updateResearchStationRecipes() {
        CutCorners.LOG.info("Updating Research Station Recipes");
        TecTechRecipeMaps.researchStationFakeRecipes.getAllRecipes().forEach(recipe -> CutCorners.getStrategy().updateResearchStationRecipe(recipe));
    }

}
