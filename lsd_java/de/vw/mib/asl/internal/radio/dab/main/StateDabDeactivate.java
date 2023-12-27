/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabDeactivate
extends AbstractHsmState {
    private final HsmTarget mTarget;
    boolean mFaded = false;
    private HsmState myNextState = null;

    public StateDabDeactivate(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabDeactivate is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.dabActive = false;
                this.myNextState = this.mTarget.stateDabInactive;
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (serviceInfo == null || serviceInfo == RadioConstants.DAB_DEFAULT_SERVICE) {
                    RadioData.getDabDatabase().mTunerState.setCurrentFrequency(null);
                }
                DabDsiApi.deactivateTuner();
                break;
            }
            case 100240: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.myNextState = this.mTarget.stateDabInactive;
                break;
            }
            case 1026: 
            case 100241: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.myNextState = this.mTarget.stateDabPrepareTuning;
                break;
            }
            case 101025: {
                if (this.mTarget.isDeactivated()) {
                    this.mTarget.sendAnswer(0);
                }
                DabRadioSlsApi.notifyDabActivated(false);
                DabRadioTextApi.dabDeactivated();
                this.trans(this.myNextState);
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

