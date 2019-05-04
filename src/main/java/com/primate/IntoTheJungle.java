package com.primate;

import com.primate.server.ServerProxy;
import com.primate.server.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.primate.IntoTheJungle.*;

@Mod(modid = MODID, name = NAME, version = VERSION, dependencies = DEPENDENCIES, acceptedMinecraftVersions = "[1.12]")
public class IntoTheJungle {
    public static final String MODID = "primate";
    public static final String VERSION = "0.1";
    public static final String NAME = "Into the Jungle";
    public static final String DEPENDENCIES = "";

    public static final String CLIENT_PROXY = "com.primate.client.ClientProxy";
    public static final String SERVER_PROXY = "com.primate.server.ServerProxy";

    public static final Logger LOGGER = LogManager.getLogger(MODID);


    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.WILD_BANANA, 1, 1);
        }
    };

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static ServerProxy PROXY;

    @Mod.EventHandler
    static void preInit(FMLPreInitializationEvent event) {
        PROXY.preInit();
    }

    @Mod.EventHandler
    static void init(FMLInitializationEvent event) {
        PROXY.init();
    }

    @Mod.EventHandler
    static void postInit(FMLPostInitializationEvent event) {
        PROXY.postInit();
    }

}
