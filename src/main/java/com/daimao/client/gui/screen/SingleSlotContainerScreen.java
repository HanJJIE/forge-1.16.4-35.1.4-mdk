package com.daimao.client.gui.screen;

import com.daimao.Main;
import com.daimao.container.SingleSlotContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

/**
 * 单插槽的容器界面
 *
 * @author 黄汉杰
 * <p>描述：用于容器的 GUI 界面渲染<p>
 * <p>创建时间：2022/6/5 12:52<p>
 */
public class SingleSlotContainerScreen extends ContainerScreen<SingleSlotContainer> {

    private static final ResourceLocation DISPLAY_CASE_GUI = new ResourceLocation(
            Main.MOD_ID,
            "textures/gui/single_slot_container.png"
    );

    public SingleSlotContainerScreen(SingleSlotContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        // 材质的像素大小，也就是右下角的坐标
        this.xSize = 175;
        this.ySize = 166;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float) this.playerInventoryTitleX,
                (float) this.playerInventoryTitleY, 4210752);

    }

    @SuppressWarnings("deprecation")
    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX,
                                                   int mouseY) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        assert this.minecraft != null;
        // 绑定材质
        this.minecraft.textureManager.bindTexture(DISPLAY_CASE_GUI);
        // 计算渲染位置
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize);
    }

}