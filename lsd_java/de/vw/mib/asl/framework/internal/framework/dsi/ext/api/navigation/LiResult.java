/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

public final class LiResult {
    private final long returnCode;

    public LiResult(Object[] objectArray) {
        this.returnCode = (Long)objectArray[0];
    }

    public long getReturnCode() {
        return this.returnCode;
    }
}

