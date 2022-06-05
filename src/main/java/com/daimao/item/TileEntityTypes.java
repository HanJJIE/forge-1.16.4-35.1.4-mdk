package com.daimao.item;

import com.daimao.tile.entity.DaimaoTileEntityType;
import com.daimao.tile.entity.SingleSlotTileEntity;

/**
 * 方块实体列表
 *
 * @author 黄汉杰
 * <p>描述：管理所用方块实体<p>
 * <p>创建时间：2022/6/5 17:25<p>
 */
public class TileEntityTypes {

    /**
     * 单个插槽的实体方块
     */
    public static DaimaoTileEntityType<SingleSlotTileEntity> SINGLE_SLOT_TILE_ENTITY = DaimaoTileEntityType.Builder
            .create(SingleSlotTileEntity::new, Blocks.SINGLE_SLOT_CONTAINER_BLOCK)
            .build(null)
            .setRegisterName("single_slot_tile_entity");

}