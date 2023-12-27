/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.BinaryMessageHeaderCodec$CodecListener;
import de.vw.mib.debugmanager.internal.Log4MibBackend;

class Log4MibBackend$1
implements BinaryMessageHeaderCodec$CodecListener {
    private final long[] timestamps = new long[1];
    private final byte[][] data = new byte[1][];
    private final int[] offsets = new int[1];
    private final int[] lengths = new int[1];
    private final /* synthetic */ Log4MibBackend this$0;

    Log4MibBackend$1(Log4MibBackend log4MibBackend) {
        this.this$0 = log4MibBackend;
    }

    @Override
    public void messageDecoded(short s, byte[] byArray, int n, int n2) {
        this.this$0.callbackDecoderListener.callbackMessageDecoded(s, byArray, n, n2);
    }

    @Override
    public void messageEncoded(long l, byte[] byArray, int n, int n2) {
        this.timestamps[0] = l;
        this.data[0] = byArray;
        this.offsets[0] = n;
        this.lengths[0] = n2;
        this.this$0.debugSpi.writeBinaryMessages(this.timestamps, this.data, this.offsets, this.lengths, 0, 1);
    }
}

