package firok.tic.block;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

// 智者树叶
public class TreeWisdomLeave extends Block
{
	public TreeWisdomLeave()
	{
		super(Material.LEAVES);
		this.setUnlocalizedName("wisdomLeave");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
}
