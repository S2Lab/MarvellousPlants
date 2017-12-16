package firok.tic.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class Painbound extends Potion{
	public Painbound()
	{
		// 是负面效果  深红色
		super(true, 0x360900);
        this.setPotionName("potion.painbound");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
    {
		return true;
    }
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		// System.out.println("potion effected and data=="+entityLivingBaseIn.getEntityData().getLong("time_last_attack"));
    }
}
