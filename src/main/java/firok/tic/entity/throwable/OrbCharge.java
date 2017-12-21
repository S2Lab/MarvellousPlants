package firok.tic.entity.throwable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class OrbCharge extends EntityThrowable
{
	public OrbCharge(World worldIn)
    {
        super(worldIn);
    }

    public OrbCharge(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public OrbCharge(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult traceIn)
    {
    	this.onKillCommand();
    	BlockPos pos=traceIn.getBlockPos();
    	World world=this.getEntityWorld();

    	
    	if(pos==null)
    		pos=traceIn.entityHit.getPosition();
    	
    	
    	if(pos==null || world==null)
    		return;
    	
    	for (EntityLivingBase living:world.getEntitiesWithinAABB(
    			EntityLivingBase.class,
    			new AxisAlignedBB(
    					pos.getX()-3,
    					pos.getY()-3,
    					pos.getZ()-3,
    					pos.getX()+3,
    					pos.getY()+3,
    					pos.getZ()+3)))
    	{
    		living.attackEntityFrom(DamageSource.lightningBolt, 3.0F);
    	}
    	
    	world.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
    }
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	// 电荷球不能高于高度500
    	if(this.posY>500)
    		this.onKillCommand();
    }
    
    // 不受重力影响
    protected float getGravityVelocity()
    {
        return 0.00F;
    }
}
