/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.e_traction;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.e_traction.E_TractionViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.e_traction.E_TractionViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.CarViewOption;

public class E_TractionDevice {
    private E_TractionViewOptionService e_tractionService;
    private MappingList mappingList;
    private CarSetupMenu carSetupMenu;

    public E_TractionDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(7);
        this.e_tractionService = ASLCarFactory.getCarApi().getE_TractionViewOptionService();
        E_TractionViewOptionListenerImpl e_TractionViewOptionListenerImpl = new E_TractionViewOptionListenerImpl(this);
        this.e_tractionService.addListener(e_TractionViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10789).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10788).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10787).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(0, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    public void addMapping(int n, CarViewOption carViewOption) {
        this.mappingList.add(n, carViewOption);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

