package com.daimao.item;

import com.daimao.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Items {

    // 车
    public static final Item CAR = (new Item(new Item.Properties()
            // 分组
            .group(Main.DAIMAO_GROUP)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "car")
    ));
    // 沙县-拌面
    public static final Item SHAXIAN_NOODLES = (new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_NOODLES)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_noodles")
    ));
    // 沙县-蒸饺
    public static final Item SHAXIAN_DUMPLING = (new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_DUMPLING)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_dumpling")
    ));
    // 五彩斑斓
    public static final Item COLORFUL = (new BlockItem(
            Blocks.COLORFUL,
            new Item.Properties().group(Main.DAIMAO_GROUP)
    ).setRegistryName(
            Objects.requireNonNull(Blocks.COLORFUL.getBlock().getRegistryName())
    ));

    /**
     * 获取所有 Item
     * @return all item
     */
    public Item[] getAll() {
        List<Item> list = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(Boolean.TRUE);
            try {
                list.add((Item) field.get(this));
            } catch (Exception e) {
                System.out.println("get block error: " + e.getMessage());
            }
        }
        return list.toArray(new Item[list.size() - 1]);
    }

}
