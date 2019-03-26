package com.ib.hactweaker.Zenscripts;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.hac.Reactor")
@ZenRegister
public final class ReactorSupport {
    @ZenMethod
    public static ReactorPrimer newRecipe(){
        return new ReactorPrimer();
    }
}
