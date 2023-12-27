/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelay;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.TimerManager;

public class FilterDelayDynamic
extends FilterDelay {
    private final Framework4U framework4u;
    private final IntLongMap slotIdTimestamp;
    private long lastTimestamp;
    private long currentTimestamp;
    private boolean isFirstLoadRequest;
    private long elapsedTimeMillis;
    private final IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook;

    public FilterDelayDynamic(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter, Invoker invoker, TimerManager timerManager, Framework4U framework4U, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter, invoker, timerManager);
        this.framework4u = framework4U;
        this.isLoadRequestInAcceptedTimeHook = isLoadRequestInAcceptedTimeHook;
        int n = 10;
        this.slotIdTimestamp = new IntLongOptHashMap(10);
    }

    @Override
    void applyFilterTriggered(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        int n = slotList.getSlotId();
        this.currentTimestamp = this.framework4u.system.currentTimeMillis();
        this.isFirstLoadRequest = this.isFirstLoadRequest(n, this.currentTimestamp);
        this.lastTimestamp = this.slotIdTimestamp.get(n);
        this.slotIdTimestamp.put(n, this.currentTimestamp);
    }

    private boolean isFirstLoadRequest(int n, long l) {
        return !this.slotIdTimestamp.containsKey(n);
    }

    @Override
    boolean isDelayNeeded(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        if (this.isFirstLoadRequest) {
            return false;
        }
        this.elapsedTimeMillis = this.currentTimestamp - this.lastTimestamp;
        return !this.isLoadRequestInAcceptedTime();
    }

    private boolean isLoadRequestInAcceptedTime() {
        boolean bl = this.elapsedTimeMillis > this.getPipeConfig().getAllowedGapInMilliseconds();
        boolean bl2 = this.isLoadRequestInAcceptedTimeHook.hook(bl);
        return bl2;
    }

    @Override
    long getDelayInMilliseconds() {
        long l = this.getPipeConfig().getAllowedGapInMilliseconds() - this.elapsedTimeMillis;
        return l;
    }

    @Override
    boolean isRescheduleOfTimerNeeded() {
        return false;
    }
}

