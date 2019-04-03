package com.ib.hactweaker.Zenscripts;

import com.ib.hactweaker.Helpers.AlterClimate;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

@ZenClass("mods.hac.FluidProcess")
@ZenRegister
public final class FluidSupport {

    @ZenMethod
    public static FluidPrimer newRecipe(){
        return new FluidPrimer();
    }

    @ZenMethod
    public static void removeRecipe(IItemStack[] inputs, ILiquidStack liquid, int heat, int air, int humid){
        List<ItemStack> processed = Arrays.asList(CraftTweakerMC.getItemStacks(inputs));
        AlterClimate climate = new AlterClimate(heat,humid,air);
        RecipeAPI.registerFluidRecipes.removeRecipe(climate,processed,CraftTweakerMC.getLiquidStack(liquid));
    }
}
