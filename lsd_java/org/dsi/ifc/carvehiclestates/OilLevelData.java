/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;

public class OilLevelData {
    public int level;
    public OilLevelRefillVolume refillVolume;
    public int warnings;
    public boolean oilsystem;
    public boolean bargraph;

    public OilLevelData() {
        this.level = 0;
        this.refillVolume = null;
        this.warnings = 0;
        this.oilsystem = false;
        this.bargraph = false;
    }

    public OilLevelData(int n, OilLevelRefillVolume oilLevelRefillVolume, int n2, boolean bl, boolean bl2) {
        this.level = n;
        this.refillVolume = oilLevelRefillVolume;
        this.warnings = n2;
        this.oilsystem = bl;
        this.bargraph = bl2;
    }

    public int getLevel() {
        return this.level;
    }

    public OilLevelRefillVolume getRefillVolume() {
        return this.refillVolume;
    }

    public int getWarnings() {
        return this.warnings;
    }

    public boolean isOilsystem() {
        return this.oilsystem;
    }

    public boolean isBargraph() {
        return this.bargraph;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("OilLevelData");
        stringBuffer.append('(');
        stringBuffer.append("level");
        stringBuffer.append('=');
        stringBuffer.append(this.level);
        stringBuffer.append(',');
        stringBuffer.append("refillVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.refillVolume);
        stringBuffer.append(',');
        stringBuffer.append("warnings");
        stringBuffer.append('=');
        stringBuffer.append(this.warnings);
        stringBuffer.append(',');
        stringBuffer.append("oilsystem");
        stringBuffer.append('=');
        stringBuffer.append(this.oilsystem);
        stringBuffer.append(',');
        stringBuffer.append("bargraph");
        stringBuffer.append('=');
        stringBuffer.append(this.bargraph);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

