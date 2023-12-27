/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

public class GPSInfo {
    public float latitudeDecimalDegrees;
    public float longitudeDecimalDegrees;
    public float altitudeMetersAboveSeaLevel;

    public GPSInfo() {
    }

    public GPSInfo(float f2, float f3, float f4) {
        this.latitudeDecimalDegrees = f2;
        this.longitudeDecimalDegrees = f3;
        this.altitudeMetersAboveSeaLevel = f4;
    }

    public float getLatitudeDecimalDegrees() {
        return this.latitudeDecimalDegrees;
    }

    public float getLongitudeDecimalDegrees() {
        return this.longitudeDecimalDegrees;
    }

    public float getAltitudeMetersAboveSeaLevel() {
        return this.altitudeMetersAboveSeaLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("GPSInfo");
        stringBuffer.append('(');
        stringBuffer.append("latitudeDecimalDegrees");
        stringBuffer.append('=');
        stringBuffer.append(this.latitudeDecimalDegrees);
        stringBuffer.append(',');
        stringBuffer.append("longitudeDecimalDegrees");
        stringBuffer.append('=');
        stringBuffer.append(this.longitudeDecimalDegrees);
        stringBuffer.append(',');
        stringBuffer.append("altitudeMetersAboveSeaLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.altitudeMetersAboveSeaLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

