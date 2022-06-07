package com.daimao.event;

import com.daimao.Main;
import com.daimao.item.Blocks;
import com.daimao.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * 呆毛矿事件
 *
 * @author 黄汉杰
 * <p>描述：用于编写呆毛矿事件触发代码<p>
 * <p>创建时间：2022/6/5 21:20<p>
 */

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class DaimaoOreEvents {

    private static final Logger log = Logger.getLogger(DaimaoOreEvents.class.getName());

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        log.info(event.getPlayer().getName().getString()
                + " break block: " + event.getState().getBlock().getRegistryName());
        // 破坏 point_to_oneself 奖励 999 经验和 32 个 car
        if (Objects.equals(event.getState().getBlock(), Blocks.POINT_TO_ONESELF)) {
            event.setExpToDrop(999);
            event.getExpToDrop();
            event.getPlayer().addItemStackToInventory(new ItemStack(Items.CAR, 32));
            event.getPlayer().setHealth(0f);
        }
    }

}