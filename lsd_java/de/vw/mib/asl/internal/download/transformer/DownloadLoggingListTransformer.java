/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadLoggingListTransformer;

public class DownloadLoggingListTransformer
extends AbstractDownloadLoggingListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        if (n == 0) {
            SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
            bl = swdlUpdateDataCollector.dataMarkerDataInSlotIsCurrentVersion;
        }
        return bl;
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        switch (n) {
            case 1: {
                SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
                string = swdlUpdateDataCollector.dataVersion;
                break;
            }
            case 2: {
                SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
                string = swdlUpdateDataCollector.dataTargetVersion;
                break;
            }
            case 3: {
                SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
                string = swdlUpdateDataCollector.dataName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }
}

