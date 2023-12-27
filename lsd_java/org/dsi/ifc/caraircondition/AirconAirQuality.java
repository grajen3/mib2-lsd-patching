/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconAirQuality {
    public int outsideCustomerThreshold;
    public int outsideOnlineData;
    public int incarCO2;
    public int incarPollution;

    public AirconAirQuality() {
        this.outsideCustomerThreshold = 0;
        this.outsideOnlineData = 0;
        this.incarCO2 = 0;
        this.incarPollution = 0;
    }

    public AirconAirQuality(int n, int n2, int n3, int n4) {
        this.outsideCustomerThreshold = n;
        this.outsideOnlineData = n2;
        this.incarCO2 = n3;
        this.incarPollution = n4;
    }

    public int getOutsideCustomerThreshold() {
        return this.outsideCustomerThreshold;
    }

    public int getOutsideOnlineData() {
        return this.outsideOnlineData;
    }

    public int getIncarCO2() {
        return this.incarCO2;
    }

    public int getIncarPollution() {
        return this.incarPollution;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconAirQuality");
        stringBuffer.append('(');
        stringBuffer.append("outsideCustomerThreshold");
        stringBuffer.append('=');
        stringBuffer.append(this.outsideCustomerThreshold);
        stringBuffer.append(',');
        stringBuffer.append("outsideOnlineData");
        stringBuffer.append('=');
        stringBuffer.append(this.outsideOnlineData);
        stringBuffer.append(',');
        stringBuffer.append("incarCO2");
        stringBuffer.append('=');
        stringBuffer.append(this.incarCO2);
        stringBuffer.append(',');
        stringBuffer.append("incarPollution");
        stringBuffer.append('=');
        stringBuffer.append(this.incarPollution);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

