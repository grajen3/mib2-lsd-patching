/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.main.StateDabTop$1;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabTop
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private final AbstractFactoryResetParticipant dabFactoryResetParticipant = new StateDabTop$1(this);

    public StateDabTop(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabTop is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                DabRadioSlsApi.start(this.mTarget.getMainObject(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_SLS, this.mTarget.getTaskId());
                this.mTarget.registerObservers();
                DabDsiApi.start(this.mTarget.getMainObject(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI, this.mTarget.getTaskId());
                DabRadioTextApi.initializeModule(this.mTarget.getMainObject(), this.mTarget.getTaskId());
                RadioData.getDabDatabase().mRadioTextSetupState.set(0);
                HmiDabListViewApi.create(this.mTarget.getMainObject(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_LIST, this.mTarget.getTaskId());
                GuiApiDab.makeSoftLinkingButtonVisible();
                this.mTarget.initFromPersistence();
                this.mTarget.setNotification();
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this.dabFactoryResetParticipant, FactoryResetComponents.RADIO);
                break;
            }
            case 3: {
                this.mTarget.send(ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_MANAGER, -1836646144));
                RadioData.getDabDatabase().setDabTunerIsInitialized(true);
                this.trans(this.mTarget.stateDabNotLoaded);
                break;
            }
            case 4: {
                DabDsiApi.stop();
                break;
            }
            case 1076141833: {
                DabPresetApi.setDabPresetCountFromModel(eventGeneric);
                break;
            }
            case 0x400004B4: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(8192)) {
                    ServiceManager.logger.trace(8192).append("[TA-DAB]DAB other Announcements set to ").append(bl).log();
                }
                RadioData.getDabDatabase().mAnnouncement.setOtherAnnouncement(bl);
                break;
            }
            case 1073743033: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(8192)) {
                    ServiceManager.logger.trace(8192).append("[TA-DAB]DAB traffic Announcements set to ").append(bl).log();
                }
                RadioData.getDabDatabase().mAnnouncement.setTrafficAnnouncement(bl);
                break;
            }
            case 1073743034: {
                RadioData.getDabDatabase().mRadioTextSetupState.set(eventGeneric.getInt(0));
                break;
            }
            case 1073743031: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("SET_DAB_SERVICE_FOLLOWING_STATE with Status : ").append(bl).log();
                }
                RadioData.getDabDatabase().mOptionLinking.setDabFollowing(bl);
                if (this.mTarget.mManualMode) break;
                this.mTarget.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
                break;
            }
            case 1073743032: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("SET_DAB_SERVICE_LINKING_STATE with Status : ").append(bl).log();
                }
                RadioData.getDabDatabase().mOptionLinking.setFmLinking(bl);
                if (this.mTarget.mManualMode) break;
                this.mTarget.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
                break;
            }
            case 1076141832: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("SET_DAB_SOFTLINKING_STATE with Status : ").append(bl).log();
                }
                RadioData.getDabDatabase().mOptionLinking.setSoftLinking(bl);
                if (this.mTarget.mManualMode) break;
                this.mTarget.mDsiDabTuner.switchLinking(RadioData.getDabDatabase().mOptionLinking.getOption());
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("ASL_SOUND_AUDIOMNGMNT_STATUS with Status : ").append(n).append("mTarget.isAudioAvailable() : ").append(this.mTarget.isAudioAvailable()).log();
                }
                if (n == 2 || n == 1) {
                    if (this.mTarget.isAudioAvailable()) break;
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("Going to stateDabPrepareAudio").log();
                    }
                    this.mTarget.setAudioAvailable(true);
                    if (!this.mTarget.dabActive) break;
                    RadioData.getDabDatabase().mAudioManager.resetAudioLock();
                    this.trans(this.mTarget.stateDabPrepareAudio);
                    break;
                }
                if (n != 0) break;
                this.mTarget.setAudioAvailable(false);
                if (!this.mTarget.dabActive) break;
                this.mTarget.changeToMain();
                break;
            }
            case 40613: {
                DabPreset[] dabPresetArray = RadioData.getDabDatabase().dabPresetList.getPresets();
                if (null == dabPresetArray) break;
                eventGeneric.setObject(0, dabPresetArray);
                eventGeneric.setResult(0);
                break;
            }
            case 1200004: {
                switch (eventGeneric.getInt(2)) {
                    case 28180695: {
                        RadioDabTraceUtil.errorLogDab("Diagnosis is changed after startup, so requesting the data");
                        ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.mTarget.getTargetId(), 2005336320);
                        break block0;
                    }
                }
                break;
            }
            case 100215: {
                RadioDabTraceUtil.errorLogDab("Got the feedback from Diagnosis in DAB Top");
                this.mTarget.processDiagnosisData(eventGeneric);
                break;
            }
            case 100238: {
                eventGeneric.setResult(0);
                eventGeneric.setInt(0, 2);
                if (!this.mTarget.dabActive) break;
                this.trans(this.mTarget.stateDabDeactivate);
                break;
            }
            case 100240: {
                eventGeneric.setResult(0);
                break;
            }
            case 101003: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.trans(this.mTarget.stateDabAutostore);
                break;
            }
            case 100248: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateDabTop received EV_DAB_STATION_HIGHLIGHTING_TIMER").log();
                }
                SelectedStationHighlighting.setSelectedStationHighlightingIsActive(false);
                if (ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("STD Target is configured").log();
                    }
                    if (SelectedStationHighlighting.getNewMuteStatusAvailable()) {
                        if (ServiceManager.logger.isTraceEnabled(256)) {
                            ServiceManager.logger.trace(256).append("SelectedStationHighlighting.getNewMuteStatusAvailable() is true").log();
                        }
                        SelectedStationHighlighting.setNewMuteStatusAvailable(false);
                        GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
                    }
                } else {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("In HIGH Target updating the mute status again after preset highlighting timer expires").log();
                    }
                    GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
                }
                RadioData.getDabDatabase().dabPresetList.autoCompare();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateLinkingSwitchStatus(int n, int n2) {
        this.mTarget.trace(new Object[]{"DSI update: Linking switch status: ", Integer.toString(n)});
        RadioData.getDabDatabase().mOptionLinking.set(n);
    }

    public void dsiDABTunerUpdateAvailability(int n, int n2) {
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), new StringBuffer().append("DabTuner:-UpdateAvailability in StateDabTop: ").append(n).toString());
        if (n == 1) {
            this.mTarget.changeToMain();
        }
        RadioData.getDabDatabase().setDabTunerAvailability(n);
    }

    public void dsiDABTunerUpdateFrequencyTableSwitchStatus(int n, int n2) {
        RadioData.getDabDatabase().mFrequencyTable.setFrequencyTable(n);
    }

    public void dsiDABTunerUpdateDetectedDevice(int n, int n2) {
        if (n2 == 1) {
            if (n == 3 || n == 4) {
                RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "dsiDABTunerUpdateDetectedDevice", "DAB Device available");
                RadioData.getDabDatabase().setDabDeviceFitted(true);
            } else {
                RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "dsiDABTunerUpdateDetectedDevice", "DAB Device not available");
                RadioData.getDabDatabase().setDabDeviceFitted(false);
            }
        }
    }

    void resetDabToFactorySettings() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("Factory Reset request from FW").log();
        }
        RadioData.getDabDatabase().resetLSMAndLists(true);
        this.mTarget.resetDABTunerSettings();
        this.mTarget.mDsiDabTuner.reset(1);
        this.mTarget.factoryReset = true;
        DabDsiApi.tuneFrequency(0);
        RadioData.getDabDatabase().mTunerState.setCurrentFrequency(RadioData.getDabDatabase().mTunerState.getNearest(0));
        GuiApiDab.UpdateDefaultStation();
    }
}

