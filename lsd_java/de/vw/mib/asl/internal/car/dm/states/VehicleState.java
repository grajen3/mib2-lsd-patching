/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm.states;

import de.vw.mib.asl.internal.car.dm.DeviceManager;

public abstract class VehicleState {
    protected DeviceManager dm;

    public VehicleState(DeviceManager deviceManager) {
        this.dm = deviceManager;
    }

    public abstract void onEntry() {
    }

    public abstract void onExit() {
    }

    public void onClamp15(boolean bl) {
    }

    public void onStandstill(boolean bl) {
    }

    public void onSpeed(boolean bl) {
    }

    protected void trans(VehicleState vehicleState) {
        this.dm.setState(vehicleState);
    }
}

