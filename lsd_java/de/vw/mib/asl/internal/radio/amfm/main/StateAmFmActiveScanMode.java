/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmFixedStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateAmFmActiveScanMode
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private AmFmStation mStationOnScanStart;
    private AmFmFixedStationList mScanMemory;
    private int mScanCounter;
    private boolean userAbort = false;
    private boolean mEmergencyScan = false;

    StateAmFmActiveScanMode(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    private AmFmStationList getFrozenFMHDStationList() {
        AmFmStationList amFmStationList = null;
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation();
        amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList().generateFrozenFmList(amFmStation);
        if (!amFmStation.isHD()) {
            amFmStationList.deleteCurrentStationInList(amFmStation);
        }
        return amFmStationList;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveScanMode is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.userAbort = false;
                if (null != RadioData.getAmfmDatabase()) {
                    AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        if (amFmStationList == null || amFmStationList.size() < 3) {
                            this.mStationOnScanStart = null;
                            this.mEmergencyScan = true;
                            this.trans(this.mTarget.stateAmFmActiveEmergencyScan);
                            break;
                        }
                        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                        if (null != amFmStation) {
                            this.mStationOnScanStart = new AmFmStation(amFmStation);
                            this.mScanCounter = 0;
                            GuiApiTunerCommon.updateScanActive(true);
                            this.mTarget.broadcastScanModeToFriends(true);
                            if (RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter() && RadioCurrentWaveband.isFm()) {
                                this.mScanMemory = new AmFmFixedStationList(this.getFrozenFMHDStationList());
                                if (!this.mStationOnScanStart.isHD()) {
                                    this.mStationOnScanStart = this.mScanMemory.prepareNext(amFmStation);
                                }
                            } else {
                                this.mScanMemory = new AmFmFixedStationList(amFmStationList);
                            }
                            AmFmStation amFmStation2 = this.mStationOnScanStart;
                            amFmStation2 = this.mScanMemory.setActual(this.mStationOnScanStart) < 0 ? this.mScanMemory.prepareNext(this.mStationOnScanStart) : this.mScanMemory.next();
                            if (null != amFmStation2) {
                                ++this.mScanCounter;
                                AmFmDsiApi.selectStation(amFmStation2);
                                this.mTarget.startTimer(1770455296, (long)0, false);
                                break;
                            }
                            this.trans(this.mTarget.stateAmFmActiveIdle);
                            break;
                        }
                        this.trans(this.mTarget.stateAmFmActiveIdle);
                        break;
                    }
                    if (amFmStationList == null || amFmStationList.size() < 3) {
                        this.mStationOnScanStart = null;
                        this.mEmergencyScan = true;
                        this.trans(this.mTarget.stateAmFmActiveEmergencyScan);
                        break;
                    }
                    AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                    if (null != amFmStation) {
                        this.mStationOnScanStart = new AmFmStation(amFmStation);
                        this.mScanMemory = new AmFmFixedStationList(this.mStationOnScanStart);
                        this.mScanCounter = 0;
                        AmFmStation amFmStation3 = this.mScanMemory.next();
                        if (null != amFmStation3) {
                            GuiApiTunerCommon.updateScanActive(true);
                            this.mTarget.broadcastScanModeToFriends(true);
                            this.mTarget.avoidRTandTPFlickering(true);
                            ++this.mScanCounter;
                            AmFmDsiApi.selectStation(amFmStation3);
                            this.mTarget.startTimer(1770455296, (long)0, false);
                            break;
                        }
                        this.trans(this.mTarget.stateAmFmActiveIdle);
                        break;
                    }
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                    break;
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 4: {
                if (!this.mEmergencyScan) {
                    GuiApiTunerCommon.updateScanActive(false);
                    this.mTarget.broadcastScanModeToFriends(false);
                    this.mTarget.avoidRTandTPFlickering(false);
                    if (this.userAbort) break;
                    AmFmDsiApi.selectStation(this.mStationOnScanStart);
                    this.userAbort = false;
                    break;
                }
                this.mEmergencyScan = false;
                break;
            }
            case 1073743017: {
                this.userAbort = true;
                hsmState = this.myParent;
                break;
            }
            case 100201: {
                ++this.mScanCounter;
                if (null != this.mScanMemory) {
                    AmFmStation amFmStation = this.mScanMemory.next();
                    if (null != amFmStation && this.mScanCounter < this.mScanMemory.size()) {
                        AmFmDsiApi.selectStation(amFmStation);
                        int n = 5000;
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                            n = 7500;
                        }
                        this.mTarget.startTimer(1770455296, (long)n, false);
                        break;
                    }
                    this.userAbort = false;
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                    break;
                }
                this.userAbort = false;
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073743064: {
                this.mTarget.stopTimer(1770455296);
                this.userAbort = true;
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

