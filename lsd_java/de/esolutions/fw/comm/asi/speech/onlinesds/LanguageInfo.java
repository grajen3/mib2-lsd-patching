/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

public class LanguageInfo {
    public String language;
    public String region;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String string) {
        this.language = string;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String string) {
        this.region = string;
    }

    public LanguageInfo() {
    }

    public LanguageInfo(String string, String string2) {
        this.language = string;
        this.region = string2;
    }

    public String toString() {
        return new StringBuffer("LanguageInfo{").append("language=").append(this.language).append(", region=").append(this.region).append("}").toString();
    }
}

