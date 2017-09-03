package firok.mps.creativetab;
import firok.mps.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class CreativeTabMPs extends CreativeTabs {
	public CreativeTabMPs(String label)
	{
		super(label==""?"mps":label);
	}

    @Override
    public Item getTabIconItem()
    {
        // return ItemLoader.tokenMoneyHigh;
    	return Items.BOOK;
    }
    @Override
    public boolean hasSearchBar()
    {
    	return true;
    }
}
