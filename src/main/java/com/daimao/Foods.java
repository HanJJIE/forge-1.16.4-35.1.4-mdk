package com.daimao;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public enum Foods {

    SHAXIAN_NOODLES(new Food.Builder()
            // 回复的饥饿值（鸡腿）：5
            .hunger(10)
            // 饱和度（0.0 ~ 4.0）：
            .saturation(0.5f)
            // 效果
            .effect(new EffectInstance(
                    // 生命回复
                    // 参考 https://www.mcmod.cn/item/list/1-6.html 效果
                    Effects.REGENERATION,
                    // 持续时间 5s
                    100,
                    // 级别（0 开始）
                    2
            ), 1f) // 触发概率 100%
            // 总是可以吃的
            .setAlwaysEdible()
            .build()
    ),
    SHAXIAN_DUMPLING(new Food.Builder()
            .hunger(10)
            .saturation(0.5f)
            .effect(new EffectInstance(
                    Effects.REGENERATION,
                    100,
                    2
            ), 1f)
            .setAlwaysEdible()
            .build()
    );

    private final Food food;

    public Food getFood() {
        return this.food;
    }

    Foods(Food food) {
        this.food = food;
    }

}
