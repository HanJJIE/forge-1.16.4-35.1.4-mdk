package com.daimao.item;

import com.daimao.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Blocks {

    // 五彩斑斓
    public static final Block COLORFUL = (new Block(Block.Properties
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

    /**
     * 获取所有 Block
     * @return all block
     */
    public Block[] getAll() {
        List<Block> list = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(Boolean.TRUE);
            try {
                list.add((Block) field.get(this));
            } catch (Exception e) {
                System.out.println("get block error: " + e.getMessage());
            }
        }
        return list.toArray(new Block[list.size() - 1]);
    }

}
