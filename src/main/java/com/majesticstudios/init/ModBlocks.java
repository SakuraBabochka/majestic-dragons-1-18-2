package com.majesticstudios.init;

import com.majesticstudios.MajesticDragons;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MajesticDragons.MOD_ID);

    public static final RegistryObject<Block> SNAKEWOOD_PLANKS = registerBlock("snakewood_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
            ), ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_LOG = registerBlock("snakewood_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            ), ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> STRIPPED_SNAKEWOOD_LOG = registerBlock("stripped_snakewood_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            ), ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_TRAPDOOR = registerBlock("snakewood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
            ), ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_CROWN = registerBlock("snakewood_crown",
            () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.LEAVES)
            ), ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_LEAVES = registerBlock("snakewood_leaves",
            () -> new HorizontalDirectionalBlock(BlockBehaviour.Properties.of(Material.LEAVES)
            ) {
            }, ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_BUTTON = registerBlock("snakewood_button",
            () -> new ButtonBlock(true, BlockBehaviour.Properties.of(Material.WOOD)) {
                @Override
                protected SoundEvent getSound(boolean pIsPressed) {
                    return null;
                }
            }, ModTab.MAJESTICDRAGONS_TAB);
    public static final RegistryObject<Block> SNAKEWOOD_FENCE = registerBlock("snakewood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
            ), ModTab.MAJESTICDRAGONS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
