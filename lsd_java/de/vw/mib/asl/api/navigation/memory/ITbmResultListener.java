/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import org.dsi.ifc.navigation.TryBestMatchResultData;

public interface ITbmResultListener {
    default public void handleResultTbm(TryBestMatchResultData[] tryBestMatchResultDataArray, Object object) {
    }
}

