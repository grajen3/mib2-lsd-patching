/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.mfa;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.mfa.MFAViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class MFADevice {
    private KombiViewOptionService bcService;
    private MappingList mappingList;
    private CarSetupMenu carSetupMenu;

    public MFADevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(17);
        this.bcService = ASLCarFactory.getCarApi().getKombiViewOptionService();
        MFAViewOptionListenerImpl mFAViewOptionListenerImpl = new MFAViewOptionListenerImpl(this);
        this.bcService.addListener(mFAViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10738).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10739).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10740).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(11, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

