/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class FilterAdd
extends PipeFilter {
    public FilterAdd(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter);
    }

    @Override
    boolean applyFilter(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        slotList.add(slotUpdateTransaction.getNewSlotEntries());
        return true;
    }
}

