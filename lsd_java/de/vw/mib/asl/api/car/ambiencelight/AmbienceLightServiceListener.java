/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.ambiencelight;

import de.vw.mib.asl.api.car.ambiencelight.AmbienceColorAreaSettings;
import de.vw.mib.asl.api.car.ambiencelight.RGBColorList;

public interface AmbienceLightServiceListener {
    default public void updateServiceExisting(boolean bl) {
    }

    default public void updateAmbianceLightStateOff(boolean bl) {
    }

    default public void updateIntLightState(int n) {
    }

    default public void updateRGBColorList(RGBColorList rGBColorList) {
    }

    default public void updateAmbienceColorAreaSettings(AmbienceColorAreaSettings ambienceColorAreaSettings) {
    }

    default public void updateBrightnessValues(int[] nArray) {
    }

    default public void updateBrightnessValue(int n, int n2) {
    }

    default public void updateAmbienceLightPackage1O2Installed(boolean bl) {
    }

    default public void updateDoorlockingBlindsControl(boolean bl) {
    }

    default public void updateIntLightBrightness(int n) {
    }
}

