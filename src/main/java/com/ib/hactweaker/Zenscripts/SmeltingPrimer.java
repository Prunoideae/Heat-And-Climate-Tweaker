package com.ib.hactweaker.Zenscripts;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.climate.recipe.ClimateSmelting;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmeltingPrimer {

    private ItemStack[] inputs;
    private ItemStack output;

    private List<DCHeatTier> heatTiers = new ArrayList<>();
    private List<DCHumidity> humidities = new ArrayList<>();
    private List<DCAirflow> airflows = new ArrayList<>();

    private boolean cooling;
    private boolean asItem;

    @ZenMethod
    public void setInput(IIngredient input){
        inputs = CraftTweakerMC.getExamples(input);
    }

    @ZenMethod
    public void setOutput(IItemStack output){
        this.output = CraftTweakerMC.getItemStack(output);
    }

    @ZenMethod
    public void addTemperature(int h){
        heatTiers.add(DCHeatTier.getHeatEnum(h));
    }

    @ZenMethod
    public void addHumidity(int u){
        humidities.add(DCHumidity.getTypeByID(u));
    }

    @ZenMethod
    public void addAirflow(int a){
        airflows.add(DCAirflow.getTypeByID(a));
    }

    @ZenMethod
    public void setCooling(boolean cooling){
        this.cooling = cooling;
    }

    @ZenMethod
    public void setAsItem(boolean flag){
        this.asItem = flag;
    }

    @ZenMethod
    public void ignite(){
        ClimateSmelting recipe = new ClimateSmelting(output, null, null, null, null, 0, cooling, Arrays.asList(inputs));
        if (asItem) recipe.setProceedAsDropItem();
        if (!heatTiers.isEmpty()){
            for(DCHeatTier h:heatTiers){
                recipe.requiredHeat().add(h);
            }
        }
        if (!humidities.isEmpty()){
            for(DCHumidity u:humidities){
                recipe.requiredHum().add(u);
            }
        }
        if (!airflows.isEmpty()){
            for(DCAirflow a:airflows){
                recipe.requiredAir().add(a);
            }
        }
        RecipeAPI.registerSmelting.addRecipe(recipe);
    }
}
