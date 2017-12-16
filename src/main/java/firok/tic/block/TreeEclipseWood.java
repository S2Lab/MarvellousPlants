package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TreeEclipseWood extends Block
{
	// 黯淡木
	public TreeEclipseWood()
	{
		super(Material.WOOD);
		this.setUnlocalizedName("eclipseWood");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}

}
