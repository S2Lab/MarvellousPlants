package firok.tic.potion;

import java.util.LinkedList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class Lifecursed extends Potion
{

	// 生命诅咒
	// 无法恢复生命
	
	public Lifecursed()
	{
		// 是负面效果  深紫红色
		super(true, 0x4C1130);
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
