/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.predictivenavigation;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;

public class LikelyDestination {
    public int calculationState;
    public int calculationProgress;
    public int likelihood;
    public long distance;
    public long remainingTravelTime;
    public long timeDelay;
    public int routeColor;
    public int routeColorIconId;
    public NavLocation destination;
    public NavSegmentID segmentId;

    public LikelyDestination() {
        this.calculationState = 0;
        this.calculationProgress = 0;
        this.likelihood = 0;
        this.distance = 0L;
        this.remainingTravelTime = 0L;
        this.timeDelay = 0L;
        this.routeColor = 0;
        this.routeColorIconId = 123;
        this.destination = null;
        this.segmentId = null;
    }

    public LikelyDestination(int n, int n2, int n3, long l, long l2, long l3, int n4, int n5, NavLocation navLocation, NavSegmentID navSegmentID) {
        this.calculationState = n;
        this.calculationProgress = n2;
        this.likelihood = n3;
        this.distance = l;
        this.remainingTravelTime = l2;
        this.timeDelay = l3;
        this.routeColor = n4;
        this.routeColorIconId = n5;
        this.destination = navLocation;
        this.segmentId = navSegmentID;
    }

    public int getCalculationState() {
        return this.calculationState;
    }

    public int getCalculationProgress() {
        return this.calculationProgress;
    }

    public int getLikelihood() {
        return this.likelihood;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getRemainingTravelTime() {
        return this.remainingTravelTime;
    }

    public long getTimeDelay() {
        return this.timeDelay;
    }

    public int getRouteColor() {
        return this.routeColor;
    }

    public int getRouteColorIconId() {
        return this.routeColorIconId;
    }

    public NavLocation getDestination() {
        return this.destination;
    }

    public NavSegmentID getSegmentId() {
        return this.segmentId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2600);
        stringBuffer.append("LikelyDestination");
        stringBuffer.append('(');
        stringBuffer.append("calculationState");
        stringBuffer.append('=');
        stringBuffer.append(this.calculationState);
        stringBuffer.append(',');
        stringBuffer.append("calculationProgress");
        stringBuffer.append('=');
        stringBuffer.append(this.calculationProgress);
        stringBuffer.append(',');
        stringBuffer.append("likelihood");
        stringBuffer.append('=');
        stringBuffer.append(this.likelihood);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("remainingTravelTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTravelTime);
        stringBuffer.append(',');
        stringBuffer.append("timeDelay");
        stringBuffer.append('=');
        stringBuffer.append(this.timeDelay);
        stringBuffer.append(',');
        stringBuffer.append("routeColor");
        stringBuffer.append('=');
        stringBuffer.append(this.routeColor);
        stringBuffer.append(',');
        stringBuffer.append("routeColorIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.routeColorIconId);
        stringBuffer.append(',');
        stringBuffer.append("destination");
        stringBuffer.append('=');
        stringBuffer.append(this.destination);
        stringBuffer.append(',');
        stringBuffer.append("segmentId");
        stringBuffer.append('=');
        stringBuffer.append(this.segmentId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

