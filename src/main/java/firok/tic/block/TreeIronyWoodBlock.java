package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TreeIronyWoodBlock extends Block
{
	// 铁质木方块
	public TreeIronyWoodBlock()
	{
		super(Material.IRON);
		this.setUnlocalizedName("ironyWoodBlock");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
}
