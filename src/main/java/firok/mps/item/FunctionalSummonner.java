package firok.mps.item;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import firok.mps.ability.*;
import firok.mps.creativetab.CreativeTabsLoader;

public class FunctionalSummonner extends Item
{
	public FunctionalSummonner()
	{
		super();
		this.setUnlocalizedName("summonner");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
		this.setMaxStackSize(1);
	}
	
	// 以后改实体类型
	@Override
	@SideOnly(Side.CLIENT)
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		CauseSummon.CenteredAt(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, EntitySkeleton.class);

        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
