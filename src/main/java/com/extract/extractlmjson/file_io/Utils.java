package com.extract.extractlmjson.file_io;

import com.extract.extractlmjson.configuration.Config;
import com.extract.extractlmjson.extraction.IExtraction;
import com.extract.extractlmjson.extraction.typed_extraction.*;
import com.mojang.datafixers.util.Pair;

import javax.annotation.Nullable;
import java.util.List;

public class Utils {
    public static final List<Pair<String, IExtraction>> SUBFOLDERS = List.of(
            new Pair<String, IExtraction>("creaturegroups", CreatureGroupsExtraction::extract),
            new Pair<String, IExtraction>("creatures",      CreaturesExtraction::extract),
            new Pair<String, IExtraction>("creaturetypes",  CreatureTypesExtraction::extract),
            new Pair<String, IExtraction>("elements",       ElementsExtraction::extract),
            new Pair<String, IExtraction>("equipment",      EquipmentExtraction::extract),
            new Pair<String, IExtraction>("items",          ItemsExtraction::extract),
            new Pair<String, IExtraction>("mobevents",      MobeventsExtraction::extract),
            new Pair<String, IExtraction>("projectiles",    ProjectilesExtraction::extract)
    );

    public static final @Nullable String LM_A_PATH = Config.LM_A_PATH.get();
    public static final String LM_B_PATH = "C:\\generated-lycanites-mobs-documents";

    // Capitalize the first letter of a string
    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
