/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class DistanceToNextManeuver {
    public boolean showDistance;
    public int distance;
    public boolean showBargraph;
    public int bargraph;

    public DistanceToNextManeuver() {
        this.showDistance = false;
        this.distance = 0;
        this.showBargraph = false;
        this.bargraph = 0;
    }

    public DistanceToNextManeuver(boolean bl, int n, boolean bl2, int n2) {
        this.showDistance = bl;
        this.distance = n;
        this.showBargraph = bl2;
        this.bargraph = n2;
    }

    public boolean isShowDistance() {
        return this.showDistance;
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean isShowBargraph() {
        return this.showBargraph;
    }

    public int getBargraph() {
        return this.bargraph;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DistanceToNextManeuver");
        stringBuffer.append('(');
        stringBuffer.append("showDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.showDistance);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("showBargraph");
        stringBuffer.append('=');
        stringBuffer.append(this.showBargraph);
        stringBuffer.append(',');
        stringBuffer.append("bargraph");
        stringBuffer.append('=');
        stringBuffer.append(this.bargraph);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

