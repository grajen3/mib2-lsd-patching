/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OperatorCallAddressEntry {
    public String street;
    public String zip;
    public String city;
    public String region;
    public String country;
    public String phoneNumber;
    public String url;
    public String statusURL;

    public OperatorCallAddressEntry() {
        this.street = null;
        this.zip = null;
        this.city = null;
        this.region = null;
        this.country = null;
        this.phoneNumber = null;
        this.url = null;
        this.statusURL = null;
    }

    public OperatorCallAddressEntry(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.street = string;
        this.zip = string2;
        this.city = string3;
        this.region = string4;
        this.country = string5;
        this.phoneNumber = string6;
        this.url = string7;
        this.statusURL = string8;
    }

    public String getStreet() {
        return this.street;
    }

    public String getZip() {
        return this.zip;
    }

    public String getCity() {
        return this.city;
    }

    public String getRegion() {
        return this.region;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getUrl() {
        return this.url;
    }

    public String getStatusURL() {
        return this.statusURL;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("OperatorCallAddressEntry");
        stringBuffer.append('(');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("zip");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.zip);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("city");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.city);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phoneNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("statusURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.statusURL);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

