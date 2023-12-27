/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.cardrivingcharacteristics;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.cardrivingcharacteristics.CharismaConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaOperationMode;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProfiles;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaScreens;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaTransmittableElements;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SoundAvailableStyles;
import org.dsi.ifc.cardrivingcharacteristics.SoundConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositionSetup;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerType;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlLevels;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public final class DSICarDrivingCharacteristicsTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CHARISMACONFIGURATION;
    private static final int ID_CHARISMALISTUPDATEINFO;
    private static final int ID_CHARISMAOPERATIONMODE;
    private static final int ID_CHARISMAPROFILES;
    private static final int ID_CHARISMAPROGBUTTON;
    private static final int ID_CHARISMASCREENS;
    private static final int ID_CHARISMASETUPTABLEWITHOPTIONMASK;
    private static final int ID_CHARISMASETUPTABLEWITHOUTOPTIONMASK;
    private static final int ID_CHARISMATRANSMITTABLEELEMENTS;
    private static final int ID_CHARISMAVIEWOPTIONS;
    private static final int ID_SOUNDAVAILABLESTYLES;
    private static final int ID_SOUNDCONFIGURATION;
    private static final int ID_SOUNDVIEWOPTIONS;
    private static final int ID_SPOILERCONFIGURATION;
    private static final int ID_SPOILERPOSITIONSETUP;
    private static final int ID_SPOILERPOSITIONS;
    private static final int ID_SPOILERSTATE;
    private static final int ID_SPOILERTYPE;
    private static final int ID_SPOILERVIEWOPTIONS;
    private static final int ID_SUSPENSIONCONTROLACTUATORINFO;
    private static final int ID_SUSPENSIONCONTROLADDITIONALFUNCTIONS;
    private static final int ID_SUSPENSIONCONTROLAIRPROFILES;
    private static final int ID_SUSPENSIONCONTROLCONFIGURATION;
    private static final int ID_SUSPENSIONCONTROLDRCPROFILES;
    private static final int ID_SUSPENSIONCONTROLHEIGHTINFO;
    private static final int ID_SUSPENSIONCONTROLLEVELS;
    private static final int ID_SUSPENSIONCONTROLOPERATIONMESSAGES;
    private static final int ID_SUSPENSIONCONTROLVIEWOPTIONS;
    private static final int ID_SUSPENSIONCONTROLEABCPREVIEW;
    private static final int ID_TADCONFIGURATION;
    private static final int ID_TADMAXMINANGLERESET;
    private static final int ID_TADVEHICLEINFO;
    private static final int ID_TADVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaOperationMode;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaProfiles;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaProgButton;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaScreens;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$CharismaViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SoundAvailableStyles;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SoundConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SoundViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositionSetup;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerState;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerType;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SpoilerViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlActuatorInfo;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAdditionalFunctions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAirProfiles;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlDRCProfiles;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlHeightInfo;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlLevels;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlOperationMessages;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControleABCPreview;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$TADConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$TADMaxMinAngleReset;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$TADVehicleInfo;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$TADViewOptions;

    public DSICarDrivingCharacteristicsTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaConfiguration == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaConfiguration = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaConfiguration")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaConfiguration, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaListUpdateInfo == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaListUpdateInfo = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaListUpdateInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaOperationMode == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaOperationMode = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaOperationMode")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaOperationMode, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaProfiles == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaProfiles = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaProfiles")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaProfiles, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaProgButton == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaProgButton = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaProgButton, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaScreens == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaScreens = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaScreens")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaScreens, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithOptionMask, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaSetupTableWithoutOptionMask, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaTransmittableElements == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaTransmittableElements = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaTransmittableElements")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaTransmittableElements, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$CharismaViewOptions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$CharismaViewOptions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions")) : class$org$dsi$ifc$cardrivingcharacteristics$CharismaViewOptions, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SoundAvailableStyles == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SoundAvailableStyles = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SoundAvailableStyles")) : class$org$dsi$ifc$cardrivingcharacteristics$SoundAvailableStyles, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SoundConfiguration == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SoundConfiguration = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SoundConfiguration")) : class$org$dsi$ifc$cardrivingcharacteristics$SoundConfiguration, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SoundViewOptions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SoundViewOptions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions")) : class$org$dsi$ifc$cardrivingcharacteristics$SoundViewOptions, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerConfiguration == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerConfiguration = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerConfiguration")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerConfiguration, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositionSetup == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositionSetup = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerPositionSetup")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositionSetup, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerPositions")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerPositions, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerState == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerState = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerState")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerState, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerType == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerType = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerType")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerType, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SpoilerViewOptions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SpoilerViewOptions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions")) : class$org$dsi$ifc$cardrivingcharacteristics$SpoilerViewOptions, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlActuatorInfo == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlActuatorInfo = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlActuatorInfo, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAdditionalFunctions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAdditionalFunctions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAdditionalFunctions, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAirProfiles == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAirProfiles = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlAirProfiles, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlConfiguration == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlConfiguration = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlConfiguration, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlDRCProfiles == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlDRCProfiles = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlDRCProfiles, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlHeightInfo == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlHeightInfo = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlHeightInfo, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlLevels == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlLevels = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlLevels")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlLevels, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlOperationMessages == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlOperationMessages = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlOperationMessages, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlViewOptions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlViewOptions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControlViewOptions, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControleABCPreview == null ? (class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControleABCPreview = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview")) : class$org$dsi$ifc$cardrivingcharacteristics$SuspensionControleABCPreview, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$TADConfiguration == null ? (class$org$dsi$ifc$cardrivingcharacteristics$TADConfiguration = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.TADConfiguration")) : class$org$dsi$ifc$cardrivingcharacteristics$TADConfiguration, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$TADMaxMinAngleReset == null ? (class$org$dsi$ifc$cardrivingcharacteristics$TADMaxMinAngleReset = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset")) : class$org$dsi$ifc$cardrivingcharacteristics$TADMaxMinAngleReset, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$TADVehicleInfo == null ? (class$org$dsi$ifc$cardrivingcharacteristics$TADVehicleInfo = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo")) : class$org$dsi$ifc$cardrivingcharacteristics$TADVehicleInfo, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cardrivingcharacteristics$TADViewOptions == null ? (class$org$dsi$ifc$cardrivingcharacteristics$TADViewOptions = DSICarDrivingCharacteristicsTracer.class$("org.dsi.ifc.cardrivingcharacteristics.TADViewOptions")) : class$org$dsi$ifc$cardrivingcharacteristics$TADViewOptions, 33);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCharismaConfiguration(printWriter, (CharismaConfiguration)object);
                break;
            }
            case 2: {
                this.traceCharismaListUpdateInfo(printWriter, (CharismaListUpdateInfo)object);
                break;
            }
            case 3: {
                this.traceCharismaOperationMode(printWriter, (CharismaOperationMode)object);
                break;
            }
            case 4: {
                this.traceCharismaProfiles(printWriter, (CharismaProfiles)object);
                break;
            }
            case 5: {
                this.traceCharismaProgButton(printWriter, (CharismaProgButton)object);
                break;
            }
            case 6: {
                this.traceCharismaScreens(printWriter, (CharismaScreens)object);
                break;
            }
            case 7: {
                this.traceCharismaSetupTableWithOptionMask(printWriter, (CharismaSetupTableWithOptionMask)object);
                break;
            }
            case 8: {
                this.traceCharismaSetupTableWithoutOptionMask(printWriter, (CharismaSetupTableWithoutOptionMask)object);
                break;
            }
            case 9: {
                this.traceCharismaTransmittableElements(printWriter, (CharismaTransmittableElements)object);
                break;
            }
            case 10: {
                this.traceCharismaViewOptions(printWriter, (CharismaViewOptions)object);
                break;
            }
            case 11: {
                this.traceSoundAvailableStyles(printWriter, (SoundAvailableStyles)object);
                break;
            }
            case 12: {
                this.traceSoundConfiguration(printWriter, (SoundConfiguration)object);
                break;
            }
            case 13: {
                this.traceSoundViewOptions(printWriter, (SoundViewOptions)object);
                break;
            }
            case 14: {
                this.traceSpoilerConfiguration(printWriter, (SpoilerConfiguration)object);
                break;
            }
            case 15: {
                this.traceSpoilerPositionSetup(printWriter, (SpoilerPositionSetup)object);
                break;
            }
            case 16: {
                this.traceSpoilerPositions(printWriter, (SpoilerPositions)object);
                break;
            }
            case 17: {
                this.traceSpoilerState(printWriter, (SpoilerState)object);
                break;
            }
            case 18: {
                this.traceSpoilerType(printWriter, (SpoilerType)object);
                break;
            }
            case 19: {
                this.traceSpoilerViewOptions(printWriter, (SpoilerViewOptions)object);
                break;
            }
            case 20: {
                this.traceSuspensionControlActuatorInfo(printWriter, (SuspensionControlActuatorInfo)object);
                break;
            }
            case 21: {
                this.traceSuspensionControlAdditionalFunctions(printWriter, (SuspensionControlAdditionalFunctions)object);
                break;
            }
            case 22: {
                this.traceSuspensionControlAirProfiles(printWriter, (SuspensionControlAirProfiles)object);
                break;
            }
            case 23: {
                this.traceSuspensionControlConfiguration(printWriter, (SuspensionControlConfiguration)object);
                break;
            }
            case 24: {
                this.traceSuspensionControlDRCProfiles(printWriter, (SuspensionControlDRCProfiles)object);
                break;
            }
            case 25: {
                this.traceSuspensionControlHeightInfo(printWriter, (SuspensionControlHeightInfo)object);
                break;
            }
            case 26: {
                this.traceSuspensionControlLevels(printWriter, (SuspensionControlLevels)object);
                break;
            }
            case 27: {
                this.traceSuspensionControlOperationMessages(printWriter, (SuspensionControlOperationMessages)object);
                break;
            }
            case 28: {
                this.traceSuspensionControlViewOptions(printWriter, (SuspensionControlViewOptions)object);
                break;
            }
            case 29: {
                this.traceSuspensionControleABCPreview(printWriter, (SuspensionControleABCPreview)object);
                break;
            }
            case 30: {
                this.traceTADConfiguration(printWriter, (TADConfiguration)object);
                break;
            }
            case 31: {
                this.traceTADMaxMinAngleReset(printWriter, (TADMaxMinAngleReset)object);
                break;
            }
            case 32: {
                this.traceTADVehicleInfo(printWriter, (TADVehicleInfo)object);
                break;
            }
            case 33: {
                this.traceTADViewOptions(printWriter, (TADViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCharismaConfiguration(PrintWriter printWriter, CharismaConfiguration charismaConfiguration) {
        if (charismaConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, charismaConfiguration.profilesAvailable);
        this.trace(printWriter, charismaConfiguration.charismaListTransmittableElements);
        printWriter.print(charismaConfiguration.systemType);
        this.trace(printWriter, charismaConfiguration.screensAvailable);
        this.trace(printWriter, charismaConfiguration.operationModesAvailable);
    }

    private void traceCharismaListUpdateInfo(PrintWriter printWriter, CharismaListUpdateInfo charismaListUpdateInfo) {
        if (charismaListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaListUpdateInfo.profileID);
        printWriter.print(charismaListUpdateInfo.arrayContent);
        printWriter.print(charismaListUpdateInfo.recordContent);
        printWriter.print(charismaListUpdateInfo.startElement);
        printWriter.print(charismaListUpdateInfo.numOfElements);
    }

    private void traceCharismaOperationMode(PrintWriter printWriter, CharismaOperationMode charismaOperationMode) {
        if (charismaOperationMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaOperationMode.evMode);
        printWriter.print(charismaOperationMode.hybridMode);
        printWriter.print(charismaOperationMode.sustainingMode);
        printWriter.print(charismaOperationMode.chargingMode);
        printWriter.print(charismaOperationMode.socControlMode);
        printWriter.print(charismaOperationMode.hybridSportMode);
    }

    private void traceCharismaProfiles(PrintWriter printWriter, CharismaProfiles charismaProfiles) {
        if (charismaProfiles == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaProfiles.comfort);
        printWriter.print(charismaProfiles.autonormal);
        printWriter.print(charismaProfiles.dynamic);
        printWriter.print(charismaProfiles.offroadallroad);
        printWriter.print(charismaProfiles.efficiency);
        printWriter.print(charismaProfiles.racesport);
        printWriter.print(charismaProfiles.individual);
        printWriter.print(charismaProfiles.range);
        printWriter.print(charismaProfiles.lift);
        printWriter.print(charismaProfiles.offroadlevel2);
        printWriter.print(charismaProfiles.offroadlevel3);
        printWriter.print(charismaProfiles.offroadlevel4);
    }

    private void traceCharismaProgButton(PrintWriter printWriter, CharismaProgButton charismaProgButton) {
        if (charismaProgButton == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaProgButton.button1);
        printWriter.print(charismaProgButton.button2);
        printWriter.print(charismaProgButton.button3);
        printWriter.print(charismaProgButton.button4);
        printWriter.print(charismaProgButton.button5);
    }

    private void traceCharismaScreens(PrintWriter printWriter, CharismaScreens charismaScreens) {
        if (charismaScreens == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaScreens.profiledcc);
        printWriter.print(charismaScreens.profile);
        printWriter.print(charismaScreens.dcc);
        printWriter.print(charismaScreens.airSuspension);
        printWriter.print(charismaScreens.hybrid);
        printWriter.print(charismaScreens.offroad);
    }

    private void traceCharismaSetupTableWithOptionMask(PrintWriter printWriter, CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask) {
        if (charismaSetupTableWithOptionMask == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaSetupTableWithOptionMask.listPosition);
        printWriter.print(charismaSetupTableWithOptionMask.functionID);
        printWriter.print(charismaSetupTableWithOptionMask.mask);
        printWriter.print(charismaSetupTableWithOptionMask.setupValue);
    }

    private void traceCharismaSetupTableWithoutOptionMask(PrintWriter printWriter, CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask) {
        if (charismaSetupTableWithoutOptionMask == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaSetupTableWithoutOptionMask.listPosition);
        printWriter.print(charismaSetupTableWithoutOptionMask.functionID);
        printWriter.print(charismaSetupTableWithoutOptionMask.setupValue);
    }

    private void traceCharismaTransmittableElements(PrintWriter printWriter, CharismaTransmittableElements charismaTransmittableElements) {
        if (charismaTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(charismaTransmittableElements.ra0);
        printWriter.print(charismaTransmittableElements.ra1);
        printWriter.print(charismaTransmittableElements.raF);
    }

    private void traceCharismaViewOptions(PrintWriter printWriter, CharismaViewOptions charismaViewOptions) {
        if (charismaViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, charismaViewOptions.activeProfile);
        this.trace(printWriter, charismaViewOptions.trailerMode);
        this.trace(printWriter, charismaViewOptions.progButton);
        this.trace(printWriter, charismaViewOptions.profileComfort);
        this.trace(printWriter, charismaViewOptions.profileAutoNormal);
        this.trace(printWriter, charismaViewOptions.profileDynamic);
        this.trace(printWriter, charismaViewOptions.profileOffroadAllroad);
        this.trace(printWriter, charismaViewOptions.profileEfficiency);
        this.trace(printWriter, charismaViewOptions.profileRaceSport);
        this.trace(printWriter, charismaViewOptions.profileIndividual);
        this.trace(printWriter, charismaViewOptions.setFactoryDefault);
        this.trace(printWriter, charismaViewOptions.charismaList);
        this.trace(printWriter, charismaViewOptions.configuration);
        this.trace(printWriter, charismaViewOptions.profileRange);
        this.trace(printWriter, charismaViewOptions.profileLift);
        this.trace(printWriter, charismaViewOptions.activeOperationMode);
        this.trace(printWriter, charismaViewOptions.evMode);
        this.trace(printWriter, charismaViewOptions.hybridMode);
        this.trace(printWriter, charismaViewOptions.sustainingMode);
        this.trace(printWriter, charismaViewOptions.chargingMode);
        this.trace(printWriter, charismaViewOptions.socControlMode);
        this.trace(printWriter, charismaViewOptions.profileOffroadLevel2);
        this.trace(printWriter, charismaViewOptions.profileOffroadLevel3);
        this.trace(printWriter, charismaViewOptions.profileOffroadLevel4);
        this.trace(printWriter, charismaViewOptions.hybridSportMode);
        this.trace(printWriter, charismaViewOptions.sound);
    }

    private void traceSoundAvailableStyles(PrintWriter printWriter, SoundAvailableStyles soundAvailableStyles) {
        if (soundAvailableStyles == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(soundAvailableStyles.style1);
        printWriter.print(soundAvailableStyles.style2);
        printWriter.print(soundAvailableStyles.style3);
        printWriter.print(soundAvailableStyles.style4);
        printWriter.print(soundAvailableStyles.style5);
        printWriter.print(soundAvailableStyles.style6);
        printWriter.print(soundAvailableStyles.style7);
        printWriter.print(soundAvailableStyles.style8);
    }

    private void traceSoundConfiguration(PrintWriter printWriter, SoundConfiguration soundConfiguration) {
        if (soundConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, soundConfiguration.availableSoundStyles);
    }

    private void traceSoundViewOptions(PrintWriter printWriter, SoundViewOptions soundViewOptions) {
        if (soundViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, soundViewOptions.configuration);
        this.trace(printWriter, soundViewOptions.setFactoryDefault);
        this.trace(printWriter, soundViewOptions.systemOnOff);
        this.trace(printWriter, soundViewOptions.soundOnOff);
        this.trace(printWriter, soundViewOptions.style);
    }

    private void traceSpoilerConfiguration(PrintWriter printWriter, SpoilerConfiguration spoilerConfiguration) {
        if (spoilerConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, spoilerConfiguration.type);
        this.trace(printWriter, spoilerConfiguration.positionsAvailable);
        this.trace(printWriter, spoilerConfiguration.positionSetup);
    }

    private void traceSpoilerPositionSetup(PrintWriter printWriter, SpoilerPositionSetup spoilerPositionSetup) {
        if (spoilerPositionSetup == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(spoilerPositionSetup.position0);
        printWriter.print(spoilerPositionSetup.position1);
        printWriter.print(spoilerPositionSetup.position2);
        printWriter.print(spoilerPositionSetup.position3);
        printWriter.print(spoilerPositionSetup.position4);
        printWriter.print(spoilerPositionSetup.position5);
    }

    private void traceSpoilerPositions(PrintWriter printWriter, SpoilerPositions spoilerPositions) {
        if (spoilerPositions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(spoilerPositions.position0);
        printWriter.print(spoilerPositions.position1);
        printWriter.print(spoilerPositions.position2);
        printWriter.print(spoilerPositions.position3);
        printWriter.print(spoilerPositions.position4);
        printWriter.print(spoilerPositions.position5);
    }

    private void traceSpoilerState(PrintWriter printWriter, SpoilerState spoilerState) {
        if (spoilerState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(spoilerState.state);
        printWriter.print(spoilerState.currentPosition);
    }

    private void traceSpoilerType(PrintWriter printWriter, SpoilerType spoilerType) {
        if (spoilerType == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(spoilerType.basis);
        printWriter.print(spoilerType.flaps);
        printWriter.print(spoilerType.angle);
    }

    private void traceSpoilerViewOptions(PrintWriter printWriter, SpoilerViewOptions spoilerViewOptions) {
        if (spoilerViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, spoilerViewOptions.positionSelection);
        this.trace(printWriter, spoilerViewOptions.position0);
        this.trace(printWriter, spoilerViewOptions.position1);
        this.trace(printWriter, spoilerViewOptions.position2);
        this.trace(printWriter, spoilerViewOptions.position3);
        this.trace(printWriter, spoilerViewOptions.position4);
        this.trace(printWriter, spoilerViewOptions.position5);
        this.trace(printWriter, spoilerViewOptions.state);
        this.trace(printWriter, spoilerViewOptions.actuation);
        this.trace(printWriter, spoilerViewOptions.messages);
        this.trace(printWriter, spoilerViewOptions.setFactoryDefault);
        this.trace(printWriter, spoilerViewOptions.systemOnOff);
        this.trace(printWriter, spoilerViewOptions.configuration);
    }

    private void traceSuspensionControlActuatorInfo(PrintWriter printWriter, SuspensionControlActuatorInfo suspensionControlActuatorInfo) {
        if (suspensionControlActuatorInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlActuatorInfo.frontLeft);
        printWriter.print(suspensionControlActuatorInfo.frontRight);
        printWriter.print(suspensionControlActuatorInfo.rearLeft);
        printWriter.print(suspensionControlActuatorInfo.rearRight);
    }

    private void traceSuspensionControlAdditionalFunctions(PrintWriter printWriter, SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions) {
        if (suspensionControlAdditionalFunctions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlAdditionalFunctions.actualNiveau);
        printWriter.print(suspensionControlAdditionalFunctions.targetNiveau);
        printWriter.print(suspensionControlAdditionalFunctions.vehicleStatus);
        printWriter.print(suspensionControlAdditionalFunctions.vehicleStateControl);
    }

    private void traceSuspensionControlAirProfiles(PrintWriter printWriter, SuspensionControlAirProfiles suspensionControlAirProfiles) {
        if (suspensionControlAirProfiles == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlAirProfiles.profile1);
        printWriter.print(suspensionControlAirProfiles.profile2);
        printWriter.print(suspensionControlAirProfiles.profile3);
        printWriter.print(suspensionControlAirProfiles.profile4);
        printWriter.print(suspensionControlAirProfiles.profile5);
        printWriter.print(suspensionControlAirProfiles.profile6);
        printWriter.print(suspensionControlAirProfiles.profile7);
    }

    private void traceSuspensionControlConfiguration(PrintWriter printWriter, SuspensionControlConfiguration suspensionControlConfiguration) {
        if (suspensionControlConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlConfiguration.deviceType);
        printWriter.print(suspensionControlConfiguration.modelType);
        this.trace(printWriter, suspensionControlConfiguration.airProfileAvailability);
        this.trace(printWriter, suspensionControlConfiguration.drcProfileAvailability);
        this.trace(printWriter, suspensionControlConfiguration.additionalFunctionsAvailability);
        this.trace(printWriter, suspensionControlConfiguration.levelsAvailability);
    }

    private void traceSuspensionControlDRCProfiles(PrintWriter printWriter, SuspensionControlDRCProfiles suspensionControlDRCProfiles) {
        if (suspensionControlDRCProfiles == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlDRCProfiles.profile1);
        printWriter.print(suspensionControlDRCProfiles.profile2);
        printWriter.print(suspensionControlDRCProfiles.profile3);
        printWriter.print(suspensionControlDRCProfiles.profile4);
    }

    private void traceSuspensionControlHeightInfo(PrintWriter printWriter, SuspensionControlHeightInfo suspensionControlHeightInfo) {
        if (suspensionControlHeightInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlHeightInfo.frontLeft);
        printWriter.print(suspensionControlHeightInfo.frontRight);
        printWriter.print(suspensionControlHeightInfo.rearLeft);
        printWriter.print(suspensionControlHeightInfo.rearRight);
    }

    private void traceSuspensionControlLevels(PrintWriter printWriter, SuspensionControlLevels suspensionControlLevels) {
        if (suspensionControlLevels == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlLevels.level1);
        printWriter.print(suspensionControlLevels.level2);
        printWriter.print(suspensionControlLevels.level3);
        printWriter.print(suspensionControlLevels.level4);
        printWriter.print(suspensionControlLevels.level5);
        printWriter.print(suspensionControlLevels.level6);
        printWriter.print(suspensionControlLevels.level7);
    }

    private void traceSuspensionControlOperationMessages(PrintWriter printWriter, SuspensionControlOperationMessages suspensionControlOperationMessages) {
        if (suspensionControlOperationMessages == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControlOperationMessages.failureReason);
        printWriter.print(suspensionControlOperationMessages.selectionConfirmation);
        printWriter.print(suspensionControlOperationMessages.processFinished);
        printWriter.print(suspensionControlOperationMessages.regulation);
    }

    private void traceSuspensionControlViewOptions(PrintWriter printWriter, SuspensionControlViewOptions suspensionControlViewOptions) {
        if (suspensionControlViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, suspensionControlViewOptions.liftMode);
        this.trace(printWriter, suspensionControlViewOptions.carJackMode);
        this.trace(printWriter, suspensionControlViewOptions.trailerMode);
        this.trace(printWriter, suspensionControlViewOptions.loadingMode);
        this.trace(printWriter, suspensionControlViewOptions.activeProfile);
        this.trace(printWriter, suspensionControlViewOptions.heightInfo);
        this.trace(printWriter, suspensionControlViewOptions.operationMessages);
        this.trace(printWriter, suspensionControlViewOptions.configuration);
        this.trace(printWriter, suspensionControlViewOptions.snowChainMode);
        this.trace(printWriter, suspensionControlViewOptions.airsuspActiveMode);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode0);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode1);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode2);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode3);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode4);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode5);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode6);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode7);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode8);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode9);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode10);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode11);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode12);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode13);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode14);
        this.trace(printWriter, suspensionControlViewOptions.airsuspMode15);
        this.trace(printWriter, suspensionControlViewOptions.eABCEasyEntry);
        this.trace(printWriter, suspensionControlViewOptions.eABCPitchControl);
        this.trace(printWriter, suspensionControlViewOptions.eABCSpecialPosition);
        this.trace(printWriter, suspensionControlViewOptions.eABCPreView);
        this.trace(printWriter, suspensionControlViewOptions.eABCPreViewState);
        this.trace(printWriter, suspensionControlViewOptions.actuatorInfo);
    }

    private void traceSuspensionControleABCPreview(PrintWriter printWriter, SuspensionControleABCPreview suspensionControleABCPreview) {
        if (suspensionControleABCPreview == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suspensionControleABCPreview.state);
        printWriter.print(suspensionControleABCPreview.obstacleLevel);
    }

    private void traceTADConfiguration(PrintWriter printWriter, TADConfiguration tADConfiguration) {
        if (tADConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tADConfiguration.rollAngleMaxScale);
        printWriter.print(tADConfiguration.rollAngleStartSoftWarning);
        printWriter.print(tADConfiguration.rollAngleStartHardWarning);
        printWriter.print(tADConfiguration.pitchAngleMaxScale);
        printWriter.print(tADConfiguration.pitchAngleStartSoftWarning);
        printWriter.print(tADConfiguration.pitchAngleStartHardWarning);
        printWriter.print(tADConfiguration.rollAngleInstallation);
        printWriter.print(tADConfiguration.pitchAngleInstallation);
    }

    private void traceTADMaxMinAngleReset(PrintWriter printWriter, TADMaxMinAngleReset tADMaxMinAngleReset) {
        if (tADMaxMinAngleReset == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tADMaxMinAngleReset.rollAngle);
        printWriter.print(tADMaxMinAngleReset.pitchAngle);
    }

    private void traceTADVehicleInfo(PrintWriter printWriter, TADVehicleInfo tADVehicleInfo) {
        if (tADVehicleInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tADVehicleInfo.roofLoad);
        printWriter.print(tADVehicleInfo.trailer);
    }

    private void traceTADViewOptions(PrintWriter printWriter, TADViewOptions tADViewOptions) {
        if (tADViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tADViewOptions.maxMinAnglesReset);
        this.trace(printWriter, tADViewOptions.configuration);
        this.trace(printWriter, tADViewOptions.angleDisplay);
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

