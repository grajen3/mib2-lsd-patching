/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemSkinListTransformer;

public class SystemSkinListTransformer
extends AbstractSystemSkinListTransformer {
    @Override
    public int getInt(int n, Object object) {
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        return "";
    }
}

