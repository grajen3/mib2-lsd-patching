/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;

public class OilLevelData {
    public int level;
    public IntBaseType refillVolume;
    public int warnings;
    public boolean oilsystem;
    public boolean bargraph;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int n) {
        this.level = n;
    }

    public IntBaseType getRefillVolume() {
        return this.refillVolume;
    }

    public void setRefillVolume(IntBaseType intBaseType) {
        this.refillVolume = intBaseType;
    }

    public int getWarnings() {
        return this.warnings;
    }

    public void setWarnings(int n) {
        this.warnings = n;
    }

    public boolean isOilsystem() {
        return this.oilsystem;
    }

    public void setOilsystem(boolean bl) {
        this.oilsystem = bl;
    }

    public boolean isBargraph() {
        return this.bargraph;
    }

    public void setBargraph(boolean bl) {
        this.bargraph = bl;
    }

    public OilLevelData() {
        this.refillVolume = null;
    }

    public OilLevelData(int n, IntBaseType intBaseType, int n2, boolean bl, boolean bl2) {
        this.level = n;
        this.refillVolume = intBaseType;
        this.warnings = n2;
        this.oilsystem = bl;
        this.bargraph = bl2;
    }

    public String toString() {
        return new StringBuffer("OilLevelData{").append("level=").append(this.level).append(", refillVolume=").append(this.refillVolume).append(", warnings=").append(this.warnings).append(", oilsystem=").append(this.oilsystem).append(", bargraph=").append(this.bargraph).append("}").toString();
    }
}

