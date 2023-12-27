/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.drvass;

import de.vw.mib.asl.api.car.vo.drvass.ACCViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.AWVViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.LdwhcaViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.MKEViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.NVViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.PAViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.SWAViewOptionsData;
import de.vw.mib.asl.api.car.vo.drvass.TSDViewOptionsData;

public interface DriverAssistanceViewOptionListener {
    default public void updateACCViewOptions(ACCViewOptionsData aCCViewOptionsData, int n) {
    }

    default public void updateSWAViewOptions(SWAViewOptionsData sWAViewOptionsData, int n) {
    }

    default public void updateAWVViewOptions(AWVViewOptionsData aWVViewOptionsData, int n) {
    }

    default public void updateLDWHCAViewOptions(LdwhcaViewOptionsData ldwhcaViewOptionsData, int n) {
    }

    default public void updateTSDViewOptions(TSDViewOptionsData tSDViewOptionsData, int n) {
    }

    default public void updateNVViewOptions(NVViewOptionsData nVViewOptionsData, int n) {
    }

    default public void updateMKEViewOptions(MKEViewOptionsData mKEViewOptionsData, int n) {
    }

    default public void updatePAViewOptions(PAViewOptionsData pAViewOptionsData, int n) {
    }

    default public void updateACCDevice(int n) {
    }

    default public void updateSWADevice(int n) {
    }

    default public void updateAWVDevice(int n) {
    }

    default public void updateLDWHCADevice(int n) {
    }

    default public void updateTSDDevice(int n) {
    }

    default public void updateNVDevice(int n) {
    }

    default public void updateMKEDevice(int n) {
    }

    default public void updatePADevice(int n) {
    }
}

