/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelay;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.TimerManager;

public class FilterDelayStatic
extends FilterDelay {
    public FilterDelayStatic(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter, Invoker invoker, TimerManager timerManager) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter, invoker, timerManager);
    }

    @Override
    void applyFilterTriggered(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
    }

    @Override
    boolean isDelayNeeded(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        return true;
    }

    @Override
    long getDelayInMilliseconds() {
        return this.getPipeConfig().getFullUpdateFrequency();
    }

    @Override
    boolean isRescheduleOfTimerNeeded() {
        return false;
    }
}

