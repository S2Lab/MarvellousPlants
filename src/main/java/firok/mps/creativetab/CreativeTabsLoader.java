package firok.mps.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CreativeTabsLoader {
	public static CreativeTabs tabMPs;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	tabMPs = new CreativeTabMPs("");
    }
}
