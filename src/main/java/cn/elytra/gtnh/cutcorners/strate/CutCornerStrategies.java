package cn.elytra.gtnh.cutcorners.strate;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.wohaopa.GTNHModify.mixins.late.gregtech.EyeOfHarmonyRecipeAccessor;
import gregtech.api.util.GT_Recipe;

import java.util.Optional;

public class CutCornerStrategies {

    public static Optional<ICutCornerStrategy> valueOf(String name) {
        switch(name) {
            case "NOOP":
            case "None":
                return Optional.of(NOOP);
            case "ONE_TICK":
            case "OneTick":
                return Optional.of(ONE_TICK);
            case "Tenths":
                reducedBy = 10;
            case "REDUCED_DURATION":
                return Optional.of(REDUCED_DURATION);
            case "Output64":
            case "Energyless":
                throw new IllegalStateException("The strategy " + name + " is not implemented in CutCorners.");
            default:
                return Optional.empty();
        }
    }

    public static final ICutCornerStrategy NOOP = new ICutCornerStrategy() {};

    public static final ICutCornerStrategy ONE_TICK = new ICutCornerStrategy() {
        @Override
        public void updateGTRecipe(GT_Recipe recipe) {
            recipe.mDuration = 1;
        }

        @Override
        public void updateAssemblyLineRecipe(GT_Recipe.GT_Recipe_AssemblyLine recipe) {
            recipe.mDuration = 1;
        }

        @Override
        public void updateEOHRecipe(EyeOfHarmonyRecipe recipe) {
            EyeOfHarmonyRecipeAccessor r = (EyeOfHarmonyRecipeAccessor) recipe;
            r.set_miningTimeSeconds(1);
            r.set_hydrogenRequirement(1);
            r.set_heliumRequirement(1);
            r.set_baseSuccessChance(5);
            r.set_euOutput(Integer.MAX_VALUE);
            r.set_euStartCost(114);
        }

        @Override
        public int getMaxFurnaceSmeltingTime(int original) {
            return 1;
        }

        @Override
        public int getBotaniaSpreaderPingbackTicks(int original) {
            return 1;
        }

        @Override
        public int getMaxProgressTime(Object instance, int original) {
            return 1;
        }

        @Override
        public int getThaumcraftFurnaceSmeltingTime(int original) {
            return 1;
        }

        @Override
        public int getThaumcraftNodeRegenerationTime(int original) {
            return 1;
        }
    };

    public static int reducedBy = 100;

    public static final ICutCornerStrategy REDUCED_DURATION = new ICutCornerStrategy() {
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
    };

}
