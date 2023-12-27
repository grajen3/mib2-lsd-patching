/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavLocation;

public class TryMatchLocationResultData {
    public NavLocation location;
    public int matchLevel;

    public TryMatchLocationResultData() {
        this.location = null;
        this.matchLevel = 0;
    }

    public TryMatchLocationResultData(NavLocation navLocation, int n) {
        this.location = navLocation;
        this.matchLevel = n;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public int getMatchLevel() {
        return this.matchLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("TryMatchLocationResultData");
        stringBuffer.append('(');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append(this.location);
        stringBuffer.append(',');
        stringBuffer.append("matchLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.matchLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

