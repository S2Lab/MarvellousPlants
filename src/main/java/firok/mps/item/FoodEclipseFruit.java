package firok.mps.item;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;

public class FoodEclipseFruit extends ItemFood
{
	// 黯淡果实
	// 2饱和 2饥饿 非狼食物
	public FoodEclipseFruit()
	{
		super(2,2,false);
		// 食用之后附加隐身效果
		// this.setPotionEffect(new PotionEffect(Potion.getPotionById(14),1600,1)_);
	}
}
