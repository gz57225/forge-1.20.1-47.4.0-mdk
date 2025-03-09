package com.extract.extractlmjson.keylistener;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.eventbus.api.IEventBus;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String EXTRACTION_KEY_CATEGORY = "key.categories.extractlmjson.extraction";
    public static final String EXTRACTION_KEY_NAME = "key.extractlmjson.extraction_name";
    public static KeyMapping EXTRACTION_KEY = new KeyMapping(
            EXTRACTION_KEY_NAME, // 显示在设置界面的名称
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_BACKSLASH, // 默认绑定 \ 键
            EXTRACTION_KEY_CATEGORY // 显示在设置界面的类别
    );
}
