/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.internal;

import de.vw.mib.physics.GeoAngle;
import de.vw.mib.physics.GeoPosition;
import de.vw.mib.physics.internal.GeoAngleImpl;

class GeoPositionImpl
implements GeoPosition {
    private final GeoAngleImpl latitude = GeoAngleImpl.createLatitude();
    private final GeoAngleImpl longitude = GeoAngleImpl.createLongitude();

    GeoPositionImpl() {
    }

    @Override
    public GeoAngle getLatitude() {
        return this.latitude;
    }

    @Override
    public GeoAngle getLongitude() {
        return this.longitude;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("GeoPosition[");
        stringBuffer.append("lat=[");
        GeoPositionImpl.append(stringBuffer, this.latitude).append(this.latitude.isNegative() ? "S" : "N");
        stringBuffer.append("],lon=[");
        GeoPositionImpl.append(stringBuffer, this.longitude).append(this.longitude.isNegative() ? "W" : "E");
        stringBuffer.append("]]");
        return stringBuffer.toString();
    }

    private static StringBuffer append(StringBuffer stringBuffer, GeoAngle geoAngle) {
        stringBuffer.append("dec=").append(geoAngle.getDecimal());
        stringBuffer.append(",dms=");
        stringBuffer.append(geoAngle.getDegrees()).append("\u00b0");
        stringBuffer.append(geoAngle.getMinutes()).append("'");
        stringBuffer.append(geoAngle.getSeconds()).append("\"");
        return stringBuffer;
    }
}

