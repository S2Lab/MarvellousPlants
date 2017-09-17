package firok.mps.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
    // public static Block grassBlock = new BlockGrassBlock();
	// 功能性方块
	
	// 蘑菇
	public static Block mushroomEnderMushroom=new MushroomEnderMushroom();
	public static Block decorationEnderBlock=new DecorationEnderBlock();
	
	// 草 蕨
	public static Block grassElasticFern=new GrassElasticFern();
	
	// 花
	public static Block flowerCorrosiveFlower=new FlowerCorrosiveFlower();
	
	public static Block flowerToxicFlower=new FlowerToxicFlower();
	
	public static Block flowerWoodenRootFlower=new FlowerWoodenRootFlower();
	public static Block flowerWoodenRootBlock=new FlowerWoodenRootBlock();
	
	public static Block flowerWisdomFlower=new FlowerWisdomFlower();
	
	public static Block flowerFrostyLotus=new FlowerFrostyLotus();
	
	public static Block flowerEmberDaisy=new FlowerEmberDaisy();
	
	// 树
	public static Block treeIronyWoodBlock=new TreeIronyWoodBlock();
	public static Block treeIronyWoodLeave=new TreeIronyWoodLeave();
	
	public static Block treeTreeWisdomWood=new TreeWisdomWood();
	public static Block treeTreeWisdomLeave=new TreeWisdomLeave();
	
	// 装饰性方块
	public static Block decorationCorrosedBlock=new DecorationCorrosedBlock();
	
	public static Block fluidMud=new FluidMud();
	
	// 实验性方块
	public static Block blockSmokerBlock=new BlockSmokerBlock();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        // register(grassBlock, "grass_block");
    	register(mushroomEnderMushroom,"mushroom_ender_mushroom");
    	register(decorationEnderBlock,"decoration_ender_block");
    	
    	
    	register(grassElasticFern,"grass_elastic_fern");
    	
    	
    	register(flowerCorrosiveFlower,"flower_corrosive_flower");
    	
    	register(flowerToxicFlower,"flower_toxic_flower");
    	
    	register(flowerWoodenRootFlower,"flower_wooden_root_flower");
    	register(flowerWoodenRootBlock,"flower_wooden_root_block");
    	
    	register(flowerWisdomFlower,"flower_wiser_flower");
    	
    	register(flowerFrostyLotus,"flower_frosty_lotus");
    	
    	register(flowerEmberDaisy,"flower_ember_daisy");
    	
    	
    	register(treeIronyWoodBlock,"tree_irony_wood_block");
    	register(treeIronyWoodLeave,"tree_irony_wood_leave");
    	
    	register(treeTreeWisdomWood,"tree_wisdom_wood");
    	register(treeTreeWisdomLeave,"tree_wisdom_leave");
        
        register(decorationCorrosedBlock,"decoration_corrosed_block");
        
        register(fluidMud,"fluid_mud");
        
        register(blockSmokerBlock,"exp_smoker_block");
    }
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        // registerRender(craftingBench);
    	registerRender(mushroomEnderMushroom);
    	registerRender(decorationEnderBlock);
    	
    	
    	registerRender(grassElasticFern);
    	
    	
        registerRender(flowerCorrosiveFlower);
        
        registerRender(flowerToxicFlower);
        
        registerRender(flowerWoodenRootFlower);
        registerRender(flowerWoodenRootBlock);
        
        registerRender(flowerWisdomFlower);
        
        registerRender(flowerFrostyLotus);
        
        registerRender(flowerEmberDaisy);
        
        registerRender(decorationCorrosedBlock);
        
        registerRender(blockSmokerBlock);
    }
    

    private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block.setRegistryName(name));
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block)
    {
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }
}