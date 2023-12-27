/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.hud;

import de.vw.mib.asl.api.car.vo.kombi.HUDViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.hud.HUDDevice;

public class HUDViewOptionListenerImpl
extends KombiViewOptionAdapter {
    private HUDDevice viewOptionsDevice;

    public HUDViewOptionListenerImpl(HUDDevice hUDDevice) {
        this.viewOptionsDevice = hUDDevice;
    }

    @Override
    public void updateHUDViewOptions(HUDViewOptionsData hUDViewOptionsData, int n) {
        this.viewOptionsDevice.addMapping(0, hUDViewOptionsData.getBrightness(), n);
        this.viewOptionsDevice.addMapping(1, hUDViewOptionsData.getSpeed(), n);
        this.viewOptionsDevice.addMapping(2, hUDViewOptionsData.getWarning(), n);
        this.viewOptionsDevice.addMapping(3, hUDViewOptionsData.getAcc(), n);
        this.viewOptionsDevice.addMapping(4, hUDViewOptionsData.getNightvision(), n);
        this.viewOptionsDevice.addMapping(5, hUDViewOptionsData.getRoadsign(), n);
        this.viewOptionsDevice.addMapping(6, hUDViewOptionsData.getRgi(), n);
        this.viewOptionsDevice.addMapping(7, hUDViewOptionsData.getNavInfo(), n);
        this.viewOptionsDevice.addMapping(8, hUDViewOptionsData.getInfoList(), n);
        this.viewOptionsDevice.addMapping(9, hUDViewOptionsData.getHca(), n);
        this.viewOptionsDevice.addMapping(10, hUDViewOptionsData.getGra(), n);
        this.viewOptionsDevice.addMapping(11, hUDViewOptionsData.getTelephone(), n);
        this.viewOptionsDevice.addMapping(12, hUDViewOptionsData.getColour(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateHUDDevice(int n) {
        this.viewOptionsDevice.addMapping(0, n);
        this.viewOptionsDevice.addMapping(1, n);
        this.viewOptionsDevice.addMapping(2, n);
        this.viewOptionsDevice.addMapping(3, n);
        this.viewOptionsDevice.addMapping(4, n);
        this.viewOptionsDevice.addMapping(5, n);
        this.viewOptionsDevice.addMapping(6, n);
        this.viewOptionsDevice.addMapping(7, n);
        this.viewOptionsDevice.addMapping(8, n);
        this.viewOptionsDevice.addMapping(9, n);
        this.viewOptionsDevice.addMapping(10, n);
        this.viewOptionsDevice.addMapping(11, n);
        this.viewOptionsDevice.addMapping(12, n);
        this.viewOptionsDevice.updateModel();
    }
}

