package com.extract.extractlmjson;

import com.extract.extractlmjson.configuration.Config;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtractLMJson.MODID)
public class ExtractLMJson
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "extractlmjson";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExtractLMJson(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        Config.register();
    }
}
