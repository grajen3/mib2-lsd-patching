/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.datapool;

import de.vw.mib.debug.service.debuginterface.datapool.DatapoolTargetCodecListener;

public abstract class DatapoolTargetCodecAdapter
implements DatapoolTargetCodecListener {
    @Override
    public void receiveGetPropertyValue(int n, short s) {
    }

    @Override
    public void receiveSetPropertyValue(int n, short s, String string) {
    }

    @Override
    public void responseDatapoolPropertyValue(long l, int n, String string) {
    }

    @Override
    public void datapoolUpdateResult(boolean bl, String string) {
    }
}

