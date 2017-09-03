package firok.mps;

import java.util.Random;

import firok.mps.common.CommonProxy;
import firok.mps.creativetab.CreativeTabsLoader;
import firok.mps.item.ItemLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MPs.MODID, name = MPs.NAME, version = MPs.VERSION, acceptedMinecraftVersions = "1.10.2")
public class MPs
{
    public static final String MODID = "mps";
    public static final String NAME = "Marvellous Plants";
    public static final String VERSION = "0.1.0";
    
    public static Random rand=new Random();

    @Instance(MPs.MODID)
    public static MPs instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
    
    @SidedProxy(
    		clientSide = "firok.mps.client.ClientProxy", 
            serverSide = "firok.mps.common.CommonProxy")
    public static CommonProxy proxy;
}