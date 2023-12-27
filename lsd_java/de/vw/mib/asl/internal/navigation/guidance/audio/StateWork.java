/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.audio.Events;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateWork
extends AbstractHsmState {
    private HsmTargetAudio target;

    StateWork(HsmTargetAudio hsmTargetAudio, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetAudio;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                Events.addObservers(this.target);
                this.target.initDSI();
                this.setSoundMode();
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.trans(this.target.stateIdle);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                Events.removeObservers(this.target);
                break;
            }
            case 4000019: {
                this.target.traceState(this, "ASL_SOUND_NAV_ANNOUNCEMENT_STATUS");
                PersistedGuidanceSetup.getInstance().setSoundOn(eventGeneric.getBoolean(0));
                this.setSoundMode();
                break;
            }
            case 4000021: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS");
                this.handleASLSoundAudioMNGMNTStatus(eventGeneric);
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_ALTERNATIVE_RC_SELECTROUTE_ANNOUNCEMENT_ON");
                this.target.isRepeatAltRouteCalcAnnouncement = true;
                this.target.isTriggerAltRouteCalcAnnouncement = true;
                break;
            }
            case 100101: {
                this.target.traceState(this, "EV_ASL_INT_ALTERNATIVE_RC_SELECTROUTE_ANNOUNCEMENT_OFF");
                this.target.isRepeatAltRouteCalcAnnouncement = false;
                this.target.isTriggerAltRouteCalcAnnouncement = false;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    void setSoundMode() {
        this.target.traceState(this, "setSoundMode");
        if (PersistedGuidanceSetup.getInstance().isSoundOn()) {
            this.target.traceState(this, "ASLNavigationDP.getInstance().isSoundOn() == true");
            int n = !ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isPNavActive() ? PersistedGuidanceSetup.getInstance().getDsiAudioAnnouncementType() : 2;
            this.target.getDsiNavigation().rgSetRouteGuidanceMode(n);
        } else {
            this.target.traceState(this, "ASLNavigationDP.getInstance().isSoundOn() == false");
            this.target.getDsiNavigation().rgSetRouteGuidanceMode(3);
        }
    }

    void handleASLSoundAudioMNGMNTStatus(EventGeneric eventGeneric) {
        this.target.traceState(this, "handleASLSoundAudioMNGMNTStatus()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_CO_UNAVAILABLE");
                this.trans(this.target.stateAudiomanagementNotAvailable);
                break;
            }
            case 1: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_C1_AVAILABLE");
                break;
            }
            case 2: {
                this.target.traceState(this, "ASL_SOUND_AUDIOMNGMNT_STATUS_C2_AVAILABLE_RESTORE_CONNECTIONS");
                break;
            }
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        this.target.isRgActive = bl;
    }
}

