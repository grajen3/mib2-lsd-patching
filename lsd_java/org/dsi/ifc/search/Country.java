/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class Country {
    public int countryID;
    public String name;
    public String code;
    public int houseNumberFormatting;
    public String stateName;
    public String stateAbbreviation;

    public Country() {
        this.countryID = -1;
        this.name = null;
        this.code = null;
        this.houseNumberFormatting = 0;
        this.stateName = null;
        this.stateAbbreviation = null;
    }

    public Country(int n, String string, String string2, int n2, String string3, String string4) {
        this.countryID = n;
        this.name = string;
        this.code = string2;
        this.houseNumberFormatting = n2;
        this.stateName = string3;
        this.stateAbbreviation = string4;
    }

    public int getCountryID() {
        return this.countryID;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getHouseNumberFormatting() {
        return this.houseNumberFormatting;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getStateAbbreviation() {
        return this.stateAbbreviation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("Country");
        stringBuffer.append('(');
        stringBuffer.append("countryID");
        stringBuffer.append('=');
        stringBuffer.append(this.countryID);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("code");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.code);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("houseNumberFormatting");
        stringBuffer.append('=');
        stringBuffer.append(this.houseNumberFormatting);
        stringBuffer.append(',');
        stringBuffer.append("stateName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stateName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("stateAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stateAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

