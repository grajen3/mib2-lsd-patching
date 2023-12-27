/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeClampsGroupTransformer;

public class TestmodeClampsGroupTransformer
extends AbstractTestmodeClampsGroupTransformer {
    @Override
    public String getString(int n, Object object) {
        return ((String[])object)[n];
    }
}

