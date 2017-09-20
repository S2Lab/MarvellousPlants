package firok.mps.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerWoodenRootFlower extends BlockBush
{
	// 木根花
	// 会将底下的草方块/土方块变成木根方块
	public FlowerWoodenRootFlower()
	{
		super();
		this.setUnlocalizedName("woodenRootFlower");
	}
	
	// 判断是否能种植在选定的方块上
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
	    IBlockState soil = worldIn.getBlockState(pos.down()); // 获取下面的方块
	    return soil.getBlock()==Blocks.GRASS || soil.getBlock()==Blocks.DIRT || soil.getBlock()==BlockLoader.flowerWoodenRootBlock; // 只能种在草或泥土上
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
