/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm.states;

import de.vw.mib.asl.internal.car.dm.DeviceManager;
import de.vw.mib.asl.internal.car.dm.states.VehicleState;

public class VehicleStateMoving
extends VehicleState {
    public VehicleStateMoving(DeviceManager deviceManager) {
        super(deviceManager);
    }

    @Override
    public void onEntry() {
        this.dm.notify(this.dm.getStandStillDevices(), 13);
        if (!this.dm.isMoving()) {
            this.onStandstill(true);
        }
    }

    @Override
    public void onExit() {
    }

    @Override
    public void onStandstill(boolean bl) {
        if (bl) {
            this.dm.notify(this.dm.getStandStillDevices(), 0);
            this.trans(this.dm.getStateNormal());
        }
    }

    @Override
    public void onClamp15(boolean bl) {
        if (!bl) {
            this.trans(this.dm.getStateClamp15());
        }
    }

    @Override
    public void onSpeed(boolean bl) {
        if (bl) {
            this.trans(this.dm.getStateSpeed());
        }
    }
}

