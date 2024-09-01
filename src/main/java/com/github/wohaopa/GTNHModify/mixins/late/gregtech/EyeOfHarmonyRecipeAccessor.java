package com.github.wohaopa.GTNHModify.mixins.late.gregtech;

import com.github.technus.tectech.recipe.EyeOfHarmonyRecipe;
import com.github.technus.tectech.util.FluidStackLong;
import com.github.technus.tectech.util.ItemStackLong;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.ArrayList;

@Mixin(value = EyeOfHarmonyRecipe.class, remap = false)
public interface EyeOfHarmonyRecipeAccessor {

    @Accessor("outputItems")
    ArrayList<ItemStackLong> get_outputItems();

    @Accessor("outputItems")
    void set_outputItems(ArrayList<ItemStackLong> value);

    @Accessor("outputFluids")
    ArrayList<FluidStackLong> get_outputFluids();

    @Accessor("outputFluids")
    void set_outputFluids(ArrayList<FluidStackLong> value);

    @Accessor("hydrogenRequirement")
    long get_hydrogenRequirement();

    @Accessor("hydrogenRequirement")
    void set_hydrogenRequirement(long value);

    @Accessor("heliumRequirement")
    long get_heliumRequirement();

    @Accessor("heliumRequirement")
    void set_heliumRequirement(long value);

    @Accessor("euOutput")
    long get_euOutput();

    @Accessor("euOutput")
    void set_euOutput(long value);

    @Accessor("euStartCost")
    long get_euStartCost();

    @Accessor("euStartCost")
    void set_euStartCost(long value);

    @Accessor("baseSuccessChance")
    double get_baseSuccessChance();

    @Accessor("baseSuccessChance")
    void set_baseSuccessChance(double value);

    @Accessor("spacetimeCasingTierRequired")
    long get_spacetimeCasingTierRequired();

    @Accessor("spacetimeCasingTierRequired")
    void set_spacetimeCasingTierRequired(long value);

    @Accessor("miningTimeSeconds")
    long get_miningTimeSeconds();

    @Accessor("miningTimeSeconds")
    void set_miningTimeSeconds(long value);

    @Accessor("recipeEnergyEfficiency")
    double get_recipeEnergyEfficiency();

    @Accessor("recipeEnergyEfficiency")
    void set_recipeEnergyEfficiency(double value);

    @Accessor("recipeTriggerItem")
    ItemStack get_recipeTriggerItem();

    @Accessor("recipeTriggerItem")
    void set_recipeTriggerItem(ItemStack value);

    @Accessor("sumOfItems")
    long get_sumOfItems();

    @Accessor("sumOfItems")
    void set_sumOfItems(long value);

    @Accessor("rocketTier")
    long get_rocketTier();

    @Accessor("rocketTier")
    void set_rocketTier(long value);

}
