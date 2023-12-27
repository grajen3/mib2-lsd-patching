/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelay;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;

public class DelayPipeFilterRunnable
implements Runnable {
    private final FilterDelay filterDelay;
    private final SlotList slotUpdateList;
    private SlotUpdateTransaction transaction;

    DelayPipeFilterRunnable(FilterDelay filterDelay, SlotList slotList) {
        this.filterDelay = filterDelay;
        this.slotUpdateList = slotList;
    }

    @Override
    public void run() {
        this.filterDelay.resumeUpdateFlow(this.slotUpdateList, this.transaction);
        this.reset();
    }

    public void setup(SlotUpdateTransaction slotUpdateTransaction) {
        if (this.transaction != null && slotUpdateTransaction != null) {
            this.transaction.appendMessagToLog("|transaction exchanged by (");
            this.transaction.appendMessagToLog(slotUpdateTransaction.getTransactionNumber());
            this.transaction.appendMessagToLog(")");
            this.transaction.log("|end of transaction");
        }
        this.transaction = slotUpdateTransaction;
    }

    private void reset() {
        this.transaction = null;
    }
}

