package io.github.kerbaras.theta.mixin.rules.chunkloader;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kerbaras.theta.ThetaTickets.REDSTONE;

@Mixin({RedstoneWireBlock.class, PistonBlock.class, AbstractRedstoneGateBlock.class, AbstractRailBlock.class})
public class BlockEventLoader {

	@Inject(method = "neighborUpdate", at = @At("HEAD"))
	private void scheduleLoad(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify, CallbackInfo ci){
		if (world.isClient()) return;
		((ServerWorld) world).getChunkManager().addTicket(REDSTONE, new ChunkPos(pos),2, pos);
	}
}
