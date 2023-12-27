/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;

public class TraceBackendState {
    private final ITraceBackend backend;
    private final String key;
    private int epoch = 0;
    private boolean connected = false;
    private int msgSeqNum;
    private short id;
    private int flags;

    public TraceBackendState(ITraceBackend iTraceBackend, String string) {
        this.backend = iTraceBackend;
        this.msgSeqNum = 0;
        this.id = (short)-1;
        this.key = string;
        this.flags = iTraceBackend.getFlags();
    }

    public void setId(short s) {
        this.id = s;
    }

    public short getId() {
        return this.id;
    }

    public ITraceBackend getBackend() {
        return this.backend;
    }

    public void setConnected(boolean bl) {
        this.connected = bl;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setEpoch(int n) {
        this.epoch = n;
    }

    public int getEpoch() {
        return this.epoch;
    }

    public int getMsgSeqNum() {
        return this.msgSeqNum;
    }

    public void setMsgSeqNum(int n) {
        this.msgSeqNum = n;
    }

    public String getKey() {
        return this.key;
    }

    public int getFlags() {
        return this.flags;
    }
}

