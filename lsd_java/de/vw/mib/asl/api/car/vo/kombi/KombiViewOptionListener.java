/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.kombi;

import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.DCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.HUDViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.SIAViewOptionsData;

public interface KombiViewOptionListener {
    default public void updateSIAViewOptions(SIAViewOptionsData sIAViewOptionsData, int n) {
    }

    default public void updateBCViewOptions(BCViewOptionsData bCViewOptionsData, int n) {
    }

    default public void updateHUDViewOptions(HUDViewOptionsData hUDViewOptionsData, int n) {
    }

    default public void updateDCViewOptions(DCViewOptionsData dCViewOptionsData, int n) {
    }

    default public void updateSIADevice(int n) {
    }

    default public void updateBCDevice(int n) {
    }

    default public void updateHUDDevice(int n) {
    }
}

