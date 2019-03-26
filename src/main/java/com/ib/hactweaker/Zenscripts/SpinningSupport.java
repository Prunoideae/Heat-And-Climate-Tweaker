package com.ib.hactweaker.Zenscripts;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.climate.recipe.SpinningRecipe;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;

@ZenClass("mods.hac.Spinning")
@ZenRegister
public final class SpinningSupport {
    @ZenMethod
    public static void addRecipe(IIngredient input, int count, IItemStack output){
        SpinAction newrecipe = new SpinAction(input,count,output);
        newrecipe.apply();
    }

    private static final class SpinAction implements IAction{
        private final ItemStack[] input;
        private final int count;
        private final ItemStack output;

        SpinAction(IIngredient input, int count, IItemStack output){
            ItemStack[] unmounted = CraftTweakerMC.getIngredient(input).getMatchingStacks();
            for (ItemStack i:unmounted){
                i.setCount(input.getAmount());
            }
            this.input=unmounted;
            this.count=count;
            this.output=CraftTweakerMC.getItemStack(output);
        }

        @Override
        public void apply() {
            SpinningRecipe recipe = new SpinningRecipe(output, count, Arrays.asList(input));
            RecipeAPI.registerSpinningRecipes.addRecipe(recipe);
        }

        @Override
        public String describe() {
            return null;
        }
    }
}
