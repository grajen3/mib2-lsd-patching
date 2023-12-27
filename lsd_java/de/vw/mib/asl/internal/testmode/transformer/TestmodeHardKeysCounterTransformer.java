/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeHardKeysCounterTransformer;

public class TestmodeHardKeysCounterTransformer
extends AbstractTestmodeHardKeysCounterTransformer {
    @Override
    public String getString(int n, Object object) {
        return ((String[])object)[n];
    }
}

