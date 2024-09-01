package com.github.wohaopa.GTNHModify.config;

import cn.elytra.gtnh.cutcorners.CutCorners;
import cn.elytra.gtnh.cutcorners.strate.CutCornerStrategies;
import cn.elytra.gtnh.cutcorners.strate.ICutCornerStrategy;
import com.github.wohaopa.GTNHModify.GTNHModifyMod;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

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

        String strategyName = config.getString(
            "Strategy",
            Configuration.CATEGORY_GENERAL,
            "OneTick",
            "Possible values: [None, OneTick, Tenths, Output64 (NOT-IMPLEMENTED), Energyless (NOT-IMPLEMENTED)]");

        try {
            Optional<ICutCornerStrategy> strategy = CutCornerStrategies.valueOf(strategyName);
            CutCorners.setStrategy(strategy.orElse(CutCornerStrategies.ONE_TICK));
        } catch (IllegalStateException e) {
            CutCorners.LOG.error("The strategy {} is not implemented in CutCorners!", strategyName, e);
        }

        if (config.hasChanged() || doSave) {
            config.save();
            doSave = false;
        }
    }

}
