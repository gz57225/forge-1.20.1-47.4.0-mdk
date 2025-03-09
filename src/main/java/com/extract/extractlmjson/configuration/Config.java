package com.extract.extractlmjson.configuration;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static final ForgeConfigSpec CLIENT_CONFIG;

    // Define the config values
    public static final ForgeConfigSpec.ConfigValue<String> LM_A_PATH;

    public static void register() {
        // Register the config
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    static {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General settings")
                .push("general");

        // Register lycanites_mobs_resource_path.
        LM_A_PATH = CLIENT_BUILDER
                .comment("Path to the Lycanites Mobs resource pack")
                .define("lycanites_mobs_resource_path",
                        "default");

        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
