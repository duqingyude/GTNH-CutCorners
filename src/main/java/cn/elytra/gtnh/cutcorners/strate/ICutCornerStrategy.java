package cn.elytra.gtnh.cutcorners.strate;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import gregtech.api.util.GT_Recipe;
import net.minecraft.item.ItemStack;

public interface ICutCornerStrategy {

    default void updateGTRecipe(GT_Recipe recipe) {
    }

    default void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
    }

    default void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
    }

    default void updateFurnaceRecipe_size(ItemStack stackIn, ItemStack stackOut) {
    }

    default int getMaxFurnaceSmeltingTime(int original) {
        return original;
    }

    default int getBotaniaSpreaderPingbackTicks(int original) {
        return original;
    }

    default int getMaxProgressTime(Object instance, int original) {
        return original;
    }

    default int getThaumcraftFurnaceSmeltingTime(int original) {
        return original;
    }

    default int getThaumcraftNodeRegenerationTime(int original) {
        return original;
    }

}
