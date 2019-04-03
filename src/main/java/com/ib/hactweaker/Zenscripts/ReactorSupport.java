package com.ib.hactweaker.Zenscripts;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

@ZenClass("mods.hac.Reactor")
@ZenRegister
public final class ReactorSupport {
    @ZenMethod
    public static ReactorPrimer newRecipe(){
        return new ReactorPrimer();
    }

    @ZenMethod
    public static void removeRecipe(IItemStack[] inputs, IItemStack cata, ILiquidStack liquid1, ILiquidStack liquid2, int heat){
        List<ItemStack> processed = Arrays.asList(CraftTweakerMC.getItemStacks(inputs));
        RecipeAPI.registerReactorRecipes.removeRecipe(DCHeatTier.getHeatEnum(heat), processed, CraftTweakerMC.getLiquidStack(liquid1), CraftTweakerMC.getLiquidStack(liquid2), CraftTweakerMC.getItemStack(cata));
    }
}
