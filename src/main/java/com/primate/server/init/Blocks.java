package com.primate.server.init;

import com.primate.IntoTheJungle;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IntoTheJungle.MODID)
public class Blocks {
    @SubscribeEvent
    static void registerBlocks(final RegistryEvent.Register<Block> event) {

    }
}
