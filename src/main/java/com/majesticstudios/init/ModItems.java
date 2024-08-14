package com.majesticstudios.init;

import com.majesticstudios.MajesticDragons;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MajesticDragons.MOD_ID);

    public static final RegistryObject<ForgeSpawnEggItem> SCALECROW_SPAWN_EGG =
            ITEMS.register("scalecrow_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SCALECROW,
                    0x1D1F28, 0x1D1F27, new Item.Properties()
                    .tab(ModTab.MAJESTICDRAGONS_TAB)
                    .stacksTo(64)));

    public static final RegistryObject<Item> SNAKEFRUIT_OPENING =
            ITEMS.register("snakefruit_opening", () -> new Item(new Item.Properties()
                    .tab(ModTab.MAJESTICDRAGONS_TAB)
                    .stacksTo(64)));

    public static final RegistryObject<Item> SNAKEFRUIT_OPEN =
            ITEMS.register("snakefruit_open", () -> new Item(new Item.Properties()
                    .tab(ModTab.MAJESTICDRAGONS_TAB)
                    .stacksTo(64)
                    .food(ModFoods.SNAKEFRUIT_OPEN)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
