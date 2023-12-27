/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavSegmentID;

public class NavTraceListData {
    public String name;
    public NavSegmentID traceID;
    public int startLongitude;
    public int startLatitude;
    public int endLongitude;
    public int endLatitude;
    public long length;
    public int numberOfTrackPoints;

    public NavTraceListData() {
        this.name = null;
        this.traceID = null;
        this.startLongitude = 0;
        this.startLatitude = 0;
        this.endLongitude = 0;
        this.endLatitude = 0;
        this.length = 0L;
        this.numberOfTrackPoints = 0;
    }

    public NavTraceListData(String string, NavSegmentID navSegmentID, int n, int n2, int n3, int n4, long l, int n5) {
        this.name = string;
        this.traceID = navSegmentID;
        this.startLongitude = n;
        this.startLatitude = n2;
        this.endLongitude = n3;
        this.endLatitude = n4;
        this.length = l;
        this.numberOfTrackPoints = n5;
    }

    public String getName() {
        return this.name;
    }

    public NavSegmentID getTraceID() {
        return this.traceID;
    }

    public int getStartLongitude() {
        return this.startLongitude;
    }

    public int getStartLatitude() {
        return this.startLatitude;
    }

    public int getEndLongitude() {
        return this.endLongitude;
    }

    public int getEndLatitude() {
        return this.endLatitude;
    }

    public long getLength() {
        return this.length;
    }

    public int getNumberOfTrackPoints() {
        return this.numberOfTrackPoints;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("NavTraceListData");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("traceID");
        stringBuffer.append('=');
        stringBuffer.append(this.traceID);
        stringBuffer.append(',');
        stringBuffer.append("startLongitude");
        stringBuffer.append('=');
        stringBuffer.append(this.startLongitude);
        stringBuffer.append(',');
        stringBuffer.append("startLatitude");
        stringBuffer.append('=');
        stringBuffer.append(this.startLatitude);
        stringBuffer.append(',');
        stringBuffer.append("endLongitude");
        stringBuffer.append('=');
        stringBuffer.append(this.endLongitude);
        stringBuffer.append(',');
        stringBuffer.append("endLatitude");
        stringBuffer.append('=');
        stringBuffer.append(this.endLatitude);
        stringBuffer.append(',');
        stringBuffer.append("length");
        stringBuffer.append('=');
        stringBuffer.append(this.length);
        stringBuffer.append(',');
        stringBuffer.append("numberOfTrackPoints");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfTrackPoints);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

