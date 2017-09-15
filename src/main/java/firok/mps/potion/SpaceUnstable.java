package firok.mps.potion;

import java.util.Random;

import firok.mps.BugNeedToFix;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

public class SpaceUnstable extends Potion
{
	// 空间不稳定 debuff
	// 随机传送
	
	
	public SpaceUnstable()
	{
		// 是负面效果  适中的兰花紫
		super(true, 0xBA55D3);
        this.setPotionName("potion.space_unstable");
		this.setIconIndex(0, 0);
	}
	
	public boolean isReady(int duration, int amplifier)
    {
		int k = 80 >> amplifier;
        return k > 0 ? duration % k == 0 : true;
    }
	@BugNeedToFix
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		teleportRandomly(entityLivingBaseIn,p_76394_2_);
    }
	// just like EnderMan // 跟末影人的一样
	protected void teleportRandomly(Entity entityIn,int levelIn)
    {
		Random rand=entityIn.getEntityWorld().rand;
		double x=entityIn.getPosition().getX() + (rand.nextDouble() - 0.5D) * 4.0D * levelIn >0 ?levelIn:1 * (rand.nextBoolean()?+1:-1);
		double y=entityIn.getPosition().getY() + (double)(rand.nextInt(4) - 2);
		double z=entityIn.getPosition().getZ() + (rand.nextDouble() - 0.5D) * 4.0D * levelIn >0 ?levelIn:1 * (rand.nextBoolean()?+1:-1);
		entityIn.setPosition(x,y>=5?y:5,z);
    }
}
