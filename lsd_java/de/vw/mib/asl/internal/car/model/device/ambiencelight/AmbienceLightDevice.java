/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.ambiencelight;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.ambiencelight.AmbienceLightViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;

public class AmbienceLightDevice {
    private LightViewOptionService viewOptionService;
    private MappingList mappingList;
    CarSetupMenu carSetupMenu;

    public AmbienceLightDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(16);
        this.viewOptionService = ASLCarFactory.getCarApi().getLightViewOptionService();
        AmbienceLightViewOptionListenerImpl ambienceLightViewOptionListenerImpl = new AmbienceLightViewOptionListenerImpl(this);
        this.viewOptionService.addListener(ambienceLightViewOptionListenerImpl);
    }

    void updateModel() {
        ListManager.getGenericASLList(10779).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10780).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10781).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(6, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }
}

