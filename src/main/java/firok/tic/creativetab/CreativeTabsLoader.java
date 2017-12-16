package firok.tic.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CreativeTabsLoader {
	public static CreativeTabs tabTIC;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	tabTIC = new CreativeTabTIC("");
    }
}
