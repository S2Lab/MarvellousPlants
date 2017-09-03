package firok.mps.block;

import java.util.Random;

import javax.annotation.Nullable;

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
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class TreeIronyWoodSapling extends Block
{
	// 铁质木树苗
	// 树干可以冶炼成铁锭
	// 生长缓慢
	// 种在铁矿石或者铁块上可以加速生长
	
	// 生长阶段
	public static PropertyInteger GrowthStage=PropertyInteger.create("spawn_level", 0, 8);
	
	public TreeIronyWoodSapling()
	{
		super(Material.GOURD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(GrowthStage, 0));
		this.setTickRandomly(true);
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
		// 生长
		// 检查底下两格的方块
		pos;
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
