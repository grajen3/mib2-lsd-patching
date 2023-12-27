/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.DoorLockingViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DoorLockingViewOptionsWrapper
implements DoorLockingViewOptionsData {
    DoorLockingViewOptions vo;
    private CarViewOptionWrapper bootBlind;

    public DoorLockingViewOptionsWrapper(DoorLockingViewOptions doorLockingViewOptions) {
        this.vo = doorLockingViewOptions;
    }

    @Override
    public CarFunctionState getComfortOpen() {
        return new CarViewOptionWrapper(this.vo.getComfortOpen());
    }

    @Override
    public CarFunctionState getRainClosing() {
        return new CarViewOptionWrapper(this.vo.getRainClosing());
    }

    @Override
    public CarFunctionState getWindowAutoClose() {
        return new CarViewOptionWrapper(this.vo.getWindowAutoClose());
    }

    @Override
    public CarFunctionState getUnlockingMode() {
        return new CarViewOptionWrapper(this.vo.getUnlockingMode());
    }

    @Override
    public CarFunctionState getAutoLock() {
        return new CarViewOptionWrapper(this.vo.getAutoLock());
    }

    @Override
    public CarFunctionState getAutoUnlock() {
        return new CarViewOptionWrapper(this.vo.getAutoUnlock());
    }

    @Override
    public CarFunctionState getBootOpen() {
        return new CarViewOptionWrapper(this.vo.getBootOpen());
    }

    @Override
    public CarFunctionState getRearBlind() {
        return new CarViewOptionWrapper(this.vo.getRearBlind());
    }

    @Override
    public CarFunctionState getLockingConfirmation() {
        return new CarViewOptionWrapper(this.vo.getLockingConfirmation());
    }

    @Override
    public CarFunctionState getTheftWarning() {
        return new CarViewOptionWrapper(this.vo.getTheftWarning());
    }

    @Override
    public CarFunctionState getUserProfileOnOff() {
        return new CarViewOptionWrapper(this.vo.getUserProfileOnOff());
    }

    @Override
    public CarFunctionState getUserList() {
        return new CarViewOptionWrapper(this.vo.getUserList());
    }

    @Override
    public CarFunctionState getUserProfileControl() {
        return new CarViewOptionWrapper(this.vo.getUserProfileControl());
    }

    @Override
    public CarFunctionState getBootBlind() {
        return this.bootBlind;
    }

    public void setBootBlind(CarViewOption carViewOption) {
        this.bootBlind = new CarViewOptionWrapper(carViewOption);
    }
}

