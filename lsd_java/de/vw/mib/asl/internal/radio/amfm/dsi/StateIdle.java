/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateIdle
extends AbstractHsmState {
    private final HsmAmFmDsi mTarget;

    StateIdle(HsmAmFmDsi hsmAmFmDsi, String string, HsmState hsmState) {
        super(hsmAmFmDsi.getHsm(), string, hsmState);
        this.mTarget = hsmAmFmDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                EventGeneric eventGeneric2 = this.mTarget.nextEvent();
                if (eventGeneric2 == null) break;
                this.processEvent(eventGeneric2);
                break;
            }
            default: {
                hsmState = this.processEvent(eventGeneric);
            }
        }
        return hsmState;
    }

    private HsmState processEvent(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 101000: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateAutoSeek);
                break;
            }
            case 101020: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateSelectFrequency);
                break;
            }
            case 101030: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateSelectStation);
                break;
            }
            case 101040: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateTuneFrequencySteps);
                break;
            }
            case 101050: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateAutostore);
                break;
            }
            case 101060: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateForceAmUpdate);
                break;
            }
            case 101070: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateForceFmUpdate);
                break;
            }
            case 101080: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.mCurrentEvent.setBlocked(true);
                this.trans(this.mTarget.stateSetAmBandRange);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void sendBack(EventGeneric eventGeneric) {
        eventGeneric.setResult(0);
        if (eventGeneric.isBlocked()) {
            eventGeneric.setBlocked(false);
            ServiceManager.eventMain.getEventDispatcher().sendBack(eventGeneric);
        }
    }
}

