package io.github.kerbaras.theta.mixin.rules;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractFireBlock.class)
public class NetherAnywhere {

	@Redirect(method = "onBlockAdded",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractFireBlock;isOverworldOrNether(Lnet/minecraft/world/World;)Z"))
	public boolean isOverworldOrNether(World world) {
		return true;
	}
}
