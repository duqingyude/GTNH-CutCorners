package cn.elytra.gtnh.cutcorners.strate.listener;

import cn.elytra.gtnh.cutcorners.strate.event.GetDurationEvent;
import cn.elytra.gtnh.cutcorners.strate.event.ModifyRecipeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TenfoldReductionTickListener {

    @SubscribeEvent
    public void onGTRecipe(ModifyRecipeEvent.GregTech e) {
        e.recipe.mDuration = Math.max(1, (int) (e.recipe.mDuration * 0.1));
    }

    @SubscribeEvent
    public void onGTAssemblyLine(ModifyRecipeEvent.GT_AssemblyLine e) {
        e.recipe.mDuration = Math.max(1, (int) (e.recipe.mDuration * 0.1));
    }

    @SubscribeEvent
    public void onEOHRecipe(ModifyRecipeEvent.GT_EyeOfHarmony e) {
        e.getAccessor().set_miningTimeSeconds(Math.max(1, (int) (e.getAccessor().get_miningTimeSeconds() * 0.1)));
    }

    @SubscribeEvent
    public void onResearchStation(ModifyRecipeEvent.GT_ResearchStation e) {
        e.recipe.mDuration = Math.max(1, (int) (e.recipe.mDuration * 0.1));
    }

    @SubscribeEvent
    public void onRCCokeOven(ModifyRecipeEvent.RC_CokeOven e) {
        e.getAccessor().set_cookTime(Math.max(1, (int) (e.getAccessor().get_cookTime() * 0.1)));
    }

    @SubscribeEvent
    public void onBlastFurnace(ModifyRecipeEvent.RC_BlastFurnace e) {
        e.getAccessor().set_cookTime(Math.max(1, (int) (e.getAccessor().get_cookTime() * 0.1)));
    }

    @SubscribeEvent
    public void onFurnaceSmelting(GetDurationEvent.FurnaceSmeltingTime e) {
        e.setDuration(Math.max(1, (int) (e.getDuration() * 0.1)));
    }

    @SubscribeEvent
    public void onBotaniaSpreader(GetDurationEvent.Botania_SpreadPingback e) {
        e.setDuration(Math.max(1, (int) (e.getDuration() * 0.1)));
    }

    @SubscribeEvent
    public void onGTMachine(GetDurationEvent.GT_MaxProgressTime e) {
        e.setDuration(Math.max(1, (int) (e.getDuration() * 0.1)));
    }

    @SubscribeEvent
    public void onTCFurnaceSmelting(GetDurationEvent.TC_FurnaceSmeltingTime e) {
        e.setDuration(Math.max(1, (int) (e.getDuration() * 0.1)));
    }

    @SubscribeEvent
    public void onTCNodeRegen(GetDurationEvent.TC_NodeRegenerationTime e) {
        e.setDuration(Math.max(1, (int) (e.getDuration() * 0.1)));
    }

}
