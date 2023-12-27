/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.NavPhoneData;

public class TryBestMatchData {
    public String streedAndOrHouseNumber;
    public String locality;
    public String country;
    public NavPhoneData[] phoneNumbers;
    public String postOfficeBox;
    public String region;
    public String postalCode;
    public String unstructured;

    public TryBestMatchData() {
        this.streedAndOrHouseNumber = "";
        this.locality = "";
        this.country = "";
        this.phoneNumbers = null;
        this.postOfficeBox = "";
        this.region = "";
        this.postalCode = "";
        this.unstructured = "";
    }

    public TryBestMatchData(String string, String string2, String string3, NavPhoneData[] navPhoneDataArray, String string4, String string5, String string6, String string7) {
        this.streedAndOrHouseNumber = string;
        this.locality = string2;
        this.country = string3;
        this.phoneNumbers = navPhoneDataArray;
        this.postOfficeBox = string4;
        this.region = string5;
        this.postalCode = string6;
        this.unstructured = string7;
    }

    public String getStreedAndOrHouseNumber() {
        return this.streedAndOrHouseNumber;
    }

    public String getLocality() {
        return this.locality;
    }

    public String getCountry() {
        return this.country;
    }

    public NavPhoneData[] getPhoneNumbers() {
        return this.phoneNumbers;
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
        stringBuffer.append("TryBestMatchData");
        stringBuffer.append('(');
        stringBuffer.append("streedAndOrHouseNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streedAndOrHouseNumber);
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

