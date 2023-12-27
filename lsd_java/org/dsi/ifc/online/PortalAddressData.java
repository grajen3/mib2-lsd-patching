/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PortalAddressData {
    public long addressType;
    public String street;
    public String locality;
    public String country;
    public String postOfficeBox;
    public String region;
    public String postalCode;
    public String unstructured;

    public PortalAddressData() {
        this.addressType = 0L;
        this.street = null;
        this.locality = null;
        this.country = null;
        this.postOfficeBox = null;
        this.region = null;
        this.postalCode = null;
        this.unstructured = null;
    }

    public PortalAddressData(long l, String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.addressType = l;
        this.street = string;
        this.locality = string2;
        this.country = string3;
        this.postOfficeBox = string4;
        this.region = string5;
        this.postalCode = string6;
        this.unstructured = string7;
    }

    public long getAddressType() {
        return this.addressType;
    }

    public String getStreet() {
        return this.street;
    }

    public String getLocality() {
        return this.locality;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPostOfficeBox() {
        return this.postOfficeBox;
    }

    public String getRegion() {
        return this.region;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getUnstructured() {
        return this.unstructured;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("PortalAddressData");
        stringBuffer.append('(');
        stringBuffer.append("addressType");
        stringBuffer.append('=');
        stringBuffer.append(this.addressType);
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("locality");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.locality);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("postOfficeBox");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postOfficeBox);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("postalCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postalCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("unstructured");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.unstructured);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

