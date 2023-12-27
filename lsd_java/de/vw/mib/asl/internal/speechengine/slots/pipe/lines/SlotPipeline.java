/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public abstract class SlotPipeline
implements Loggable {
    private final PipeFilter pipeHead;
    private final PipeConfig pipeConfig;
    protected final AbstractClassifiedLogger logger;
    protected final SlotUpdaterParameters paras;
    protected final IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook;

    SlotPipeline(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        this.logger = abstractClassifiedLogger;
        this.pipeConfig = pipeConfig;
        this.paras = slotUpdaterParameters;
        this.isLoadRequestInAcceptedTimeHook = isLoadRequestInAcceptedTimeHook;
        this.pipeHead = this.createPipeline();
        if (abstractClassifiedLogger.isTraceEnabled()) {
            LogMessage logMessage = abstractClassifiedLogger.trace();
            logMessage.append("creating: ");
            logMessage.append(this);
            logMessage.log();
        }
    }

    abstract PipeFilter createPipeline() {
    }

    public void startUpdate(SlotList slotList, SlotEntry[] slotEntryArray) {
        SlotUpdateTransaction slotUpdateTransaction = new SlotUpdateTransaction(this, slotEntryArray);
        this.startUpdateTracing(slotList, slotUpdateTransaction);
        this.pipeHead.applyAndGoOn(slotList, slotUpdateTransaction);
    }

    private void startUpdateTracing(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        slotUpdateTransaction.appendMessagToLog("started(");
        slotUpdateTransaction.appendMessagToLog(slotUpdateTransaction.getTransactionNumber());
        slotUpdateTransaction.appendMessagToLog(") slotId=");
        slotUpdateTransaction.appendMessagToLog(slotList.getSlotId());
    }

    PipeConfig getPipeConfig() {
        return this.pipeConfig;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append(this.getName());
        logMessage.append(":");
        for (PipeFilter pipeFilter = this.pipeHead; pipeFilter != null; pipeFilter = pipeFilter.getNextFilter()) {
            logMessage.append(pipeFilter);
            logMessage.append("|");
        }
        logMessage.append("null");
    }

    final String getName() {
        return this.pipeConfig.getName();
    }

    AbstractClassifiedLogger getLogger() {
        return this.logger;
    }
}

