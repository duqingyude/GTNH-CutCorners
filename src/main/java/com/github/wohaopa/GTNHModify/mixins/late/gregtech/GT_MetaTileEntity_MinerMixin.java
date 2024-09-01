package com.github.wohaopa.GTNHModify.mixins.late.gregtech;

import cn.elytra.gtnh.cutcorners.CutCorners;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Miner;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GT_MetaTileEntity_Miner.class, remap = false)
public class GT_MetaTileEntity_MinerMixin {

    @Mutable
    @Final
    @Shadow
    private int mSpeed;

    @Inject(method = "<init>*", at = @At("RETURN"))
    private void gtnhcc$overwriteSpeed(CallbackInfo info) {
        mSpeed = CutCorners.getStrategy().getMaxProgressTime(this, mSpeed);
    }

//    @Redirect(
//        method = "onPostTick",
//        at = @At(
//            value = "FIELD",
//            target = "Lgregtech/common/tileentities/machines/basic/GT_MetaTileEntity_Miner;mSpeed:I",
//            opcode = Opcodes.GETFIELD))
//    private int gtnhcc$overrideSpeed(GT_MetaTileEntity_Miner miner) {
//        // return GregTechHandler.handle(miner, mSpeed);
//        GT_MetaTileEntity_Miner self = (GT_MetaTileEntity_Miner) (Object) this;
//        return CutCorners.getStrategy().getMaxProgressTime(self, mSpeed);
//    }
}
