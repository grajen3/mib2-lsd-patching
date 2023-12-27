/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.service;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDevice;

public class ServiceVehicleStatesViewOptionListenerImpl
extends VehicleStatesViewOptionAdapter {
    private ServiceDevice viewOptionsDevice;

    public ServiceVehicleStatesViewOptionListenerImpl(ServiceDevice serviceDevice) {
        this.viewOptionsDevice = serviceDevice;
    }

    @Override
    public void updateVINViewOption(CarFunctionState carFunctionState, int n) {
        this.viewOptionsDevice.addMappingService(0, carFunctionState, n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateVINDevice(int n) {
        this.viewOptionsDevice.addMappingService(0, n);
        this.viewOptionsDevice.updateModel();
    }
}

