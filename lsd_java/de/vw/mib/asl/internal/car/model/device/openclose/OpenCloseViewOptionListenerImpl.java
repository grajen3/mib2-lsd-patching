/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.openclose;

import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.DoorLockingViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.UGDOViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.WiperViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.openclose.OpenCloseDevice;

public class OpenCloseViewOptionListenerImpl
extends ComfortViewOptionAdapter {
    private OpenCloseDevice device;

    public OpenCloseViewOptionListenerImpl(OpenCloseDevice openCloseDevice) {
        this.device = openCloseDevice;
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptionsData doorLockingViewOptionsData, int n) {
        this.device.addMapping(0, doorLockingViewOptionsData.getComfortOpen(), n);
        this.device.addMapping(1, doorLockingViewOptionsData.getRainClosing(), n);
        this.device.addMapping(2, doorLockingViewOptionsData.getWindowAutoClose(), n);
        this.device.addMapping(3, doorLockingViewOptionsData.getUnlockingMode(), n);
        this.device.addMapping(4, doorLockingViewOptionsData.getAutoLock(), n);
        this.device.addMapping(5, doorLockingViewOptionsData.getAutoUnlock(), n);
        this.device.addMapping(6, doorLockingViewOptionsData.getBootOpen(), n);
        this.device.addMapping(8, doorLockingViewOptionsData.getBootBlind(), n);
        this.device.addMapping(9, doorLockingViewOptionsData.getLockingConfirmation(), n);
        this.device.addMapping(10, doorLockingViewOptionsData.getTheftWarning(), n);
        this.device.updateModel();
    }

    @Override
    public void updateDoorLockingDevice(int n) {
        this.device.addMapping(0, n);
        this.device.addMapping(1, n);
        this.device.addMapping(2, n);
        this.device.addMapping(3, n);
        this.device.addMapping(4, n);
        this.device.addMapping(5, n);
        this.device.addMapping(6, n);
        this.device.addMapping(8, n);
        this.device.addMapping(9, n);
        this.device.addMapping(10, n);
        this.device.updateModel();
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptionsData wiperViewOptionsData, int n) {
        this.device.addMapping(7, wiperViewOptionsData.getEasyEntrySteeringColumn(), n);
        this.device.updateModel();
    }

    @Override
    public void updateWiperDevice(int n) {
        this.device.addMapping(7, n);
        this.device.updateModel();
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptionsData uGDOViewOptionsData, int n) {
        this.device.addMapping(11, uGDOViewOptionsData.getButtonList(), n);
        this.device.addMapping(12, uGDOViewOptionsData.getDeleteButton(), n);
        this.device.addMapping(13, uGDOViewOptionsData.getVersionData(), n);
        this.device.updateModel();
    }

    @Override
    public void updateUGDODevice(int n) {
        this.device.addMapping(11, n);
        this.device.addMapping(12, n);
        this.device.addMapping(13, n);
        this.device.updateModel();
    }
}

