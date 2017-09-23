package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FlowerWoodenRootBlock extends Block
{
	public FlowerWoodenRootBlock()
	{
		super(Material.WOOD);
		this.setUnlocalizedName("woodenRootBlock");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}
