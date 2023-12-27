/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;

public class SlotUpdateTransaction {
    private final SlotEntry[] newEntries;
    private final int transactionNumber;
    private final StringBuilder logMessageBuilder;
    private static int transactionCounter = 0;
    private final SlotPipeline pipe;

    SlotUpdateTransaction(SlotPipeline slotPipeline, SlotEntry[] slotEntryArray) {
        this.pipe = slotPipeline;
        this.newEntries = slotEntryArray;
        this.transactionNumber = transactionCounter++;
        this.logMessageBuilder = slotPipeline.getLogger().isTraceEnabled() ? new StringBuilder() : null;
    }

    public SlotUpdateTransaction fork() {
        return new SlotUpdateTransaction(this.pipe, this.newEntries);
    }

    public SlotEntry[] getNewSlotEntries() {
        return this.newEntries;
    }

    public void appendMessagToLog(String string) {
        if (this.isTracingInitialized()) {
            this.logMessageBuilder.append(string);
        }
    }

    public void appendMessagToLog(long l) {
        if (this.isTracingInitialized()) {
            this.logMessageBuilder.append(l);
        }
    }

    public void appendMessagToLog(int n) {
        if (this.isTracingInitialized()) {
            this.logMessageBuilder.append(n);
        }
    }

    public void log(String string) {
        if (this.isTracingInitialized() && this.pipe.getLogger().isTraceEnabled()) {
            LogMessage logMessage = this.pipe.getLogger().trace();
            logMessage.append(this.logMessageBuilder.toString());
            logMessage.append(string);
            logMessage.log();
        }
    }

    private boolean isTracingInitialized() {
        return this.logMessageBuilder != null;
    }

    public int getTransactionNumber() {
        return this.transactionNumber;
    }
}

