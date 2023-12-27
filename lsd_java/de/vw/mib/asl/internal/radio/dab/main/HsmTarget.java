/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRadioTextOption;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.StateDabActive;
import de.vw.mib.asl.internal.radio.dab.main.StateDabActiveIdle;
import de.vw.mib.asl.internal.radio.dab.main.StateDabActiveLearnMemory;
import de.vw.mib.asl.internal.radio.dab.main.StateDabActiveScanMode;
import de.vw.mib.asl.internal.radio.dab.main.StateDabActiveSeek;
import de.vw.mib.asl.internal.radio.dab.main.StateDabAutostore;
import de.vw.mib.asl.internal.radio.dab.main.StateDabDeactivate;
import de.vw.mib.asl.internal.radio.dab.main.StateDabInactive;
import de.vw.mib.asl.internal.radio.dab.main.StateDabLoad;
import de.vw.mib.asl.internal.radio.dab.main.StateDabNotLoaded;
import de.vw.mib.asl.internal.radio.dab.main.StateDabPrepareAudio;
import de.vw.mib.asl.internal.radio.dab.main.StateDabPrepareSelectLsm;
import de.vw.mib.asl.internal.radio.dab.main.StateDabPrepareTuner;
import de.vw.mib.asl.internal.radio.dab.main.StateDabPrepareTuning;
import de.vw.mib.asl.internal.radio.dab.main.StateDabTop;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class HsmTarget
extends AbstractASLHsmTarget {
    DSIDABTuner mDsiDabTuner;
    public boolean mDoSeek = false;
    HsmState mNextState = null;
    private EventGeneric mCurrentEvent = null;
    private EventGeneric mNextEvent = null;
    private boolean mRestoreAudio = false;
    private boolean mAudioAvailable = true;
    public boolean dabActive = false;
    public boolean userProfileChangeRequested = false;
    public boolean factoryReset = false;
    private final HsmState stateDabTop = new StateDabTop(this, this.hsm, "stateDabTop", this.getWorkStateParent());
    final HsmState stateDabNotLoaded = new StateDabNotLoaded(this, this.hsm, "stateDabNotLoaded", this.stateDabTop);
    final HsmState stateDabLoad = new StateDabLoad(this, this.hsm, "stateDabLoad", this.stateDabTop);
    final HsmState stateDabInactive = new StateDabInactive(this, this.hsm, "stateDabInactive", this.stateDabTop);
    final HsmState stateDabActive = new StateDabActive(this, this.hsm, "stateDabActive", this.stateDabTop);
    final HsmState stateDabAutostore = new StateDabAutostore(this, this.hsm, "stateDabAutostore", this.stateDabTop);
    final HsmState stateDabPrepareTuning = new StateDabPrepareTuning(this, this.hsm, "stateDabPrepareTuning", this.stateDabTop);
    final HsmState stateDabActiveScanMode = new StateDabActiveScanMode(this, this.hsm, "stateDabActiveASLScanMode", this.stateDabActive);
    final HsmState stateDabActiveLearnMemory = new StateDabActiveLearnMemory(this, this.hsm, "stateDabActiveLearnMemory", this.stateDabActive);
    final HsmState stateDabActiveSeek = new StateDabActiveSeek(this, this.hsm, "stateDabActiveSeek", this.stateDabActive);
    final HsmState stateDabActiveIdle = new StateDabActiveIdle(this, this.hsm, "stateDabActiveIdle", this.stateDabActive);
    final HsmState stateDabPrepareAudio = new StateDabPrepareAudio(this, this.hsm, "stateDabPrepareAudio", this.stateDabPrepareTuning);
    final HsmState stateDabPrepareTuner = new StateDabPrepareTuner(this, this.hsm, "stateDabPrepareTuner", this.stateDabPrepareTuning);
    final HsmState stateDabPrepareSelectLSM = new StateDabPrepareSelectLsm(this, this.hsm, "stateDabPrepareSelectLsm", this.stateDabPrepareTuning);
    final HsmState stateDabDeactivate = new StateDabDeactivate(this, this.hsm, "stateDabDeactivate", this.stateDabTop);
    boolean mManualMode = false;
    ConfigurationManager mConfigManager;
    int mCurrentLinkingOption;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;

    public HsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        RadioServiceManager.getServiceManager().setRadioDabTarget(this);
        this.hsm.verbose = false;
        DabDatabase.mDabMainTarget = this;
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateDabTop;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    void trace(Object[] objectArray) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.getTextLogger().trace(256);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                logMessage.append(objectArray[i2]);
            }
            logMessage.log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    public void initFromPersistence() {
        ServiceManager.logger.info(256, "DAB - Loading Persistence Start");
        RadioData.getDabDatabase().mPersistable.mPresets = new DabPreset[RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets()];
        RadioData.getDabDatabase().mPersistable.setWriteAccessBlocked(true);
        RadioData.getDabDatabase().mPersistable.fromPersistence();
        RadioData.getDabDatabase().mPersistable.setWriteAccessBlocked(false);
        ServiceManager.logger.info(256, "DAB - Loading Persistence End");
        this.notifyLastService();
        RadioData.getDabDatabase().mRadioTextSetupState.notifyFriends();
        AmfmRadioTextOption.notifyHMI();
        RadioData.getDabDatabase().mAnnouncement.notifyFriendsAboutTrafficAnnouncement();
        RadioData.getDabDatabase().mAnnouncement.notifyFriendsAboutOtherAnnouncement();
        RadioData.getDabDatabase().mAnnouncement.notifyHMIAboutOtherAnnouncement();
        RadioData.getDabDatabase().mAnnouncement.notifyHMIAboutTrafficAnnouncement();
        RadioData.getDabDatabase().mFrequencyTable.notifyHMIAboutLBandOption();
        RadioData.getDabDatabase().mFrequencyTable.notifyHMIAboutLBandOptionState();
        RadioData.getDabDatabase().mOptionLinking.notifyHMI();
        if (DabPresetApi.isDeletePresetsDatabaseIdsRequested()) {
            RadioData.getDabDatabase().dabPresetList.deleteAllDatabaseStationIds();
        }
        if (DabPresetApi.isDeletePresetsLogoRequested()) {
            RadioData.getDabDatabase().dabPresetList.deleteAllPresetLogos();
        }
    }

    public void updateCurrentStationInfo(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        if (frequencyInfo != null && frequencyInfo.getFrequency() > 0L) {
            this.trace(new StringBuffer().append("--- DSI selected frequency: ").append(frequencyInfo).toString());
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
            if (ensembleInfo != null && ensembleInfo.getEnsID() > 0) {
                DabTunerState.correctEmptyLabels(ensembleInfo);
                if (serviceInfo != null && serviceInfo.sID > 0L) {
                    GuiApiDab.updatePresetList();
                    GuiApiDab.updateEnsembleStateToAvailableAndNotMuted();
                    RadioData.getDabDatabase().mTunerState.correctEmptyLabels(serviceInfo);
                    DabTunerState.correctEmptyLabels(ensembleInfo);
                    RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                    RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
                    RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(ensembleInfo);
                    RadioData.getDabDatabase().mTunerState.saveCurrentEnsemble(ensembleInfo);
                    if (componentInfo != null && componentInfo.sCIDI > 0) {
                        RadioData.getDabDatabase().mTunerState.correctEmptyLabels(componentInfo);
                        RadioData.getDabDatabase().mTunerState.setCurrentComponent(componentInfo);
                    } else {
                        RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
                    }
                    RadioData.getDabDatabase().mPersistable.setCurrentComponent(componentInfo);
                } else {
                    RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
                    RadioData.getDabDatabase().mTunerState.setCurrentEnsemble(ensembleInfo);
                }
            } else {
                RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
            }
        }
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        if (RadioData.getDabDatabase().mInitialStartup) {
            GuiApiDab.UpdateDefaultStation();
        } else {
            GuiApiDab.updateCurrentStationInfo();
        }
        this.notifyRadioTextHsm();
        DabRadioSlsApi.notifyStationChanging();
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void updateCurrentStationInfo(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo) {
        if (frequencyInfo != null && frequencyInfo.getFrequency() > 0L) {
            this.trace(new StringBuffer().append("--- DSI selected frequency: ").append(frequencyInfo).toString());
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
            if (ensembleInfo != null && ensembleInfo.getEnsID() > 0) {
                GuiApiDab.updateEnsembleStateToNoAudio();
            } else {
                GuiApiDab.updateEnsembleStateToNotAvailable();
            }
        }
        RadioData.getDabDatabase().mPersistable.setLinkingService(null, null);
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        if (RadioData.getDabDatabase().mInitialStartup) {
            GuiApiDab.UpdateDefaultStation();
        } else {
            GuiApiDab.updateCurrentStationInfo();
        }
        this.notifyRadioTextHsm();
        DabRadioSlsApi.notifyStationSelected();
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void updateCurrentStationInfo(int n) {
        DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.getPreset(n);
        RadioData.getDabDatabase().mTunerState.setCurrentFrequency(dabPreset.mFrequency);
        GuiApiDab.updatePresetList();
        GuiApiDab.updateEnsembleStateToAvailableAndNotMuted();
        RadioData.getDabDatabase().mTunerState.setCurrentService(dabPreset.getService(), dabPreset.getEnsemble(), dabPreset.mFrequency);
        RadioData.getDabDatabase().mPersistable.setCurrentService(dabPreset.getService());
        RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(dabPreset.getEnsemble());
        RadioData.getDabDatabase().mTunerState.saveCurrentEnsemble(dabPreset.getEnsemble());
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(n, l);
        RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
        GuiApiDab.updateCurrentStationInfo();
        DabRadioSlsApi.notifyStationChanging();
        this.notifyRadioTextHsm();
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void updateCurrentStationInfoFromList() {
        GuiApiDab.updateCurrentStationInfo();
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        GuiApiDab.updatePresetList();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        DabRadioSlsApi.notifyStationChanging();
        this.notifyRadioTextHsm();
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void updateCurrentStationInfoFromPresetBank() {
        GuiApiDab.updateCurrentStationInfo();
        GuiApiDab.updatePresetList();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        DabRadioSlsApi.notifyStationChanging();
        this.notifyRadioTextHsm();
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void newStationSelected(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        boolean bl = true;
        boolean bl2 = true;
        if (serviceInfo != null) {
            serviceInfo.fullName = serviceInfo.fullName.trim();
            serviceInfo.shortName = serviceInfo.shortName.trim();
            bl = RadioData.getDabDatabase().mTunerState.correctEmptyLabels(serviceInfo);
        }
        if (ensembleInfo != null) {
            ensembleInfo.fullName = ensembleInfo.fullName.trim();
            ensembleInfo.shortName = ensembleInfo.shortName.trim();
            bl2 = DabTunerState.correctEmptyLabels(ensembleInfo);
        }
        if (componentInfo != null) {
            if (componentInfo.isPrimaryService()) {
                componentInfo = null;
            } else {
                componentInfo.fullName = componentInfo.fullName.trim();
                componentInfo.shortName = componentInfo.shortName.trim();
            }
        }
        ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mPersistable.getCurrentService();
        ServiceInfo serviceInfo3 = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (serviceInfo != null) {
            Object object;
            if (serviceInfo.sID == 0L || DabTunerState.compare(serviceInfo, serviceInfo2)) {
                RadioData.getDabDatabase().mPersistable.setLinkingService(null, null);
                if (!bl) {
                    RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
                    if (ensembleInfo != null && !bl2) {
                        RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                        RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(ensembleInfo);
                    } else {
                        RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, RadioData.getDabDatabase().mTunerState.getCurrentEnsemble());
                    }
                }
            } else {
                if (null != serviceInfo3 && serviceInfo.sID != serviceInfo3.sID) {
                    DabRadioTextApi.newProgram(serviceInfo.sID);
                }
                DabTunerState.correctEmptyLabels(ensembleInfo);
                RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                RadioData.getDabDatabase().mPersistable.setLinkingService(ensembleInfo, serviceInfo);
            }
            if (componentInfo != null) {
                RadioData.getDabDatabase().mTunerState.correctEmptyLabels(componentInfo);
            }
            RadioData.getDabDatabase().mTunerState.setCurrentComponent(componentInfo);
            RadioData.getDabDatabase().dabPresetList.autoCompare();
            if (!bl) {
                RadioData.getDabDatabase().dabPresetList.setLabels(serviceInfo);
            } else {
                object = RadioData.getDabDatabase().dabPresetList.getCurrentService();
                if (object != null && DabTunerState.compare((ServiceInfo)object, serviceInfo)) {
                    serviceInfo.fullName = ((ServiceInfo)object).fullName;
                    serviceInfo.shortName = ((ServiceInfo)object).shortName;
                }
            }
            if (ensembleInfo != null && bl2 && (object = RadioData.getDabDatabase().dabPresetList.getCurrentEnsemble()) != null && DabTunerState.compare((EnsembleInfo)object, ensembleInfo)) {
                ensembleInfo.fullName = ((EnsembleInfo)object).fullName;
                ensembleInfo.shortName = ((EnsembleInfo)object).shortName;
            }
            GuiApiDab.updatePresetList();
            long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
            GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
            DabRadioSlsApi.notifyStationSelected();
            GuiApiDab.updateCurrentStationInfo();
            HmiDabListViewApi.notifyCurrentStationInfo();
        }
        GuiApiDab.updateSpeechAndBapReceptionList();
    }

    void updateStationInfoLabels(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        RadioData.getDabDatabase().mPersistable.setLinkingService(null, null);
        if (RadioData.getDabDatabase().mInitialStartup) {
            return;
        }
        EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
        if (ensembleInfo2 != null && ensembleInfo != null && DabTunerState.compare(ensembleInfo2, ensembleInfo)) {
            ServiceInfo serviceInfo2;
            String string = ensembleInfo.fullName.trim();
            if (string.length() > 0) {
                ensembleInfo2.fullName = string;
                ensembleInfo2.shortName = ensembleInfo.shortName.trim();
                RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(ensembleInfo2);
            }
            if ((serviceInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentService()) != null && serviceInfo != null && DabTunerState.compare(serviceInfo, serviceInfo2)) {
                ComponentInfo componentInfo2;
                string = serviceInfo.fullName.trim();
                if (string.length() > 0) {
                    serviceInfo2.fullName = string;
                    serviceInfo2.shortName = serviceInfo.shortName.trim();
                    RadioData.getDabDatabase().dabPresetList.setLabels(serviceInfo2);
                    RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo2);
                    GuiApiDab.updatePresetList();
                }
                if ((componentInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentComponent()) != null && componentInfo != null && (string = componentInfo.fullName.trim()).length() > 0) {
                    componentInfo2.fullName = string;
                    componentInfo2.shortName = componentInfo.shortName.trim();
                    RadioData.getDabDatabase().mPersistable.setCurrentComponent(componentInfo2);
                }
            }
        }
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        GuiApiDab.updateCurrentStationInfo();
        DabRadioSlsApi.notifyStationSelected();
    }

    void handleSyncStatus(int n) {
        boolean bl = false;
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (ensembleInfo != null) {
            if (!(RadioData.getDabDatabase().mTunerState.hasAudioServices(ensembleInfo) || serviceInfo != null && DabTunerState.compare(serviceInfo, ensembleInfo))) {
                GuiApiDab.updateEnsembleStateToNoAudio();
            } else {
                RadioData.getDabDatabase().mTunerState.setEnsembleStatus(n);
            }
        } else {
            GuiApiDab.updateEnsembleStateToNotAvailable();
        }
        switch (n) {
            case 1: {
                DabRadioSlsApi.signalLost();
                bl = true;
                break;
            }
            case 2: {
                DabRadioSlsApi.signalLost();
                bl = true;
                break;
            }
            case 3: {
                DabRadioSlsApi.signalLost();
                bl = true;
                break;
            }
            case 4: {
                DabRadioSlsApi.signalAvailable();
                bl = false;
                break;
            }
            default: {
                bl = true;
            }
        }
        RadioData.getDabDatabase().mTunerState.setServiceMuted(bl);
        RadioData.getDabDatabase().mTunerState.calcServiceState();
        int n2 = RadioData.getDabDatabase().mTunerState.getCurrentServiceState();
        if (bl && n2 != 3 || serviceInfo == null) {
            RadioData.getDabDatabase().mAudioManager.setMuted(true);
            DabRadioTextApi.signalLost();
        } else {
            RadioData.getDabDatabase().mAudioManager.setMuted(false);
            DabRadioTextApi.signalAvailable();
        }
        GuiApiDab.updateServiceState(n2);
    }

    void processDiagnosisData(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        if (n == -687821311 && l == 1L) {
            Coding coding = (Coding)eventGeneric.getObject(1);
            int n2 = RadioData.getDabDatabase().mPersistable.getBand1();
            int n3 = RadioData.getDabDatabase().mPersistable.getBand2();
            if (coding != null) {
                int n4 = coding.getValue(47);
                int n5 = coding.getValue(48);
                if (n2 != n4 || n3 != n5) {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.info(256).append("Change in DAB Band coding, so resetting the Service : ").append(new StringBuffer().append("Previous Band1 : ").append(n2).append("Previous Band2 : ").append(n3).toString()).append(new StringBuffer().append("New Band1 : ").append(n4).append("New Band2 : ").append(n5).toString()).log();
                    }
                    RadioData.getDabDatabase().mPersistable.setCurrentBand1(n4);
                    RadioData.getDabDatabase().mPersistable.setCurrentBand2(n5);
                    RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(null);
                    RadioData.getDabDatabase().mPersistable.setCurrentService(null);
                    RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
                    RadioData.getDabDatabase().mPersistable.setLinkingService(null, null);
                    RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(-1);
                    RadioData.getDabDatabase().mInitialStartup = true;
                }
                if (n4 == 0 && n5 == 0) {
                    EntertainmentManagerResponder entertainmentManagerResponder;
                    RadioDabTraceUtil.errorLogDab("DAB band is completely Decoded so Changing to FM Band");
                    if (RadioCurrentWaveband.get() == 2 && null != (entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER))) {
                        entertainmentManagerResponder.weakRequest(1);
                    }
                } else {
                    RadioData.getDabDatabase().mFrequencyTable.initFromDiagnosis(n4, n5);
                }
                RadioData.getDabDatabase().mAnnouncement.setAlarmActivatd(coding.getBoolean(58));
            }
        }
    }

    boolean activateStationById(long l) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.info(256).append("HsmTarget - activateStationById with id : ").append(l).log();
        }
        boolean bl = RadioData.getDabDatabase().mTunerState.tuneStationById(l);
        this.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
        return bl;
    }

    boolean tuneLastService() {
        boolean bl = false;
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mPersistable.getCurrentService();
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mPersistable.getCurrentEnsemble();
        ComponentInfo componentInfo = RadioData.getDabDatabase().mPersistable.getCurrentComponent();
        DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.getLastTunedPreset();
        GuiApiDab.setActivePreset(RadioData.getDabDatabase().dabPresetList.getLastTunedIndex());
        GuiApiDab.updateIndexOfPresetBank(RadioData.getDabDatabase().dabPresetList.getVisibleBankIndex());
        ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mPersistable.getLinkingService();
        EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mPersistable.getLinkingEnsemble();
        if (this.factoryReset) {
            DabDsiApi.tuneFrequency(0);
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(RadioData.getDabDatabase().mTunerState.getNearest(0));
            GuiApiDab.UpdateDefaultStation();
            bl = true;
            this.factoryReset = false;
        } else if (serviceInfo2 != null) {
            RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo2, ensembleInfo2);
            GuiApiDab.updateCurrentStationInfo();
            bl = true;
        } else if (componentInfo != null) {
            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
            RadioData.getDabDatabase().mTunerState.setCurrentComponent(componentInfo);
            RadioData.getDabDatabase().mTunerState.tuneComponent(componentInfo, serviceInfo, ensembleInfo);
            GuiApiDab.updateCurrentStationInfo();
            bl = true;
            if (dabPreset != null) {
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(dabPreset);
            }
        } else if (dabPreset != null && DabTunerState.compare(dabPreset.getService(), serviceInfo) && dabPreset.mFrequency.frequency == (long)ensembleInfo.frequencyValue) {
            dabPreset.tune();
            bl = true;
            RadioData.getDabDatabase().mTunerState.setCurrentService(dabPreset.getService(), dabPreset.getEnsemble());
            GuiApiDab.updateCurrentStationInfo();
        } else if (serviceInfo != null) {
            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
            GuiApiDab.updateCurrentStationInfo();
            RadioData.getDabDatabase().mTunerState.tuneServiceByFrequency(serviceInfo, ensembleInfo, RadioData.getDabDatabase().mTunerState.getFrequencyById(serviceInfo.ensID, serviceInfo.ensECC));
            bl = true;
        }
        if (!bl) {
            DabDsiApi.tuneFrequency(0);
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(RadioData.getDabDatabase().mTunerState.getNearest(0));
            GuiApiDab.UpdateDefaultStation();
        }
        RadioData.getDabDatabase().dabPresetList.notifyHmi();
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi(), true);
        RadioData.getDabDatabase().dabPresetList.notifyHmiAboutVisibleBank();
        RadioData.getDabDatabase().mInitialStartup = !bl;
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        this.notifyRadioTextHsm();
        return bl;
    }

    boolean notifyLastService() {
        RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
        GuiApiTunerCommon.setDabRadioTextLoadingStateToLoading();
        boolean bl = false;
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mPersistable.getCurrentService();
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mPersistable.getCurrentEnsemble();
        ComponentInfo componentInfo = RadioData.getDabDatabase().mPersistable.getCurrentComponent();
        DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.getLastTunedPreset();
        ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mPersistable.getLinkingService();
        if (serviceInfo2 != null) {
            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
            RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
            GuiApiDab.updateCurrentStationInfo();
            bl = true;
        } else if (componentInfo != null) {
            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
            RadioData.getDabDatabase().mTunerState.setCurrentComponent(componentInfo);
            GuiApiDab.updateCurrentStationInfo();
            bl = true;
            if (dabPreset != null) {
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(dabPreset);
            }
        } else if (dabPreset != null && DabTunerState.compare(dabPreset.getService(), serviceInfo) && dabPreset.mFrequency.frequency == (long)ensembleInfo.frequencyValue) {
            bl = true;
            RadioData.getDabDatabase().mTunerState.setCurrentService(dabPreset.getService(), dabPreset.getEnsemble());
            GuiApiDab.updateCurrentStationInfo();
        } else if (serviceInfo != null) {
            RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
            GuiApiDab.updateCurrentStationInfo();
            bl = true;
        }
        if (!bl) {
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(RadioData.getDabDatabase().mTunerState.getDefaultFrequency());
            GuiApiDab.UpdateDefaultStation();
        }
        RadioData.getDabDatabase().dabPresetList.notifyHmi();
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        RadioData.getDabDatabase().dabPresetList.notifyHmiAboutVisibleBank();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
        return bl;
    }

    void registerObservers() {
        this.addObservers(new int[]{161424448, 614285568, -2075192832, 352926976, 671694080, 654916864, -1794899904, -485883840, -419168192, -821821376, -670826432, -1711013824, -1509687232, -1023147968, -805044160, -654049216, -855375808, -872153024, -788266944, -620494784, -754712512, -1123811264, -1962672064, -1895563200, -1694236608, -1677459392, -1811677120, -553385920, -1459355584, -1593573312, -1979449280, -1929117632, -402390976, -1727791040, -888930240, -1425801152, -1660682176, -972816320, 722075712, -1073151936, 1443430464, -1174142912, -1274806208, -1190920128, -1224474560, -1207697344, 144647232, -1056702400, -1392246720, -1996226496, -1945894848, -2063335360, -1862008768, -1878785984, -2113667008, -1492910016, -1610350528, -1291583424, -2046558144, -2080112576, -1912340416, -2013003712, 118161472, 134938688, -967043840});
    }

    void setNotification() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiDabTuner = (DSIDABTuner)dSIProxy.getService(this, class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener);
        int[] nArray = new int[]{11, 18, 14, 19, 15, 27, 20, 21};
        this.mDsiDabTuner.setNotification(nArray, dSIListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener, dSIListener);
    }

    public void switchLBandState(boolean bl) {
        if (bl) {
            this.mDsiDabTuner.switchFrequencyTable(1);
        } else {
            this.mDsiDabTuner.switchFrequencyTable(8);
        }
    }

    public void resetDABTunerSettings() {
        RadioData.getDabDatabase().mOptionLinking.reset();
        this.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
        RadioData.getDabDatabase().mAnnouncement.reset();
        if (RadioData.getDabDatabase().mFrequencyTable.getLBandOptionAvailable() && !RadioData.getDabDatabase().mFrequencyTable.getLBandOptionState()) {
            this.switchLBandState(true);
        }
        RadioData.getDabDatabase().mRadioTextSetupState.reset();
    }

    public void informDSINewUserSettings() {
        this.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
        if (RadioData.getDabDatabase().mFrequencyTable.getLBandOptionAvailable()) {
            boolean bl = RadioData.getDabDatabase().mFrequencyTable.getLBandOptionState();
            this.switchLBandState(bl);
        } else {
            this.switchLBandState(false);
        }
    }

    void TraceViewState(String string, String string2, boolean bl, boolean bl2, boolean bl3) {
        String string3 = new StringBuffer().append("Event: ").append(string).append(" - ").append(string2).append(" ServiceListView [").append(bl).append("] ComponentListView [").append(bl2).append("] ManualView [").append(bl3).append("]").toString();
        this.traceDab(string3);
    }

    void traceDab(String string) {
        RadioDabTraceUtil.traceDab(this.getTargetId(), string);
    }

    void updatePresetBank() {
        RadioData.getDabDatabase().dabPresetList.autoCompare();
        GuiApiDab.updatePresetList();
        HmiDabListViewApi.notifyPresetBank();
        long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), l);
    }

    void storeCurrentStationPreset(int n) {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
        if (RadioData.listStoreViewEntered && !DabTunerState.compare(serviceInfo, RadioData.getDabDatabase().mTunerState.serviceInListStoreView)) {
            serviceInfo = RadioData.getDabDatabase().mTunerState.serviceInListStoreView;
            ensembleInfo = RadioData.getDabDatabase().mTunerState.ensembleInListStoreView;
            RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
        }
        if (serviceInfo != null && RadioData.getDabDatabase().dabPresetList.setPreset(ensembleInfo, serviceInfo, n, true, true)) {
            RadioData.getDabDatabase().dabPresetList.notifyHmi();
            RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(n, false);
            RadioData.getDabDatabase().dabPresetList.notifyFriendsAboutList();
            GuiApiDab.updateBapCurrentStationIndices(n, DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID));
            RadioSystemEventsUtil.sendPresetStored();
        }
    }

    void activatePreset(int n) {
        DabPreset[] dabPresetArray = RadioData.getDabDatabase().dabPresetList.getPresets();
        if (null == dabPresetArray) {
            return;
        }
        if (n < 0 || n >= dabPresetArray.length) {
            return;
        }
        DabPreset dabPreset = dabPresetArray[n];
        if (dabPreset != null) {
            SelectedStationHighlighting.setSelectedStationHighlightingIsActive(true);
            int n2 = RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            if (n == n2) {
                ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getNextComponentOfService(serviceInfo);
                if (componentInfo != null) {
                    RadioData.getDabDatabase().mTunerState.tuneComponent(componentInfo, serviceInfo, RadioData.getDabDatabase().mTunerState.getCurrentEnsemble());
                    this.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), serviceInfo, componentInfo);
                } else if (0 != RadioData.getDabDatabase().mTunerState.getCurrentServiceState() || null != RadioData.getDabDatabase().mTunerState.getCurrentComponent()) {
                    RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(dabPreset);
                    dabPreset.tune();
                    DabRadioSlsApi.notifyStationChanging();
                }
            } else {
                RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(dabPreset);
                if (0 != RadioData.getDabDatabase().mTunerState.getCurrentServiceState() || null != RadioData.getDabDatabase().mTunerState.getCurrentComponent() || !DabTunerState.compare(serviceInfo, dabPreset.getService())) {
                    dabPreset.tune();
                    this.updateCurrentStationInfo(n);
                    DabRadioSlsApi.notifyStationChanging();
                } else {
                    long l = RadioData.getDabDatabase().mTunerState.getCurrentStationId();
                    GuiApiDab.updateBapCurrentStationIndices(n, l);
                }
            }
        }
        HmiDabListViewApi.notifyCurrentStationInfo();
    }

    void notifyRadioTextHsm() {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        long l = serviceInfo != null ? serviceInfo.sID : 0L;
        DabRadioTextApi.newProgram(l);
    }

    void setCurrentEvent(EventGeneric eventGeneric) {
        if (this.mCurrentEvent != null) {
            this.mCurrentEvent.setBlocked(false);
            ServiceManager.mGenericEventFactory.freeEvent(this.mCurrentEvent);
        }
        if (eventGeneric != null) {
            eventGeneric.setBlocked(true);
        }
        this.mCurrentEvent = eventGeneric;
    }

    EventGeneric getCurrentEvent() {
        return this.mCurrentEvent;
    }

    void setNextEvent(EventGeneric eventGeneric) {
        if (this.mNextEvent != null) {
            this.mNextEvent.setBlocked(false);
            ServiceManager.mGenericEventFactory.freeEvent(this.mNextEvent);
        }
        if (eventGeneric != null) {
            eventGeneric.setBlocked(true);
        }
        this.mNextEvent = eventGeneric;
    }

    EventGeneric getNextEvent() {
        return this.mNextEvent;
    }

    void setNextAsCurrent() {
        this.setCurrentEvent(this.mNextEvent);
        this.mNextEvent = null;
    }

    void sendAnswer(int n) {
        if (this.mCurrentEvent != null) {
            this.mCurrentEvent.setResult(n);
            this.mCurrentEvent.setBlocked(false);
            this.mCurrentEvent.setInt(0, 2);
            this.sendBack(this.mCurrentEvent);
            this.mCurrentEvent = null;
        }
    }

    public boolean isTunerAvailable() {
        ASLStartupv7rAPI aSLStartupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
        if (null != aSLStartupv7rAPI) {
            return RadioData.getDabDatabase().getDabTunerAvailability() == 2 || aSLStartupv7rAPI.isHighActivatorStarted();
        }
        return RadioData.getDabDatabase().getDabTunerAvailability() == 2;
    }

    boolean isAudioAvailable() {
        return this.mAudioAvailable;
    }

    void setAudioAvailable(boolean bl) {
        this.mAudioAvailable = bl;
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("mAudioAvailable : ").append(bl).log();
        }
        if (!bl) {
            this.mRestoreAudio = true;
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("mRestoreAudio : ").append(this.mRestoreAudio).log();
            }
        }
    }

    void setAudioRestored() {
        this.mRestoreAudio = false;
    }

    boolean restoreAudio() {
        return this.mRestoreAudio;
    }

    boolean isDeactivated() {
        return this.mCurrentEvent != null && (this.mCurrentEvent.getReceiverEventId() == -1870200576 || this.mCurrentEvent.getReceiverEventId() == 1026);
    }

    void exitManualView() {
        this.mManualMode = false;
        if (this.mCurrentLinkingOption != 1) {
            this.mDsiDabTuner.switchLinking(this.mCurrentLinkingOption);
        }
        DabDsiApi.notifyLeaveManualMode();
        GuiApiTunerCommon.updateRadioManualMode(false);
        this.trace("--- leave stateManualMode");
    }

    void loadManualView() {
        this.mManualMode = true;
        this.mCurrentLinkingOption = RadioData.getDabDatabase().mOptionLinking.getOption();
        if (this.mCurrentLinkingOption != 1) {
            this.mDsiDabTuner.switchLinking(1);
        }
        GuiApiDab.updateCurrentStationInfo();
        this.trace("--- enter stateManualMode");
        GuiApiTunerCommon.updateRadioManualMode(true);
    }

    void changeToMain() {
        RadioSystemEventsUtil.sendReturnToMain();
        HmiDabListViewApi.notifyTunerNotAvailable();
        if (this.mManualMode) {
            this.exitManualView();
        }
    }

    HsmState getStateDabTop() {
        return this.stateDabTop;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

