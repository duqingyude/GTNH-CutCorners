package cn.elytra.gtnh.cutcorners;

import cn.elytra.gtnh.cutcorners.init.GTRecipeInit;
import cn.elytra.gtnh.cutcorners.init.RailcraftRecipeInit;
import cn.elytra.gtnh.cutcorners.init.VanillaRecipeInit;
import cn.elytra.gtnh.cutcorners.strate.CutCornerStrategies;
import cn.elytra.gtnh.cutcorners.strate.ICutCornerStrategy;
import cn.elytra.gtnh.cutcorners.strate.event.CutCornersEvents;
import cn.elytra.gtnh.cutcorners.strate.listener.OneTickListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CutCorners {

    private static ICutCornerStrategy strategy = CutCornerStrategies.EVENT;

    public static final Logger LOG = LogManager.getLogger("GTNH-CutCorners");

    private static final Runnable[] INITIALIZERS = new Runnable[]{
        GTRecipeInit::init,
        VanillaRecipeInit::init,
        RailcraftRecipeInit::init,
    };

    public static void setStrategy(ICutCornerStrategy strategies) {
        CutCorners.strategy = strategies;
    }

    public static ICutCornerStrategy getStrategy() {
        if (strategy == null) {
            throw new IllegalStateException("strategy has not been set yet!");
        }
        return strategy;
    }

    // called in ServerStarting event
    public static void init() {
        for (Runnable initializer : INITIALIZERS) {
            try {
                initializer.run();
            } catch (Exception e) {
                LOG.error("Failed to initialize: {}", initializer, e);
            }
        }
    }

    public static void registerListener(Object listener) {
        CutCornersEvents.CC_EVENTS.register(listener);
    }

    public static void unregisterListener(Object listener) {
        CutCornersEvents.CC_EVENTS.unregister(listener);
    }

    static {
        CutCornersEvents.CC_EVENTS.register(new OneTickListener());
    }

}
