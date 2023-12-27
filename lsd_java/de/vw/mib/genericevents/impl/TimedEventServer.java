/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.SyncLongObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.impl.TimedEvent;
import de.vw.mib.genericevents.impl.TimedEventServer$1;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

final class TimedEventServer
implements TimerServer {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private static final long MINIMUM_DELAY = Long.getLong("de.vw.mib.genericevents.timer.warn.minimumdelay", 0);
    private static final long NO_DELAY_REPLACEMENT = Long.getLong("de.vw.mib.genericevents.timer.nodelay.replacement", 0);
    private static final long SHORT_DELAY_FACTOR = Long.getLong("de.vw.mib.genericevents.timer.shortdelay.factor", 0);
    private final ObjectPool timedEventPool = new TimedEventServer$1(this, 100);
    private final LongObjectMap timedEvents = new SyncLongObjectOptHashMap(new LongObjectOptHashMap());

    TimedEventServer() {
    }

    @Override
    public boolean isTimerActive(int n, int n2) {
        return this.timedEvents.containsKey(this.getKey(n, n2));
    }

    @Override
    public boolean isTimerSuspended(int n, int n2) {
        TimedEvent timedEvent = this.getTimedEvent(n, n2);
        return timedEvent != null && timedEvent.isSuspended();
    }

    @Override
    public void restartOrStartTimedEvent(EventGeneric eventGeneric, long l, boolean bl) {
        if (eventGeneric == null) {
            logger.error(2).append("Couldn't restart or start timer for TimedEvent! EventGeneric is null!").attachThrowable(new NullPointerException()).log();
            return;
        }
        if (this.restartTimer(eventGeneric.getReceiverTargetId(), eventGeneric.getReceiverEventId())) {
            ServiceManager.mEventFactory.freeEvent(eventGeneric);
            return;
        }
        this.startTimer(eventGeneric.getReceiverTargetId(), eventGeneric.getReceiverEventId(), eventGeneric, l, bl, false, true);
    }

    @Override
    public void restartOrStartTimedEvent(int n, int n2, long l, boolean bl) {
        if (this.restartTimer(n, n2)) {
            return;
        }
        this.startTimer(n, n2, null, l, bl, false, true);
    }

    @Override
    public void restartTimedEvent(int n, int n2) {
        this.restartTimer(n, n2);
    }

    @Override
    public void resumeTimedEvent(int n, int n2) {
        TimedEvent timedEvent = this.getTimedEvent(n, n2);
        if (timedEvent == null || !timedEvent.isSuspended()) {
            logger.warn(2).append("Couldn't resume timer for TimedEvent [targetId=").append(n).append("][eventId=").append(n2).append("]: No suspended timer found!").log();
            return;
        }
        timedEvent.resume();
        logger.info(2).append("Timer for TimedEvent [targetId=").append(n).append("][eventId=").append(n2).append("] resumed!").log();
    }

    @Override
    public void sendTimedEvent(EventGeneric eventGeneric, long l, boolean bl) {
        this.sendTimedEvent(eventGeneric, l, bl, false);
    }

    @Override
    public void sendTimedEvent(EventGeneric eventGeneric, long l, boolean bl, boolean bl2) {
        if (eventGeneric == null) {
            logger.error(2).append("Couldn't start timer for TimedEvent! EventGeneric is null!").attachThrowable(new NullPointerException()).log();
            return;
        }
        this.startTimer(eventGeneric.getReceiverTargetId(), eventGeneric.getReceiverEventId(), eventGeneric, l, bl, bl2, false);
    }

    @Override
    public void sendTimedEvent(int n, int n2, long l, boolean bl) {
        this.startTimer(n, n2, null, l, bl, false, false);
    }

    @Override
    public void stopTimedEvent(int n, int n2) {
        this.stopAllTimers(n, n2);
    }

    @Override
    public void suspendTimedEvent(int n, int n2) {
        TimedEvent timedEvent = this.getTimedEvent(n, n2);
        if (timedEvent == null) {
            logger.warn(2).append("Couldn't suspend timer for TimedEvent [targetId=").append(n).append("][eventId=").append(n2).append("]: No active timer found!").log();
            return;
        }
        timedEvent.suspend();
        logger.info(2).append("Timer for TimedEvent [targetId=").append(n).append("][eventId=").append(n2).append("] suspended!").log();
    }

    void release(TimedEvent timedEvent) {
        long l = this.getKey(timedEvent.receiverTargetId, timedEvent.receiverEventId);
        TimedEvent timedEvent2 = (TimedEvent)this.timedEvents.get(l);
        if (timedEvent2 == timedEvent) {
            this.timedEvents.remove(l);
        }
        this.timedEventPool.releaseObject(timedEvent);
    }

    private TimedEvent createTimedEvent(int n, int n2, EventGeneric eventGeneric, long l, boolean bl) {
        TimedEvent timedEvent = (TimedEvent)this.timedEventPool.borrowObject();
        timedEvent.init(n, n2, l, bl, eventGeneric);
        return timedEvent;
    }

    private long getKey(int n, int n2) {
        long l = n;
        return (l <<= 32) + (long)n2;
    }

    private TimedEvent getTimedEvent(int n, int n2) {
        return (TimedEvent)this.timedEvents.get(this.getKey(n, n2));
    }

    private boolean restartTimer(int n, int n2) {
        TimedEvent timedEvent = this.getTimedEvent(n, n2);
        if (timedEvent == null) {
            return false;
        }
        return timedEvent.restart();
    }

    private void startTimer(int n, int n2, EventGeneric eventGeneric, long l, boolean bl, boolean bl2, boolean bl3) {
        TimedEvent timedEvent;
        if (n == 0 || n2 == 0) {
            logger.error(2).append("startTimer with invalid arguments [targetId=").append(n).append("][eventId=").append(n2).append("]").log();
            return;
        }
        if (l < MINIMUM_DELAY) {
            long l2 = l <= 0L ? NO_DELAY_REPLACEMENT : l * SHORT_DELAY_FACTOR;
            logger.error(2).append("The delay for timed event [").append(n).append(".").append(n2).append("] is invalid/too short! Timeout: ").append(l).append("ms. Using a delay of ").append(l2).append("ms instead!").attachThrowable(new Exception("Invalid timeout!")).log();
            l = l2;
        }
        if ((timedEvent = this.getTimedEvent(n, n2)) == null) {
            TimedEvent timedEvent2 = this.createTimedEvent(n, n2, eventGeneric, l, bl);
            this.timedEvents.put(this.getKey(n, n2), timedEvent2);
        } else if (bl3) {
            logger.warn(2).append("Another timer for TimedEvent [targetId=").append(n).append("][eventId=").append(n2).append("] was still in the TimedEventServer's map! Stopping the old timer and starting a new one ...").log();
            timedEvent.dispose();
            TimedEvent timedEvent3 = this.createTimedEvent(n, n2, eventGeneric, l, bl);
            this.timedEvents.put(this.getKey(n, n2), timedEvent3);
        } else if (bl2) {
            TimedEvent timedEvent4 = this.createTimedEvent(n, n2, eventGeneric, l, bl);
            timedEvent.addAdditionalTimedEvent(timedEvent4);
        } else {
            logger.warn(2).append("Couldn't start timer for TimedEvent: Timer has already been started [targetId=").append(n).append("][eventId=").append(n2).append("]").log();
        }
    }

    private void stopAllTimers(int n, int n2) {
        TimedEvent timedEvent = (TimedEvent)this.timedEvents.remove(this.getKey(n, n2));
        if (timedEvent == null) {
            return;
        }
        timedEvent.dispose();
    }
}

