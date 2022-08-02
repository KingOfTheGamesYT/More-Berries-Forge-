package moreberries;
;
import moreberries.config.BaseConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;


@Mod("moreberries")
public class MoreBerries {

		public static final String MOD_ID = "moreberries";
	//	public static final ItemGroup TAB = new DangerZoneItems();


		public MoreBerries() {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BaseConfig.COMMON, "moreberries-common.toml");
			BaseConfig.loadConfig(BaseConfig.COMMON, FMLPaths.CONFIGDIR.get().resolve("moreberries-common.toml").toString());

			FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
			FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
			final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
			modEventBus.addListener(this::setup);

			MinecraftForge.EVENT_BUS.register(this);

		}

		private void setup(final FMLCommonSetupEvent event) {

		}
		private void doClientStuff(final FMLClientSetupEvent event) {

		}
}



