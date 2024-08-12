package com.majesticstudios.item;

import com.majesticstudios.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MAJESTICDRAGONS_TAB = new CreativeModeTab("majesticdragons_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SNAKEWOOD_PLANKS.get());
        }
    };
}
