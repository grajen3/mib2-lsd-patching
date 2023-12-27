/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadSourceMediaAvailableTransformer;

public class DownloadSourceMediaAvailableTransformer
extends AbstractDownloadSourceMediaAvailableTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 0) {
            return (Boolean)object;
        }
        throw new IllegalArgumentException();
    }
}

