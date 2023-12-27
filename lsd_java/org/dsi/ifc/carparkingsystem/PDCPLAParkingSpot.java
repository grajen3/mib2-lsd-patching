/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCPLAParkingSpot {
    public boolean backwardParkboxSlotLeftFound;
    public boolean backwardParkboxSlotRightFound;
    public boolean forwardParkboxSlotLeftFound;
    public boolean forwardParkboxSlotRightFound;
    public boolean backwardParallelToRoadSlotLeftFound;
    public boolean backwardParallelToRoadSlotRightFound;
    public boolean forwardParkboxSlotMiddleFound;

    public PDCPLAParkingSpot() {
        this.backwardParkboxSlotLeftFound = false;
        this.backwardParkboxSlotRightFound = false;
        this.forwardParkboxSlotLeftFound = false;
        this.forwardParkboxSlotRightFound = false;
        this.backwardParallelToRoadSlotLeftFound = false;
        this.backwardParallelToRoadSlotRightFound = false;
        this.forwardParkboxSlotMiddleFound = false;
    }

    public PDCPLAParkingSpot(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.backwardParkboxSlotLeftFound = bl;
        this.backwardParkboxSlotRightFound = bl2;
        this.forwardParkboxSlotLeftFound = bl3;
        this.forwardParkboxSlotRightFound = bl4;
        this.backwardParallelToRoadSlotLeftFound = bl5;
        this.backwardParallelToRoadSlotRightFound = bl6;
        this.forwardParkboxSlotMiddleFound = bl7;
    }

    public boolean isBackwardParkboxSlotLeftFound() {
        return this.backwardParkboxSlotLeftFound;
    }

    public boolean isBackwardParkboxSlotRightFound() {
        return this.backwardParkboxSlotRightFound;
    }

    public boolean isForwardParkboxSlotLeftFound() {
        return this.forwardParkboxSlotLeftFound;
    }

    public boolean isForwardParkboxSlotRightFound() {
        return this.forwardParkboxSlotRightFound;
    }

    public boolean isBackwardParallelToRoadSlotLeftFound() {
        return this.backwardParallelToRoadSlotLeftFound;
    }

    public boolean isBackwardParallelToRoadSlotRightFound() {
        return this.backwardParallelToRoadSlotRightFound;
    }

    public boolean isForwardParkboxSlotMiddleFound() {
        return this.forwardParkboxSlotMiddleFound;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("PDCPLAParkingSpot");
        stringBuffer.append('(');
        stringBuffer.append("backwardParkboxSlotLeftFound");
        stringBuffer.append('=');
        stringBuffer.append(this.backwardParkboxSlotLeftFound);
        stringBuffer.append(',');
        stringBuffer.append("backwardParkboxSlotRightFound");
        stringBuffer.append('=');
        stringBuffer.append(this.backwardParkboxSlotRightFound);
        stringBuffer.append(',');
        stringBuffer.append("forwardParkboxSlotLeftFound");
        stringBuffer.append('=');
        stringBuffer.append(this.forwardParkboxSlotLeftFound);
        stringBuffer.append(',');
        stringBuffer.append("forwardParkboxSlotRightFound");
        stringBuffer.append('=');
        stringBuffer.append(this.forwardParkboxSlotRightFound);
        stringBuffer.append(',');
        stringBuffer.append("backwardParallelToRoadSlotLeftFound");
        stringBuffer.append('=');
        stringBuffer.append(this.backwardParallelToRoadSlotLeftFound);
        stringBuffer.append(',');
        stringBuffer.append("backwardParallelToRoadSlotRightFound");
        stringBuffer.append('=');
        stringBuffer.append(this.backwardParallelToRoadSlotRightFound);
        stringBuffer.append(',');
        stringBuffer.append("forwardParkboxSlotMiddleFound");
        stringBuffer.append('=');
        stringBuffer.append(this.forwardParkboxSlotMiddleFound);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

