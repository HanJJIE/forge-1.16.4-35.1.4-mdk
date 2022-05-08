package com.daimao;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Objects;

@Mod(Main.MOD_ID)
public class Main {

    public static final String MOD_ID = "daimao";
    public static final ItemGroup DAIMAO_GROUP = new ItemGroup("daimao_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.CAR.getItem());
        }
    };

    private static Main instance = null;

    public static Main getInstance() {
        if (Objects.isNull(instance)) {
            init();
        }
        return instance;
    }

    private static void init() {
        instance = new Main();
        FMLJavaModLoadingContext.get().getModEventBus()
                .addListener(instance::setup);
        FMLJavaModLoadingContext.get().getModEventBus()
                .addListener(instance::clientSetup);
//        FMLJavaModLoadingContext.get().getModEventBus()
//                .addListener(instance::onServerStarting);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void onServerStarting(final FMLServerStartingEvent event) {

    }

}
