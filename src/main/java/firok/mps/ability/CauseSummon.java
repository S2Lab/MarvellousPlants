package firok.mps.ability;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;

public class CauseSummon
{
	public static void CenteredAt(World worldIn,double xIn,double yIn,double zIn,Class<? extends Entity> entityTypeIn)
	{
		EntityRegistration entityReg=EntityRegistry.instance().lookupModSpawn(entityTypeIn, true);
		if(entityReg!=null)
		{
			try {
				Entity entity=entityReg.getEntityClass().newInstance();
				entity.setWorld(worldIn);
				entity.setPosition(xIn, yIn, zIn);
				
				worldIn.spawnEntityInWorld(entity);
				System.out.println("创建实体成功");
			}
			catch (Exception e) {
				System.out.println("召唤实体出现错误");
			}
		}
		else
		{
			System.out.println("没有获取到实体种类");
		}
	}
}
