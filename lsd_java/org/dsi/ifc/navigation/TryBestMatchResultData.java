/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavLocation;

public class TryBestMatchResultData {
    public NavLocation location;

    public TryBestMatchResultData() {
        this.location = null;
    }

    public TryBestMatchResultData(NavLocation navLocation) {
        this.location = navLocation;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1050);
        stringBuffer.append("TryBestMatchResultData");
        stringBuffer.append('(');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append(this.location);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

