/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

public interface ILoggerDataMessage {
    default public long getLoggerTimeStamp() {
    }

    default public short getLoggerDataType() {
    }

    default public short getLoggerMessageType() {
    }

    default public byte[] getLoggerMessageData() {
    }
}

