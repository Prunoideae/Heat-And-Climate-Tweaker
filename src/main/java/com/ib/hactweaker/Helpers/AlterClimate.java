package com.ib.hactweaker.Helpers;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.climate.IClimate;

public class AlterClimate implements IClimate {
    private final int heat;
    private final int humid;
    private final int air;

    public AlterClimate(int heat, int humid, int air){
        this.air = air;
        this.heat = heat;
        this.humid = humid;
    }

    @Override
    public DCHeatTier getHeat() {
        return null;
    }

    @Override
    public DCHumidity getHumidity() {
        return null;
    }

    @Override
    public DCAirflow getAirflow() {
        return null;
    }

    @Override
    public int getClimateInt() {
        return 0;
    }
}
