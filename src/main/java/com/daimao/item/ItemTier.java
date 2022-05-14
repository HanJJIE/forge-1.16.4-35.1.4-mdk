package com.daimao.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 * 物品等级
 */
public enum ItemTier implements IItemTier {

    LOW(0,
            10,
            2.0F,
            0.0F,
            15,
            () -> Ingredient.fromTag(ItemTags.PLANKS)
    ),
    HIGH(4,
            999,
            15.0F,
            999.0F,
            22,
            () -> Ingredient.fromItems(Items.GOLD_INGOT)
    );

    /**
     * 收获级别：工具的采矿能力
     * https://minecraftmodcustomstuff.fandom.com/wiki/HarvestLevel
     * 0	Wood 木头
     * 1	Stone / Gold 石头/黄金
     * 2	Iron 铁
     * 3	Diamond 钻石
     * 4	Netherite 下届石
     */
    private final int harvestLevel;
    /**
     * 耐久度：工具最大使用次数
     * https://minecraftmodcustomstuff.fandom.com/wiki/Maxuses
     */
    private final int maxUses;
    /**
     * 效率：工具破坏方块的速度
     * https://minecraftmodcustomstuff.fandom.com/wiki/Efficiency
     */
    private final float efficiency;
    /**
     * 攻击伤害
     */
    private final float attackDamage;
    /**
     * 附魔性：定义了物品的可附魔性
     * https://minecraftmodcustomstuff.fandom.com/wiki/Enchantability
     */
    private final int enchantability;
    /**
     * 修复材料
     * https://minecraftmodcustomstuff.fandom.com/wiki/Repairable
     * https://minecraft.fandom.com/wiki/Item_repair
     */
    private final LazyValue<Ingredient> repairMaterial;

    private ItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    @Nonnull
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

}