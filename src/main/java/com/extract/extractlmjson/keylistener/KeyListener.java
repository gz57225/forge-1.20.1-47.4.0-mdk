package com.extract.extractlmjson.keylistener;

import com.extract.extractlmjson.ExtractLMJson;
import com.extract.extractlmjson.extraction.Extraction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;

import static com.extract.extractlmjson.ExtractLMJson.LOGGER;

@Mod.EventBusSubscriber(modid = ExtractLMJson.MODID)
public class KeyListener {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // Check if the \ key is pressed
        boolean isBackslashDown = KeyBindings.EXTRACTION_KEY.consumeClick();

        if (isBackslashDown) {
            try {
                // Only in client side
                Extraction.extract();
            } catch (IOException e) {
                LOGGER.error("Failed to extract data", e);
            }
        }
    }
}
