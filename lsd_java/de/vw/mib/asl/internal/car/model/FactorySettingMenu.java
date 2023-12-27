/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import generated.de.vw.mib.asl.internal.ListManager;

public class FactorySettingMenu {
    private MappingList mappingList = new MappingList(14);

    private void updateModel() {
        ListManager.getGenericASLList(10773).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10772).updateList(this.mappingList.getFunctionStates());
        ListManager.getGenericASLList(10771).updateList(this.mappingList.getFunctionStates());
    }

    void addMapping(int n, CarFunctionState carFunctionState, int n2) {
        this.mappingList.add(n, carFunctionState, n2);
    }

    public void updateFSMenu(int n, FunctionState functionState, CarSetupMenu carSetupMenu) {
        if (this.isFactorySettingsItem(n)) {
            this.mappingList.add(this.carMenuItemIdToFactorySettingsId(n), functionState);
        }
        this.mappingList.add(0, new FunctionState(0, 0));
        carSetupMenu.updateFactorySettings(this.mappingList);
        this.mappingList.add(0, new FunctionState(2, 0));
        this.updateModel();
    }

    private boolean isFactorySettingsItem(int n) {
        switch (n) {
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return true;
            }
        }
        return false;
    }

    private int carMenuItemIdToFactorySettingsId(int n) {
        switch (n) {
            case 14: {
                return 12;
            }
            case 5: {
                return 4;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 0: {
                return 1;
            }
            case 6: {
                return 5;
            }
            case 8: {
                return 6;
            }
            case 9: {
                return 7;
            }
            case 10: {
                return 8;
            }
            case 11: {
                return 9;
            }
            case 12: {
                return 10;
            }
            case 13: {
                return 11;
            }
        }
        return -1;
    }
}

