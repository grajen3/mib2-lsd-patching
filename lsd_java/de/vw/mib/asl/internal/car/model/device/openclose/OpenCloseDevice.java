/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.openclose;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.openclose.OpenCloseViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.CarViewOption;

public class OpenCloseDevice
extends ComfortViewOptionAdapter {
    private MappingList mappingList;
    private ComfortViewOptionService psoService;
    private CarSetupMenu carSetupMenu;

    public OpenCloseDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(14);
        this.psoService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        OpenCloseViewOptionListenerImpl openCloseViewOptionListenerImpl = new OpenCloseViewOptionListenerImpl(this);
        this.psoService.addListener(openCloseViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10783).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10785).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10784).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(9, this.mappingList);
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

