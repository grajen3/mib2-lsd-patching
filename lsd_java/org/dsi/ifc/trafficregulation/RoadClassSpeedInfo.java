/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

public class RoadClassSpeedInfo {
    public String countryAbbreviation;
    public int roadClassIconReference;
    public int roadClassType;
    public int roadSignIconReference;
    public int speedLimit;
    public int speedUnit;
    public int variant;

    public RoadClassSpeedInfo() {
        this.countryAbbreviation = null;
        this.roadClassIconReference = 0;
        this.roadClassType = 0;
        this.roadSignIconReference = 0;
        this.speedLimit = 0;
        this.speedUnit = 0;
        this.variant = 0;
    }

    public RoadClassSpeedInfo(String string, int n, int n2, int n3, int n4, int n5, int n6) {
        this.countryAbbreviation = string;
        this.roadClassIconReference = n;
        this.roadClassType = n2;
        this.roadSignIconReference = n3;
        this.speedLimit = n4;
        this.speedUnit = n5;
        this.variant = n6;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public int getRoadClassIconReference() {
        return this.roadClassIconReference;
    }

    public int getRoadClassType() {
        return this.roadClassType;
    }

    public int getRoadSignIconReference() {
        return this.roadSignIconReference;
    }

    public int getSpeedLimit() {
        return this.speedLimit;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public int getVariant() {
        return this.variant;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("RoadClassSpeedInfo");
        stringBuffer.append('(');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("roadClassIconReference");
        stringBuffer.append('=');
        stringBuffer.append(this.roadClassIconReference);
        stringBuffer.append(',');
        stringBuffer.append("roadClassType");
        stringBuffer.append('=');
        stringBuffer.append(this.roadClassType);
        stringBuffer.append(',');
        stringBuffer.append("roadSignIconReference");
        stringBuffer.append('=');
        stringBuffer.append(this.roadSignIconReference);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit);
        stringBuffer.append(',');
        stringBuffer.append("speedUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedUnit);
        stringBuffer.append(',');
        stringBuffer.append("variant");
        stringBuffer.append('=');
        stringBuffer.append(this.variant);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

