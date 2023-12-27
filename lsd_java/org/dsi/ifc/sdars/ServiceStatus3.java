/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class ServiceStatus3 {
    public int audioStatus;
    public int antennaStatus;
    public int listUpdateStatus;
    public short listUpdatePercentage;
    public int dataUpdateStatus;
    public int dataSubscription;
    public int subscriptionUpdateStatus;

    public ServiceStatus3() {
        this.audioStatus = 0;
        this.antennaStatus = 0;
        this.listUpdateStatus = 0;
        this.listUpdatePercentage = 0;
        this.dataUpdateStatus = 0;
        this.dataSubscription = 0;
        this.subscriptionUpdateStatus = 0;
    }

    public ServiceStatus3(int n, int n2, int n3, short s, int n4, int n5, int n6) {
        this.audioStatus = n;
        this.antennaStatus = n2;
        this.listUpdateStatus = n3;
        this.listUpdatePercentage = s;
        this.dataUpdateStatus = n4;
        this.dataSubscription = n5;
        this.subscriptionUpdateStatus = n6;
    }

    public int getAudioStatus() {
        return this.audioStatus;
    }

    public int getAntennaStatus() {
        return this.antennaStatus;
    }

    public int getListUpdateStatus() {
        return this.listUpdateStatus;
    }

    public short getListUpdatePercentage() {
        return this.listUpdatePercentage;
    }

    public int getDataUpdateStatus() {
        return this.dataUpdateStatus;
    }

    public int getDataSubscription() {
        return this.dataSubscription;
    }

    public int getSubscriptionUpdateStatus() {
        return this.subscriptionUpdateStatus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("ServiceStatus3");
        stringBuffer.append('(');
        stringBuffer.append("audioStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.audioStatus);
        stringBuffer.append(',');
        stringBuffer.append("antennaStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.antennaStatus);
        stringBuffer.append(',');
        stringBuffer.append("listUpdateStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.listUpdateStatus);
        stringBuffer.append(',');
        stringBuffer.append("listUpdatePercentage");
        stringBuffer.append('=');
        stringBuffer.append(this.listUpdatePercentage);
        stringBuffer.append(',');
        stringBuffer.append("dataUpdateStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.dataUpdateStatus);
        stringBuffer.append(',');
        stringBuffer.append("dataSubscription");
        stringBuffer.append('=');
        stringBuffer.append(this.dataSubscription);
        stringBuffer.append(',');
        stringBuffer.append("subscriptionUpdateStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.subscriptionUpdateStatus);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

