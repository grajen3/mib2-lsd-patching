/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

import de.vw.mib.debug.spi.messages.CRCByteArrayWriter;
import de.vw.mib.debug.spi.messages.DebugSPI_Header;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodecListener;
import java.io.DataInputStream;

public abstract class DebugSPI_HeaderCodec
extends CRCByteArrayWriter
implements DebugSPI_Header {
    protected final DebugSPI_HeaderCodecListener listener;

    public DebugSPI_HeaderCodec(DebugSPI_HeaderCodecListener debugSPI_HeaderCodecListener) {
        this.listener = debugSPI_HeaderCodecListener;
    }

    public abstract void decode(DataInputStream dataInputStream) {
    }

    public byte[] encode(int n, short s, byte[] byArray, int n2) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }

    public byte[] encode(long l, byte[] byArray, int n, int n2) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }

    public byte[] encode(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }

    public byte[] encode(long l, int n, int n2, int n3, int n4, byte[] byArray, int n5) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }

    public byte[] encode(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
        throw new UnsupportedOperationException("Not supported in this implementation.");
    }
}

