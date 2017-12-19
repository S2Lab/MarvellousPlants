package firok.tic.potion;

import java.util.LinkedList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class Teared extends Potion
{
	// 被撕裂 debuff
	// 受到的伤害加深debuff等级*30%
	
	public Teared()
	{
		// 是负面效果 暗血红色
		super(true, 0x610C0C);
        this.setPotionName("potion.teared");
		this.setIconIndex(0, 0);
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
    {
		return false;
    }
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
    {
        // p_76394_2_ == 效果等级
		;
    }
}