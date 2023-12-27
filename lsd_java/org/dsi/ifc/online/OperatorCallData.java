/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.global.NavLocationWgs84;

public class OperatorCallData {
    public int heading;
    public int altitude;
    public NavLocationWgs84 position;
    public NavLocationWgs84 destination;
    public int validBitMask;

    public OperatorCallData() {
        this.heading = -1;
        this.altitude = 0;
        this.position = null;
        this.destination = null;
        this.validBitMask = 0;
    }

    public OperatorCallData(int n, int n2, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842, int n3) {
        this.heading = n;
        this.altitude = n2;
        this.position = navLocationWgs84;
        this.destination = navLocationWgs842;
        this.validBitMask = n3;
    }

    public int getHeading() {
        return this.heading;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public NavLocationWgs84 getPosition() {
        return this.position;
    }

    public NavLocationWgs84 getDestination() {
        return this.destination;
    }

    public int getValidBitMask() {
        return this.validBitMask;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("OperatorCallData");
        stringBuffer.append('(');
        stringBuffer.append("heading");
        stringBuffer.append('=');
        stringBuffer.append(this.heading);
        stringBuffer.append(',');
        stringBuffer.append("altitude");
        stringBuffer.append('=');
        stringBuffer.append(this.altitude);
        stringBuffer.append(',');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("destination");
        stringBuffer.append('=');
        stringBuffer.append(this.destination);
        stringBuffer.append(',');
        stringBuffer.append("validBitMask");
        stringBuffer.append('=');
        stringBuffer.append(this.validBitMask);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

