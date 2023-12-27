/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.i18n;

public interface I18nLanguage {
    default public void checkCompatibility(I18nLanguage i18nLanguage) {
    }

    default public int getScaleStringUpperLimit() {
    }

    default public String getScalarString(int n) {
    }

    default public int getStringArrayUpperLimit() {
    }

    default public String[] getStringArray(int n) {
    }
}

