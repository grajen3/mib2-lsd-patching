/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car;

import java.util.Arrays;

public final class RawConfigDataProxy {
    public byte[] rawConfigData;

    public RawConfigDataProxy() {
    }

    public RawConfigDataProxy(byte[] byArray) {
        this.rawConfigData = byArray;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof RawConfigDataProxy) {
            RawConfigDataProxy rawConfigDataProxy = (RawConfigDataProxy)object;
            return Arrays.equals(this.rawConfigData, rawConfigDataProxy.rawConfigData);
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

