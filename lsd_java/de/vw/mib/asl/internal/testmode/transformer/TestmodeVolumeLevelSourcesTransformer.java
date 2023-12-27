/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeVolumeLevelSourcesTransformer;

public class TestmodeVolumeLevelSourcesTransformer
extends AbstractTestmodeVolumeLevelSourcesTransformer {
    @Override
    public String getString(int n, Object object) {
        if (!(object instanceof String[])) {
            throw new IllegalArgumentException();
        }
        String[] stringArray = (String[])object;
        return stringArray[n];
    }
}

