package com.daimao;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Blocks {

    // 五彩斑斓
    COLORFUL(new Block(Block.Properties
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
    ));

    private final Block block;

    public Block getBlock() {
        return this.block;
    }

    Blocks(Block block) {
        this.block = block;
    }

    public static Block[] getAll() {
        return Arrays.stream(Blocks.values())
                .map(Blocks::getBlock)
                .collect(Collectors.toList())
                .toArray(new Block[Blocks.values().length]);
    }

}
