/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.global.ResourceLocator;

public class StationInfo {
    public short stationNumber;
    public int sID;
    public String shortLabel;
    public String fullLabel;
    public int subscription;
    public short categoryNumber;
    public boolean mature;
    public ResourceLocator channelArt;

    public StationInfo() {
        this.stationNumber = 0;
        this.sID = 0;
        this.shortLabel = "";
        this.fullLabel = "";
        this.subscription = 0;
        this.categoryNumber = 0;
        this.mature = false;
        this.channelArt = null;
    }

    public StationInfo(short s, int n, String string, String string2, int n2, short s2, boolean bl, ResourceLocator resourceLocator) {
        this.stationNumber = s;
        this.sID = n;
        this.shortLabel = string;
        this.fullLabel = string2;
        this.subscription = n2;
        this.categoryNumber = s2;
        this.mature = bl;
        this.channelArt = resourceLocator;
    }

    public short getStationNumber() {
        return this.stationNumber;
    }

    public int getSID() {
        return this.sID;
    }

    public String getShortLabel() {
        return this.shortLabel;
    }

    public String getFullLabel() {
        return this.fullLabel;
    }

    public int getSubscription() {
        return this.subscription;
    }

    public short getCategoryNumber() {
        return this.categoryNumber;
    }

    public boolean isMature() {
        return this.mature;
    }

    public ResourceLocator getChannelArt() {
        return this.channelArt;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("StationInfo");
        stringBuffer.append('(');
        stringBuffer.append("stationNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.stationNumber);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("shortLabel");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortLabel);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullLabel");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fullLabel);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("subscription");
        stringBuffer.append('=');
        stringBuffer.append(this.subscription);
        stringBuffer.append(',');
        stringBuffer.append("categoryNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.categoryNumber);
        stringBuffer.append(',');
        stringBuffer.append("mature");
        stringBuffer.append('=');
        stringBuffer.append(this.mature);
        stringBuffer.append(',');
        stringBuffer.append("channelArt");
        stringBuffer.append('=');
        stringBuffer.append(this.channelArt);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

