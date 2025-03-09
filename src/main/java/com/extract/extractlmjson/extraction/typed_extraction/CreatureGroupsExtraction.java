package com.extract.extractlmjson.extraction.typed_extraction;

import com.extract.extractlmjson.file_io.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static com.extract.extractlmjson.ExtractLMJson.LOGGER;

public class CreatureGroupsExtraction {
    // A Map that maps the name to its chinese name
    private static final Map<String, String> GROUPS = Map.of(
            "hunt", "敌对",
            "pack", "友好",
            "wary", "中立",
            "flee", "惧怕",
            "ignore", "被动",
            "retaliate", "报复"
    );

    public static void extract(BufferedWriter writer, JsonObject object) throws IOException {
        LOGGER.debug("Extracting creature groups " + Utils.capitalize(object.get("name").getAsString()));

        writer.write("# " + Utils.capitalize(object.get("name").getAsString()) + "生物组\n");
        writer.write(object.get("loadDefault").getAsBoolean() ? "**该生物组未被修改过**\n" : "**该生物组可能被修改过**\n");

        writeGroups(writer, object, "hunt", "该生物组会主动攻击这些生物组。");
        writeGroups(writer, object, "pack", "该生物组会与这些生物组友好相处。");
        writeGroups(writer, object, "wary", "该生物组会保持警惕，但不会主动攻击这些生物组。");
        writeGroups(writer, object, "flee", "该生物组会逃离这些生物组。");
        writeGroups(writer, object, "ignore", "该生物组会忽略这些生物组。");

        writer.write("## 对待玩家的态度是: \n");
        if (object.get("hunt").getAsJsonArray().contains(new JsonPrimitive("humanoid")))
            writer.write("- 敌对。\n");
        else
            writer.write("- " + GROUPS.get(object.get("default").getAsString()) + "。\n");

    }

    private static void writeGroups(BufferedWriter writer, JsonObject object, String name, String description) throws IOException {
        var array = object.get(name).getAsJsonArray();
        if (array != null && !array.isEmpty()) {
            writer.write("## " + GROUPS.get(name) + "生物组\n");
            writer.write(description + "\n");
            for (JsonElement group : array) {
                writer.write("- " + Utils.capitalize(group.getAsString()) + " 生物组\n");
            }
        }
    }
}
