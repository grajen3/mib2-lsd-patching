/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.hud;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.hud.HUDViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class HUDDevice {
    private KombiViewOptionService hudService;
    private MappingList mappingList;
    private CarSetupMenu carSetupMenu;

    public HUDDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(13);
        this.hudService = ASLCarFactory.getCarApi().getKombiViewOptionService();
        HUDViewOptionListenerImpl hUDViewOptionListenerImpl = new HUDViewOptionListenerImpl(this);
        this.hudService.addListener(hUDViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10722).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10723).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10724).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(12, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

