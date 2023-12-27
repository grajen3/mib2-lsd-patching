/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavRectangle;

public class RouteSectionInfo {
    public long startDistanceToDestination;
    public long length;
    public long startTimeToDestination;
    public NavRectangle boundingRectangle;

    public RouteSectionInfo() {
        this.startDistanceToDestination = 0L;
        this.length = 0L;
        this.startTimeToDestination = 0L;
        this.boundingRectangle = null;
    }

    public RouteSectionInfo(long l, long l2, long l3, NavRectangle navRectangle) {
        this.startDistanceToDestination = l;
        this.length = l2;
        this.startTimeToDestination = l3;
        this.boundingRectangle = navRectangle;
    }

    public long getStartDistanceToDestination() {
        return this.startDistanceToDestination;
    }

    public long getLength() {
        return this.length;
    }

    public long getStartTimeToDestination() {
        return this.startTimeToDestination;
    }

    public NavRectangle getBoundingRectangle() {
        return this.boundingRectangle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1350);
        stringBuffer.append("RouteSectionInfo");
        stringBuffer.append('(');
        stringBuffer.append("startDistanceToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.startDistanceToDestination);
        stringBuffer.append(',');
        stringBuffer.append("length");
        stringBuffer.append('=');
        stringBuffer.append(this.length);
        stringBuffer.append(',');
        stringBuffer.append("startTimeToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.startTimeToDestination);
        stringBuffer.append(',');
        stringBuffer.append("boundingRectangle");
        stringBuffer.append('=');
        stringBuffer.append(this.boundingRectangle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

