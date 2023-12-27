/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PortalLocation {
    public int longitude;
    public int latitude;
    public String unstructured;

    public PortalLocation() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public PortalLocation(int n, int n2, String string) {
        this.longitude = n;
        this.latitude = n2;
        this.unstructured = string;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int n) {
        this.longitude = n;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int n) {
        this.latitude = n;
    }

    public String getUnstructured() {
        return this.unstructured;
    }

    public void setUnstructured(String string) {
        this.unstructured = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PortalLocation");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("unstructured");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.unstructured);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

