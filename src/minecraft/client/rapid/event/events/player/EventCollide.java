package client.rapid.event.events.player;

import client.rapid.event.events.Event;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class EventCollide extends Event {
    private AxisAlignedBB axisalignedbb;
    private final Block block;
    private final Entity collidingEntity;
    private final int x;
    private final int y;
    private final int z;
    private final BlockPos blockPos;

    public EventCollide(Entity collidingEntity, int x, int y, int z, AxisAlignedBB axisalignedbb, Block block, BlockPos pos) {
        this.collidingEntity = collidingEntity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.axisalignedbb = axisalignedbb;
        this.block = block;
        this.blockPos = pos;
    }

    public AxisAlignedBB getBoundingBox() {
        return this.axisalignedbb;
    }

    public Entity getCollidingEntity() {
        return collidingEntity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Block getBlock() {
        return block;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public void setBoundingBox(AxisAlignedBB object) {
        this.axisalignedbb = object;
    }

}
