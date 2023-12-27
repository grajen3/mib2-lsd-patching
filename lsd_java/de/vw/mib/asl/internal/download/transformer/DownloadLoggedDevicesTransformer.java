/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadLoggedDevicesTransformer;

public class DownloadLoggedDevicesTransformer
extends AbstractDownloadLoggedDevicesTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2 = 0;
        if (n == 2) {
            n2 = ((SwdlUpdateDataCollector)object).dataState;
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        if (n == 0) {
            string = ((SwdlUpdateDataCollector)object).dataName;
        }
        return string;
    }
}

