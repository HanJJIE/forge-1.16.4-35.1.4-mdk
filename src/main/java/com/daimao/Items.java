package com.daimao;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Items {

    // 车
    CAR(new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "car")
    )),
    // 沙县-拌面
    SHAXIAN_NOODLES(new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_NOODLES.getFood())
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_noodles")
    )),
    // 沙县-蒸饺
    SHAXIAN_DUMPLING(new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_DUMPLING.getFood())
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_dumpling")
    )),
    // 五彩斑斓
    COLORFUL(new BlockItem(
            Blocks.COLORFUL.getBlock(),
            new Item.Properties().group(Main.DAIMAO_GROUP)
    ).setRegistryName(
            Objects.requireNonNull(Blocks.COLORFUL.getBlock().getRegistryName())
    ));

    private final Item item;

    public Item getItem() {
        return this.item;
    }

    Items(Item item) {
        this.item = item;
    }

    public static Item[] getAll() {
        return Arrays.stream(Items.values())
                .map(Items::getItem)
                .collect(Collectors.toList())
                .toArray(new Item[Items.values().length]);
    }

}
