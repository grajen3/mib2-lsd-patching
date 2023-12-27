/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

public class AmbienceLightAreaCollector {
    private int colorAreaAvailability;
    private boolean colorAreaMode;
    private int brightnessValue;
    private int buttonId;

    public AmbienceLightAreaCollector() {
        this.colorAreaAvailability = 0;
        this.colorAreaMode = false;
        this.brightnessValue = 0;
        this.buttonId = -1;
    }

    public AmbienceLightAreaCollector(int n, boolean bl, int n2, int n3) {
        this.colorAreaAvailability = n;
        this.colorAreaMode = bl;
        this.brightnessValue = n2;
        this.buttonId = n3;
    }

    public void setColorAreaAvailability(int n) {
        this.colorAreaAvailability = n;
    }

    public int getColorAreaAvailability() {
        return this.colorAreaAvailability;
    }

    public void setColorAreaMode(boolean bl) {
        this.colorAreaMode = bl;
    }

    public boolean isColorAreaMode() {
        return this.colorAreaMode;
    }

    public void setButtonId(int n) {
        this.buttonId = n;
    }

    public int getButtonId() {
        return this.buttonId;
    }

    public void setBrightnessValue(int n) {
        this.brightnessValue = n;
    }

    public int getBrightnessValue() {
        return this.brightnessValue;
    }
}

