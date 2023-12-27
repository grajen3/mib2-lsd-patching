/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficSignInformationOnRoute {
    public TrafficSignInformation info;
    public long distance;
    public long remainingTime;

    public TrafficSignInformationOnRoute() {
        this.info = null;
        this.distance = 0L;
        this.remainingTime = 0L;
    }

    public TrafficSignInformationOnRoute(TrafficSignInformation trafficSignInformation, long l, long l2) {
        this.info = trafficSignInformation;
        this.distance = l;
        this.remainingTime = l2;
    }

    public TrafficSignInformation getInfo() {
        return this.info;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("TrafficSignInformationOnRoute");
        stringBuffer.append('(');
        stringBuffer.append("info");
        stringBuffer.append('=');
        stringBuffer.append(this.info);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("remainingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

