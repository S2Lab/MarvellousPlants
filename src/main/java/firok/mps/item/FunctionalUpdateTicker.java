package firok.mps.item;

import java.util.List;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FunctionalUpdateTicker extends Item
{
	public FunctionalUpdateTicker()
	{
		super();
		this.setUnlocalizedName("updateTicker");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		worldIn.getBlockState(pos).getBlock().updateTick(worldIn, pos, worldIn.getBlockState(pos), worldIn.rand);
        return EnumActionResult.SUCCESS;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add("Triger the updateTick() of the block you clicked with this");
		tooltip.add("Creative Only");
    }
}
