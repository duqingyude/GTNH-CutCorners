package com.github.wohaopa.GTNHModify.config;

import cn.elytra.gtnh.cutcorners.CutCorners;
import cn.elytra.gtnh.cutcorners.strate.*;
import com.github.wohaopa.GTNHModify.GTNHModifyMod;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.Optional;

public class Config {

    public static Configuration config;

    private static boolean doSave;

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
        }
        doSave = false;
        loadConfig();
        FMLCommonHandler.instance()
            .bus()
            .register(new Config());
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(GTNHModifyMod.MOD_ID)) {
            loadConfig();
        }
    }

    private static void loadConfig() {

        Property propStrategy = config.get(
            Configuration.CATEGORY_GENERAL,
            "Strategy",
            "EVENT",
            """
                The strategy of cut corners.
                NOOP: No cut corners.
                EVENT: Cut corners triggered by events.
                Others are deprecated and works like EVENT.""",
            new String[]{"NOOP", "EVENT", "None", "OneTick", "Tenths", "Output64", "Energyless"}
        );
        String strategyName = propStrategy.getString();

        // handle deprecated
        if (strategyName.equals("None") ||
            strategyName.equals("OneTick") ||
            strategyName.equals("Tenths") ||
            strategyName.equals("Output64") ||
            strategyName.equals("Energyless")) {
            propStrategy.set("EVENT");
            strategyName = propStrategy.getString();
        }

        try {
            Optional<ICutCornerStrategy> strategy = CutCornerStrategies.getByName(strategyName);
            CutCorners.setStrategy(strategy.orElse(CutCornerStrategies.EVENT));
        } catch (IllegalStateException e) {
            CutCorners.LOG.error("The strategy {} is not implemented in CutCorners!", strategyName, e);
        }

        Property propEventHandlers = config.get(
            Configuration.CATEGORY_GENERAL,
            "EventHandlers",
            new String[] {"TENFOLD_REDUCTION_TICK"},
            """
                The event handlers used by EVENT strategy.
                ONE_TICK: All recipes and processing time are set to 1 tick.
                GT_TIER_LV: All voltage tier of GT recipes are set to LV.
                TENFOLD_REDUCTION_TICK: All recipes and processing time are set to tenfold reduction tick"""
        );
        String[] eventHandlerNames = propEventHandlers.getStringList();
        for (String name : eventHandlerNames) {
            Optional<Object> handlerOptional = CutCornerEventHandlers.getHandler(name);
            if (handlerOptional.isPresent()) {
                CutCorners.registerListener(handlerOptional.get());
            } else {
                CutCorners.LOG.error("The event handler {} does not exist!", name);
            }
        }

        if (config.hasChanged() || doSave) {
            config.save();
            doSave = false;
        }
    }

}
