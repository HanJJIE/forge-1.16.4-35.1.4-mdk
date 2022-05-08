package com.daimao.events;

import com.daimao.Blocks;
import com.daimao.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    /**
     * 注册物品
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerItems(
            final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(Items.getAll());
    }

    /**
     * 注册方块
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerBlocks(
            final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(Blocks.getAll());
    }

}
