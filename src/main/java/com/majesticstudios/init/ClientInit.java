package com.majesticstudios.init;

import com.majesticstudios.MajesticDragons;
import com.majesticstudios.entity.scalecrow.ScalecrowRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MajesticDragons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    public static void clientInit() {
        EntityRenderers.register(ModEntities.SCALECROW.get(), ScalecrowRender::new);

    }
}
