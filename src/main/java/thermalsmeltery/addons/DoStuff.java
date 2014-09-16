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
  public static ItemStack ore; // we need to declare ore as a static field (public, in case you access it elsewhere
  // this puts it in the whole class's scope
	
	@Handler
    public static void init () {
		letsGetCooking();
		// if we declared it here, when the method finishes, it falls out of scope
		ore = OreDictionary.getOres("oreIron").get(0).copy(); // then we set a value
		ore.stackSize = 1;
    }
	
	private static void letsGetCooking() {
		//Max RF value for Induction Smelter is 1,200,000. It takes 4000 RF to pulverize a ore.
		
		//Iron
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.ingotLiquidValue, new ItemStack(Items.iron_ingot, 1), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.ingotLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.oreLiquidValue, ore, new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.oreLiquidValue)); // here, the variable can be used because it is in the class scope
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.blockLiquidValue, new ItemStack(Blocks.iron_block, 1), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.blockLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.chunkLiquidValue, new ItemStack(TinkerTools.toolShard, 1, TinkerTools.MaterialID.Iron), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.chunkLiquidValue));
		//I'm just going to leave this out for now, until OreDictionary Stuff is sorted out
		//TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.nuggetLiquidValue, new ItemStack(), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.nuggetLiquidValue));
		
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.ingotLiquidValue, new ItemStack(Items.gold_ingot, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.ingotLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.oreLiquidValue, new ItemStack(Blocks.gold_ore, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.oreLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.blockLiquidValue, new ItemStack(Blocks.gold_block, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.blockLiquidValue));
		TE4Helper.addCrucibleRecipe(RFMultiplier*TConstruct.nuggetLiquidValue, new ItemStack(Items.gold_nugget, 1), new FluidStack(TinkerSmeltery.moltenGoldFluid, TConstruct.nuggetLiquidValue));

		
		
	}
	
	
}
