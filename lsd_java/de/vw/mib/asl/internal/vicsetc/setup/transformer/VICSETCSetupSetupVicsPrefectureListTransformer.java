/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.setup.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.AbstractVICSETCSetupSetupVicsPrefectureListTransformer;

public class VICSETCSetupSetupVicsPrefectureListTransformer
extends AbstractVICSETCSetupSetupVicsPrefectureListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        throw new IllegalArgumentException();
    }
}

