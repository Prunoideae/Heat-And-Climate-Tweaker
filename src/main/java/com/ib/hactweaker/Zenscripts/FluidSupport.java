package com.ib.hactweaker.Zenscripts;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.hac.FluidProcess")
@ZenRegister
public final class FluidSupport {

    @ZenMethod
    public static FluidPrimer newRecipe(){
        return new FluidPrimer();
    }
}
