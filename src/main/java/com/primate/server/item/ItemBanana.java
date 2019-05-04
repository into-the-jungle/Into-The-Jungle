package com.primate.server.item;

import com.primate.IntoTheJungle;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.Locale;

public class ItemBanana extends ItemFood {
    private static final String NBT_TIMER = "timer";
    private static final int MAX_TIMER = 1_000_000;
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
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger(NBT_TIMER, 0);
        }
        int meta = stack.getMetadata();
        int timer = stack.getTagCompound().getInteger(NBT_TIMER);
        if(timer >= MAX_TIMER) {
            if(meta == 0) {
                //UNRIPE -> RIPE
                entityIn.replaceItemInInventory(itemSlot, new ItemStack(this, stack.getCount(), 1));
            } else if (meta == 1) {
                //RIPE -> OVERRIPE
                entityIn.replaceItemInInventory(itemSlot, new ItemStack(this, stack.getCount(), 2));
            }
            timer = 0;
        }
        stack.getTagCompound().setInteger(NBT_TIMER, timer + 1);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack.getItem() != newStack.getItem() || oldStack.getMetadata() != newStack.getMetadata();
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
