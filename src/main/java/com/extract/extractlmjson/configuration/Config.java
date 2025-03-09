package com.extract.extractlmjson.configuration;

import com.extract.extractlmjson.ExtractLMJson;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import javax.annotation.Nullable;

// TODO: Add The Function That Avoids Overwriting The Config File When It's Modified.
public class Config {

    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_CONFIG;

    // 定义配置项
    public static ForgeConfigSpec.ConfigValue<String> LYCANITES_MOBS_RESOURCE_PATH;

    public static void register() {
        // 注册客户端配置
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    @Nullable
    public static String getLMResourcePackPath() {
        String resourcePath = Config.LYCANITES_MOBS_RESOURCE_PATH.get();

        if (resourcePath == null) {
            ExtractLMJson.LOGGER.warn("Lycanites Mobs resource pack path is not set!");
            return null;
        }
        return resourcePath;
    }

    static {
        CLIENT_BUILDER.comment("General settings")
                .push("general");

        // 定义资源包路径配置项
        LYCANITES_MOBS_RESOURCE_PATH = CLIENT_BUILDER
                .comment("Path to the Lycanites Mobs resource pack")
                .define("lycanites_mobs_resource_path",
                        "");

        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
