/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.impl.TimedEventServer;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerException;
import java.util.ArrayList;

final class TimedEvent
implements PooledObject,
Runnable {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    int receiverEventId;
    int receiverTargetId;
    private EventGeneric template;
    private final Timer timer;
    private final TimedEventServer timerServer;
    private ArrayList additionalTimedEvents;
    private boolean active;
    private boolean suspended = false;
    private boolean disposed = false;
    private TimedEvent parent;

    TimedEvent(TimedEventServer timedEventServer) {
        this.timerServer = timedEventServer;
        this.timer = ServiceManager.mTimerManager.createTimer("TimedEvent");
        this.timer.setRunnable(this, Timer.TIMER_THREAD_INVOKER);
    }

    @Override
    public void backToPool() {
        if (this.timer != null && this.timer.isStarted()) {
            this.timer.stop();
        }
        if (this.template != null) {
            ServiceManager.mEventFactory.freeEvent(this.template);
            this.template = null;
        }
        this.parent = null;
        this.additionalTimedEvents = null;
    }

    @Override
    public void run() {
        if (this.disposed) {
            logger.warn(2).append("Won't execute timer for TimedEvent [targetId=").append(this.receiverTargetId).append("][eventId=").append(this.receiverEventId).append("]! Timer has already been stopped!").log();
            return;
        }
        this.active = this.timer.isRepeat();
        EventGeneric eventGeneric = this.template != null ? ServiceManager.mEventFactory.newEvent(this.template) : ServiceManager.mEventFactory.newEvent();
        eventGeneric.setSenderTargetId(5001);
        eventGeneric.setReceiverTargetId(this.receiverTargetId);
        eventGeneric.setReceiverEventId(this.receiverEventId);
        if (!this.active) {
            if (this.parent != null) {
                this.parent.removeAdditionalTimedEvent(this);
                this.timerServer.release(this);
            } else if (this.additionalTimedEvents == null || this.additionalTimedEvents.isEmpty()) {
                this.timerServer.release(this);
            }
        }
        try {
            ServiceManager.mEventContext.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            logger.error(2).append("Error sending timed event: ").append(eventGeneric).attachThrowable(genericEventException).log();
        }
    }

    void addAdditionalTimedEvent(TimedEvent timedEvent) {
        if (this.additionalTimedEvents == null) {
            this.additionalTimedEvents = new ArrayList();
        }
        timedEvent.parent = this;
        this.additionalTimedEvents.add(timedEvent);
    }

    private void removeAdditionalTimedEvent(TimedEvent timedEvent) {
        if (this.additionalTimedEvents == null) {
            if (!this.active) {
                this.timerServer.release(this);
            }
        } else {
            this.additionalTimedEvents.remove(timedEvent);
            if (this.additionalTimedEvents.isEmpty() && !this.active) {
                this.timerServer.release(this);
            }
        }
    }

    void dispose() {
        this.disposed = true;
        if (this.additionalTimedEvents != null && !this.additionalTimedEvents.isEmpty()) {
            for (int i2 = 0; i2 < this.additionalTimedEvents.size(); ++i2) {
                this.timerServer.release((TimedEvent)this.additionalTimedEvents.get(i2));
            }
            this.additionalTimedEvents.clear();
        }
        this.timerServer.release(this);
    }

    void init(int n, int n2, long l, boolean bl, EventGeneric eventGeneric) {
        this.receiverTargetId = n;
        this.receiverEventId = n2;
        this.template = eventGeneric;
        this.active = true;
        this.disposed = false;
        this.timer.setName(new StringBuffer().append("TimedEvent-[").append(n).append(".").append(n2).append("]").toString());
        this.timer.setDelay(l);
        this.timer.setRepeat(bl);
        this.timer.start();
    }

    boolean restart() {
        if (this.disposed) {
            logger.warn(2).append("Couldn't restart timer for TimedEvent [targetId=").append(this.receiverTargetId).append("][eventId=").append(this.receiverEventId).append("]! Timer has already been stopped!").log();
            return false;
        }
        if (this.active) {
            try {
                this.timer.setDelayFromNow(this.timer.getDelay());
                return true;
            }
            catch (TimerException timerException) {
                logger.warn(2).append("Couldn't restart timer for TimedEvent [targetId=").append(this.receiverTargetId).append("][eventId=").append(this.receiverEventId).append("]! Timer has already been executed!").log();
                return false;
            }
        }
        if (this.additionalTimedEvents != null && !this.additionalTimedEvents.isEmpty()) {
            return ((TimedEvent)this.additionalTimedEvents.get(0)).restart();
        }
        logger.warn(2).append("Couldn't restart timer for TimedEvent [targetId=").append(this.receiverTargetId).append("][eventId=").append(this.receiverEventId).append("]! All timers were already executed!").log();
        return false;
    }

    void resume() {
        if (this.suspended) {
            this.timer.resume();
            this.suspended = false;
        }
    }

    void suspend() {
        this.timer.suspend();
        this.suspended = true;
    }

    boolean isSuspended() {
        return this.suspended;
    }
}

