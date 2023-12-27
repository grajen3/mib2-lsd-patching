/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carparkingsystem;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.ARATrailerConfiguration;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCConfiguration;
import org.dsi.ifc.carparkingsystem.PDCContinueDrivingAssist;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningFrontRear;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningRightLeft;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssist;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCSupportedFunctions;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSConfiguration;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSSupportedBVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedFVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSplitscreens;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCConfiguration;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPanelStates;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;

public final class DSICarParkingSystemTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ARACURRENTTRAILERANGLE;
    private static final int ID_ARAINFO;
    private static final int ID_ARATRAILERCONFIGURATION;
    private static final int ID_DISPLAYCONTENT;
    private static final int ID_PDCCONFIGURATION;
    private static final int ID_PDCCONTINUEDRIVINGASSIST;
    private static final int ID_PDCCRASHWARNING;
    private static final int ID_PDCCRASHWARNINGFRONTREAR;
    private static final int ID_PDCCRASHWARNINGRIGHTLEFT;
    private static final int ID_PDCDISTANCEVALUESFRONTREAR;
    private static final int ID_PDCDISTANCEVALUESFRONTREAREXT;
    private static final int ID_PDCDISTANCEVALUESRIGHTLEFT;
    private static final int ID_PDCINFO;
    private static final int ID_PDCMANEUVERASSIST;
    private static final int ID_PDCMANEUVERASSISTSTATE;
    private static final int ID_PDCPLABARGRAPH;
    private static final int ID_PDCPLAINSTRUCTIONS;
    private static final int ID_PDCPLAPARKINGSPOT;
    private static final int ID_PDCPLASTATUS;
    private static final int ID_PDCPLASYSTEMSTATE;
    private static final int ID_PDCPILOPASYSTEMSTATE;
    private static final int ID_PDCSOUND;
    private static final int ID_PDCSOUNDREPRODUCTION;
    private static final int ID_PDCSTATUSLEVELFRONTREAR;
    private static final int ID_PDCSTATUSLEVELFRONTREAREXT;
    private static final int ID_PDCSTATUSLEVELRIGHTLEFT;
    private static final int ID_PDCSTEERINGINFORMATION;
    private static final int ID_PDCSUPPORTEDFUNCTIONS;
    private static final int ID_PDCWALLDETECTION;
    private static final int ID_PDCWALLDETECTIONFRONTREAR;
    private static final int ID_PDCWALLDETECTIONRIGHTLEFT;
    private static final int ID_PARKINGSYSTEMVIEWOPTIONS;
    private static final int ID_VPSCAMERACLEANING;
    private static final int ID_VPSCAMERASTATES;
    private static final int ID_VPSCONFIGURATION;
    private static final int ID_VPSDEFAULTMODE;
    private static final int ID_VPSDYNPARKINGMODE;
    private static final int ID_VPSOPSOVERLAY;
    private static final int ID_VPSRIMPROTECTION;
    private static final int ID_VPSSUPPORTEDBVMODES;
    private static final int ID_VPSSUPPORTEDFVMODES;
    private static final int ID_VPSSUPPORTEDRVMODES;
    private static final int ID_VPSSUPPORTEDSVMODES;
    private static final int ID_VPSSUPPORTEDSPLITSCREENS;
    private static final int ID_VPSSUPPORTEDVIEWS;
    private static final int ID_VPSVIDEOINFO;
    private static final int ID_WCCONFIGURATION;
    private static final int ID_WCPANELINFO;
    private static final int ID_WCPANELLISTRECORD;
    private static final int ID_WCPANELSTATES;
    private static final int ID_WCPINPUKSTATE;
    private static final int ID_WCVEHICLEPANELINFO;
    private static final int ID_WCVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$ARACurrentTrailerAngle;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$ARAInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$ARATrailerConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DisplayContent;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCContinueDrivingAssist;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCCrashWarning;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCCrashWarningFrontRear;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCCrashWarningRightLeft;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRear;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRearExt;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesRightLeft;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCManeuverAssist;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCManeuverAssistState;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPLABargraph;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPLAInstructions;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPLAParkingSpot;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPLAStatus;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPLASystemState;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCPiloPaSystemState;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCSound;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCSoundReproduction;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRear;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRearExt;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCStatusLevelRightLeft;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCSteeringInformation;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCSupportedFunctions;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCWallDetection;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCWallDetectionFrontRear;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$PDCWallDetectionRightLeft;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$ParkingSystemViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSCameraCleaning;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSCameraStates;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSDefaultMode;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSDynParkingMode;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSOPSOverlay;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSRimProtection;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedBVModes;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedFVModes;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedRVModes;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedSVModes;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedSplitscreens;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSSupportedViews;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$VPSVideoInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCPanelInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCPanelListRecord;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCPanelStates;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCPinPukState;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCVehiclePanelInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$WCViewOptions;

    public DSICarParkingSystemTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$ARACurrentTrailerAngle == null ? (class$org$dsi$ifc$carparkingsystem$ARACurrentTrailerAngle = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle")) : class$org$dsi$ifc$carparkingsystem$ARACurrentTrailerAngle, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$ARAInfo == null ? (class$org$dsi$ifc$carparkingsystem$ARAInfo = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.ARAInfo")) : class$org$dsi$ifc$carparkingsystem$ARAInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$ARATrailerConfiguration == null ? (class$org$dsi$ifc$carparkingsystem$ARATrailerConfiguration = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.ARATrailerConfiguration")) : class$org$dsi$ifc$carparkingsystem$ARATrailerConfiguration, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$DisplayContent == null ? (class$org$dsi$ifc$carparkingsystem$DisplayContent = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.DisplayContent")) : class$org$dsi$ifc$carparkingsystem$DisplayContent, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCConfiguration == null ? (class$org$dsi$ifc$carparkingsystem$PDCConfiguration = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCConfiguration")) : class$org$dsi$ifc$carparkingsystem$PDCConfiguration, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCContinueDrivingAssist == null ? (class$org$dsi$ifc$carparkingsystem$PDCContinueDrivingAssist = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCContinueDrivingAssist")) : class$org$dsi$ifc$carparkingsystem$PDCContinueDrivingAssist, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCCrashWarning == null ? (class$org$dsi$ifc$carparkingsystem$PDCCrashWarning = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCCrashWarning")) : class$org$dsi$ifc$carparkingsystem$PDCCrashWarning, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCCrashWarningFrontRear == null ? (class$org$dsi$ifc$carparkingsystem$PDCCrashWarningFrontRear = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCCrashWarningFrontRear")) : class$org$dsi$ifc$carparkingsystem$PDCCrashWarningFrontRear, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCCrashWarningRightLeft == null ? (class$org$dsi$ifc$carparkingsystem$PDCCrashWarningRightLeft = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCCrashWarningRightLeft")) : class$org$dsi$ifc$carparkingsystem$PDCCrashWarningRightLeft, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRear == null ? (class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRear = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear")) : class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRear, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRearExt == null ? (class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRearExt = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt")) : class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesFrontRearExt, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesRightLeft == null ? (class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesRightLeft = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft")) : class$org$dsi$ifc$carparkingsystem$PDCDistanceValuesRightLeft, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCInfo == null ? (class$org$dsi$ifc$carparkingsystem$PDCInfo = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCInfo")) : class$org$dsi$ifc$carparkingsystem$PDCInfo, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCManeuverAssist == null ? (class$org$dsi$ifc$carparkingsystem$PDCManeuverAssist = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCManeuverAssist")) : class$org$dsi$ifc$carparkingsystem$PDCManeuverAssist, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCManeuverAssistState == null ? (class$org$dsi$ifc$carparkingsystem$PDCManeuverAssistState = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCManeuverAssistState")) : class$org$dsi$ifc$carparkingsystem$PDCManeuverAssistState, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPLABargraph == null ? (class$org$dsi$ifc$carparkingsystem$PDCPLABargraph = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPLABargraph")) : class$org$dsi$ifc$carparkingsystem$PDCPLABargraph, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPLAInstructions == null ? (class$org$dsi$ifc$carparkingsystem$PDCPLAInstructions = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPLAInstructions")) : class$org$dsi$ifc$carparkingsystem$PDCPLAInstructions, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPLAParkingSpot == null ? (class$org$dsi$ifc$carparkingsystem$PDCPLAParkingSpot = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot")) : class$org$dsi$ifc$carparkingsystem$PDCPLAParkingSpot, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPLAStatus == null ? (class$org$dsi$ifc$carparkingsystem$PDCPLAStatus = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPLAStatus")) : class$org$dsi$ifc$carparkingsystem$PDCPLAStatus, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPLASystemState == null ? (class$org$dsi$ifc$carparkingsystem$PDCPLASystemState = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPLASystemState")) : class$org$dsi$ifc$carparkingsystem$PDCPLASystemState, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCPiloPaSystemState == null ? (class$org$dsi$ifc$carparkingsystem$PDCPiloPaSystemState = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState")) : class$org$dsi$ifc$carparkingsystem$PDCPiloPaSystemState, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCSound == null ? (class$org$dsi$ifc$carparkingsystem$PDCSound = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCSound")) : class$org$dsi$ifc$carparkingsystem$PDCSound, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCSoundReproduction == null ? (class$org$dsi$ifc$carparkingsystem$PDCSoundReproduction = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCSoundReproduction")) : class$org$dsi$ifc$carparkingsystem$PDCSoundReproduction, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRear == null ? (class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRear = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear")) : class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRear, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRearExt == null ? (class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRearExt = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt")) : class$org$dsi$ifc$carparkingsystem$PDCStatusLevelFrontRearExt, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCStatusLevelRightLeft == null ? (class$org$dsi$ifc$carparkingsystem$PDCStatusLevelRightLeft = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft")) : class$org$dsi$ifc$carparkingsystem$PDCStatusLevelRightLeft, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCSteeringInformation == null ? (class$org$dsi$ifc$carparkingsystem$PDCSteeringInformation = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCSteeringInformation")) : class$org$dsi$ifc$carparkingsystem$PDCSteeringInformation, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCSupportedFunctions == null ? (class$org$dsi$ifc$carparkingsystem$PDCSupportedFunctions = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCSupportedFunctions")) : class$org$dsi$ifc$carparkingsystem$PDCSupportedFunctions, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCWallDetection == null ? (class$org$dsi$ifc$carparkingsystem$PDCWallDetection = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCWallDetection")) : class$org$dsi$ifc$carparkingsystem$PDCWallDetection, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCWallDetectionFrontRear == null ? (class$org$dsi$ifc$carparkingsystem$PDCWallDetectionFrontRear = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear")) : class$org$dsi$ifc$carparkingsystem$PDCWallDetectionFrontRear, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$PDCWallDetectionRightLeft == null ? (class$org$dsi$ifc$carparkingsystem$PDCWallDetectionRightLeft = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft")) : class$org$dsi$ifc$carparkingsystem$PDCWallDetectionRightLeft, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$ParkingSystemViewOptions == null ? (class$org$dsi$ifc$carparkingsystem$ParkingSystemViewOptions = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions")) : class$org$dsi$ifc$carparkingsystem$ParkingSystemViewOptions, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSCameraCleaning == null ? (class$org$dsi$ifc$carparkingsystem$VPSCameraCleaning = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSCameraCleaning")) : class$org$dsi$ifc$carparkingsystem$VPSCameraCleaning, 33);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSCameraStates == null ? (class$org$dsi$ifc$carparkingsystem$VPSCameraStates = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSCameraStates")) : class$org$dsi$ifc$carparkingsystem$VPSCameraStates, 34);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSConfiguration == null ? (class$org$dsi$ifc$carparkingsystem$VPSConfiguration = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSConfiguration")) : class$org$dsi$ifc$carparkingsystem$VPSConfiguration, 35);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSDefaultMode == null ? (class$org$dsi$ifc$carparkingsystem$VPSDefaultMode = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSDefaultMode")) : class$org$dsi$ifc$carparkingsystem$VPSDefaultMode, 36);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSDynParkingMode == null ? (class$org$dsi$ifc$carparkingsystem$VPSDynParkingMode = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSDynParkingMode")) : class$org$dsi$ifc$carparkingsystem$VPSDynParkingMode, 37);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSOPSOverlay == null ? (class$org$dsi$ifc$carparkingsystem$VPSOPSOverlay = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSOPSOverlay")) : class$org$dsi$ifc$carparkingsystem$VPSOPSOverlay, 38);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSRimProtection == null ? (class$org$dsi$ifc$carparkingsystem$VPSRimProtection = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSRimProtection")) : class$org$dsi$ifc$carparkingsystem$VPSRimProtection, 39);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedBVModes == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedBVModes = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedBVModes")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedBVModes, 40);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedFVModes == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedFVModes = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedFVModes")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedFVModes, 41);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedRVModes == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedRVModes = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedRVModes")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedRVModes, 42);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedSVModes == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedSVModes = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedSVModes")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedSVModes, 43);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedSplitscreens == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedSplitscreens = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedSplitscreens")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedSplitscreens, 44);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSSupportedViews == null ? (class$org$dsi$ifc$carparkingsystem$VPSSupportedViews = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSSupportedViews")) : class$org$dsi$ifc$carparkingsystem$VPSSupportedViews, 45);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$VPSVideoInfo == null ? (class$org$dsi$ifc$carparkingsystem$VPSVideoInfo = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.VPSVideoInfo")) : class$org$dsi$ifc$carparkingsystem$VPSVideoInfo, 46);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCConfiguration == null ? (class$org$dsi$ifc$carparkingsystem$WCConfiguration = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCConfiguration")) : class$org$dsi$ifc$carparkingsystem$WCConfiguration, 47);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCPanelInfo == null ? (class$org$dsi$ifc$carparkingsystem$WCPanelInfo = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCPanelInfo")) : class$org$dsi$ifc$carparkingsystem$WCPanelInfo, 48);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCPanelListRecord == null ? (class$org$dsi$ifc$carparkingsystem$WCPanelListRecord = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCPanelListRecord")) : class$org$dsi$ifc$carparkingsystem$WCPanelListRecord, 49);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCPanelStates == null ? (class$org$dsi$ifc$carparkingsystem$WCPanelStates = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCPanelStates")) : class$org$dsi$ifc$carparkingsystem$WCPanelStates, 50);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCPinPukState == null ? (class$org$dsi$ifc$carparkingsystem$WCPinPukState = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCPinPukState")) : class$org$dsi$ifc$carparkingsystem$WCPinPukState, 51);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCVehiclePanelInfo == null ? (class$org$dsi$ifc$carparkingsystem$WCVehiclePanelInfo = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo")) : class$org$dsi$ifc$carparkingsystem$WCVehiclePanelInfo, 52);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carparkingsystem$WCViewOptions == null ? (class$org$dsi$ifc$carparkingsystem$WCViewOptions = DSICarParkingSystemTracer.class$("org.dsi.ifc.carparkingsystem.WCViewOptions")) : class$org$dsi$ifc$carparkingsystem$WCViewOptions, 53);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceARACurrentTrailerAngle(printWriter, (ARACurrentTrailerAngle)object);
                break;
            }
            case 2: {
                this.traceARAInfo(printWriter, (ARAInfo)object);
                break;
            }
            case 3: {
                this.traceARATrailerConfiguration(printWriter, (ARATrailerConfiguration)object);
                break;
            }
            case 4: {
                this.traceDisplayContent(printWriter, (DisplayContent)object);
                break;
            }
            case 5: {
                this.tracePDCConfiguration(printWriter, (PDCConfiguration)object);
                break;
            }
            case 6: {
                this.tracePDCContinueDrivingAssist(printWriter, (PDCContinueDrivingAssist)object);
                break;
            }
            case 7: {
                this.tracePDCCrashWarning(printWriter, (PDCCrashWarning)object);
                break;
            }
            case 8: {
                this.tracePDCCrashWarningFrontRear(printWriter, (PDCCrashWarningFrontRear)object);
                break;
            }
            case 9: {
                this.tracePDCCrashWarningRightLeft(printWriter, (PDCCrashWarningRightLeft)object);
                break;
            }
            case 10: {
                this.tracePDCDistanceValuesFrontRear(printWriter, (PDCDistanceValuesFrontRear)object);
                break;
            }
            case 11: {
                this.tracePDCDistanceValuesFrontRearExt(printWriter, (PDCDistanceValuesFrontRearExt)object);
                break;
            }
            case 12: {
                this.tracePDCDistanceValuesRightLeft(printWriter, (PDCDistanceValuesRightLeft)object);
                break;
            }
            case 13: {
                this.tracePDCInfo(printWriter, (PDCInfo)object);
                break;
            }
            case 14: {
                this.tracePDCManeuverAssist(printWriter, (PDCManeuverAssist)object);
                break;
            }
            case 15: {
                this.tracePDCManeuverAssistState(printWriter, (PDCManeuverAssistState)object);
                break;
            }
            case 16: {
                this.tracePDCPLABargraph(printWriter, (PDCPLABargraph)object);
                break;
            }
            case 17: {
                this.tracePDCPLAInstructions(printWriter, (PDCPLAInstructions)object);
                break;
            }
            case 18: {
                this.tracePDCPLAParkingSpot(printWriter, (PDCPLAParkingSpot)object);
                break;
            }
            case 19: {
                this.tracePDCPLAStatus(printWriter, (PDCPLAStatus)object);
                break;
            }
            case 20: {
                this.tracePDCPLASystemState(printWriter, (PDCPLASystemState)object);
                break;
            }
            case 21: {
                this.tracePDCPiloPaSystemState(printWriter, (PDCPiloPaSystemState)object);
                break;
            }
            case 22: {
                this.tracePDCSound(printWriter, (PDCSound)object);
                break;
            }
            case 23: {
                this.tracePDCSoundReproduction(printWriter, (PDCSoundReproduction)object);
                break;
            }
            case 24: {
                this.tracePDCStatusLevelFrontRear(printWriter, (PDCStatusLevelFrontRear)object);
                break;
            }
            case 25: {
                this.tracePDCStatusLevelFrontRearExt(printWriter, (PDCStatusLevelFrontRearExt)object);
                break;
            }
            case 26: {
                this.tracePDCStatusLevelRightLeft(printWriter, (PDCStatusLevelRightLeft)object);
                break;
            }
            case 27: {
                this.tracePDCSteeringInformation(printWriter, (PDCSteeringInformation)object);
                break;
            }
            case 28: {
                this.tracePDCSupportedFunctions(printWriter, (PDCSupportedFunctions)object);
                break;
            }
            case 29: {
                this.tracePDCWallDetection(printWriter, (PDCWallDetection)object);
                break;
            }
            case 30: {
                this.tracePDCWallDetectionFrontRear(printWriter, (PDCWallDetectionFrontRear)object);
                break;
            }
            case 31: {
                this.tracePDCWallDetectionRightLeft(printWriter, (PDCWallDetectionRightLeft)object);
                break;
            }
            case 32: {
                this.traceParkingSystemViewOptions(printWriter, (ParkingSystemViewOptions)object);
                break;
            }
            case 33: {
                this.traceVPSCameraCleaning(printWriter, (VPSCameraCleaning)object);
                break;
            }
            case 34: {
                this.traceVPSCameraStates(printWriter, (VPSCameraStates)object);
                break;
            }
            case 35: {
                this.traceVPSConfiguration(printWriter, (VPSConfiguration)object);
                break;
            }
            case 36: {
                this.traceVPSDefaultMode(printWriter, (VPSDefaultMode)object);
                break;
            }
            case 37: {
                this.traceVPSDynParkingMode(printWriter, (VPSDynParkingMode)object);
                break;
            }
            case 38: {
                this.traceVPSOPSOverlay(printWriter, (VPSOPSOverlay)object);
                break;
            }
            case 39: {
                this.traceVPSRimProtection(printWriter, (VPSRimProtection)object);
                break;
            }
            case 40: {
                this.traceVPSSupportedBVModes(printWriter, (VPSSupportedBVModes)object);
                break;
            }
            case 41: {
                this.traceVPSSupportedFVModes(printWriter, (VPSSupportedFVModes)object);
                break;
            }
            case 42: {
                this.traceVPSSupportedRVModes(printWriter, (VPSSupportedRVModes)object);
                break;
            }
            case 43: {
                this.traceVPSSupportedSVModes(printWriter, (VPSSupportedSVModes)object);
                break;
            }
            case 44: {
                this.traceVPSSupportedSplitscreens(printWriter, (VPSSupportedSplitscreens)object);
                break;
            }
            case 45: {
                this.traceVPSSupportedViews(printWriter, (VPSSupportedViews)object);
                break;
            }
            case 46: {
                this.traceVPSVideoInfo(printWriter, (VPSVideoInfo)object);
                break;
            }
            case 47: {
                this.traceWCConfiguration(printWriter, (WCConfiguration)object);
                break;
            }
            case 48: {
                this.traceWCPanelInfo(printWriter, (WCPanelInfo)object);
                break;
            }
            case 49: {
                this.traceWCPanelListRecord(printWriter, (WCPanelListRecord)object);
                break;
            }
            case 50: {
                this.traceWCPanelStates(printWriter, (WCPanelStates)object);
                break;
            }
            case 51: {
                this.traceWCPinPukState(printWriter, (WCPinPukState)object);
                break;
            }
            case 52: {
                this.traceWCVehiclePanelInfo(printWriter, (WCVehiclePanelInfo)object);
                break;
            }
            case 53: {
                this.traceWCViewOptions(printWriter, (WCViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceARACurrentTrailerAngle(PrintWriter printWriter, ARACurrentTrailerAngle aRACurrentTrailerAngle) {
        if (aRACurrentTrailerAngle == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aRACurrentTrailerAngle.angle);
        printWriter.print(aRACurrentTrailerAngle.valid);
    }

    private void traceARAInfo(PrintWriter printWriter, ARAInfo aRAInfo) {
        if (aRAInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aRAInfo.message);
        printWriter.print(aRAInfo.automaticSteering);
        printWriter.print(aRAInfo.deactivationProhibited);
    }

    private void traceARATrailerConfiguration(PrintWriter printWriter, ARATrailerConfiguration aRATrailerConfiguration) {
        if (aRATrailerConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aRATrailerConfiguration.maxTrailerAngle);
        printWriter.print(aRATrailerConfiguration.instantTrailerAngle);
        printWriter.print(aRATrailerConfiguration.hazinessTrailerAngle);
        printWriter.print(aRATrailerConfiguration.threshold1);
        printWriter.print(aRATrailerConfiguration.threshold2);
        printWriter.print(aRATrailerConfiguration.threshold3);
        printWriter.print(aRATrailerConfiguration.threshold4);
        printWriter.print(aRATrailerConfiguration.stepSize1);
        printWriter.print(aRATrailerConfiguration.stepSize2);
        printWriter.print(aRATrailerConfiguration.stepSize3);
        printWriter.print(aRATrailerConfiguration.stepSize4);
    }

    private void traceDisplayContent(PrintWriter printWriter, DisplayContent displayContent) {
        if (displayContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayContent.popup);
        printWriter.print(displayContent.screen);
        printWriter.print(displayContent.view);
        printWriter.print(displayContent.mode);
    }

    private void tracePDCConfiguration(PrintWriter printWriter, PDCConfiguration pDCConfiguration) {
        if (pDCConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCConfiguration.numberFrontSectors);
        printWriter.print(pDCConfiguration.numberRearSectors);
        printWriter.print(pDCConfiguration.numberRightSectors);
        printWriter.print(pDCConfiguration.numberLeftSectors);
        printWriter.print(pDCConfiguration.wheelbase);
        printWriter.print(pDCConfiguration.crashWarning);
        printWriter.print(pDCConfiguration.steeringInformation);
        this.trace(printWriter, pDCConfiguration.supportedFunctions);
        this.trace(printWriter, pDCConfiguration.maneuverAssist);
        this.trace(printWriter, pDCConfiguration.continueDrivingAssist);
    }

    private void tracePDCContinueDrivingAssist(PrintWriter printWriter, PDCContinueDrivingAssist pDCContinueDrivingAssist) {
        if (pDCContinueDrivingAssist == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCContinueDrivingAssist.offEarlyMediumLate);
    }

    private void tracePDCCrashWarning(PrintWriter printWriter, PDCCrashWarning pDCCrashWarning) {
        if (pDCCrashWarning == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, pDCCrashWarning.sectorsFront);
        this.trace(printWriter, pDCCrashWarning.sectorsRear);
        this.trace(printWriter, pDCCrashWarning.sectorsRight);
        this.trace(printWriter, pDCCrashWarning.sectorsLeft);
    }

    private void tracePDCCrashWarningFrontRear(PrintWriter printWriter, PDCCrashWarningFrontRear pDCCrashWarningFrontRear) {
        if (pDCCrashWarningFrontRear == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCCrashWarningFrontRear.left);
        printWriter.print(pDCCrashWarningFrontRear.leftMiddle);
        printWriter.print(pDCCrashWarningFrontRear.rightMiddle);
        printWriter.print(pDCCrashWarningFrontRear.right);
    }

    private void tracePDCCrashWarningRightLeft(PrintWriter printWriter, PDCCrashWarningRightLeft pDCCrashWarningRightLeft) {
        if (pDCCrashWarningRightLeft == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCCrashWarningRightLeft.front);
        printWriter.print(pDCCrashWarningRightLeft.frontMiddle);
        printWriter.print(pDCCrashWarningRightLeft.rearMiddle);
        printWriter.print(pDCCrashWarningRightLeft.rear);
    }

    private void tracePDCDistanceValuesFrontRear(PrintWriter printWriter, PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        if (pDCDistanceValuesFrontRear == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCDistanceValuesFrontRear.left);
        printWriter.print(pDCDistanceValuesFrontRear.leftMiddle);
        printWriter.print(pDCDistanceValuesFrontRear.rightMiddle);
        printWriter.print(pDCDistanceValuesFrontRear.right);
    }

    private void tracePDCDistanceValuesFrontRearExt(PrintWriter printWriter, PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
        if (pDCDistanceValuesFrontRearExt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCDistanceValuesFrontRearExt.spacing5);
        printWriter.print(pDCDistanceValuesFrontRearExt.spacing6);
        printWriter.print(pDCDistanceValuesFrontRearExt.spacing7);
        printWriter.print(pDCDistanceValuesFrontRearExt.spacing8);
    }

    private void tracePDCDistanceValuesRightLeft(PrintWriter printWriter, PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        if (pDCDistanceValuesRightLeft == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCDistanceValuesRightLeft.front);
        printWriter.print(pDCDistanceValuesRightLeft.frontMiddle);
        printWriter.print(pDCDistanceValuesRightLeft.rearMiddle);
        printWriter.print(pDCDistanceValuesRightLeft.rear);
    }

    private void tracePDCInfo(PrintWriter printWriter, PDCInfo pDCInfo) {
        if (pDCInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCInfo.limitedFunctionality);
        printWriter.print(pDCInfo.trunkOpen);
    }

    private void tracePDCManeuverAssist(PrintWriter printWriter, PDCManeuverAssist pDCManeuverAssist) {
        if (pDCManeuverAssist == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCManeuverAssist.braking);
        printWriter.print(pDCManeuverAssist.steering);
    }

    private void tracePDCManeuverAssistState(PrintWriter printWriter, PDCManeuverAssistState pDCManeuverAssistState) {
        if (pDCManeuverAssistState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCManeuverAssistState.activity);
        printWriter.print(pDCManeuverAssistState.steeringIntervention);
        printWriter.print(pDCManeuverAssistState.brakingIntervention);
        printWriter.print(pDCManeuverAssistState.availability);
    }

    private void tracePDCPLABargraph(PrintWriter printWriter, PDCPLABargraph pDCPLABargraph) {
        if (pDCPLABargraph == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPLABargraph.arrowIndication);
        printWriter.print(pDCPLABargraph.arrowLevel);
    }

    private void tracePDCPLAInstructions(PrintWriter printWriter, PDCPLAInstructions pDCPLAInstructions) {
        if (pDCPLAInstructions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPLAInstructions.brakeSymbol);
        printWriter.print(pDCPLAInstructions.steeringInterventionSymbol);
        printWriter.print(pDCPLAInstructions.plaDeactivation);
        printWriter.print(pDCPLAInstructions.plaSearchLeftSide);
        printWriter.print(pDCPLAInstructions.plaSearchRightSide);
        printWriter.print(pDCPLAInstructions.neighborLaneWarning);
    }

    private void tracePDCPLAParkingSpot(PrintWriter printWriter, PDCPLAParkingSpot pDCPLAParkingSpot) {
        if (pDCPLAParkingSpot == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPLAParkingSpot.backwardParkboxSlotLeftFound);
        printWriter.print(pDCPLAParkingSpot.backwardParkboxSlotRightFound);
        printWriter.print(pDCPLAParkingSpot.forwardParkboxSlotLeftFound);
        printWriter.print(pDCPLAParkingSpot.forwardParkboxSlotRightFound);
        printWriter.print(pDCPLAParkingSpot.backwardParallelToRoadSlotLeftFound);
        printWriter.print(pDCPLAParkingSpot.backwardParallelToRoadSlotRightFound);
        printWriter.print(pDCPLAParkingSpot.forwardParkboxSlotMiddleFound);
    }

    private void tracePDCPLAStatus(PrintWriter printWriter, PDCPLAStatus pDCPLAStatus) {
        if (pDCPLAStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPLAStatus.mode);
        this.trace(printWriter, pDCPLAStatus.parkingSpot);
        printWriter.print(pDCPLAStatus.drivingDirection);
        this.trace(printWriter, pDCPLAStatus.instructions);
        printWriter.print(pDCPLAStatus.preSelection);
    }

    private void tracePDCPLASystemState(PrintWriter printWriter, PDCPLASystemState pDCPLASystemState) {
        if (pDCPLASystemState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPLASystemState.pdcSystemState);
        printWriter.print(pDCPLASystemState.plaSystemState);
    }

    private void tracePDCPiloPaSystemState(PrintWriter printWriter, PDCPiloPaSystemState pDCPiloPaSystemState) {
        if (pDCPiloPaSystemState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCPiloPaSystemState.pp);
        printWriter.print(pDCPiloPaSystemState.gp);
    }

    private void tracePDCSound(PrintWriter printWriter, PDCSound pDCSound) {
        if (pDCSound == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCSound.volume);
        printWriter.print(pDCSound.frequency);
    }

    private void tracePDCSoundReproduction(PrintWriter printWriter, PDCSoundReproduction pDCSoundReproduction) {
        if (pDCSoundReproduction == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCSoundReproduction.front);
        printWriter.print(pDCSoundReproduction.rear);
        printWriter.print(pDCSoundReproduction.right);
        printWriter.print(pDCSoundReproduction.left);
    }

    private void tracePDCStatusLevelFrontRear(PrintWriter printWriter, PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        if (pDCStatusLevelFrontRear == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCStatusLevelFrontRear.left);
        printWriter.print(pDCStatusLevelFrontRear.leftMiddle);
        printWriter.print(pDCStatusLevelFrontRear.rightMiddle);
        printWriter.print(pDCStatusLevelFrontRear.right);
    }

    private void tracePDCStatusLevelFrontRearExt(PrintWriter printWriter, PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
        if (pDCStatusLevelFrontRearExt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCStatusLevelFrontRearExt.statusLevel5);
        printWriter.print(pDCStatusLevelFrontRearExt.statusLevel6);
        printWriter.print(pDCStatusLevelFrontRearExt.statusLevel7);
        printWriter.print(pDCStatusLevelFrontRearExt.statusLevel8);
    }

    private void tracePDCStatusLevelRightLeft(PrintWriter printWriter, PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        if (pDCStatusLevelRightLeft == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCStatusLevelRightLeft.front);
        printWriter.print(pDCStatusLevelRightLeft.frontMiddle);
        printWriter.print(pDCStatusLevelRightLeft.rearMiddle);
        printWriter.print(pDCStatusLevelRightLeft.rear);
    }

    private void tracePDCSteeringInformation(PrintWriter printWriter, PDCSteeringInformation pDCSteeringInformation) {
        if (pDCSteeringInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCSteeringInformation.additionalInfo);
        printWriter.print(pDCSteeringInformation.trackDisplay);
        printWriter.print(pDCSteeringInformation.direction);
        printWriter.print(pDCSteeringInformation.radiusRearWheel);
        printWriter.print(pDCSteeringInformation.radiusFrontWheel);
    }

    private void tracePDCSupportedFunctions(PrintWriter printWriter, PDCSupportedFunctions pDCSupportedFunctions) {
        if (pDCSupportedFunctions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCSupportedFunctions.pla);
        printWriter.print(pDCSupportedFunctions.ipa);
        printWriter.print(pDCSupportedFunctions.pp);
        printWriter.print(pDCSupportedFunctions.gp);
    }

    private void tracePDCWallDetection(PrintWriter printWriter, PDCWallDetection pDCWallDetection) {
        if (pDCWallDetection == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, pDCWallDetection.sectorsFront);
        this.trace(printWriter, pDCWallDetection.sectorsRear);
        this.trace(printWriter, pDCWallDetection.sectorsRight);
        this.trace(printWriter, pDCWallDetection.sectorsLeft);
    }

    private void tracePDCWallDetectionFrontRear(PrintWriter printWriter, PDCWallDetectionFrontRear pDCWallDetectionFrontRear) {
        if (pDCWallDetectionFrontRear == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCWallDetectionFrontRear.sector1);
        printWriter.print(pDCWallDetectionFrontRear.sector2);
        printWriter.print(pDCWallDetectionFrontRear.sector3);
        printWriter.print(pDCWallDetectionFrontRear.sector4);
        printWriter.print(pDCWallDetectionFrontRear.sector5);
        printWriter.print(pDCWallDetectionFrontRear.sector6);
        printWriter.print(pDCWallDetectionFrontRear.sector7);
        printWriter.print(pDCWallDetectionFrontRear.sector8);
    }

    private void tracePDCWallDetectionRightLeft(PrintWriter printWriter, PDCWallDetectionRightLeft pDCWallDetectionRightLeft) {
        if (pDCWallDetectionRightLeft == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pDCWallDetectionRightLeft.sector1);
        printWriter.print(pDCWallDetectionRightLeft.sector2);
        printWriter.print(pDCWallDetectionRightLeft.sector3);
        printWriter.print(pDCWallDetectionRightLeft.sector4);
    }

    private void traceParkingSystemViewOptions(PrintWriter printWriter, ParkingSystemViewOptions parkingSystemViewOptions) {
        if (parkingSystemViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, parkingSystemViewOptions.pdcSystemOnOff);
        this.trace(printWriter, parkingSystemViewOptions.pdcVolumeFront);
        this.trace(printWriter, parkingSystemViewOptions.pdcFrequencyFront);
        this.trace(printWriter, parkingSystemViewOptions.pdcVolumeRear);
        this.trace(printWriter, parkingSystemViewOptions.pdcFrequencyRear);
        this.trace(printWriter, parkingSystemViewOptions.pdcVolumeRight);
        this.trace(printWriter, parkingSystemViewOptions.pdcFrequencyRight);
        this.trace(printWriter, parkingSystemViewOptions.pdcVolumeLeft);
        this.trace(printWriter, parkingSystemViewOptions.pdcFrequencyLeft);
        this.trace(printWriter, parkingSystemViewOptions.pdcDefaultParkingMode);
        this.trace(printWriter, parkingSystemViewOptions.pdcMute);
        this.trace(printWriter, parkingSystemViewOptions.pdcAutoActivation);
        this.trace(printWriter, parkingSystemViewOptions.pdcSoundReproduction);
        this.trace(printWriter, parkingSystemViewOptions.pdcFlankGuard);
        this.trace(printWriter, parkingSystemViewOptions.pdcSoundFront);
        this.trace(printWriter, parkingSystemViewOptions.pdcSoundRear);
        this.trace(printWriter, parkingSystemViewOptions.pdcSoundLeft);
        this.trace(printWriter, parkingSystemViewOptions.pdcSoundRight);
        this.trace(printWriter, parkingSystemViewOptions.pdcOffroadMode);
        this.trace(printWriter, parkingSystemViewOptions.pdcParkboxVisualisation);
        this.trace(printWriter, parkingSystemViewOptions.pdcOPSVisualisationPosition);
        this.trace(printWriter, parkingSystemViewOptions.pdcPLAStatus);
        this.trace(printWriter, parkingSystemViewOptions.pdcPLABargraph);
        this.trace(printWriter, parkingSystemViewOptions.pdcPLAParkmodeSelection);
        this.trace(printWriter, parkingSystemViewOptions.pdcPLASystemState);
        this.trace(printWriter, parkingSystemViewOptions.vpsSystemOnOff);
        this.trace(printWriter, parkingSystemViewOptions.vpsColor);
        this.trace(printWriter, parkingSystemViewOptions.vpsBrightness);
        this.trace(printWriter, parkingSystemViewOptions.vpsContrast);
        this.trace(printWriter, parkingSystemViewOptions.vpsFollowUpTime);
        this.trace(printWriter, parkingSystemViewOptions.vpsOPSOverlay);
        this.trace(printWriter, parkingSystemViewOptions.vpsDynamicParkingMode);
        this.trace(printWriter, parkingSystemViewOptions.vpsDefaultView);
        this.trace(printWriter, parkingSystemViewOptions.vpsDefaultModeRV);
        this.trace(printWriter, parkingSystemViewOptions.vpsDefaultModeFV);
        this.trace(printWriter, parkingSystemViewOptions.vpsDefaultModeSV);
        this.trace(printWriter, parkingSystemViewOptions.vpsDefaultModeBV);
        this.trace(printWriter, parkingSystemViewOptions.vpsExtCamConfig);
        this.trace(printWriter, parkingSystemViewOptions.vpsExtCamManActivation);
        this.trace(printWriter, parkingSystemViewOptions.vps3DBirdview);
        this.trace(printWriter, parkingSystemViewOptions.vpsSystemState);
        this.trace(printWriter, parkingSystemViewOptions.pdcSetFactoryDefault);
        this.trace(printWriter, parkingSystemViewOptions.vpsSetFactoryDefault);
        this.trace(printWriter, parkingSystemViewOptions.araCurrentTrailerAngle);
        this.trace(printWriter, parkingSystemViewOptions.araTargetTrailerAngle);
        this.trace(printWriter, parkingSystemViewOptions.pdcConfiguration);
        this.trace(printWriter, parkingSystemViewOptions.vpsConfiguration);
        this.trace(printWriter, parkingSystemViewOptions.araTrailerConfiguration);
        this.trace(printWriter, parkingSystemViewOptions.pdcManeuverAssistConfig);
        this.trace(printWriter, parkingSystemViewOptions.pdcManeuverAssist);
        this.trace(printWriter, parkingSystemViewOptions.pdcContinueDrivingAssist);
        this.trace(printWriter, parkingSystemViewOptions.pdcIpaConfig);
        this.trace(printWriter, parkingSystemViewOptions.pdcPiloPaSystemStatePP);
        this.trace(printWriter, parkingSystemViewOptions.pdcPiloPaSystemStateGP);
        this.trace(printWriter, parkingSystemViewOptions.vpsCameraCleaning);
        this.trace(printWriter, parkingSystemViewOptions.vpsRimProtection);
    }

    private void traceVPSCameraCleaning(PrintWriter printWriter, VPSCameraCleaning vPSCameraCleaning) {
        if (vPSCameraCleaning == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSCameraCleaning.rearCamera);
    }

    private void traceVPSCameraStates(PrintWriter printWriter, VPSCameraStates vPSCameraStates) {
        if (vPSCameraStates == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSCameraStates.rearCamera);
        printWriter.print(vPSCameraStates.frontCamera);
        printWriter.print(vPSCameraStates.rightCamera);
        printWriter.print(vPSCameraStates.leftCamera);
    }

    private void traceVPSConfiguration(PrintWriter printWriter, VPSConfiguration vPSConfiguration) {
        if (vPSConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, vPSConfiguration.supportedSplitScreens);
        this.trace(printWriter, vPSConfiguration.supportedViews);
        this.trace(printWriter, vPSConfiguration.supportedRVModes);
        this.trace(printWriter, vPSConfiguration.supportedFVModes);
        this.trace(printWriter, vPSConfiguration.supportedSVModes);
        this.trace(printWriter, vPSConfiguration.supportedBVModes);
        printWriter.print(vPSConfiguration.birdview3DViewPlains);
        printWriter.print(vPSConfiguration.birdview3DViewPoints);
    }

    private void traceVPSDefaultMode(PrintWriter printWriter, VPSDefaultMode vPSDefaultMode) {
        if (vPSDefaultMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSDefaultMode.vpsScreen);
        printWriter.print(vPSDefaultMode.vpsMode);
    }

    private void traceVPSDynParkingMode(PrintWriter printWriter, VPSDynParkingMode vPSDynParkingMode) {
        if (vPSDynParkingMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSDynParkingMode.parkbox);
        printWriter.print(vPSDynParkingMode.parallelToRoad);
        printWriter.print(vPSDynParkingMode.offroad);
        printWriter.print(vPSDynParkingMode.rightSideview);
        printWriter.print(vPSDynParkingMode.leftSideview);
        printWriter.print(vPSDynParkingMode.crossing);
        printWriter.print(vPSDynParkingMode.trailerAssist);
    }

    private void traceVPSOPSOverlay(PrintWriter printWriter, VPSOPSOverlay vPSOPSOverlay) {
        if (vPSOPSOverlay == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSOPSOverlay.rearview);
        printWriter.print(vPSOPSOverlay.frontview);
        printWriter.print(vPSOPSOverlay.sideview);
        printWriter.print(vPSOPSOverlay.birdview);
    }

    private void traceVPSRimProtection(PrintWriter printWriter, VPSRimProtection vPSRimProtection) {
        if (vPSRimProtection == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSRimProtection.tireAngle);
        printWriter.print(vPSRimProtection.tireStateFrontLeft);
        printWriter.print(vPSRimProtection.tireStateFrontRight);
        printWriter.print(vPSRimProtection.tireStateRearLeft);
        printWriter.print(vPSRimProtection.tireStateRearRight);
    }

    private void traceVPSSupportedBVModes(PrintWriter printWriter, VPSSupportedBVModes vPSSupportedBVModes) {
        if (vPSSupportedBVModes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedBVModes.parkbox);
        printWriter.print(vPSSupportedBVModes.offroad);
        printWriter.print(vPSSupportedBVModes.mainMode);
        printWriter.print(vPSSupportedBVModes.offroadKOG);
        printWriter.print(vPSSupportedBVModes.birdview3D);
    }

    private void traceVPSSupportedFVModes(PrintWriter printWriter, VPSSupportedFVModes vPSSupportedFVModes) {
        if (vPSSupportedFVModes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedFVModes.parkbox);
        printWriter.print(vPSSupportedFVModes.offroad);
        printWriter.print(vPSSupportedFVModes.crossing);
        printWriter.print(vPSSupportedFVModes.offroadKOG);
    }

    private void traceVPSSupportedRVModes(PrintWriter printWriter, VPSSupportedRVModes vPSSupportedRVModes) {
        if (vPSSupportedRVModes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedRVModes.parkbox);
        printWriter.print(vPSSupportedRVModes.parallelToRoad);
        printWriter.print(vPSSupportedRVModes.crossing);
        printWriter.print(vPSSupportedRVModes.trailerAssist);
        printWriter.print(vPSSupportedRVModes.offroadKOG);
        printWriter.print(vPSSupportedRVModes.trailerAssistARA);
    }

    private void traceVPSSupportedSVModes(PrintWriter printWriter, VPSSupportedSVModes vPSSupportedSVModes) {
        if (vPSSupportedSVModes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedSVModes.offroad);
        printWriter.print(vPSSupportedSVModes.rightSideview);
        printWriter.print(vPSSupportedSVModes.leftSideview);
        printWriter.print(vPSSupportedSVModes.leftRightSideview);
        printWriter.print(vPSSupportedSVModes.onlySideview);
        printWriter.print(vPSSupportedSVModes.offroadKOG);
    }

    private void traceVPSSupportedSplitscreens(PrintWriter printWriter, VPSSupportedSplitscreens vPSSupportedSplitscreens) {
        if (vPSSupportedSplitscreens == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedSplitscreens.parkbox);
        printWriter.print(vPSSupportedSplitscreens.parallelToRoad);
        printWriter.print(vPSSupportedSplitscreens.offroad);
        printWriter.print(vPSSupportedSplitscreens.crossing);
        printWriter.print(vPSSupportedSplitscreens.trailerAssist);
        printWriter.print(vPSSupportedSplitscreens.sideview);
    }

    private void traceVPSSupportedViews(PrintWriter printWriter, VPSSupportedViews vPSSupportedViews) {
        if (vPSSupportedViews == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSSupportedViews.rearview);
        printWriter.print(vPSSupportedViews.frontview);
        printWriter.print(vPSSupportedViews.leftsideview);
        printWriter.print(vPSSupportedViews.rightsideview);
        printWriter.print(vPSSupportedViews.birdview);
        printWriter.print(vPSSupportedViews.extCam);
    }

    private void traceVPSVideoInfo(PrintWriter printWriter, VPSVideoInfo vPSVideoInfo) {
        if (vPSVideoInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vPSVideoInfo.trailerHitched);
        printWriter.print(vPSVideoInfo.trunkOpen);
        printWriter.print(vPSVideoInfo.speedToHigh);
        printWriter.print(vPSVideoInfo.calibration);
        printWriter.print(vPSVideoInfo.guidelinesLeftSide);
        printWriter.print(vPSVideoInfo.guidelinesRightSide);
        printWriter.print(vPSVideoInfo.extMirrorFolded);
    }

    private void traceWCConfiguration(PrintWriter printWriter, WCConfiguration wCConfiguration) {
        if (wCConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCConfiguration.vehiclePanelSizeY);
        printWriter.print(wCConfiguration.vehiclePanelSizeX);
        printWriter.print(wCConfiguration.vehiclePanelPositionY);
        printWriter.print(wCConfiguration.vehiclePanelPositionX);
        printWriter.print(wCConfiguration.vehicleWidth);
        this.trace(printWriter, wCConfiguration.panelListTransmittableElements);
        if (wCConfiguration.panelListRAConfig == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = wCConfiguration.panelListRAConfig.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(wCConfiguration.panelListRAConfig[i2]);
            }
        }
    }

    private void traceWCPanelInfo(PrintWriter printWriter, WCPanelInfo wCPanelInfo) {
        if (wCPanelInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCPanelInfo.state);
        printWriter.print(wCPanelInfo.angle);
        printWriter.print(wCPanelInfo.positionY);
        printWriter.print(wCPanelInfo.positionX);
    }

    private void traceWCPanelListRecord(PrintWriter printWriter, WCPanelListRecord wCPanelListRecord) {
        if (wCPanelListRecord == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCPanelListRecord.pos);
        printWriter.print(wCPanelListRecord.serialNumber);
        printWriter.print(wCPanelListRecord.name);
        printWriter.print(wCPanelListRecord.pin);
        printWriter.print(wCPanelListRecord.software);
        printWriter.print(wCPanelListRecord.hardware);
        this.trace(printWriter, wCPanelListRecord.state);
        printWriter.print(wCPanelListRecord.info);
    }

    private void traceWCPanelStates(PrintWriter printWriter, WCPanelStates wCPanelStates) {
        if (wCPanelStates == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCPanelStates.pairedBefore);
        printWriter.print(wCPanelStates.secured);
        printWriter.print(wCPanelStates.justPaired);
        printWriter.print(wCPanelStates.defaultPin);
    }

    private void traceWCPinPukState(PrintWriter printWriter, WCPinPukState wCPinPukState) {
        if (wCPinPukState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCPinPukState.serialNumber);
        printWriter.print(wCPinPukState.state);
        printWriter.print(wCPinPukState.lockTime);
    }

    private void traceWCVehiclePanelInfo(PrintWriter printWriter, WCVehiclePanelInfo wCVehiclePanelInfo) {
        if (wCVehiclePanelInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wCVehiclePanelInfo.software);
        printWriter.print(wCVehiclePanelInfo.hardware);
    }

    private void traceWCViewOptions(PrintWriter printWriter, WCViewOptions wCViewOptions) {
        if (wCViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, wCViewOptions.systemOnOff);
        this.trace(printWriter, wCViewOptions.setFactoryDefault);
        this.trace(printWriter, wCViewOptions.autoActivation);
        this.trace(printWriter, wCViewOptions.vehiclePanelInfo);
        this.trace(printWriter, wCViewOptions.pinPukState);
        this.trace(printWriter, wCViewOptions.panelList);
        this.trace(printWriter, wCViewOptions.enterPinPuk);
        this.trace(printWriter, wCViewOptions.startScanning);
        this.trace(printWriter, wCViewOptions.startPairing);
        this.trace(printWriter, wCViewOptions.startSoftwareUpdate);
        this.trace(printWriter, wCViewOptions.changePin);
        this.trace(printWriter, wCViewOptions.changePanelName);
        this.trace(printWriter, wCViewOptions.configuration);
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

