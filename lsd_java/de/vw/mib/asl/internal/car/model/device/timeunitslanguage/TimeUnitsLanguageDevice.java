/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.timeunitslanguage;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeUnitsLanguageViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeUnitsLanguageViewOptionService;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeViewOptionsData;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.UnitsViewOptionsData;
import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.MappingTable;

public class TimeUnitsLanguageDevice
extends TimeUnitsLanguageViewOptionAdapter {
    CarSetupMenu carSetupMenu;
    private TimeUnitsLanguageViewOptionService timeUnitsLanguageService;

    public TimeUnitsLanguageDevice(CarSetupMenu carSetupMenu) {
        this.carSetupMenu = carSetupMenu;
        this.timeUnitsLanguageService = ASLCarFactory.getCarApi().getTimeUniTsLanguageViewOptionsService();
        this.timeUnitsLanguageService.addListener(this);
    }

    @Override
    public void updateClockViewOptions(TimeViewOptionsData timeViewOptionsData, int n) {
        if (n == 0) {
            this.carSetupMenu.updateTime(new FunctionState(timeViewOptionsData.getTime().getState(), MappingTable.getModelValue(timeViewOptionsData.getTime().getAvailableReason())));
        } else {
            this.carSetupMenu.updateTime(new FunctionState(1, MappingTable.getModelValue(n)));
        }
    }

    @Override
    public void updateClockDevice(int n) {
        this.carSetupMenu.updateTime(new FunctionState(1, MappingTable.getModelValue(n)));
    }

    @Override
    public void updateUnitsViewOptions(UnitsViewOptionsData unitsViewOptionsData, int n) {
        if (n == 0) {
            this.carSetupMenu.updateUnits(new FunctionState(unitsViewOptionsData.getUnits().getState(), MappingTable.getModelValue(unitsViewOptionsData.getUnits().getAvailableReason())));
        } else {
            this.carSetupMenu.updateUnits(new FunctionState(1, MappingTable.getModelValue(n)));
        }
    }

    @Override
    public void updateUnitsDevice(int n) {
        this.carSetupMenu.updateUnits(new FunctionState(1, MappingTable.getModelValue(n)));
    }
}

