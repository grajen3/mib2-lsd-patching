/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

public class TrafficInfo {
    public String trafficOffset;
    public String trafficOffsetAffix;
    public boolean affixPlacementBefore;

    public TrafficInfo() {
        this.trafficOffset = null;
        this.trafficOffsetAffix = null;
        this.affixPlacementBefore = false;
    }

    public TrafficInfo(String string, String string2, boolean bl) {
        this.trafficOffset = string;
        this.trafficOffsetAffix = string2;
        this.affixPlacementBefore = bl;
    }

    public String getTrafficOffset() {
        return this.trafficOffset;
    }

    public String getTrafficOffsetAffix() {
        return this.trafficOffsetAffix;
    }

    public boolean isAffixPlacementBefore() {
        return this.affixPlacementBefore;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("TrafficInfo");
        stringBuffer.append('(');
        stringBuffer.append("trafficOffset");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.trafficOffset);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("trafficOffsetAffix");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.trafficOffsetAffix);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("affixPlacementBefore");
        stringBuffer.append('=');
        stringBuffer.append(this.affixPlacementBefore);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

