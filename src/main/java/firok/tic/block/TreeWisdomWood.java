package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TreeWisdomWood extends Block
{
	// 智者之树
	public TreeWisdomWood()
	{
		super(Material.WOOD);
		this.setUnlocalizedName("wisdomWood");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}

}
