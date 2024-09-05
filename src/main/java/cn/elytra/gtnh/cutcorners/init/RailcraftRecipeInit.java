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
        CutCorners.LOG.info("Updating Railcraft Coke Oven Recipes");
        CokeOvenCraftingManager.getInstance().getRecipes().forEach((recipe) -> CutCorners.getStrategy().updateRailcraftCokeOvenRecipe(recipe));
    }

    private static void updateBlastFurnaceRecipes() {
        CutCorners.LOG.info("Updating Railcraft Blast Furnace Recipes");
        BlastFurnaceCraftingManager.getInstance().getRecipes().forEach((recipe) -> CutCorners.getStrategy().updateRailcraftBlastFurnaceRecipe(recipe));
    }

}
