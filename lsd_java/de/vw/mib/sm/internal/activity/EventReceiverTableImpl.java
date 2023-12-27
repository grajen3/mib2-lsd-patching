/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.activity;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.activity.EventReceiverTable;
import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;
import de.vw.mib.sm.internal.activity.EventReceiverTableImpl$ReceiverColumnImpl;

public class EventReceiverTableImpl
implements EventReceiverTable {
    private long freeReceiverIds = -1L;
    private long outReceiverIds = 0L;
    long[] receiverTable;

    public EventReceiverTableImpl(int n) {
        this.receiverTable = new long[n];
    }

    @Override
    public long allocReceiverId() {
        if (this.freeReceiverIds == 0L) {
            ++this.outReceiverIds;
            return -1L;
        }
        long l = EventReceiverTableImpl.highestOneBit(this.freeReceiverIds);
        this.freeReceiverIds &= l ^ 0xFFFFFFFFFFFFFFFFL;
        return l;
    }

    @Override
    public void freeReceiverId(long l) {
        if (l != -1L) {
            this.freeReceiverIds |= l;
        } else {
            --this.outReceiverIds;
        }
    }

    @Override
    public void setColumn(long l, short[] sArray) {
        int n = this.receiverTable.length;
        if (l != -1L) {
            long l2 = l;
            for (int i2 = sArray.length - 1; i2 >= 0; --i2) {
                short s = sArray[i2];
                if (s < 0 || s >= n) continue;
                short s2 = s;
                this.receiverTable[s2] = this.receiverTable[s2] | l2;
            }
        }
    }

    @Override
    public void unsetColumn(long l, short[] sArray) {
        int n = this.receiverTable.length;
        if (l != -1L) {
            long l2 = l ^ 0xFFFFFFFFFFFFFFFFL;
            for (int i2 = sArray.length - 1; i2 >= 0; --i2) {
                short s = sArray[i2];
                if (s < 0 || s >= n) continue;
                short s2 = s;
                this.receiverTable[s2] = this.receiverTable[s2] & l2;
            }
        }
    }

    @Override
    public EventReceiverTable$ReceiverColumn getReceiverColumn(long l) {
        if (l == -1L) {
            return null;
        }
        return new EventReceiverTableImpl$ReceiverColumnImpl(this, l);
    }

    @Override
    public boolean canResponseToCurrentEvent(long l) {
        Preconditions.checkArgument(l != -1L, "InvalidReceiverId not allowed.");
        short s = CurrentHMIEvent.compactId;
        if (s >= 0 && s < this.receiverTable.length) {
            return (this.receiverTable[s] & l) != 0L;
        }
        return false;
    }

    @Override
    public boolean canResponseToCurrentEvent() {
        short s = CurrentHMIEvent.compactId;
        if (s >= 0 && s < this.receiverTable.length) {
            return this.receiverTable[s] != 0L || this.outReceiverIds > 0L;
        }
        return false;
    }

    public static long highestOneBit(long l) {
        long l2 = l;
        l2 |= l2 >> 1;
        l2 |= l2 >> 2;
        l2 |= l2 >> 4;
        l2 |= l2 >> 8;
        l2 |= l2 >> 16;
        l2 |= l2 >> 32;
        return l2 - (l2 >>> 1);
    }
}

