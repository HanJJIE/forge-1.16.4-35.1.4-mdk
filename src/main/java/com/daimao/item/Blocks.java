package com.daimao.item;

import com.daimao.Main;
import com.daimao.block.DaiMaoOreBlock;
import com.daimao.block.PointToOneself;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class Blocks {

    // 五彩斑斓
    public static final Block COLORFUL = new Block(AbstractBlock.Properties
            // 创建材料类型：岩石
            .create(Material.ROCK)
            // 硬度和阻力
            // 参考 https://minecraft.fandom.com/wiki/Breaking?so=search 中的 Blocks by hardness
            .hardnessAndResistance(5f, 6f)
            // 被破坏的声音：石头
            .sound(SoundType.STONE)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "colorful")
    );

    // 矿物：呆毛矿
    public static final Block DAIMAO_ORE = new DaiMaoOreBlock(AbstractBlock.Properties
            // 创建岩石
            .create(Material.ROCK)
            .setRequiresTool()
            // 硬度和阻力，这里和铁矿石一样
            .hardnessAndResistance(3.0F, 3.0F)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "daimao_ore")
    );

    // 面向我（也就是箭头面向对面）
    public static final Block POINT_TO_ONESELF = new PointToOneself(AbstractBlock.Properties
            // 创建岩石
            .create(Material.ROCK)
            // 硬度和阻力，这里和铁矿石一样
            .hardnessAndResistance(3.0F, 3.0F)
    ).setRegistryName(new ResourceLocation(
            Main.MOD_ID,
            "point_to_oneself")
    );


}
