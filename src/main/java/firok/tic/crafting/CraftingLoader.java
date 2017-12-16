package firok.tic.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
    	/*
    	GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.goldenEgg), new Object[]
    			{
    					"###", "#*#", "###", '#', Items.gold_ingot, '*', Items.egg
    			});
    	GameRegistry.addShapelessRecipe(new ItemStack(), BlockLoader.grassBlock)
    	*/
    }

    private static void registerSmelting()
    {

    }

    private static void registerFuel()
    {
        GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                // return ItemLoader.itemVillagersCharcoal != fuel.getItem() ? 0 : 1200;
            	return 1;
            }
        });
    }
}
