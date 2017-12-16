package firok.tic.item;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

public class MaterialRichChargePetal extends Item
{
	// 富电荷花瓣
	// 用来合成富电荷液
	public MaterialRichChargePetal()
	{
		super();
		this.setUnlocalizedName("materialChargePetal");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
}
