/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.traffic.states;

import de.vw.mib.asl.internal.online.traffic.states.OnlineTrafficTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class OnlineTrafficStateActive
extends AbstractHsmState {
    private final OnlineTrafficTarget _target;
    private final String _classname;

    public OnlineTrafficStateActive(OnlineTrafficTarget onlineTrafficTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._classname = "OnlineTrafficStateActive";
        this._target = onlineTrafficTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("OnlineTrafficStateActive").append(".OnlineTrafficStateActive()").log();
        }
    }

    private OnlineTrafficTarget getTarget() {
        return this._target;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 4300062: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append("OnlineTrafficStateActive").append(".handle(ASLSystemServiceIds.RELOAD_PERSISTABLES)").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

