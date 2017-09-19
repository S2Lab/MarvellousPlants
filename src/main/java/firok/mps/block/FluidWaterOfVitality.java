package firok.mps.block;

import firok.mps.ability.CauseSummon;
import firok.mps.creativetab.CreativeTabsLoader;
import firok.mps.fluid.FluidLoader;
import firok.mps.fluid.WaterOfVitality;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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
        this.setCreativeTab(CreativeTabsLoader.tabMPs);
    }
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(entityIn instanceof EntityItem)
		{
			Item item=((EntityItem)entityIn).getEntityItem().getItem();
			if(WaterOfVitality.hasSummon(item))
			{
				((EntityItem) entityIn).getEntityItem().stackSize--;
				CauseSummon.CenteredAt(worldIn,(double)pos.getX(),(double)pos.getY()+1,(double)pos.getZ(),WaterOfVitality.getSummon(item));
			}
		}
    }
}