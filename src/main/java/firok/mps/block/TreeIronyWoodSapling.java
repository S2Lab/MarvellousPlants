package firok.mps.block;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import firok.mps.common.ConfigLoader;
import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import firok.mps.block.*;

public class TreeIronyWoodSapling extends Block
{
	// 铁质木树苗
	// 树干可以冶炼成铁锭
	// 生长缓慢
	// 种在铁矿石或者铁块上可以加速生长
	
	// 生长阶段
	// 最大生长阶段 // 最大为15
	protected static int maxGrowthStage=
			ConfigLoader.treeIronyWoodTotalGrowthStage>=15 ? 15 : 
			ConfigLoader.treeIronyWoodTotalGrowthStage<=0? 0 :ConfigLoader.treeIronyWoodTotalGrowthStage;
			
	protected static int acceleratedByIronBlock=
			ConfigLoader.treeIronyWoodAcceleratedByIronBlock<=0 ? 0 : ConfigLoader.treeIronyWoodAcceleratedByIronBlock; // 铁块对于铁质木生长的加速
	protected static int acceleratedByIronOre=
			ConfigLoader.treeIronyWoodAcceleratedByIronOre<=0 ? 0 : ConfigLoader.treeIronyWoodAcceleratedByIronOre; // 铁矿石对于铁质木生长的加速
			
	public static PropertyInteger GrowthStage=PropertyInteger.create("spawn_level", 0, maxGrowthStage);
	
	public TreeIronyWoodSapling()
	{
		super(Material.GOURD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(GrowthStage, 0));
		this.setTickRandomly(true);
		this.setUnlocalizedName("ironyWoodSapling");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
		// 生长
		// 检查底下两格的方块
		int nowStage=getMetaFromState(state);
		if(worldIn.getBlockState(pos.down(2)).getBlock()==Blocks.IRON_ORE)
			nowStage+=acceleratedByIronOre;
		else if(worldIn.getBlockState(pos.down(2)).getBlock()==Blocks.IRON_BLOCK)
			nowStage+=acceleratedByIronBlock;
		if(nowStage<=maxGrowthStage)
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(GrowthStage, nowStage));
		else
			;
	}
	
	protected boolean checkAbleGrow(World worldIn,BlockPos posSapling)
	{
		return true;
	}
	
	public void grow(World worldIn,BlockPos posSapling)
	{
		List<BlockPos> posesWood=new LinkedList<BlockPos>(); // 树干的位置
		List<BlockPos> posesLeave=new LinkedList<BlockPos>(); // 树叶的位置
		
		posesWood.add(posSapling);
		posesWood.add(posSapling.up());
		posesWood.add(posSapling.up(2));
		posesWood.add(posSapling.up(3));
		
		for(BlockPos posTemp:posesWood) // 产生树干
		{
			worldIn.setBlockState(posTemp,BlockLoader.treeIronyWoodBlock.getDefaultState());
		}
		for(BlockPos posTemp:posesLeave) // 产生树叶
		{
			worldIn.setBlockState(posTemp,BlockLoader.treeIronyWoodLeave.getDefaultState());
		}
	}
	
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, GrowthStage);
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(GrowthStage, meta);
	}
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(GrowthStage).intValue();
    }
}
