/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.LIExtData;

public class LIValueListElement {
    public String data;
    public boolean validDestination;
    public boolean toRefine;
    public int criteriaNumber;
    public int poiUniqueId;
    public int iconIndex;
    public int subIconIndex;
    public int longitude;
    public int latitude;
    public String countryAbbreviation;
    public boolean hasListIndex;
    public int listIndex;
    public int additionalFlags;
    public String additionalData;
    public boolean houseNumberInZipCode;
    public boolean bestGuess;
    public LIExtData[] extendedData;
    public int[] iconDecoratorInformation;

    public LIValueListElement() {
        this.data = null;
        this.validDestination = false;
        this.toRefine = false;
        this.criteriaNumber = 0;
        this.iconIndex = 0;
        this.subIconIndex = 0;
        this.longitude = 0;
        this.latitude = 0;
        this.countryAbbreviation = null;
        this.hasListIndex = false;
        this.listIndex = 0;
        this.additionalFlags = 0;
        this.additionalData = null;
        this.houseNumberInZipCode = false;
        this.bestGuess = false;
        this.extendedData = null;
        this.iconDecoratorInformation = null;
    }

    public LIValueListElement(String string, boolean bl, boolean bl2, int n, int n2, int n3, int n4, int n5, int n6, String string2, boolean bl3, int n7, int n8, String string3, boolean bl4, boolean bl5, LIExtData[] lIExtDataArray, int[] nArray) {
        this.data = string;
        this.validDestination = bl;
        this.toRefine = bl2;
        this.criteriaNumber = n;
        this.poiUniqueId = n2;
        this.iconIndex = n3;
        this.subIconIndex = n4;
        this.longitude = n5;
        this.latitude = n6;
        this.countryAbbreviation = string2;
        this.hasListIndex = bl3;
        this.listIndex = n7;
        this.additionalFlags = n8;
        this.additionalData = string3;
        this.houseNumberInZipCode = bl4;
        this.bestGuess = bl5;
        this.extendedData = lIExtDataArray;
        this.iconDecoratorInformation = nArray;
    }

    public String getData() {
        return this.data;
    }

    public boolean isValidDestination() {
        return this.validDestination;
    }

    public boolean isToRefine() {
        return this.toRefine;
    }

    public int getCriteriaNumber() {
        return this.criteriaNumber;
    }

    public int getPoiUniqueId() {
        return this.poiUniqueId;
    }

    public int getIconIndex() {
        return this.iconIndex;
    }

    public int getSubIconIndex() {
        return this.subIconIndex;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public boolean isHasListIndex() {
        return this.hasListIndex;
    }

    public int getListIndex() {
        return this.listIndex;
    }

    public int getAdditionalFlags() {
        return this.additionalFlags;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public boolean isHouseNumberInZipCode() {
        return this.houseNumberInZipCode;
    }

    public boolean isBestGuess() {
        return this.bestGuess;
    }

    public LIExtData[] getExtendedData() {
        return this.extendedData;
    }

    public int[] getIconDecoratorInformation() {
        return this.iconDecoratorInformation;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1050);
        stringBuffer.append("LIValueListElement");
        stringBuffer.append('(');
        stringBuffer.append("data");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.data);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("validDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.validDestination);
        stringBuffer.append(',');
        stringBuffer.append("toRefine");
        stringBuffer.append('=');
        stringBuffer.append(this.toRefine);
        stringBuffer.append(',');
        stringBuffer.append("criteriaNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.criteriaNumber);
        stringBuffer.append(',');
        stringBuffer.append("poiUniqueId");
        stringBuffer.append('=');
        stringBuffer.append(this.poiUniqueId);
        stringBuffer.append(',');
        stringBuffer.append("iconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.iconIndex);
        stringBuffer.append(',');
        stringBuffer.append("subIconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.subIconIndex);
        stringBuffer.append(',');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hasListIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.hasListIndex);
        stringBuffer.append(',');
        stringBuffer.append("listIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.listIndex);
        stringBuffer.append(',');
        stringBuffer.append("additionalFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalFlags);
        stringBuffer.append(',');
        stringBuffer.append("additionalData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.additionalData);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("houseNumberInZipCode");
        stringBuffer.append('=');
        stringBuffer.append(this.houseNumberInZipCode);
        stringBuffer.append(',');
        stringBuffer.append("bestGuess");
        stringBuffer.append('=');
        stringBuffer.append(this.bestGuess);
        stringBuffer.append(',');
        stringBuffer.append("extendedData");
        stringBuffer.append('[');
        if (this.extendedData != null) {
            stringBuffer.append(this.extendedData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extendedData != null) {
            n3 = this.extendedData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.extendedData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extendedData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("iconDecoratorInformation");
        stringBuffer.append('[');
        if (this.iconDecoratorInformation != null) {
            stringBuffer.append(this.iconDecoratorInformation.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.iconDecoratorInformation != null) {
            n3 = this.iconDecoratorInformation.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.iconDecoratorInformation[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.iconDecoratorInformation);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

