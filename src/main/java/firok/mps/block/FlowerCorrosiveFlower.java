package firok.mps.block;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import firok.mps.common.ConfigLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerCorrosiveFlower extends BlockBush
{
	// 腐蚀之花
	// 随机产生毒气 向周围的实体添加中毒效果
	// 另外可能改变周围的方块
	
	// 腐蚀速度是每次执行腐蚀的时候 腐蚀多少个方块
	protected static int corroseSpeed; // 腐蚀速度
	protected static List<Block> uncorrosedBlock=new LinkedList<Block>(); // 不可腐蚀方块列表
	protected static int corroseRadius; // 腐蚀半径
	
	
	public FlowerCorrosiveFlower()
	{
		super();
		this.setTickRandomly(true);
		this.setUnlocalizedName("corrosiveFlower");
		corroseSpeed=ConfigLoader.flowerCorrosiveFlowerCorroseSpeed;
		corroseRadius=ConfigLoader.minEffectRadius+ConfigLoader.flowerCorrosiveFlowerCorroseRadius;
		
		uncorrosedBlock.add(Blocks.AIR); // 不能腐蚀空气
		uncorrosedBlock.add(BlockLoader.flowerCorrosiveFlower); // 不能腐蚀自己
		uncorrosedBlock.add(Blocks.WATER); // 不能腐蚀水
		uncorrosedBlock.add(Blocks.LAVA); // 不能腐蚀岩浆
	}
	
	
	// 随机执行 释放毒气或者积累毒气
	// 或者改变周围的方块
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
        for(int i=0;i<corroseSpeed;i++)
        {
        	// 获取腐蚀半径之内的一个随机位置
        	int x,y,z;
        	x=pos.getX()-corroseRadius+random.nextInt(2*corroseRadius);
        	y=pos.getY()-corroseRadius+random.nextInt(2*corroseRadius);
        	z=pos.getZ()-corroseRadius+random.nextInt(2*corroseRadius);
        	BlockPos posTemp=new BlockPos(x,y,z);
        	if(!isUncorrosed(worldIn.getBlockState(posTemp).getBlock())) // 如果方块可被腐蚀
        	{
        		worldIn.setBlockState(posTemp, BlockLoader.decorationCorrosedBlock.getDefaultState()); // 腐蚀方块
        	}
        }
    }
	
	// 获取腐蚀速度
	public int getCorroseSpeed()
	{
		return corroseSpeed;
	}
	// 获取腐蚀半径
	public int getCorroseRadius()
	{
		return corroseRadius;
	}
	
	// 设定一个方块不可腐蚀
	public void setUncorrosed(Block blockIn)
	{
		uncorrosedBlock.add(blockIn);
	}
	// 返回方块是否可被腐蚀
	public boolean isUncorrosed(Block blockIn)
	{
		// 不确定直接查表能不能用
		// 以后再改
		return uncorrosedBlock.contains(blockIn);
	}
	// 删除某个方块的不可侵蚀性质
	public void setCorrosed(Block blockIn)
	{
		uncorrosedBlock.remove(blockIn);
	}
	
	// 判断是否能种植在选定的方块上
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down()); // 获取下面的方块
        return soil.getBlock()==Blocks.GRASS || soil.getBlock()==Blocks.DIRT; // 只能种在草或泥土上
    }
	
	// 当旁边的方块改变的时候
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if(!canPlaceBlockAt(worldIn,pos))
        	this.checkAndDropBlock(worldIn, pos, state);
    }
	
	@Override
	protected void checkAndDropBlock(World worldIn,BlockPos pos,IBlockState state)
	{
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		dropBlockAsItem(worldIn, pos, state, 0);
	}
	
	// 平原植物
	@Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }
}
