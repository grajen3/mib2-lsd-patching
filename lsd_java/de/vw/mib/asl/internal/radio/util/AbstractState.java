/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.util.StateMachineOwner;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class AbstractState
extends AbstractHsmState {
    protected final StateMachineOwner mOwner;
    private boolean mTimeoutRunning;
    static final int P0_CURRENT_STATE;

    public AbstractState(StateMachineOwner stateMachineOwner, String string, HsmState hsmState) {
        super(stateMachineOwner.getHsm(), string, hsmState);
        this.mOwner = stateMachineOwner;
    }

    public abstract long getTimeout() {
    }

    protected void onTimeout() {
        ServiceManager.logger.error(128, new StringBuffer().append("DSI Timeout: after ").append(this.getTimeout()).append(" ms for state ").append(this.getName()).toString());
        this.sendAnswer();
        this.trans(this.mOwner.getIdleState());
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (eventGeneric.getReceiverEventId() == this.mOwner.getTimeoutEventId()) {
            if (eventGeneric.getObject(0) == this) {
                this.mTimeoutRunning = false;
                this.onTimeout();
            }
        } else {
            switch (eventGeneric.getReceiverEventId()) {
                case 2: {
                    this.startTimeout();
                    break;
                }
                case 4: {
                    this.sendAnswer();
                    this.stopTimeout();
                    break;
                }
                default: {
                    hsmState = this.myParent;
                }
            }
        }
        return hsmState;
    }

    public void startTimeout() {
        if (!this.mTimeoutRunning) {
            int n = this.mOwner.getTargetId();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, n, this.mOwner.getTimeoutEventId());
            eventGeneric.setObject(0, this);
            ServiceManager.eventMain.getTimerServer().sendTimedEvent(eventGeneric, this.getTimeout(), false, true);
            this.mTimeoutRunning = true;
        }
    }

    public void stopTimeout() {
        if (this.mTimeoutRunning) {
            ServiceManager.eventMain.getTimerServer().stopTimedEvent(this.mOwner.getTargetId(), this.mOwner.getTimeoutEventId());
        }
        this.mTimeoutRunning = false;
    }

    public void retriggerTimeout() {
        if (this.mTimeoutRunning) {
            ServiceManager.eventMain.getTimerServer().restartTimedEvent(this.mOwner.getTargetId(), this.mOwner.getTimeoutEventId());
        } else {
            this.startTimeout();
        }
        this.mTimeoutRunning = true;
    }

    public void transitionToIdle() {
        this.trans(this.mOwner.getIdleState());
    }

    protected void sendAnswer() {
        EventGeneric eventGeneric = this.mOwner.getCurrentEvent();
        if (!eventGeneric.isBlocked()) {
            this.mOwner.getTarget().warn("Not sending event back because not blocked!");
        } else {
            eventGeneric.setBlocked(false);
            ServiceManager.eventMain.getEventDispatcher().sendBack(eventGeneric);
        }
    }

    protected EventGeneric getRequest() {
        return this.mOwner.getCurrentEvent();
    }
}

