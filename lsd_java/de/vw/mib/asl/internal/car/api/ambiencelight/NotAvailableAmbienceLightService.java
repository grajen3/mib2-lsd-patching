/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.ambiencelight;

import de.vw.mib.asl.api.car.ambiencelight.AmbienceColorAreaSettings;
import de.vw.mib.asl.api.car.ambiencelight.AmbienceLightService;
import de.vw.mib.asl.api.car.ambiencelight.RGBColorList;

public class NotAvailableAmbienceLightService
implements AmbienceLightService {
    @Override
    public boolean isAmbianceLightStateOff() {
        return true;
    }

    @Override
    public void setAmbianceLightState(boolean bl) {
    }

    @Override
    public RGBColorList getRGBColorList() {
        return null;
    }

    @Override
    public void setAmbianceLightColor(int n) {
    }

    @Override
    public AmbienceColorAreaSettings getAmbienceColorAreaSettings() {
        return null;
    }

    @Override
    public int[] getBrightnessValues() {
        return null;
    }

    @Override
    public void setAmbienceLightBrightness(int n, int n2) {
    }

    @Override
    public boolean isAmbienceLightPackage1O2Installed() {
        return false;
    }

    @Override
    public void toggleDoorlockingBlindsControl() {
    }

    @Override
    public boolean getDoorlockingBlindsControl() {
        return false;
    }

    @Override
    public void setIntLightBrightness(int n) {
    }

    @Override
    public int getIntLightBrightness() {
        return 0;
    }

    @Override
    public boolean isServiceExisting() {
        return false;
    }

    @Override
    public void setIntLightState(int n) {
    }

    @Override
    public int getIntLightState() {
        return 0;
    }
}

