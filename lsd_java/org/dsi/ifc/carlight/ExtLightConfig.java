/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class ExtLightConfig {
    public boolean leftHandTraffic;
    public boolean rainDependency;
    public boolean speedDependency;

    public ExtLightConfig() {
        this.leftHandTraffic = false;
        this.rainDependency = false;
        this.speedDependency = false;
    }

    public ExtLightConfig(boolean bl, boolean bl2, boolean bl3) {
        this.leftHandTraffic = bl;
        this.rainDependency = bl2;
        this.speedDependency = bl3;
    }

    public boolean isLeftHandTraffic() {
        return this.leftHandTraffic;
    }

    public boolean isRainDependency() {
        return this.rainDependency;
    }

    public boolean isSpeedDependency() {
        return this.speedDependency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ExtLightConfig");
        stringBuffer.append('(');
        stringBuffer.append("leftHandTraffic");
        stringBuffer.append('=');
        stringBuffer.append(this.leftHandTraffic);
        stringBuffer.append(',');
        stringBuffer.append("rainDependency");
        stringBuffer.append('=');
        stringBuffer.append(this.rainDependency);
        stringBuffer.append(',');
        stringBuffer.append("speedDependency");
        stringBuffer.append('=');
        stringBuffer.append(this.speedDependency);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

