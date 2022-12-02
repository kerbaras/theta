package io.github.kerbaras.theta;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class ThetaTickets {
	public static final ChunkTicketType<BlockPos> REDSTONE = ChunkTicketType.create("redstone", Vec3i::compareTo, 8);
	public static final ChunkTicketType<BlockPos> DISPENSER = ChunkTicketType.create("dispenser", Vec3i::compareTo, 30);
}
