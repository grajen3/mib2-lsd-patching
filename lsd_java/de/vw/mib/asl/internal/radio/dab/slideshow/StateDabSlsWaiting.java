/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.DABSlideShowInfo;

public final class StateDabSlsWaiting
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;

    public StateDabSlsWaiting(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsWaiting is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabSlsWaiting HSM_START updateSlideshowState").log();
                }
                this.mTarget.decideSlideshowState();
                break;
            }
            case 100100: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabSlsWaiting updateSlideshowState").log();
                }
                this.mTarget.decideSlideshowState();
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

    public void dsiDABTunerUpdateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateDabSlsWaiting - updateSlideShowInfo").log();
        }
        if (this.mTarget.isItforCurrentServiceorComponent(dABSlideShowInfo)) {
            this.mTarget.mCurrentSlideShowImage = dABSlideShowInfo.slideshowImage;
            if (dABSlideShowInfo.slideshowImage != null) {
                this.trans(this.mTarget.stateDabSlsShowing);
            }
        }
    }
}

