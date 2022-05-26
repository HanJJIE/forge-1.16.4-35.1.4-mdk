package com.daimao.item;

import com.daimao.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

public class Items {

    // 车
    public static final Item CAR = new Item(new Item.Properties()
            // 分组
            .group(Main.DAIMAO_GROUP)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "car")
    );
    // 沙县-拌面
    public static final Item SHAXIAN_NOODLES = new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_NOODLES)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_noodles")
    );
    // 沙县-蒸饺
    public static final Item SHAXIAN_DUMPLING = new Item(new Item.Properties()
            .group(Main.DAIMAO_GROUP)
            .food(Foods.SHAXIAN_DUMPLING)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "shaxian_dumpling")
    );
    // 五彩斑斓
    public static final Item COLORFUL = new BlockItem(
            Blocks.COLORFUL,
            new Item.Properties().group(Main.DAIMAO_GROUP)
    ).setRegistryName(
            Objects.requireNonNull(Blocks.COLORFUL.getBlock().getRegistryName())
    );
    // 五彩斑斓
    public static final Item DAIMAO_ORE = new BlockItem(
            Blocks.DAIMAO_ORE,
            new Item.Properties().group(Main.DAIMAO_GROUP)
    ).setRegistryName(
            Objects.requireNonNull(Blocks.DAIMAO_ORE.getBlock().getRegistryName())
    );
    // 低级剑
    public static final Item LOW_SWORD = new SwordItem(
            ItemTier.LOW,
            1,
            -2.4f,
            new Item.Properties().group(ItemGroup.COMBAT)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "low_sword")
    );
    // 高级级剑
    public static final Item HIGH_SWORD = new SwordItem(
            ItemTier.HIGH,
            88,
            -3.0f,
            new Item.Properties().group(ItemGroup.COMBAT)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "high_sword")
    );
    // 面向我（也就是箭头面向对面）
    public static final Item POINT_TO_ONESELF = new BlockItem(
            Blocks.POINT_TO_ONESELF,
            new Item.Properties().group(Main.DAIMAO_GROUP)
    ).setRegistryName(
            Objects.requireNonNull(Blocks.POINT_TO_ONESELF.getBlock().getRegistryName())
    );

}
