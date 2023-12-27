/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemLangErrorList_LangIsoTransformer;

public class SystemLangErrorList_LangIsoTransformer
extends AbstractSystemLangErrorList_LangIsoTransformer {
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

