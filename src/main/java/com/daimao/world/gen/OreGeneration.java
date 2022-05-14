package com.daimao.world.gen;

import com.daimao.item.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

public class OreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        // 如果是 下界 or 雨林
        if (Objects.equals(event.getCategory(), Biome.Category.NETHER)
                || Objects.equals(event.getCategory(), Biome.Category.JUNGLE)) {
            // do something
        }
        oreGenerate(
                // 生成器
                event.getGeneration(),
                // 填充类型：主世界
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                // 填充块
                Blocks.DAIMAO_ORE.getDefaultState(),
                6,
                0,
                5,
                20,
                66
        );
    }

    /**
     * @param settingsBuilder 设置构建器
     * @param fillerType      填充类型
     * @param state           状态
     * @param veinSize        矿脉最大数量（vanilla 没有规定最小数量，要实现的话需要自己写一个 Feature）
     * @param topOffset       矿脉生成范围：顶部偏移量（建议为 0）
     * @param minimalHeight   矿脉生成范围：高度
     * @param maximalHeight   矿脉生成范围：深度
     * @param countPerChunk   每个区块的数量
     */
    private static void oreGenerate(
            BiomeGenerationSettingsBuilder settingsBuilder,
            RuleTest fillerType,
            BlockState state,
            int veinSize,
            int topOffset,
            int minimalHeight,
            int maximalHeight,
            int countPerChunk
    ) {
        // 设置特性
        settingsBuilder.withFeature(
                // 1.类型：地下矿石
                GenerationStage.Decoration.UNDERGROUND_ORES,
                // 2.矿石配置
                Feature.ORE.withConfiguration(
                        // 2.1 特性配置
                        new OreFeatureConfig(fillerType, state, veinSize)
                ).withPlacement(
                        // 2.2 矿石范围配置
                        Placement.RANGE.configure(
                                new TopSolidRangeConfig(
                                        minimalHeight,
                                        topOffset,
                                        maximalHeight
                                )
                        )
                ).square().func_242731_b(countPerChunk)
        );
    }

}
