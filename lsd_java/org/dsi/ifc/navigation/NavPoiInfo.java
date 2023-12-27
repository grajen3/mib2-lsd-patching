/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class NavPoiInfo {
    public long distance;
    public long remainingTime;
    public NavLocation[] poiLocations;
    public String exitNumber;
    public String signpostInfo;
    public int exitIconId;
    public boolean sideOfStreet;
    public int destinationIndex;
    public int type;
    public NavLocation exitPoiLocation;
    public NavRouteListDataIcon[] poiIcons;

    public NavPoiInfo() {
        this.distance = 0L;
        this.remainingTime = 0L;
        this.poiLocations = null;
        this.exitNumber = null;
        this.signpostInfo = null;
        this.exitIconId = 0;
        this.sideOfStreet = false;
        this.destinationIndex = 0;
        this.type = 0;
        this.exitPoiLocation = null;
        this.poiIcons = null;
    }

    public NavPoiInfo(long l, long l2, NavLocation[] navLocationArray, String string, String string2, int n, boolean bl, int n2, int n3, NavLocation navLocation, NavRouteListDataIcon[] navRouteListDataIconArray) {
        this.distance = l;
        this.remainingTime = l2;
        this.poiLocations = navLocationArray;
        this.exitNumber = string;
        this.signpostInfo = string2;
        this.exitIconId = n;
        this.sideOfStreet = bl;
        this.destinationIndex = n2;
        this.type = n3;
        this.exitPoiLocation = navLocation;
        this.poiIcons = navRouteListDataIconArray;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public NavLocation[] getPoiLocations() {
        return this.poiLocations;
    }

    public String getExitNumber() {
        return this.exitNumber;
    }

    public String getSignpostInfo() {
        return this.signpostInfo;
    }

    public int getExitIconId() {
        return this.exitIconId;
    }

    public boolean isSideOfStreet() {
        return this.sideOfStreet;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public int getType() {
        return this.type;
    }

    public NavLocation getExitPoiLocation() {
        return this.exitPoiLocation;
    }

    public NavRouteListDataIcon[] getPoiIcons() {
        return this.poiIcons;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("NavPoiInfo");
        stringBuffer.append('(');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("remainingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTime);
        stringBuffer.append(',');
        stringBuffer.append("poiLocations");
        stringBuffer.append('[');
        if (this.poiLocations != null) {
            stringBuffer.append(this.poiLocations.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.poiLocations != null) {
            n3 = this.poiLocations.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.poiLocations[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.poiLocations);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("exitNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("signpostInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.signpostInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.exitIconId);
        stringBuffer.append(',');
        stringBuffer.append("sideOfStreet");
        stringBuffer.append('=');
        stringBuffer.append(this.sideOfStreet);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("exitPoiLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.exitPoiLocation);
        stringBuffer.append(',');
        stringBuffer.append("poiIcons");
        stringBuffer.append('[');
        if (this.poiIcons != null) {
            stringBuffer.append(this.poiIcons.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.poiIcons != null) {
            n3 = this.poiIcons.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.poiIcons[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.poiIcons);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

