package com.cafecraft.core.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static com.cafecraft.core.cca.MyComponents.DAY;

@Mixin(DebugHud.class)
public class DebugHudMixin {

    private static String getDayString(World provider) {
        return DAY.get(provider).valueToString();
    }

    /*
    @Inject(method = "getLeftText", at = @At("HEAD"))
    private void PrintString(CallbackInfoReturnable<List<String>> cir) {
        System.out.println("LEFT TEXT MIXIN!!");
    }
    */

    @Inject(method = "getRightText", at = @At("RETURN"))
    private void addText(CallbackInfoReturnable<List<String>> cir) {
        String day = getDayString(MinecraftClient.getInstance().world);

        cir.getReturnValue().add("");
        cir.getReturnValue().add("Day: " + day);
    }
}