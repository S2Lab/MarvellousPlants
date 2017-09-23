package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockBush;

public class FlowerEmberDaisy extends BlockBush
{
	// 燃烬菊
	// 出产烟火之星
	public FlowerEmberDaisy()
	{
		super();
		this.setUnlocalizedName("emberDaisy");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}