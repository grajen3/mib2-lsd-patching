/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.AbstractVICSETCFmGraphicMessageButtonNumbersTransformer;

public class VICSETCFmGraphicMessageButtonNumbersTransformer
extends AbstractVICSETCFmGraphicMessageButtonNumbersTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            return (Integer)object;
        }
        throw new IllegalArgumentException();
    }
}

