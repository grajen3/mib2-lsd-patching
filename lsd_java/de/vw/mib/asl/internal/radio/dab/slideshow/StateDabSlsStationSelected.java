/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabSlsStationSelected
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;

    public StateDabSlsStationSelected(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsStationSelected is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabSlsStationSelected HSM_START").log();
                }
                this.trans(this.mTarget.stateDabSlsWaiting);
                break;
            }
            case 100102: {
                this.trans(this.mTarget.stateDabSlsSyncLost);
                break;
            }
            case 100105: {
                this.trans(this.mTarget.stateDabSlsDabOff);
                break;
            }
            case 100108: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabSlsStationSelected EV_SLS_STATION_CHANGING").log();
                }
                this.trans(this.mTarget.stateDabSlsStationChanging);
                break;
            }
            case 100107: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabSlsStationSelected updateSlideshowState").log();
                }
                this.mTarget.decideSlideshowState();
                break;
            }
            case 100110: {
                this.trans(this.mTarget.stateDabSlsSearching);
                break;
            }
            case 4: {
                this.mTarget.mCurrentSlideShowImage = null;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

