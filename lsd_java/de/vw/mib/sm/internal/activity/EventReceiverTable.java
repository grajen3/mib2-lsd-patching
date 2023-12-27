/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.activity;

import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;

public interface EventReceiverTable {
    public static final long INVALID_RECEIVER_ID;
    public static final long NULL_RECEIVER_ID;

    default public long allocReceiverId() {
    }

    default public void freeReceiverId(long l) {
    }

    default public void setColumn(long l, short[] sArray) {
    }

    default public void unsetColumn(long l, short[] sArray) {
    }

    default public EventReceiverTable$ReceiverColumn getReceiverColumn(long l) {
    }

    default public boolean canResponseToCurrentEvent(long l) {
    }

    default public boolean canResponseToCurrentEvent() {
    }
}

