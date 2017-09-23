package firok.mps.block;

import java.util.Random;

import firok.mps.common.ConfigLoader;
import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerFrostyLotus extends BlockBush{
	// 霜冻雪莲
	// 在周围产生雪
	// 或者冰冻
	
	public static int freezeSpeed;
	public static int freezeRadius;
	
	public FlowerFrostyLotus()
	{
		super();
		this.setTickRandomly(true);
		this.setUnlocalizedName("frostyLotus");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
		freezeSpeed=ConfigLoader.flowerFrostyLotusFreezeSpeed;
		freezeRadius=ConfigLoader.flowerFrostyLotusFreezeRadius;
	}
	
	// 冰冻周围的方块
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
		for(int i=0;i<freezeSpeed;i++)
        {
        	// 获取效果半径之内的一个随机位置
        	int x,y,z;
        	x=pos.getX()-freezeRadius+random.nextInt(2*freezeRadius-1);
        	y=pos.getY()-freezeRadius+random.nextInt(2*freezeRadius);
        	z=pos.getZ()-freezeRadius+random.nextInt(2*freezeRadius-1);
        	BlockPos posTemp=new BlockPos(x,y,z);
        	if(worldIn.getBlockState(posTemp).getBlock()==Blocks.WATER) // 如果方块是水方块
        	{
        		worldIn.setBlockState(posTemp, Blocks.ICE.getDefaultState()); // 冻结方块
        	}
        	else
        	{
        		 // 如果选定位置的方块是完整固体方块  且位于其上面一个的方块是空气
        		if(worldIn.getBlockState(posTemp).isFullCube() && worldIn.getBlockState(posTemp.up()).getBlock()==Blocks.AIR)
        		{
        			worldIn.setBlockState(posTemp.up(), Blocks.SNOW_LAYER.getDefaultState()); // 生成一层雪
        		}
        	}
        }
    }
}
