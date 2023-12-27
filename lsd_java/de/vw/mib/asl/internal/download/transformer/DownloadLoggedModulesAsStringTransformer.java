/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadLoggedModulesAsStringTransformer;

public class DownloadLoggedModulesAsStringTransformer
extends AbstractDownloadLoggedModulesAsStringTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2 = 0;
        if (n != 2) {
            throw new IllegalArgumentException();
        }
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        n2 = swdlUpdateDataCollector.dataState;
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        if (n == 1) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            string = swdlUpdateDataCollector.stateAbbreviation;
        } else if (n == 0) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            string = swdlUpdateDataCollector.dataName;
        } else {
            throw new IllegalArgumentException();
        }
        return string;
    }
}

