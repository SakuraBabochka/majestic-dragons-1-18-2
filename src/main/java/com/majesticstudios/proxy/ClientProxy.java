package com.majesticstudios.proxy;

import com.majesticstudios.MajesticDragons;
import com.majesticstudios.init.ClientInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MajesticDragons.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {


    @Override
    public void clientInit() {
        super.clientInit();
        ClientInit.clientInit();
    }
}
