package com.extract.extractlmjson.extraction;

import com.extract.extractlmjson.ExtractLMJson;
import com.extract.extractlmjson.configuration.Config;

import javax.annotation.Nullable;

public class Extraction {
    public static final @Nullable String LM_RESOURCE_PACK_PATH = Config.getLMResourcePackPath();


    public static void extract() {
        ExtractLMJson.LOGGER.info("Lycanites Mobs resource pack path: {}", LM_RESOURCE_PACK_PATH);
    }
}
