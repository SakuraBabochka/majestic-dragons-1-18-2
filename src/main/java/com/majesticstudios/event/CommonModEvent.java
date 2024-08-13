package com.majesticstudios.event;

import com.majesticstudios.MajesticDragons;
import com.majesticstudios.entity.scalecrow.ScalecrowEntity;
import com.majesticstudios.init.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MajesticDragons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvent {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SCALECROW.get(), ScalecrowEntity.bakeAttributes().build());
    }
}
