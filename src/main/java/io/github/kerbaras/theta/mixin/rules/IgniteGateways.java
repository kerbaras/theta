package io.github.kerbaras.theta.mixin.rules;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlintAndSteelItem.class)
public class IgniteGateways {

	@Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
	public void ignite(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
		World world = context.getWorld();
		if (world.getRegistryKey() != World.END) return;
		BlockPos blockPos = context.getBlockPos();
		BlockState blockState = world.getBlockState(blockPos);
		if(!blockState.getBlock().equals(Blocks.END_PORTAL_FRAME)) return;
		world.setBlockState(blockPos, Blocks.END_GATEWAY.getDefaultState());
		cir.setReturnValue(ActionResult.success(world.isClient()));
	}

}
