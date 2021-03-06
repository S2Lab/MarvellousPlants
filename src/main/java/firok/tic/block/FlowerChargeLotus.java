package firok.tic.block;

import java.util.Random;

import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerChargeLotus extends BlockBush
{
	// 电荷兰
	// 雨天会吸引雷电
	
	public FlowerChargeLotus()
	{
		super();
		this.setTickRandomly(true);
		this.setUnlocalizedName("chargeLotus");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
	
	// 吸引雷电
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
		if(worldIn.isRaining())
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(),pos.getY(),pos.getZ(), false));
    }
}