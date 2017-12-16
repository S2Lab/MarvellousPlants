package firok.tic.entity;

import firok.tic.TIC;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityLoader
{
	private static int nextID=0;
	
	public EntityLoader()
	{
		// Entity.class, nameOfEntity, trackingRange, updateFrequency, sendsVelocityUpdates
		// 实体class 实体名称 追踪距离 更新频率 是否速度更新
		// registerEntity(EntityTowerOrb.class,"TowerOrb",64,3,true);
	}
	
	private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
            int updateFrequency, boolean sendsVelocityUpdates)
    {
		// registerEntity(Entity.class,nameOfEntity,idOfEntity,mod.class,trackingRange,updateFrequency,sendsVelocityUpdates
        EntityRegistry.registerModEntity(entityClass, name, nextID++, TIC.instance, trackingRange, updateFrequency,
                sendsVelocityUpdates);
    }
	
	private static void registerEntityEgg(Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(entityClass, eggPrimary, eggSecondary);
    }
}
