/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages.internal;

import de.vw.mib.debug.spi.messages.CRCInputStreamWrapper;
import de.vw.mib.debug.spi.messages.DebugSPI_Header;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodec;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodecListener;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderException;
import de.vw.mib.debug.spi.messages.SyncMarkerHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;

public final class DebugSPI_MLPHeaderCodec
extends DebugSPI_HeaderCodec
implements DebugSPI_Header {
    private static final byte PADDING;
    private static final byte TYPE_TEXT_MESSAGE;
    private static final byte TYPE_VW_BINARY_MESSAGE;
    private static final int MLP_HEADER_LENGTH;
    private static final int TEXT_HEADER_LENGTH;
    private final CRCInputStreamWrapper inputStreamReader = new CRCInputStreamWrapper();
    public static final byte[] MLP_SYNC_MARKER;
    private static final int SYNC_MARKER_COUNT;
    private static final long SYNC_MARKER_CLEAR_MASK;
    private static final long SYNC_MARKER_MASK;

    public DebugSPI_MLPHeaderCodec(DebugSPI_HeaderCodecListener debugSPI_HeaderCodecListener) {
        super(debugSPI_HeaderCodecListener);
    }

    @Override
    public void decode(DataInputStream dataInputStream) {
        this.inputStreamReader.reset(dataInputStream);
        if (SyncMarkerHelper.matchesSyncMarker(SYNC_MARKER_COUNT, SYNC_MARKER_MASK, SYNC_MARKER_CLEAR_MASK, dataInputStream) == -1) {
            throw new EOFException();
        }
        int n = this.inputStreamReader.readCRC();
        long l = this.inputStreamReader.readLong();
        byte by = this.inputStreamReader.readByte();
        this.inputStreamReader.skip(1L);
        byte[] byArray = new byte[this.inputStreamReader.readInt()];
        this.inputStreamReader.readBody(byArray);
        if (this.inputStreamReader.getCalculatedCRC() != n) {
            throw new DebugSPI_HeaderException("Checksums did`n match.");
        }
        if (this.listener != null && 1 == by) {
            this.listener.messageDecoded(l, byArray);
        }
    }

    @Override
    public byte[] encode(long l, byte[] byArray, int n, int n2) {
        this.reset();
        this.appendGlobalHeaderPart(n2);
        this.appendMLPBinaryMessageHeader(l);
        this.appendInt(n2);
        this.appendBody(byArray, n, n2);
        return this.finish();
    }

    private void appendBody(byte[] byArray, int n, int n2) {
        this.appendByteArray(byArray, n, n2);
    }

    private void appendMLPBinaryMessageHeader(long l) {
        this.beginCRCCalculation();
        this.appendLong(l);
        this.appendByte((byte)1);
        this.appendByte((byte)-1);
    }

    private void appendGlobalHeaderPart(int n) {
        this.appendInt(n + 26 - 4);
        this.appendByte(MLP_SYNC_MARKER[0]);
        this.appendByte(MLP_SYNC_MARKER[1]);
        this.appendByte(MLP_SYNC_MARKER[2]);
        this.appendByte(MLP_SYNC_MARKER[3]);
    }

    @Override
    public byte[] encode(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
        int n3 = n + n2;
        if (lArray.length < n3 || byArray.length < n3 || nArray.length < n3 || nArray2.length < n3) {
            throw new IllegalArgumentException("Not enough messages for setted offset and length");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = n; i2 < n2 + n; ++i2) {
            byte[] byArray2 = this.encode(lArray[i2], byArray[i2], nArray[i2], nArray2[i2]);
            byteArrayOutputStream.write(byArray2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] encode(long l, int n, int n2, int n3, int n4, byte[] byArray, int n5) {
        this.reset();
        int n6 = byArray.length;
        this.appendGlobalHeaderPart(n6 + 14);
        this.appendTextMessageHeader(l, n, n2, n3, n4, n5, n6);
        this.appendBody(byArray, 0, n6);
        return this.finish();
    }

    private void appendTextMessageHeader(long l, int n, int n2, int n3, int n4, int n5, int n6) {
        this.beginCRCCalculation();
        this.appendLong(l);
        this.appendByte((byte)0);
        this.appendByte((byte)-1);
        this.appendInt(n6 + 14);
        this.appendByte((byte)1);
        this.appendByte((byte)1);
        this.appendShort((short)n2);
        this.appendShort((short)n3);
        this.appendInt(n4);
        this.appendByte((byte)n);
        this.appendByte((byte)n5);
        this.appendShort((short)n6);
    }

    @Override
    public byte[] encode(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
        int n3 = n + n2;
        if (lArray.length < n3 || nArray.length < n3 || nArray2.length < n3 || nArray3.length < n3 || nArray4.length < n3 || byArray.length < n3 || nArray5.length < n3) {
            throw new IllegalArgumentException("Not enough messages for setted offset and length");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = n; i2 < n2 + n; ++i2) {
            byte[] byArray2 = this.encode(lArray[i2], nArray[i2], nArray2[i2], nArray3[i2], nArray4[i2], byArray[i2], nArray5[i2]);
            byteArrayOutputStream.write(byArray2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    static {
        MLP_SYNC_MARKER = new byte[]{-128, 77, 76, 80};
        SYNC_MARKER_COUNT = MLP_SYNC_MARKER.length;
        SYNC_MARKER_CLEAR_MASK = SyncMarkerHelper.calculateClearMask(MLP_SYNC_MARKER);
        SYNC_MARKER_MASK = SyncMarkerHelper.calculateExpectedMask(MLP_SYNC_MARKER);
    }
}

