package firok.tic.item;

import java.util.List;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialMagicCrystal extends Item
{
	// 魔晶
	public MaterialMagicCrystal()
	{
		super();
		this.setUnlocalizedName("randomMagicCrystal");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
	// 魔晶种类与meta
	/*
	0	空晶石
	1	火魔晶
	2	水魔晶
	3	地魔晶
	4	风魔晶
	5	冰魔晶
	6	雷魔晶
	7	光魔晶	未决定
	8	暗魔晶	未决定
	10	时间魔晶
	11	空间魔晶
	12	生命魔晶
	13	精神魔晶
	14	混沌魔晶
	15	虚无魔晶
	*/
	// 能量水平
	/*
	0~1000
	*//*
	@Override
	@SideOnly(Side.CLIENT) // 这个标签以后可能去掉
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		NBTTagCompound nbt=stack.getTagCompound();
		if(nbt.hasKey("type"))
		{
			;
		}
		return EnumActionResult.SUCCESS; 
    }*/
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add("Magic Crystal is a kind of useful material.");
    }
}
