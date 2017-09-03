package firok.mps.client;

import firok.mps.block.BlockLoader;
import firok.mps.item.ItemLoader;

public class ItemRenderLoader
{
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}