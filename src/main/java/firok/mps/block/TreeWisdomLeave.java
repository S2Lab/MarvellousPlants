package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

// 智者树叶
public class TreeWisdomLeave extends Block
{
	public TreeWisdomLeave()
	{
		super(Material.LEAVES);
		this.setUnlocalizedName("wisdomLeave");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}
