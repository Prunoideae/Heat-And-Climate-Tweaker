package com.ib.hactweaker.Zenscripts;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.climate.recipe.ReactorRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import scala.actors.threadpool.Arrays;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

public class ReactorPrimer {
    private List<Object> inputs = new ArrayList<>();
    private ItemStack output;
    private ItemStack secondary;
    private float chance;

    private FluidStack fluidStacki1;
    private FluidStack fluidStacki2;
    private FluidStack fluidStacko1;
    private FluidStack fluidStacko2;

    private List<ItemStack> catas;
    private List<DCHeatTier> heatTiers = new ArrayList<>();

    @ZenMethod
    public void addInput(Object i){
        inputs.add(i);
    }

    @ZenMethod
    public void setOutput(IItemStack output){
        this.output = CraftTweakerMC.getItemStack(output);
    }

    @ZenMethod
    public void setSecondary(IItemStack output){
        this.secondary = CraftTweakerMC.getItemStack(output);
    }

    @ZenMethod
    public void setChance(float chance){
    this.chance = chance;
    }

    @ZenMethod
    public void setFluidI1(ILiquidStack liquid){
        fluidStacki1 = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void setFluidI2(ILiquidStack liquid){
        fluidStacki2 = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void setFluidO1(ILiquidStack liquid){
        fluidStacko1 = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void setFluidO2(ILiquidStack liquid){
        fluidStacko2 = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void setCatalyst(IItemStack[] items){
        catas = Arrays.asList(CraftTweakerMC.getItemStacks(items));
    }

    @ZenMethod
    public void addHeat(int heatTier){
        this.heatTiers.add(DCHeatTier.getHeatEnum(heatTier));
    }

    @ZenMethod
    public void ignite(){
        ReactorRecipe recipe = new ReactorRecipe(output, secondary, fluidStacko1, fluidStacko2, null, chance,catas,fluidStacki1, fluidStacki2, inputs.toArray());
        if(!heatTiers.isEmpty()){
            for (DCHeatTier h : heatTiers){
                recipe.requiredHeat().add(h);
            }
        }
        RecipeAPI.registerReactorRecipes.addRecipe(recipe);
    }
}
