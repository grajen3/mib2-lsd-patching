/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabInactive
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabInactive(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabInactive is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.trace("--- DAB tuner is now deactivated");
                break;
            }
            case 3: {
                GuiApiDab.updateServiceState(0);
                break;
            }
            case 4: {
                break;
            }
            case 100241: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.trans(this.mTarget.stateDabPrepareTuning);
                break;
            }
            case 100240: {
                eventGeneric.setResult(0);
                eventGeneric.setInt(0, 2);
                break;
            }
            case 1026: {
                this.trans(this.mTarget.stateDabPrepareTuner);
                break;
            }
            case 4300068: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

