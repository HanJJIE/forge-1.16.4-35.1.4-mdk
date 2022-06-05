package com.daimao.container;

import com.daimao.item.Blocks;
import com.daimao.item.ContainerTypes;
import com.daimao.tile.entity.SingleSlotTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class SingleSlotContainer extends Container {

    public final SingleSlotTileEntity tileEntity;
    private final IWorldPosCallable ableToInteract;

    public SingleSlotContainer(final int winId, final PlayerInventory playerIvty, final SingleSlotTileEntity tileEntity) {
        super(ContainerTypes.SINGLE_SLOT_CONTAINER, winId);
        this.tileEntity = tileEntity;
        this.ableToInteract = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        // 1.添加插槽：index 索引，xPos 和 yPos 是插槽左上角的 GUI

        this.addSlot(new Slot(tileEntity, 0, 80, 35));
//        this.addSlot(new Slot(tileEntity, 1, 98, 35));
//        this.addSlot(new Slot(tileEntity, 2, 116, 35));

        // 2.创建玩家背包物品栏

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++)// ⑨是不是很熟悉？因为物品栏一横行有九个
            {
                this.addSlot(new Slot(playerIvty, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        // 3.工具栏
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerIvty, col, 8 + col * 18, 142));
        }

    }

    public SingleSlotContainer(final int winId, final PlayerInventory playerIvty, final PacketBuffer data) {
        this(winId, playerIvty, getTileEntity(playerIvty, data));
    }

    // 创建从 data 里获取 TileEntity 的方法
    private static SingleSlotTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {

        // 检查物品栏和 data 是否为 null
        Objects.requireNonNull(playerInventory, "Player's item column cannot be null.");
        Objects.requireNonNull(data, "Packet Buffer cannot be null.");

        // 获取 Tile Entity

        final TileEntity tileentity = playerInventory.player.world.getTileEntity(data.readBlockPos());

        // 如果 tileentity 是 SingleSlotTileEntity 的实例
        if (tileentity instanceof SingleSlotTileEntity) {
            return ((SingleSlotTileEntity) tileentity);
        }
        // 否则报错
        throw new IllegalStateException("Invalid Tile Entity");
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(ableToInteract, playerIn, Blocks.SINGLE_SLOT_CONTAINER_BLOCK);
    }

    // 把 ItemStack 转移到我们看到的另一个容器里的 slot
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        // 检查 slot 是否不为 null 且有 getHasStack
        if (slot != null && slot.getHasStack()) {
            // 如果满足条件，则创建另一个 ItemStack
            ItemStack stack_ = slot.getStack();
            stack = stack_.copy();

            // 考虑各种情况
            if (index < SingleSlotTileEntity.SLOTS &&
                    // 给玩家和 container 中第一个可用的提供 ItemStack
                    !this.mergeItemStack(stack_, SingleSlotTileEntity.SLOTS, this.inventorySlots.size(), true)) {

                return ItemStack.EMPTY;
            }

            if (!this.mergeItemStack(stack_, 0, SingleSlotTileEntity.SLOTS, false)) {
                return ItemStack.EMPTY;
            }

            if (stack_.isEmpty()) {
                // 把 stack 放进 slot 里
                slot.putStack(ItemStack.EMPTY);
            } else {
                // slot 里的 stack 发生改变时 call
                slot.onSlotChanged();
            }

        }
        return stack;
    }

}