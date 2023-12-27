/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carhybrid;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateMode;
import org.dsi.ifc.carhybrid.BatteryControlClimateOperationModeInstallation;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlEngineInstallation;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileInstallation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;
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
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterActivity;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterInstallation;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlTransmittableElements;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterActivity;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterInstallation;
import org.dsi.ifc.carhybrid.HybridConfiguration;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridSinkState;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public final class DSICarHybridTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BATTERYCONTROLCHARGESTATE;
    private static final int ID_BATTERYCONTROLCLIMATEMODE;
    private static final int ID_BATTERYCONTROLCLIMATEOPERATIONMODEINSTALLATION;
    private static final int ID_BATTERYCONTROLCLIMATESTATE;
    private static final int ID_BATTERYCONTROLCONFIGURATION;
    private static final int ID_BATTERYCONTROLENGINEINSTALLATION;
    private static final int ID_BATTERYCONTROLEXPIREDTIMER;
    private static final int ID_BATTERYCONTROLPLUG;
    private static final int ID_BATTERYCONTROLPOWERPROVIDERAH;
    private static final int ID_BATTERYCONTROLPOWERPROVIDERRA0;
    private static final int ID_BATTERYCONTROLPOWERPROVIDERRA1;
    private static final int ID_BATTERYCONTROLPOWERPROVIDERRA2;
    private static final int ID_BATTERYCONTROLPOWERPROVIDERRAE;
    private static final int ID_BATTERYCONTROLPROFILEINSTALLATION;
    private static final int ID_BATTERYCONTROLPROFILEOPERATION;
    private static final int ID_BATTERYCONTROLPROFILEOPERATION2;
    private static final int ID_BATTERYCONTROLPROFILERA0;
    private static final int ID_BATTERYCONTROLPROFILERA1;
    private static final int ID_BATTERYCONTROLPROFILERA2;
    private static final int ID_BATTERYCONTROLPROFILERA3;
    private static final int ID_BATTERYCONTROLPROFILERA4;
    private static final int ID_BATTERYCONTROLPROFILERA5;
    private static final int ID_BATTERYCONTROLPROFILERA6;
    private static final int ID_BATTERYCONTROLPROFILERA7;
    private static final int ID_BATTERYCONTROLPROFILESAH;
    private static final int ID_BATTERYCONTROLPROGRAMMEDTIMER;
    private static final int ID_BATTERYCONTROLREMAININGCHARGETIME;
    private static final int ID_BATTERYCONTROLSEATHEATERACTIVITY;
    private static final int ID_BATTERYCONTROLSEATHEATERINSTALLATION;
    private static final int ID_BATTERYCONTROLTIMER;
    private static final int ID_BATTERYCONTROLTIMERSTATE;
    private static final int ID_BATTERYCONTROLTRANSMITTABLEELEMENTS;
    private static final int ID_BATTERYCONTROLVIEWOPTIONS;
    private static final int ID_BATTERYCONTROLWEEKDAYS;
    private static final int ID_BATTERYCONTROLWINDOWHEATERACTIVITY;
    private static final int ID_BATTERYCONTROLWINDOWHEATERINSTALLATION;
    private static final int ID_HYBRIDCONFIGURATION;
    private static final int ID_HYBRIDENERGYFLOWSTATE;
    private static final int ID_HYBRIDINHIBITREASON;
    private static final int ID_HYBRIDSINKSTATE;
    private static final int ID_HYBRIDTARGETRANGE;
    private static final int ID_HYBRIDVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlChargeState;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlClimateMode;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlClimateOperationModeInstallation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlClimateState;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlEngineInstallation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlExpiredTimer;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPlug;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderAH;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA0;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA1;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA2;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRAE;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileInstallation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation2;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA0;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA1;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA2;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA3;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA4;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA5;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA6;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfileRA7;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProfilesAH;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlProgrammedTimer;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlRemainingChargeTime;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterActivity;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterInstallation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlTimer;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlTimerState;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlWeekdays;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterActivity;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterInstallation;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridEnergyFlowState;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridInhibitReason;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridSinkState;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridTargetRange;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$HybridViewOptions;

    public DSICarHybridTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlChargeState == null ? (class$org$dsi$ifc$carhybrid$BatteryControlChargeState = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlChargeState")) : class$org$dsi$ifc$carhybrid$BatteryControlChargeState, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlClimateMode == null ? (class$org$dsi$ifc$carhybrid$BatteryControlClimateMode = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlClimateMode")) : class$org$dsi$ifc$carhybrid$BatteryControlClimateMode, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlClimateOperationModeInstallation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlClimateOperationModeInstallation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlClimateOperationModeInstallation")) : class$org$dsi$ifc$carhybrid$BatteryControlClimateOperationModeInstallation, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlClimateState == null ? (class$org$dsi$ifc$carhybrid$BatteryControlClimateState = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlClimateState")) : class$org$dsi$ifc$carhybrid$BatteryControlClimateState, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlConfiguration == null ? (class$org$dsi$ifc$carhybrid$BatteryControlConfiguration = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlConfiguration")) : class$org$dsi$ifc$carhybrid$BatteryControlConfiguration, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlEngineInstallation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlEngineInstallation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlEngineInstallation")) : class$org$dsi$ifc$carhybrid$BatteryControlEngineInstallation, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlExpiredTimer == null ? (class$org$dsi$ifc$carhybrid$BatteryControlExpiredTimer = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlExpiredTimer")) : class$org$dsi$ifc$carhybrid$BatteryControlExpiredTimer, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPlug == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPlug = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPlug")) : class$org$dsi$ifc$carhybrid$BatteryControlPlug, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderAH == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderAH = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH")) : class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderAH, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA0 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA0 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0")) : class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA0, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA1 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA1 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1")) : class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA1, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA2 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA2 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2")) : class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRA2, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRAE == null ? (class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRAE = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE")) : class$org$dsi$ifc$carhybrid$BatteryControlPowerProviderRAE, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileInstallation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileInstallation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileInstallation")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileInstallation, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileOperation")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation2 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation2 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileOperation2")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileOperation2, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA0 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA0 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA0")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA0, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA1 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA1 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA1")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA1, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA2 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA2 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA2")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA2, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA3 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA3 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA3")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA3, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA4 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA4 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA4")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA4, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA5 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA5 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA5")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA5, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA6 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA6 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA6")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA6, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfileRA7 == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfileRA7 = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfileRA7")) : class$org$dsi$ifc$carhybrid$BatteryControlProfileRA7, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProfilesAH == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProfilesAH = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProfilesAH")) : class$org$dsi$ifc$carhybrid$BatteryControlProfilesAH, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlProgrammedTimer == null ? (class$org$dsi$ifc$carhybrid$BatteryControlProgrammedTimer = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer")) : class$org$dsi$ifc$carhybrid$BatteryControlProgrammedTimer, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlRemainingChargeTime == null ? (class$org$dsi$ifc$carhybrid$BatteryControlRemainingChargeTime = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime")) : class$org$dsi$ifc$carhybrid$BatteryControlRemainingChargeTime, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterActivity == null ? (class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterActivity = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlSeatheaterActivity")) : class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterActivity, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterInstallation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterInstallation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlSeatheaterInstallation")) : class$org$dsi$ifc$carhybrid$BatteryControlSeatheaterInstallation, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlTimer == null ? (class$org$dsi$ifc$carhybrid$BatteryControlTimer = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlTimer")) : class$org$dsi$ifc$carhybrid$BatteryControlTimer, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlTimerState == null ? (class$org$dsi$ifc$carhybrid$BatteryControlTimerState = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlTimerState")) : class$org$dsi$ifc$carhybrid$BatteryControlTimerState, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlTransmittableElements == null ? (class$org$dsi$ifc$carhybrid$BatteryControlTransmittableElements = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlTransmittableElements")) : class$org$dsi$ifc$carhybrid$BatteryControlTransmittableElements, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlViewOptions == null ? (class$org$dsi$ifc$carhybrid$BatteryControlViewOptions = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlViewOptions")) : class$org$dsi$ifc$carhybrid$BatteryControlViewOptions, 33);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlWeekdays == null ? (class$org$dsi$ifc$carhybrid$BatteryControlWeekdays = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlWeekdays")) : class$org$dsi$ifc$carhybrid$BatteryControlWeekdays, 34);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterActivity == null ? (class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterActivity = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlWindowheaterActivity")) : class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterActivity, 35);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterInstallation == null ? (class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterInstallation = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.BatteryControlWindowheaterInstallation")) : class$org$dsi$ifc$carhybrid$BatteryControlWindowheaterInstallation, 36);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridConfiguration == null ? (class$org$dsi$ifc$carhybrid$HybridConfiguration = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridConfiguration")) : class$org$dsi$ifc$carhybrid$HybridConfiguration, 37);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridEnergyFlowState == null ? (class$org$dsi$ifc$carhybrid$HybridEnergyFlowState = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridEnergyFlowState")) : class$org$dsi$ifc$carhybrid$HybridEnergyFlowState, 38);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridInhibitReason == null ? (class$org$dsi$ifc$carhybrid$HybridInhibitReason = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridInhibitReason")) : class$org$dsi$ifc$carhybrid$HybridInhibitReason, 39);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridSinkState == null ? (class$org$dsi$ifc$carhybrid$HybridSinkState = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridSinkState")) : class$org$dsi$ifc$carhybrid$HybridSinkState, 40);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridTargetRange == null ? (class$org$dsi$ifc$carhybrid$HybridTargetRange = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridTargetRange")) : class$org$dsi$ifc$carhybrid$HybridTargetRange, 41);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carhybrid$HybridViewOptions == null ? (class$org$dsi$ifc$carhybrid$HybridViewOptions = DSICarHybridTracer.class$("org.dsi.ifc.carhybrid.HybridViewOptions")) : class$org$dsi$ifc$carhybrid$HybridViewOptions, 42);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBatteryControlChargeState(printWriter, (BatteryControlChargeState)object);
                break;
            }
            case 2: {
                this.traceBatteryControlClimateMode(printWriter, (BatteryControlClimateMode)object);
                break;
            }
            case 3: {
                this.traceBatteryControlClimateOperationModeInstallation(printWriter, (BatteryControlClimateOperationModeInstallation)object);
                break;
            }
            case 4: {
                this.traceBatteryControlClimateState(printWriter, (BatteryControlClimateState)object);
                break;
            }
            case 5: {
                this.traceBatteryControlConfiguration(printWriter, (BatteryControlConfiguration)object);
                break;
            }
            case 6: {
                this.traceBatteryControlEngineInstallation(printWriter, (BatteryControlEngineInstallation)object);
                break;
            }
            case 7: {
                this.traceBatteryControlExpiredTimer(printWriter, (BatteryControlExpiredTimer)object);
                break;
            }
            case 8: {
                this.traceBatteryControlPlug(printWriter, (BatteryControlPlug)object);
                break;
            }
            case 9: {
                this.traceBatteryControlPowerProviderAH(printWriter, (BatteryControlPowerProviderAH)object);
                break;
            }
            case 10: {
                this.traceBatteryControlPowerProviderRA0(printWriter, (BatteryControlPowerProviderRA0)object);
                break;
            }
            case 11: {
                this.traceBatteryControlPowerProviderRA1(printWriter, (BatteryControlPowerProviderRA1)object);
                break;
            }
            case 12: {
                this.traceBatteryControlPowerProviderRA2(printWriter, (BatteryControlPowerProviderRA2)object);
                break;
            }
            case 13: {
                this.traceBatteryControlPowerProviderRAE(printWriter, (BatteryControlPowerProviderRAE)object);
                break;
            }
            case 14: {
                this.traceBatteryControlProfileInstallation(printWriter, (BatteryControlProfileInstallation)object);
                break;
            }
            case 15: {
                this.traceBatteryControlProfileOperation(printWriter, (BatteryControlProfileOperation)object);
                break;
            }
            case 16: {
                this.traceBatteryControlProfileOperation2(printWriter, (BatteryControlProfileOperation2)object);
                break;
            }
            case 17: {
                this.traceBatteryControlProfileRA0(printWriter, (BatteryControlProfileRA0)object);
                break;
            }
            case 18: {
                this.traceBatteryControlProfileRA1(printWriter, (BatteryControlProfileRA1)object);
                break;
            }
            case 19: {
                this.traceBatteryControlProfileRA2(printWriter, (BatteryControlProfileRA2)object);
                break;
            }
            case 20: {
                this.traceBatteryControlProfileRA3(printWriter, (BatteryControlProfileRA3)object);
                break;
            }
            case 21: {
                this.traceBatteryControlProfileRA4(printWriter, (BatteryControlProfileRA4)object);
                break;
            }
            case 22: {
                this.traceBatteryControlProfileRA5(printWriter, (BatteryControlProfileRA5)object);
                break;
            }
            case 23: {
                this.traceBatteryControlProfileRA6(printWriter, (BatteryControlProfileRA6)object);
                break;
            }
            case 24: {
                this.traceBatteryControlProfileRA7(printWriter, (BatteryControlProfileRA7)object);
                break;
            }
            case 25: {
                this.traceBatteryControlProfilesAH(printWriter, (BatteryControlProfilesAH)object);
                break;
            }
            case 26: {
                this.traceBatteryControlProgrammedTimer(printWriter, (BatteryControlProgrammedTimer)object);
                break;
            }
            case 27: {
                this.traceBatteryControlRemainingChargeTime(printWriter, (BatteryControlRemainingChargeTime)object);
                break;
            }
            case 28: {
                this.traceBatteryControlSeatheaterActivity(printWriter, (BatteryControlSeatheaterActivity)object);
                break;
            }
            case 29: {
                this.traceBatteryControlSeatheaterInstallation(printWriter, (BatteryControlSeatheaterInstallation)object);
                break;
            }
            case 30: {
                this.traceBatteryControlTimer(printWriter, (BatteryControlTimer)object);
                break;
            }
            case 31: {
                this.traceBatteryControlTimerState(printWriter, (BatteryControlTimerState)object);
                break;
            }
            case 32: {
                this.traceBatteryControlTransmittableElements(printWriter, (BatteryControlTransmittableElements)object);
                break;
            }
            case 33: {
                this.traceBatteryControlViewOptions(printWriter, (BatteryControlViewOptions)object);
                break;
            }
            case 34: {
                this.traceBatteryControlWeekdays(printWriter, (BatteryControlWeekdays)object);
                break;
            }
            case 35: {
                this.traceBatteryControlWindowheaterActivity(printWriter, (BatteryControlWindowheaterActivity)object);
                break;
            }
            case 36: {
                this.traceBatteryControlWindowheaterInstallation(printWriter, (BatteryControlWindowheaterInstallation)object);
                break;
            }
            case 37: {
                this.traceHybridConfiguration(printWriter, (HybridConfiguration)object);
                break;
            }
            case 38: {
                this.traceHybridEnergyFlowState(printWriter, (HybridEnergyFlowState)object);
                break;
            }
            case 39: {
                this.traceHybridInhibitReason(printWriter, (HybridInhibitReason)object);
                break;
            }
            case 40: {
                this.traceHybridSinkState(printWriter, (HybridSinkState)object);
                break;
            }
            case 41: {
                this.traceHybridTargetRange(printWriter, (HybridTargetRange)object);
                break;
            }
            case 42: {
                this.traceHybridViewOptions(printWriter, (HybridViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBatteryControlChargeState(PrintWriter printWriter, BatteryControlChargeState batteryControlChargeState) {
        if (batteryControlChargeState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlChargeState.chargeMode);
        printWriter.print(batteryControlChargeState.chargeState);
        printWriter.print(batteryControlChargeState.currentChargeLevel);
        printWriter.print(batteryControlChargeState.remainingChargeTime);
        printWriter.print(batteryControlChargeState.currentChargeRange);
        printWriter.print(batteryControlChargeState.unitRange);
        printWriter.print(batteryControlChargeState.current);
        printWriter.print(batteryControlChargeState.startReason);
        printWriter.print(batteryControlChargeState.batteryClimateState);
        printWriter.print(batteryControlChargeState.targetSOC);
    }

    private void traceBatteryControlClimateMode(PrintWriter printWriter, BatteryControlClimateMode batteryControlClimateMode) {
        if (batteryControlClimateMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlClimateMode.climating);
        printWriter.print(batteryControlClimateMode.autoDefrost);
        printWriter.print(batteryControlClimateMode.heating);
        printWriter.print(batteryControlClimateMode.cooling);
        printWriter.print(batteryControlClimateMode.ventilation);
        printWriter.print(batteryControlClimateMode.fuelBasedHeating);
    }

    private void traceBatteryControlClimateOperationModeInstallation(PrintWriter printWriter, BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation) {
        if (batteryControlClimateOperationModeInstallation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlClimateOperationModeInstallation.operationModeImmediatly);
        printWriter.print(batteryControlClimateOperationModeInstallation.operationModeTimer1);
        printWriter.print(batteryControlClimateOperationModeInstallation.operationModeTimer2);
        printWriter.print(batteryControlClimateOperationModeInstallation.operationModeTimer3);
        printWriter.print(batteryControlClimateOperationModeInstallation.operationModeTimer4);
    }

    private void traceBatteryControlClimateState(PrintWriter printWriter, BatteryControlClimateState batteryControlClimateState) {
        if (batteryControlClimateState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, batteryControlClimateState.climateMode);
        printWriter.print(batteryControlClimateState.currentTemperature);
        printWriter.print(batteryControlClimateState.temperatureUnit);
        printWriter.print(batteryControlClimateState.climatingTime);
        printWriter.print(batteryControlClimateState.climateState);
        printWriter.print(batteryControlClimateState.seatheaterWindowState);
        this.trace(printWriter, batteryControlClimateState.seatheaterMode);
        this.trace(printWriter, batteryControlClimateState.windowheaterMode);
    }

    private void traceBatteryControlConfiguration(PrintWriter printWriter, BatteryControlConfiguration batteryControlConfiguration) {
        if (batteryControlConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, batteryControlConfiguration.engineInstallation);
        this.trace(printWriter, batteryControlConfiguration.profileInstallation);
        this.trace(printWriter, batteryControlConfiguration.seatheaterInstallation);
        this.trace(printWriter, batteryControlConfiguration.windowheaterInstallation);
        this.trace(printWriter, batteryControlConfiguration.profilesTransmittableElements);
        this.trace(printWriter, batteryControlConfiguration.powerProviderTransmittableElements);
        printWriter.print(batteryControlConfiguration.parkheaterInstallation);
        this.trace(printWriter, batteryControlConfiguration.climateOperationModeInstallation);
    }

    private void traceBatteryControlEngineInstallation(PrintWriter printWriter, BatteryControlEngineInstallation batteryControlEngineInstallation) {
        if (batteryControlEngineInstallation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlEngineInstallation.rangeAdjustmentElectricEngine);
        printWriter.print(batteryControlEngineInstallation.rangeAdjustmentCombination);
    }

    private void traceBatteryControlExpiredTimer(PrintWriter printWriter, BatteryControlExpiredTimer batteryControlExpiredTimer) {
        if (batteryControlExpiredTimer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlExpiredTimer.timer1);
        printWriter.print(batteryControlExpiredTimer.timer2);
        printWriter.print(batteryControlExpiredTimer.timer3);
        printWriter.print(batteryControlExpiredTimer.timer4);
    }

    private void traceBatteryControlPlug(PrintWriter printWriter, BatteryControlPlug batteryControlPlug) {
        if (batteryControlPlug == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPlug.lockSetup);
        printWriter.print(batteryControlPlug.lockState);
        printWriter.print(batteryControlPlug.supplyState);
        printWriter.print(batteryControlPlug.plugState);
    }

    private void traceBatteryControlPowerProviderAH(PrintWriter printWriter, BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        if (batteryControlPowerProviderAH == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPowerProviderAH.arrayContent);
        printWriter.print(batteryControlPowerProviderAH.transactionID);
        printWriter.print(batteryControlPowerProviderAH.recordContent);
        printWriter.print(batteryControlPowerProviderAH.startElement);
        printWriter.print(batteryControlPowerProviderAH.numOfElements);
        printWriter.print(batteryControlPowerProviderAH.asgID);
    }

    private void traceBatteryControlPowerProviderRA0(PrintWriter printWriter, BatteryControlPowerProviderRA0 batteryControlPowerProviderRA0) {
        if (batteryControlPowerProviderRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPowerProviderRA0.pos);
        printWriter.print(batteryControlPowerProviderRA0.client);
        printWriter.print(batteryControlPowerProviderRA0.provider);
        this.trace(printWriter, batteryControlPowerProviderRA0.nrWeekday);
        printWriter.print(batteryControlPowerProviderRA0.nrStartHour);
        printWriter.print(batteryControlPowerProviderRA0.nrStartMinute);
        printWriter.print(batteryControlPowerProviderRA0.nrEndHour);
        printWriter.print(batteryControlPowerProviderRA0.nrEndMinute);
    }

    private void traceBatteryControlPowerProviderRA1(PrintWriter printWriter, BatteryControlPowerProviderRA1 batteryControlPowerProviderRA1) {
        if (batteryControlPowerProviderRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPowerProviderRA1.pos);
        this.trace(printWriter, batteryControlPowerProviderRA1.nrWeekday);
        printWriter.print(batteryControlPowerProviderRA1.nrStartHour);
        printWriter.print(batteryControlPowerProviderRA1.nrStartMinute);
        printWriter.print(batteryControlPowerProviderRA1.nrEndHour);
        printWriter.print(batteryControlPowerProviderRA1.nrEndMinute);
    }

    private void traceBatteryControlPowerProviderRA2(PrintWriter printWriter, BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2) {
        if (batteryControlPowerProviderRA2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPowerProviderRA2.pos);
        printWriter.print(batteryControlPowerProviderRA2.nrStartHour);
        printWriter.print(batteryControlPowerProviderRA2.nrStartMinute);
        printWriter.print(batteryControlPowerProviderRA2.nrEndHour);
        printWriter.print(batteryControlPowerProviderRA2.nrEndMinute);
    }

    private void traceBatteryControlPowerProviderRAE(PrintWriter printWriter, BatteryControlPowerProviderRAE batteryControlPowerProviderRAE) {
        if (batteryControlPowerProviderRAE == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlPowerProviderRAE.pos);
        printWriter.print(batteryControlPowerProviderRAE.provider);
    }

    private void traceBatteryControlProfileInstallation(PrintWriter printWriter, BatteryControlProfileInstallation batteryControlProfileInstallation) {
        if (batteryControlProfileInstallation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileInstallation.leadingTime);
        printWriter.print(batteryControlProfileInstallation.acTempSetting);
    }

    private void traceBatteryControlProfileOperation(PrintWriter printWriter, BatteryControlProfileOperation batteryControlProfileOperation) {
        if (batteryControlProfileOperation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileOperation.charge);
        printWriter.print(batteryControlProfileOperation.climate);
        printWriter.print(batteryControlProfileOperation.climateWithoutExternalSupply);
        printWriter.print(batteryControlProfileOperation.autoDefrost);
        printWriter.print(batteryControlProfileOperation.seatHeaterFrontLeft);
        printWriter.print(batteryControlProfileOperation.seatHeaterFrontRight);
        printWriter.print(batteryControlProfileOperation.seatHeaterRearLeft);
        printWriter.print(batteryControlProfileOperation.seatHeaterRearRight);
    }

    private void traceBatteryControlProfileOperation2(PrintWriter printWriter, BatteryControlProfileOperation2 batteryControlProfileOperation2) {
        if (batteryControlProfileOperation2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileOperation2.windowHeaterFront);
        printWriter.print(batteryControlProfileOperation2.windowHeaterRear);
        printWriter.print(batteryControlProfileOperation2.parkHeater);
        printWriter.print(batteryControlProfileOperation2.parkHeaterAutomatic);
    }

    private void traceBatteryControlProfileRA0(PrintWriter printWriter, BatteryControlProfileRA0 batteryControlProfileRA0) {
        if (batteryControlProfileRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA0.pos);
        this.trace(printWriter, batteryControlProfileRA0.profileOperation);
        this.trace(printWriter, batteryControlProfileRA0.profileOperation2);
        printWriter.print(batteryControlProfileRA0.maxCurrent);
        printWriter.print(batteryControlProfileRA0.minChargeLevel);
        printWriter.print(batteryControlProfileRA0.minRange);
        printWriter.print(batteryControlProfileRA0.targetChargeLevel);
        printWriter.print(batteryControlProfileRA0.targetChargeDuration);
        printWriter.print(batteryControlProfileRA0.targetChargeRange);
        printWriter.print(batteryControlProfileRA0.unitRange);
        printWriter.print(batteryControlProfileRA0.rangeCalculationSetup);
        printWriter.print(batteryControlProfileRA0.temperature);
        printWriter.print(batteryControlProfileRA0.temperatureUnit);
        printWriter.print(batteryControlProfileRA0.leadTime);
        printWriter.print(batteryControlProfileRA0.holdingTimePlug);
        printWriter.print(batteryControlProfileRA0.holdingTimeBattery);
        printWriter.print(batteryControlProfileRA0.providerDataId);
        printWriter.print(batteryControlProfileRA0.name);
    }

    private void traceBatteryControlProfileRA1(PrintWriter printWriter, BatteryControlProfileRA1 batteryControlProfileRA1) {
        if (batteryControlProfileRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA1.pos);
        this.trace(printWriter, batteryControlProfileRA1.profileOperation);
        printWriter.print(batteryControlProfileRA1.maxCurrent);
        printWriter.print(batteryControlProfileRA1.targetChargeLevel);
        printWriter.print(batteryControlProfileRA1.providerDataId);
        printWriter.print(batteryControlProfileRA1.name);
    }

    private void traceBatteryControlProfileRA2(PrintWriter printWriter, BatteryControlProfileRA2 batteryControlProfileRA2) {
        if (batteryControlProfileRA2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA2.pos);
        this.trace(printWriter, batteryControlProfileRA2.profileOperation);
        printWriter.print(batteryControlProfileRA2.maxCurrent);
        printWriter.print(batteryControlProfileRA2.targetChargeLevel);
    }

    private void traceBatteryControlProfileRA3(PrintWriter printWriter, BatteryControlProfileRA3 batteryControlProfileRA3) {
        if (batteryControlProfileRA3 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA3.pos);
        printWriter.print(batteryControlProfileRA3.name);
    }

    private void traceBatteryControlProfileRA4(PrintWriter printWriter, BatteryControlProfileRA4 batteryControlProfileRA4) {
        if (batteryControlProfileRA4 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA4.pos);
        this.trace(printWriter, batteryControlProfileRA4.profileOperation);
        printWriter.print(batteryControlProfileRA4.maxCurrent);
        printWriter.print(batteryControlProfileRA4.minChargeLevel);
        printWriter.print(batteryControlProfileRA4.temperature);
        printWriter.print(batteryControlProfileRA4.temperatureUnit);
        printWriter.print(batteryControlProfileRA4.leadTime);
        printWriter.print(batteryControlProfileRA4.holdingTimePlug);
    }

    private void traceBatteryControlProfileRA5(PrintWriter printWriter, BatteryControlProfileRA5 batteryControlProfileRA5) {
        if (batteryControlProfileRA5 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA5.pos);
        this.trace(printWriter, batteryControlProfileRA5.profileOperation);
        this.trace(printWriter, batteryControlProfileRA5.profileOperation2);
        printWriter.print(batteryControlProfileRA5.maxCurrent);
        printWriter.print(batteryControlProfileRA5.targetChargeLevel);
        printWriter.print(batteryControlProfileRA5.providerDataId);
        printWriter.print(batteryControlProfileRA5.name);
    }

    private void traceBatteryControlProfileRA6(PrintWriter printWriter, BatteryControlProfileRA6 batteryControlProfileRA6) {
        if (batteryControlProfileRA6 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA6.pos);
        this.trace(printWriter, batteryControlProfileRA6.profileOperation);
        this.trace(printWriter, batteryControlProfileRA6.profileOperation2);
        printWriter.print(batteryControlProfileRA6.maxCurrent);
        printWriter.print(batteryControlProfileRA6.targetChargeLevel);
    }

    private void traceBatteryControlProfileRA7(PrintWriter printWriter, BatteryControlProfileRA7 batteryControlProfileRA7) {
        if (batteryControlProfileRA7 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfileRA7.pos);
        this.trace(printWriter, batteryControlProfileRA7.profileOperation);
        this.trace(printWriter, batteryControlProfileRA7.profileOperation2);
        printWriter.print(batteryControlProfileRA7.maxCurrent);
        printWriter.print(batteryControlProfileRA7.minChargeLevel);
        printWriter.print(batteryControlProfileRA7.temperature);
        printWriter.print(batteryControlProfileRA7.temperatureUnit);
        printWriter.print(batteryControlProfileRA7.leadTime);
        printWriter.print(batteryControlProfileRA7.holdingTimePlug);
        printWriter.print(batteryControlProfileRA7.holdingTimeBattery);
    }

    private void traceBatteryControlProfilesAH(PrintWriter printWriter, BatteryControlProfilesAH batteryControlProfilesAH) {
        if (batteryControlProfilesAH == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProfilesAH.arrayContent);
        printWriter.print(batteryControlProfilesAH.recordContent);
        printWriter.print(batteryControlProfilesAH.startElement);
        printWriter.print(batteryControlProfilesAH.numOfElements);
        printWriter.print(batteryControlProfilesAH.transactionID);
        printWriter.print(batteryControlProfilesAH.asgID);
    }

    private void traceBatteryControlProgrammedTimer(PrintWriter printWriter, BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        if (batteryControlProgrammedTimer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlProgrammedTimer.timer1);
        printWriter.print(batteryControlProgrammedTimer.timer2);
        printWriter.print(batteryControlProgrammedTimer.timer3);
        printWriter.print(batteryControlProgrammedTimer.timer4);
    }

    private void traceBatteryControlRemainingChargeTime(PrintWriter printWriter, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime) {
        if (batteryControlRemainingChargeTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlRemainingChargeTime.mode);
        printWriter.print(batteryControlRemainingChargeTime.targetSOC);
        printWriter.print(batteryControlRemainingChargeTime.chargeTime);
    }

    private void traceBatteryControlSeatheaterActivity(PrintWriter printWriter, BatteryControlSeatheaterActivity batteryControlSeatheaterActivity) {
        if (batteryControlSeatheaterActivity == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlSeatheaterActivity.frontLeft);
        printWriter.print(batteryControlSeatheaterActivity.frontRight);
        printWriter.print(batteryControlSeatheaterActivity.rearLeft);
        printWriter.print(batteryControlSeatheaterActivity.rearRight);
    }

    private void traceBatteryControlSeatheaterInstallation(PrintWriter printWriter, BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation) {
        if (batteryControlSeatheaterInstallation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlSeatheaterInstallation.frontLeft);
        printWriter.print(batteryControlSeatheaterInstallation.frontRight);
        printWriter.print(batteryControlSeatheaterInstallation.rearLeft);
        printWriter.print(batteryControlSeatheaterInstallation.rearRight);
    }

    private void traceBatteryControlTimer(PrintWriter printWriter, BatteryControlTimer batteryControlTimer) {
        if (batteryControlTimer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlTimer.year);
        printWriter.print(batteryControlTimer.month);
        printWriter.print(batteryControlTimer.day);
        printWriter.print(batteryControlTimer.hour);
        printWriter.print(batteryControlTimer.minute);
        this.trace(printWriter, batteryControlTimer.weekdays);
        printWriter.print(batteryControlTimer.chargeSchedule);
        printWriter.print(batteryControlTimer.climateSchedule);
        printWriter.print(batteryControlTimer.refID);
    }

    private void traceBatteryControlTimerState(PrintWriter printWriter, BatteryControlTimerState batteryControlTimerState) {
        if (batteryControlTimerState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, batteryControlTimerState.programmedTimer);
        this.trace(printWriter, batteryControlTimerState.expiredTimer);
    }

    private void traceBatteryControlTransmittableElements(PrintWriter printWriter, BatteryControlTransmittableElements batteryControlTransmittableElements) {
        if (batteryControlTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlTransmittableElements.ra0);
        printWriter.print(batteryControlTransmittableElements.ra1);
        printWriter.print(batteryControlTransmittableElements.ra2);
        printWriter.print(batteryControlTransmittableElements.ra3);
        printWriter.print(batteryControlTransmittableElements.ra4);
        printWriter.print(batteryControlTransmittableElements.ra5);
        printWriter.print(batteryControlTransmittableElements.ra6);
        printWriter.print(batteryControlTransmittableElements.ra7);
        printWriter.print(batteryControlTransmittableElements.ra8);
        printWriter.print(batteryControlTransmittableElements.ra9);
        printWriter.print(batteryControlTransmittableElements.raA);
        printWriter.print(batteryControlTransmittableElements.raB);
        printWriter.print(batteryControlTransmittableElements.raC);
        printWriter.print(batteryControlTransmittableElements.raD);
        printWriter.print(batteryControlTransmittableElements.raE);
        printWriter.print(batteryControlTransmittableElements.raF);
    }

    private void traceBatteryControlViewOptions(PrintWriter printWriter, BatteryControlViewOptions batteryControlViewOptions) {
        if (batteryControlViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, batteryControlViewOptions.plug);
        this.trace(printWriter, batteryControlViewOptions.chargeState);
        this.trace(printWriter, batteryControlViewOptions.climateState);
        this.trace(printWriter, batteryControlViewOptions.timerState);
        this.trace(printWriter, batteryControlViewOptions.immediately);
        this.trace(printWriter, batteryControlViewOptions.timer1);
        this.trace(printWriter, batteryControlViewOptions.timer2);
        this.trace(printWriter, batteryControlViewOptions.timer3);
        this.trace(printWriter, batteryControlViewOptions.timer4);
        this.trace(printWriter, batteryControlViewOptions.profileList);
        this.trace(printWriter, batteryControlViewOptions.powerProviderList);
        this.trace(printWriter, batteryControlViewOptions.setFactoryDefault);
        this.trace(printWriter, batteryControlViewOptions.configuration);
        this.trace(printWriter, batteryControlViewOptions.pastErrorReason);
        this.trace(printWriter, batteryControlViewOptions.plugDisplayState);
        this.trace(printWriter, batteryControlViewOptions.remainingChargeTime);
        this.trace(printWriter, batteryControlViewOptions.lowestMaxCurrent);
    }

    private void traceBatteryControlWeekdays(PrintWriter printWriter, BatteryControlWeekdays batteryControlWeekdays) {
        if (batteryControlWeekdays == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlWeekdays.monday);
        printWriter.print(batteryControlWeekdays.tuesday);
        printWriter.print(batteryControlWeekdays.wednesday);
        printWriter.print(batteryControlWeekdays.thursday);
        printWriter.print(batteryControlWeekdays.friday);
        printWriter.print(batteryControlWeekdays.saturday);
        printWriter.print(batteryControlWeekdays.sunday);
        printWriter.print(batteryControlWeekdays.cyclic);
    }

    private void traceBatteryControlWindowheaterActivity(PrintWriter printWriter, BatteryControlWindowheaterActivity batteryControlWindowheaterActivity) {
        if (batteryControlWindowheaterActivity == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlWindowheaterActivity.front);
        printWriter.print(batteryControlWindowheaterActivity.rear);
    }

    private void traceBatteryControlWindowheaterInstallation(PrintWriter printWriter, BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation) {
        if (batteryControlWindowheaterInstallation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(batteryControlWindowheaterInstallation.front);
        printWriter.print(batteryControlWindowheaterInstallation.rear);
    }

    private void traceHybridConfiguration(PrintWriter printWriter, HybridConfiguration hybridConfiguration) {
        if (hybridConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hybridConfiguration.ice);
        printWriter.print(hybridConfiguration.ee1);
        printWriter.print(hybridConfiguration.ee2);
    }

    private void traceHybridEnergyFlowState(PrintWriter printWriter, HybridEnergyFlowState hybridEnergyFlowState) {
        if (hybridEnergyFlowState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hybridEnergyFlowState.motionState);
        printWriter.print(hybridEnergyFlowState.iCEState);
        printWriter.print(hybridEnergyFlowState.batteryState);
        printWriter.print(hybridEnergyFlowState.torqueState);
        printWriter.print(hybridEnergyFlowState.powerSupplyState);
        printWriter.print(hybridEnergyFlowState.ee1State);
        printWriter.print(hybridEnergyFlowState.ee2State);
        this.trace(printWriter, hybridEnergyFlowState.sinkState);
    }

    private void traceHybridInhibitReason(PrintWriter printWriter, HybridInhibitReason hybridInhibitReason) {
        if (hybridInhibitReason == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hybridInhibitReason.batteryCapacity);
        printWriter.print(hybridInhibitReason.batteryTemperatureLow);
        printWriter.print(hybridInhibitReason.batteryTemperatureHigh);
        printWriter.print(hybridInhibitReason.iceTemperatureLow);
        printWriter.print(hybridInhibitReason.powerEE);
        printWriter.print(hybridInhibitReason.speed);
        printWriter.print(hybridInhibitReason.fuelQuality);
        printWriter.print(hybridInhibitReason.engineProtection);
        printWriter.print(hybridInhibitReason.malfunctionLow);
        printWriter.print(hybridInhibitReason.malfunctionCritical);
        printWriter.print(hybridInhibitReason.leavingConcept);
        printWriter.print(hybridInhibitReason.diagnosis);
    }

    private void traceHybridSinkState(PrintWriter printWriter, HybridSinkState hybridSinkState) {
        if (hybridSinkState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hybridSinkState.installation);
        printWriter.print(hybridSinkState.heating);
        printWriter.print(hybridSinkState.cooling);
    }

    private void traceHybridTargetRange(PrintWriter printWriter, HybridTargetRange hybridTargetRange) {
        if (hybridTargetRange == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hybridTargetRange.maxRange);
        printWriter.print(hybridTargetRange.range);
        printWriter.print(hybridTargetRange.rangeUnit);
    }

    private void traceHybridViewOptions(PrintWriter printWriter, HybridViewOptions hybridViewOptions) {
        if (hybridViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, hybridViewOptions.hybridEnergyFlowState);
        this.trace(printWriter, hybridViewOptions.hybridCharge);
        this.trace(printWriter, hybridViewOptions.hybridRecoveredEnergy);
        this.trace(printWriter, hybridViewOptions.hybridEnergyFlow);
        this.trace(printWriter, hybridViewOptions.hybridConfiguration);
        this.trace(printWriter, hybridViewOptions.hybridTargetRange);
        this.trace(printWriter, hybridViewOptions.hybridEnergyAssistControl);
        this.trace(printWriter, hybridViewOptions.hybridEnergyAssistState);
        this.trace(printWriter, hybridViewOptions.hybridActivePedal);
        this.trace(printWriter, hybridViewOptions.hybridInhibitReason);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

