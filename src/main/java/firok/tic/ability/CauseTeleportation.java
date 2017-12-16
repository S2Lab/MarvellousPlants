package firok.tic.ability;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseTeleportation {
	// 随机传送
	public static void teleportEntityRandomly(Entity entityIn,BlockPos centerIn,int teleportHorizontalRange)
	{
		World world=entityIn.getEntityWorld();
		Random rand=world.rand;
		int x=centerIn.getX()-teleportHorizontalRange+rand.nextInt(2*teleportHorizontalRange);
		int z=centerIn.getZ()-teleportHorizontalRange+rand.nextInt(2*teleportHorizontalRange);
		// 找到传送范围内的一个位置最顶端的方块
		BlockPos topPos=world.getTopSolidOrLiquidBlock(new BlockPos(x,centerIn.getY(),z));
		// 传送实体
		entityIn.setPosition(topPos.getX(), topPos.getY()+2, topPos.getZ());
	}
}
