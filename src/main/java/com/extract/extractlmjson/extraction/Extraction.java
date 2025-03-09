package com.extract.extractlmjson.extraction;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static com.extract.extractlmjson.ExtractLMJson.LOGGER;
import static com.extract.extractlmjson.file_io.Utils.*;

public class Extraction {
    public static void extract() throws IOException {
        LOGGER.info("Extracting LM JSON files to MD files...");
        for (final var SUBFOLDER_NAME : SUBFOLDERS) {
            File subfolderA = getFolder(LM_A_PATH + "\\" + SUBFOLDER_NAME.getFirst());
            @Nonnull File[] filesA = Objects.requireNonNull(subfolderA.listFiles());
            File subfolderB = getFolder(LM_B_PATH + "\\" + SUBFOLDER_NAME.getFirst());

            for (var fileA : filesA) {
                if (isntJson(fileA)) { continue; }
                File fileB = getMDFiles(subfolderB, fileA);
                ConvertAToB(fileA, fileB, SUBFOLDER_NAME.getSecond());
            }
        }
    }

    private static File getFolder(String fullPath) throws IOException {
        Files.createDirectories(Path.of(fullPath));
        return new File(fullPath);
    }

    private static File getMDFiles(File subfolder, File file) throws IOException {
        String fullPathString = subfolder.toPath() + "\\" + file.getName().replace(".json", ".md");
        Path fullPath = Path.of(fullPathString);
        if (Files.exists(fullPath)) Files.delete(fullPath);
        Files.createFile(fullPath);
        return new File(fullPathString);
    }

    private static boolean isntJson(File file) {
        return !file.isFile() || !file.getName().endsWith(".json");
    }

    private static void ConvertAToB(File fileA, File fileB, IExtraction iExtraction) throws IOException {
        // Get a File Reader from fileA
        try (Reader reader = Files.newBufferedReader(fileA.toPath())) {
            // Get Json Element from fileA
            JsonElement masterElement = JsonParser.parseReader(reader);
            // Convert Json Element to Markdown (Write to fileB DIRECTLY)
            try (var writer = Files.newBufferedWriter(fileB.toPath())) {
                LOGGER.debug("Extracting to the file: {}, Abs. path: {}", fileB.getPath(), fileB.getAbsolutePath());
                iExtraction.apply(writer, masterElement.getAsJsonObject());
            }
        }
    }
}
