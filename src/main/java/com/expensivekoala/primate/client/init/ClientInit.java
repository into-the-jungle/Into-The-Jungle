package com.expensivekoala.primate.client.init;

import com.expensivekoala.primate.IntoTheJungle;
import com.expensivekoala.primate.server.init.Items;
import com.expensivekoala.primate.server.item.ItemBanana;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Locale;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = IntoTheJungle.MODID)
public class ClientInit {

    @SubscribeEvent
    static void registerModesl(final ModelRegistryEvent event) {
        for (ItemBanana.BananaTypes type : ItemBanana.BananaTypes.values()) {
            ResourceLocation location = new ResourceLocation(IntoTheJungle.MODID, Items.WILD_BANANA.getRegistryName().getPath() + "_" + type.name().toLowerCase(Locale.ROOT));
            ModelResourceLocation model = new ModelResourceLocation(location, "inventory");
            ModelLoader.setCustomModelResourceLocation(Items.WILD_BANANA, type.ordinal(), model);
        }
    }
}
