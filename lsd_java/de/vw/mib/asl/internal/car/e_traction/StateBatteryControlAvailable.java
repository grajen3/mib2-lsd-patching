/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.car.e_traction.HsmTargetBatteryManager;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
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
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class StateBatteryControlAvailable
extends StateBatteryControlBase {
    private boolean initialized;

    public StateBatteryControlAvailable(HsmTargetBatteryManager hsmTargetBatteryManager, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetBatteryManager, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        StateBatteryControlAvailable stateBatteryControlAvailable = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("BatteryContorl: HSM_ENTRY in state ").append(this.getName()).log();
                break;
            }
            case 3: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("BatteryContorl: HSM_START in state ").append(this.getName()).log();
                }
                if (!this.initialized) {
                    this.myTarget.registerModelEvents();
                    this.myTarget.registerOnCarHybridProfilesListUpdateInfo();
                    this.myTarget.registerOnPowerProviderListUpdateInfo();
                    this.myTarget.registerOnTimer();
                    this.myTarget.registerOnTimerState();
                    this.myTarget.registerOnCarHybridTotalNumbersOfProfiles();
                    this.myTarget.registerOnPowerProviderTotalNumbers();
                    this.myTarget.registerOnActivePedal();
                    this.initialized = true;
                }
                this.myTarget.getBatterManagerMainController().setBatteryMangerBecomesAvailable();
                break;
            }
            case 4: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("BatteryContorl: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            default: {
                this.myTarget.getBatterManagerMainController().handle(eventGeneric);
                stateBatteryControlAvailable = this;
            }
        }
        return stateBatteryControlAvailable;
    }

    public void dsiCarHybridUpdateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlViewOptions(batteryControlViewOptions, n);
        if (!this.myTarget.getBatterManagerMainController().isBatteryManagerAvailable()) {
            this.myTarget.error("[ERROR] CarHybrid: FSG does not exists!!!");
            this.trans(this.myTarget.getStateBatteryControlNotAvailable());
        } else {
            this.myTarget.info().append("[INFO] CarHybrid: Battery Manager still in Available State").log();
        }
    }

    public void dsiCarHybridUpdateHybridActivePedal(boolean bl, int n) {
        this.myTarget.batterManagerMainController.isActivePedal = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(10595, bl);
    }

    public void dsiCarHybridAcknowledgeBatteryControlSetFactoryDefault(boolean bl) {
    }

    public void dsiCarHybridResponsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponsePowerProviderListRA0(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array);
    }

    public void dsiCarHybridResponsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponsePowerProviderListRA1(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array);
    }

    public void dsiCarHybridResponsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponsePowerProviderListRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
    }

    public void dsiCarHybridResponsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponsePowerProviderListRAE(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
    }

    public void dsiCarHybridResponsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponsePowerProviderListRAF(batteryControlPowerProviderAH, nArray);
    }

    public void dsiCarHybridResponseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
    }

    public void dsiCarHybridResponseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA1(batteryControlProfilesAH, batteryControlProfileRA1Array);
    }

    public void dsiCarHybridResponseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA2(batteryControlProfilesAH, batteryControlProfileRA2Array);
    }

    public void dsiCarHybridResponseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
    }

    public void dsiCarHybridResponseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA4(batteryControlProfilesAH, batteryControlProfileRA4Array);
    }

    public void dsiCarHybridResponseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
    }

    public void dsiCarHybridResponseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA6(batteryControlProfilesAH, batteryControlProfileRA6Array);
    }

    public void dsiCarHybridResponseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRA7(batteryControlProfilesAH, batteryControlProfileRA7Array);
    }

    public void dsiCarHybridResponseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridResponseProfileListRAF(batteryControlProfilesAH, nArray);
    }

    public void dsiCarHybridUpdateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlChargeState(batteryControlChargeState, n);
    }

    public void dsiCarHybridUpdateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlClimateState(batteryControlClimateState, n);
    }

    public void dsiCarHybridUpdateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlPlug(batteryControlPlug, n);
    }

    public void dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo(batteryControlPowerProviderAH, nArray, n);
    }

    public void dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo(batteryControlProfilesAH, nArray, n);
    }

    public void dsiCarHybridUpdateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTimer1(batteryControlTimer, n);
    }

    public void dsiCarHybridUpdateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTimer2(batteryControlTimer, n);
    }

    public void dsiCarHybridUpdateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTimer3(batteryControlTimer, n);
    }

    public void dsiCarHybridUpdateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTimerState(batteryControlTimerState, n);
    }

    public void dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(n, n2);
    }

    public void dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(n, n2);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockDate(ClockDate clockDate, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarTimeUnitsLanguageUpdateClockDate(clockDate, n);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockFormat(int n, int n2) {
        this.myTarget.getBatterManagerMainController().dsiCarTimeUnitsLanguageUpdateClockFormat(n, n2);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockTime(ClockTime clockTime, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarTimeUnitsLanguageUpdateClockTime(clockTime, n);
    }
}

