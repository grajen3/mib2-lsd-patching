/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class CountryInfo {
    public String name;
    public String countryAbbreviation;
    public int iconIndex;
    public boolean rightHandTraffic;
    public String[] additionalInfo;
    public int[] additionalIcons;

    public CountryInfo() {
        this.name = "";
        this.countryAbbreviation = "";
        this.iconIndex = 0;
        this.rightHandTraffic = true;
        this.additionalInfo = null;
        this.additionalIcons = null;
    }

    public CountryInfo(String string, String string2, int n, boolean bl, String[] stringArray, int[] nArray) {
        this.name = string;
        this.countryAbbreviation = string2;
        this.iconIndex = n;
        this.rightHandTraffic = bl;
        this.additionalInfo = stringArray;
        this.additionalIcons = nArray;
    }

    public String getName() {
        return this.name;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public int getIconIndex() {
        return this.iconIndex;
    }

    public boolean isRightHandTraffic() {
        return this.rightHandTraffic;
    }

    public String[] getAdditionalInfo() {
        return this.additionalInfo;
    }

    public int[] getAdditionalIcons() {
        return this.additionalIcons;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("CountryInfo");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.iconIndex);
        stringBuffer.append(',');
        stringBuffer.append("rightHandTraffic");
        stringBuffer.append('=');
        stringBuffer.append(this.rightHandTraffic);
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo");
        stringBuffer.append('[');
        if (this.additionalInfo != null) {
            stringBuffer.append(this.additionalInfo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalInfo != null) {
            n3 = this.additionalInfo.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.additionalInfo[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalInfo);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("additionalIcons");
        stringBuffer.append('[');
        if (this.additionalIcons != null) {
            stringBuffer.append(this.additionalIcons.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalIcons != null) {
            n3 = this.additionalIcons.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.additionalIcons[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalIcons);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

