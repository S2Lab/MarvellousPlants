package firok.mps.block;

import firok.mps.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DecorationCorrosedBlock extends Block{
	
	// 被腐蚀的方块
	// 没啥用处
	// 以后用来合成泥土之类的吧
	public DecorationCorrosedBlock()
	{
		super(Material.GROUND);
		this.setUnlocalizedName("corrosedBlock");
		this.setCreativeTab(CreativeTabsLoader.tabMPs);
	}
}
