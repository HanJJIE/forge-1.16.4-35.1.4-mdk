package com.daimao.block;

import com.daimao.item.Items;
import com.daimao.item.TileEntityTypes;
import com.daimao.tile.entity.SingleSlotTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * 单插槽的容器方块
 *
 * @author 黄汉杰
 * <p>描述：可以定义插槽容量的容器块<p>
 * <p>创建时间：2022/6/5 13:05<p>
 */
public class SingleSlotContainerBlock extends Block {

    public SingleSlotContainerBlock(Properties properties) {
        super(properties);
    }

    /**
     * 是否包含实体
     *
     * @param state 方块状态
     * @return boolean
     * @author 黄汉杰
     * @date 2022/6/5 13:08
     */
    @Override
    public boolean hasTileEntity(BlockState state) {
        return Boolean.TRUE;
    }

    /**
     * 创建方块实体
     *
     * @param state 块状态
     * @param world 世界
     * @return net.minecraft.tileentity.TileEntity
     * @author 黄汉杰
     * @date 2022/6/5 13:22
     */
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypes.SINGLE_SLOT_TILE_ENTITY.create();
    }

    /**
     * 在块激活后出发此方法
     *
     * @param state   块状态
     * @param worldIn 世界
     * @param pos     位置
     * @param player  玩家
     * @param handIn  手
     * @param hit     块射线追踪结果
     * @return net.minecraft.util.ActionResultType
     * @author 黄汉杰
     * @date 2022/6/5 13:24
     */
    @SuppressWarnings("all")
    @Override
    public ActionResultType onBlockActivated(
            BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit) {
        // 检测手持物品是否满足条件
        if (player.getHeldItemMainhand().getItem() != Items.SINGLE_SLOT_CONTAINER_ITEM) {
            // 如果是客户端
            if (!worldIn.isRemote()) {
                TileEntity tileentity = worldIn.getTileEntity(pos);
                // 检查 TileEntity 是否为 TileEntity
                if (tileentity instanceof SingleSlotTileEntity) {
                    NetworkHooks.openGui((ServerPlayerEntity) player, (SingleSlotTileEntity) tileentity, pos);
                }
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

}