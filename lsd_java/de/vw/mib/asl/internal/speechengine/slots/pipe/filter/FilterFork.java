/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class FilterFork
extends PipeFilter {
    private final PipeFilter secondNextFilter;

    public FilterFork(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter, PipeFilter pipeFilter2) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter);
        this.secondNextFilter = pipeFilter2;
    }

    @Override
    boolean applyFilter(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        if (this.secondNextFilter != null) {
            SlotUpdateTransaction slotUpdateTransaction2 = slotUpdateTransaction.fork();
            slotUpdateTransaction.appendMessagToLog(" create(");
            slotUpdateTransaction.appendMessagToLog(slotUpdateTransaction2.getTransactionNumber());
            slotUpdateTransaction.appendMessagToLog(")");
            slotUpdateTransaction.log("...");
            slotUpdateTransaction2.appendMessagToLog("forking(");
            slotUpdateTransaction2.appendMessagToLog(slotUpdateTransaction2.getTransactionNumber());
            slotUpdateTransaction2.appendMessagToLog(") slotId=");
            slotUpdateTransaction2.appendMessagToLog(slotList.getSlotId());
            this.secondNextFilter.applyAndGoOn(slotList, slotUpdateTransaction2);
        }
        return true;
    }
}

