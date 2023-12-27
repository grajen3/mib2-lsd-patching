/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap.transformer;

import generated.de.vw.mib.asl.internal.swap.transformer.AbstractSWaPSupportedFEC_CodeTransformer;

public class SWaPSupportedFEC_CodeTransformer
extends AbstractSWaPSupportedFEC_CodeTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        throw new IllegalArgumentException();
    }
}

