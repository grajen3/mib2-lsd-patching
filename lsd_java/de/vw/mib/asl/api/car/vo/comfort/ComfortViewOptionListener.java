/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.comfort;

import de.vw.mib.asl.api.car.vo.comfort.BrakeViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.DoorLockingViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.MirrorViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.RDKViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.RGSViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.UGDOViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.WiperViewOptionsData;

public interface ComfortViewOptionListener {
    default public void updateRGSViewOptions(RGSViewOptionsData rGSViewOptionsData, int n) {
    }

    default public void updateMirrorViewOptions(MirrorViewOptionsData mirrorViewOptionsData, int n) {
    }

    default public void updateRDKViewOptions(RDKViewOptionsData rDKViewOptionsData, int n) {
    }

    default public void updateWiperViewOptions(WiperViewOptionsData wiperViewOptionsData, int n) {
    }

    default public void updateDoorLockingViewOptions(DoorLockingViewOptionsData doorLockingViewOptionsData, int n) {
    }

    default public void updateUGDOViewOptions(UGDOViewOptionsData uGDOViewOptionsData, int n) {
    }

    default public void updateBrakeViewOptions(BrakeViewOptionsData brakeViewOptionsData, int n) {
    }

    default public void updatePersonalizationConfiguration(boolean bl) {
    }

    default public void updateRGSDevice(int n) {
    }

    default public void updateMirrorDevice(int n) {
    }

    default public void updateRDKDevice(int n) {
    }

    default public void updateWiperDevice(int n) {
    }

    default public void updateDoorLockingDevice(int n) {
    }

    default public void updateUGDODevice(int n) {
    }

    default public void updateBrakeDevice(int n) {
    }
}

