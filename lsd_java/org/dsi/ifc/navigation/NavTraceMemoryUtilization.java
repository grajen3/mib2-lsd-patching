/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavTraceMemoryUtilization {
    public long firstTrackpoint;
    public long numberOfTrackpoints;
    public short utilization;
    public int recordingDistance;
    public int remainingDistance;
    public int remainingTime;
    public long totalNumberOfTrackPoints;
    public long maximumNumberOfTrackPoints;

    public NavTraceMemoryUtilization() {
        this.firstTrackpoint = 0L;
        this.numberOfTrackpoints = 0L;
        this.utilization = 0;
        this.recordingDistance = 0;
        this.remainingDistance = 0;
        this.remainingTime = 0;
        this.totalNumberOfTrackPoints = 0L;
        this.maximumNumberOfTrackPoints = 0L;
    }

    public NavTraceMemoryUtilization(long l, long l2, short s, int n, int n2, int n3, long l3, long l4) {
        this.firstTrackpoint = l;
        this.numberOfTrackpoints = l2;
        this.utilization = s;
        this.recordingDistance = n;
        this.remainingDistance = n2;
        this.remainingTime = n3;
        this.totalNumberOfTrackPoints = l3;
        this.maximumNumberOfTrackPoints = l4;
    }

    public long getFirstTrackpoint() {
        return this.firstTrackpoint;
    }

    public long getNumberOfTrackpoints() {
        return this.numberOfTrackpoints;
    }

    public short getUtilization() {
        return this.utilization;
    }

    public int getRecordingDistance() {
        return this.recordingDistance;
    }

    public int getRemainingDistance() {
        return this.remainingDistance;
    }

    public int getRemainingTime() {
        return this.remainingTime;
    }

    public long getTotalNumberOfTrackPoints() {
        return this.totalNumberOfTrackPoints;
    }

    public long getMaximumNumberOfTrackPoints() {
        return this.maximumNumberOfTrackPoints;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("NavTraceMemoryUtilization");
        stringBuffer.append('(');
        stringBuffer.append("firstTrackpoint");
        stringBuffer.append('=');
        stringBuffer.append(this.firstTrackpoint);
        stringBuffer.append(',');
        stringBuffer.append("numberOfTrackpoints");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfTrackpoints);
        stringBuffer.append(',');
        stringBuffer.append("utilization");
        stringBuffer.append('=');
        stringBuffer.append(this.utilization);
        stringBuffer.append(',');
        stringBuffer.append("recordingDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.recordingDistance);
        stringBuffer.append(',');
        stringBuffer.append("remainingDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingDistance);
        stringBuffer.append(',');
        stringBuffer.append("remainingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTime);
        stringBuffer.append(',');
        stringBuffer.append("totalNumberOfTrackPoints");
        stringBuffer.append('=');
        stringBuffer.append(this.totalNumberOfTrackPoints);
        stringBuffer.append(',');
        stringBuffer.append("maximumNumberOfTrackPoints");
        stringBuffer.append('=');
        stringBuffer.append(this.maximumNumberOfTrackPoints);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

