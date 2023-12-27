/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm.states;

import de.vw.mib.asl.internal.car.dm.DeviceManager;
import de.vw.mib.asl.internal.car.dm.states.VehicleState;

public class VehicleStateUnknown
extends VehicleState {
    public VehicleStateUnknown(DeviceManager deviceManager) {
        super(deviceManager);
    }

    @Override
    public void onEntry() {
    }

    @Override
    public void onExit() {
    }

    @Override
    public void onClamp15(boolean bl) {
        if (!bl) {
            this.trans(this.dm.getStateClamp15());
        } else if (this.dm.getSpeedTooHigh() == 1) {
            this.trans(this.dm.getStateSpeed());
        } else if (this.dm.getStandstill() == 0) {
            this.trans(this.dm.getStateMoving());
        } else {
            this.dm.notify(this.dm.getAllCodedDevices(), 14);
            this.trans(this.dm.getStateNormal());
        }
    }
}

