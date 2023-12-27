/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

public class SpeedAndFlowSegment {
    public int id;
    public int severity;
    public long distance;
    public int destinationIndex;

    public SpeedAndFlowSegment() {
        this.id = 0;
        this.severity = 0;
        this.distance = 0L;
        this.destinationIndex = 0;
    }

    public SpeedAndFlowSegment(int n, int n2, long l, int n3) {
        this.id = n;
        this.severity = n2;
        this.distance = l;
        this.destinationIndex = n3;
    }

    public int getId() {
        return this.id;
    }

    public int getSeverity() {
        return this.severity;
    }

    public long getDistance() {
        return this.distance;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SpeedAndFlowSegment");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("severity");
        stringBuffer.append('=');
        stringBuffer.append(this.severity);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

