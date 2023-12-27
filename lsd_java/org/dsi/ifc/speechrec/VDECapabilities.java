/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class VDECapabilities {
    public String countryAbbreviation;
    public boolean oneShot;
    public boolean fullWord;
    public boolean spelling;
    public boolean poiFuzzy;
    public boolean flexVDE;
    public String[] grammarLanguage;
    public String[] flexVDELanguage;

    public VDECapabilities() {
        this.countryAbbreviation = "";
        this.oneShot = false;
        this.fullWord = false;
        this.spelling = false;
        this.poiFuzzy = false;
        this.flexVDE = false;
        this.grammarLanguage = null;
        this.flexVDELanguage = null;
    }

    public VDECapabilities(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, String[] stringArray) {
        this.countryAbbreviation = string;
        this.oneShot = bl;
        this.fullWord = bl2;
        this.spelling = bl3;
        this.poiFuzzy = bl4;
        this.grammarLanguage = stringArray;
    }

    public VDECapabilities(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, String[] stringArray, String[] stringArray2) {
        this.countryAbbreviation = string;
        this.oneShot = bl;
        this.fullWord = bl2;
        this.spelling = bl3;
        this.poiFuzzy = bl4;
        this.flexVDE = bl5;
        this.grammarLanguage = stringArray;
        this.flexVDELanguage = stringArray2;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public boolean isOneShot() {
        return this.oneShot;
    }

    public boolean isFullWord() {
        return this.fullWord;
    }

    public boolean isSpelling() {
        return this.spelling;
    }

    public boolean isPoiFuzzy() {
        return this.poiFuzzy;
    }

    public boolean isFlexVDE() {
        return this.flexVDE;
    }

    public String[] getGrammarLanguage() {
        return this.grammarLanguage;
    }

    public String[] getFlexVDELanguage() {
        return this.flexVDELanguage;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("VDECapabilities");
        stringBuffer.append('(');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("oneShot");
        stringBuffer.append('=');
        stringBuffer.append(this.oneShot);
        stringBuffer.append(',');
        stringBuffer.append("fullWord");
        stringBuffer.append('=');
        stringBuffer.append(this.fullWord);
        stringBuffer.append(',');
        stringBuffer.append("spelling");
        stringBuffer.append('=');
        stringBuffer.append(this.spelling);
        stringBuffer.append(',');
        stringBuffer.append("poiFuzzy");
        stringBuffer.append('=');
        stringBuffer.append(this.poiFuzzy);
        stringBuffer.append(',');
        stringBuffer.append("flexVDE");
        stringBuffer.append('=');
        stringBuffer.append(this.flexVDE);
        stringBuffer.append(',');
        stringBuffer.append("grammarLanguage");
        stringBuffer.append('[');
        if (this.grammarLanguage != null) {
            stringBuffer.append(this.grammarLanguage.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.grammarLanguage != null) {
            n3 = this.grammarLanguage.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.grammarLanguage[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.grammarLanguage);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("flexVDELanguage");
        stringBuffer.append('[');
        if (this.flexVDELanguage != null) {
            stringBuffer.append(this.flexVDELanguage.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.flexVDELanguage != null) {
            n3 = this.flexVDELanguage.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.flexVDELanguage[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.flexVDELanguage);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

