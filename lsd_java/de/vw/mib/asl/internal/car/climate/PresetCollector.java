/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

public class PresetCollector {
    public int presetModeAuto;
    public int presetModeMaxAc;
    public int presetModeMaxDefrost;
    public int presetModeManual;

    public PresetCollector(int n, int n2, int n3, int n4) {
        this.presetModeAuto = n;
        this.presetModeMaxAc = n2;
        this.presetModeMaxDefrost = n3;
        this.presetModeManual = n4;
    }

    public PresetCollector(PresetCollector presetCollector) {
        this.presetModeAuto = presetCollector.presetModeAuto;
        this.presetModeMaxAc = presetCollector.presetModeMaxAc;
        this.presetModeMaxDefrost = presetCollector.presetModeMaxDefrost;
        this.presetModeManual = presetCollector.presetModeManual;
    }

    public PresetCollector() {
        this.presetModeAuto = 1;
        this.presetModeMaxAc = 1;
        this.presetModeMaxDefrost = 1;
        this.presetModeManual = 1;
    }

    public int getPresetModeAuto() {
        return this.presetModeAuto;
    }

    public void setPresetModeAuto(int n) {
        this.presetModeAuto = n;
    }

    public int getPresetModeMaxAc() {
        return this.presetModeMaxAc;
    }

    public void setPresetModeMaxAc(int n) {
        this.presetModeMaxAc = n;
    }

    public int getPresetModeMaxDefrost() {
        return this.presetModeMaxDefrost;
    }

    public void setPresetModeMaxDefrost(int n) {
        this.presetModeMaxDefrost = n;
    }

    public int getPresetModeManual() {
        return this.presetModeManual;
    }

    public void setPresetModeManual(int n) {
        this.presetModeManual = n;
    }
}

