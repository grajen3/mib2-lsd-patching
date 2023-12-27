/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabActiveSeek
extends AbstractHsmState {
    private final Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;
    private ServiceInfo currentService = null;

    public StateDabActiveSeek(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabActiveSeek is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                boolean bl;
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("StateDabActiveSeek - HSM_START").log();
                }
                this.currentService = RadioData.getDabDatabase().mTunerState.getCurrentService();
                boolean bl2 = bl = this.mTarget.getCurrentEvent().getReceiverEventId() == -805044160;
                if (this.mTarget.getCurrentEvent().getInt(0) == 0) {
                    DabDsiApi.startTargetSeekDown(true, bl, -2138636032);
                } else {
                    DabDsiApi.startTargetSeekUp(true, bl, -2138636032);
                }
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                break;
            }
            case 4: {
                if (!this.logger.isTraceEnabled(256)) break;
                this.logger.trace(256).append("StateDabActiveSeek - HSM_EXIT").log();
                break;
            }
            case 100224: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("EV_DAB_ASL_ANSWER_SEEK with IdResult - ").append(eventGeneric.getResult()).log();
                }
                if ((eventGeneric.getResult() == 11 || eventGeneric.getResult() == 0) && this.mTarget.getNextEvent() == null) {
                    EnsembleInfo ensembleInfo = (EnsembleInfo)eventGeneric.getObject(DabDsiApi.P_FOUND_ENSEMBLE);
                    FrequencyInfo frequencyInfo = (FrequencyInfo)eventGeneric.getObject(DabDsiApi.P_FOUND_FREQUENCY);
                    if (ensembleInfo != null) {
                        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
                        if (serviceInfoArray != null && serviceInfoArray.length > 0) {
                            ServiceInfo serviceInfo = serviceInfoArray[0];
                            RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                            RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
                            RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
                            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
                            RadioData.getDabDatabase().mTunerState.saveCurrentEnsemble(ensembleInfo);
                            if (frequencyInfo != null) {
                                DabDsiApi.selectServiceByFrequency(serviceInfo, frequencyInfo);
                            } else {
                                DabDsiApi.selectService(serviceInfo);
                            }
                            this.mTarget.updateCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
                        } else {
                            this.mTarget.updateCurrentStationInfo(frequencyInfo, ensembleInfo);
                        }
                    } else if (eventGeneric.getResult() == 0) {
                        if (null != this.currentService) {
                            this.mTarget.tuneLastService();
                        }
                    } else {
                        this.mTarget.updateCurrentStationInfo(frequencyInfo, ensembleInfo);
                    }
                    HmiDabListViewApi.notifyCurrentStationInfo();
                }
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 100240: 
            case 0x40000484: 
            case 1073742982: 
            case 0x40000488: 
            case 1073742987: 
            case 1073742990: 
            case 1073742991: 
            case 0x40000494: 
            case 1073742997: 
            case 1073743037: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("In StateDabActiveSeek with Event id - ").append(eventGeneric.getReceiverEventId()).log();
                }
                DabDsiApi.stopTargetSeek();
                return this.myParent;
            }
            case 1073743043: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("SET_MANUAL_MODE - ").append(eventGeneric.getBoolean(0)).log();
                }
                if (eventGeneric.getBoolean(0)) break;
                DabDsiApi.stopTargetSeek();
                this.mTarget.exitManualView();
                RadioData.getDabDatabase().mManualMode = false;
                break;
            }
            case 101007: {
                this.mTarget.TraceViewState("EV_DAB_PUB_NOTIFY_SERVICELIST", "Soll Zustand:", true, false, false);
                HmiDabListViewApi.notifyServiceList();
                GuiApiDab.updateSpeechAndBapReceptionList();
                break;
            }
            case 4300068: 
            case 1073743002: 
            case 1073743014: 
            case 0x400004CC: 
            case 1073743053: 
            case 0x400004D0: 
            case 1073743057: 
            case 1073743059: 
            case 1073743065: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("In StateDabActiveSeek with Event id - ").append(eventGeneric.getReceiverEventId()).log();
                }
                DabDsiApi.stopTargetSeek();
                break;
            }
            case 1073743067: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("STOP_TARGET_SEEK").log();
                }
                DabDsiApi.stopTargetSeekAtNext();
                break;
            }
            case 101019: {
                if (!this.logger.isTraceEnabled(256)) break;
                this.logger.trace(256).append("EV_DAB_PUB_NOTIFY_SYNC_STATUS").log();
                break;
            }
            case 101021: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("EV_DAB_PUB_NOTIFY_SELECT_SERVICE_DONE").log();
                }
                this.trans(this.mTarget.stateDabActiveIdle);
                return this.myParent;
            }
            case 101013: {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append("EV_DAB_PUB_NOTIFY_SERVICE_SELECTED_UNSUCCESSFUL").log();
                }
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

