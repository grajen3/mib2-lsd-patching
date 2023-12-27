/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.climate;

import de.vw.mib.asl.api.car.vo.climate.AirconRowViewOptionsData;
import de.vw.mib.asl.api.car.vo.climate.AirconViewOptionsMasterData;

public interface ClimateViewOptionListener {
    default public void updateAirconViewOptionsMaster(AirconViewOptionsMasterData airconViewOptionsMasterData) {
    }

    default public void updateAirconViewOptionsMaster(AirconViewOptionsMasterData airconViewOptionsMasterData, int n) {
    }

    default public void updateAirconViewOptionsRow1(AirconRowViewOptionsData airconRowViewOptionsData, int n) {
    }

    default public void updateAirconMasterDivice(int n) {
    }

    default public void updateAirconRow1Divice(int n) {
    }
}

