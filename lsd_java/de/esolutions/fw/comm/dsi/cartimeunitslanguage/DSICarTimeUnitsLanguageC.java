/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

public interface DSICarTimeUnitsLanguageC {
    default public void setMenuLanguage(int n) {
    }

    default public void setPressureUnit(int n) {
    }

    default public void setVolumeUnit(int n) {
    }

    default public void setTemperatureUnit(int n) {
    }

    default public void setDistanceUnit(int n) {
    }

    default public void setSpeedUnit(int n) {
    }

    default public void setConsumptionPetrolUnit(int n) {
    }

    default public void setConsumptionGasUnit(int n) {
    }

    default public void setConsumptionElectricUnit(int n) {
    }

    default public void setClockFormat(int n) {
    }

    default public void setDateFormat(int n) {
    }

    default public void setClockDate(ClockDate clockDate) {
    }

    default public void setClockTime(byte by, byte by2, byte by3) {
    }

    default public void setClockSource(int n) {
    }

    default public void setClockDayLightSaving(boolean bl) {
    }

    default public void setClockTimeZoneOffset(float f2) {
    }

    default public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
    }

    default public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
    }

    default public void setUmSetFactoryDefault() {
    }

    default public void setSkin(int n) {
    }

    default public void setWeightUnit(int n) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

