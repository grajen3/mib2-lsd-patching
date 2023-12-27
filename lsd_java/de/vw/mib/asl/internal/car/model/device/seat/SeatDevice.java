/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.seat;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.seat.ComfortViewOptionListenerImpl;
import de.vw.mib.asl.internal.car.model.device.seat.SeatViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class SeatDevice {
    private SeatViewOptionService seatService;
    private ComfortViewOptionService comfortService;
    private CarSetupMenu carSetupMenu;
    private MappingList mappingList;

    public SeatDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(5);
        this.seatService = ASLCarFactory.getCarApi().getSeatViewOptionService();
        this.comfortService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        ComfortViewOptionListenerImpl comfortViewOptionListenerImpl = new ComfortViewOptionListenerImpl(this);
        SeatViewOptionListenerImpl seatViewOptionListenerImpl = new SeatViewOptionListenerImpl(this);
        this.seatService.addListener(seatViewOptionListenerImpl);
        this.comfortService.addListener(comfortViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10635).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10636).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10637).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(10, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

