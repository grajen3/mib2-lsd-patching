/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabAutostore
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabAutostore(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabAutostore is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                DabDsiApi.activateTuner();
                break;
            }
            case 101024: {
                DabDsiApi.updateLearnMemory(1, this.mTarget.getTargetId(), 1955004672);
                break;
            }
            case 100212: {
                this.trans(this.mTarget.stateDabDeactivate);
                this.mTarget.sendAnswer(eventGeneric.getResult());
                break;
            }
            case 101002: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.mTarget.trace("--- DAB auto store aborted.");
                this.trans(this.mTarget.stateDabDeactivate);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:-UpdateAvailability in StateDabAutostore: ").append(n).toString());
        if (n == 1) {
            this.mTarget.sendAnswer(16);
            this.trans(this.mTarget.stateDabInactive);
        }
        RadioData.getDabDatabase().setDabTunerAvailability(n);
    }
}

