/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.datapool;

public interface DatapoolTargetCodecListener {
    default public void receiveGetPropertyValue(int n, short s) {
    }

    default public void receiveSetPropertyValue(int n, short s, String string) {
    }

    default public void responseDatapoolPropertyValue(long l, int n, String string) {
    }

    default public void datapoolUpdateResult(boolean bl, String string) {
    }
}

