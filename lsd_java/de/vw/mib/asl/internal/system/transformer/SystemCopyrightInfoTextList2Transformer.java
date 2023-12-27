/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemCopyrightInfoTextList2Transformer;

public class SystemCopyrightInfoTextList2Transformer
extends AbstractSystemCopyrightInfoTextList2Transformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        throw new IllegalArgumentException();
    }
}

