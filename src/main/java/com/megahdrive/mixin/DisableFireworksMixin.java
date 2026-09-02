package com.megahdrive.mixin;

import com.megahdrive.HardPlusPlus;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class DisableFireworksMixin {
    // Could use @Overwrite but we dont wanna break stuff by messing around with it
    // On unmodded clients:
    // Clients show a swing because their client sends a swing packet to the server predicting that use is normal.
    // Since use is only altered on the server, the logic applies, but the swing packet still replicates :(
    // No workaround really. Doesnt happen on modded clients
    @Inject(at = @At("HEAD"), method = "use", cancellable = true)
    private void use(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (!HardPlusPlus.CONFIG.disableElytraFireworks) return;
        cir.setReturnValue(InteractionResult.PASS);
        cir.cancel();
    }
}
