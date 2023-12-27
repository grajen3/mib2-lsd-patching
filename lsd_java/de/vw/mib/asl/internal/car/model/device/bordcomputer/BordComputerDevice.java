/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.bordcomputer;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionService;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionService;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerEcoViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerKombiViewOptionListnerImpl;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerVehicleStatesViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class BordComputerDevice {
    private MappingList mappingListMain = new MappingList(1);
    private MappingList mappingListBordComputer = new MappingList(11);
    private VehicleStatesViewOptionService vehicleStatesViewOptionService = ASLCarFactory.getCarApi().getVehicleStatesViewOptionService();
    private EcoViewOptionService ecoViewOptionService;
    private KombiViewOptionService kombiViewOptionService;

    public BordComputerDevice() {
        BordComputerVehicleStatesViewOptionListenerImpl bordComputerVehicleStatesViewOptionListenerImpl = new BordComputerVehicleStatesViewOptionListenerImpl(this);
        this.vehicleStatesViewOptionService.addListener(bordComputerVehicleStatesViewOptionListenerImpl);
        this.ecoViewOptionService = ASLCarFactory.getCarApi().getEcoViewOptionService();
        BordComputerEcoViewOptionServiceImpl bordComputerEcoViewOptionServiceImpl = new BordComputerEcoViewOptionServiceImpl(this);
        this.ecoViewOptionService.addListener(bordComputerEcoViewOptionServiceImpl);
        this.kombiViewOptionService = ASLCarFactory.getCarApi().getKombiViewOptionService();
        BordComputerKombiViewOptionListnerImpl bordComputerKombiViewOptionListnerImpl = new BordComputerKombiViewOptionListnerImpl(this);
        this.kombiViewOptionService.addListener(bordComputerKombiViewOptionListnerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10812).updateList(this.mappingListBordComputer.getFunctionStates());
        ListManager.getGenericASLList(10813).updateList(this.mappingListBordComputer.getFunctionStates());
        ListManager.getGenericASLList(10814).updateList(this.mappingListBordComputer.getFunctionStates());
        ListManager.getGenericASLList(10816).updateList(this.mappingListMain.getFunctionStates());
        ListManager.getGenericASLList(10817).updateList(this.mappingListMain.getFunctionStates());
        ListManager.getGenericASLList(10818).updateList(this.mappingListMain.getFunctionStates());
    }

    void addMappingMain(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingListMain.add(n, carFunctionState, n2);
    }

    void addMappingMain(int n, int n2) {
        this.mappingListMain.add(n, n2);
    }

    void addMappingBordComputer(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingListBordComputer.add(n, carFunctionState, n2);
    }

    void addMappingBordComputer(int n, int n2) {
        this.mappingListBordComputer.add(n, n2);
    }
}

