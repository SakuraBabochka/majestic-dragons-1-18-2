package com.majesticstudios.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab MAJESTICDRAGONS_TAB = new CreativeModeTab("majesticdragons_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SNAKEWOOD_PLANKS.get());
        }
    };
}
