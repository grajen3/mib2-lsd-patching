/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

public interface LanguageChanger {
    public static final long LANGUAGE_CHANGE_TIMEOUT_PER_LANGUAGE = Long.getLong("de.vw.mib.lsc.languagechangetimeout4language", 0);
    public static final long LANGUAGE_CHANGE_TIMEOUT_TOTAL = Long.getLong("de.vw.mib.lsc.languagechangetimeouttotal", 0);

    default public void setChangeResult(int n, boolean bl, String string) {
    }
}

