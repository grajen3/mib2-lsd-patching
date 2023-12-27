/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public interface DSICarTimeUnitsLanguageListener
extends DSIListener {
    default public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
    }

    default public void updateMenuLanguage(int n, int n2) {
    }

    default public void updateTemperatureUnit(int n, int n2) {
    }

    default public void updateDistanceUnit(int n, int n2) {
    }

    default public void updateSpeedUnit(int n, int n2) {
    }

    default public void updatePressureUnit(int n, int n2) {
    }

    default public void updateVolumeUnit(int n, int n2) {
    }

    default public void updateConsumptionPetrolUnit(int n, int n2) {
    }

    default public void updateConsumptionGasUnit(int n, int n2) {
    }

    default public void updateConsumptionElectricUnit(int n, int n2) {
    }

    default public void updateClockFormat(int n, int n2) {
    }

    default public void updateDateFormat(int n, int n2) {
    }

    default public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
    }

    default public void updateClockDate(ClockDate clockDate, int n) {
    }

    default public void updateClockTime(ClockTime clockTime, int n) {
    }

    default public void updateClockSource(int n, int n2) {
    }

    default public void updateClockDayLightSaving(boolean bl, int n) {
    }

    default public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
    }

    default public void updateClockTimeZoneOffset(float f2, int n) {
    }

    default public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
    }

    default public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
    }

    default public void acknowledgeUmSetFactoryDefault(boolean bl) {
    }

    default public void updateUTCOffset(UTCOffset uTCOffset, int n) {
    }

    default public void updateSkin(int n, int n2) {
    }

    default public void updateWeightUnit(int n, int n2) {
    }
}

