/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.eco;

import de.vw.mib.asl.api.car.vo.eco.EAViewOptionsData;
import de.vw.mib.asl.api.car.vo.eco.StartStopViewOptionsData;

public interface EcoViewOptionListener {
    default public void updateEAViewOptions(EAViewOptionsData eAViewOptionsData, int n) {
    }

    default public void updateEADevice(int n) {
    }

    default public void updateStartStopViewOptions(StartStopViewOptionsData startStopViewOptionsData, int n) {
    }

    default public void updateStartStopDevice(int n) {
    }
}

