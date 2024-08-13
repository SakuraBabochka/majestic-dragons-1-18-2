package com.majesticstudios.init;

import com.majesticstudios.MajesticDragons;
import com.majesticstudios.entity.scalecrow.ScalecrowEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MajesticDragons.MOD_ID);

    public static final RegistryObject<EntityType<ScalecrowEntity>> SCALECROW =
            ENTITIES.register("scalecrow", () -> EntityType.Builder.of(ScalecrowEntity::new, MobCategory.CREATURE)
                    .sized(2F, 1F)
                    .clientTrackingRange(100)
                    .setShouldReceiveVelocityUpdates(false)
                    .build(new ResourceLocation(MajesticDragons.MOD_ID, "scalecrow").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
