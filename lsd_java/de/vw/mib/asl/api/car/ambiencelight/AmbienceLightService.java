/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.ambiencelight;

import de.vw.mib.asl.api.car.ambiencelight.AmbienceColorAreaSettings;
import de.vw.mib.asl.api.car.ambiencelight.RGBColorList;

public interface AmbienceLightService {
    public static final int LIGHTSTATE_OFF;
    public static final int LIGHTSTATE_NORMAL;
    public static final int LIGHTSTATE_AUTO;

    default public boolean isServiceExisting() {
    }

    default public boolean isAmbienceLightPackage1O2Installed() {
    }

    default public boolean isAmbianceLightStateOff() {
    }

    default public void setAmbianceLightState(boolean bl) {
    }

    default public void setIntLightState(int n) {
    }

    default public int getIntLightState() {
    }

    default public RGBColorList getRGBColorList() {
    }

    default public void setAmbianceLightColor(int n) {
    }

    default public AmbienceColorAreaSettings getAmbienceColorAreaSettings() {
    }

    default public int[] getBrightnessValues() {
    }

    default public void setAmbienceLightBrightness(int n, int n2) {
    }

    default public void toggleDoorlockingBlindsControl() {
    }

    default public boolean getDoorlockingBlindsControl() {
    }

    default public void setIntLightBrightness(int n) {
    }

    default public int getIntLightBrightness() {
    }
}

