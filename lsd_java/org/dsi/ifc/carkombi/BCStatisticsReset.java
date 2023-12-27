/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCStatisticsReset {
    public boolean time;
    public boolean distance;

    public BCStatisticsReset() {
        this.time = false;
        this.distance = false;
    }

    public BCStatisticsReset(boolean bl, boolean bl2) {
        this.time = bl;
        this.distance = bl2;
    }

    public boolean isTime() {
        return this.time;
    }

    public boolean isDistance() {
        return this.distance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BCStatisticsReset");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

