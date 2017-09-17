package firok.mps.common;

import firok.mps.block.BlockLoader;
import firok.mps.crafting.CraftingLoader;
import firok.mps.creativetab.CreativeTabsLoader;
import firok.mps.entity.EntityLoader;
import firok.mps.fluid.FluidLoader;
import firok.mps.inventory.GuiElementLoader;
import firok.mps.item.ItemLoader;
import firok.mps.potion.PotionLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new ConfigLoader(event);
    	new CreativeTabsLoader(event);
    	new ItemLoader(event);
    	new FluidLoader(event);
    	new BlockLoader(event);
    	new PotionLoader(event);
    	
    	
    	
        new EntityLoader();
    }

    public void init(FMLInitializationEvent event)
    {
    	new CraftingLoader();
    	// new Recipes();
    	new EventLoader();
    	
    	// new WorldGeneratorLoader();
    	
    	new GuiElementLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}