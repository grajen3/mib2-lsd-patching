/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.drivingcharacteristics;

import de.vw.mib.asl.api.car.vo.drivingcharacteristics.SuspensionControlViewOptionsData;

public interface DrivingCharacteristicsViewOptionListener {
    default public void updateSuspensionControlViewOptions(SuspensionControlViewOptionsData suspensionControlViewOptionsData, int n) {
    }

    default public void updateSuspensionControlDevice(int n) {
    }
}

