package com.daimao;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public enum Foods {

    SHAXIAN_NOODLES(new Food.Builder()
            .hunger(10)
            .saturation(0.5f)
            .effect(new EffectInstance(
                    Effects.REGENERATION,
                    100,
                    2
            ), 1f)
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
