/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm.states;

import de.vw.mib.asl.internal.car.dm.DeviceManager;
import de.vw.mib.asl.internal.car.dm.states.VehicleState;

public class VehicleStateNormal
extends VehicleState {
    public VehicleStateNormal(DeviceManager deviceManager) {
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
        }
    }

    @Override
    public void onStandstill(boolean bl) {
        if (!bl) {
            this.trans(this.dm.getStateMoving());
        }
    }

    @Override
    public void onSpeed(boolean bl) {
        if (bl) {
            this.trans(this.dm.getStateSpeed());
        }
    }
}

