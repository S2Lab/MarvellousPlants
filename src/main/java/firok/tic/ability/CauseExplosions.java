package firok.tic.ability;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseExplosions {
	// 在一个位置创建一个爆炸 伴随数个小爆炸
	// (都是一瞬间)
	public static void CenteredAt(World worldIn,BlockPos posIn,float powerIn)
	{
		;
	}
	
	public static void CenterAt(World worldIn,Entity entityIn,float powerIn)
	{
		CenteredAt(worldIn,entityIn.getPosition(),powerIn);
	}
}
