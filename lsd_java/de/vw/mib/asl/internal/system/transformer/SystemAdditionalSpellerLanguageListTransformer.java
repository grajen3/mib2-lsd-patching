/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import de.vw.mib.asl.internal.system.transformer.LanguageUpdateDataCollector;
import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemAdditionalSpellerLanguageListTransformer;

public class SystemAdditionalSpellerLanguageListTransformer
extends AbstractSystemAdditionalSpellerLanguageListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                LanguageUpdateDataCollector languageUpdateDataCollector = (LanguageUpdateDataCollector)object;
                return languageUpdateDataCollector.additionalSpellerFlag;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((LanguageUpdateDataCollector)object).language;
            }
        }
        throw new IllegalArgumentException();
    }
}

