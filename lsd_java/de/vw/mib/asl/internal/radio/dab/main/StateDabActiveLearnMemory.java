/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabActiveLearnMemory
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private int mPresetIndex;
    private boolean mRunning = false;

    public StateDabActiveLearnMemory(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabActiveLearnMemory is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
                this.mPresetIndex = RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex();
                GuiApiDab.updateListStateToUpdating();
                DabDsiApi.updateLearnMemory(1, this.mTarget.getTargetId(), 1955004672);
                this.mRunning = true;
                break;
            }
            case 0x40000499: {
                this.mRunning = false;
                GuiApiDab.updateListStateToCancelling();
                DabDsiApi.cancelLearnMemoryUpdate();
                break;
            }
            case 101007: {
                HmiDabListViewApi.notifyServiceList();
                break;
            }
            case 101014: {
                DabRadioSlsApi.notifyNewDataServiceList();
                HmiDabListViewApi.notifyDataServiceList();
                break;
            }
            case 100212: {
                if (eventGeneric.getResult() == 0) {
                    GuiApiDab.updateSpeechAndBapReceptionList();
                    HmiDabListViewApi.reloadList();
                    if (RadioData.getDabDatabase().mTunerState.getServiceList().length == 0) {
                        if (RadioCurrentWaveband.get() == 2) {
                            RadioSystemEventsUtil.sendNoServicesAvailable();
                        }
                        RadioData.getDabDatabase().mTunerState.tuneDefaultService();
                    } else {
                        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                        if (serviceInfo == null || RadioData.getDabDatabase().mTunerState.findServiceInList(serviceInfo) == null) {
                            serviceInfo = RadioData.getDabDatabase().mTunerState.getServiceList()[0];
                            if (serviceInfo != null) {
                                RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC));
                            } else {
                                RadioData.getDabDatabase().mTunerState.tuneDefaultService();
                            }
                        } else {
                            RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(this.mPresetIndex, true);
                        }
                    }
                    this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble());
                }
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 100240: {
                this.mRunning = false;
                DabDsiApi.cancelLearnMemoryUpdate();
                return this.myParent;
            }
            case 0x40000488: 
            case 1073742987: 
            case 1073742990: 
            case 1073742991: 
            case 0x40000494: 
            case 1073743037: 
            case 1073743071: {
                break;
            }
            case 4: {
                GuiApiDab.updateListStateToAvailable();
                if (!this.mRunning) break;
                DabDsiApi.cancelLearnMemoryUpdate();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

