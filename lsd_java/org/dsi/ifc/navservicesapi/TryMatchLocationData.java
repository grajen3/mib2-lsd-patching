/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.navservicesapi.NavPhoneData;

public class TryMatchLocationData {
    public int latitude;
    public int longitude;
    public String houseNumber;
    public String junction;
    public String street;
    public String town;
    public String country;
    public NavPhoneData[] phoneNumbers;
    public String state;
    public String poiName;
    public int poiCategory;
    public String postalCode;
    public String unstructured;
    public int origin;
    public String dbVersion;
    public String townPart;

    public TryMatchLocationData() {
        this.latitude = 0;
        this.longitude = 0;
        this.houseNumber = "";
        this.junction = "";
        this.street = "";
        this.town = "";
        this.country = "";
        this.phoneNumbers = null;
        this.state = "";
        this.poiName = "";
        this.poiCategory = 0;
        this.postalCode = "";
        this.unstructured = "";
        this.origin = 0;
        this.dbVersion = "";
        this.townPart = "";
    }

    public TryMatchLocationData(int n, int n2, String string, String string2, String string3, String string4, String string5, NavPhoneData[] navPhoneDataArray, String string6, String string7, int n3, String string8, String string9, int n4, String string10, String string11) {
        this.longitude = n2;
        this.latitude = n;
        this.houseNumber = string;
        this.junction = string2;
        this.street = string3;
        this.town = string4;
        this.country = string5;
        this.phoneNumbers = navPhoneDataArray;
        this.state = string6;
        this.poiName = string7;
        this.poiCategory = n3;
        this.postalCode = string8;
        this.unstructured = string9;
        this.origin = n4;
        this.dbVersion = string10;
        this.townPart = string11;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String getJunction() {
        return this.junction;
    }

    public String getStreet() {
        return this.street;
    }

    public String getTown() {
        return this.town;
    }

    public String getCountry() {
        return this.country;
    }

    public NavPhoneData[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String getState() {
        return this.state;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public int getPoiCategory() {
        return this.poiCategory;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getUnstructured() {
        return this.unstructured;
    }

    public int getOrigin() {
        return this.origin;
    }

    public String getDbVersion() {
        return this.dbVersion;
    }

    public String getTownPart() {
        return this.townPart;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("TryMatchLocationData");
        stringBuffer.append('(');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("houseNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.houseNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("junction");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.junction);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("town");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.town);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phoneNumbers");
        stringBuffer.append('[');
        if (this.phoneNumbers != null) {
            stringBuffer.append(this.phoneNumbers.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.phoneNumbers != null) {
            int n = this.phoneNumbers.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.phoneNumbers[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.phoneNumbers);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.state);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("poiName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.poiName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("poiCategory");
        stringBuffer.append('=');
        stringBuffer.append(this.poiCategory);
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
        stringBuffer.append(',');
        stringBuffer.append("origin");
        stringBuffer.append('=');
        stringBuffer.append(this.origin);
        stringBuffer.append(',');
        stringBuffer.append("dbVersion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dbVersion);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("townPart");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.townPart);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

