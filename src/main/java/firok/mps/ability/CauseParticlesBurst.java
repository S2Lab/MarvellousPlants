package firok.mps.ability;

import java.util.Random;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseParticlesBurst {
	// 粒子是随机方向的
	// 数量 速度
	public static void CenteredAt(World worldIn,BlockPos posIn,float radiusIn,Particle particleIn,int amount,float speed)
	{
		// worldIn.spawnParticle(particleIn, radiusIn, posIn.getX(), posIn.getY(), posIn.getZ(), xSpeed, ySpeed, zSpeed);
	}
	public static void CenteredAt(World worldIn,Entity entityIn,float radiusIn,Particle particleIn,int amount,float speed)
	{
		CenteredAt(worldIn,entityIn.getPosition(),radiusIn,particleIn,amount,speed);
	}
}
