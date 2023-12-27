/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
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
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public interface DSICarHybridListener
extends DSIListener {
    default public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
    }

    default public void updateHybridCharge(int n, int n2) {
    }

    default public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
    }

    default public void updateHybridRecoveredEnergy(int n, int n2) {
    }

    default public void updateHybridEnergyFlow(int n, int n2) {
    }

    default public void updateHybridEnergyAssistControl(boolean bl, int n) {
    }

    default public void updateHybridEnergyAssistState(int n, int n2) {
    }

    default public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
    }

    default public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
    }

    default public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
    }

    default public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
    }

    default public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
    }

    default public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
    }

    default public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
    }

    default public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
    }

    default public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
    }

    default public void updateBatteryControlTotalNumberOfProfiles(int n, int n2) {
    }

    default public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
    }

    default public void updateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
    }

    default public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
    }

    default public void acknowledgeBatteryControlSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
    }

    default public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
    }

    default public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
    }

    default public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
    }

    default public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
    }

    default public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
    }

    default public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
    }

    default public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
    }

    default public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
    }

    default public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
    }

    default public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
    }

    default public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
    }

    default public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
    }

    default public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
    }

    default public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
    }

    default public void updateHybridTargetRange(HybridTargetRange hybridTargetRange, int n) {
    }

    default public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
    }

    default public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
    }

    default public void updateBatteryControlRemainingChargeTime(BatteryControlRemainingChargeTime batteryControlRemainingChargeTime, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime2, int n) {
    }

    default public void updateBatteryControlLowestMaxCurrent(int n, int n2) {
    }

    default public void updateHybridInhibitReason(HybridInhibitReason hybridInhibitReason, int n) {
    }

    default public void updateHybridActivePedal(boolean bl, int n) {
    }
}

