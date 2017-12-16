package firok.tic.creativetab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class CreativeTabTIC extends CreativeTabs {
	public CreativeTabTIC(String label)
	{
		super(label==""?"tic":label);
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
