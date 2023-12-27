/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public class DsiCarTimeUnitsLanguageListenerAdapter
implements DSICarTimeUnitsLanguageListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
    }

    @Override
    public void updateMenuLanguage(int n, int n2) {
    }

    @Override
    public void updateTemperatureUnit(int n, int n2) {
    }

    @Override
    public void updateDistanceUnit(int n, int n2) {
    }

    @Override
    public void updateSpeedUnit(int n, int n2) {
    }

    @Override
    public void updatePressureUnit(int n, int n2) {
    }

    @Override
    public void updateVolumeUnit(int n, int n2) {
    }

    @Override
    public void updateConsumptionPetrolUnit(int n, int n2) {
    }

    @Override
    public void updateConsumptionGasUnit(int n, int n2) {
    }

    @Override
    public void updateConsumptionElectricUnit(int n, int n2) {
    }

    @Override
    public void updateClockFormat(int n, int n2) {
    }

    @Override
    public void updateDateFormat(int n, int n2) {
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
    }

    @Override
    public void updateClockSource(int n, int n2) {
    }

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
    }

    @Override
    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
    }

    @Override
    public void updateClockTimeZoneOffset(float f2, int n) {
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
    }

    @Override
    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
    }

    @Override
    public void acknowledgeUmSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
    }

    @Override
    public void updateSkin(int n, int n2) {
    }

    @Override
    public void updateWeightUnit(int n, int n2) {
    }
}

