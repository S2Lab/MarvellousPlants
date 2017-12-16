package firok.tic.block;

import firok.tic.ability.CauseTeleportation;
import firok.tic.common.ConfigLoader;
import firok.tic.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DecorationEnderBlock extends Block
{
	// 末影方块
	// 碰撞到会把实体传送走
	
	// 横向传送范围
	public static int teleportHorizontalRange=ConfigLoader.decorationEnderBlockHorizontalRange;
	
	public DecorationEnderBlock()
	{
		super(Material.GROUND);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabsLoader.tabTIC);
	}
	
	// 获取传送距离
	public int getTeleportRange()
	{
		return teleportHorizontalRange;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		CauseTeleportation.teleportEntityRandomly(entityIn, pos, teleportHorizontalRange);
    }
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		CauseTeleportation.teleportEntityRandomly(entityIn, pos, teleportHorizontalRange);
    }
}
