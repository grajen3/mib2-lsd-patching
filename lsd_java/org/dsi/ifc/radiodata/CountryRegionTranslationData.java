/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

public class CountryRegionTranslationData {
    public int countryId;
    public int guiLanguageId;
    public String guiLanguage;
    public String countryRegionTranslation;
    public int guiListItemPosition;

    public CountryRegionTranslationData() {
        this.countryId = -1;
        this.guiLanguageId = -1;
        this.guiLanguage = "";
        this.countryRegionTranslation = "";
        this.guiListItemPosition = 0;
    }

    public CountryRegionTranslationData(int n, int n2, String string, String string2, int n3) {
        this.countryId = n;
        this.guiLanguageId = n2;
        this.guiLanguage = string;
        this.countryRegionTranslation = string2;
        this.guiListItemPosition = n3;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public int getGuiLanguageId() {
        return this.guiLanguageId;
    }

    public String getGuiLanguage() {
        return this.guiLanguage;
    }

    public String getCountryRegionTranslation() {
        return this.countryRegionTranslation;
    }

    public int getGuiListItemPosition() {
        return this.guiListItemPosition;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("CountryRegionTranslationData");
        stringBuffer.append('(');
        stringBuffer.append("countryId");
        stringBuffer.append('=');
        stringBuffer.append(this.countryId);
        stringBuffer.append(',');
        stringBuffer.append("guiLanguageId");
        stringBuffer.append('=');
        stringBuffer.append(this.guiLanguageId);
        stringBuffer.append(',');
        stringBuffer.append("guiLanguage");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.guiLanguage);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryRegionTranslation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryRegionTranslation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("guiListItemPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.guiListItemPosition);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

