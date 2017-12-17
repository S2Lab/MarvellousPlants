package firok.tic.potion;

import java.util.LinkedList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class Lifeblessed extends Potion
{

	// 生命祝福
	// 收到的治疗效果变成双倍
	
	public Lifeblessed()
	{
		// 不是负面效果  粉红色
		super(false, 0xFF00CC);
        this.setPotionName("potion.lifecurse");
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
		;
    }
}
