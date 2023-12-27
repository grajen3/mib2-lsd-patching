/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class ADBAddressData {
    public String country;
    public String region;
    public String locality;
    public String postalCode;
    public String street;
    public String plaintextAddress;
    public long addressType;

    public ADBAddressData() {
        this.country = null;
        this.region = null;
        this.locality = null;
        this.postalCode = null;
        this.street = null;
        this.plaintextAddress = null;
        this.addressType = 0L;
    }

    public ADBAddressData(String string, String string2, String string3, String string4, String string5, String string6, long l) {
        this.country = string;
        this.region = string2;
        this.locality = string3;
        this.postalCode = string4;
        this.street = string5;
        this.plaintextAddress = string6;
        this.addressType = l;
    }

    public String getCountry() {
        return this.country;
    }

    public String getRegion() {
        return this.region;
    }

    public String getLocality() {
        return this.locality;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPlaintextAddress() {
        return this.plaintextAddress;
    }

    public long getAddressType() {
        return this.addressType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("ADBAddressData");
        stringBuffer.append('(');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("locality");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.locality);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("postalCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postalCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("plaintextAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.plaintextAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("addressType");
        stringBuffer.append('=');
        stringBuffer.append(this.addressType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

