package com.extract.extractlmjson.keylistener;

import com.extract.extractlmjson.ExtractLMJson;
import com.extract.extractlmjson.extraction.Extraction;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = ExtractLMJson.MODID)
public class KeyListener {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        long window = Minecraft.getInstance().getWindow().getWindow();

        // 判断是否按下 \
        boolean isBackslashDown = KeyBindings.EXTRACTION_KEY.consumeClick();

        if (isBackslashDown) {
            Extraction.extract();
        }
    }
}
