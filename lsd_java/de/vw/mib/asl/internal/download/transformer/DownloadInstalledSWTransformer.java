/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadInstalledSWTransformer;

public class DownloadInstalledSWTransformer
extends AbstractDownloadInstalledSWTransformer {
    @Override
    public String getString(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        switch (n) {
            case 0: {
                return swdlUpdateDataCollector.dataName;
            }
            case 1: {
                return swdlUpdateDataCollector.dataVersion;
            }
        }
        throw new IllegalArgumentException();
    }
}

