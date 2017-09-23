package firok.mps.block;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import firok.mps.common.ConfigLoader;
import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerToxicFlower extends BlockBush
{
	// 腐蚀之花
	// 随机产生毒气 向周围的实体添加中毒效果
	// 另外可能改变周围的方块
	
	protected static int burstRadius; // 毒气半径
	protected static int incrementRadius; // 半径增量
	
	
	
	public FlowerToxicFlower()
	{
		super();
		this.setTickRandomly(true);
		this.setUnlocalizedName("toxicFlower");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
		burstRadius=ConfigLoader.minEffectRadius+ConfigLoader.flowerToxicFlowerEffectRadius;
		incrementRadius=ConfigLoader.incrementEffectRadius;
	}
	
	
	// 随机执行 释放毒气或者积累毒气
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
        ;
    }
	
	// 获取半径增量
	public int getIncrementRadius()
	{
		return incrementRadius;
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
