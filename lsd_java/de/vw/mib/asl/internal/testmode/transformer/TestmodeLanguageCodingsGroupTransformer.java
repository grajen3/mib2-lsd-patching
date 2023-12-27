/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeLanguageCodingsGroupTransformer;

public class TestmodeLanguageCodingsGroupTransformer
extends AbstractTestmodeLanguageCodingsGroupTransformer {
    @Override
    public String getString(int n, Object object) {
        String[] stringArray = (String[])object;
        switch (n) {
            case 0: {
                return stringArray[0];
            }
            case 1: {
                return stringArray[1];
            }
        }
        throw new IllegalArgumentException();
    }
}

