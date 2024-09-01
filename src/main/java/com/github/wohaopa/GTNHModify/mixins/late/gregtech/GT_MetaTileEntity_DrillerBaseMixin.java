package com.github.wohaopa.GTNHModify.mixins.late.gregtech;

import cn.elytra.gtnh.cutcorners.CutCorners;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_DrillerBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GT_MetaTileEntity_DrillerBase.class, remap = false)
public abstract class GT_MetaTileEntity_DrillerBaseMixin {

    @Inject(
        method = "checkProcessing",
        at = @At(
            value = "INVOKE",
            target = "Lgregtech/common/tileentities/machines/multi/GT_MetaTileEntity_DrillerBase;setElectricityStats()V",
            shift = At.Shift.AFTER))
    private void gtnhcc$updateMaxProgressTime(CallbackInfoReturnable<CheckRecipeResult> cir) {

//        ((GT_MetaTileEntity_DrillerBase) ((Object) this)).mMaxProgresstime = GregTechHandler
//            .handle(this, ((GT_MetaTileEntity_DrillerBase) ((Object) this)).mMaxProgresstime);

        GT_MetaTileEntity_DrillerBase self = (GT_MetaTileEntity_DrillerBase) (Object) this;
        self.mMaxProgresstime = CutCorners.getStrategy().getMaxProgressTime(self, self.mMaxProgresstime);
    }
}
