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

    @SubscribeEvent
    public static void registerItems(
            final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(Items.getAll());
    }

    @SubscribeEvent
    public static void registerBlocks(
            final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(Blocks.getAll());
    }

}
