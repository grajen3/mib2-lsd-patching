/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.light;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.light.ExtLightViewOptionsData;
import de.vw.mib.asl.api.car.vo.light.IntLightViewOptionsData;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionService;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.CarViewOption;

public class LightDevice
extends LightViewOptionAdapter {
    private LightViewOptionService lightService;
    private MappingList mappingList;
    private CarSetupMenu carSetupMenu;

    public LightDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(14);
        ASLCarFactory.getCarApi().getLightViewOptionService().addListener(this);
        this.updateModel();
    }

    void updateModel() {
        ListManager.getGenericASLList(10728).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10727).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10749).updateList(this.mappingList.getFunctionStates());
        this.carSetupMenu.updateMenu(5, this.mappingList);
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    public void addMapping(int n, CarViewOption carViewOption) {
        this.mappingList.add(n, carViewOption);
    }

    @Override
    public void updateExtLightViewOptions(ExtLightViewOptionsData extLightViewOptionsData, int n) {
        this.addMapping(2, extLightViewOptionsData.getMaskedHighBeam(), n);
        this.addMapping(3, extLightViewOptionsData.getHeadlightSystem(), n);
        this.addMapping(4, extLightViewOptionsData.getAdaptiveLightSystem(), n);
        this.addMapping(5, extLightViewOptionsData.getSwitchOnSensitivity(), n);
        this.addMapping(6, extLightViewOptionsData.getHeadlightRange(), n);
        this.addMapping(7, extLightViewOptionsData.getAutomaticLight(), n);
        this.addMapping(8, extLightViewOptionsData.getAutomaticLight(), n);
        this.addMapping(9, extLightViewOptionsData.getDayLight(), n);
        this.addMapping(10, extLightViewOptionsData.getMotorwayBlinking(), n);
        this.addMapping(11, extLightViewOptionsData.getTouristLight(), n);
        this.addMapping(12, extLightViewOptionsData.getComingHome(), n);
        this.addMapping(13, extLightViewOptionsData.getLeavingHome(), n);
        this.updateModel();
    }

    @Override
    public void updateIntLightViewOptions(IntLightViewOptionsData intLightViewOptionsData, int n) {
        this.addMapping(0, intLightViewOptionsData.getIntLightBrigthness(), n);
        this.updateModel();
    }

    @Override
    public void updateExtLightDevice(int n) {
        this.mappingList.add(2, n);
        this.mappingList.add(3, n);
        this.mappingList.add(4, n);
        this.mappingList.add(5, n);
        this.mappingList.add(6, n);
        this.mappingList.add(7, n);
        this.mappingList.add(8, n);
        this.mappingList.add(9, n);
        this.mappingList.add(10, n);
        this.mappingList.add(11, n);
        this.mappingList.add(12, n);
        this.mappingList.add(13, n);
        this.updateModel();
    }

    @Override
    public void updateIntLightDevice(int n) {
        this.mappingList.add(0, n);
        this.updateModel();
    }
}

