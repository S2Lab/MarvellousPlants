package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TreeIronyWoodLeave extends Block
{
	// 铁质木树叶
	public TreeIronyWoodLeave()
	{
		super(Material.LEAVES);
		this.setUnlocalizedName("ironyWoodLeave");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}
