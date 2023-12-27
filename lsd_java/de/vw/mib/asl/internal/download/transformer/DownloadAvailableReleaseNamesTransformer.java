/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadAvailableReleaseNamesTransformer;

public class DownloadAvailableReleaseNamesTransformer
extends AbstractDownloadAvailableReleaseNamesTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = null;
        if (n == 0) {
            string = (String)object;
        }
        return string;
    }
}

