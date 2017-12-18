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
        
        register(ConfigLoader.idEnchantmentCulling,culling,new ResourceLocation("culling"));
        register(ConfigLoader.idEnchantmentTearing,tearing,new ResourceLocation("tearing"));
    }
    
    public static void register(int idIn,Enchantment enchIn,ResourceLocation reIn)
    {
    	try
        {
            Enchantment.REGISTRY.register(idIn, reIn, enchIn);
        }
        catch (Exception e)
        {
            ConfigLoader.logger().error(
                    "Duplicate or illegal enchantment id: {}, the registry of class '{}' will be skipped. ",
                    idIn, enchIn.getClass().getName());
        }
    }

}
