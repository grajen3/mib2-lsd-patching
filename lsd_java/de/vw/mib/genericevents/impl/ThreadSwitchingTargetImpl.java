/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

public class ThreadSwitchingTargetImpl
implements ThreadSwitchingTarget {
    private static final int EV_LOCAL_CALLBACK;
    private static final int EV_LOCAL_CALLBACK_SLOT_RUNNABLE;
    private final GenericEvents eventContext;
    private int targetId;
    private final TaskInterface task;

    public ThreadSwitchingTargetImpl(GenericEvents genericEvents, TaskInterface taskInterface) {
        this.eventContext = genericEvents;
        this.task = taskInterface;
    }

    @Override
    public GenericEvents getMainObject() {
        return this.eventContext;
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void setTargetId(int n) {
        this.targetId = n;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 100000: {
                this.onEventCallback(eventGeneric);
                break;
            }
        }
    }

    private void onEventCallback(EventGeneric eventGeneric) {
        Runnable runnable = (Runnable)eventGeneric.getObject(0);
        runnable.run();
    }

    @Override
    public void enqueue(Runnable runnable) {
        EventGeneric eventGeneric = this.eventContext.getEventFactory().newEvent();
        eventGeneric.setReceiverTargetId(this.targetId);
        eventGeneric.setReceiverEventId(-1601830656);
        eventGeneric.setObject(0, runnable);
        this.eventContext.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void invoke(Runnable runnable) {
        this.enqueue(runnable);
    }

    @Override
    public boolean isThreadChangeNecessary() {
        return !this.task.isInCurrentMIBThread();
    }
}

