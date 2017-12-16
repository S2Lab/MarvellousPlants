package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

// 黯淡树叶
public class TreeEclipseLeave extends Block
{
	public TreeEclipseLeave()
	{
		super(Material.LEAVES);
		this.setUnlocalizedName("eclipseLeave");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
}
