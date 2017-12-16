package firok.tic;

import java.util.Random;

import firok.tic.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TIC.MODID, name = TIC.NAME, version = TIC.VERSION, acceptedMinecraftVersions = "1.10.2")
public class TIC
{
    public static final String MODID = "tic";
    public static final String NAME = "The Irisia Continent";
    public static final String VERSION = "0.1.0";
    
    public static Random rand=new Random();

    @Instance(TIC.MODID)
    public static TIC instance;

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
    		clientSide = "firok.tic.client.ClientProxy", 
            serverSide = "firok.tic.common.CommonProxy")
    public static CommonProxy proxy;
}