/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabSlsSearching
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;

    public StateDabSlsSearching(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsSearching is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.currentSlideShowState = 0;
                this.mTarget.mCurrentSlideShowImage = null;
                this.mTarget.slSSearching = true;
                this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                break;
            }
            case 100105: {
                this.trans(this.mTarget.stateDabSlsDabOff);
                break;
            }
            case 100108: {
                this.trans(this.mTarget.stateDabSlsStationChanging);
                break;
            }
            case 100107: {
                this.trans(this.mTarget.stateDabSlsStationSelected);
                break;
            }
            case 100102: {
                this.trans(this.mTarget.stateDabSlsSyncLost);
                break;
            }
            case 4: {
                this.mTarget.slSSearching = false;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

