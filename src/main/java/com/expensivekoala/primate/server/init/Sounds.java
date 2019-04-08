package com.expensivekoala.primate.server.init;

import com.expensivekoala.primate.IntoTheJungle;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IntoTheJungle.MODID)
public class Sounds {

    @SubscribeEvent
    static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {

    }
}
