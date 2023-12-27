/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceServiceImpl;
import de.vw.mib.asl.internal.car.model.FactorySettingMenu;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import generated.de.vw.mib.asl.internal.ListManager;

public class CarSetupMenu {
    private FunctionState[] carMenuList = new FunctionState[19];
    FactorySettingMenu factorySettingMenu;

    public CarSetupMenu(FactorySettingMenu factorySettingMenu) {
        this.factorySettingMenu = factorySettingMenu;
        this.initDefault();
        this.updateModel();
    }

    private void initDefault() {
        this.carMenuList[0] = new FunctionState(0, 0);
        this.carMenuList[1] = new FunctionState(0, 0);
        this.carMenuList[2] = new FunctionState(0, 0);
        this.carMenuList[3] = new FunctionState(0, 0);
        this.carMenuList[4] = new FunctionState(0, 0);
        this.carMenuList[5] = new FunctionState(0, 0);
        this.carMenuList[6] = new FunctionState(0, 0);
        this.carMenuList[7] = new FunctionState(0, 0);
        this.carMenuList[8] = new FunctionState(0, 0);
        this.carMenuList[9] = new FunctionState(0, 0);
        this.carMenuList[10] = new FunctionState(0, 0);
        this.carMenuList[11] = new FunctionState(0, 0);
        this.carMenuList[12] = new FunctionState(0, 0);
        this.carMenuList[13] = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly().isClimateSpecialFunctionsVisible() ? new FunctionState(1, 2) : new FunctionState(0, 0);
        this.carMenuList[14] = new FunctionState(0, 0);
        this.carMenuList[15] = new FunctionState(2, 0);
        this.carMenuList[16] = new FunctionState(2, 0);
        this.carMenuList[17] = new FunctionState(0, 0);
        this.carMenuList[18] = new FunctionState(0, 0);
    }

    private void updateModel() {
        ListManager.getGenericASLList(10791).updateList(this.carMenuList);
        ListManager.getGenericASLList(10792).updateList(this.carMenuList);
        ListManager.getGenericASLList(10793).updateList(this.carMenuList);
    }

    public void updateMenu(int n, MappingList mappingList) {
        Car car;
        FunctionState functionState = mappingList.getListFunctionState();
        if (n == 6 && !(car = CarPersistenceServiceImpl.getInstance().loadCar()).isAmbientLight()) {
            functionState = new FunctionState(0, 0);
        }
        this.carMenuList[n] = functionState;
        this.factorySettingMenu.updateFSMenu(n, functionState, this);
        this.updateModel();
    }

    public void updateClimateSettings(MappingList mappingList, boolean bl) {
        FunctionState functionState;
        this.carMenuList[13] = functionState = bl ? new FunctionState(0, 0) : mappingList.getListFunctionState();
        CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly().setClimateSpecialFunctionsVisible(functionState.getFunctionState() == 2 || functionState.getFunctionState() == 1);
        this.factorySettingMenu.updateFSMenu(13, functionState, this);
        this.updateModel();
    }

    public void updateFactorySettings(MappingList mappingList) {
        FunctionState functionState;
        this.carMenuList[18] = functionState = mappingList.getListFunctionState();
        this.updateModel();
    }

    public void updateStabilityProgram(FunctionState functionState) {
        this.carMenuList[1] = functionState;
        this.updateModel();
    }

    public void updateTime(FunctionState functionState) {
        this.carMenuList[15] = functionState;
        this.updateModel();
    }

    public void updateUnits(FunctionState functionState) {
        this.carMenuList[16] = functionState;
        this.updateModel();
    }

    public FunctionState get(int n) {
        return this.carMenuList[n];
    }

    public void updateMenu(int n, int n2) {
        FunctionState functionState;
        this.carMenuList[n] = functionState = new FunctionState(1, n2);
        this.factorySettingMenu.updateFSMenu(n, functionState, this);
        this.updateModel();
    }
}

