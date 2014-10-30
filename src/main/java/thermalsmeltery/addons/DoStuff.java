package thermalsmeltery.addons;

import mantle.pulsar.pulse.Handler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.TConstruct;
import tconstruct.plugins.te4.TE4Helper;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;

public class DoStuff {
	
	public static int RFMultiplier = 24;
	
	// We need to declare ore as a static field (public, in case you access it elsewhere
	// this puts it in the whole class's scope
	// I'm going to go ahead and leave these comments in because I'm still a n00b at this.
	public static ItemStack ironOre;
	public static ItemStack ironNugget; 
	
	@Handler
    public static void init () {
		letsGetCooking();
		// If we declared it here, when the method finishes, it falls out of scope
		ironOre = OreDictionary.getOres("oreIron").get(0).copy(); // Then we set a value
		ironOre.stackSize = 1;
		
		
		/*
		
		This causes Java to throw a fit, because Java is going to throw a fit
		whenever there is a mention of "nuggetIron" because it's not implemented
		even thought this is a check to see if it's implemented or not. 
		
		if (!OreDictionary.getOres("nuggetIron").isEmpty()) {
			//ironNugget = OreDictionary.getOres("nuggetIron").get(0).copy();
			//ironNugget.stackSize = 1;
		}*/
		
	}
	
	private static void letsGetCooking() {
		//Max RF value for Induction Smelter is 1,200,000. It takes 4000 RF to pulverize an ore.
		
		// Ingot
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.ingotLiquidValue, new ItemStack(Items.iron_ingot, 1), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.ingotLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.ingotLiquidValue, new ItemStack(Items.gold_ingot, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.ingotLiquidValue));
		
		// Ore
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.oreLiquidValue, ironOre, new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.oreLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.oreLiquidValue, new ItemStack(Blocks.gold_ore, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.oreLiquidValue));
		
		// Block
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.blockLiquidValue, new ItemStack(Blocks.iron_block, 1), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.blockLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.blockLiquidValue, new ItemStack(Blocks.gold_block, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.blockLiquidValue));
		
		// Chunk
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.chunkLiquidValue, new ItemStack(TinkerTools.toolShard, 1, TinkerTools.MaterialID.Iron), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.chunkLiquidValue));
		// No gold chunks
		
		// Nugget
		/*
		
		Disabled for now
		
		if (!OreDictionary.getOres("nuggetIron").isEmpty()) {
			TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.nuggetLiquidValue, ironNugget, new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.nuggetLiquidValue));
		} */
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.nuggetLiquidValue, new ItemStack(Items.gold_nugget, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.nuggetLiquidValue));

		
		
	}
	
	
}
