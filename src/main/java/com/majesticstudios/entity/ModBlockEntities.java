package com.majesticstudios.entity;

import com.majesticstudios.MajesticDragons;
import com.majesticstudios.entity.signs.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MajesticDragons.MOD_ID);

    public static void register(IEventBus eventBus) {BLOCK_ENTITIES.register(eventBus);}
}
