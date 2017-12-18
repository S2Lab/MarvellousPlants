package firok.tic.item;

import java.util.List;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FunctionalSmokingBomb extends Item
{
	public FunctionalSmokingBomb()
	{
		super();
		this.setUnlocalizedName("smokingBomb");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		firok.tic.ability.CauseEffect.CenteredAt(EntityLivingBase.class,worldIn, pos, 4, Potion.getPotionById(15), 100, 1);
        return EnumActionResult.SUCCESS;
    }
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		firok.tic.ability.CauseEffect.CenteredAt(EntityLivingBase.class,worldIn, playerIn.getPosition(), 4, Potion.getPotionById(15), 100, 1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add("Boom!");
    }
}
