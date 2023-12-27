/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

public class TrafficInformationDetails {
    public int trafficType;
    public int contentID;

    public TrafficInformationDetails() {
        this.trafficType = 0;
        this.contentID = 0;
    }

    public TrafficInformationDetails(int n, int n2) {
        this.trafficType = n;
        this.contentID = n2;
    }

    public int getTrafficType() {
        return this.trafficType;
    }

    public int getContentID() {
        return this.contentID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TrafficInformationDetails");
        stringBuffer.append('(');
        stringBuffer.append("trafficType");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficType);
        stringBuffer.append(',');
        stringBuffer.append("contentID");
        stringBuffer.append('=');
        stringBuffer.append(this.contentID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

