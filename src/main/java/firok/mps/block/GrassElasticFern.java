package firok.mps.block;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import firok.mps.ability.CauseMotion;

public class GrassElasticFern extends BlockGrass
{
	// 弹力蕨
	// 把实体弹开
	public GrassElasticFern()
	{
		super();
		this.setUnlocalizedName("elasticFern");
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		pushEntity(entityIn,pos);
    }
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		pushEntity(entityIn,pos);
    }
	
	protected void pushEntity(Entity entityIn,BlockPos centerIn)
	{
		double entityX=entityIn.posX, entityZ=entityIn.posZ;
		double blockX=centerIn.getX() ,blockZ=centerIn.getZ();
		float motionX,motionZ;
		
		if(entityX>blockX)
			motionX=2;
		else if(entityX<blockX)
			motionX=-2;
		else
			motionX=0;
		
		if(entityZ>blockZ)
			motionZ=2;
		else if(entityZ<blockZ)
			motionZ=-2;
		else
			motionZ=0;
		
		CauseMotion.excute(entityIn, motionX, 0F, motionZ);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		System.out.print("updated");
        for(Entity entity:worldIn.getEntitiesWithinAABB(Entity.class,new AxisAlignedBB(pos.getX()-1, pos.getY(), pos.getZ()-1,pos.getX()+1, pos.getY(), pos.getZ()+1) ))
        {
        	pushEntity(entity,pos);
        }
    }
}
