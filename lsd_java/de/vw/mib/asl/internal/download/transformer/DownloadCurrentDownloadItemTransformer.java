/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadCurrentDownloadItemTransformer;

public class DownloadCurrentDownloadItemTransformer
extends AbstractDownloadCurrentDownloadItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        switch (n) {
            case 3: {
                return swdlUpdateDataCollector.progress;
            }
            case 2: {
                return swdlUpdateDataCollector.retries;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        switch (n) {
            case 0: {
                return swdlUpdateDataCollector.deviceName;
            }
            case 1: {
                return swdlUpdateDataCollector.moduleName;
            }
        }
        throw new IllegalArgumentException();
    }
}

