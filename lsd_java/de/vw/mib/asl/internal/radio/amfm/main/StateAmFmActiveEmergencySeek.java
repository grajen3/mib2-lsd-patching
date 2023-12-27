/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashSet;
import org.dsi.ifc.radio.Station;

public final class StateAmFmActiveEmergencySeek
extends AbstractHsmState {
    private final HsmTarget mTarget;
    public static final int EMERGENCY_SEEK_INVALID;
    public static final int EMERGENCY_SEEK_ACTIVE;
    public static final int EMERGENCY_SEEK_FINISHED;
    private static int seekStatus;
    private boolean foundSameFrequency = false;
    private boolean showlist = false;
    private HashSet tunedFrequencies = null;
    private Long oldFrequency = new Long(-1L);
    private Long selectedFrequency = new Long(-1L);
    private static AmFmStation initialAslStation;

    StateAmFmActiveEmergencySeek(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveEmergencySeek is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.showlist = false;
                this.foundSameFrequency = false;
                this.tunedFrequencies = new HashSet();
                this.oldFrequency = new Long(-1L);
                GuiApiTunerCommon.updateSeekActive(true);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.mTarget.stopTimer(1971781888);
                GuiApiTunerCommon.updateSeekActive(false);
                seekStatus = 2;
                AudioConnectionUtils.requestVolumeLock(RadioCurrentWaveband.get(), false, this.mTarget);
                AmFmPresetApi.autoCompare();
                break;
            }
            case 100002: {
                if (eventGeneric.getInt(1) == 1) break;
                if (this.foundSameFrequency) {
                    this.mTarget.startTimer(1971781888, (long)0, false);
                    break;
                }
                if (this.showlist) {
                    this.trans(this.mTarget.stateAmFmActiveListView);
                    break;
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073743064: 
            case 1073743065: {
                this.stopSeek();
                hsmState = null;
                break;
            }
            case 100240: {
                this.stopSeek();
                hsmState = this.myParent;
                break;
            }
            case 100213: {
                if (null != initialAslStation) {
                    AmFmDsiApi.selectStation(initialAslStation);
                    AmFmPresetApi.autoCompare();
                }
                if (this.showlist) {
                    this.trans(this.mTarget.stateAmFmActiveListView);
                    break;
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073742987: 
            case 1073742991: {
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                break;
            }
            case 1073743017: {
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                this.showlist = true;
                hsmState = null;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public static void setEmergencySeekStatus(int n) {
        seekStatus = n;
    }

    public static boolean isEmergencySeekActive() {
        return seekStatus == 1;
    }

    public static void setInitialAslStation(AmFmStation amFmStation) {
        initialAslStation = new AmFmStation(amFmStation);
    }

    public boolean checkBandRangeIteration(Station station) {
        if (null != station) {
            this.selectedFrequency = new Long(station.frequency);
            if (!this.foundSameFrequency && this.oldFrequency.longValue() != this.selectedFrequency.longValue()) {
                if (null != this.tunedFrequencies) {
                    if (this.tunedFrequencies.contains(this.selectedFrequency) && this.tunedFrequencies.size() > 5) {
                        this.foundSameFrequency = true;
                        AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                    } else {
                        this.tunedFrequencies.add(this.selectedFrequency);
                    }
                }
                this.oldFrequency = this.selectedFrequency;
            }
        }
        return this.foundSameFrequency;
    }

    private void stopSeek() {
        if (null != initialAslStation) {
            RadioData.getAmfmDatabase().setCurrentStation(initialAslStation);
            StateAmFmActiveEmergencySeek.setEmergencySeekStatus(1);
            AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(initialAslStation);
        }
        AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
        this.trans(this.mTarget.stateAmFmActiveIdle);
    }

    static {
        seekStatus = 0;
        initialAslStation = null;
    }
}

