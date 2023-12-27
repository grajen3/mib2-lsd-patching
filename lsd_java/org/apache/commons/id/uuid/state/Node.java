/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.util.Arrays;
import org.apache.commons.id.uuid.clock.Clock;
import org.apache.commons.id.uuid.state.StateHelper;

public class Node {
    private byte[] id;
    private short clockSequence;
    private long lastTimestamp;
    private Clock clock;

    public Node(byte[] byArray) {
        this.id = byArray;
        this.clockSequence = StateHelper.newClockSequence();
        this.clock = StateHelper.getClockImpl();
    }

    public Node(byte[] byArray, long l, short s) {
        this.id = byArray;
        this.lastTimestamp = l;
        this.clockSequence = s;
        this.clock = StateHelper.getClockImpl();
    }

    public byte[] getNodeIdentifier() {
        return this.id;
    }

    public short getClockSequence() {
        return this.clockSequence;
    }

    private void incrementClockSequence() {
        this.clockSequence = (short)(this.clockSequence + 1);
        if (this.clockSequence > 16383) {
            this.clockSequence = 0;
        }
    }

    public long getUUIDTime() {
        long l = this.clock.getUUIDTime();
        if (l <= this.lastTimestamp) {
            this.incrementClockSequence();
        }
        this.lastTimestamp = l;
        return l;
    }

    public boolean equals(Object object) {
        if (object instanceof Node) {
            byte[] byArray = ((Node)object).getNodeIdentifier();
            return Arrays.equals(byArray, this.id);
        }
        if (object instanceof byte[]) {
            return Arrays.equals((byte[])object, this.id);
        }
        return false;
    }

    public int hashCode() {
        int n = 0;
        for (int i2 = 0; i2 < this.id.length; ++i2) {
            n += this.id[i2];
        }
        return n;
    }

    public long getLastTimestamp() {
        return this.lastTimestamp;
    }
}

