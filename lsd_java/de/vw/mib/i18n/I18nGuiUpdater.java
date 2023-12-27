/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.i18n;

import de.vw.mib.i18n.I18nLanguage;

public interface I18nGuiUpdater {
    default public void languageChanged(String string, I18nLanguage i18nLanguage) {
    }

    default public I18nLanguage getCurrentLanguage() {
    }
}

