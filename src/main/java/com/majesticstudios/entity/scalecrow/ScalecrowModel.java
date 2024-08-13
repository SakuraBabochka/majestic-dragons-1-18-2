package com.majesticstudios.entity.scalecrow;

import com.majesticstudios.MajesticDragons;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ScalecrowModel extends AnimatedGeoModel<ScalecrowEntity> {
    @Override
    public ResourceLocation getModelLocation(ScalecrowEntity scalecrowEntity) {
        return new ResourceLocation(MajesticDragons.MOD_ID, "geo/entity/scalecrow.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ScalecrowEntity scalecrowEntity) {
        return new ResourceLocation(MajesticDragons.MOD_ID, "textures/entity/scalecrow/black_scalecrow_male.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ScalecrowEntity scalecrowEntity) {
        return new ResourceLocation(MajesticDragons.MOD_ID, "animations/entity/scalecrow.animation.json");
    }
}
