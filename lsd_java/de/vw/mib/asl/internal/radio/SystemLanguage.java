/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

public final class SystemLanguage {
    private static SystemLanguage systemLanguageInstance = null;
    private String language = "en_GB";

    private SystemLanguage() {
    }

    public static SystemLanguage getInstance() {
        if (systemLanguageInstance == null) {
            systemLanguageInstance = new SystemLanguage();
        }
        return systemLanguageInstance;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String string) {
        if (null != string && !string.equals("NO_LANGUAGE")) {
            this.language = string;
        }
    }
}

