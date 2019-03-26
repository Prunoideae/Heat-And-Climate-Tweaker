package com.ib.hactweaker.Zenscripts;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.hac.Smelting")
@ZenRegister
public final class SmeltingSupport {

    @ZenMethod
    public static SmeltingPrimer newRecipe(){
        return new SmeltingPrimer();
    }
}
