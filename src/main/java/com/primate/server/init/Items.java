package com.primate.server.init;

import com.primate.IntoTheJungle;
import com.primate.server.item.ItemBanana;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(IntoTheJungle.MODID)
@Mod.EventBusSubscriber(modid = IntoTheJungle.MODID)
public class Items {

    public static final ItemBanana WILD_BANANA = null;

    @SubscribeEvent
    static void registerItems(final RegistryEvent.Register<Item> event) {
        register(event.getRegistry(), "wild_banana", new ItemBanana());
    }

    private static void register(final IForgeRegistry<Item> registry, final String name, final Item item) {
        ResourceLocation id = new ResourceLocation(IntoTheJungle.MODID, name);
        item.setRegistryName(id).setTranslationKey(IntoTheJungle.MODID + "." + name);
        registry.register(item);
    }
}
