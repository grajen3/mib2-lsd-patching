/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight;

import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLightC {
    default public void setExtLightComingHome(TimeState timeState) {
    }

    default public void setExtLightLeavingHome(TimeState timeState) {
    }

    default public void setExtLightSwitchOnSensitivity(int n) {
    }

    default public void setExtLightDayLight(boolean bl) {
    }

    default public void setExtLightHeadLightSystem(boolean bl) {
    }

    default public void setExtLightGlidingLightSystem(boolean bl) {
    }

    default public void setExtLightAdaptive(boolean bl) {
    }

    default public void setExtLightTourist(boolean bl) {
    }

    default public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
    }

    default public void setExtLightMaskedHighBeam(boolean bl) {
    }

    default public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
    }

    default public void setExtLightSetFactoryDefault() {
    }

    default public void setExtLightLaserLight(boolean bl) {
    }

    default public void setExtLightSignatureLight(boolean bl) {
    }

    default public void setExtLightHeadlightRange(int n) {
    }

    default public void setIntLightIlluminationSet(int n, int n2) {
    }

    default public void setIntLightColour(int n) {
    }

    default public void setIntLightState(int n) {
    }

    default public void setIntLightEnvironment(boolean bl) {
    }

    default public void setIntLightSpeed(boolean bl) {
    }

    default public void setIntLightTemperature(boolean bl) {
    }

    default public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
    }

    default public void setIntLightSetFactoryDefault() {
    }

    default public void setIntLightIlluminationProfile(int n, int n2) {
    }

    default public void setIntLightActiveProfile(int n) {
    }

    default public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
    }

    default public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
    }

    default public void setIntLightFollowUpTime(int n) {
    }

    default public void setIntLightDoorContact(boolean bl) {
    }

    default public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
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

