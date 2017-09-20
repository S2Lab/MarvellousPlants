package firok.mps.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FunctionalStoneOfCorona extends Item
{
	// 日冕之石
	// 创建一次大爆炸
	// 至于威力有多大 取决于配置文件
	
	// 另外也能当作燃料
	// 冶炼巨量物品
	
	private static float defaultStrength=100; // 默认爆炸威力
	private static float explosionStrength;
	
	public FunctionalStoneOfCorona()
	{
		super();
		this.setUnlocalizedName("functionalStoneOfCorona");
		explosionStrength=defaultStrength;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		// 潜行才能使用日冕之石
		if(!playerIn.isSneaking())
			return new ActionResult(EnumActionResult.PASS, itemStackIn);
		BlockPos posPlayer=playerIn.getPosition();
		itemStackIn.stackSize--;
		worldIn.createExplosion(playerIn, posPlayer.getX(), posPlayer.getY(), posPlayer.getZ(), explosionStrength, true);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
