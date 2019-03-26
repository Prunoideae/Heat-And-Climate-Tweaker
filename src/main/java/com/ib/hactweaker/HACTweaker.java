package com.ib.hactweaker;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = HACTweaker.MODID, name = HACTweaker.NAME, version = HACTweaker.VERSION, dependencies = "required-after:crafttweaker;required-after:dcs_climate")
public class HACTweaker
{
    public static final String MODID = "hactweaker";
    public static final String NAME = "Heat&Climate Tweaker";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    { }
}
