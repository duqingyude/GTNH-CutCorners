package cn.elytra.gtnh.cutcorners.strate;

import java.util.Optional;

public class CutCornerStrategies {

    public static Optional<ICutCornerStrategy> getByName(String name) {
        return switch (name) {
            case "NOOP" -> Optional.of(NOOP);
            case "EVENT" -> Optional.of(EVENT);
            default -> Optional.empty();
        };
    }

    @Deprecated
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
            case "EVENT":
                return Optional.of(EVENT);
            default:
                return Optional.empty();
        }
    }

    public static final ICutCornerStrategy NOOP = new ICutCornerStrategy() {};

    @Deprecated public static final OneTickStrategy ONE_TICK = new OneTickStrategy();
    @Deprecated public static final ReducedDurationStrategy REDUCED_DURATION = new ReducedDurationStrategy();
    @Deprecated public static final OneTickLVStrategy ONE_TICK_ALL_LV = new OneTickLVStrategy();

    public static final EventStrategy EVENT = new EventStrategy();

}
