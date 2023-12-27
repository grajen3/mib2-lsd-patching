/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;

public final class StateActive
extends AbstractState {
    StateActive(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateActive is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.notifySpeechAboutListUpdate();
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100001: {
                this.trans(this.mTarget.stateInactive);
                this.mTarget.unregister();
                break;
            }
            case 100112: {
                this.mTarget.mNextState = null;
                DabMainApi.notifyTunerActivated();
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100008: 
            case 100009: 
            case 100010: 
            case 100012: 
            case 100016: 
            case 100018: 
            case 100021: 
            case 100106: 
            case 100110: 
            case 100111: 
            case 100113: {
                this.mTarget.sendResult(this.mTarget.mNextEvent, 1);
                eventGeneric.setBlocked(true);
                this.mTarget.mNextEvent = eventGeneric;
                break;
            }
            case 100024: {
                this.mTarget.mJumpLm = true;
                this.mTarget.stopMuteTimer();
                break;
            }
            case 100011: {
                if (this.mTarget.mNextEvent == null) break;
                this.sendAnswer(this.mTarget.mNextEvent.getInt(0));
                if (this.mTarget.mNextEvent.getReceiverEventId() != -1434058496) break;
                this.mTarget.mNextEvent = null;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerAsyncException(int n, String string, int n2) {
        if (this.mTarget.isTraceEnabled()) {
            this.mTarget.getTextLogger().trace(256).append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]");
        }
        this.trans(this.mTarget.stateIdle);
    }

    public HsmState dsiDABTunerUpdateComponentList(ComponentInfo[] componentInfoArray, int n) {
        RadioData.getDabDatabase().mTunerState.setComponentList(componentInfoArray);
        this.mTarget.notifySpeechAboutListUpdate();
        return this.myParent;
    }

    public void dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:- UpdateAvailability in DSI StateActive: ").append(n).toString());
        RadioData.getDabDatabase().setDabTunerAvailability(n);
        if (n == 1) {
            if (this.mTarget.mNextEvent != null) {
                this.mTarget.sendResult(this.mTarget.mNextEvent, 12);
                this.mTarget.mNextEvent = null;
            }
            if (this.mTarget.mCurrentEvent != null) {
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 12);
                this.mTarget.mCurrentEvent = null;
            }
            DabMainApi.notifyTunerDeactivated();
            this.trans(this.mTarget.stateInactive);
        }
    }

    public void dsiDABTunerUpdateLinkingUsageStatus(int n, int n2) {
        if (n == 2 && !this.mTarget.switchLinkingDone) {
            this.mTarget.switchLinkingDone = true;
            DabMainApi.triggerLastService();
        }
        if (n != 2) {
            this.mTarget.switchLinkingDone = false;
        }
    }

    @Override
    long getTimeout() {
        return 0L;
    }
}

