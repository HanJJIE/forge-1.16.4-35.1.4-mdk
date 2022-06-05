package com.daimao.container;

import com.daimao.Main;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.network.IContainerFactory;

/**
 * 自定义容器类型
 *
 * @author 黄汉杰
 * <p>描述：继承 ContainerType 重写一些方法<p>
 * <p>创建时间：2022/6/5 16:59<p>
 */
public class DaimaoContainerType<T extends Container> extends ContainerType<T> implements IForgeContainerType<T> {

    public DaimaoContainerType(IFactory<T> factory) {
        super(factory);
    }

    public static <T extends Container> DaimaoContainerType<T> create(IContainerFactory<T> factory) {
        return new DaimaoContainerType<>(factory);
    }

    /**
     * 会返回自己的注册方法
     * @author 黄汉杰
     * @date 2022/6/5 17:36
     * @param name   注册名
     * @return com.daimao.container.DaimaoContainerType<T>
     */
    public DaimaoContainerType<T> setRegisterName(String name) {
        this.setRegistryName(Main.MOD_ID, name);
        return this;
    }

}