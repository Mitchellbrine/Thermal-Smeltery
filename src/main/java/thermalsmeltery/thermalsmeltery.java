package thermalsmeltery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import thermalsmeltery.addons.DoStuff;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "thermalsmeltery", name = "Thermal Smeltery", version = "1.7.10.1A", dependencies = "required-after:ThermalExpansion;required-after:TConstruct")
public class thermalsmeltery {
	
	public static final String modID = "Thermal Smeltery";
	public static final Logger logger = LogManager.getLogger(modID);
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		DoStuff.init();
		
		
		if (Loader.isModLoaded("Natura"))
        {
            logger.info("Hey guys! Can I join in on the fun too?"); 
        }
        else
        {
        	logger.info("Yeah mDiyo, yeah science!");
        }
	}

}
