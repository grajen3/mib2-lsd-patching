/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadUpdateableModulesTransformer;

public class DownloadUpdateableModulesTransformer
extends AbstractDownloadUpdateableModulesTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            return swdlUpdateDataCollector.dataState;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            return swdlUpdateDataCollector.dataName;
        }
        throw new IllegalArgumentException();
    }
}

