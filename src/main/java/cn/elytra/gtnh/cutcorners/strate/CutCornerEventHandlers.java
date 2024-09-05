package cn.elytra.gtnh.cutcorners.strate;

import cn.elytra.gtnh.cutcorners.strate.listener.OneTickListener;
import cn.elytra.gtnh.cutcorners.strate.listener.TierLVListener;

import java.util.Optional;

public class CutCornerEventHandlers {

    public static final OneTickListener ONE_TICK = new OneTickListener();
    public static final TierLVListener GT_TIER_LV = new TierLVListener();

    public static Optional<Object> getHandler(String name) {
        return switch (name) {
            case "ONE_TICK" -> Optional.of(ONE_TICK);
            case "GT_TIER_LV" -> Optional.of(GT_TIER_LV);
            default -> Optional.empty();
        };
    }

}
