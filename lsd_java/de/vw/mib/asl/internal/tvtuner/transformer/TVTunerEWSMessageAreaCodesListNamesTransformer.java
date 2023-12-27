/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerEWSMessageAreaCodesListNamesTransformer;

public class TVTunerEWSMessageAreaCodesListNamesTransformer
extends AbstractTVTunerEWSMessageAreaCodesListNamesTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((String)object).toString();
        }
        throw new IllegalArgumentException();
    }
}

