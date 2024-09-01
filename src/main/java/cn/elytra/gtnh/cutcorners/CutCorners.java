package cn.elytra.gtnh.cutcorners;

import cn.elytra.gtnh.cutcorners.init.GTRecipeInit;
import cn.elytra.gtnh.cutcorners.init.RailcraftRecipeInit;
import cn.elytra.gtnh.cutcorners.init.VanillaRecipeInit;
import cn.elytra.gtnh.cutcorners.strate.CutCornerStrategies;
import cn.elytra.gtnh.cutcorners.strate.ICutCornerStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CutCorners {

    private static ICutCornerStrategy strategy = CutCornerStrategies.ONE_TICK;

    public static final Logger LOG = LogManager.getLogger("CutCorners");

    private static final Runnable[] INITIALIZERS = new Runnable[] {
        GTRecipeInit::init,
        VanillaRecipeInit::init,
        RailcraftRecipeInit::init,
    };

    public static void setStrategy(ICutCornerStrategy strategy) {
        CutCorners.strategy = strategy;
    }

    public static ICutCornerStrategy getStrategy() {
        if(strategy == null) {
            throw new IllegalStateException("strategy has not been set yet!");
        }
        return strategy;
    }

    public static void init() {
        for (Runnable initializer : INITIALIZERS) {
            try {
                initializer.run();
            } catch (Exception e) {
                LOG.error("Failed to initialize: {}", initializer, e);
            }
        }
    }

}
