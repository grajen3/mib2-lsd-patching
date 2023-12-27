/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemSetupAvailableLanguagesList_ISOTransformer;

public class SystemSetupAvailableLanguagesList_ISOTransformer
extends AbstractSystemSetupAvailableLanguagesList_ISOTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return (String)object;
            }
        }
        throw new IllegalArgumentException();
    }
}

