/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

public interface ITraceMessage {
    default public long getTimeStamp() {
    }

    default public short getLevel() {
    }

    default public short getModifiers() {
    }

    default public int getChannelID() {
    }

    default public int getThreadID() {
    }

    default public short getMessageType() {
    }

    default public String[] getDecodedMessage() {
    }

    default public String getMessageString() {
    }

    default public int getMessageSize() {
    }

    default public byte[] getMessageData() {
    }

    default public void setEpoch(int n) {
    }

    default public int getEpoch() {
    }

    default public void setSeqNum(int n) {
    }

    default public int getSeqNum() {
    }

    default public void expandNow() {
    }

    default public void setChannelID(int n) {
    }

    default public void setThreadID(int n) {
    }

    default public void setDecodedMessage(String[] stringArray) {
    }

    default public void setTimeStamp(long l) {
    }
}

