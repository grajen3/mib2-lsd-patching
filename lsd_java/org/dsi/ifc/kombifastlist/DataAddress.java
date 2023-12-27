/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataAddress {
    public int pos;
    public String lastName;
    public String firstName;
    public String street;
    public String city;
    public String region;
    public String postalCode;
    public String country;
    public String coordinates;
    public String poiDescription;
    public int poiType;
    public int addressType;

    public DataAddress() {
        this.pos = 0;
        this.lastName = "";
        this.firstName = "";
        this.street = "";
        this.city = "";
        this.region = "";
        this.postalCode = "";
        this.country = "";
        this.coordinates = "";
        this.poiDescription = "";
        this.poiType = 0;
        this.addressType = 0;
    }

    public DataAddress(int n, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int n2, int n3) {
        this.pos = n;
        this.lastName = string;
        this.firstName = string2;
        this.street = string3;
        this.city = string4;
        this.region = string5;
        this.postalCode = string6;
        this.country = string7;
        this.coordinates = string8;
        this.poiDescription = string9;
        this.poiType = n2;
        this.addressType = n3;
    }

    public int getPos() {
        return this.pos;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getRegion() {
        return this.region;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    public String getPoiDescription() {
        return this.poiDescription;
    }

    public int getPoiType() {
        return this.poiType;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(850);
        stringBuffer.append("DataAddress");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("lastName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
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
        stringBuffer.append("postalCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postalCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("coordinates");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.coordinates);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("poiDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.poiDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("poiType");
        stringBuffer.append('=');
        stringBuffer.append(this.poiType);
        stringBuffer.append(',');
        stringBuffer.append("addressType");
        stringBuffer.append('=');
        stringBuffer.append(this.addressType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

