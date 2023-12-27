/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadUpdateableFirmwarePartTransformer;

public class DownloadUpdateableFirmwarePartTransformer
extends AbstractDownloadUpdateableFirmwarePartTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 3) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            return swdlUpdateDataCollector.dataState;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        switch (n) {
            case 1: {
                return swdlUpdateDataCollector.dataVersion;
            }
            case 0: {
                return swdlUpdateDataCollector.dataName;
            }
            case 2: {
                return swdlUpdateDataCollector.dataTargetVersion;
            }
        }
        throw new IllegalArgumentException();
    }
}

