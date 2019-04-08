package com.expensivekoala.primate.server.item;

import com.expensivekoala.primate.IntoTheJungle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Locale;

public class ItemBanana extends ItemFood {
    public ItemBanana() {
        super(0, false);
        setCreativeTab(IntoTheJungle.TAB);
        setHasSubtypes(true);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        int meta = stack.getMetadata();
        if(meta >= 0 && meta < BananaTypes.values().length) {
            String name = BananaTypes.values()[meta].name();
            return super.getTranslationKey() + "." + name.toLowerCase(Locale.ROOT);
        }
        return super.getTranslationKey(stack);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(isInCreativeTab(tab)) {
            for (BananaTypes type : BananaTypes.values()) {
                items.add(new ItemStack(this, 1, type.ordinal()));
            }
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        int meta = stack.getMetadata();
        if(meta >= 0 && meta < BananaTypes.values().length) {
            return BananaTypes.values()[meta].getHealAmount();
        }
        return super.getHealAmount(stack);
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        int meta = stack.getMetadata();
        if(meta >= 0 && meta < BananaTypes.values().length) {
            return BananaTypes.values()[meta].getSaturationModifier();
        }
        return super.getSaturationModifier(stack);
    }

    public enum BananaTypes {
        UNRIPE(2, 0.4f),
        RIPE(5, 0.6f),
        OVERRIPE(3, 0.5f)
        ;

        private int healAmount;
        private float saturationModifier;

        BananaTypes(int healAmount, float saturationModifier) {
            this.healAmount = healAmount;
            this.saturationModifier = saturationModifier;
        }

        public int getHealAmount() {
            return healAmount;
        }

        public float getSaturationModifier() {
            return saturationModifier;
        }
    }
}
