/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class AbstractState
extends AbstractHsmState {
    protected final HsmDabDsi mTarget;
    static final int P0_SENDER_EVENT_ID;
    private boolean mTimeoutRunning;
    private boolean mAbortTimeoutRunning;
    private boolean mFailure;

    AbstractState(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi.getHsm(), string, hsmState);
        this.mTarget = hsmDabDsi;
        RadioServiceManager.getServiceManager().setHsmDabDsi(this.mTarget);
    }

    abstract long getTimeout() {
    }

    void onTimeout() {
        String string = new StringBuffer().append("DSI Timeout(").append(this.getTimeout()).append(" ms): ").append(this.dsiRequestToString()).append(")").toString();
        if (this.abort()) {
            string = new StringBuffer().append(string).append(" -> try to abort").toString();
        } else {
            this.trans(this.mTarget.stateIdle);
        }
        RadioDabTraceUtil.errorLogDab(string);
    }

    void onAbortTimeout() {
        RadioDabTraceUtil.errorLogDab(new StringBuffer().append("DSI Timeout for Abort (2000ms)").append(this.dsiAbortRequestToString()).toString());
        this.trans(this.mTarget.stateIdle);
    }

    final void startAbortTimeout() {
        if (!this.mAbortTimeoutRunning) {
            int n = this.mTarget.getTargetId();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, n, -1215954688);
            eventGeneric.setObject(0, this);
            this.mTarget.startTimer(eventGeneric, 0, false, true);
            this.mAbortTimeoutRunning = true;
        }
    }

    final boolean isAbortTimeoutRunning() {
        return this.mAbortTimeoutRunning;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.debugOut('>', "started");
                this.mFailure = false;
                this.startTimeout();
                break;
            }
            case 4: {
                this.debugOut('|', "stopped");
                if (this.mTarget.mCurrentEvent != null) {
                    this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                    this.mTarget.mCurrentEvent = null;
                }
                this.stopTimeout();
                this.stopAbortTimeout();
                break;
            }
            case 100020: {
                if (eventGeneric.getObject(0) != this) break;
                this.mTimeoutRunning = false;
                this.errorLog('!', "Timeout");
                this.mFailure = true;
                this.onTimeout();
                break;
            }
            case 100023: {
                if (eventGeneric.getObject(0) != this) break;
                this.mAbortTimeoutRunning = false;
                this.errorLog('!', "Abort Timeout");
                this.mFailure = true;
                this.onAbortTimeout();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    void startTimeout() {
        if (!this.mTimeoutRunning) {
            int n = this.mTarget.getTargetId();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, n, -1266286336);
            eventGeneric.setObject(0, this);
            this.mTarget.startTimer(eventGeneric, this.getTimeout(), false, false);
            this.mTimeoutRunning = true;
        }
    }

    void stopTimeout() {
        if (this.mTimeoutRunning) {
            this.mTarget.stopTimer(-1266286336);
        }
        this.mTimeoutRunning = false;
    }

    void stopAbortTimeout() {
        if (this.mAbortTimeoutRunning) {
            this.mAbortTimeoutRunning = false;
            this.mTarget.stopTimer(-1215954688);
        }
    }

    void retriggerTimeout() {
        if (this.mTimeoutRunning) {
            this.mTarget.retriggerTimer(-1266286336);
        } else {
            this.startTimeout();
        }
        this.mTimeoutRunning = true;
    }

    void debugOut(char c2, String string) {
        StringBuffer stringBuffer = new StringBuffer(120);
        stringBuffer.append("---");
        stringBuffer.append(c2);
        stringBuffer.append(" ");
        stringBuffer.append(this.getName());
        stringBuffer.append(": ");
        stringBuffer.append(string);
        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), stringBuffer.toString());
    }

    void errorLog(char c2, String string) {
        StringBuffer stringBuffer = new StringBuffer(120);
        stringBuffer.append("---");
        stringBuffer.append(c2);
        stringBuffer.append(" ");
        stringBuffer.append(this.getName());
        stringBuffer.append(": ");
        stringBuffer.append(string);
        RadioDabTraceUtil.errorLogDab(stringBuffer.toString());
    }

    void sendAnswer(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(this.mTarget.getTargetId());
        eventGeneric.setSenderEventId(0);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        eventGeneric.setReceiverEventId(n);
        this.mTarget.send(eventGeneric);
    }

    protected String dsiRequestToString() {
        return this.getName();
    }

    protected String dsiAbortRequestToString() {
        return this.getName();
    }

    protected boolean abort() {
        return false;
    }

    final void logFailure() {
        RadioDabTraceUtil.errorLogDab(new StringBuffer().append("DSI Failure - ").append(this.dsiRequestToString()).toString());
    }

    final void logFailure(String string) {
        RadioDabTraceUtil.errorLogDab(new StringBuffer().append("DSI Failure  ").append(string).append(" - ").append(this.dsiRequestToString()).toString());
    }

    final void failed() {
        this.mFailure = true;
    }

    final boolean hasFailed() {
        return this.mFailure;
    }
}

