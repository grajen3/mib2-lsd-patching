/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.service;

import de.vw.mib.asl.api.car.vo.drivingcharacteristics.DrivingCharacteristicsViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.SuspensionControlViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDevice;

public class ServiceDrivingCharacteristicsViewOptionListenerImpl
extends DrivingCharacteristicsViewOptionAdapter {
    private ServiceDevice viewOptionsDevice;

    public ServiceDrivingCharacteristicsViewOptionListenerImpl(ServiceDevice serviceDevice) {
        this.viewOptionsDevice = serviceDevice;
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptionsData suspensionControlViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingService(1, suspensionControlViewOptionsData.getCarJackMode(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateSuspensionControlDevice(int n) {
        this.viewOptionsDevice.addMappingService(1, n);
        this.viewOptionsDevice.updateModel();
    }
}

