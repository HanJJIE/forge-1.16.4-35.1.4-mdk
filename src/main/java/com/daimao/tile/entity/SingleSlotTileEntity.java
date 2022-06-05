package com.daimao.tile.entity;

import com.daimao.Main;
import com.daimao.container.SingleSlotContainer;
import com.daimao.item.TileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SingleSlotTileEntity extends LockableLootTileEntity {

    /**
     * 插槽数量
     */
    public static final int SLOTS = 1;

    /**
     * 用空填充 ItemStack
     */
    protected NonNullList<ItemStack> stacks = NonNullList.withSize(SLOTS, ItemStack.EMPTY);

    protected SingleSlotTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public SingleSlotTileEntity() {
        this(TileEntityTypes.SINGLE_SLOT_TILE_ENTITY);
    }

    /**
     * 获取库存
     *
     * @return int
     * @author 黄汉杰
     * @date 2022/6/5 18:24
     */
    @Override
    public int getSizeInventory() {
        return SLOTS;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.stacks = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + Main.MOD_ID + ".single_slot_container");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new SingleSlotContainer(id, player, this);
    }


    /**
     * 写入物品
     * @author 黄汉杰
     * @date 2022/6/5 18:25
     * @param compound   物品
     * @return net.minecraft.nbt.CompoundNBT
     */
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        // 检查有没有写入 compound
        if (!this.checkLootAndWrite(compound)) {
            // 如果没有，保存所有物品
            ItemStackHelper.saveAllItems(compound, stacks);
        }
        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        // 先读取所有需要的 data
        this.stacks = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        // 检查
        if (!this.checkLootAndRead(compound)) {
            // 与上面大同小异
            ItemStackHelper.loadAllItems(compound, this.stacks);
        }
    }

}
