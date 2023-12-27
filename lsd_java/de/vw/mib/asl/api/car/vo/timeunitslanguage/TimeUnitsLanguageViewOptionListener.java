/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.timeunitslanguage;

import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeViewOptionsData;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.UnitsViewOptionsData;

public interface TimeUnitsLanguageViewOptionListener {
    default public void updateClockViewOptions(TimeViewOptionsData timeViewOptionsData, int n) {
    }

    default public void updateClockDevice(int n) {
    }

    default public void updateUnitsViewOptions(UnitsViewOptionsData unitsViewOptionsData, int n) {
    }

    default public void updateUnitsDevice(int n) {
    }
}

