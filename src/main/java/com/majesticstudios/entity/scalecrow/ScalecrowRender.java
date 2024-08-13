package com.majesticstudios.entity.scalecrow;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ScalecrowRender extends GeoEntityRenderer<ScalecrowEntity> {
    public ScalecrowRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ScalecrowModel());
    }
}

