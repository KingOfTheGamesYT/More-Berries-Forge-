package moreberries.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class BaseConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON;

    public BaseConfig() {
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        CommentedFileConfig configData = (CommentedFileConfig)CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        config.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(ModConfig.Loading configEvent) {
    }

    @SubscribeEvent
    public static void onReload(ModConfig.Reloading configEvent) {
    }

    static {
        MoreBerriesConfig.COMMON(COMMON_BUILDER);
        COMMON = COMMON_BUILDER.build();
    }
}
