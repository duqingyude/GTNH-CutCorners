package cn.elytra.gtnh.cutcorners.init;

import cn.elytra.gtnh.cutcorners.CutCorners;
import mods.railcraft.common.util.crafting.BlastFurnaceCraftingManager;
import mods.railcraft.common.util.crafting.CokeOvenCraftingManager;

public class RailcraftRecipeInit {

    public static void init() {
        updateCokeOvenRecipes();
        updateBlastFurnaceRecipes();
    }

    private static void updateCokeOvenRecipes() {
        CokeOvenCraftingManager.getInstance().getRecipes().forEach((recipe) -> {
            CutCorners.getStrategy().updateRailcraftCokeOvenRecipe(recipe);
        });
    }

    private static void updateBlastFurnaceRecipes() {
        BlastFurnaceCraftingManager.getInstance().getRecipes().forEach((recipe) -> {
            CutCorners.getStrategy().updateRailcraftBlastFurnaceRecipe(recipe);
        });
    }

}
