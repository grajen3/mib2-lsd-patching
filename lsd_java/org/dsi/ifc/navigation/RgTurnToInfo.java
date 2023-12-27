/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RgTurnToInfo {
    public String turnToStreet;
    public String streetIconText;
    public int streetIconId;
    public boolean inProgressData;
    public String signPost;

    public RgTurnToInfo() {
        this.turnToStreet = null;
        this.streetIconText = null;
        this.streetIconId = 0;
        this.inProgressData = false;
        this.signPost = null;
    }

    public RgTurnToInfo(String string, String string2, int n, boolean bl, String string3) {
        this.turnToStreet = string;
        this.streetIconText = string2;
        this.streetIconId = n;
        this.inProgressData = bl;
        this.signPost = string3;
    }

    public String getTurnToStreet() {
        return this.turnToStreet;
    }

    public String getStreetIconText() {
        return this.streetIconText;
    }

    public int getStreetIconId() {
        return this.streetIconId;
    }

    public boolean isInProgressData() {
        return this.inProgressData;
    }

    public String getSignPost() {
        return this.signPost;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("RgTurnToInfo");
        stringBuffer.append('(');
        stringBuffer.append("turnToStreet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.turnToStreet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetIconText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.streetIconId);
        stringBuffer.append(',');
        stringBuffer.append("inProgressData");
        stringBuffer.append('=');
        stringBuffer.append(this.inProgressData);
        stringBuffer.append(',');
        stringBuffer.append("signPost");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.signPost);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

