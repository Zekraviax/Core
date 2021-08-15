package com.cafecraft.core.mixin;

import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public class DebugHudMixin {

    @Inject(method = "renderLeftText", at = @At("TAIL"))
    private void PrintString(MatrixStack matrices, CallbackInfo ci) {
        System.out.println("MIXIN!!");
    }

    @Inject(method = "getLeftText()Ljava/util/List;", at = @At("RETURN"))
    private void addText(CallbackInfoReturnable<List<String>> cir) {

        cir.getReturnValue().add("Test!");
        //cir.getReturnValue().add("DAY: TEST DAY STRING");
    }
}