package client.rapid.util.block;

import client.rapid.util.MinecraftUtil;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

import java.util.List;

public class BlockUtil extends MinecraftUtil {

    public static BlockPos getBlock(Block block, double range) {
        for (double x = -range; x < range; ++x) {
            for (double y = -range; y < range; ++y) {
                for (double z = -range; z < range; ++z) {
                    if(mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX + x, mc.thePlayer.posY + y, mc.thePlayer.posZ + z)).getBlock() == block) {
                        return new BlockPos(mc.thePlayer.posX + x, mc.thePlayer.posY + y, mc.thePlayer.posZ + z);
                    }
                }
            }
        }
        return null;
    }

    public static BlockData getBlockData(BlockPos pos, List<Block> invalid) {
        BlockPos pos1 = pos.add(-1, 0, 0),
                pos2 = pos.add(1, 0, 0),
                pos3 = pos.add(0, 0, 1),
                pos4 = pos.add(0, 0, -1),
                pos5 = pos.add(0, -1, 0),
                pos6 = pos5.add(1, 0, 0),
                pos7 = pos5.add(-1, 0, 0),
                pos8 = pos5.add(0, 0, 1),
                pos9 = pos5.add(0, 0, -1);

        if (!invalid.contains(mc.theWorld.getBlockState((pos.add(0, -1, 0))).getBlock()))
            return new BlockData(pos.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos.add(1, 0, 0))).getBlock()))
            return new BlockData(pos.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos.add(0, 0, 1))).getBlock()))
            return new BlockData(pos.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos.add(0, 0, -1))).getBlock()))
            return new BlockData(pos.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, -1, 0))).getBlock()))
            return new BlockData(pos1.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos1.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(1, 0, 0))).getBlock()))
            return new BlockData(pos1.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, 0, 1))).getBlock()))
            return new BlockData(pos1.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, 0, -1))).getBlock()))
            return new BlockData(pos1.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, -1, 0))).getBlock()))
            return new BlockData(pos2.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos2.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(1, 0, 0))).getBlock()))
            return new BlockData(pos2.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, 0, 1))).getBlock()))
            return new BlockData(pos2.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, 0, -1))).getBlock()))
            return new BlockData(pos2.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, -1, 0))).getBlock()))
            return new BlockData(pos3.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos3.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(1, 0, 0))).getBlock()))
            return new BlockData(pos3.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, 0, 1))).getBlock()))
            return new BlockData(pos3.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, 0, -1))).getBlock()))
            return new BlockData(pos3.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, -1, 0))).getBlock()))
            return new BlockData(pos4.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos4.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(1, 0, 0))).getBlock()))
            return new BlockData(pos4.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, 0, 1))).getBlock()))
            return new BlockData(pos4.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, 0, -1))).getBlock()))
            return new BlockData(pos4.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, -1, 0))).getBlock()))
            return new BlockData(pos1.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos1.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(1, 0, 0))).getBlock()))
            return new BlockData(pos1.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, 0, 1))).getBlock()))
            return new BlockData(pos1.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos1.add(0, 0, -1))).getBlock()))
            return new BlockData(pos1.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, -1, 0))).getBlock()))
            return new BlockData(pos2.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos2.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(1, 0, 0))).getBlock()))
            return new BlockData(pos2.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, 0, 1))).getBlock()))
            return new BlockData(pos2.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos2.add(0, 0, -1))).getBlock()))
            return new BlockData(pos2.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, -1, 0))).getBlock()))
            return new BlockData(pos3.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos3.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(1, 0, 0))).getBlock()))
            return new BlockData(pos3.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, 0, 1))).getBlock()))
            return new BlockData(pos3.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos3.add(0, 0, -1))).getBlock()))
            return new BlockData(pos3.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, -1, 0))).getBlock()))
            return new BlockData(pos4.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos4.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(1, 0, 0))).getBlock()))
            return new BlockData(pos4.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, 0, 1))).getBlock()))
            return new BlockData(pos4.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos4.add(0, 0, -1))).getBlock()))
            return new BlockData(pos4.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos5.add(0, -1, 0))).getBlock()))
            return new BlockData(pos5.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos5.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos5.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos5.add(1, 0, 0))).getBlock()))
            return new BlockData(pos5.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos5.add(0, 0, 1))).getBlock()))
            return new BlockData(pos5.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos5.add(0, 0, -1))).getBlock()))
            return new BlockData(pos5.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos6.add(0, -1, 0))).getBlock()))
            return new BlockData(pos6.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState((pos6.add(-1, 0, 0))).getBlock()))
            return new BlockData(pos6.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos6.add(1, 0, 0))).getBlock()))
            return new BlockData(pos6.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState((pos6.add(0, 0, 1))).getBlock()))
            return new BlockData(pos6.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos6.add(0, 0, -1))).getBlock()))
            return new BlockData(pos6.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState((pos7.add(0, -1, 0))).getBlock()))
            return new BlockData(pos7.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState(pos7.add(-1, 0, 0)).getBlock()))
            return new BlockData(pos7.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos7.add(1, 0, 0)).getBlock()))
            return new BlockData(pos7.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos7.add(0, 0, 1)).getBlock()))
            return new BlockData(pos7.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState(pos7.add(0, 0, -1)).getBlock()))
            return new BlockData(pos7.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState(pos8.add(0, -1, 0)).getBlock()))
            return new BlockData(pos8.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState(pos8.add(-1, 0, 0)).getBlock()))
            return new BlockData(pos8.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos8.add(1, 0, 0)).getBlock()))
            return new BlockData(pos8.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos8.add(0, 0, 1)).getBlock()))
            return new BlockData(pos8.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState(pos8.add(0, 0, -1)).getBlock()))
            return new BlockData(pos8.add(0, 0, -1), EnumFacing.SOUTH);
        if (!invalid.contains(mc.theWorld.getBlockState(pos9.add(0, -1, 0)).getBlock()))
            return new BlockData(pos9.add(0, -1, 0), EnumFacing.UP);
        if (!invalid.contains(mc.theWorld.getBlockState(pos9.add(-1, 0, 0)).getBlock()))
            return new BlockData(pos9.add(-1, 0, 0), EnumFacing.EAST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos9.add(1, 0, 0)).getBlock()))
            return new BlockData(pos9.add(1, 0, 0), EnumFacing.WEST);
        if (!invalid.contains(mc.theWorld.getBlockState(pos9.add(0, 0, 1)).getBlock()))
            return new BlockData(pos9.add(0, 0, 1), EnumFacing.NORTH);
        if (!invalid.contains(mc.theWorld.getBlockState(pos9.add(0, 0, -1)).getBlock()))
            return new BlockData(pos9.add(0, 0, -1), EnumFacing.SOUTH);
        return null;
    }

}
