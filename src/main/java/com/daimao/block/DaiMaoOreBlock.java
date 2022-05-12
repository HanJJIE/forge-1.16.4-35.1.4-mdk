package com.daimao.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class DaiMaoOreBlock extends OreBlock {

    public DaiMaoOreBlock(Properties properties) {
        super(properties);
    }

    /**
     * 挖矿的经验值
     * @param rand 随机
     * @return 经验值
     */
    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand, 22, 33);
    }

}
