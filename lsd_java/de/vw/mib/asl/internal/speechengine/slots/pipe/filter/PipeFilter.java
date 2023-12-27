/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.PipeSlotEntryUpdater;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public abstract class PipeFilter
implements Loggable {
    protected final PipeFilter nextFilter;
    private final PipeConfig pipeConfig;
    private final String name;
    protected final AbstractClassifiedLogger logger;

    public PipeFilter(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter) {
        this.logger = abstractClassifiedLogger;
        this.pipeConfig = pipeConfig;
        this.nextFilter = pipeFilter;
        String string = super.getClass().getName();
        this.name = PipeSlotEntryUpdater.convertToUnqualifiedName(string);
    }

    public final PipeFilter getNextFilter() {
        return this.nextFilter;
    }

    public final void applyAndGoOn(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        slotUpdateTransaction.appendMessagToLog("|");
        slotUpdateTransaction.appendMessagToLog(this.getName());
        slotUpdateTransaction.appendMessagToLog("(");
        slotUpdateTransaction.appendMessagToLog(slotUpdateTransaction.getTransactionNumber());
        slotUpdateTransaction.appendMessagToLog(")");
        boolean bl = this.applyFilter(slotList, slotUpdateTransaction);
        if (bl) {
            if (!this.isEndOfPipe()) {
                this.nextFilter.applyAndGoOn(slotList, slotUpdateTransaction);
            } else {
                this.endOfPipeReached(slotUpdateTransaction);
            }
        }
    }

    private void endOfPipeReached(SlotUpdateTransaction slotUpdateTransaction) {
        slotUpdateTransaction.log("|end of pipe reached.");
    }

    abstract boolean applyFilter(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
    }

    public final String getName() {
        return this.name;
    }

    PipeConfig getPipeConfig() {
        return this.pipeConfig;
    }

    @Override
    public final void toString(LogMessage logMessage) {
        logMessage.append(this.getName());
    }

    public boolean isEndOfPipe() {
        return this.nextFilter == null;
    }
}

