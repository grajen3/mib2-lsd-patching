/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class NavLocationWgs84 {
    public int longitude;
    public int latitude;

    public NavLocationWgs84() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public NavLocationWgs84(int n, int n2) {
        this.longitude = n;
        this.latitude = n2;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NavLocationWgs84 {");
        stringBuffer.append("longitude=");
        stringBuffer.append(this.longitude);
        stringBuffer.append(", ");
        stringBuffer.append("latitude=");
        stringBuffer.append(this.latitude);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

