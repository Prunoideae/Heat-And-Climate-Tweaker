package com.ib.hactweaker.Zenscripts;

import com.ib.hactweaker.Helpers.AlterClimate;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.hac.Smelting")
@ZenRegister
public final class SmeltingSupport {

    @ZenMethod
    public static SmeltingPrimer newRecipe(){
        return new SmeltingPrimer();
    }

    @ZenMethod
    public static void removeRecipe(IItemStack input, int heat, int air, int humid){
        AlterClimate climate = new AlterClimate(heat,humid,air);
        RecipeAPI.registerSmelting.removeRecipe(climate, CraftTweakerMC.getItemStack(input));
    }
}
