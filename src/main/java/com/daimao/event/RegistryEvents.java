package com.daimao.event;

import com.daimao.container.DaimaoContainerType;
import com.daimao.item.Blocks;
import com.daimao.item.ContainerTypes;
import com.daimao.item.Items;
import com.daimao.item.TileEntityTypes;
import com.daimao.tile.entity.DaimaoTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    /**
     * 注册物品
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        getAllStaticField(Items.class, Item.class).forEach(registry::register);
    }

    /**
     * 注册方块
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        getAllStaticField(Blocks.class, Block.class).forEach(registry::register);
    }

    /**
     * 注册容器
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
        IForgeRegistry<ContainerType<?>> registry = event.getRegistry();
        getAllStaticField(ContainerTypes.class, DaimaoContainerType.class).forEach(registry::register);
    }

    /**
     * 注册方块实体
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
        IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
        getAllStaticField(TileEntityTypes.class, DaimaoTileEntityType.class).forEach(registry::register);
    }

    /**
     * 获取一个类的所有静态属性
     *
     * @param objClass    类
     * @param targetClass 属性类型
     * @param <T>         属性类型
     * @return 所有静态属性
     */
    public static <T> List<T> getAllStaticField(Class<?> objClass, Class<T> targetClass) {
        List<T> list = new ArrayList<>();
        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(Boolean.TRUE);
            try {
                if (Modifier.isStatic(field.getModifiers()) && Objects.equals(field.getType(), targetClass)) {
                    list.add(targetClass.cast(field.get(objClass)));
                }
            } catch (Exception e) {
                System.out.println("RegistryEvents.getAllStaticField.error: " + e.getMessage());
            }
        }
        return list;
    }

}
