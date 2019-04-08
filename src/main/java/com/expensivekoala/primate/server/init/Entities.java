package com.expensivekoala.primate.server.init;

import com.expensivekoala.primate.IntoTheJungle;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid = IntoTheJungle.MODID)
public class Entities {
    @SubscribeEvent
    static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {

    }
}
