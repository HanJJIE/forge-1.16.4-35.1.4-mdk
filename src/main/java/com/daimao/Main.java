package com.daimao;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(Main.MOD_ID)
public class Main {

    public static final String MOD_ID = "daimao";
    private static final Logger LOGGER = LogManager.getLogger();

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
