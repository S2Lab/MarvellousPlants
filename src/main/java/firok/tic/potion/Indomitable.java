package firok.tic.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class Indomitable extends Potion
{
	// 不屈 buff
	// 血量不会低于2+等级*2.5
	

	public Indomitable()
	{
		// 不是负面效果  红粉色
		super(false, 0xE06666);
        this.setPotionName("potion.indomitable");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
    {
		return true;
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