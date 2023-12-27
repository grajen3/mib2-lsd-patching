/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

import de.vw.mib.asl.internal.download.transformer.SwdlUpdateDataCollector;
import generated.de.vw.mib.asl.internal.download.transformer.AbstractDownloadUpdateableFirmwarePartAsStringTransformer;

public class DownloadUpdateableFirmwarePartAsStringTransformer
extends AbstractDownloadUpdateableFirmwarePartAsStringTransformer {
    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        SwdlUpdateDataCollector swdlUpdateDataCollector = (SwdlUpdateDataCollector)object;
        switch (n) {
            case 3: {
                return swdlUpdateDataCollector.stateAbbreviation;
            }
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

