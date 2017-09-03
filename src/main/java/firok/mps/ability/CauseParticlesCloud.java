package firok.mps.ability;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseParticlesCloud {
	public static void CenteredAt(World worldIn,BlockPos posIn,Particle particleIn,float dencityIn,float xSpeed,float ySpeed,float zSpeed)
	{
		return;
	}
	public static void CenteredAt(World worldIn,Entity entityIn,Particle particleIn,float dencityIn,float xSpeed,float ySpeed,float zSpeed)
	{
		CenteredAt(worldIn,entityIn.getPosition(),particleIn,dencityIn,xSpeed,ySpeed,zSpeed);
	}
}
