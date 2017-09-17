package firok.mps.fluid;

import java.util.LinkedList;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FluidLoader
{
	public static LinkedList<Fluid> fluids;
	
	public static Fluid mud=new Mud();
	
	public FluidLoader(FMLPreInitializationEvent event)
	{
		if(fluids==null)
			fluids=new LinkedList<Fluid>();
		
		registerFluid(event,mud);
	}
	
	protected void registerFluid(FMLPreInitializationEvent event,Fluid fluidIn)
	{
		if (FluidRegistry.isFluidRegistered(fluidIn))
        {
            event.getModLog().info("Found fluid {}, the registration is canceled. ", fluidIn.getName());
            fluidIn = FluidRegistry.getFluid(fluidIn.getName());
        }
        else
        {
            FluidRegistry.registerFluid(mud);
            fluids.add(fluidIn);
        }
	}
	
	public Fluid getFluid(Fluid fluidIn)
	{
		for(Fluid tempFluid:fluids)
		{
			if(tempFluid.getName().equals(fluidIn.getName()))
			{
				return tempFluid;
			}
		}
		return fluidIn;
	}
}
