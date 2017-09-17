package firok.mps.common;

import firok.mps.potion.PotionLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventLoader
{
    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onPlayerDamaged(LivingHurtEvent event)
    {
    	EntityLivingBase entity= event.getEntityLiving();
    	if(entity.getActivePotionEffect(PotionLoader.folly)!=null) // 愚者状态的效果 会覆盖 智者状态的效果
    	{
    		event.setAmount(
    				ConfigLoader.percentDamageDiscreasementPotionFool>=0 ?
    						ConfigLoader.percentDamageDiscreasementPotionFool : 0 * event.getAmount());
    	}
    	else if(entity.getActivePotionEffect(PotionLoader.wise)!=null)
    	{
    		event.setAmount(
    				ConfigLoader.percentDamageDiscreasementPotionFool>=0 ?
    						ConfigLoader.percentDamageDiscreasementPotionFool : 0 * event.getAmount());
    	}
    }
    
}