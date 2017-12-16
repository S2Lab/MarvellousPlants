package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSmokerBlock extends Block
{
	public BlockSmokerBlock()
	{
		super(Material.GROUND);
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
}
