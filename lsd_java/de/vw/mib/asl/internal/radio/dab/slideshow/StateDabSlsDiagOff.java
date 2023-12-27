/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.radio.ASLRadioPropertyManager;

public final class StateDabSlsDiagOff
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;
    private HsmState nextState;

    public StateDabSlsDiagOff(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsDiagOff is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.currentSlideShowState = 3;
                this.mTarget.mCurrentSlideShowImage = ASLRadioPropertyManager.DAB_SLIDE_SHOW_IMAGE__DEFAULT_VALUE;
                this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                this.nextState = this.mTarget.getHsm().getPreviousState();
                break;
            }
            case 4300066: {
                if (!this.mTarget.slsAllowed(eventGeneric)) break;
                this.trans(this.nextState);
                break;
            }
            case 100105: {
                this.nextState = this.mTarget.stateDabSlsDabOff;
                break;
            }
            case 100102: {
                this.nextState = this.mTarget.stateDabSlsSyncLost;
                break;
            }
            case 4300065: {
                this.mTarget.mAboveLimit = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(new StringBuffer().append("AboveLimit: ").append(this.mTarget.mAboveLimit).append("Duration1: ").append(this.mTarget.mDiagDuration1).append("Duration2: ").append(this.mTarget.mDiagDuration2).append("mTarget.thresholdON: ").append(this.mTarget.thresholdON).toString()).log();
                }
                if (this.mTarget.mAboveLimit) break;
                int n = this.mTarget.mDiagDuration1;
                super.getClass();
                if (n == -65536 || !this.mTarget.thresholdON) break;
                this.trans(this.nextState);
                break;
            }
            case 100106: 
            case 100108: {
                this.nextState = this.mTarget.stateDabSlsStationChanging;
                break;
            }
            case 100103: 
            case 100107: {
                this.nextState = this.mTarget.stateDabSlsStationSelected;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

