package com.extract.extractlmjson.extraction;

import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;

@FunctionalInterface
public interface IExtraction {
    void apply(BufferedWriter writer, JsonObject element) throws IOException;
}
