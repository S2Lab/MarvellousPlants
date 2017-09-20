package firok.mps.block;

import java.util.Random;

import firok.mps.common.ConfigLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerWisdomFlower extends BlockBush
{
	// 智者花
	// 掉落经验
	
	protected int amountXP;
	public FlowerWisdomFlower()
	{
		super();
		this.setTickRandomly(true);
		this.setUnlocalizedName("wisdomFlower");
		amountXP=ConfigLoader.flowerWiserFlowerXPAmount;
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
		Entity xpball=new EntityXPOrb(worldIn, 0, 5, 0, amountXP);
		xpball.setPosition(pos.getX(),pos.getY(),pos.getZ());
		worldIn.spawnEntityInWorld(xpball);
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
