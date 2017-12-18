package firok.tic.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader
{
	// static 非本地化名称= new 类名
    // public static Item itemRecipe=new ItemRecipe();
	public static Item functionalRandomTicker=new FunctionalRandomTicker();
	public static Item functionalUpdateTicker=new FunctionalUpdateTicker();
	
	public static Item functionalSummonner=new FunctionalSummonner();
	public static Item functionalSmokingBomb=new FunctionalSmokingBomb();
	
	public static Item materialRichChargePetal=new MaterialRichChargePetal();
	

    public ItemLoader(FMLPreInitializationEvent event)
    {
    	// 注册的时候 使用静态成员+物品id
        // register(tokenMoneyLow, "token_money_low");
        // register(itemRecipe,"recipe");
        register(functionalRandomTicker,"functional_random_ticker");
        register(functionalUpdateTicker,"functional_update_ticker");
        
        register(functionalSummonner,"functional_summonner");
        register(functionalSmokingBomb,"functional_smoking_bomb");
        
        register(materialRichChargePetal,"material_rich_charge_petal");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	// registerRender(tokenMoneyLow);
    	// registerRender(itemRecipe);
    	registerRender(functionalRandomTicker);
    	registerRender(functionalUpdateTicker);
    	
    	registerRender(functionalSummonner);
    	
    	registerRender(materialRichChargePetal);
    	
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item.setRegistryName(name));
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
