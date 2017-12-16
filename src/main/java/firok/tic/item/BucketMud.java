package firok.tic.item;

import firok.tic.block.BlockLoader;
import firok.tic.creativetab.CreativeTabsLoader;
import firok.tic.fluid.FluidLoader;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class BucketMud extends ItemBucket
{
	public BucketMud()
    {
        super(BlockLoader.fluidMud);
        this.setContainerItem(Items.BUCKET);
        this.setUnlocalizedName("bucketMud");
        this.setCreativeTab(CreativeTabsLoader.tabTIC);
        FluidContainerRegistry.registerFluidContainer(FluidLoader.getFluid(FluidLoader.mud), new ItemStack(this),
                FluidContainerRegistry.EMPTY_BUCKET);
    }
}
