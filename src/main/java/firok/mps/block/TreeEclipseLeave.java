package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

// 黯淡树叶
public class TreeEclipseLeave extends Block
{
	public TreeEclipseLeave()
	{
		super(Material.LEAVES);
		this.setUnlocalizedName("eclipseLeave");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}
