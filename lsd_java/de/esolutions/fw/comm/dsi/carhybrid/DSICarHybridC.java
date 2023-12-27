/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public interface DSICarHybridC {
    default public void setBatteryControlImmediately(int n, int n2) {
    }

    default public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
    }

    default public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
    }

    default public void setBatteryControlSetFactoryDefault() {
    }

    default public void setHybridTargetRange(short s, int n) {
    }

    default public void setHybridEnergyAssistControl(boolean bl) {
    }

    default public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
    }

    default public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
    }

    default public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
    }

    default public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
    }

    default public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
    }

    default public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
    }

    default public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
    }

    default public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
    }

    default public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
    }

    default public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
    }

    default public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
    }

    default public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
    }

    default public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
    }

    default public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
    }

    default public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
    }

    default public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
    }

    default public void setBatteryControlPastErrorReason(int n) {
    }

    default public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
    }

    default public void setHybridActivePedal(boolean bl) {
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

