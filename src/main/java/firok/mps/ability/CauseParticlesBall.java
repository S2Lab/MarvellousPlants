package firok.mps.ability;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseParticlesBall {
	public static void CenteredAt(World worldIn,BlockPos posIn,float radiusIn,Particle particleIn,float dencityIn)
	{
		return;
	}
	
	public static void CenteredAt(World worldIn,Entity entityIn,float radiusIn,Particle particleIn,float dencityIn)
	{
		CenteredAt(worldIn,entityIn.getPosition(),radiusIn,particleIn,dencityIn);
	}
}
