package firok.tic.enchantment;

import firok.tic.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.util.ResourceLocation;

public class EnchantmentLoader {
	public static Enchantment culling;
	public static Enchantment tearing;

    public EnchantmentLoader()
    {
        culling=new Culling();
        tearing=new Tearing();
        
        register(ConfigLoader.idEnchantmentCulling,culling,"culling");
        register(ConfigLoader.idEnchantmentTearing,tearing,"tearing");
    }
    
    public static void register(int idIn,Enchantment enchIn,String nameIn)
    {
    	try
        {
            Enchantment.REGISTRY.register(idIn, new ResourceLocation(firok.tic.TIC.MODID+":"+nameIn), enchIn);
        }
        catch (Exception e)
        {
            ConfigLoader.logger().error(
                    "Duplicate or illegal enchantment id: {}, the registry of class '{}' will be skipped. ",
                    idIn, enchIn.getClass().getName());
        }
    }

}
