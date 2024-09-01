package cn.elytra.gtnh.cutcorners.strate;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_Recipe;
import net.minecraft.item.ItemStack;

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
                CutCornerStrategies.REDUCED_DURATION.reducedBy = 10;
            case "REDUCED_DURATION":
                return Optional.of(REDUCED_DURATION);
            case "ONE_TICK_LV":
                return Optional.of(ONE_TICK_ALL_LV);
            case "Output64":
            case "Energyless":
                throw new IllegalStateException("The strategy " + name + " is not implemented in CutCorners.");
            default:
                return Optional.empty();
        }
    }

    public static final ICutCornerStrategy NOOP = new ICutCornerStrategy() {};
    public static final OneTickStrategy ONE_TICK = new OneTickStrategy();
    public static final ReducedDurationStrategy REDUCED_DURATION = new ReducedDurationStrategy();
    public static final OneTickLVStrategy ONE_TICK_ALL_LV = new OneTickLVStrategy();

}
