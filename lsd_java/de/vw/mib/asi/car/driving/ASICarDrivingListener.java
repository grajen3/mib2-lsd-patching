/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.driving;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.vw.mib.asi.ASIListener;

public interface ASICarDrivingListener
extends ASIListener {
    default public void updateDriveSelectActiveProfile(int n, boolean bl) {
    }

    default public void updateDriveSelectActiveProfileVisibilityState(int n, boolean bl) {
    }

    default public void updateSuspensionControlCurrentLevel(int n, boolean bl) {
    }

    default public void updateSuspensionControlTargetLevel(int n, boolean bl) {
    }

    default public void updateSuspensionVisibilityState(int[] nArray, boolean bl) {
    }

    default public void updateTADConfiguration(TADConfiguration tADConfiguration, boolean bl) {
    }

    default public void updateTADCurrentPitchAngle(float f2, boolean bl) {
    }

    default public void updateTADCurrentRollAngle(float f2, boolean bl) {
    }

    default public void updateTADNegMaxPitch(float f2, boolean bl) {
    }

    default public void updateTADNegMaxRollAngle(float f2, boolean bl) {
    }

    default public void updateTADPosMaxPitch(float f2, boolean bl) {
    }

    default public void updateTADPosMaxRollAngle(float f2, boolean bl) {
    }

    default public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, boolean bl) {
    }

    default public void updateTADVisibilityState(int n, boolean bl) {
    }
}

