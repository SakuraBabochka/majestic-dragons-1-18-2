package com.majesticstudios.init;

import com.majesticstudios.MajesticDragons;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MajesticDragons.MOD_ID);

    public static final RegistryObject<ForgeSpawnEggItem> SCALECROW_SPAWN_EGG =
            ITEMS.register("scalecrow_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SCALECROW,
                    0x1D1F28, 0x1D1F27, new Item.Properties()
                    .tab(ModTab.MAJESTICDRAGONS_TAB)
                    .stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
