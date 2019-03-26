package com.ib.hactweaker.Zenscripts;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.climate.recipe.FluidCraftRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import scala.actors.threadpool.Arrays;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

public class FluidPrimer {
    private List<Object> inputs = new ArrayList<>();
    private ItemStack output;
    private ItemStack second;
    private float chance=0;
    private boolean cooling=false;
    private FluidStack fluidInput;
    private FluidStack fluidOutput;
    private List<DCHeatTier> heatTier = new ArrayList<>();
    private List<DCAirflow> airflow = new ArrayList<>();
    private List<DCHumidity> humidity = new ArrayList<>();

    @ZenMethod
    public void addInput(Object input){
        inputs.add(input);
    }

    @ZenMethod
    public void setOutput(IItemStack output){
        this.output = CraftTweakerMC.getItemStack(output);
    }

    @ZenMethod
    public void setSecondary(IItemStack output){
        this.second = CraftTweakerMC.getItemStack(output);
    }

    @ZenMethod
    public void setChance(float chance){
        this.chance = chance;
    }

    @ZenMethod
    public void setCooling(boolean cooling){
        this.cooling = cooling;
    }
    @ZenMethod
    public void setFluidInput(ILiquidStack liquid){
        fluidInput = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void setFluidOutput(ILiquidStack liquid){
        fluidOutput = CraftTweakerMC.getLiquidStack(liquid);
    }

    @ZenMethod
    public void addHeatTier(int heatTier){
        this.heatTier.add(DCHeatTier.getHeatEnum(heatTier));
    }

    @ZenMethod
    public void addAirflow(int flowtype){
        airflow.add(DCAirflow.getTypeByID(flowtype));
    }

    @ZenMethod
    public void addHumidity(int humtype){
        humidity.add(DCHumidity.getTypeByID(humtype));
    }

    @ZenMethod
    public void ignite(){
        FluidCraftRecipe recipe = new FluidCraftRecipe(output, second, fluidOutput, null, null, null, chance,cooling, fluidInput, inputs.toArray());
        if (!heatTier.isEmpty()){
            for (DCHeatTier h : heatTier){
                recipe.requiredHeat().add(h);
            }
        }
        if (!humidity.isEmpty()){
            for (DCHumidity u : humidity){
                recipe.requiredHum().add(u);
            }
        }
        if (!airflow.isEmpty()){
           for (DCAirflow a : airflow){
               recipe.requiredAir().add(a);
           }
        }
        RecipeAPI.registerFluidRecipes.addRecipe(recipe);
    }
}
