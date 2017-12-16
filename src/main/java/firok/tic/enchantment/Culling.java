package firok.tic.enchantment;

import firok.tic.TIC;
import firok.tic.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Culling extends Enchantment{
	// 淘汰
	// 直接秒杀血量低于10%的生物
	// 并且给玩家一个10秒速度1buff 连续击杀会延长时间
	
	public Culling()
    {
		super(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        
        this.setName("culling");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench)
    {
    	int id_in=Enchantment.getEnchantmentID(ench);
        return super.canApplyTogether(ench)
        		&& id_in != Enchantment.getEnchantmentID(Enchantments.POWER)
        		;
    }

    @Override
    public boolean canApply(ItemStack stack)
    {
        return /*stack.getItem() == Items. ? true : */ super.canApply(stack);
    }

}
