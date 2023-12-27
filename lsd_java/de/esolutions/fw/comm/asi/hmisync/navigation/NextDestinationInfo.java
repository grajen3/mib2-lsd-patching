/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

public class NextDestinationInfo {
    public int destinationIndex;
    public double distanceToNextDestination;
    public double timeToNextDestiantion;

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public void setDestinationIndex(int n) {
        this.destinationIndex = n;
    }

    public double getDistanceToNextDestination() {
        return this.distanceToNextDestination;
    }

    public void setDistanceToNextDestination(double d2) {
        this.distanceToNextDestination = d2;
    }

    public double getTimeToNextDestiantion() {
        return this.timeToNextDestiantion;
    }

    public void setTimeToNextDestiantion(double d2) {
        this.timeToNextDestiantion = d2;
    }

    public NextDestinationInfo() {
    }

    public NextDestinationInfo(int n, double d2, double d3) {
        this.destinationIndex = n;
        this.distanceToNextDestination = d2;
        this.timeToNextDestiantion = d3;
    }

    public String toString() {
        return new StringBuffer("NextDestinationInfo{").append("destinationIndex=").append(this.destinationIndex).append(", distanceToNextDestination=").append(this.distanceToNextDestination).append(", timeToNextDestiantion=").append(this.timeToNextDestiantion).append("}").toString();
    }
}

