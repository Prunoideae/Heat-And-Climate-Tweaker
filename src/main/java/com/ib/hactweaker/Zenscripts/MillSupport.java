package com.ib.hactweaker.Zenscripts;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.climate.recipe.MillRecipe;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.value.IAny;

import java.util.Arrays;

import static com.ib.hactweaker.HACTweaker.logger;

@ZenClass("mods.hac.Mill")
@ZenRegister
public final class MillSupport {

    @ZenMethod
    public static void addRecipe(IIngredient input, IItemStack output1, IItemStack output2, float c2){
        MillAction newrecipe = new MillAction(input, output1, output2, c2);
        newrecipe.apply();
    }

    private static final class MillAction implements IAction{
        private final ItemStack[] input;
        private final ItemStack output1;
        private final ItemStack output2;
        private final float c2;

        MillAction(IIngredient input, IItemStack output1, IItemStack output2, float c2){
            this.input = CraftTweakerMC.getIngredient(input).getMatchingStacks();
            this.output1 = CraftTweakerMC.getItemStack(output1);
            this.output2 = CraftTweakerMC.getItemStack(output2);
            this.c2 = c2;
        }

        @Override
        public void apply() {
            MillRecipe recipe = new MillRecipe(output1, output1, c2, Arrays.asList(input));
            RecipeAPI.registerMills.addRecipe(recipe);
        }

        @Override
        public String describe() {
            return null;
        }
    }
}
