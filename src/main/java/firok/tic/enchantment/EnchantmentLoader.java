package firok.tic.enchantment;

import firok.tic.common.ConfigLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.util.ResourceLocation;

public class EnchantmentLoader {
	public static Enchantment culling;

    public EnchantmentLoader()
    {
        try
        {
            culling = new Culling();
            /*
            {
            	for(ResourceLocation rel : Enchantment.REGISTRY.getKeys())
            	{
            		Enchantment enc=Enchantment.REGISTRY.getObject(rel);
            		System.out.println("enc.getName()=="+enc.getName()+" : "+Enchantment.getEnchantmentID(enc));
            	}
            }*/
            Enchantment.REGISTRY.register(ConfigLoader.idEnchantmentCulling, new ResourceLocation("culling"), culling);
        }
        catch (Exception e)
        {
            ConfigLoader.logger().error(
                    "Duplicate or illegal enchantment id: {}, the registry of class '{}' will be skipped. ",
                    ConfigLoader.idEnchantmentCulling, Culling.class.getName());
        }
    }

}
