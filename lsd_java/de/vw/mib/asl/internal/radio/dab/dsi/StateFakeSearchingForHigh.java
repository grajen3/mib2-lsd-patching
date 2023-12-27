/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateFakeSearchingForHigh
extends AbstractHsmState {
    private final HsmDabDsi mTarget;
    private static int fakingTimeout = 10000;
    private int mLinkingOption = 0;

    public StateFakeSearchingForHigh(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi.getHsm(), string, hsmState);
        this.mTarget = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateFakeSearchingForHigh is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mLinkingOption = RadioData.getDabDatabase().mOptionLinking.getOption();
                this.mTarget.mDsiDabTuner.switchLinking(1);
                DabRadioSlsApi.notifySearching();
                GuiApiTunerCommon.setDabRadioTextLoadingStateToLoading();
                GuiApiDab.updateDabSearching(true);
                HmiDabListViewApi.notifyJumpLmStarted();
                this.mTarget.startTimer(327614720, (long)fakingTimeout, false);
                break;
            }
            case 100115: {
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 4: {
                GuiApiDab.updateDabSearching(false);
                this.mTarget.stopTimer(327614720);
                this.mTarget.mDsiDabTuner.switchLinking(this.mLinkingOption);
                this.mTarget.tuneLsm();
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100008: 
            case 100022: 
            case 100025: 
            case 100106: 
            case 100110: {
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100009: 
            case 100010: 
            case 100012: 
            case 100016: 
            case 100021: 
            case 100113: {
                this.mTarget.mNextEvent = eventGeneric;
                this.trans(this.mTarget.stateIdle);
                break;
            }
            default: {
                hsmState = null;
            }
        }
        return hsmState;
    }
}

