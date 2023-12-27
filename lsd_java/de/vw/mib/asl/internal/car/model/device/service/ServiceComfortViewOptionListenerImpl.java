/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.service;

import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.RDKViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDevice;

public class ServiceComfortViewOptionListenerImpl
extends ComfortViewOptionAdapter {
    private ServiceDevice viewOptionsDevice;

    public ServiceComfortViewOptionListenerImpl(ServiceDevice serviceDevice) {
        this.viewOptionsDevice = serviceDevice;
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptionsData rDKViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingTires(5, rDKViewOptionsData.getTirePressureDisplay(), n);
        this.viewOptionsDevice.addMappingTires(1, rDKViewOptionsData.getTirePressureLevel(), n);
        this.viewOptionsDevice.addMappingTires(0, rDKViewOptionsData.getRKASetCalibrate(), n);
        this.viewOptionsDevice.addMappingTires(2, rDKViewOptionsData.getTireType(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateRDKDevice(int n) {
        this.viewOptionsDevice.addMappingTires(5, n);
        this.viewOptionsDevice.addMappingTires(1, n);
        this.viewOptionsDevice.addMappingTires(0, n);
        this.viewOptionsDevice.addMappingTires(2, n);
        this.viewOptionsDevice.updateModel();
    }
}

