/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.service;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.DrivingCharacteristicsViewOptionService;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.service.ServiceComfortViewOptionListenerImpl;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDrivingCharacteristicsViewOptionListenerImpl;
import de.vw.mib.asl.internal.car.model.device.service.ServiceKombiViewOptionListenerImpl;
import de.vw.mib.asl.internal.car.model.device.service.ServiceVehicleStatesViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class ServiceDevice {
    private KombiViewOptionService kombiService;
    private ComfortViewOptionService comfortService;
    private VehicleStatesViewOptionService vehicleStatesViewOptionService;
    private DrivingCharacteristicsViewOptionService drivingCharacteristicsViewOptionService;
    private MappingList mappingListTires = new MappingList(6);
    private MappingList mappingListServices = new MappingList(5);
    private CarSetupMenu carSetupMenu;

    public ServiceDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.kombiService = ASLCarFactory.getCarApi().getKombiViewOptionService();
        this.comfortService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        this.vehicleStatesViewOptionService = ASLCarFactory.getCarApi().getVehicleStatesViewOptionService();
        this.drivingCharacteristicsViewOptionService = ASLCarFactory.getCarApi().getDrivingCharacteristicsViewOptionService();
        ServiceComfortViewOptionListenerImpl serviceComfortViewOptionListenerImpl = new ServiceComfortViewOptionListenerImpl(this);
        ServiceKombiViewOptionListenerImpl serviceKombiViewOptionListenerImpl = new ServiceKombiViewOptionListenerImpl(this);
        ServiceVehicleStatesViewOptionListenerImpl serviceVehicleStatesViewOptionListenerImpl = new ServiceVehicleStatesViewOptionListenerImpl(this);
        ServiceDrivingCharacteristicsViewOptionListenerImpl serviceDrivingCharacteristicsViewOptionListenerImpl = new ServiceDrivingCharacteristicsViewOptionListenerImpl(this);
        this.kombiService.addListener(serviceKombiViewOptionListenerImpl);
        this.comfortService.addListener(serviceComfortViewOptionListenerImpl);
        this.vehicleStatesViewOptionService.addListener(serviceVehicleStatesViewOptionListenerImpl);
        this.drivingCharacteristicsViewOptionService.addListener(serviceDrivingCharacteristicsViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10756).updateList(this.mappingListServices.getFunctionStates());
        ListManager.getGenericASLList(10757).updateList(this.mappingListServices.getFunctionStates());
        ListManager.getGenericASLList(10758).updateList(this.mappingListServices.getFunctionStates());
        ListManager.getGenericASLList(10760).updateList(this.mappingListTires.getFunctionStates());
        ListManager.getGenericASLList(10761).updateList(this.mappingListTires.getFunctionStates());
        ListManager.getGenericASLList(10762).updateList(this.mappingListTires.getFunctionStates());
        this.carSetupMenu.updateMenu(17, this.mappingListServices);
        this.carSetupMenu.updateMenu(2, this.mappingListTires);
    }

    void addMappingTires(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingListTires.add(n, carFunctionState, n2);
    }

    void addMappingTires(int n, int n2) {
        this.mappingListTires.add(n, n2);
    }

    void addMappingService(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingListServices.add(n, carFunctionState, n2);
    }

    void addMappingService(int n, int n2) {
        this.mappingListServices.add(n, n2);
    }
}

