package com.daimao;

import com.daimao.client.gui.screen.SingleSlotContainerScreen;
import com.daimao.item.ContainerTypes;
import com.daimao.item.Items;
import com.daimao.world.gen.OreGeneration;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main {

    public static final String MOD_ID = "daimao";
    /**
     * 创造模式分组
     */
    public static final ItemGroup DAIMAO_GROUP = new ItemGroup("daimao_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.CAR);
        }
    };

    /**
     * 实例
     */
    public static Main instance;

    public Main() {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(instance::setup);
        modEventBus.addListener(instance::clientSetup);
//        modEventBus.addListener(instance::onServerStarting);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerTypes.SINGLE_SLOT_CONTAINER, SingleSlotContainerScreen::new);
    }

    private void onServerStarting(final FMLServerStartingEvent event) {

    }

}
