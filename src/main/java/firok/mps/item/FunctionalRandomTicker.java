package firok.mps.item;

import java.util.List;

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

public class FunctionalRandomTicker extends Item
{
	public FunctionalRandomTicker()
	{
		super();
		this.setUnlocalizedName("randomTicker");
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		worldIn.getBlockState(pos).getBlock().randomTick(worldIn, pos, worldIn.getBlockState(pos), worldIn.rand);
        return EnumActionResult.SUCCESS;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add("Triger the randomTick() of the block you clicked with this");
		tooltip.add("Creative Only");
    }
}
