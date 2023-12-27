/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.climate;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import de.vw.mib.asl.internal.car.model.device.climate.ClimateViewOptionListenerImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.CarViewOption;

public class ClimateDevice {
    private ClimateViewOptionService climateService;
    private MappingList mappingList;
    private boolean hasSetupButton;
    CarSetupMenu carSetupMenu;

    public boolean isKME() {
        return this.hasSetupButton;
    }

    public void setHasSetupButton(boolean bl) {
        this.hasSetupButton = bl;
    }

    public ClimateDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.mappingList = new MappingList(6);
        this.climateService = ASLCarFactory.getCarApi().getClimateViewOptionService();
        ClimateViewOptionListenerImpl climateViewOptionListenerImpl = new ClimateViewOptionListenerImpl(this);
        this.climateService.addListener(climateViewOptionListenerImpl);
        this.updateModel();
    }

    void updateModel() {
        try {
            ListManager.getGenericASLList(621047296).updateList(this.mappingList.getFunctionStates());
            ListManager.getGenericASLList(637824512).updateList(this.mappingList.getFunctionStates());
            ListManager.getGenericASLList(654601728).updateList(this.mappingList.getFunctionStates());
            ServiceManager.aslPropertyManager.valueChangedBoolean(313393408, this.mappingList.getListFunctionState().getFunctionState() == 2);
            this.carSetupMenu.updateClimateSettings(this.mappingList, this.hasSetupButton);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    void addMapping(int n, int n2) {
        this.mappingList.add(n, n2);
    }

    public void addMapping(int n, CarViewOption carViewOption) {
        this.mappingList.add(n, carViewOption);
    }
}

