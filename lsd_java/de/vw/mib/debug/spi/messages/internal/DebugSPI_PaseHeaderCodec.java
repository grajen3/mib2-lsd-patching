/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages.internal;

import de.vw.mib.debug.spi.messages.DebugSPI_Header;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodec;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderCodecListener;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderException;
import de.vw.mib.debug.spi.messages.SyncMarkerHelper;
import java.io.DataInputStream;
import java.io.EOFException;

public final class DebugSPI_PaseHeaderCodec
extends DebugSPI_HeaderCodec
implements DebugSPI_Header {
    private static final byte[] PASE_SYNC_MARKER = new byte[]{3, 4, 5};
    private static final int SYNC_MARKER_COUNT = PASE_SYNC_MARKER.length;
    private static final long SYNC_MARKER_CLEAR_MASK = SyncMarkerHelper.calculateClearMask(PASE_SYNC_MARKER);
    private static final long SYNC_MARKER_MASK = SyncMarkerHelper.calculateExpectedMask(PASE_SYNC_MARKER);

    public DebugSPI_PaseHeaderCodec(DebugSPI_HeaderCodecListener debugSPI_HeaderCodecListener) {
        super(debugSPI_HeaderCodecListener);
    }

    @Override
    public void decode(DataInputStream dataInputStream) {
        if (SyncMarkerHelper.matchesSyncMarker(SYNC_MARKER_COUNT, SYNC_MARKER_MASK, SYNC_MARKER_CLEAR_MASK, dataInputStream) == -1) {
            throw new EOFException();
        }
        dataInputStream.readByte();
        dataInputStream.skipBytes(4);
        int n = this.readInt(dataInputStream);
        dataInputStream.skipBytes(8);
        short s = this.readShort(dataInputStream);
        int n2 = this.readShort(dataInputStream) & 0xFFFF0000;
        byte[] byArray = this.readBody(dataInputStream, n2);
        if (this.listener != null) {
            this.listener.messageDecoded(n, s, byArray);
        }
    }

    private byte[] readBody(DataInputStream dataInputStream, int n) {
        try {
            int n2;
            if (n > 1000) {
                throw new DebugSPI_HeaderException(new StringBuffer().append("Message body is corrupt! Length (").append(n).append(") exceeds max message length!").toString());
            }
            int n3 = n;
            byte[] byArray = new byte[n3];
            for (int i2 = n3; i2 > 0; i2 -= n2) {
                n2 = dataInputStream.read(byArray, n3 - i2, i2);
                if (n2 >= 0) continue;
                throw new EOFException();
            }
            return byArray;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new DebugSPI_HeaderException(new StringBuffer().append("Message body is corrupt! The declared length (").append(n).append(") doesn't match to the received message! ").append(arrayIndexOutOfBoundsException.getMessage()).toString());
        }
    }

    @Override
    public byte[] encode(int n, short s, byte[] byArray, int n2) {
        this.reset();
        this.writeByte(PASE_SYNC_MARKER[0]);
        this.writeByte(PASE_SYNC_MARKER[1]);
        this.writeByte(PASE_SYNC_MARKER[2]);
        this.writeByte(1);
        this.writeLittleEndianInt(0);
        this.writeLittleEndianInt(n);
        this.writeLittleEndianLong(0L);
        this.writeLittleEndianShort(s);
        this.writeLittleEndianShort(n2);
        this.write(byArray, n2);
        return this.toByteArray();
    }

    private int readInt(DataInputStream dataInputStream) {
        int n = dataInputStream.read();
        int n2 = dataInputStream.read();
        int n3 = dataInputStream.read();
        int n4 = dataInputStream.read();
        if ((n4 | n3 | n2 | n) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }

    private short readShort(DataInputStream dataInputStream) {
        int n = dataInputStream.read();
        int n2 = dataInputStream.read();
        if ((n2 | n) >= 0) {
            return (short)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    private void writeLittleEndianInt(int n) {
        byte by = (byte)(n >> 24);
        byte by2 = (byte)(n >> 16);
        byte by3 = (byte)(n >> 8);
        byte by4 = (byte)n;
        this.writeByte(by4);
        this.writeByte(by3);
        this.writeByte(by2);
        this.writeByte(by);
    }

    private void writeLittleEndianLong(long l) {
        this.writeLittleEndianInt((int)(l >> 32));
        this.writeLittleEndianInt((int)l);
    }

    private void writeLittleEndianShort(int n) {
        byte by = (byte)(n >> 8);
        byte by2 = (byte)n;
        this.writeByte(by2);
        this.writeByte(by);
    }
}

