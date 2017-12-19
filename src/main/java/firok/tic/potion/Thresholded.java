package firok.tic.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class Thresholded extends Potion
{
	// 阈化 debuff
	// 超过一定攻击力的攻击会失效
	

	public Thresholded()
	{
		// 不是负面效果  红紫色
		super(false, 0xA64D79);
        this.setPotionName("potion.thresholded");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
    {
		return false;
		/*
		int k = 40 >> amplifier;
        return k > 0 ? duration % k == 0 : true;
        */
    }
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		;
    }
}