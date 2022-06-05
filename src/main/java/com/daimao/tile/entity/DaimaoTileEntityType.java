package com.daimao.tile.entity;

import com.daimao.Main;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.Set;
import java.util.function.Supplier;

/**
 * 自定义 方块实体类型
 *
 * @author 黄汉杰
 * <p>描述：继承 TileEntityType 重写一些方法<p>
 * <p>创建时间：2022/6/5 17:34<p>
 */
public class DaimaoTileEntityType<T extends TileEntity> extends TileEntityType<T> {

    public DaimaoTileEntityType(Supplier<? extends T> factoryIn, Set<Block> validBlocksIn, Type<?> dataFixerType) {
        super(factoryIn, validBlocksIn, dataFixerType);
    }

    public static final class Builder<T extends TileEntity> {
        private final Supplier<? extends T> factory;
        private final Set<Block> blocks;

        private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
            this.factory = factoryIn;
            this.blocks = validBlocks;
        }

        public static <T extends TileEntity> DaimaoTileEntityType.Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
            return new DaimaoTileEntityType.Builder<>(factoryIn, ImmutableSet.copyOf(validBlocks));
        }

        public DaimaoTileEntityType<T> build(Type<?> datafixerType) {
            return new DaimaoTileEntityType<>(this.factory, this.blocks, datafixerType);
        }
    }

    /**
     * 会返回自己的注册方法
     * @author 黄汉杰
     * @date 2022/6/5 17:37
     * @param name   注册名
     * @return com.daimao.tile.entity.DaimaoTileEntityType<T>
     */
    public DaimaoTileEntityType<T> setRegisterName(String name) {
        this.setRegistryName(Main.MOD_ID, name);
        return this;
    }

}