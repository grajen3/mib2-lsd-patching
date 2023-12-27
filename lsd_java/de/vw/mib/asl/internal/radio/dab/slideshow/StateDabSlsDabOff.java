/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.radio.ASLRadioPropertyManager;

public final class StateDabSlsDabOff
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;
    private boolean mSelected = false;

    public StateDabSlsDabOff(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsDabOff is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mSelected = false;
                this.mTarget.mCurrentSlideShowImage = ASLRadioPropertyManager.DAB_SLIDE_SHOW_IMAGE__DEFAULT_VALUE;
                this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                this.mTarget.notifyFriendsAboutActivationSLS(false);
                break;
            }
            case 100106: {
                int n;
                this.mTarget.currentSlideShowState = n = RadioData.getDabDatabase().mPersistable.lsmSupportsSlideShow() ? 2 : 0;
                this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                this.mTarget.notifyFriendsAboutActivationSLS(true);
                this.mTarget.mainViewVisible(true);
                if (this.mSelected) {
                    this.trans(this.mTarget.stateDabSlsStationSelected);
                    break;
                }
                this.trans(this.mTarget.stateDabSlsStationChanging);
                break;
            }
            case 100107: {
                this.mSelected = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

