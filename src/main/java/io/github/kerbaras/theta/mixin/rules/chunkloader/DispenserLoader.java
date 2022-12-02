package io.github.kerbaras.theta.mixin.rules.chunkloader;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.DropperBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.kerbaras.theta.ThetaTickets.DISPENSER;

@Mixin({DispenserBlock.class, DropperBlock.class})
public class DispenserLoader {

	@Inject(method = "dispense", at = @At("HEAD"))
	protected void scheduleLoad(ServerWorld world, BlockPos pos, CallbackInfo ci){
		world.getChunkManager().addTicket(DISPENSER, new ChunkPos(pos),3, pos);
	}
}
