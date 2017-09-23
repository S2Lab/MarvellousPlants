package firok.mps.potion;

import firok.mps.MPs;
import firok.mps.common.ConfigLoader;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PotionLoader
{
	
	public static final ResourceLocation res = new ResourceLocation(MPs.MODID + ":" + "textures/gui/potion.png");
	
	
    // public static Potion potionFallProtection;
	
	public static Potion wise			=new Wise();
	public static Potion folly			=new Folly();
	public static Potion spaceUnstable	=new SpaceUnstable();

    public PotionLoader(FMLPreInitializationEvent event)
    {
        // potionFallProtection = new PotionFallProtection();
    	registerPotion(ConfigLoader.idPotionWise,"wise",wise);
    	registerPotion(ConfigLoader.idPotionFool,"folly",folly);
    	registerPotion(ConfigLoader.idPotionSpaceUnstable,"space_unstable",spaceUnstable);
    }
    
    private void registerPotion(int potionIdIn,String potionNameIn,Potion potionIn)
    {
    	// Potion.REGISTRY.register(1, new ResourceLocation("speed"), (new Potion(false, 8171462)).setPotionName("effect.moveSpeed").setIconIndex(0, 0).registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2).setBeneficial());
    	Potion.REGISTRY.register(potionIdIn,new ResourceLocation(MPs.MODID+":"+potionNameIn), potionIn);
    }
}
