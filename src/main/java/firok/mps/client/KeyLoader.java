package firok.mps.client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyLoader {
	public static KeyBinding showTime;
	
	public KeyLoader()
	{
		KeyLoader.showTime = new KeyBinding("key.mps.showTime", Keyboard.KEY_1, "key.categories.cota");

        ClientRegistry.registerKeyBinding(KeyLoader.showTime);
	}

}
