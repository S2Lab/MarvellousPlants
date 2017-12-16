package firok.tic.client;

import firok.tic.block.BlockLoader;
import firok.tic.item.ItemLoader;

public class ItemRenderLoader
{
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}