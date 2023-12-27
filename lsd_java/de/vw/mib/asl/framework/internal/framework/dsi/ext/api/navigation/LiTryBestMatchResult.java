/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

import org.dsi.ifc.navigation.TryBestMatchResultData;

public final class LiTryBestMatchResult {
    private final TryBestMatchResultData[] result;

    public LiTryBestMatchResult(Object[] objectArray) {
        this.result = (TryBestMatchResultData[])objectArray[0];
    }

    public TryBestMatchResultData[] getResult() {
        return this.result;
    }
}

