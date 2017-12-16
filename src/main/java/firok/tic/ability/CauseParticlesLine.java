package firok.tic.ability;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauseParticlesLine
{
	public static void FromTo(World worldIn,BlockPos pos1,BlockPos pos2,Particle particleIn,float density)
	{
		;
	}
	
	public static void FromTo(World worldIn,Entity ent1,Entity ent2,Particle particleIn,float density)
	{
		FromTo(worldIn,ent1.getPosition(),ent2.getPosition(),particleIn,density);
	}
}
