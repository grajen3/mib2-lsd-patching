/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class NavPosition {
    public float lat;
    public float lon;

    public NavPosition(float f2, float f3) {
        this.lat = f2;
        this.lon = f3;
    }

    public NavPosition() {
        this.lat = 0.0f;
        this.lon = 0.0f;
    }

    public float getLat() {
        return this.lat;
    }

    public float getLon() {
        return this.lon;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("NavPosition");
        stringBuffer.append('(');
        stringBuffer.append("lat");
        stringBuffer.append('=');
        stringBuffer.append(this.lat);
        stringBuffer.append(',');
        stringBuffer.append("lon");
        stringBuffer.append('=');
        stringBuffer.append(this.lon);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

