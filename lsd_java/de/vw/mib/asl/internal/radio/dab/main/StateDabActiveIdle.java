/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public final class StateDabActiveIdle
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabActiveIdle(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabActiveIdle is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.setNextAsCurrent();
                if (this.mTarget.getCurrentEvent() == null) break;
                this.processEvent(this.mTarget.getCurrentEvent(), true);
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.processEvent(eventGeneric, false);
            }
        }
        return hsmState;
    }

    private HsmState processEvent(EventGeneric eventGeneric, boolean bl) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742987: {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(true, 1170613248, -1);
                    break;
                }
                this.mTarget.TraceViewState("EV_DAB_DOWN_ACTIVATE_NEXT_STATION", "Soll Zustand:", false, false, false);
                this.activateNextStation(true, bl);
                break;
            }
            case 1073742991: {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    RadioServiceManager.getServiceManager().getTileStationList().activateStationInRadioTileList(false, 1170613248, -1);
                    break;
                }
                this.mTarget.TraceViewState("EV_DAB_DOWN_ACTIVATE_PREVIOUS_STATION", "Soll Zustand:", false, false, false);
                this.activateNextStation(false, bl);
                break;
            }
            case 0x40000488: {
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                DabDsiApi.jumpLMUp();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073742990: {
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                DabDsiApi.jumpLMDown();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743071: {
                if (DabRadioSlsApi.getSearchingStatus()) break;
                this.mTarget.TraceViewState("EV_DAB_DOWN_STORE_CURRENT_STATION_PRESET", "Soll Zustand:", false, false, false);
                int n = eventGeneric.getInt(0);
                this.mTarget.storeCurrentStationPreset(n);
                if (bl) {
                    this.mTarget.setCurrentEvent(null);
                }
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 0x40000494: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_ACTIVATE_STATION_PRESET", "Soll Zustand:", false, false, false);
                int n = eventGeneric.getInt(0);
                this.mTarget.activatePreset(n);
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 0x40000484: {
                long l = eventGeneric.getLong(0);
                RadioData.getDabDatabase().mInitialStartup = false;
                boolean bl2 = this.mTarget.activateStationById(l);
                RadioSystemEventsUtil.sendSelectStationFinished(bl2);
                HmiDabListViewApi.notifyCurrentStationInfo();
                HmiDabListViewApi.reloadList();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073742982: {
                this.tuneServiceTriggeredBySpeechControl(eventGeneric);
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073744611: {
                long l = eventGeneric.getLong(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.info(256).append("received ACTIVATE_ENSEMBLE_BY_ID with id : ").append(l).log();
                }
                boolean bl3 = false;
                if (RadioUtil.isIdADatabaseStationId(l)) {
                    bl3 = l > -1L;
                    RadioDataApi.requestRadioStationDataForTuningTheStation((int)(l >> 1), 16);
                } else {
                    bl3 = this.mTarget.activateStationById(l);
                }
                RadioSystemEventsUtil.sendSelectEnsembleFinished(bl3);
                break;
            }
            case 1073742997: {
                this.tunePresetStationTriggeredBySpeechControl(eventGeneric, bl);
                break;
            }
            case 100234: {
                RadioData.getDabDatabase().mTunerState.tuneComponent((ComponentInfo)eventGeneric.getObject(0), (ServiceInfo)eventGeneric.getObject(1), (EnsembleInfo)eventGeneric.getObject(2));
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                RadioSystemEventsUtil.sendSelectStationFinished(true);
                HmiDabListViewApi.notifyCurrentStationInfo();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 100235: {
                RadioData.getDabDatabase().mTunerState.tuneService((ServiceInfo)eventGeneric.getObject(0), (EnsembleInfo)eventGeneric.getObject(1));
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                RadioSystemEventsUtil.sendSelectStationFinished(true);
                HmiDabListViewApi.notifyCurrentStationInfo();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743080: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_UPDATE_STATION_LIST", "Soll Zustand:", true, false, false);
                this.trans(this.mTarget.stateDabActiveLearnMemory);
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 0x400004D0: 
            case 1073743057: {
                this.trans(this.mTarget.stateDabActiveSeek);
                if (bl) break;
                this.mTarget.setCurrentEvent(eventGeneric);
                break;
            }
            case 4300068: {
                if (this.mTarget.mManualMode) {
                    int n = eventGeneric.getInt(1);
                    if (n == 10) {
                        int n2 = eventGeneric.getInt(0);
                        DabDsiApi.ddsRotated(n2);
                    }
                    RadioData.getDabDatabase().mInitialStartup = false;
                    DabRadioTextApi.newProgram(0L);
                    DabRadioSlsApi.notifyStationChanging();
                }
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743014: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_INCREASE_FREQUENCY_ONESTEP", "Soll Zustand:", false, false, true);
                DabDsiApi.stepUp();
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743002: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_DECREASE_FREQUENCY_ONESTEP", "Soll Zustand:", false, false, true);
                DabDsiApi.stepDown();
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743053: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_START_INCREASE_FREQUENCY", "Soll Zustand:", false, false, true);
                DabDsiApi.startIncreasingFrequency(true);
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 0x400004CC: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_START_DECREASE_FREQUENCY", "Soll Zustand:", false, false, true);
                DabDsiApi.startDecreasingFrequency(true);
                RadioData.getDabDatabase().mInitialStartup = false;
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743059: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_STOP_CHANGING_FREQUENCY", "Soll Zustand:", false, false, true);
                DabDsiApi.stopChangingFrequency();
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 1073743037: {
                this.mTarget.TraceViewState("EV_DAB_DOWN_SET_FREQUENCY_VALUE", "Soll Zustand:", false, false, true);
                int n = eventGeneric.getInt(0);
                this.mTarget.trace(new StringBuffer().append("DAB scale gives frequency ").append(n).toString());
                RadioData.getDabDatabase().mInitialStartup = false;
                DabDsiApi.tuneFrequency(n);
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                if (!bl) break;
                this.mTarget.setCurrentEvent(null);
                break;
            }
            case 100240: {
                SelectedStationHighlighting.setSelectedStationHighlightingIsActive(false);
                this.trans(this.mTarget.stateDabDeactivate);
                if (bl) break;
                this.mTarget.setCurrentEvent(eventGeneric);
                break;
            }
            case 100215: {
                RadioDabTraceUtil.errorLogDab("Got the feedback from Diagnosis in DabActiveIdle");
                int n = RadioData.getDabDatabase().mPersistable.getBand1();
                int n3 = RadioData.getDabDatabase().mPersistable.getBand2();
                this.mTarget.processDiagnosisData(eventGeneric);
                int n4 = RadioData.getDabDatabase().mPersistable.getBand1();
                int n5 = RadioData.getDabDatabase().mPersistable.getBand2();
                if (n == n4 && n3 == n5) break;
                RadioData.getDabDatabase().mTunerState.tuneDefaultService();
                GuiApiDab.UpdateDefaultStation();
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.signalLost();
                RadioData.getDabDatabase().mInitialStartup = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:-UpdateAvailability in StateDabActiveIdle: ").append(n).toString());
        if (n == 1) {
            this.mTarget.changeToMain();
        } else if (n == 2 && RadioData.getDabDatabase().getDabTunerAvailability() != 2) {
            if (this.mTarget.restoreAudio()) {
                this.trans(this.mTarget.stateDabPrepareAudio);
            } else {
                this.trans(this.mTarget.stateDabPrepareTuner);
            }
        }
        RadioData.getDabDatabase().setDabTunerAvailability(n);
    }

    private void activateNextStation(boolean bl, boolean bl2) {
        if (AmfmScopeOfArrowKeys.get() == 0) {
            SelectedStationHighlighting.setSelectedStationHighlightingIsActive(true);
        }
        RadioData.getDabDatabase().mInitialStartup = false;
        DabDsiApi.stepService(bl);
        if (bl2) {
            this.mTarget.setCurrentEvent(null);
        }
    }

    private void tunePresetStationTriggeredBySpeechControl(EventGeneric eventGeneric, boolean bl) {
        try {
            long l = eventGeneric.getLong(0);
            int n = -1;
            n = RadioUtil.isIdADatabaseStationId(l) ? RadioData.getDabDatabase().dabPresetList.getIndexByDatabaseStationId(l >> 1) : RadioData.getDabDatabase().dabPresetList.getIndexById(l);
            if (n > -1) {
                this.mTarget.activatePreset(n);
                RadioSystemEventsUtil.sendSelectStationFinished(true);
            } else {
                RadioSystemEventsUtil.sendSelectStationFinished(false);
            }
            if (bl) {
                this.mTarget.setCurrentEvent(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(214);
        }
    }

    private void tuneServiceTriggeredBySpeechControl(EventGeneric eventGeneric) {
        try {
            long l = eventGeneric.getLong(0);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.info(256).append("received ACTIVATE_DAB_SERVICE_BY_ID with id : ").append(l).log();
            }
            RadioData.getDabDatabase().mInitialStartup = false;
            boolean bl = false;
            if (RadioUtil.isIdADatabaseStationId(l)) {
                bl = l > -1L;
                RadioStationDataRequest radioStationDataRequest = RadioDataApi.requestRadioDabStationRequestDataFromHmiBuffer((int)(l >> 1));
                if (radioStationDataRequest != null) {
                    ServiceInfo serviceInfo = new ServiceInfo();
                    serviceInfo.sID = radioStationDataRequest.getPiSid();
                    serviceInfo.ensECC = radioStationDataRequest.getExtendedCountryCode();
                    serviceInfo.ensID = radioStationDataRequest.getEnsembleId();
                    serviceInfo.fullName = radioStationDataRequest.getLongName();
                    serviceInfo.shortName = radioStationDataRequest.getShortName();
                    EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
                    RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                    RadioData.getDabDatabase().mTunerState.setCurrentEnsemble(ensembleInfo);
                    RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
                    RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
                    this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                }
            } else {
                bl = this.mTarget.activateStationById(l);
            }
            RadioSystemEventsUtil.sendSelectStationFinished(bl);
            HmiDabListViewApi.notifyCurrentStationInfo();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

