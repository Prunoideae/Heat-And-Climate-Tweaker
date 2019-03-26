package com.ib.hactweaker.Zenscripts;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import defeatedcrow.hac.core.climate.recipe.CrusherRecipe;
import defeatedcrow.hac.api.recipe.RecipeAPI;

import java.util.Arrays;

@ZenClass("mods.hac.Crusher")
@ZenRegister
public final class CrusherSupport {

    @ZenMethod
    public static void addRecipe(IIngredient input, IItemStack output1, IItemStack output2, IItemStack output3, float c1, float c2, float c3, IItemStack cata, ILiquidStack fluid){
        CrusherAction newrecipe = new CrusherAction(input, output1, output2, output3, c1, c2, c3, cata, fluid);
        newrecipe.apply();

    }

    private static final class CrusherAction implements IAction{
        private final ItemStack output1;
        private final ItemStack output2;
        private final ItemStack output3;

        private final float c1;
        private final float c2;
        private final float c3;

        private final ItemStack[] input;

        private final ItemStack cata;

        private final FluidStack liquid;

        CrusherAction(IIngredient input, IItemStack output1, IItemStack output2, IItemStack output3, float c1, float c2, float c3, IItemStack cata, ILiquidStack fluid){
            this.output1 = CraftTweakerMC.getItemStack(output1);
            this.output2 = CraftTweakerMC.getItemStack(output2);
            this.output3 = CraftTweakerMC.getItemStack(output3);

            this.c1 = c1;
            this.c2 = c2;
            this.c3 = c3;

            this.input = CraftTweakerMC.getIngredient(input).getMatchingStacks();

            this.cata = CraftTweakerMC.getItemStack(cata);
            this.liquid = CraftTweakerMC.getLiquidStack(fluid);
        }

        @Override
        public void apply() {
            CrusherRecipe recipe = new CrusherRecipe(output1, c1, output2, c2, output3, c3, liquid, cata, Arrays.asList(input));
            RecipeAPI.registerCrushers.addRecipe(recipe);
        }

        @Override
        public String describe() {
            return null;
        }
    }
}
