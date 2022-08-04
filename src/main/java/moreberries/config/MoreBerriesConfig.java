package moreberries.config;

import moreberries.BiomeDictionaryHelper;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

import static net.minecraft.world.biome.Biomes.BIRCH_FOREST;
import static net.minecraft.world.biome.Biomes.TALL_BIRCH_FOREST;
import static net.minecraftforge.common.BiomeDictionary.Type.*;


public class MoreBerriesConfig {
    public static ForgeConfigSpec.IntValue blackBerrySpawnChance;
    public static ForgeConfigSpec.IntValue blueBerrySpawnChance;
    public static ForgeConfigSpec.IntValue greenBerrySpawnChance;
    public static ForgeConfigSpec.IntValue orangeBerrySpawnChance;
    public static ForgeConfigSpec.IntValue purpleBerrySpawnChance;
    public static ForgeConfigSpec.IntValue yellowBerrySpawnChance;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> blackBerrySpawnBiomes;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> blueBerrySpawnBiomes;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> greenBerrySpawnBiomes;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> orangeBerrySpawnBiomes;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> purpleBerrySpawnBiomes;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> yellowBerrySpawnBiomes;
    public static ForgeConfigSpec.BooleanValue craftableBerryBushes;
    public static ForgeConfigSpec.BooleanValue replaceSweetBerryBushModel;

    public MoreBerriesConfig() {
    }

    public static void COMMON(ForgeConfigSpec.Builder builder) {
        builder.comment("Spawn Chances");
        builder.comment("Configure Berry bush spawn weight (How frequently they spawn. Set weight to 0 to disable.");
        builder.push("Berry Bush Spawn Chances");
        blackBerrySpawnChance = builder.defineInRange("Black Berry Spawn Chance", 16, 0, 640);
        blueBerrySpawnChance = builder.defineInRange("Blue Berry Spawn Chance", 16, 0, 640);
        greenBerrySpawnChance = builder.defineInRange("Green Berry Spawn Chance", 16, 0, 640);
        orangeBerrySpawnChance = builder.defineInRange("Orange Berry Spawn Chance", 16, 0, 640);
        purpleBerrySpawnChance = builder.defineInRange("Purple Berry Spawn Chance", 16, 0, 640);
        yellowBerrySpawnChance = builder.defineInRange("Yellow Berry Spawn Chance", 16, 0, 640);
        builder.pop();

        builder.comment("Berry Bush Spawnable Biomes");
        builder.push("Berry Bush Biomes Whitelist/Blacklist");
        blackBerrySpawnBiomes = builder.defineList("include Black Berry Bush", Arrays.asList(PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        blueBerrySpawnBiomes = builder.defineList("include Blue Berry Bush", Arrays.asList(FOREST.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        greenBerrySpawnBiomes = builder.defineList("include Green Berry Bush", Arrays.asList(JUNGLE.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        orangeBerrySpawnBiomes = builder.defineList("include Orange Berry Bush", Arrays.asList(MESA.toString(), SAVANNA.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        purpleBerrySpawnBiomes = builder.defineList("include Purple Berry Bush", Arrays.asList(SWAMP.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        yellowBerrySpawnBiomes = builder.defineList("include Yellow Berry Bush", Arrays.asList(BIRCH_FOREST.toString(), TALL_BIRCH_FOREST.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        builder.pop();

        builder.comment("Craftable Berry Bush");
        builder.push("Decide weather or not the Berry Bushes are craftable");
        craftableBerryBushes = builder.define("include Black Berry Bush", false);
        builder.pop();

        builder.comment("Replace Sweet Berry Bush Model");
        builder.push("Decide weather or not the Sweet Berry Bushes have a cube model");
        replaceSweetBerryBushModel = builder.define("include Black Berry Bush", true);
        builder.pop();
    }

}
