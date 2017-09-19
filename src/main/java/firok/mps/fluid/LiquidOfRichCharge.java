package firok.mps.fluid;

import java.util.HashMap;

import firok.mps.MPs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class LiquidOfRichCharge extends Fluid
{
	public static final ResourceLocation still = new ResourceLocation(MPs.MODID + ":" + "fluid/liquid_of_rich_charge_still");
    public static final ResourceLocation flowing = new ResourceLocation(MPs.MODID + ":" + "fluid/liquid_of_rich_charge_flow");
    
	public LiquidOfRichCharge()
	{
		super("mud", Mud.still, Mud.flowing);
    	this.setDensity(1000); // 密度1倍于水
    	this.setViscosity(500); // 粘度0.5倍于水
    	this.setLuminosity(2); // 亮度4
    	this.setTemperature(600); // 水温2倍于水
    	this.setGaseous(false); // 不是气体
	}
}
