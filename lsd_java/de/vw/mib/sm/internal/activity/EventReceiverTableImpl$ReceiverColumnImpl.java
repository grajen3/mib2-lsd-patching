/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.activity;

import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;
import de.vw.mib.sm.internal.activity.EventReceiverTableImpl;

final class EventReceiverTableImpl$ReceiverColumnImpl
implements EventReceiverTable$ReceiverColumn {
    private final long receiverId;
    private int count;
    private final /* synthetic */ EventReceiverTableImpl this$0;

    public EventReceiverTableImpl$ReceiverColumnImpl(EventReceiverTableImpl eventReceiverTableImpl, long l) {
        this.this$0 = eventReceiverTableImpl;
        this.receiverId = l;
        this.count = 0;
    }

    @Override
    public void setCompactEventId(short s) {
        long l;
        long l2;
        if (s >= 0 && s < this.this$0.receiverTable.length && (l2 = this.this$0.receiverTable[s]) != (l = l2 | this.receiverId)) {
            this.this$0.receiverTable[s] = l;
            ++this.count;
        }
    }

    @Override
    public void unsetCompactEventId(short s) {
        long l;
        long l2;
        if (s >= 0 && s < this.this$0.receiverTable.length && (l2 = this.this$0.receiverTable[s]) != (l = l2 & (this.receiverId ^ 0xFFFFFFFFFFFFFFFFL))) {
            this.this$0.receiverTable[s] = l;
            --this.count;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void clear() {
        long l = this.receiverId ^ 0xFFFFFFFFFFFFFFFFL;
        int n = this.this$0.receiverTable.length - 1;
        while (n >= 0) {
            int n2 = n--;
            this.this$0.receiverTable[n2] = this.this$0.receiverTable[n2] & l;
        }
        this.count = 0;
    }

    @Override
    public short[] getCompactEventIds() {
        short[] sArray = new short[this.count];
        int n = 0;
        int n2 = 0;
        while (n < this.count) {
            if ((this.this$0.receiverTable[n2] & this.receiverId) != 0L) {
                sArray[n++] = n2;
            }
            n2 = (short)(n2 + 1);
        }
        return sArray;
    }
}

