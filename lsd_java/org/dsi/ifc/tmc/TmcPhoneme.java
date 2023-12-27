/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

public class TmcPhoneme {
    public String roadName;
    public String directionOfRoad1;
    public String directionOfRoad2;
    public String startLocation;
    public String endLocation;
    public String phonemeAlphabet;

    public TmcPhoneme() {
        this.roadName = null;
        this.directionOfRoad1 = null;
        this.directionOfRoad2 = null;
        this.startLocation = null;
        this.endLocation = null;
        this.phonemeAlphabet = null;
    }

    public TmcPhoneme(String string, String string2, String string3, String string4, String string5, String string6) {
        this.roadName = string;
        this.directionOfRoad1 = string2;
        this.directionOfRoad2 = string3;
        this.startLocation = string4;
        this.endLocation = string5;
        this.phonemeAlphabet = string6;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String string) {
        this.roadName = string;
    }

    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    public void setDirectionOfRoad1(String string) {
        this.directionOfRoad1 = string;
    }

    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    public void setDirectionOfRoad2(String string) {
        this.directionOfRoad2 = string;
    }

    public String getStartLocation() {
        return this.startLocation;
    }

    public void setStartLocation(String string) {
        this.startLocation = string;
    }

    public String getEndLocation() {
        return this.endLocation;
    }

    public void setEndLocation(String string) {
        this.endLocation = string;
    }

    public String getPhonemeAlphabet() {
        return this.phonemeAlphabet;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("TmcPhoneme");
        stringBuffer.append('(');
        stringBuffer.append("roadName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("startLocation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.startLocation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("endLocation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.endLocation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phonemeAlphabet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phonemeAlphabet);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

