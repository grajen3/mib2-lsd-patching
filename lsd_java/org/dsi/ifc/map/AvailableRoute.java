/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.global.NavSegmentID;

public class AvailableRoute {
    public NavSegmentID navSegmentID;
    public long changeIndicator;
    public boolean isComplete;

    public AvailableRoute() {
        this.navSegmentID = null;
        this.changeIndicator = 0L;
        this.isComplete = false;
    }

    public AvailableRoute(NavSegmentID navSegmentID, long l, boolean bl) {
        this.navSegmentID = navSegmentID;
        this.changeIndicator = l;
        this.isComplete = bl;
    }

    public NavSegmentID getNavSegmentID() {
        return this.navSegmentID;
    }

    public long getChangeIndicator() {
        return this.changeIndicator;
    }

    public boolean isIsComplete() {
        return this.isComplete;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("AvailableRoute");
        stringBuffer.append('(');
        stringBuffer.append("navSegmentID");
        stringBuffer.append('=');
        stringBuffer.append(this.navSegmentID);
        stringBuffer.append(',');
        stringBuffer.append("changeIndicator");
        stringBuffer.append('=');
        stringBuffer.append(this.changeIndicator);
        stringBuffer.append(',');
        stringBuffer.append("isComplete");
        stringBuffer.append('=');
        stringBuffer.append(this.isComplete);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

