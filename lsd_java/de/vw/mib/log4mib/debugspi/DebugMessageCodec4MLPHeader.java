/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.debugspi;

import de.vw.mib.log4mib.debugspi.DebugMessageCodec4MLPHeaderListener;
import java.io.EOFException;
import java.io.IOException;

public final class DebugMessageCodec4MLPHeader {
    public static final int HEADER_LENGTH;
    private static final int INTERNAL_HEADER_CODEC_VERSION_FIELD;
    private static final int INTERNAL_HEADER_TYPE_FIELD_0;
    private static final int INTERNAL_HEADER_TYPE_FIELD_1;
    private static final byte INTERNAL_HEADER_CODEC_VERSION;
    private final DebugMessageCodec4MLPHeaderListener listener;

    public DebugMessageCodec4MLPHeader(DebugMessageCodec4MLPHeaderListener debugMessageCodec4MLPHeaderListener) {
        this.listener = debugMessageCodec4MLPHeaderListener;
    }

    public void readFromDebugSPI(byte[] byArray) {
        if (byArray.length < 5) {
            throw new IOException("Received message body is to short for an MLP-Encoded message");
        }
        byte by = this.getCodecVersion(byArray);
        if (by != -1) {
            throw new IOException(new StringBuffer().append("Internal header codec version does not match. Encoder version: ").append(by).append(" | Decoder version: ").append(-1).toString());
        }
        this.messageComplete(this.getInternalType(byArray), byArray, 5, byArray.length - 5);
    }

    private void messageComplete(short s, byte[] byArray, int n, int n2) {
        this.listener.informCallbackListener(s, byArray, 5, n2);
    }

    public void writeCompleteDebugMessage(long l, short s, byte[] byArray, int n) {
        this.setCodecVersion(byArray);
        this.setInternalType(s, byArray);
        this.listener.writeBinaryLogMessageToDebugSPI(l, byArray, 0, n);
    }

    private void setInternalType(short s, byte[] byArray) {
        byArray[1] = (byte)(s >> 8);
        byArray[2] = (byte)s;
    }

    private short getInternalType(byte[] byArray) {
        int n = byArray[1] & 0xFF;
        int n2 = byArray[2] & 0xFF;
        if ((n | n2) >= 0) {
            return (short)((n << 8) + n2);
        }
        throw new EOFException();
    }

    private void setCodecVersion(byte[] byArray) {
        byArray[0] = -1;
    }

    private byte getCodecVersion(byte[] byArray) {
        return byArray[0];
    }
}

