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
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmTPOption;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabActive
extends AbstractHsmState {
    private final HsmTarget mTarget;
    boolean radioAudible = true;
    boolean triggeredBackgroundActivity = false;

    public StateDabActive(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabActive is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.dabActive = true;
                this.mTarget.factoryReset = false;
                GuiApiDab.updateSpeechAndBapReceptionList();
                RadioData.getDabDatabase().dabPresetList.notifyHmi();
                DabRadioSlsApi.notifyDabActivated(true);
                DabRadioTextApi.dabActivated();
                break;
            }
            case 3: {
                this.mTarget.trace("Event: Start - Abgleich mit HMI");
                this.mTarget.updatePresetBank();
                this.mTarget.mCurrentLinkingOption = RadioData.getDabDatabase().mOptionLinking.getOption();
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 4: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Exiting StateDabActive").log();
                }
                DabRadioTextApi.dabDeactivated();
                DabRadioSlsApi.notifyDabActivated(false);
                if (!this.mTarget.mManualMode) break;
                this.mTarget.exitManualView();
                break;
            }
            case 1073743079: {
                if (!DabPresetApi.isDabPresetsLoadedAndInitialized()) break;
                RadioData.getDabDatabase().dabPresetList.notifyHmi();
                break;
            }
            case 226: {
                boolean bl = eventGeneric.getBoolean(0);
                GuiApiDab.updateDabSearching(bl);
                break;
            }
            case 100217: {
                this.mTarget.TraceViewState("EV_DAB_ASL_DAB_PRESETS", "Soll Zustand:", true, false, false);
                HmiDabListViewApi.notifyPresetBank();
                long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
                GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getLastTunedIndex(), l);
                break;
            }
            case 101007: {
                this.mTarget.TraceViewState("EV_DAB_PUB_NOTIFY_SERVICELIST", "Soll Zustand:", true, false, false);
                HmiDabListViewApi.notifyServiceList();
                break;
            }
            case 101014: {
                HmiDabListViewApi.notifyDataServiceList();
                DabRadioSlsApi.notifyNewDataServiceList();
                break;
            }
            case 101005: {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (serviceInfo != null) {
                    GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
                }
                HmiDabListViewApi.notifyComponentList();
                GuiApiDab.updateSpeechAndBapReceptionList();
                break;
            }
            case 100241: {
                eventGeneric.setResult(0);
                if (!this.mTarget.userProfileChangeRequested) break;
                this.mTarget.setCurrentEvent(eventGeneric);
                this.trans(this.mTarget.stateDabPrepareTuning);
                this.mTarget.userProfileChangeRequested = false;
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
            case 1073743037: 
            case 1073743071: {
                this.mTarget.setNextEvent(eventGeneric);
                break;
            }
            case 1073743027: {
                boolean bl = eventGeneric.getBoolean(0);
                this.mTarget.switchLBandState(bl);
                DabDsiApi.canceljumpLM();
                break;
            }
            case 100225: {
                FrequencyInfo[] frequencyInfoArray = RadioData.getDabDatabase().mTunerState.getFrequencyList();
                long l = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo().frequency;
                boolean bl = false;
                for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                    if (l != frequencyInfoArray[i2].frequency) continue;
                    bl = true;
                    break;
                }
                if (bl) break;
                break;
            }
            case 1073743055: {
                this.trans(this.mTarget.stateDabActiveScanMode);
                RadioData.getDabDatabase().mInitialStartup = false;
                break;
            }
            case 101021: {
                EnsembleInfo ensembleInfo = (EnsembleInfo)eventGeneric.getObject(0);
                ServiceInfo serviceInfo = (ServiceInfo)eventGeneric.getObject(1);
                ComponentInfo componentInfo = (ComponentInfo)eventGeneric.getObject(2);
                this.mTarget.newStationSelected(ensembleInfo, serviceInfo, componentInfo);
                break;
            }
            case 100221: {
                this.mTarget.updateCurrentStationInfoFromList();
                break;
            }
            case 1073743041: {
                int n = eventGeneric.getInt(0);
                if (n == RadioData.getDabDatabase().mPersistable.getVisibleBankIndex()) break;
                RadioData.getDabDatabase().dabPresetList.setVisibleBankIndex(n);
                RadioData.getDabDatabase().dabPresetList.autoCompare();
                int n2 = RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex();
                long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
                GuiApiDab.updateBapCurrentStationIndices(n2, l);
                break;
            }
            case 1073743003: {
                int n = eventGeneric.getInt(0);
                if (n != 2) break;
                this.deleteAllPresets(true);
                this.mTarget.updateCurrentStationInfoFromPresetBank();
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
            case 1073743004: {
                int n = eventGeneric.getInt(0);
                if (n != 2) break;
                int n3 = eventGeneric.getInt(1);
                this.deletePreset(n3);
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
            case 1073743043: {
                boolean bl;
                RadioData.getDabDatabase().mManualMode = bl = eventGeneric.getBoolean(0);
                if (bl) {
                    SelectedStationHighlighting.setSelectedStationHighlightingIsActive(false);
                    this.mTarget.TraceViewState("EV_DAB_DOWN_TOGGLE_MANUAL_MODE", "Soll Zustand:", false, false, false);
                    this.mTarget.loadManualView();
                    DabDsiApi.canceljumpLM();
                    break;
                }
                this.mTarget.TraceViewState("EV_DAB_DOWN_TOGGLE_MANUAL_MODE", "Soll Zustand:", false, false, true);
                this.mTarget.exitManualView();
                this.mTarget.updatePresetBank();
                break;
            }
            case 0x40000490: {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
                if (serviceInfo == null) break;
                RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                break;
            }
            case 1073742978: {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
                ComponentInfo componentInfo2 = RadioData.getDabDatabase().mTunerState.getNextComponentOfService(serviceInfo);
                if (componentInfo2 != null) {
                    RadioData.getDabDatabase().mTunerState.tuneComponent(componentInfo2, serviceInfo, RadioData.getDabDatabase().mTunerState.getCurrentEnsemble());
                } else if (componentInfo != null) {
                    RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, RadioData.getDabDatabase().mTunerState.getCurrentEnsemble());
                }
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                break;
            }
            case 1073743051: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(8192)) {
                    ServiceManager.logger.trace(8192).append("[TA-DAB]TP set to ").append(bl).log();
                }
                AmfmTPOption.set(bl);
                break;
            }
            case 1073743019: {
                int n = eventGeneric.getInt(0);
                ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(1);
                RadioData.getDabDatabase().dabPresetList.notifyHmi();
                PresetManualPictureStore.storePresetPicture(this.mTarget, n, resourceLocator, 2022113536, RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() * 7, 5128);
                break;
            }
            case 100216: {
                boolean bl = eventGeneric.getBoolean(4);
                if (bl) {
                    ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(3);
                    Integer n = (Integer)eventGeneric.getObject(2);
                    ServiceInfo serviceInfo = RadioData.getDabDatabase().dabPresetList.setManualAssignedPresetLogo(n, resourceLocator);
                    if (RadioUtil.isDabTraceEnabled()) {
                        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), new StringBuffer().append("answer PictureStore - index[").append(n).append("] ResourceLocator[").append(resourceLocator).append("]").toString());
                    }
                    if (null != resourceLocator && null != serviceInfo && RadioDataApi.isSouthSideStationLogoDbActive()) {
                        RadioDataApi.setDabStationLogoInHmiLogoBuffer(resourceLocator, serviceInfo);
                        DabPresetApi.setManualAssignedDabStationLogoForAllPresets(resourceLocator, serviceInfo);
                    }
                    RadioData.getDabDatabase().dabPresetList.notifyHmi();
                } else {
                    RadioDabTraceUtil.errorLogDab("Store preset picture failed");
                }
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
                break;
            }
            case 101019: {
                int n = eventGeneric.getInt(0);
                this.mTarget.handleSyncStatus(n);
                HmiDabListViewApi.notifySyncState();
                break;
            }
            case 1073744320: {
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(eventGeneric);
                DabRadioSlsApi.notifyNewLogoAvailable();
                break;
            }
            case 1027: {
                this.trans(this.mTarget.stateDabDeactivate);
                break;
            }
            case 1073744647: {
                GuiApiDab.updateCurrentStationInfo();
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
                RadioData.listStoreViewEntered = true;
                RadioData.getDabDatabase().mTunerState.serviceInListStoreView = new ServiceInfo(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID, serviceInfo.shortName, serviceInfo.fullName, serviceInfo.ptyCodes, serviceInfo.tp, serviceInfo.radiotext);
                RadioData.getDabDatabase().mTunerState.ensembleInListStoreView = new EnsembleInfo(ensembleInfo.ensID, ensembleInfo.ensECC, ensembleInfo.shortName, ensembleInfo.fullName, ensembleInfo.frequencyLabel, ensembleInfo.frequencyValue, ensembleInfo.tp, ensembleInfo.potentiallyReceivable);
                break;
            }
            case 1073744648: {
                RadioData.listStoreViewEntered = false;
                this.mTarget.updateCurrentStationInfoFromList();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void deletePreset(int n) {
        RadioData.getDabDatabase().dabPresetList.deletePresetPicture(n);
        RadioData.getDabDatabase().dabPresetList.deletePreset(n);
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
        if (serviceInfo != null) {
            int n2 = RadioData.getDabDatabase().dabPresetList.autocompareNew(frequencyInfo, serviceInfo, false);
            this.updatePresets(n2);
        } else {
            RadioData.getDabDatabase().dabPresetList.notifyHmi();
        }
    }

    private void updatePresets(int n) {
        RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(n, false);
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        RadioData.getDabDatabase().dabPresetList.notifyHmi();
        RadioData.getDabDatabase().dabPresetList.notifyFriendsAboutList();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
    }

    private void deleteAllPresets(boolean bl) {
        RadioData.getDabDatabase().dabPresetList.resetPictures();
        RadioData.getDabDatabase().dabPresetList.deleteAllPresets();
        RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(-1, false);
        RadioData.getDabDatabase().dabPresetList.notifyFriendsAboutList();
        if (bl) {
            RadioData.getDabDatabase().dabPresetList.notifyHmi();
        }
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(-1, l);
        RadioDataApi.requestPersistStationLogosInSouthSideDb();
    }

    public void dsiDABTunerUpdateAudioStatus(AudioStatus audioStatus, int n) {
        this.mTarget.trace(new Object[]{"--- DAB audio status: ", audioStatus.toString()});
    }

    public void dsiDABTunerUpdateLinkingUsageStatus(int n, int n2) {
        this.mTarget.trace(new Object[]{"DSI update: Linking usage status: ", Integer.toString(n)});
    }

    public void dsiDABTunerUpdateFrequencyTableSwitchStatus(int n, int n2) {
        RadioData.getDabDatabase().mFrequencyTable.setFrequencyTable(n);
    }
}

