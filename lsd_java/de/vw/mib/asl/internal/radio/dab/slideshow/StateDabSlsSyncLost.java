/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabSlsSyncLost
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;

    public StateDabSlsSyncLost(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsSyncLost is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.startTimer(143065344, (long)0, false);
                break;
            }
            case 100102: {
                break;
            }
            case 100103: {
                if (this.mTarget.mCurrentSlideShowImage != null) {
                    this.trans(this.mTarget.stateDabSlsShowing);
                    break;
                }
                this.trans(this.mTarget.stateDabSlsWaiting);
                break;
            }
            case 100104: {
                this.mTarget.mCurrentSlideShowImage = null;
                this.mTarget.currentSlideShowState = 0;
                this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                break;
            }
            case 4: {
                this.mTarget.stopTimer(143065344);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

