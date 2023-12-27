/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm.states;

import de.vw.mib.asl.internal.car.dm.DeviceManager;
import de.vw.mib.asl.internal.car.dm.states.VehicleState;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateMoving;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateSpeed;

public class VehicleStateClamp15
extends VehicleState {
    public VehicleStateClamp15(DeviceManager deviceManager) {
        super(deviceManager);
    }

    @Override
    public void onEntry() {
        this.dm.notify(this.dm.getAllCodedDevices(), 2);
    }

    @Override
    public void onExit() {
    }

    @Override
    public void onClamp15(boolean bl) {
        if (this.dm.isNormal()) {
            this.dm.notify(this.dm.getAllCodedDevices(), 0);
            this.trans(this.dm.getStateNormal());
        } else if (this.dm.isMoving()) {
            this.dm.notify(this.dm.diffList(this.dm.getAllCodedDevices(), this.dm.getStandStillDevices()), 0);
            this.trans(this.dm.getStateMoving());
        } else if (this.dm.isSpeedTooHigh()) {
            this.dm.notify(this.dm.getNoCodingDevices(), 0);
            this.dm.notify(this.dm.getStandStillDevices(), 13);
            this.trans(this.dm.getStateSpeed());
        } else {
            this.dm.notify(this.dm.getAllCodedDevices(), 0);
            this.trans(this.dm.getStateNormal());
        }
    }

    @Override
    public void onStandstill(boolean bl) {
        if (this.dm.isMoving()) {
            this.dm.notify(this.dm.getNoCodingDevices(), 0);
            this.trans(new VehicleStateMoving(this.dm));
        }
    }

    @Override
    public void onSpeed(boolean bl) {
        if (this.dm.isSpeedTooHigh()) {
            this.dm.notify(this.dm.diffList(this.dm.diffList(this.dm.getAllCodedDevices(), this.dm.getStandStillDevices()), this.dm.getSpeedDevices()), 0);
            this.dm.notify(this.dm.getStandStillDevices(), 13);
            this.trans(new VehicleStateSpeed(this.dm));
        }
    }
}

