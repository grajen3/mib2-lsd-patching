/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerSupportedTVNormIndicesTransformer;

public class TVTunerSupportedTVNormIndicesTransformer
extends AbstractTVTunerSupportedTVNormIndicesTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            return (Integer)object;
        }
        return 0;
    }
}

