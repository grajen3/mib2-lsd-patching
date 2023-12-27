/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RgInfoForNextDestination {
    public long airDistanceToNextDest;
    public long distanceToNextDest;
    public long timeToNextDest;
    public int timeLagToNextDest;
    public short directionToNextDest;
    public int timeToNextDestStatus;
    public int destinationIndex;

    public RgInfoForNextDestination() {
        this.airDistanceToNextDest = 0L;
        this.distanceToNextDest = 0L;
        this.timeToNextDest = 0L;
        this.timeLagToNextDest = 0;
        this.directionToNextDest = 0;
        this.destinationIndex = 0;
    }

    public RgInfoForNextDestination(long l, long l2, long l3, int n, short s, int n2, int n3) {
        this.airDistanceToNextDest = l;
        this.distanceToNextDest = l2;
        this.timeToNextDest = l3;
        this.timeLagToNextDest = n;
        this.directionToNextDest = s;
        this.timeToNextDestStatus = n2;
        this.destinationIndex = n3;
    }

    public long getAirDistanceToNextDest() {
        return this.airDistanceToNextDest;
    }

    public long getDistanceToNextDest() {
        return this.distanceToNextDest;
    }

    public long getTimeToNextDest() {
        return this.timeToNextDest;
    }

    public int getTimeLagToNextDest() {
        return this.timeLagToNextDest;
    }

    public short getDirectionToNextDest() {
        return this.directionToNextDest;
    }

    public int getTimeToNextDestStatus() {
        return this.timeToNextDestStatus;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("RgInfoForNextDestination");
        stringBuffer.append('(');
        stringBuffer.append("airDistanceToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.airDistanceToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("distanceToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("timeToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.timeToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("timeLagToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.timeLagToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("directionToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.directionToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("timeToNextDestStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.timeToNextDestStatus);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

