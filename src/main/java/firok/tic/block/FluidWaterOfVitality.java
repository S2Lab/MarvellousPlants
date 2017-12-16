package firok.tic.block;

import firok.tic.ability.CauseSummon;
import firok.tic.creativetab.CreativeTabsLoader;
import firok.tic.fluid.FluidLoader;
import firok.tic.fluid.WaterOfVitality;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class FluidWaterOfVitality extends BlockFluidClassic
{
	public FluidWaterOfVitality()
    {
        super(FluidLoader.waterOfVitality, Material.WATER);
        this.setUnlocalizedName("fluidWaterOfVitality");
        this.setCreativeTab(CreativeTabsLoader.tabTIC);
    }
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(entityIn instanceof EntityItem)
		{
			Item item=((EntityItem)entityIn).getEntityItem().getItem();
			if(WaterOfVitality.hasSummon(item))
			{
				((EntityItem) entityIn).getEntityItem().stackSize--;
				CauseSummon.CenteredAt(worldIn,pos.getX(),(double)pos.getY()+1,pos.getZ(),WaterOfVitality.getSummon(item));
			}
		}
    }
}