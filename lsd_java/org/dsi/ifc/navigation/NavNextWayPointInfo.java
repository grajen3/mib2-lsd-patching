/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavNextWayPointInfo {
    public int longitude;
    public int latitude;
    public long distanceToDestination;
    public long timeToDestination;
    public int remainingWaypoints;

    public NavNextWayPointInfo() {
        this.longitude = 0;
        this.latitude = 0;
        this.remainingWaypoints = 0;
    }

    public NavNextWayPointInfo(int n, int n2, long l, long l2, int n3) {
        this.longitude = n;
        this.latitude = n2;
        this.distanceToDestination = l;
        this.timeToDestination = l2;
        this.remainingWaypoints = n3;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public long getDistanceToDestination() {
        return this.distanceToDestination;
    }

    public long getTimeToDestination() {
        return this.timeToDestination;
    }

    public int getRemainingWaypoints() {
        return this.remainingWaypoints;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("NavNextWayPointInfo");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("distanceToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceToDestination);
        stringBuffer.append(',');
        stringBuffer.append("timeToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.timeToDestination);
        stringBuffer.append(',');
        stringBuffer.append("remainingWaypoints");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingWaypoints);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

