/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.global.NavLocationWgs84;

public class MobilityHorizonLocation {
    public NavLocationWgs84 location;
    public int locationType;

    public MobilityHorizonLocation(NavLocationWgs84 navLocationWgs84, int n) {
        this.location = navLocationWgs84;
        this.locationType = n;
    }

    public MobilityHorizonLocation() {
        this.location = null;
        this.locationType = 0;
    }

    public NavLocationWgs84 getLocation() {
        return this.location;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("MobilityHorizonLocation");
        stringBuffer.append('(');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append(this.location);
        stringBuffer.append(',');
        stringBuffer.append("locationType");
        stringBuffer.append('=');
        stringBuffer.append(this.locationType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

