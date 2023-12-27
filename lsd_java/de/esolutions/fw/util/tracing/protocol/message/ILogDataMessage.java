/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

public interface ILogDataMessage {
    default public long getTimeStamp() {
    }

    default public short getLevel() {
    }

    default public short getModifiers() {
    }

    default public int getChannelID() {
    }

    default public int getSourceID() {
    }

    default public short getLogType() {
    }

    default public byte[] getLogData() {
    }
}

