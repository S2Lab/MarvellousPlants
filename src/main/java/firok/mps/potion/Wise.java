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

public class Wise extends Potion
{
	// 智者 buff
	// 获得的xp几率倍增 受到的伤害几率增加
	// 与愚者debuff冲突
	
	

	public Wise()
	{
		// 不是负面效果  矢车菊的蓝色
		super(false, 0x6495ED);
        this.setPotionName("potion.wise");
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
			int amountXP=entityLivingBaseIn.getEntityWorld().rand.nextInt(3*p_76394_2_>0?p_76394_2_:1);
			((EntityPlayer) entityLivingBaseIn).addExperience(amountXP);
		}
    }
}
