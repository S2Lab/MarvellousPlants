package firok.mps.inventory;

import firok.mps.MPs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiElementLoader implements IGuiHandler {
	// public static final int GUI_CRAFTING_BENCH=1; // 合成台
	// public static final int GUI_RECIPE_BENCH=2; // 卷轴制作台
	
	public GuiElementLoader()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(MPs.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	@Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		return null;
    }
}
