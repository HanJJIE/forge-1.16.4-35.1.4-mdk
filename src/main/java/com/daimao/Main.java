package com.daimao;

import com.daimao.item.Items;
import com.daimao.world.gen.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
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
        FMLJavaModLoadingContext.get().getModEventBus()
                .addListener(instance::setup);
        FMLJavaModLoadingContext.get().getModEventBus()
                .addListener(instance::clientSetup);
//        FMLJavaModLoadingContext.get().getModEventBus()
//                .addListener(instance::onServerStarting);
        MinecraftForge.EVENT_BUS.addListener(
                EventPriority.HIGH,
                OreGeneration::generateOres
        );
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void onServerStarting(final FMLServerStartingEvent event) {

    }

}
