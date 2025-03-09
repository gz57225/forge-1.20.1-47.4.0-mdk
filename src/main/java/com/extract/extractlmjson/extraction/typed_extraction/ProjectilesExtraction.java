package com.extract.extractlmjson.extraction.typed_extraction;

import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;

import static com.extract.extractlmjson.ExtractLMJson.LOGGER;

public class ProjectilesExtraction {
    public static void extract(BufferedWriter writer, JsonObject element) throws IOException {
        LOGGER.debug("Extracting projectiles");
    }
}
