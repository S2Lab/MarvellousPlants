package firok.tic.common;

import firok.tic.block.BlockLoader;
import firok.tic.crafting.CraftingLoader;
import firok.tic.creativetab.CreativeTabsLoader;
import firok.tic.enchantment.EnchantmentLoader;
import firok.tic.entity.EntityLoader;
import firok.tic.fluid.FluidLoader;
import firok.tic.inventory.GuiElementLoader;
import firok.tic.item.ItemLoader;
import firok.tic.potion.PotionLoader;
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

    	new EnchantmentLoader();
    	
    	new EventLoader();
    	
    	// new WorldGeneratorLoader();
    	
    	new GuiElementLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}