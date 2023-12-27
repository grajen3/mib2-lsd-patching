/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.i18n;

import de.vw.mib.i18n.I18nLanguage;
import java.io.File;

public interface I18nTableDecoder {
    default public I18nLanguage loadI18nTable(File file) {
    }

    default public I18nLanguage loadI18nDeltaTable(File file) {
    }
}

