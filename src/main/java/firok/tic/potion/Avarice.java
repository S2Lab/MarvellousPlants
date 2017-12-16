package firok.tic.potion;

import java.util.LinkedList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class Avarice extends Potion
{
	// 贪婪 debuff
	// 背包里没有指定物品就会减血
	

	public Avarice()
	{
		// 是负面效果  淡黄色
		super(true, 0xFFE599);
        this.setPotionName("potion.avarice");
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
		if(entityLivingBaseIn instanceof EntityPlayer)
		{
			EntityPlayer player=(EntityPlayer)entityLivingBaseIn;
			
			if(player.isCreative()) // 创造模式直接返回 不执行效果
				return;
			
			int size=player.inventory.getSizeInventory();
			for(int step=0;step<size;step++)
			{
				ItemStack itemstack=player.inventory.getStackInSlot(step);
				if(itemstack!=null && itemstack.getItem()!=null && isExpensive(itemstack.getItem()))
				{
					return; // 找到贵重物品 返回
				}
			}
			
			player.attackEntityFrom(new firok.tic.DamageSources.AvariceDamege(), (float) (2+p_76394_2_*2.5));
		}
    }
	
	protected static LinkedList<Item> listExpensiveItem=new LinkedList<Item>();
	static
	{
		listExpensiveItem.add(Items.DIAMOND);
		listExpensiveItem.add(Items.GOLD_INGOT);
		listExpensiveItem.add(Items.GOLD_NUGGET);
		listExpensiveItem.add(Items.GOLDEN_APPLE);
		
	}
	public static boolean isExpensive(Item itemIn)
	{
		return listExpensiveItem.contains(itemIn);
	}
}