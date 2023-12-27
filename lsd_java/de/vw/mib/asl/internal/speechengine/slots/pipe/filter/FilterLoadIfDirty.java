/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class FilterLoadIfDirty
extends PipeFilter {
    public FilterLoadIfDirty(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter);
    }

    @Override
    boolean applyFilter(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        if (slotList.isDirty()) {
            slotList.load();
            slotUpdateTransaction.appendMessagToLog(" load");
        } else {
            slotUpdateTransaction.appendMessagToLog(" no load");
        }
        return true;
    }
}

