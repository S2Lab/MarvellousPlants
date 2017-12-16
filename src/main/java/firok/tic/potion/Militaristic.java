package firok.tic.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class Militaristic extends Potion
{
	// 穷兵黩武 debuff // 英文原义:军国主义
	// 持续时间内不攻击别的生物就会掉血
	

	public Militaristic()
	{
		// 是负面效果  暗红
		super(true, 0x60000);
        this.setPotionName("potion.militaristic");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
    {
		
		int k = 80 >> amplifier;
        return k > 0 ? duration % k == 0 : true;
    }
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		// System.out.println("potion effected and data=="+entityLivingBaseIn.getEntityData().getLong("time_last_attack"));
    }
}