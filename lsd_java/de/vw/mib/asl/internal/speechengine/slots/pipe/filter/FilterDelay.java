/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.filter;

import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.DelayPipeFilterRunnable;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotUpdateTransaction;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public abstract class FilterDelay
extends PipeFilter {
    private final Invoker invoker;
    private final TimerManager timerManager;
    static final long MINIMUM_TIMER_IN_MILLISECONDS;
    private final IntObjectMap slotIdTimer;

    public FilterDelay(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, PipeFilter pipeFilter, Invoker invoker, TimerManager timerManager) {
        super(abstractClassifiedLogger, pipeConfig, pipeFilter);
        this.invoker = invoker;
        this.timerManager = timerManager;
        int n = 10;
        this.slotIdTimer = new IntObjectOptHashMap(10);
    }

    @Override
    final boolean applyFilter(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        boolean bl;
        this.applyFilterTriggered(slotList, slotUpdateTransaction);
        int n = slotList.getSlotId();
        boolean bl2 = this.isDelayAlreadyScheduled(n);
        if (bl2) {
            this.updateRunningDelay(n, slotUpdateTransaction);
            bl = false;
        } else if (this.isDelayNeeded(slotList, slotUpdateTransaction)) {
            this.delayUpdateFlow(slotList, slotUpdateTransaction);
            slotUpdateTransaction.appendMessagToLog(" delayed");
            slotUpdateTransaction.log("...");
            bl = false;
        } else {
            slotUpdateTransaction.appendMessagToLog(" no delay");
            bl = true;
        }
        return bl;
    }

    abstract void applyFilterTriggered(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
    }

    abstract boolean isDelayNeeded(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
    }

    private void updateRunningDelay(int n, SlotUpdateTransaction slotUpdateTransaction) {
        Timer timer = (Timer)this.slotIdTimer.get(n);
        DelayPipeFilterRunnable delayPipeFilterRunnable = (DelayPipeFilterRunnable)timer.getRunnable();
        delayPipeFilterRunnable.setup(slotUpdateTransaction);
        slotUpdateTransaction.appendMessagToLog(" old delay->");
        slotUpdateTransaction.appendMessagToLog(timer.getDelay());
    }

    private boolean isDelayAlreadyScheduled(int n) {
        if (this.slotIdTimer.containsKey(n)) {
            Timer timer = (Timer)this.slotIdTimer.get(n);
            return timer.isStarted();
        }
        return false;
    }

    void resumeUpdateFlow(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        int n = slotList.getSlotId();
        if (this.slotIdTimer.containsKey(n)) {
            Timer timer = (Timer)this.slotIdTimer.get(n);
            timer.stop();
            PipeFilter pipeFilter = this.getNextFilter();
            if (pipeFilter != null) {
                pipeFilter.applyAndGoOn(slotList, slotUpdateTransaction);
            } else {
                this.logger.fatal().append("FilterDelay#resumeUpdateFlow(...), but but no successor filter is defined. This is not a valid configuratin.").log();
            }
        } else {
            this.logger.fatal().append("FilterDelay#resumeUpdateFlow(...) called, but timer is not in map anymore.").log();
        }
    }

    private void delayUpdateFlow(SlotList slotList, SlotUpdateTransaction slotUpdateTransaction) {
        int n = slotList.getSlotId();
        Timer timer = this.slotIdTimer.containsKey(n) ? (Timer)this.slotIdTimer.get(n) : this.createTimer(slotList);
        if (this.isScheduleOfTimerNeeded(timer)) {
            this.scheduleTimer(timer, slotUpdateTransaction);
        }
    }

    private boolean isScheduleOfTimerNeeded(Timer timer) {
        if (!timer.isStarted()) {
            return true;
        }
        return this.isRescheduleOfTimerNeeded();
    }

    abstract boolean isRescheduleOfTimerNeeded() {
    }

    private Timer createTimer(SlotList slotList) {
        int n = slotList.getSlotId();
        String string = this.createTimerName(n);
        Timer timer = this.timerManager.createTimer(string);
        DelayPipeFilterRunnable delayPipeFilterRunnable = new DelayPipeFilterRunnable(this, slotList);
        timer.setRunnable(delayPipeFilterRunnable, this.invoker);
        this.slotIdTimer.put(n, timer);
        return timer;
    }

    private String createTimerName(int n) {
        return FilterDelay.createTimerName(this.getPipeConfig().getName(), this.getName(), n);
    }

    private void scheduleTimer(Timer timer, SlotUpdateTransaction slotUpdateTransaction) {
        DelayPipeFilterRunnable delayPipeFilterRunnable = (DelayPipeFilterRunnable)timer.getRunnable();
        delayPipeFilterRunnable.setup(slotUpdateTransaction);
        long l = this.getCheckedDelay();
        timer.setDelay(l);
        timer.start();
        slotUpdateTransaction.appendMessagToLog(" new delay->");
        slotUpdateTransaction.appendMessagToLog(l);
    }

    private long getCheckedDelay() {
        long l = this.getDelayInMilliseconds();
        long l2 = Math.max(l, (long)0);
        return l2;
    }

    abstract long getDelayInMilliseconds() {
    }

    public static String createTimerName(String string, String string2, int n) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append("_");
        stringBuffer.append(string2);
        stringBuffer.append("_");
        stringBuffer.append(String.valueOf(n));
        String string3 = stringBuffer.toString();
        return string3;
    }
}

