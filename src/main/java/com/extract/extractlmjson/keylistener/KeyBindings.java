package com.extract.extractlmjson.keylistener;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String EXTRACTION_KEY_CATEGORY = "key.categories.extractlmjson.extraction";
    public static final String EXTRACTION_KEY_NAME = "key.extractlmjson.extraction_name";
    public static KeyMapping EXTRACTION_KEY = new KeyMapping(
            EXTRACTION_KEY_NAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_BACKSLASH,
            EXTRACTION_KEY_CATEGORY
    );
}
