/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLightListener
extends DSIListener {
    default public void updateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
    }

    default public void updateIntLightIlluminationSet1(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet2(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet3(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet4(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet5(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet6(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet7(int n, int n2) {
    }

    default public void updateIntLightIlluminationSet8(int n, int n2) {
    }

    default public void updateIntLightTemperature(boolean bl, int n) {
    }

    default public void updateIntLightColour(int n, int n2) {
    }

    default public void updateIntLightState(int n, int n2) {
    }

    default public void updateIntLightEnvironment(boolean bl, int n) {
    }

    default public void updateIntLightSpeed(boolean bl, int n) {
    }

    default public void updateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
    }

    default public void updateIntLightIlluminationProfile1(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile2(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile3(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile4(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile5(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile6(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile7(int n, int n2) {
    }

    default public void updateIntLightIlluminationProfile8(int n, int n2) {
    }

    default public void updateIntLightActiveProfile(int n, int n2) {
    }

    default public void updateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
    }

    default public void updateIntLightContourLightColor(IntLightRGBValues intLightRGBValues, int n) {
    }

    default public void updateIntLightFollowUpTime(int n, int n2) {
    }

    default public void updateIntLightDoorContact(boolean bl, int n) {
    }

    default public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
    }

    default public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
    }

    default public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
    }

    default public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
    }

    default public void updateExtLightComingHome(TimeState timeState, int n) {
    }

    default public void updateExtLightLeavingHome(TimeState timeState, int n) {
    }

    default public void updateExtLightSwitchOnSensitivity(int n, int n2) {
    }

    default public void updateExtLightDaylight(boolean bl, int n) {
    }

    default public void updateExtLightTourist(boolean bl, int n) {
    }

    default public void updateExtLightAdaptive(boolean bl, int n) {
    }

    default public void updateExtLightHeadLightSystem(boolean bl, int n) {
    }

    default public void updateExtLightGlidingSystem(boolean bl, int n) {
    }

    default public void updateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
    }

    default public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
    }

    default public void updateExtLightMaskedHighBeam(boolean bl, int n) {
    }

    default public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray, int n) {
    }

    default public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray, int n) {
    }

    default public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray, int n) {
    }

    default public void updateExtLightAutomaticLight(boolean bl, boolean bl2, int n) {
    }

    default public void acknowledgeIntLightSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeExtLightSetFactoryDefault(boolean bl) {
    }

    default public void updateExtLightLaserLight(boolean bl, int n) {
    }

    default public void updateExtLightSignatureLight(boolean bl, int n) {
    }

    default public void updateExtLightHeadlightRange(int n, int n2) {
    }
}

