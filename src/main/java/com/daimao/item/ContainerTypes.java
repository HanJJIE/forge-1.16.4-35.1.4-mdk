package com.daimao.item;

import com.daimao.container.DaimaoContainerType;
import com.daimao.container.SingleSlotContainer;

/**
 * 容器列表
 *
 * @author 黄汉杰
 * <p>描述：管理所有容器<p>
 * <p>创建时间：2022/6/5 16:19<p>
 */
public class ContainerTypes {

    /**
     * 单个槽位的容器
     */
    public static DaimaoContainerType<SingleSlotContainer> SINGLE_SLOT_CONTAINER
            = DaimaoContainerType.create(SingleSlotContainer::new).setRegisterName("single_slot_container");

}