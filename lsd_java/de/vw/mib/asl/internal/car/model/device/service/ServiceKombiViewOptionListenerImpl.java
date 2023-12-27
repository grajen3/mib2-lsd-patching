/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.service;

import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.kombi.SIAViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDevice;

public class ServiceKombiViewOptionListenerImpl
extends KombiViewOptionAdapter {
    private ServiceDevice viewOptionsDevice;

    public ServiceKombiViewOptionListenerImpl(ServiceDevice serviceDevice) {
        this.viewOptionsDevice = serviceDevice;
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptionsData sIAViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingService(2, sIAViewOptionsData.getServiceData(), n);
        this.viewOptionsDevice.addMappingService(3, sIAViewOptionsData.getOilInspection(), n);
        this.viewOptionsDevice.addMappingService(4, sIAViewOptionsData.getReset(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateSIADevice(int n) {
        this.viewOptionsDevice.addMappingService(2, n);
        this.viewOptionsDevice.addMappingService(3, n);
        this.viewOptionsDevice.addMappingService(4, n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateBCViewOptions(BCViewOptionsData bCViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingTires(3, bCViewOptionsData.getSpeedWarning(), n);
        this.viewOptionsDevice.addMappingTires(4, bCViewOptionsData.getSpeedWarning(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateBCDevice(int n) {
        this.viewOptionsDevice.addMappingTires(3, n);
        this.viewOptionsDevice.addMappingTires(4, n);
        this.viewOptionsDevice.updateModel();
    }
}

