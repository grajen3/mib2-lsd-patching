/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.cardriverassistance;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms;
import org.dsi.ifc.cardriverassistance.ACCConfiguration;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVConfiguration;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.CurveAssistViewOptions;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVConfiguration;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWAConfiguration;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDConfiguration;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSignInfo;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;

public final class DSICarDriverAssistanceTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ACCAVAILABLEDRIVINGPROGRAMS;
    private static final int ID_ACCCONFIGURATION;
    private static final int ID_ACCDISTANCEWARNING;
    private static final int ID_ACCVIEWOPTIONS;
    private static final int ID_AWVCONFIGURATION;
    private static final int ID_AWVEMERGENCYBRAKE;
    private static final int ID_AWVVIEWOPTIONS;
    private static final int ID_CURVEASSISTVIEWOPTIONS;
    private static final int ID_FTASENSORDATA;
    private static final int ID_FTAVIEWOPTIONS;
    private static final int ID_LDWHCAVIEWOPTIONS;
    private static final int ID_MKEVIEWOPTIONS;
    private static final int ID_NVCONFIGURATION;
    private static final int ID_NVOBJECTDETECTION;
    private static final int ID_NVVIEWOPTIONS;
    private static final int ID_PAVIEWOPTIONS;
    private static final int ID_SWACONFIGURATION;
    private static final int ID_SWARCTASENSORDATA;
    private static final int ID_SWAVIEWOPTIONS;
    private static final int ID_TSDCONFIGURATION;
    private static final int ID_TSDROADSIGNFILTER;
    private static final int ID_TSDSIGNFCT;
    private static final int ID_TSDSIGNINFO;
    private static final int ID_TSDSYSTEMMESSAGES;
    private static final int ID_TSDVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$ACCAvailableDrivingPrograms;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$ACCConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$ACCDistanceWarning;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$ACCViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$AWVConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$AWVEmergencyBrake;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$AWVViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$CurveAssistViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$FTASensorData;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$FTAViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$LDWHCAViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$MKEViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$NVConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$NVObjectDetection;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$NVViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$PAViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$SWAConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$SWARCTASensorData;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$SWAViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDRoadSignFilter;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDSignFct;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDSignInfo;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDSystemMessages;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$TSDViewOptions;

    public DSICarDriverAssistanceTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$ACCAvailableDrivingPrograms == null ? (class$org$dsi$ifc$cardriverassistance$ACCAvailableDrivingPrograms = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms")) : class$org$dsi$ifc$cardriverassistance$ACCAvailableDrivingPrograms, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$ACCConfiguration == null ? (class$org$dsi$ifc$cardriverassistance$ACCConfiguration = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.ACCConfiguration")) : class$org$dsi$ifc$cardriverassistance$ACCConfiguration, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$ACCDistanceWarning == null ? (class$org$dsi$ifc$cardriverassistance$ACCDistanceWarning = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.ACCDistanceWarning")) : class$org$dsi$ifc$cardriverassistance$ACCDistanceWarning, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$ACCViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$ACCViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.ACCViewOptions")) : class$org$dsi$ifc$cardriverassistance$ACCViewOptions, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$AWVConfiguration == null ? (class$org$dsi$ifc$cardriverassistance$AWVConfiguration = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.AWVConfiguration")) : class$org$dsi$ifc$cardriverassistance$AWVConfiguration, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$AWVEmergencyBrake == null ? (class$org$dsi$ifc$cardriverassistance$AWVEmergencyBrake = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.AWVEmergencyBrake")) : class$org$dsi$ifc$cardriverassistance$AWVEmergencyBrake, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$AWVViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$AWVViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.AWVViewOptions")) : class$org$dsi$ifc$cardriverassistance$AWVViewOptions, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$CurveAssistViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$CurveAssistViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.CurveAssistViewOptions")) : class$org$dsi$ifc$cardriverassistance$CurveAssistViewOptions, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$FTASensorData == null ? (class$org$dsi$ifc$cardriverassistance$FTASensorData = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.FTASensorData")) : class$org$dsi$ifc$cardriverassistance$FTASensorData, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$FTAViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$FTAViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.FTAViewOptions")) : class$org$dsi$ifc$cardriverassistance$FTAViewOptions, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$LDWHCAViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$LDWHCAViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.LDWHCAViewOptions")) : class$org$dsi$ifc$cardriverassistance$LDWHCAViewOptions, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$MKEViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$MKEViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.MKEViewOptions")) : class$org$dsi$ifc$cardriverassistance$MKEViewOptions, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$NVConfiguration == null ? (class$org$dsi$ifc$cardriverassistance$NVConfiguration = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.NVConfiguration")) : class$org$dsi$ifc$cardriverassistance$NVConfiguration, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$NVObjectDetection == null ? (class$org$dsi$ifc$cardriverassistance$NVObjectDetection = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.NVObjectDetection")) : class$org$dsi$ifc$cardriverassistance$NVObjectDetection, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$NVViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$NVViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.NVViewOptions")) : class$org$dsi$ifc$cardriverassistance$NVViewOptions, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$PAViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$PAViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.PAViewOptions")) : class$org$dsi$ifc$cardriverassistance$PAViewOptions, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$SWAConfiguration == null ? (class$org$dsi$ifc$cardriverassistance$SWAConfiguration = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.SWAConfiguration")) : class$org$dsi$ifc$cardriverassistance$SWAConfiguration, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$SWARCTASensorData == null ? (class$org$dsi$ifc$cardriverassistance$SWARCTASensorData = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.SWARCTASensorData")) : class$org$dsi$ifc$cardriverassistance$SWARCTASensorData, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$SWAViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$SWAViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.SWAViewOptions")) : class$org$dsi$ifc$cardriverassistance$SWAViewOptions, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDConfiguration == null ? (class$org$dsi$ifc$cardriverassistance$TSDConfiguration = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDConfiguration")) : class$org$dsi$ifc$cardriverassistance$TSDConfiguration, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDRoadSignFilter == null ? (class$org$dsi$ifc$cardriverassistance$TSDRoadSignFilter = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDRoadSignFilter")) : class$org$dsi$ifc$cardriverassistance$TSDRoadSignFilter, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDSignFct == null ? (class$org$dsi$ifc$cardriverassistance$TSDSignFct = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDSignFct")) : class$org$dsi$ifc$cardriverassistance$TSDSignFct, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDSignInfo == null ? (class$org$dsi$ifc$cardriverassistance$TSDSignInfo = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDSignInfo")) : class$org$dsi$ifc$cardriverassistance$TSDSignInfo, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDSystemMessages == null ? (class$org$dsi$ifc$cardriverassistance$TSDSystemMessages = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDSystemMessages")) : class$org$dsi$ifc$cardriverassistance$TSDSystemMessages, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardriverassistance$TSDViewOptions == null ? (class$org$dsi$ifc$cardriverassistance$TSDViewOptions = DSICarDriverAssistanceTracer.class$("org.dsi.ifc.cardriverassistance.TSDViewOptions")) : class$org$dsi$ifc$cardriverassistance$TSDViewOptions, 25);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceACCAvailableDrivingPrograms(printWriter, (ACCAvailableDrivingPrograms)object);
                break;
            }
            case 2: {
                this.traceACCConfiguration(printWriter, (ACCConfiguration)object);
                break;
            }
            case 3: {
                this.traceACCDistanceWarning(printWriter, (ACCDistanceWarning)object);
                break;
            }
            case 4: {
                this.traceACCViewOptions(printWriter, (ACCViewOptions)object);
                break;
            }
            case 5: {
                this.traceAWVConfiguration(printWriter, (AWVConfiguration)object);
                break;
            }
            case 6: {
                this.traceAWVEmergencyBrake(printWriter, (AWVEmergencyBrake)object);
                break;
            }
            case 7: {
                this.traceAWVViewOptions(printWriter, (AWVViewOptions)object);
                break;
            }
            case 8: {
                this.traceCurveAssistViewOptions(printWriter, (CurveAssistViewOptions)object);
                break;
            }
            case 9: {
                this.traceFTASensorData(printWriter, (FTASensorData)object);
                break;
            }
            case 10: {
                this.traceFTAViewOptions(printWriter, (FTAViewOptions)object);
                break;
            }
            case 11: {
                this.traceLDWHCAViewOptions(printWriter, (LDWHCAViewOptions)object);
                break;
            }
            case 12: {
                this.traceMKEViewOptions(printWriter, (MKEViewOptions)object);
                break;
            }
            case 13: {
                this.traceNVConfiguration(printWriter, (NVConfiguration)object);
                break;
            }
            case 14: {
                this.traceNVObjectDetection(printWriter, (NVObjectDetection)object);
                break;
            }
            case 15: {
                this.traceNVViewOptions(printWriter, (NVViewOptions)object);
                break;
            }
            case 16: {
                this.tracePAViewOptions(printWriter, (PAViewOptions)object);
                break;
            }
            case 17: {
                this.traceSWAConfiguration(printWriter, (SWAConfiguration)object);
                break;
            }
            case 18: {
                this.traceSWARCTASensorData(printWriter, (SWARCTASensorData)object);
                break;
            }
            case 19: {
                this.traceSWAViewOptions(printWriter, (SWAViewOptions)object);
                break;
            }
            case 20: {
                this.traceTSDConfiguration(printWriter, (TSDConfiguration)object);
                break;
            }
            case 21: {
                this.traceTSDRoadSignFilter(printWriter, (TSDRoadSignFilter)object);
                break;
            }
            case 22: {
                this.traceTSDSignFct(printWriter, (TSDSignFct)object);
                break;
            }
            case 23: {
                this.traceTSDSignInfo(printWriter, (TSDSignInfo)object);
                break;
            }
            case 24: {
                this.traceTSDSystemMessages(printWriter, (TSDSystemMessages)object);
                break;
            }
            case 25: {
                this.traceTSDViewOptions(printWriter, (TSDViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceACCAvailableDrivingPrograms(PrintWriter printWriter, ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms) {
        if (aCCAvailableDrivingPrograms == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aCCAvailableDrivingPrograms.dynamic);
        printWriter.print(aCCAvailableDrivingPrograms.comfort);
        printWriter.print(aCCAvailableDrivingPrograms.standard);
        printWriter.print(aCCAvailableDrivingPrograms.eco);
    }

    private void traceACCConfiguration(PrintWriter printWriter, ACCConfiguration aCCConfiguration) {
        if (aCCConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, aCCConfiguration.drivingPrograms);
    }

    private void traceACCDistanceWarning(PrintWriter printWriter, ACCDistanceWarning aCCDistanceWarning) {
        if (aCCDistanceWarning == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aCCDistanceWarning.systemState);
        printWriter.print(aCCDistanceWarning.timeGap);
    }

    private void traceACCViewOptions(PrintWriter printWriter, ACCViewOptions aCCViewOptions) {
        if (aCCViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, aCCViewOptions.gongState);
        this.trace(printWriter, aCCViewOptions.gongVolume);
        this.trace(printWriter, aCCViewOptions.timegap);
        this.trace(printWriter, aCCViewOptions.drivingProgram);
        this.trace(printWriter, aCCViewOptions.defaultMode);
        this.trace(printWriter, aCCViewOptions.curveAssist);
        this.trace(printWriter, aCCViewOptions.speedLimitAdoption);
        this.trace(printWriter, aCCViewOptions.speedLimitOffset);
        this.trace(printWriter, aCCViewOptions.trafficJamAssist);
        this.trace(printWriter, aCCViewOptions.distanceWarning);
        this.trace(printWriter, aCCViewOptions.setFactoryDefault);
        this.trace(printWriter, aCCViewOptions.configuration);
        this.trace(printWriter, aCCViewOptions.paccSensibility);
        this.trace(printWriter, aCCViewOptions.paccMaxSpeed);
        this.trace(printWriter, aCCViewOptions.paccMeanVelocity);
        this.trace(printWriter, aCCViewOptions.paccMeanConsumption);
        this.trace(printWriter, aCCViewOptions.paccCoastingPercentage);
        this.trace(printWriter, aCCViewOptions.paccDrivingProgram);
        this.trace(printWriter, aCCViewOptions.paccSystemState);
    }

    private void traceAWVConfiguration(PrintWriter printWriter, AWVConfiguration aWVConfiguration) {
        if (aWVConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aWVConfiguration.systemMode);
    }

    private void traceAWVEmergencyBrake(PrintWriter printWriter, AWVEmergencyBrake aWVEmergencyBrake) {
        if (aWVEmergencyBrake == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(aWVEmergencyBrake.targetBrake);
        printWriter.print(aWVEmergencyBrake.autoBrake);
    }

    private void traceAWVViewOptions(PrintWriter printWriter, AWVViewOptions aWVViewOptions) {
        if (aWVViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, aWVViewOptions.system);
        this.trace(printWriter, aWVViewOptions.warning);
        this.trace(printWriter, aWVViewOptions.gong);
        this.trace(printWriter, aWVViewOptions.gongVolume);
        this.trace(printWriter, aWVViewOptions.brakeJerk);
        this.trace(printWriter, aWVViewOptions.emergencyBrake);
        this.trace(printWriter, aWVViewOptions.distanceWarning);
        this.trace(printWriter, aWVViewOptions.warningTimegap);
        this.trace(printWriter, aWVViewOptions.setFactoryDefault);
        this.trace(printWriter, aWVViewOptions.configuration);
    }

    private void traceCurveAssistViewOptions(PrintWriter printWriter, CurveAssistViewOptions curveAssistViewOptions) {
        if (curveAssistViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, curveAssistViewOptions.curveAssistSystemOnOff);
        this.trace(printWriter, curveAssistViewOptions.curveAssistSetFactoryDefault);
    }

    private void traceFTASensorData(PrintWriter printWriter, FTASensorData fTASensorData) {
        if (fTASensorData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(fTASensorData.statusLevelFrontRight);
        printWriter.print(fTASensorData.statusLevelFrontLeft);
    }

    private void traceFTAViewOptions(PrintWriter printWriter, FTAViewOptions fTAViewOptions) {
        if (fTAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, fTAViewOptions.system);
    }

    private void traceLDWHCAViewOptions(PrintWriter printWriter, LDWHCAViewOptions lDWHCAViewOptions) {
        if (lDWHCAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, lDWHCAViewOptions.hCAToleranceLevel);
        this.trace(printWriter, lDWHCAViewOptions.lDWSteeringWheelVibration);
        this.trace(printWriter, lDWHCAViewOptions.hCAInterventionStyle);
        this.trace(printWriter, lDWHCAViewOptions.lDWWarningTime);
        this.trace(printWriter, lDWHCAViewOptions.ldwhcaSetFactoryDefault);
        this.trace(printWriter, lDWHCAViewOptions.ldwhcaSystemOnOff);
        this.trace(printWriter, lDWHCAViewOptions.ldwhcaWarningSound);
    }

    private void traceMKEViewOptions(PrintWriter printWriter, MKEViewOptions mKEViewOptions) {
        if (mKEViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, mKEViewOptions.systemOnOff);
        this.trace(printWriter, mKEViewOptions.mkeSetFactoryDefault);
    }

    private void traceNVConfiguration(PrintWriter printWriter, NVConfiguration nVConfiguration) {
        if (nVConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(nVConfiguration.installationHUDDisplay);
        printWriter.print(nVConfiguration.installationKombiDisplay);
        printWriter.print(nVConfiguration.installationMMIDisplay);
        printWriter.print(nVConfiguration.panning);
        printWriter.print(nVConfiguration.animalDetection);
        printWriter.print(nVConfiguration.pedestrianDetection);
    }

    private void traceNVObjectDetection(PrintWriter printWriter, NVObjectDetection nVObjectDetection) {
        if (nVObjectDetection == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(nVObjectDetection.animalDetection);
        printWriter.print(nVObjectDetection.pedestrianDetection);
    }

    private void traceNVViewOptions(PrintWriter printWriter, NVViewOptions nVViewOptions) {
        if (nVViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, nVViewOptions.activation);
        this.trace(printWriter, nVViewOptions.contrast);
        this.trace(printWriter, nVViewOptions.brightness);
        this.trace(printWriter, nVViewOptions.objectDetection);
        this.trace(printWriter, nVViewOptions.colorPA);
        this.trace(printWriter, nVViewOptions.designPA);
        this.trace(printWriter, nVViewOptions.display);
        this.trace(printWriter, nVViewOptions.zoomPanning);
        this.trace(printWriter, nVViewOptions.sound);
        this.trace(printWriter, nVViewOptions.symbol);
        this.trace(printWriter, nVViewOptions.configuration);
        this.trace(printWriter, nVViewOptions.system);
        this.trace(printWriter, nVViewOptions.setFactoryDefault);
        this.trace(printWriter, nVViewOptions.warningTimegap);
    }

    private void tracePAViewOptions(PrintWriter printWriter, PAViewOptions pAViewOptions) {
        if (pAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, pAViewOptions.paSystemOnOff);
        this.trace(printWriter, pAViewOptions.paSetFactoryDefault);
        this.trace(printWriter, pAViewOptions.paConfigInformation);
        this.trace(printWriter, pAViewOptions.paConfigWarning);
        this.trace(printWriter, pAViewOptions.paWarningTimegap);
    }

    private void traceSWAConfiguration(PrintWriter printWriter, SWAConfiguration sWAConfiguration) {
        if (sWAConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sWAConfiguration.system);
    }

    private void traceSWARCTASensorData(PrintWriter printWriter, SWARCTASensorData sWARCTASensorData) {
        if (sWARCTASensorData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sWARCTASensorData.statusLevelRearRight);
        printWriter.print(sWARCTASensorData.distanceRearRight);
        printWriter.print(sWARCTASensorData.statusLevelRearLeft);
        printWriter.print(sWARCTASensorData.distanceRearLeft);
    }

    private void traceSWAViewOptions(PrintWriter printWriter, SWAViewOptions sWAViewOptions) {
        if (sWAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, sWAViewOptions.brightness);
        this.trace(printWriter, sWAViewOptions.warningTime);
        this.trace(printWriter, sWAViewOptions.frequence);
        this.trace(printWriter, sWAViewOptions.system);
        this.trace(printWriter, sWAViewOptions.gongState);
        this.trace(printWriter, sWAViewOptions.gongVolume);
        this.trace(printWriter, sWAViewOptions.rcta);
        this.trace(printWriter, sWAViewOptions.exitAssist);
        this.trace(printWriter, sWAViewOptions.configuration);
    }

    private void traceTSDConfiguration(PrintWriter printWriter, TSDConfiguration tSDConfiguration) {
        if (tSDConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tSDConfiguration.type);
    }

    private void traceTSDRoadSignFilter(PrintWriter printWriter, TSDRoadSignFilter tSDRoadSignFilter) {
        if (tSDRoadSignFilter == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tSDRoadSignFilter.trailerLimits);
    }

    private void traceTSDSignFct(PrintWriter printWriter, TSDSignFct tSDSignFct) {
        if (tSDSignFct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tSDSignFct.sign);
        printWriter.print(tSDSignFct.signDynamicValue);
        printWriter.print(tSDSignFct.addSign);
        printWriter.print(tSDSignFct.addSignDynamicValue);
        this.trace(printWriter, tSDSignFct.signInfo);
    }

    private void traceTSDSignInfo(PrintWriter printWriter, TSDSignInfo tSDSignInfo) {
        if (tSDSignInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tSDSignInfo.roadWorkSign);
        printWriter.print(tSDSignInfo.sourceIsCamera);
        printWriter.print(tSDSignInfo.signWarning);
        printWriter.print(tSDSignInfo.mph);
        printWriter.print(tSDSignInfo.sourceIsDatabase);
        printWriter.print(tSDSignInfo.sourceIsFusion);
        printWriter.print(tSDSignInfo.startUrbanArea);
        printWriter.print(tSDSignInfo.endUrbanArea);
        printWriter.print(tSDSignInfo.startTrafficCalmedArea);
        printWriter.print(tSDSignInfo.endTrafficCalmedArea);
        printWriter.print(tSDSignInfo.signEffective);
        printWriter.print(tSDSignInfo.acousticWarning);
    }

    private void traceTSDSystemMessages(PrintWriter printWriter, TSDSystemMessages tSDSystemMessages) {
        if (tSDSystemMessages == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tSDSystemMessages.disclaimer);
        printWriter.print(tSDSystemMessages.roadSignRecognition);
        printWriter.print(tSDSystemMessages.cameraBlind);
        printWriter.print(tSDSystemMessages.navigationData);
        printWriter.print(tSDSystemMessages.system);
        printWriter.print(tSDSystemMessages.operationArea);
        printWriter.print(tSDSystemMessages.roadSignRecognitionInit);
        printWriter.print(tSDSystemMessages.speedWarning);
        printWriter.print(tSDSystemMessages.wrongWayWarningLevel1);
        printWriter.print(tSDSystemMessages.wrongWayWarningLevel2);
        printWriter.print(tSDSystemMessages.wrongWayWarningOperationArea);
        printWriter.print(tSDSystemMessages.wrongWayWarning);
    }

    private void traceTSDViewOptions(PrintWriter printWriter, TSDViewOptions tSDViewOptions) {
        if (tSDViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tSDViewOptions.systemOnOff);
        this.trace(printWriter, tSDViewOptions.trailerDetection);
        this.trace(printWriter, tSDViewOptions.roadSign);
        this.trace(printWriter, tSDViewOptions.roadSignFilter);
        this.trace(printWriter, tSDViewOptions.tsdSetFactoryDefault);
        this.trace(printWriter, tSDViewOptions.speedWarningThreshold);
        this.trace(printWriter, tSDViewOptions.trailerSpeedLimit);
        this.trace(printWriter, tSDViewOptions.systemMessages);
        this.trace(printWriter, tSDViewOptions.speedWarnAcoustics);
        this.trace(printWriter, tSDViewOptions.configuration);
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

