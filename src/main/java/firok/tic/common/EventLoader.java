package firok.tic.common;

import java.util.List;

import firok.tic.enchantment.EnchantmentLoader;
import firok.tic.potion.PotionLoader;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
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
    	
    	EntityLivingBase attacker=entity.getLastAttacker();
    	/*
    	if(attacker!=null)
    		System.out.println("entity "+entity.getName() +" is attacking by "+attacker.getName());
    	else
    		System.out.println("entity "+entity.getName() +" is attacking by someone");
    	*/
    	
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
    public void buffPainbound_Hurt(LivingAttackEvent event)
    {
    	if(event.getAmount()<4)
    		return;
    	// 痛苦链接 debuff效果
    	EntityLivingBase center=event.getEntityLiving();
    	if(event.getSource() instanceof firok.tic.DamageSources.PainboundDamege)
    		return; // 如果受到的伤害已经是痛苦链接造成的伤害 不造成二次伤害
    	
    	PotionEffect painbound_center=center.getActivePotionEffect(PotionLoader.painbound);
    	if(painbound_center==null) // 如果被打中的生物没有这个debuff 则直接返回
    		return;
    	
    	int level=painbound_center.getAmplifier(); // 获取等级
    	double r=level * 2.5; // 计算范围 // 范围是2.5*debuff等级
    	
    	World world=center.getEntityWorld();
    	
    	List<Entity> entities
    		=world.getEntitiesWithinAABBExcludingEntity(center, new AxisAlignedBB
    			(-r, -r, -r, r, r, r));
    	for(Entity entity_temp : entities)
    	{
    		if(entity_temp instanceof EntityLiving)
    		{
    			EntityLiving living =(EntityLiving) entity_temp;
    			PotionEffect painbound_temp=living.getActivePotionEffect(PotionLoader.painbound);
    			if(painbound_temp==null) // 如果这个实体没有痛苦链接debuff 则计算下一个实体
    				continue;
    			
    			int level_temp=painbound_temp.getAmplifier(); // 获取等级
    			
    			// 求两个等级的平均值
    			float level_aver=(float) ((level*1.0+level_temp)/2);
    			
    			// 给予等级*30%的伤害
    			entity_temp.attackEntityFrom(new firok.tic.DamageSources.PainboundDamege(), (float) (level_aver*0.3*event.getAmount()));
    			
    			// 渲染粒子效果 // 暂时不管这个
    			// firok.tic.ability.CauseParticlesLine(center.getEntityWorld(),center,entity_temp,new ParticleFlame(),100);
    		}
    	}
    }
    
    @SubscribeEvent
    public void enchantmentCulling_buff(LivingExperienceDropEvent event)
    {
    	EntityPlayer entity=event.getAttackingPlayer();
    	
    	if(!(entity instanceof EntityPlayer))
    		return;

		EntityPlayer player=(EntityPlayer)entity;
		ItemStack currentItemStack=player.inventory.getCurrentItem();
		
		if(currentItemStack!=null)
		{
			// 淘汰附魔效果
			int level=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.culling, currentItemStack);
			
			if(level>0)
			{
				// 判断玩家当前的buff状态 给玩家一个速度buff
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
    @SubscribeEvent
    public void enchantmentCulling_kill(AttackEntityEvent event)
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
					if(living.getMaxHealth() / living.getHealth() < 0.1) // 斩杀血线低于10%的生物
					{
						living.onKillCommand();
					}
				}
			}
		}
    }
    
    @SubscribeEvent
    public void enchantmentTearing_buff(AttackEntityEvent event)
    {
    	EntityPlayer player=event.getEntityPlayer();
    	Entity _target=event.getTarget();
    	
    	// 撕裂附魔
    	
    	if(!(_target instanceof EntityLivingBase)) // 不是生物的话就返回
	    	return;
    	
    	EntityLivingBase target=(EntityLivingBase)_target;
    	
    	ItemStack currentItemStack=player.inventory.getCurrentItem();
    	if(currentItemStack!=null)
    	{
    		int level=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.tearing, currentItemStack);
    		if(level<=0)
    			return;
    		
    		// 先刷新一下当前的buff
    		target.addPotionEffect(new PotionEffect(PotionLoader.teared,level*100,level));
    		
    		// 然后判断实体身上有没有已经有的效果
    	}
    }
    @SubscribeEvent
    public void enchantmentTearing_damage(LivingAttackEvent event)
    {
    	if(event.getEntityLiving() instanceof EntityBat)
    		return;
    	
    	if(event.getSource() instanceof firok.tic.DamageSources.TearingDamege )
    		return;
    	
    	System.out.println("实体受到攻击 初始血量"+event.getEntityLiving().getHealth()+"  本次伤害"+event.getAmount()+"  伤害类型"+event.getSource().getDamageType());
    	
    	EntityLivingBase entity=event.getEntityLiving();
    	PotionEffect teared=entity.getActivePotionEffect(PotionLoader.teared);
    	
    	if(teared==null)
    		return;
    	
    	System.out.println("撕裂debuff生效 等级"+teared.getAmplifier()+"  剩余时间"+teared.getDuration());
    	
    	System.out.println(entity.getName()+" 实体受到伤害加深 "+(float) (event.getAmount() * teared.getAmplifier() * 0.3)+" 点");
    	
    	// 伤害加深 debuff等级*0.3
		// entity.attackEntityFrom(
		//    			new firok.tic.DamageSources.TearingDamege(),
		//    			(float) (event.getAmount() * teared.getAmplifier() * 0.3));
    	entity.setHealth((float) (entity.getHealth() - event.getAmount() * teared.getAmplifier() * 0.3));
    	
    }
    
    
    @SubscribeEvent
    public void onEntitySetAttackTarget(LivingSetAttackTargetEvent event)
    {
    	/*
    	EntityLivingBase entity=event.getEntityLiving();
    	World world=entity.getEntityWorld();
    	
    	Long time_now=world.getTotalWorldTime();
    	
    	entity.getEntityData().setLong("time_last_attack", time_now);
    	EntityDataManager dm=entity.getDataManager();
    	// dm.createKey(null, null);*/
    }
    
    
    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event)
    {
    	;
    }
    
    
    
    @SubscribeEvent
    public void buffLifecurse(LivingHealEvent event)
    {
    	EntityLivingBase entity=event.getEntityLiving();
    	if(entity.getActivePotionEffect(PotionLoader.lifecursed) ==null)
    		return;
    	if(entity instanceof EntityPlayer && ((EntityPlayer) entity).isCreative())
    		return;
    	
    	event.setCanceled(true);
    	// 渲染粒子效果 // 暂时不处理
    	// firok.tic.ability.CauseParticlesBall.CenteredAt(worldIn, posIn, radiusIn, particleIn, dencityIn);
    }
    @SubscribeEvent
    public void buffLifeblessed(LivingHealEvent event)
    {
    	EntityLivingBase entity=event.getEntityLiving();
    	if(entity.getActivePotionEffect(PotionLoader.lifeblessed) ==null)
    		return;
    	
    	event.setAmount(event.getAmount()*2); // 双倍治疗
    	// 渲染粒子效果 // 暂时不处理
    	// firok.tic.ability.CauseParticlesBall.CenteredAt(worldIn, posIn, radiusIn, particleIn, dencityIn);
    }
    
    
     
}