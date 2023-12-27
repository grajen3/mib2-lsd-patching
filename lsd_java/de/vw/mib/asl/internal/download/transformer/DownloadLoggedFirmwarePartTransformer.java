/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadLoggedFirmwarePartTransformer;

public class DownloadLoggedFirmwarePartTransformer
extends AbstractDownloadLoggedFirmwarePartTransformer {
    @Override
    public int getInt(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector;
        int n2 = 0;
        if (n == 4) {
            swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            n2 = swdlUpdateDataCollector.dataState;
        }
        if (n == 6) {
            swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            n2 = swdlUpdateDataCollector.dataState;
        } else if (n == 5) {
            swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            n2 = swdlUpdateDataCollector.plannedResult;
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        if (n == 0) {
            string = swdlUpdateDataCollector.dataName;
        } else if (n == 1) {
            string = swdlUpdateDataCollector.dataVersion;
        } else if (n == 3) {
            string = swdlUpdateDataCollector.dataTargetVersion;
        } else if (n == 2) {
            string = swdlUpdateDataCollector.dataTargetVersion;
        }
        return string;
    }
}

