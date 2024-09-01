package com.github.wohaopa.GTNHModify.mixins.late.gregtech;

import cn.elytra.gtnh.cutcorners.CutCorners;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_MultiFurnace;

@Mixin(value = GT_MetaTileEntity_MultiFurnace.class, remap = false)
public class GT_MetaTileEntity_MultiFurnaceMixin {

//    @ModifyConstant(method = "checkProcessing", constant = @Constant(intValue = 512 /* RECIPE_DURATION */))
//    private int gtnhcc$overwriteRecipeDuration(int value) {
//        // return GregTechHandler.handle(this, value);
//        return CutCorners.getStrategy().getMaxProgressTimeForOverclock(this, value);
//    }

    @Redirect(method = "checkProcessing", at = @At(value = "FIELD", target = "Lgregtech/common/tileentities/machines/multi/GT_MetaTileEntity_MultiFurnace;mMaxProgresstime:I", opcode = Opcodes.PUTFIELD))
    private void gtnhcc$overwriteRecipeDuration(GT_MetaTileEntity_MultiFurnace instance, int value) {
        instance.mMaxProgresstime = CutCorners.getStrategy().getMaxProgressTime(this, value);
    }
}
