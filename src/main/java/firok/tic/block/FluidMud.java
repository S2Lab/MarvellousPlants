package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import firok.tic.fluid.FluidLoader;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;


public class FluidMud extends BlockFluidClassic
{
	public FluidMud()
    {
        super(FluidLoader.mud, Material.WATER);
        this.setUnlocalizedName("fluidMud");
        this.setCreativeTab(CreativeTabsLoader.tabTIC);
    }
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(entityIn instanceof EntityPlayer && ((EntityPlayer) entityIn).isCreative())
			return;
		else
		{
			entityIn.motionX *= 0.05D;
	        entityIn.motionZ *= 0.05D;
	        entityIn.motionY*=0.01D;
		}
    }
}
