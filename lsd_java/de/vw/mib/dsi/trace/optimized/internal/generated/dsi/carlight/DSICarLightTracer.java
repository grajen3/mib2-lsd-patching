/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carlight;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carlight.ExtLightConfig;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightStatus;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightSetupColors;
import org.dsi.ifc.carlight.IntLightTransmittableElements;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public final class DSICarLightTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_EXTLIGHTCONFIG;
    private static final int ID_EXTLIGHTLAMPERRORDETECTIONSTATE;
    private static final int ID_EXTLIGHTLAMPERRORDETECTIONSTATETRAILER;
    private static final int ID_EXTLIGHTSENSORERRORDETECTIONSTATE;
    private static final int ID_EXTLIGHTSTATUS;
    private static final int ID_EXTLIGHTVIEWOPTIONS;
    private static final int ID_INTLIGHTBRIGHTNESS;
    private static final int ID_INTLIGHTCONFIG;
    private static final int ID_INTLIGHTMEMBERSILLUMINATIONSET;
    private static final int ID_INTLIGHTMEMBERSMULTICOLOR;
    private static final int ID_INTLIGHTRGBCOLORLISTRA0;
    private static final int ID_INTLIGHTRGBCOLORLISTUPDATEINFO;
    private static final int ID_INTLIGHTRGBVALUES;
    private static final int ID_INTLIGHTSETUPCOLORS;
    private static final int ID_INTLIGHTTRANSMITTABLEELEMENTS;
    private static final int ID_INTLIGHTVIEWOPTIONS;
    private static final int ID_MOTORWAYBLINKINGSETTINGS;
    private static final int ID_TIMESTATE;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionState;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionStateTrailer;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightSensorErrorDetectionState;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightStatus;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$ExtLightViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightBrightness;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightMembersIlluminationSet;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightMembersMultiColor;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightRGBColorListRA0;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightRGBValues;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightSetupColors;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$IntLightViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$MotorwayBlinkingSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$TimeState;

    public DSICarLightTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightConfig == null ? (class$org$dsi$ifc$carlight$ExtLightConfig = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightConfig")) : class$org$dsi$ifc$carlight$ExtLightConfig, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionState == null ? (class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionState = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightLampErrorDetectionState")) : class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionState, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionStateTrailer == null ? (class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionStateTrailer = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer")) : class$org$dsi$ifc$carlight$ExtLightLampErrorDetectionStateTrailer, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightSensorErrorDetectionState == null ? (class$org$dsi$ifc$carlight$ExtLightSensorErrorDetectionState = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState")) : class$org$dsi$ifc$carlight$ExtLightSensorErrorDetectionState, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightStatus == null ? (class$org$dsi$ifc$carlight$ExtLightStatus = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightStatus")) : class$org$dsi$ifc$carlight$ExtLightStatus, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$ExtLightViewOptions == null ? (class$org$dsi$ifc$carlight$ExtLightViewOptions = DSICarLightTracer.class$("org.dsi.ifc.carlight.ExtLightViewOptions")) : class$org$dsi$ifc$carlight$ExtLightViewOptions, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightBrightness == null ? (class$org$dsi$ifc$carlight$IntLightBrightness = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightBrightness")) : class$org$dsi$ifc$carlight$IntLightBrightness, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightConfig == null ? (class$org$dsi$ifc$carlight$IntLightConfig = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightConfig")) : class$org$dsi$ifc$carlight$IntLightConfig, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightMembersIlluminationSet == null ? (class$org$dsi$ifc$carlight$IntLightMembersIlluminationSet = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightMembersIlluminationSet")) : class$org$dsi$ifc$carlight$IntLightMembersIlluminationSet, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightMembersMultiColor == null ? (class$org$dsi$ifc$carlight$IntLightMembersMultiColor = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightMembersMultiColor")) : class$org$dsi$ifc$carlight$IntLightMembersMultiColor, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightRGBColorListRA0 == null ? (class$org$dsi$ifc$carlight$IntLightRGBColorListRA0 = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightRGBColorListRA0")) : class$org$dsi$ifc$carlight$IntLightRGBColorListRA0, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo == null ? (class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo")) : class$org$dsi$ifc$carlight$IntLightRGBColorListUpdateInfo, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightRGBValues == null ? (class$org$dsi$ifc$carlight$IntLightRGBValues = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightRGBValues")) : class$org$dsi$ifc$carlight$IntLightRGBValues, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightSetupColors == null ? (class$org$dsi$ifc$carlight$IntLightSetupColors = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightSetupColors")) : class$org$dsi$ifc$carlight$IntLightSetupColors, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightTransmittableElements == null ? (class$org$dsi$ifc$carlight$IntLightTransmittableElements = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightTransmittableElements")) : class$org$dsi$ifc$carlight$IntLightTransmittableElements, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$IntLightViewOptions == null ? (class$org$dsi$ifc$carlight$IntLightViewOptions = DSICarLightTracer.class$("org.dsi.ifc.carlight.IntLightViewOptions")) : class$org$dsi$ifc$carlight$IntLightViewOptions, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$MotorwayBlinkingSettings == null ? (class$org$dsi$ifc$carlight$MotorwayBlinkingSettings = DSICarLightTracer.class$("org.dsi.ifc.carlight.MotorwayBlinkingSettings")) : class$org$dsi$ifc$carlight$MotorwayBlinkingSettings, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlight$TimeState == null ? (class$org$dsi$ifc$carlight$TimeState = DSICarLightTracer.class$("org.dsi.ifc.carlight.TimeState")) : class$org$dsi$ifc$carlight$TimeState, 18);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceExtLightConfig(printWriter, (ExtLightConfig)object);
                break;
            }
            case 2: {
                this.traceExtLightLampErrorDetectionState(printWriter, (ExtLightLampErrorDetectionState)object);
                break;
            }
            case 3: {
                this.traceExtLightLampErrorDetectionStateTrailer(printWriter, (ExtLightLampErrorDetectionStateTrailer)object);
                break;
            }
            case 4: {
                this.traceExtLightSensorErrorDetectionState(printWriter, (ExtLightSensorErrorDetectionState)object);
                break;
            }
            case 5: {
                this.traceExtLightStatus(printWriter, (ExtLightStatus)object);
                break;
            }
            case 6: {
                this.traceExtLightViewOptions(printWriter, (ExtLightViewOptions)object);
                break;
            }
            case 7: {
                this.traceIntLightBrightness(printWriter, (IntLightBrightness)object);
                break;
            }
            case 8: {
                this.traceIntLightConfig(printWriter, (IntLightConfig)object);
                break;
            }
            case 9: {
                this.traceIntLightMembersIlluminationSet(printWriter, (IntLightMembersIlluminationSet)object);
                break;
            }
            case 10: {
                this.traceIntLightMembersMultiColor(printWriter, (IntLightMembersMultiColor)object);
                break;
            }
            case 11: {
                this.traceIntLightRGBColorListRA0(printWriter, (IntLightRGBColorListRA0)object);
                break;
            }
            case 12: {
                this.traceIntLightRGBColorListUpdateInfo(printWriter, (IntLightRGBColorListUpdateInfo)object);
                break;
            }
            case 13: {
                this.traceIntLightRGBValues(printWriter, (IntLightRGBValues)object);
                break;
            }
            case 14: {
                this.traceIntLightSetupColors(printWriter, (IntLightSetupColors)object);
                break;
            }
            case 15: {
                this.traceIntLightTransmittableElements(printWriter, (IntLightTransmittableElements)object);
                break;
            }
            case 16: {
                this.traceIntLightViewOptions(printWriter, (IntLightViewOptions)object);
                break;
            }
            case 17: {
                this.traceMotorwayBlinkingSettings(printWriter, (MotorwayBlinkingSettings)object);
                break;
            }
            case 18: {
                this.traceTimeState(printWriter, (TimeState)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceExtLightConfig(PrintWriter printWriter, ExtLightConfig extLightConfig) {
        if (extLightConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extLightConfig.leftHandTraffic);
        printWriter.print(extLightConfig.rainDependency);
        printWriter.print(extLightConfig.speedDependency);
    }

    private void traceExtLightLampErrorDetectionState(PrintWriter printWriter, ExtLightLampErrorDetectionState extLightLampErrorDetectionState) {
        if (extLightLampErrorDetectionState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extLightLampErrorDetectionState.lamp);
        printWriter.print(extLightLampErrorDetectionState.state);
    }

    private void traceExtLightLampErrorDetectionStateTrailer(PrintWriter printWriter, ExtLightLampErrorDetectionStateTrailer extLightLampErrorDetectionStateTrailer) {
        if (extLightLampErrorDetectionStateTrailer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extLightLampErrorDetectionStateTrailer.lamp);
        printWriter.print(extLightLampErrorDetectionStateTrailer.state);
    }

    private void traceExtLightSensorErrorDetectionState(PrintWriter printWriter, ExtLightSensorErrorDetectionState extLightSensorErrorDetectionState) {
        if (extLightSensorErrorDetectionState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extLightSensorErrorDetectionState.sensor);
        printWriter.print(extLightSensorErrorDetectionState.state);
    }

    private void traceExtLightStatus(PrintWriter printWriter, ExtLightStatus extLightStatus) {
        if (extLightStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extLightStatus.headlight);
        printWriter.print(extLightStatus.parklightLeft);
        printWriter.print(extLightStatus.parklightRight);
    }

    private void traceExtLightViewOptions(PrintWriter printWriter, ExtLightViewOptions extLightViewOptions) {
        if (extLightViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, extLightViewOptions.comingHome);
        this.trace(printWriter, extLightViewOptions.leavingHome);
        this.trace(printWriter, extLightViewOptions.switchOnSensitivity);
        this.trace(printWriter, extLightViewOptions.dayLight);
        this.trace(printWriter, extLightViewOptions.touristLight);
        this.trace(printWriter, extLightViewOptions.motorwayBlinking);
        this.trace(printWriter, extLightViewOptions.adaptiveLightSystem);
        this.trace(printWriter, extLightViewOptions.headlightSystem);
        this.trace(printWriter, extLightViewOptions.glidingLightSystem);
        this.trace(printWriter, extLightViewOptions.maskedHighBeam);
        this.trace(printWriter, extLightViewOptions.extLightConfig);
        this.trace(printWriter, extLightViewOptions.automaticLight);
        this.trace(printWriter, extLightViewOptions.extLightSetFactoryDefault);
        this.trace(printWriter, extLightViewOptions.laserLight);
        this.trace(printWriter, extLightViewOptions.signatureLight);
        this.trace(printWriter, extLightViewOptions.headlightRange);
    }

    private void traceIntLightBrightness(PrintWriter printWriter, IntLightBrightness intLightBrightness) {
        if (intLightBrightness == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightBrightness.brightness);
        printWriter.print(intLightBrightness.state);
    }

    private void traceIntLightConfig(PrintWriter printWriter, IntLightConfig intLightConfig) {
        if (intLightConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightConfig.ambienceStateAutoAvailable);
        printWriter.print(intLightConfig.ambienceStatePrivacyAvailable);
        printWriter.print(intLightConfig.setupIlluminationSet1);
        printWriter.print(intLightConfig.setupIlluminationSet2);
        printWriter.print(intLightConfig.setupIlluminationSet3);
        printWriter.print(intLightConfig.setupIlluminationSet4);
        printWriter.print(intLightConfig.setupIlluminationSet5);
        printWriter.print(intLightConfig.setupIlluminationSet6);
        printWriter.print(intLightConfig.setupIlluminationSet7);
        printWriter.print(intLightConfig.setupIlluminationSet8);
        this.trace(printWriter, intLightConfig.membersIlluminationSet1);
        this.trace(printWriter, intLightConfig.membersIlluminationSet2);
        this.trace(printWriter, intLightConfig.membersIlluminationSet3);
        this.trace(printWriter, intLightConfig.membersIlluminationSet4);
        this.trace(printWriter, intLightConfig.membersIlluminationSet5);
        this.trace(printWriter, intLightConfig.membersIlluminationSet6);
        this.trace(printWriter, intLightConfig.membersIlluminationSet7);
        this.trace(printWriter, intLightConfig.membersIlluminationSet8);
        printWriter.print(intLightConfig.setupIlluminationProfile1);
        printWriter.print(intLightConfig.setupIlluminationProfile2);
        printWriter.print(intLightConfig.setupIlluminationProfile3);
        printWriter.print(intLightConfig.setupIlluminationProfile4);
        printWriter.print(intLightConfig.setupIlluminationProfile5);
        printWriter.print(intLightConfig.setupIlluminationProfile6);
        printWriter.print(intLightConfig.setupIlluminationProfile7);
        printWriter.print(intLightConfig.setupIlluminationProfile8);
        this.trace(printWriter, intLightConfig.rgbColorListTransmittableElements);
        this.trace(printWriter, intLightConfig.membersMultiColor);
        this.trace(printWriter, intLightConfig.setupColors);
    }

    private void traceIntLightMembersIlluminationSet(PrintWriter printWriter, IntLightMembersIlluminationSet intLightMembersIlluminationSet) {
        if (intLightMembersIlluminationSet == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightMembersIlluminationSet.frontRoofLighting);
        printWriter.print(intLightMembersIlluminationSet.rearRoofLighting);
        printWriter.print(intLightMembersIlluminationSet.frontFootwellLighting);
        printWriter.print(intLightMembersIlluminationSet.rearFootwellLighting);
        printWriter.print(intLightMembersIlluminationSet.frontDoorsLighting);
        printWriter.print(intLightMembersIlluminationSet.rearDoorsLighting);
        printWriter.print(intLightMembersIlluminationSet.frontDoorsWarningLighting);
        printWriter.print(intLightMembersIlluminationSet.rearDoorsWarningLighting);
        printWriter.print(intLightMembersIlluminationSet.frontDoorsEntranceLighting);
        printWriter.print(intLightMembersIlluminationSet.rearDoorsEntranceLighting);
        printWriter.print(intLightMembersIlluminationSet.frontDoorsStripLighting);
        printWriter.print(intLightMembersIlluminationSet.rearDoorsStripLighting);
        printWriter.print(intLightMembersIlluminationSet.cockpitStripLighting);
        printWriter.print(intLightMembersIlluminationSet.cupholderStripLighting);
        printWriter.print(intLightMembersIlluminationSet.premiumSoundLighting);
        printWriter.print(intLightMembersIlluminationSet.sunRoofStripLighting);
        printWriter.print(intLightMembersIlluminationSet.frontSliderLighting);
        printWriter.print(intLightMembersIlluminationSet.navigationDeviceStripLighting);
        printWriter.print(intLightMembersIlluminationSet.frontClimateControlStripLighting);
        printWriter.print(intLightMembersIlluminationSet.gearShiftLighting);
        printWriter.print(intLightMembersIlluminationSet.centerControlLighting);
        printWriter.print(intLightMembersIlluminationSet.frontDoorPocketLighting);
        printWriter.print(intLightMembersIlluminationSet.rearDoorPocketLighting);
    }

    private void traceIntLightMembersMultiColor(PrintWriter printWriter, IntLightMembersMultiColor intLightMembersMultiColor) {
        if (intLightMembersMultiColor == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightMembersMultiColor.frontRoofLighting);
        printWriter.print(intLightMembersMultiColor.rearRoofLighting);
        printWriter.print(intLightMembersMultiColor.frontFootwellLighting);
        printWriter.print(intLightMembersMultiColor.rearFootwellLighting);
        printWriter.print(intLightMembersMultiColor.frontDoorsLighting);
        printWriter.print(intLightMembersMultiColor.rearDoorsLighting);
        printWriter.print(intLightMembersMultiColor.frontDoorsWarningLighting);
        printWriter.print(intLightMembersMultiColor.rearDoorsWarningLighting);
        printWriter.print(intLightMembersMultiColor.frontDoorsEntranceLighting);
        printWriter.print(intLightMembersMultiColor.rearDoorsEntranceLighting);
        printWriter.print(intLightMembersMultiColor.frontDoorsStripLighting);
        printWriter.print(intLightMembersMultiColor.rearDoorsStripLighting);
        printWriter.print(intLightMembersMultiColor.cockpitStripLighting);
        printWriter.print(intLightMembersMultiColor.cupholderStripLighting);
        printWriter.print(intLightMembersMultiColor.premiumSoundLighting);
        printWriter.print(intLightMembersMultiColor.sunRoofStripLighting);
        printWriter.print(intLightMembersMultiColor.frontSliderLighting);
        printWriter.print(intLightMembersMultiColor.navigationDeviceStripLighting);
        printWriter.print(intLightMembersMultiColor.frontClimateControlStripLighting);
        printWriter.print(intLightMembersMultiColor.gearShiftLighting);
        printWriter.print(intLightMembersMultiColor.centerControlLighting);
        printWriter.print(intLightMembersMultiColor.frontDoorPocketLighting);
        printWriter.print(intLightMembersMultiColor.rearDoorPocketLighting);
    }

    private void traceIntLightRGBColorListRA0(PrintWriter printWriter, IntLightRGBColorListRA0 intLightRGBColorListRA0) {
        if (intLightRGBColorListRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightRGBColorListRA0.pos);
        this.trace(printWriter, intLightRGBColorListRA0.values);
    }

    private void traceIntLightRGBColorListUpdateInfo(PrintWriter printWriter, IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        if (intLightRGBColorListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightRGBColorListUpdateInfo.arrayContent);
        printWriter.print(intLightRGBColorListUpdateInfo.recordContent);
        printWriter.print(intLightRGBColorListUpdateInfo.startElement);
        printWriter.print(intLightRGBColorListUpdateInfo.numOfElements);
        printWriter.print(intLightRGBColorListUpdateInfo.transactionID);
    }

    private void traceIntLightRGBValues(PrintWriter printWriter, IntLightRGBValues intLightRGBValues) {
        if (intLightRGBValues == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightRGBValues.baseColorRed);
        printWriter.print(intLightRGBValues.baseColorGreen);
        printWriter.print(intLightRGBValues.baseColorBlue);
    }

    private void traceIntLightSetupColors(PrintWriter printWriter, IntLightSetupColors intLightSetupColors) {
        if (intLightSetupColors == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightSetupColors.warmWhite);
        printWriter.print(intLightSetupColors.coldWhite);
        printWriter.print(intLightSetupColors.redWhite);
        printWriter.print(intLightSetupColors.orange);
        printWriter.print(intLightSetupColors.blue);
        printWriter.print(intLightSetupColors.cyan);
    }

    private void traceIntLightTransmittableElements(PrintWriter printWriter, IntLightTransmittableElements intLightTransmittableElements) {
        if (intLightTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(intLightTransmittableElements.ra0);
        printWriter.print(intLightTransmittableElements.raF);
    }

    private void traceIntLightViewOptions(PrintWriter printWriter, IntLightViewOptions intLightViewOptions) {
        if (intLightViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, intLightViewOptions.intLightState);
        this.trace(printWriter, intLightViewOptions.intLightColour);
        this.trace(printWriter, intLightViewOptions.intLightEnvironment);
        this.trace(printWriter, intLightViewOptions.intLightTemperature);
        this.trace(printWriter, intLightViewOptions.intLightSpeed);
        this.trace(printWriter, intLightViewOptions.intLightBrightness);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet1);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet2);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet3);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet4);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet5);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet6);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet7);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationSet8);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile1);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile2);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile3);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile4);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile5);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile6);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile7);
        this.trace(printWriter, intLightViewOptions.intLightIlluminationProfile8);
        this.trace(printWriter, intLightViewOptions.intLightActiveProfile);
        this.trace(printWriter, intLightViewOptions.intLightAmbientLightColor);
        this.trace(printWriter, intLightViewOptions.intLightContourLightColor);
        this.trace(printWriter, intLightViewOptions.intLightRGBColorList);
        this.trace(printWriter, intLightViewOptions.intLightFollowUpTime);
        this.trace(printWriter, intLightViewOptions.intLightSetFactoryDefault);
        this.trace(printWriter, intLightViewOptions.intLightConfig);
        this.trace(printWriter, intLightViewOptions.intLightDoorContact);
    }

    private void traceMotorwayBlinkingSettings(PrintWriter printWriter, MotorwayBlinkingSettings motorwayBlinkingSettings) {
        if (motorwayBlinkingSettings == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(motorwayBlinkingSettings.time);
        printWriter.print(motorwayBlinkingSettings.state);
    }

    private void traceTimeState(PrintWriter printWriter, TimeState timeState) {
        if (timeState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(timeState.time);
        printWriter.print(timeState.state);
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

