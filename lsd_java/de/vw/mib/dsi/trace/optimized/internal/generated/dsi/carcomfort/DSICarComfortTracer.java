/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carcomfort;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carcomfort.BrakeConfiguration;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingCLSettings;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListTransmittableElements;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKBatteryState;
import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKSpeedLimit;
import org.dsi.ifc.carcomfort.RDKSpeedLimitAvailability;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSConfiguration;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOConfiguration;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOTransmittableElements;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public final class DSICarComfortTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BRAKECONFIGURATION;
    private static final int ID_BRAKEVIEWOPTIONS;
    private static final int ID_DOORLOCKINGBOOTBLINDSTATE;
    private static final int ID_DOORLOCKINGCLSETTINGS;
    private static final int ID_DOORLOCKINGCOMFORTOPENSETTINGS;
    private static final int ID_DOORLOCKINGCONFIGURATION;
    private static final int ID_DOORLOCKINGLOCKSTATUS;
    private static final int ID_DOORLOCKINGMESSAGE;
    private static final int ID_DOORLOCKINGREARBLIND;
    private static final int ID_DOORLOCKINGTHEFTWARNINGSETTINGS;
    private static final int ID_DOORLOCKINGUSERLISTRA1;
    private static final int ID_DOORLOCKINGUSERLISTTRANSMITTABLEELEMENTS;
    private static final int ID_DOORLOCKINGUSERLISTUPDATEINFO;
    private static final int ID_DOORLOCKINGUSERPROFILEONOFF;
    private static final int ID_DOORLOCKINGVIEWOPTIONS;
    private static final int ID_DOORLOCKINGWINDOWSTATUS;
    private static final int ID_MIRRORVIEWOPTIONS;
    private static final int ID_RDKBATTERYSTATE;
    private static final int ID_RDKCONFIGURATION;
    private static final int ID_RDKRESIDUALBATTERYLIFETIME;
    private static final int ID_RDKSPEEDLIMIT;
    private static final int ID_RDKSPEEDLIMITAVAILABILITY;
    private static final int ID_RDKTIREDISPLAYDATA;
    private static final int ID_RDKTIREINFO;
    private static final int ID_RDKVIEWOPTIONS;
    private static final int ID_RDKWHEELPRESSURES;
    private static final int ID_RDKWHEELSTATES;
    private static final int ID_RDKWHEELTEMPERATURES;
    private static final int ID_RGSBELTPRETENSIONDATA;
    private static final int ID_RGSCONFIGURATION;
    private static final int ID_RGSLOCALHAZARDDETECTION;
    private static final int ID_RGSLOCALHAZARDINFORMATION;
    private static final int ID_RGSVIEWOPTIONS;
    private static final int ID_UGDOBUTTONLISTRA0;
    private static final int ID_UGDOBUTTONLISTRA1;
    private static final int ID_UGDOBUTTONLISTRA2;
    private static final int ID_UGDOBUTTONLISTRA3;
    private static final int ID_UGDOBUTTONLISTRA4;
    private static final int ID_UGDOBUTTONLISTRA5;
    private static final int ID_UGDOBUTTONLISTUPDATEINFO;
    private static final int ID_UGDOCONFIGURATION;
    private static final int ID_UGDOCONTENT;
    private static final int ID_UGDODESTINATIONREACHED;
    private static final int ID_UGDOLEARNINGDATA;
    private static final int ID_UGDOOPENDOOR;
    private static final int ID_UGDOSOFTKEYS;
    private static final int ID_UGDOSPECIALFEATURES;
    private static final int ID_UGDOSYNCHRONISATION;
    private static final int ID_UGDOTRANSMITTABLEELEMENTS;
    private static final int ID_UGDOVERSIONDATA;
    private static final int ID_UGDOVIEWOPTIONS;
    private static final int ID_WIPERVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$BrakeConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$BrakeViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingBootBlindState;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingCLSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingComfortOpenSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingLockStatus;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingMessage;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingRearBlind;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingTheftWarningSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingUserListRA1;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingUserListTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingUserListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingUserProfileOnOff;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DoorLockingWindowStatus;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$MirrorViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKBatteryState;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKResidualBatteryLifetime;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKSpeedLimit;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKSpeedLimitAvailability;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKTireDisplayData;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKTireInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKWheelPressures;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKWheelStates;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RDKWheelTemperatures;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RGSBeltPretensionData;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RGSConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RGSLocalHazardDetection;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RGSLocalHazardInformation;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$RGSViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA0;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA1;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA2;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA3;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA4;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListRA5;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOButtonListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOContent;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDODestinationReached;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOLearningData;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOOpenDoor;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOSoftkeys;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOSpecialFeatures;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOSynchronisation;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOVersionData;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$UGDOViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$WiperViewOptions;

    public DSICarComfortTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$BrakeConfiguration == null ? (class$org$dsi$ifc$carcomfort$BrakeConfiguration = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.BrakeConfiguration")) : class$org$dsi$ifc$carcomfort$BrakeConfiguration, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$BrakeViewOptions == null ? (class$org$dsi$ifc$carcomfort$BrakeViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.BrakeViewOptions")) : class$org$dsi$ifc$carcomfort$BrakeViewOptions, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingBootBlindState == null ? (class$org$dsi$ifc$carcomfort$DoorLockingBootBlindState = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingBootBlindState")) : class$org$dsi$ifc$carcomfort$DoorLockingBootBlindState, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingCLSettings == null ? (class$org$dsi$ifc$carcomfort$DoorLockingCLSettings = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingCLSettings")) : class$org$dsi$ifc$carcomfort$DoorLockingCLSettings, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingComfortOpenSettings == null ? (class$org$dsi$ifc$carcomfort$DoorLockingComfortOpenSettings = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings")) : class$org$dsi$ifc$carcomfort$DoorLockingComfortOpenSettings, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingConfiguration == null ? (class$org$dsi$ifc$carcomfort$DoorLockingConfiguration = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingConfiguration")) : class$org$dsi$ifc$carcomfort$DoorLockingConfiguration, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingLockStatus == null ? (class$org$dsi$ifc$carcomfort$DoorLockingLockStatus = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingLockStatus")) : class$org$dsi$ifc$carcomfort$DoorLockingLockStatus, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingMessage == null ? (class$org$dsi$ifc$carcomfort$DoorLockingMessage = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingMessage")) : class$org$dsi$ifc$carcomfort$DoorLockingMessage, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingRearBlind == null ? (class$org$dsi$ifc$carcomfort$DoorLockingRearBlind = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingRearBlind")) : class$org$dsi$ifc$carcomfort$DoorLockingRearBlind, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingTheftWarningSettings == null ? (class$org$dsi$ifc$carcomfort$DoorLockingTheftWarningSettings = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings")) : class$org$dsi$ifc$carcomfort$DoorLockingTheftWarningSettings, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingUserListRA1 == null ? (class$org$dsi$ifc$carcomfort$DoorLockingUserListRA1 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingUserListRA1")) : class$org$dsi$ifc$carcomfort$DoorLockingUserListRA1, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingUserListTransmittableElements == null ? (class$org$dsi$ifc$carcomfort$DoorLockingUserListTransmittableElements = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingUserListTransmittableElements")) : class$org$dsi$ifc$carcomfort$DoorLockingUserListTransmittableElements, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingUserListUpdateInfo == null ? (class$org$dsi$ifc$carcomfort$DoorLockingUserListUpdateInfo = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo")) : class$org$dsi$ifc$carcomfort$DoorLockingUserListUpdateInfo, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingUserProfileOnOff == null ? (class$org$dsi$ifc$carcomfort$DoorLockingUserProfileOnOff = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff")) : class$org$dsi$ifc$carcomfort$DoorLockingUserProfileOnOff, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingViewOptions == null ? (class$org$dsi$ifc$carcomfort$DoorLockingViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingViewOptions")) : class$org$dsi$ifc$carcomfort$DoorLockingViewOptions, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$DoorLockingWindowStatus == null ? (class$org$dsi$ifc$carcomfort$DoorLockingWindowStatus = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.DoorLockingWindowStatus")) : class$org$dsi$ifc$carcomfort$DoorLockingWindowStatus, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$MirrorViewOptions == null ? (class$org$dsi$ifc$carcomfort$MirrorViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.MirrorViewOptions")) : class$org$dsi$ifc$carcomfort$MirrorViewOptions, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKBatteryState == null ? (class$org$dsi$ifc$carcomfort$RDKBatteryState = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKBatteryState")) : class$org$dsi$ifc$carcomfort$RDKBatteryState, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKConfiguration == null ? (class$org$dsi$ifc$carcomfort$RDKConfiguration = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKConfiguration")) : class$org$dsi$ifc$carcomfort$RDKConfiguration, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKResidualBatteryLifetime == null ? (class$org$dsi$ifc$carcomfort$RDKResidualBatteryLifetime = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime")) : class$org$dsi$ifc$carcomfort$RDKResidualBatteryLifetime, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKSpeedLimit == null ? (class$org$dsi$ifc$carcomfort$RDKSpeedLimit = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKSpeedLimit")) : class$org$dsi$ifc$carcomfort$RDKSpeedLimit, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKSpeedLimitAvailability == null ? (class$org$dsi$ifc$carcomfort$RDKSpeedLimitAvailability = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKSpeedLimitAvailability")) : class$org$dsi$ifc$carcomfort$RDKSpeedLimitAvailability, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKTireDisplayData == null ? (class$org$dsi$ifc$carcomfort$RDKTireDisplayData = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKTireDisplayData")) : class$org$dsi$ifc$carcomfort$RDKTireDisplayData, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKTireInfo == null ? (class$org$dsi$ifc$carcomfort$RDKTireInfo = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKTireInfo")) : class$org$dsi$ifc$carcomfort$RDKTireInfo, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKViewOptions == null ? (class$org$dsi$ifc$carcomfort$RDKViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKViewOptions")) : class$org$dsi$ifc$carcomfort$RDKViewOptions, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKWheelPressures == null ? (class$org$dsi$ifc$carcomfort$RDKWheelPressures = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKWheelPressures")) : class$org$dsi$ifc$carcomfort$RDKWheelPressures, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKWheelStates == null ? (class$org$dsi$ifc$carcomfort$RDKWheelStates = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKWheelStates")) : class$org$dsi$ifc$carcomfort$RDKWheelStates, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RDKWheelTemperatures == null ? (class$org$dsi$ifc$carcomfort$RDKWheelTemperatures = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RDKWheelTemperatures")) : class$org$dsi$ifc$carcomfort$RDKWheelTemperatures, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RGSBeltPretensionData == null ? (class$org$dsi$ifc$carcomfort$RGSBeltPretensionData = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RGSBeltPretensionData")) : class$org$dsi$ifc$carcomfort$RGSBeltPretensionData, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RGSConfiguration == null ? (class$org$dsi$ifc$carcomfort$RGSConfiguration = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RGSConfiguration")) : class$org$dsi$ifc$carcomfort$RGSConfiguration, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RGSLocalHazardDetection == null ? (class$org$dsi$ifc$carcomfort$RGSLocalHazardDetection = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RGSLocalHazardDetection")) : class$org$dsi$ifc$carcomfort$RGSLocalHazardDetection, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RGSLocalHazardInformation == null ? (class$org$dsi$ifc$carcomfort$RGSLocalHazardInformation = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RGSLocalHazardInformation")) : class$org$dsi$ifc$carcomfort$RGSLocalHazardInformation, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$RGSViewOptions == null ? (class$org$dsi$ifc$carcomfort$RGSViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.RGSViewOptions")) : class$org$dsi$ifc$carcomfort$RGSViewOptions, 33);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA0 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA0 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA0")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA0, 34);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA1 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA1 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA1")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA1, 35);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA2 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA2 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA2")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA2, 36);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA3 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA3 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA3")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA3, 37);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA4 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA4 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA4")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA4, 38);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListRA5 == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListRA5 = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListRA5")) : class$org$dsi$ifc$carcomfort$UGDOButtonListRA5, 39);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOButtonListUpdateInfo == null ? (class$org$dsi$ifc$carcomfort$UGDOButtonListUpdateInfo = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo")) : class$org$dsi$ifc$carcomfort$UGDOButtonListUpdateInfo, 40);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOConfiguration == null ? (class$org$dsi$ifc$carcomfort$UGDOConfiguration = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOConfiguration")) : class$org$dsi$ifc$carcomfort$UGDOConfiguration, 41);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOContent == null ? (class$org$dsi$ifc$carcomfort$UGDOContent = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOContent")) : class$org$dsi$ifc$carcomfort$UGDOContent, 42);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDODestinationReached == null ? (class$org$dsi$ifc$carcomfort$UGDODestinationReached = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDODestinationReached")) : class$org$dsi$ifc$carcomfort$UGDODestinationReached, 43);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOLearningData == null ? (class$org$dsi$ifc$carcomfort$UGDOLearningData = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOLearningData")) : class$org$dsi$ifc$carcomfort$UGDOLearningData, 44);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOOpenDoor == null ? (class$org$dsi$ifc$carcomfort$UGDOOpenDoor = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOOpenDoor")) : class$org$dsi$ifc$carcomfort$UGDOOpenDoor, 45);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOSoftkeys == null ? (class$org$dsi$ifc$carcomfort$UGDOSoftkeys = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOSoftkeys")) : class$org$dsi$ifc$carcomfort$UGDOSoftkeys, 46);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOSpecialFeatures == null ? (class$org$dsi$ifc$carcomfort$UGDOSpecialFeatures = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOSpecialFeatures")) : class$org$dsi$ifc$carcomfort$UGDOSpecialFeatures, 47);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOSynchronisation == null ? (class$org$dsi$ifc$carcomfort$UGDOSynchronisation = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOSynchronisation")) : class$org$dsi$ifc$carcomfort$UGDOSynchronisation, 48);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOTransmittableElements == null ? (class$org$dsi$ifc$carcomfort$UGDOTransmittableElements = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOTransmittableElements")) : class$org$dsi$ifc$carcomfort$UGDOTransmittableElements, 49);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOVersionData == null ? (class$org$dsi$ifc$carcomfort$UGDOVersionData = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOVersionData")) : class$org$dsi$ifc$carcomfort$UGDOVersionData, 50);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$UGDOViewOptions == null ? (class$org$dsi$ifc$carcomfort$UGDOViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.UGDOViewOptions")) : class$org$dsi$ifc$carcomfort$UGDOViewOptions, 51);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carcomfort$WiperViewOptions == null ? (class$org$dsi$ifc$carcomfort$WiperViewOptions = DSICarComfortTracer.class$("org.dsi.ifc.carcomfort.WiperViewOptions")) : class$org$dsi$ifc$carcomfort$WiperViewOptions, 52);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBrakeConfiguration(printWriter, (BrakeConfiguration)object);
                break;
            }
            case 2: {
                this.traceBrakeViewOptions(printWriter, (BrakeViewOptions)object);
                break;
            }
            case 3: {
                this.traceDoorLockingBootBlindState(printWriter, (DoorLockingBootBlindState)object);
                break;
            }
            case 4: {
                this.traceDoorLockingCLSettings(printWriter, (DoorLockingCLSettings)object);
                break;
            }
            case 5: {
                this.traceDoorLockingComfortOpenSettings(printWriter, (DoorLockingComfortOpenSettings)object);
                break;
            }
            case 6: {
                this.traceDoorLockingConfiguration(printWriter, (DoorLockingConfiguration)object);
                break;
            }
            case 7: {
                this.traceDoorLockingLockStatus(printWriter, (DoorLockingLockStatus)object);
                break;
            }
            case 8: {
                this.traceDoorLockingMessage(printWriter, (DoorLockingMessage)object);
                break;
            }
            case 9: {
                this.traceDoorLockingRearBlind(printWriter, (DoorLockingRearBlind)object);
                break;
            }
            case 10: {
                this.traceDoorLockingTheftWarningSettings(printWriter, (DoorLockingTheftWarningSettings)object);
                break;
            }
            case 11: {
                this.traceDoorLockingUserListRA1(printWriter, (DoorLockingUserListRA1)object);
                break;
            }
            case 12: {
                this.traceDoorLockingUserListTransmittableElements(printWriter, (DoorLockingUserListTransmittableElements)object);
                break;
            }
            case 13: {
                this.traceDoorLockingUserListUpdateInfo(printWriter, (DoorLockingUserListUpdateInfo)object);
                break;
            }
            case 14: {
                this.traceDoorLockingUserProfileOnOff(printWriter, (DoorLockingUserProfileOnOff)object);
                break;
            }
            case 15: {
                this.traceDoorLockingViewOptions(printWriter, (DoorLockingViewOptions)object);
                break;
            }
            case 16: {
                this.traceDoorLockingWindowStatus(printWriter, (DoorLockingWindowStatus)object);
                break;
            }
            case 17: {
                this.traceMirrorViewOptions(printWriter, (MirrorViewOptions)object);
                break;
            }
            case 18: {
                this.traceRDKBatteryState(printWriter, (RDKBatteryState)object);
                break;
            }
            case 19: {
                this.traceRDKConfiguration(printWriter, (RDKConfiguration)object);
                break;
            }
            case 20: {
                this.traceRDKResidualBatteryLifetime(printWriter, (RDKResidualBatteryLifetime)object);
                break;
            }
            case 21: {
                this.traceRDKSpeedLimit(printWriter, (RDKSpeedLimit)object);
                break;
            }
            case 22: {
                this.traceRDKSpeedLimitAvailability(printWriter, (RDKSpeedLimitAvailability)object);
                break;
            }
            case 23: {
                this.traceRDKTireDisplayData(printWriter, (RDKTireDisplayData)object);
                break;
            }
            case 24: {
                this.traceRDKTireInfo(printWriter, (RDKTireInfo)object);
                break;
            }
            case 25: {
                this.traceRDKViewOptions(printWriter, (RDKViewOptions)object);
                break;
            }
            case 26: {
                this.traceRDKWheelPressures(printWriter, (RDKWheelPressures)object);
                break;
            }
            case 27: {
                this.traceRDKWheelStates(printWriter, (RDKWheelStates)object);
                break;
            }
            case 28: {
                this.traceRDKWheelTemperatures(printWriter, (RDKWheelTemperatures)object);
                break;
            }
            case 29: {
                this.traceRGSBeltPretensionData(printWriter, (RGSBeltPretensionData)object);
                break;
            }
            case 30: {
                this.traceRGSConfiguration(printWriter, (RGSConfiguration)object);
                break;
            }
            case 31: {
                this.traceRGSLocalHazardDetection(printWriter, (RGSLocalHazardDetection)object);
                break;
            }
            case 32: {
                this.traceRGSLocalHazardInformation(printWriter, (RGSLocalHazardInformation)object);
                break;
            }
            case 33: {
                this.traceRGSViewOptions(printWriter, (RGSViewOptions)object);
                break;
            }
            case 34: {
                this.traceUGDOButtonListRA0(printWriter, (UGDOButtonListRA0)object);
                break;
            }
            case 35: {
                this.traceUGDOButtonListRA1(printWriter, (UGDOButtonListRA1)object);
                break;
            }
            case 36: {
                this.traceUGDOButtonListRA2(printWriter, (UGDOButtonListRA2)object);
                break;
            }
            case 37: {
                this.traceUGDOButtonListRA3(printWriter, (UGDOButtonListRA3)object);
                break;
            }
            case 38: {
                this.traceUGDOButtonListRA4(printWriter, (UGDOButtonListRA4)object);
                break;
            }
            case 39: {
                this.traceUGDOButtonListRA5(printWriter, (UGDOButtonListRA5)object);
                break;
            }
            case 40: {
                this.traceUGDOButtonListUpdateInfo(printWriter, (UGDOButtonListUpdateInfo)object);
                break;
            }
            case 41: {
                this.traceUGDOConfiguration(printWriter, (UGDOConfiguration)object);
                break;
            }
            case 42: {
                this.traceUGDOContent(printWriter, (UGDOContent)object);
                break;
            }
            case 43: {
                this.traceUGDODestinationReached(printWriter, (UGDODestinationReached)object);
                break;
            }
            case 44: {
                this.traceUGDOLearningData(printWriter, (UGDOLearningData)object);
                break;
            }
            case 45: {
                this.traceUGDOOpenDoor(printWriter, (UGDOOpenDoor)object);
                break;
            }
            case 46: {
                this.traceUGDOSoftkeys(printWriter, (UGDOSoftkeys)object);
                break;
            }
            case 47: {
                this.traceUGDOSpecialFeatures(printWriter, (UGDOSpecialFeatures)object);
                break;
            }
            case 48: {
                this.traceUGDOSynchronisation(printWriter, (UGDOSynchronisation)object);
                break;
            }
            case 49: {
                this.traceUGDOTransmittableElements(printWriter, (UGDOTransmittableElements)object);
                break;
            }
            case 50: {
                this.traceUGDOVersionData(printWriter, (UGDOVersionData)object);
                break;
            }
            case 51: {
                this.traceUGDOViewOptions(printWriter, (UGDOViewOptions)object);
                break;
            }
            case 52: {
                this.traceWiperViewOptions(printWriter, (WiperViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBrakeConfiguration(PrintWriter printWriter, BrakeConfiguration brakeConfiguration) {
        if (brakeConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(brakeConfiguration.autoHoldLastMode);
        printWriter.print(brakeConfiguration.autoHoldOnOff);
        printWriter.print(brakeConfiguration.escOff);
        printWriter.print(brakeConfiguration.escSport);
        printWriter.print(brakeConfiguration.escTcsOff);
        printWriter.print(brakeConfiguration.escOffroad);
        printWriter.print(brakeConfiguration.systemtype);
    }

    private void traceBrakeViewOptions(PrintWriter printWriter, BrakeViewOptions brakeViewOptions) {
        if (brakeViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, brakeViewOptions.brakeElectricalParking);
        this.trace(printWriter, brakeViewOptions.brakeAutoHold);
        this.trace(printWriter, brakeViewOptions.brakeEscMode);
        this.trace(printWriter, brakeViewOptions.configuration);
        this.trace(printWriter, brakeViewOptions.brakeHdcMode);
    }

    private void traceDoorLockingBootBlindState(PrintWriter printWriter, DoorLockingBootBlindState doorLockingBootBlindState) {
        if (doorLockingBootBlindState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingBootBlindState.control);
        printWriter.print(doorLockingBootBlindState.motionState);
    }

    private void traceDoorLockingCLSettings(PrintWriter printWriter, DoorLockingCLSettings doorLockingCLSettings) {
        if (doorLockingCLSettings == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingCLSettings.seperateDoor);
        printWriter.print(doorLockingCLSettings.sideDoors);
        printWriter.print(doorLockingCLSettings.allDoors);
    }

    private void traceDoorLockingComfortOpenSettings(PrintWriter printWriter, DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        if (doorLockingComfortOpenSettings == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingComfortOpenSettings.driverWindow);
        printWriter.print(doorLockingComfortOpenSettings.codriverWindow);
        printWriter.print(doorLockingComfortOpenSettings.driverRearWindow);
        printWriter.print(doorLockingComfortOpenSettings.codriverRearWindow);
        printWriter.print(doorLockingComfortOpenSettings.sunRoof);
        printWriter.print(doorLockingComfortOpenSettings.rearBlind);
    }

    private void traceDoorLockingConfiguration(PrintWriter printWriter, DoorLockingConfiguration doorLockingConfiguration) {
        if (doorLockingConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingConfiguration.numberOfDoors);
        printWriter.print(doorLockingConfiguration.numberOfWindows);
        printWriter.print(doorLockingConfiguration.sunRoof);
        printWriter.print(doorLockingConfiguration.rearBlindButton);
        printWriter.print(doorLockingConfiguration.rearBlindSunProtection);
        printWriter.print(doorLockingConfiguration.rearBlindReverseGear);
        printWriter.print(doorLockingConfiguration.kessy);
        printWriter.print(doorLockingConfiguration.bootBlind);
        printWriter.print(doorLockingConfiguration.individual);
        printWriter.print(doorLockingConfiguration.profiles);
        this.trace(printWriter, doorLockingConfiguration.profilesTransmittableElements);
        printWriter.print(doorLockingConfiguration.driverWindowInCO);
        printWriter.print(doorLockingConfiguration.extendedKeyMapping);
        printWriter.print(doorLockingConfiguration.keyDetection);
        printWriter.print(doorLockingConfiguration.atne);
        printWriter.print(doorLockingConfiguration.temporaryKeyAssignment);
        printWriter.print(doorLockingConfiguration.sideBlinds);
        printWriter.print(doorLockingConfiguration.keyMappingAutomatic);
        this.trace(printWriter, doorLockingConfiguration.centralLockingSettings);
        printWriter.print(doorLockingConfiguration.restore);
        printWriter.print(doorLockingConfiguration.numOfParams);
    }

    private void traceDoorLockingLockStatus(PrintWriter printWriter, DoorLockingLockStatus doorLockingLockStatus) {
        if (doorLockingLockStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingLockStatus.vehicleLockState);
        printWriter.print(doorLockingLockStatus.driverDoor);
        printWriter.print(doorLockingLockStatus.codriverDoor);
        printWriter.print(doorLockingLockStatus.fondDoorRight);
        printWriter.print(doorLockingLockStatus.fondDoorLeft);
        printWriter.print(doorLockingLockStatus.hood);
        printWriter.print(doorLockingLockStatus.bootlid);
        printWriter.print(doorLockingLockStatus.flap);
        printWriter.print(doorLockingLockStatus.vehicleSafe);
    }

    private void traceDoorLockingMessage(PrintWriter printWriter, DoorLockingMessage doorLockingMessage) {
        if (doorLockingMessage == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingMessage.remoteKeyBatteryLow);
        printWriter.print(doorLockingMessage.secondKeyInVehicle);
        printWriter.print(doorLockingMessage.keyDetectedInVehicle);
        printWriter.print(doorLockingMessage.keyInBoot);
        printWriter.print(doorLockingMessage.immobilizerActive);
        printWriter.print(doorLockingMessage.keyNotFound);
        printWriter.print(doorLockingMessage.removeKey);
        printWriter.print(doorLockingMessage.depressBrakePedal);
        printWriter.print(doorLockingMessage.depressClutch);
        printWriter.print(doorLockingMessage.steeringLockDefective);
        printWriter.print(doorLockingMessage.steeringNotUnlocked);
        printWriter.print(doorLockingMessage.steeringLockWorkshop);
        printWriter.print(doorLockingMessage.moveSteeringWheel);
        printWriter.print(doorLockingMessage.moveSelectorToPositionN);
        printWriter.print(doorLockingMessage.moveSelectorToPositionP);
        printWriter.print(doorLockingMessage.startEngine);
        printWriter.print(doorLockingMessage.immobilizerAdjustmentActive);
        printWriter.print(doorLockingMessage.immobilizerAdjustmentFault);
        printWriter.print(doorLockingMessage.immobilizerEndOfLineFault);
        printWriter.print(doorLockingMessage.immobilizerAdjustmentOk);
    }

    private void traceDoorLockingRearBlind(PrintWriter printWriter, DoorLockingRearBlind doorLockingRearBlind) {
        if (doorLockingRearBlind == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingRearBlind.rearBlindButton);
        printWriter.print(doorLockingRearBlind.rearBlindSunProtection);
        printWriter.print(doorLockingRearBlind.rearBlindReverseGear);
    }

    private void traceDoorLockingTheftWarningSettings(PrintWriter printWriter, DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        if (doorLockingTheftWarningSettings == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingTheftWarningSettings.interior);
        printWriter.print(doorLockingTheftWarningSettings.decline);
    }

    private void traceDoorLockingUserListRA1(PrintWriter printWriter, DoorLockingUserListRA1 doorLockingUserListRA1) {
        if (doorLockingUserListRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingUserListRA1.pos);
        printWriter.print(doorLockingUserListRA1.type);
        printWriter.print(doorLockingUserListRA1.name);
    }

    private void traceDoorLockingUserListTransmittableElements(PrintWriter printWriter, DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements) {
        if (doorLockingUserListTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingUserListTransmittableElements.ra1);
        printWriter.print(doorLockingUserListTransmittableElements.raF);
    }

    private void traceDoorLockingUserListUpdateInfo(PrintWriter printWriter, DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        if (doorLockingUserListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingUserListUpdateInfo.arrayContent);
        printWriter.print(doorLockingUserListUpdateInfo.recordContent);
        printWriter.print(doorLockingUserListUpdateInfo.transactionID);
        printWriter.print(doorLockingUserListUpdateInfo.startElement);
        printWriter.print(doorLockingUserListUpdateInfo.numOfElements);
        printWriter.print(doorLockingUserListUpdateInfo.asgID);
    }

    private void traceDoorLockingUserProfileOnOff(PrintWriter printWriter, DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        if (doorLockingUserProfileOnOff == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingUserProfileOnOff.handling);
        printWriter.print(doorLockingUserProfileOnOff.autoKeyAssignment);
        printWriter.print(doorLockingUserProfileOnOff.temporaryKeyAssignment);
        printWriter.print(doorLockingUserProfileOnOff.atneInMotion);
    }

    private void traceDoorLockingViewOptions(PrintWriter printWriter, DoorLockingViewOptions doorLockingViewOptions) {
        if (doorLockingViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, doorLockingViewOptions.message);
        this.trace(printWriter, doorLockingViewOptions.lockStatus);
        this.trace(printWriter, doorLockingViewOptions.windowStatus);
        this.trace(printWriter, doorLockingViewOptions.unlockingMode);
        this.trace(printWriter, doorLockingViewOptions.autoLock);
        this.trace(printWriter, doorLockingViewOptions.clBootLock);
        this.trace(printWriter, doorLockingViewOptions.mirrorProtection);
        this.trace(printWriter, doorLockingViewOptions.lockingConfirmation);
        this.trace(printWriter, doorLockingViewOptions.comfortOpen);
        this.trace(printWriter, doorLockingViewOptions.rainClosing);
        this.trace(printWriter, doorLockingViewOptions.rearBlind);
        this.trace(printWriter, doorLockingViewOptions.theftWarning);
        this.trace(printWriter, doorLockingViewOptions.autoUnlock);
        this.trace(printWriter, doorLockingViewOptions.doorLockingSetFactoryDefault);
        this.trace(printWriter, doorLockingViewOptions.clBootOpen);
        this.trace(printWriter, doorLockingViewOptions.bootOpen);
        this.trace(printWriter, doorLockingViewOptions.bootClose);
        this.trace(printWriter, doorLockingViewOptions.remoteLockUnlock);
        this.trace(printWriter, doorLockingViewOptions.remoteBlinking);
        this.trace(printWriter, doorLockingViewOptions.remoteHorn);
        this.trace(printWriter, doorLockingViewOptions.userList);
        this.trace(printWriter, doorLockingViewOptions.activeUser);
        this.trace(printWriter, doorLockingViewOptions.userProfileOnOff);
        this.trace(printWriter, doorLockingViewOptions.userProfileControl);
        this.trace(printWriter, doorLockingViewOptions.windowAutoClose);
        this.trace(printWriter, doorLockingViewOptions.blindsControl);
        this.trace(printWriter, doorLockingViewOptions.blindsControlExtended);
        this.trace(printWriter, doorLockingViewOptions.leftSideBlindControl);
        this.trace(printWriter, doorLockingViewOptions.rightSideBlindControl);
        this.trace(printWriter, doorLockingViewOptions.prompt);
        this.trace(printWriter, doorLockingViewOptions.turnIndRepeat);
        this.trace(printWriter, doorLockingViewOptions.keyless);
        this.trace(printWriter, doorLockingViewOptions.configuration);
    }

    private void traceDoorLockingWindowStatus(PrintWriter printWriter, DoorLockingWindowStatus doorLockingWindowStatus) {
        if (doorLockingWindowStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(doorLockingWindowStatus.windowDriver);
        printWriter.print(doorLockingWindowStatus.windowCodriver);
        printWriter.print(doorLockingWindowStatus.windowFondRight);
        printWriter.print(doorLockingWindowStatus.windowFondLeft);
        printWriter.print(doorLockingWindowStatus.sunRoof);
    }

    private void traceMirrorViewOptions(PrintWriter printWriter, MirrorViewOptions mirrorViewOptions) {
        if (mirrorViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, mirrorViewOptions.mirrorLowering);
        this.trace(printWriter, mirrorViewOptions.mirrorSyncAdjust);
        this.trace(printWriter, mirrorViewOptions.mirrorFolding);
        this.trace(printWriter, mirrorViewOptions.mirrorDimming);
        this.trace(printWriter, mirrorViewOptions.mirrorHeating);
        this.trace(printWriter, mirrorViewOptions.mirrorSetFactoryDefault);
    }

    private void traceRDKBatteryState(PrintWriter printWriter, RDKBatteryState rDKBatteryState) {
        if (rDKBatteryState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKBatteryState.okFrontLeft);
        printWriter.print(rDKBatteryState.okFrontRight);
        printWriter.print(rDKBatteryState.okRearLeft);
        printWriter.print(rDKBatteryState.okRearRight);
        printWriter.print(rDKBatteryState.okSpareWheel);
    }

    private void traceRDKConfiguration(PrintWriter printWriter, RDKConfiguration rDKConfiguration) {
        if (rDKConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKConfiguration.system);
        this.trace(printWriter, rDKConfiguration.speedLimitAvailability);
        printWriter.print(rDKConfiguration.pressureLevel2);
        printWriter.print(rDKConfiguration.pressureLevel3);
        printWriter.print(rDKConfiguration.pressureLevel1);
        printWriter.print(rDKConfiguration.pressureLevel4);
        printWriter.print(rDKConfiguration.wheelDetails);
        printWriter.print(rDKConfiguration.calibrationViaHardkey);
        printWriter.print(rDKConfiguration.systemType);
    }

    private void traceRDKResidualBatteryLifetime(PrintWriter printWriter, RDKResidualBatteryLifetime rDKResidualBatteryLifetime) {
        if (rDKResidualBatteryLifetime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeUnit);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeFrontLeft);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeFrontRight);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeRearLeft);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeRearRight);
        printWriter.print(rDKResidualBatteryLifetime.lifetimeSpareWheel);
        this.trace(printWriter, rDKResidualBatteryLifetime.batteryState);
    }

    private void traceRDKSpeedLimit(PrintWriter printWriter, RDKSpeedLimit rDKSpeedLimit) {
        if (rDKSpeedLimit == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKSpeedLimit.state);
        printWriter.print(rDKSpeedLimit.speedValue);
        printWriter.print(rDKSpeedLimit.speedUnit);
    }

    private void traceRDKSpeedLimitAvailability(PrintWriter printWriter, RDKSpeedLimitAvailability rDKSpeedLimitAvailability) {
        if (rDKSpeedLimitAvailability == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKSpeedLimitAvailability.speedLimit1);
        printWriter.print(rDKSpeedLimitAvailability.speedLimit2);
        printWriter.print(rDKSpeedLimitAvailability.speedLimit3);
    }

    private void traceRDKTireDisplayData(PrintWriter printWriter, RDKTireDisplayData rDKTireDisplayData) {
        if (rDKTireDisplayData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, rDKTireDisplayData.wheelStates);
        this.trace(printWriter, rDKTireDisplayData.wheelPressures);
        this.trace(printWriter, rDKTireDisplayData.requiredWheelPressures);
        this.trace(printWriter, rDKTireDisplayData.wheelTemperatures);
    }

    private void traceRDKTireInfo(PrintWriter printWriter, RDKTireInfo rDKTireInfo) {
        if (rDKTireInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKTireInfo.position);
        printWriter.print(rDKTireInfo.vendorName);
        printWriter.print(rDKTireInfo.wheelSize);
        printWriter.print(rDKTireInfo.wheelType);
        printWriter.print(rDKTireInfo.frontPressure1);
        printWriter.print(rDKTireInfo.frontPressure2);
        printWriter.print(rDKTireInfo.frontPressure3);
        printWriter.print(rDKTireInfo.rearPressure1);
        printWriter.print(rDKTireInfo.rearPressure2);
        printWriter.print(rDKTireInfo.rearPressure3);
        printWriter.print(rDKTireInfo.spareWheelPressure);
        printWriter.print(rDKTireInfo.pressureUnit);
        this.trace(printWriter, rDKTireInfo.speedLimit1);
        this.trace(printWriter, rDKTireInfo.speedLimit2);
        this.trace(printWriter, rDKTireInfo.speedLimit3);
        printWriter.print(rDKTireInfo.frontPressure4);
        printWriter.print(rDKTireInfo.rearPressure4);
    }

    private void traceRDKViewOptions(PrintWriter printWriter, RDKViewOptions rDKViewOptions) {
        if (rDKViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, rDKViewOptions.tireDisplay);
        this.trace(printWriter, rDKViewOptions.tireChanged);
        this.trace(printWriter, rDKViewOptions.pressureChanged);
        this.trace(printWriter, rDKViewOptions.systemOnOff);
        this.trace(printWriter, rDKViewOptions.speedLimit);
        this.trace(printWriter, rDKViewOptions.tireSetup);
        this.trace(printWriter, rDKViewOptions.configuration);
        this.trace(printWriter, rDKViewOptions.pressureLevel);
        this.trace(printWriter, rDKViewOptions.differentialPressure);
        this.trace(printWriter, rDKViewOptions.residualBatteryLifetime);
        this.trace(printWriter, rDKViewOptions.actualState);
        this.trace(printWriter, rDKViewOptions.actualPressure);
        this.trace(printWriter, rDKViewOptions.requiredPressure);
        this.trace(printWriter, rDKViewOptions.actualTemperature);
        this.trace(printWriter, rDKViewOptions.setFactoryDefault);
    }

    private void traceRDKWheelPressures(PrintWriter printWriter, RDKWheelPressures rDKWheelPressures) {
        if (rDKWheelPressures == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKWheelPressures.pressureUnit);
        printWriter.print(rDKWheelPressures.frontLeft);
        printWriter.print(rDKWheelPressures.frontRight);
        printWriter.print(rDKWheelPressures.rearLeft);
        printWriter.print(rDKWheelPressures.rearRight);
        printWriter.print(rDKWheelPressures.spareWheel);
    }

    private void traceRDKWheelStates(PrintWriter printWriter, RDKWheelStates rDKWheelStates) {
        if (rDKWheelStates == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKWheelStates.frontLeft);
        printWriter.print(rDKWheelStates.frontRight);
        printWriter.print(rDKWheelStates.rearLeft);
        printWriter.print(rDKWheelStates.rearRight);
        printWriter.print(rDKWheelStates.spareWheel);
        printWriter.print(rDKWheelStates.collectedState);
    }

    private void traceRDKWheelTemperatures(PrintWriter printWriter, RDKWheelTemperatures rDKWheelTemperatures) {
        if (rDKWheelTemperatures == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rDKWheelTemperatures.temperatureUnit);
        printWriter.print(rDKWheelTemperatures.frontLeft);
        printWriter.print(rDKWheelTemperatures.frontRight);
        printWriter.print(rDKWheelTemperatures.rearLeft);
        printWriter.print(rDKWheelTemperatures.rearRight);
        printWriter.print(rDKWheelTemperatures.spareWheel);
    }

    private void traceRGSBeltPretensionData(PrintWriter printWriter, RGSBeltPretensionData rGSBeltPretensionData) {
        if (rGSBeltPretensionData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rGSBeltPretensionData.left);
        printWriter.print(rGSBeltPretensionData.right);
    }

    private void traceRGSConfiguration(PrintWriter printWriter, RGSConfiguration rGSConfiguration) {
        if (rGSConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rGSConfiguration.driverSide);
    }

    private void traceRGSLocalHazardDetection(PrintWriter printWriter, RGSLocalHazardDetection rGSLocalHazardDetection) {
        if (rGSLocalHazardDetection == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rGSLocalHazardDetection.eventClass);
        printWriter.print(rGSLocalHazardDetection.eventTransaction);
        printWriter.print(rGSLocalHazardDetection.eventQuality);
        printWriter.print(rGSLocalHazardDetection.eventCourse);
        printWriter.print(rGSLocalHazardDetection.eventPositionLatitude);
        printWriter.print(rGSLocalHazardDetection.eventPositionLongitude);
    }

    private void traceRGSLocalHazardInformation(PrintWriter printWriter, RGSLocalHazardInformation rGSLocalHazardInformation) {
        if (rGSLocalHazardInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rGSLocalHazardInformation.eventID);
        printWriter.print(rGSLocalHazardInformation.eventType);
        printWriter.print(rGSLocalHazardInformation.eventQuality);
        this.trace(printWriter, rGSLocalHazardInformation.approach);
    }

    private void traceRGSViewOptions(PrintWriter printWriter, RGSViewOptions rGSViewOptions) {
        if (rGSViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, rGSViewOptions.beltPretensionerFrontDataLeft);
        this.trace(printWriter, rGSViewOptions.beltPretensionerFrontDataRight);
        this.trace(printWriter, rGSViewOptions.beltPretensionerRearDataLeft);
        this.trace(printWriter, rGSViewOptions.beltPretensionerRearDataRight);
        this.trace(printWriter, rGSViewOptions.preCrashSystem);
        this.trace(printWriter, rGSViewOptions.rgsSetFactoryDefault);
        this.trace(printWriter, rGSViewOptions.preSenseSystem);
        this.trace(printWriter, rGSViewOptions.preSenseWarning);
        this.trace(printWriter, rGSViewOptions.localHazardDetection);
        this.trace(printWriter, rGSViewOptions.localHazardInformation);
        this.trace(printWriter, rGSViewOptions.configuration);
    }

    private void traceUGDOButtonListRA0(PrintWriter printWriter, UGDOButtonListRA0 uGDOButtonListRA0) {
        if (uGDOButtonListRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA0.pos);
        printWriter.print(uGDOButtonListRA0.name);
        printWriter.print(uGDOButtonListRA0.positionLatitude);
        printWriter.print(uGDOButtonListRA0.positionLongitude);
        printWriter.print(uGDOButtonListRA0.learnedState);
        printWriter.print(uGDOButtonListRA0.hardkey);
        printWriter.print(uGDOButtonListRA0.softkey);
        this.trace(printWriter, uGDOButtonListRA0.specialFeatures);
    }

    private void traceUGDOButtonListRA1(PrintWriter printWriter, UGDOButtonListRA1 uGDOButtonListRA1) {
        if (uGDOButtonListRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA1.pos);
        printWriter.print(uGDOButtonListRA1.positionLatitude);
        printWriter.print(uGDOButtonListRA1.positionLongitude);
        printWriter.print(uGDOButtonListRA1.learnedState);
        this.trace(printWriter, uGDOButtonListRA1.specialFeatures);
    }

    private void traceUGDOButtonListRA2(PrintWriter printWriter, UGDOButtonListRA2 uGDOButtonListRA2) {
        if (uGDOButtonListRA2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA2.pos);
        printWriter.print(uGDOButtonListRA2.learnedState);
        this.trace(printWriter, uGDOButtonListRA2.specialFeatures);
    }

    private void traceUGDOButtonListRA3(PrintWriter printWriter, UGDOButtonListRA3 uGDOButtonListRA3) {
        if (uGDOButtonListRA3 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA3.pos);
        this.trace(printWriter, uGDOButtonListRA3.specialFeatures);
    }

    private void traceUGDOButtonListRA4(PrintWriter printWriter, UGDOButtonListRA4 uGDOButtonListRA4) {
        if (uGDOButtonListRA4 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA4.pos);
        printWriter.print(uGDOButtonListRA4.name);
    }

    private void traceUGDOButtonListRA5(PrintWriter printWriter, UGDOButtonListRA5 uGDOButtonListRA5) {
        if (uGDOButtonListRA5 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListRA5.pos);
        printWriter.print(uGDOButtonListRA5.learnedState);
    }

    private void traceUGDOButtonListUpdateInfo(PrintWriter printWriter, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        if (uGDOButtonListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOButtonListUpdateInfo.arrayContent);
        printWriter.print(uGDOButtonListUpdateInfo.recordContent);
        printWriter.print(uGDOButtonListUpdateInfo.startElement);
        printWriter.print(uGDOButtonListUpdateInfo.numOfElements);
        printWriter.print(uGDOButtonListUpdateInfo.transactionID);
        printWriter.print(uGDOButtonListUpdateInfo.asgID);
    }

    private void traceUGDOConfiguration(PrintWriter printWriter, UGDOConfiguration uGDOConfiguration) {
        if (uGDOConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOConfiguration.availableHardkeys);
        printWriter.print(uGDOConfiguration.availableSoftkeys);
        this.trace(printWriter, uGDOConfiguration.specialFeatures);
        printWriter.print(uGDOConfiguration.gpsSupervisionRadius);
        this.trace(printWriter, uGDOConfiguration.buttonListTransmittableElements);
    }

    private void traceUGDOContent(PrintWriter printWriter, UGDOContent uGDOContent) {
        if (uGDOContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOContent.hardkey);
        printWriter.print(uGDOContent.softkey);
        printWriter.print(uGDOContent.content);
    }

    private void traceUGDODestinationReached(PrintWriter printWriter, UGDODestinationReached uGDODestinationReached) {
        if (uGDODestinationReached == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDODestinationReached.softkey1);
        printWriter.print(uGDODestinationReached.softkey2);
        printWriter.print(uGDODestinationReached.softkey3);
        printWriter.print(uGDODestinationReached.softkey4);
        printWriter.print(uGDODestinationReached.softkey5);
        printWriter.print(uGDODestinationReached.softkey6);
        printWriter.print(uGDODestinationReached.softkey7);
        printWriter.print(uGDODestinationReached.softkey8);
        printWriter.print(uGDODestinationReached.softkey9);
        printWriter.print(uGDODestinationReached.softkey10);
        printWriter.print(uGDODestinationReached.softkey11);
        printWriter.print(uGDODestinationReached.softkey12);
        printWriter.print(uGDODestinationReached.softkey13);
        printWriter.print(uGDODestinationReached.softkey14);
        printWriter.print(uGDODestinationReached.softkey15);
    }

    private void traceUGDOLearningData(PrintWriter printWriter, UGDOLearningData uGDOLearningData) {
        if (uGDOLearningData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOLearningData.aSGRequest);
        printWriter.print(uGDOLearningData.fSGResponse);
        printWriter.print(uGDOLearningData.codeSystem);
        printWriter.print(uGDOLearningData.button);
    }

    private void traceUGDOOpenDoor(PrintWriter printWriter, UGDOOpenDoor uGDOOpenDoor) {
        if (uGDOOpenDoor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOOpenDoor.doorState);
        printWriter.print(uGDOOpenDoor.softkey);
    }

    private void traceUGDOSoftkeys(PrintWriter printWriter, UGDOSoftkeys uGDOSoftkeys) {
        if (uGDOSoftkeys == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOSoftkeys.softkey1);
        printWriter.print(uGDOSoftkeys.softkey2);
        printWriter.print(uGDOSoftkeys.softkey3);
        printWriter.print(uGDOSoftkeys.softkey4);
        printWriter.print(uGDOSoftkeys.softkey5);
        printWriter.print(uGDOSoftkeys.softkey6);
        printWriter.print(uGDOSoftkeys.softkey7);
        printWriter.print(uGDOSoftkeys.softkey8);
        printWriter.print(uGDOSoftkeys.softkey9);
        printWriter.print(uGDOSoftkeys.softkey10);
        printWriter.print(uGDOSoftkeys.softkey11);
        printWriter.print(uGDOSoftkeys.softkey12);
        printWriter.print(uGDOSoftkeys.softkey13);
        printWriter.print(uGDOSoftkeys.softkey14);
        printWriter.print(uGDOSoftkeys.softkey15);
    }

    private void traceUGDOSpecialFeatures(PrintWriter printWriter, UGDOSpecialFeatures uGDOSpecialFeatures) {
        if (uGDOSpecialFeatures == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOSpecialFeatures.doorName);
        printWriter.print(uGDOSpecialFeatures.gpsSupervision);
        printWriter.print(uGDOSpecialFeatures.keyFob);
        printWriter.print(uGDOSpecialFeatures.biDirectionalCommunication);
        printWriter.print(uGDOSpecialFeatures.fixkitMode);
        printWriter.print(uGDOSpecialFeatures.defaultMode);
    }

    private void traceUGDOSynchronisation(PrintWriter printWriter, UGDOSynchronisation uGDOSynchronisation) {
        if (uGDOSynchronisation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOSynchronisation.state);
        printWriter.print(uGDOSynchronisation.softkey);
        printWriter.print(uGDOSynchronisation.doorMovement);
    }

    private void traceUGDOTransmittableElements(PrintWriter printWriter, UGDOTransmittableElements uGDOTransmittableElements) {
        if (uGDOTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOTransmittableElements.ra0);
        printWriter.print(uGDOTransmittableElements.ra1);
        printWriter.print(uGDOTransmittableElements.ra2);
        printWriter.print(uGDOTransmittableElements.ra3);
        printWriter.print(uGDOTransmittableElements.ra4);
        printWriter.print(uGDOTransmittableElements.ra5);
        printWriter.print(uGDOTransmittableElements.raF);
    }

    private void traceUGDOVersionData(PrintWriter printWriter, UGDOVersionData uGDOVersionData) {
        if (uGDOVersionData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uGDOVersionData.countryCode);
        printWriter.print(uGDOVersionData.state);
        printWriter.print(uGDOVersionData.version);
    }

    private void traceUGDOViewOptions(PrintWriter printWriter, UGDOViewOptions uGDOViewOptions) {
        if (uGDOViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, uGDOViewOptions.learningData);
        this.trace(printWriter, uGDOViewOptions.deleteButton);
        this.trace(printWriter, uGDOViewOptions.versionData);
        this.trace(printWriter, uGDOViewOptions.setFactoryDefault);
        this.trace(printWriter, uGDOViewOptions.destinationReached);
        this.trace(printWriter, uGDOViewOptions.learning);
        this.trace(printWriter, uGDOViewOptions.synchronisation);
        this.trace(printWriter, uGDOViewOptions.openDoor);
        this.trace(printWriter, uGDOViewOptions.buttonList);
        this.trace(printWriter, uGDOViewOptions.configuration);
    }

    private void traceWiperViewOptions(PrintWriter printWriter, WiperViewOptions wiperViewOptions) {
        if (wiperViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, wiperViewOptions.wiperServicePosition);
        this.trace(printWriter, wiperViewOptions.wiperRainSensorOnOff);
        this.trace(printWriter, wiperViewOptions.wiperRainSensorConfig);
        this.trace(printWriter, wiperViewOptions.wiperRearWiping);
        this.trace(printWriter, wiperViewOptions.wiperTearsWiping);
        this.trace(printWriter, wiperViewOptions.wiperWinterPosition);
        this.trace(printWriter, wiperViewOptions.easyEntrySteeringColumn);
        this.trace(printWriter, wiperViewOptions.wiperSetFactoryDefault);
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

