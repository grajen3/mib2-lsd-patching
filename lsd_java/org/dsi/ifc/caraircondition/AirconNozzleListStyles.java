/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconNozzleListStyles {
    public boolean interval;
    public boolean focus;
    public boolean diffuse;
    public boolean manual;

    public AirconNozzleListStyles() {
        this.interval = false;
        this.focus = false;
        this.diffuse = false;
        this.manual = false;
    }

    public AirconNozzleListStyles(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.interval = bl;
        this.focus = bl2;
        this.diffuse = bl3;
        this.manual = bl4;
    }

    public boolean isInterval() {
        return this.interval;
    }

    public boolean isFocus() {
        return this.focus;
    }

    public boolean isDiffuse() {
        return this.diffuse;
    }

    public boolean isManual() {
        return this.manual;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AirconNozzleListStyles");
        stringBuffer.append('(');
        stringBuffer.append("interval");
        stringBuffer.append('=');
        stringBuffer.append(this.interval);
        stringBuffer.append(',');
        stringBuffer.append("focus");
        stringBuffer.append('=');
        stringBuffer.append(this.focus);
        stringBuffer.append(',');
        stringBuffer.append("diffuse");
        stringBuffer.append('=');
        stringBuffer.append(this.diffuse);
        stringBuffer.append(',');
        stringBuffer.append("manual");
        stringBuffer.append('=');
        stringBuffer.append(this.manual);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

