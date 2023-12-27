/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

final class ConnectionClientHandler$WaitingStub {
    private final short stubId;
    private final long startTime;
    private final long timeOut;

    public ConnectionClientHandler$WaitingStub(short s, long l, long l2) {
        this.stubId = s;
        this.startTime = l2;
        this.timeOut = l;
    }

    public boolean isDue(long l) {
        return l - this.startTime >= this.timeOut;
    }

    public short getStubID() {
        return this.stubId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ConnectionClientHandler$WaitingStub connectionClientHandler$WaitingStub = (ConnectionClientHandler$WaitingStub)object;
        return this.stubId == connectionClientHandler$WaitingStub.stubId;
    }

    public int hashCode() {
        return this.stubId;
    }
}

