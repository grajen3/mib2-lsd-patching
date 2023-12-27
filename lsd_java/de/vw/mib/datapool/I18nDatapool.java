/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.datapool.I18nListener;

public interface I18nDatapool {
    default public String getString(int n) {
    }

    default public String[] getStrings(int n) {
    }

    default public void registerI18nListener(I18nListener i18nListener) {
    }

    default public void deregisterI18nListener(I18nListener i18nListener) {
    }
}

