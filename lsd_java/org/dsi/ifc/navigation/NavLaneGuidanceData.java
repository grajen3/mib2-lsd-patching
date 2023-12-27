/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavLaneGuidanceData {
    public short pos;
    public short laneDirection;
    public byte[] laneSideStreets;
    public short laneType;
    public byte laneMarkingLeft;
    public byte laneMarkingRight;
    public byte laneDescription;
    public byte guidanceInfo;

    public NavLaneGuidanceData() {
        this.pos = 0;
        this.laneDirection = 0;
        this.laneSideStreets = null;
        this.laneType = 0;
        this.laneMarkingLeft = 0;
        this.laneMarkingRight = 0;
        this.laneDescription = 0;
    }

    public NavLaneGuidanceData(short s, short s2, byte[] byArray, short s3, byte by, byte by2, byte by3, byte by4) {
        this.pos = s;
        this.laneDirection = s2;
        this.laneSideStreets = byArray;
        this.laneType = s3;
        this.laneMarkingLeft = by;
        this.laneMarkingRight = by2;
        this.laneDescription = by3;
        this.guidanceInfo = by4;
    }

    public short getPos() {
        return this.pos;
    }

    public short getLaneDirection() {
        return this.laneDirection;
    }

    public byte[] getLaneSideStreets() {
        return this.laneSideStreets;
    }

    public short getLaneType() {
        return this.laneType;
    }

    public byte getLaneMarkingLeft() {
        return this.laneMarkingLeft;
    }

    public byte getLaneMarkingRight() {
        return this.laneMarkingRight;
    }

    public byte getLaneDescription() {
        return this.laneDescription;
    }

    public byte getGuidanceInfo() {
        return this.guidanceInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("NavLaneGuidanceData");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("laneDirection");
        stringBuffer.append('=');
        stringBuffer.append(this.laneDirection);
        stringBuffer.append(',');
        stringBuffer.append("laneSideStreets");
        stringBuffer.append('[');
        if (this.laneSideStreets != null) {
            stringBuffer.append(this.laneSideStreets.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.laneSideStreets != null) {
            int n = this.laneSideStreets.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.laneSideStreets[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.laneSideStreets);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("laneType");
        stringBuffer.append('=');
        stringBuffer.append(this.laneType);
        stringBuffer.append(',');
        stringBuffer.append("laneMarkingLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.laneMarkingLeft);
        stringBuffer.append(',');
        stringBuffer.append("laneMarkingRight");
        stringBuffer.append('=');
        stringBuffer.append(this.laneMarkingRight);
        stringBuffer.append(',');
        stringBuffer.append("laneDescription");
        stringBuffer.append('=');
        stringBuffer.append(this.laneDescription);
        stringBuffer.append(',');
        stringBuffer.append("guidanceInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.guidanceInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

