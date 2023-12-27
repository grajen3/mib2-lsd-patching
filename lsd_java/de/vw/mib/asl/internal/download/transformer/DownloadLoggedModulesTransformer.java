/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadLoggedModulesTransformer;

public class DownloadLoggedModulesTransformer
extends AbstractDownloadLoggedModulesTransformer {
    @Override
    public int getInt(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector;
        int n2 = 0;
        if (n == 1) {
            swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            n2 = swdlUpdateDataCollector.dataState;
        }
        if (n != 2) {
            throw new IllegalArgumentException();
        }
        swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        n2 = swdlUpdateDataCollector.dataState;
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        if (n != 0) {
            throw new IllegalArgumentException();
        }
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        string = swdlUpdateDataCollector.dataName;
        return string;
    }
}

