package firok.tic.common;

import firok.tic.enchantment.EnchantmentLoader;
import firok.tic.potion.PotionLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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
    	
    	// 最后的时候计算不屈buff的效果
    	PotionEffect potionIndomitable=entity.getActivePotionEffect(PotionLoader.indomitable);
    	if(potionIndomitable!=null)
    	{
    		float health_old=entity.getHealth();
    		float damage=event.getAmount();
    		float min_hp=(float) (potionIndomitable.getAmplifier()*2.5+2);
    		
    		if(health_old-damage <= min_hp)
    		{
    			event.setAmount(health_old-min_hp);
    		}
    	}
    }
    
    @SubscribeEvent
    public void onEntityAttacking(LivingAttackEvent event)
    {
    	/*
    	EntityLivingBase entity=event.getEntityLiving();
    	if(entity instanceof EntityPlayer)
		{
			EntityPlayer player=(EntityPlayer)entity;
			
			int size=player.inventory.getSizeInventory();
			for(int step=0;step<size;step++)
			{
				ItemStack itemstack=player.inventory.getStackInSlot(step);
				if(itemstack!=null && itemstack.getItem()!=null ))
				{
					return; // 找到贵重物品 返回
				}
			}
			
			player.attackEntityFrom(new firok.tic.DamageSources.AvariceDamege(), (float) (2+p_76394_2_*2.5));
		}*/
    }
    
    @SubscribeEvent
    public void onPlayerAttacking(AttackEntityEvent event)
    {
    	// 淘汰附魔效果
    	EntityPlayer player=event.getEntityPlayer();
		ItemStack currentItemStack=player.inventory.getCurrentItem();
		if(currentItemStack!=null)
		{
			int culling_level=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.culling, currentItemStack);
			if(culling_level>0)
			{
				Entity target=event.getTarget();
				if(target instanceof EntityLiving)
				{
					EntityLiving living=(EntityLiving) target;
					if(living.getMaxHealth() / living.getHealth() < 0.1)
					{
						living.onKillCommand();
					}
				}
			}
		}
    }
    
    @SubscribeEvent
    public void onEntitySetAttackTarget(LivingSetAttackTargetEvent event)
    {
    	EntityLivingBase entity=event.getEntityLiving();
    	World world=entity.getEntityWorld();
    	
    	Long time_now=world.getTotalWorldTime();
    	
    	entity.getEntityData().setLong("time_last_attack", time_now);
    	EntityDataManager dm=entity.getDataManager();
    	// dm.createKey(null, null);
    }
    @SubscribeEvent
    public void onLivingHurting(LivingHurtEvent event)
    {
    	;
    }
    
    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event)
    {
    	;
    }
    
    @SubscribeEvent
    public void onLivingExperienceDropping(LivingExperienceDropEvent event)
    {
    	EntityPlayer entity=event.getAttackingPlayer();

		EntityPlayer player=(EntityPlayer)entity;
		ItemStack currentItemStack=player.inventory.getCurrentItem();
		
		if(currentItemStack!=null)
		{
			// 淘汰附魔效果
			int level=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.culling, currentItemStack);
			
			if(level>0)
			{
				Potion speed=Potion.getPotionById(1);
				PotionEffect old_effect=player.getActivePotionEffect(speed);
				if(old_effect==null || old_effect.getAmplifier() < level)
					player.addPotionEffect(new PotionEffect(speed, level*200, level, false, true));
				else if(old_effect.getAmplifier() == level)
				{
					int old_duration=old_effect.getDuration();
					player.addPotionEffect(new PotionEffect(speed, old_duration+level*200, level, false, true));
				}
			}
		}
    }
    
     
}