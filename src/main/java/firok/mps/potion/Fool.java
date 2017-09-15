package firok.mps.potion;

import firok.mps.MPs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Fool extends Potion
{
	// 愚者 buff
	// 获得的xp几率降低 受到的伤害几率减少
	// 与智者debuff冲突
	
	

	public Fool()
	{
		// 不是负面效果  绿黄色
		super(false, 0xADFF2F);
        this.setPotionName("potion.fool");
		this.setIconIndex(0, 0);
	}
	
	public boolean isReady(int duration, int amplifier)
    {
		int k = 40 >> amplifier;
        return k > 0 ? duration % k == 0 : true;
    }
	
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		if(entityLivingBaseIn instanceof EntityPlayer)
		{
			int amountXP=entityLivingBaseIn.getEntityWorld().rand.nextInt(3*p_76394_2_>1?p_76394_2_:1);
			((EntityPlayer) entityLivingBaseIn).addExperience(amountXP*-1);
		}
    }
}
