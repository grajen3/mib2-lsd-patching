/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadUnReadyDevicesTransformer;

public class DownloadUnReadyDevicesTransformer
extends AbstractDownloadUnReadyDevicesTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return (String)object;
        }
        throw new IllegalArgumentException();
    }
}

