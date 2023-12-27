/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.manager;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentActivation;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioAdaptationAdapter;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget$1;
import de.vw.mib.asl.internal.radio.manager.Tuner;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.DSIDABTunerListener;

public final class ManagerTarget
extends AbstractTarget {
    Logger logger = ServiceManager.logger;
    public static boolean isRadioActive = false;
    public static boolean mIsMuteActive = false;
    private boolean mPowerOnAlreadyReceived = false;
    private Tuner mLastTuner = null;
    private Tuner[] mTuner;
    private static final int AM;
    private static final int FM;
    private static final int DAB;
    private static final int SDARS;
    int activeContext = 1;
    private boolean ignoreLastAudioMode = false;
    DSIDABTuner mDsiDabTuner;
    DSIDABTunerListener dsidabTunerListener;
    private boolean cancelledPending;
    private boolean deactivatePending;
    private static boolean activationRunning;
    private boolean mAudioAvailable = true;
    private boolean autostoreAudioMute = false;
    private boolean autoStoreFinished = false;
    private boolean entWavebandIsDifferent = false;
    private final AbstractFactoryResetParticipant amfmFactoryResetParticipant = new ManagerTarget$1(this);
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService;

    public ManagerTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("ManagerTarget - ManagerTarget()").log();
        }
        this.mTuner = new Tuner[4];
        this.mTuner[0] = new Tuner("AM", ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM);
        this.mTuner[1] = new Tuner("FM", ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM);
        this.mTuner[2] = new Tuner("DAB", ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        this.mTuner[3] = new Tuner("SDARS", ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET);
        this.deactivatePending = false;
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_RADIO_MANAGER;
    }

    private void registerObservers() {
        this.addObserver(-1017375488);
        this.addObserver(-967043840);
        this.addObserver(118045952);
        this.addObserver(362627328);
        this.addObserver(352926976);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.mPowerOnAlreadyReceived) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received POWER_ON, mPowerOnAlreadyReceived = ").append(this.mPowerOnAlreadyReceived).log();
                }
                this.mPowerOnAlreadyReceived = true;
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1484390144);
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this.amfmFactoryResetParticipant, FactoryResetComponents.RADIO);
                break;
            }
            case 100007: {
                int n = eventGeneric.getInt(2);
                long l = eventGeneric.getLong(3);
                if (n != -687821311 || l != 1L) break;
                RadioCodingAdapter.mAmFmCodingData = (Coding)eventGeneric.getObject(1);
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1350172416);
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_RADIO_MANAGER_ANSWER_DIAGNOSIS_CODING_DATA").log();
                break;
            }
            case 100015: {
                int n = eventGeneric.getInt(2);
                long l = eventGeneric.getLong(3);
                if (n != -536825343 || l != 0) break;
                RadioAdaptationAdapter.mAmFmAdaptationData = (Adaptation)eventGeneric.getObject(1);
                this.send(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -1819868928));
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_RADIO_MANAGER_ANSWER_DIAGNOSIS_ADAPTATION_DATA").log();
                break;
            }
            case 100244: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received AM_FM_TUNER_IS_INITIALIZED").log();
                }
                RadioDabTraceUtil.traceDab(this.getTargetId(), "Radio Manager Power On: mGlobalAvailability = false");
                this.registerObservers();
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-899934976);
                eventGeneric2.setInt(0, 1);
                eventGeneric2.setInt(1, 1324);
                this.send(eventGeneric2);
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                ServiceManager.aslPropertyManager.valueChangedInteger(1710, 1);
                RadioData.amFmTunerIsCompletelyInitialized = true;
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().resetLoadedPersistenceAndAnswerCallBack();
                break;
            }
            case 100247: {
                break;
            }
            case 100242: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received NOTIFY_TARGET_READY_TO_WORK").log();
                }
                int n = eventGeneric.getSenderTargetId();
                for (int i2 = 0; i2 < this.mTuner.length; ++i2) {
                    if (this.mTuner[i2].getTID() != n) continue;
                    this.mTuner[i2].setLoaded();
                    if (this.mTuner[i2] != this.mLastTuner) continue;
                    this.mTuner[i2].activate();
                }
                RadioHASUpdater.setTunerAvailable(n);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 1) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received AudioMgmnt Available").log();
                    }
                    this.mAudioAvailable = true;
                    break;
                }
                if (n == 0) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received AudioMgmnt Unavailable").log();
                    }
                    this.mAudioAvailable = false;
                    break;
                }
                if (n != 2) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received AudioMgmnt Restore Connections").log();
                }
                this.mAudioAvailable = true;
                if (!this.autostoreAudioMute || !this.autoStoreFinished) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("Releasing mute and FM lock after autostore finished").log();
                }
                AudioConnectionUtils.requestMuteAndVolumeLockForRadio(false, this);
                this.autostoreAudioMute = false;
                break;
            }
            case 100227: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_AUTOSTORE_STARTED, mIsRadio = ").append(isRadioActive).log();
                }
                this.autoStoreFinished = false;
                this.autostoreAudioMute = false;
                if (isRadioActive) {
                    if (this.mLastTuner != this.mTuner[1]) {
                        this.fireModelActivateBandEvent(1);
                    }
                    if (!this.mAudioAvailable) break;
                    AudioConnectionUtils.requestMuteAndVolumeLockForRadio(true, this);
                    this.autostoreAudioMute = true;
                    break;
                }
                RadioCurrentWaveband.set(1);
                this.mLastTuner = this.mTuner[1];
                break;
            }
            case 100228: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_AUTOSTORE_FINISHED, mIsRadio = ").append(isRadioActive).log();
                }
                int n = eventGeneric.getInt(0);
                if (isRadioActive) {
                    this.fireModelActivateBandEvent(n);
                } else {
                    RadioCurrentWaveband.set(n);
                    this.mLastTuner = this.mTuner[1];
                }
                if (this.mAudioAvailable && this.autostoreAudioMute) {
                    AudioConnectionUtils.requestMuteAndVolumeLockForRadio(false, this);
                    this.autostoreAudioMute = false;
                }
                this.autoStoreFinished = true;
                break;
            }
            case 1400006: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASLEntertainmentmanagerServiceIds.CANCEL with activationRunning : ").append(activationRunning).log();
                }
                if (activationRunning) {
                    this.cancelledPending = true;
                    break;
                }
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
                eventGeneric3.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_MANAGER);
                this.sendSafe(eventGeneric3);
                break;
            }
            case 0x155CC5: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASLEntertainmentmanagerServiceIds.DEACTIVATE").log();
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    TaggingApi.notifyAMFMStationChanged();
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(418)) {
                    EventGeneric eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 1686256384);
                    this.send(eventGeneric4);
                }
                SelectedStationHighlighting.setStationSelectionIsActive(false, true);
                this.deactivatePending = true;
                this.setRadio(false, -1);
                break;
            }
            case 1400003: {
                EntertainmentActivation entertainmentActivation = (EntertainmentActivation)eventGeneric.getObject(0);
                int n = entertainmentActivation.getSubcontext();
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASLEntertainmentmanagerServiceIds.ACTIVATE - band = ").append(n).log();
                }
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASLEntertainmentmanagerServiceIds.ACTIVATE - band = ").append(n).log();
                }
                this.setRadio(true, n);
                break;
            }
            case 1400004: {
                int n;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASLEntertainmentmanagerServiceIds.ACTIVATE_STARTUP").log();
                }
                boolean bl = (n = eventGeneric.getInt(0)) == 1;
                int n2 = eventGeneric.getInt(1);
                if (n2 != RadioCurrentWaveband.get()) {
                    this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager - Startup Wavebands are different EntManager wb is = ").append(n2).append(" current wb is = ").append(RadioCurrentWaveband.get()).log();
                    n2 = RadioCurrentWaveband.get();
                    this.entWavebandIsDifferent = true;
                }
                if (this.ignoreLastAudioMode) break;
                this.ignoreLastAudioMode = true;
                this.setRadio(bl, n2);
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("received ASL_LSM_START_ENTERTAINMENT_CONTEXT, mIsRadio = ").append(isRadioActive).log();
                break;
            }
            case 100229: 
            case 3900001: {
                activationRunning = false;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_RADIO_ANSWER_ACTIVATE = ").append(eventGeneric.getResult() == 0).append("with cancelledPending - ").append(this.cancelledPending).log();
                }
                EventGeneric eventGeneric5 = null;
                if (this.cancelledPending) {
                    this.cancelledPending = false;
                    eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
                } else {
                    eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(-1067707136);
                }
                eventGeneric5.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_MANAGER);
                this.sendSafe(eventGeneric5);
                if (!this.entWavebandIsDifferent) break;
                this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager - Triggering weakrequest() due to different band").log();
                EntertainmentManagerResponder entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER);
                if (null != entertainmentManagerResponder) {
                    entertainmentManagerResponder.weakRequest(RadioCurrentWaveband.get());
                }
                this.entWavebandIsDifferent = false;
                break;
            }
            case 100230: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_RADIO_ANSWER_DEACTIVATE").log();
                }
                this.stopTimer(-2021195520);
            }
            case 100231: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received EV_TIMER_TUNER_DEACTIVATED").log();
                }
                if (this.deactivatePending) {
                    EventGeneric eventGeneric6 = ServiceManager.mGenericEventFactory.newEvent(-1050929920);
                    eventGeneric6.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_MANAGER);
                    this.sendSafe(eventGeneric6);
                    this.deactivatePending = false;
                }
                if (eventGeneric.getResult() != 0 || !isRadioActive || activationRunning) break;
                this.activateLast();
                break;
            }
            case 4000007: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("RadioManager received ASL_SOUND_USERMUTE_IS_ACTIVE").log();
                }
                mIsMuteActive = eventGeneric.getBoolean(0);
                break;
            }
            case 3700256: {
                boolean bl = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("ASLPicturestoreServiceIds.PICTURESTORE_STATUS - ").append(bl).log();
                }
                PresetManualPictureStore.setPictureStoreTargetAvailable(bl);
                break;
            }
        }
    }

    private void activateBand(int n) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("activateBand, newWaveband: ").append(n).append("  current waveband: ").append(RadioCurrentWaveband.getWavebandString()).log();
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("activateBand, newWaveband: ").append(n).append("  current waveband: ").append(RadioCurrentWaveband.getWavebandString()).log();
            }
            if (n != RadioCurrentWaveband.get()) {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    ListManager.getGenericASLList(1270).clear();
                }
                if (RadioCurrentWaveband.isAm(n) && RadioCurrentWaveband.isFm() || RadioCurrentWaveband.isFm(n) && RadioCurrentWaveband.isAm()) {
                    RadioCurrentWaveband.set(n);
                    this.activateLast();
                } else {
                    int n2 = RadioCurrentWaveband.get();
                    this.deactivateLast();
                    RadioCurrentWaveband.set(n);
                    if (n2 != 2) {
                        this.activateLast();
                    }
                }
            } else {
                this.activateLast();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void setRadio(boolean bl, int n) {
        try {
            if (!bl) {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("radio off").log();
                }
                this.deactivateLast();
                isRadioActive = false;
            } else {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("radio on").log();
                }
                this.activateBand(n);
                isRadioActive = true;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void activateLast() {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("activateLast mLastTuner = ").append(this.getTunerAsString()).log();
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("activateLast mLastTuner = ").append(this.getTunerAsString()).log();
            }
            RadioHASUpdater.updateBand();
            this.mLastTuner = this.getTuner();
            this.mLastTuner.activate();
            activationRunning = true;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void deactivateLast() {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("deactivateLast mLastTuner = ").append(this.getTunerAsString()).log();
            }
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                this.logger.trace(4).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("deactivateLast mLastTuner = ").append(this.getTunerAsString()).log();
            }
            if (this.mLastTuner != null) {
                if (RadioCurrentWaveband.isDab()) {
                    this.startTimer(-2021195520, (long)0, false);
                }
                this.mLastTuner.deactivate();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private Tuner getTuner() {
        try {
            switch (RadioCurrentWaveband.get()) {
                case 0: {
                    return this.mTuner[0];
                }
                case 1: {
                    return this.mTuner[1];
                }
                case 2: {
                    return this.mTuner[2];
                }
                case 3: {
                    return this.mTuner[3];
                }
            }
            return this.mTuner[1];
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return this.mTuner[1];
        }
    }

    private String getTunerAsString() {
        try {
            switch (RadioCurrentWaveband.get()) {
                case 0: {
                    return "mTuner[AM]";
                }
                case 1: {
                    return "mTuner[FM]";
                }
                case 2: {
                    return "mTuner[DAB]";
                }
                case 3: {
                    return "mTuner[SDARS]";
                }
            }
            return "mTuner[FM]";
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "mTuner[FM]";
        }
    }

    private void fireModelActivateBandEvent(int n) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append("firing ACTIVATE_BAND model event: ").append(n).log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, n);
            this.triggerObserver(-2096889792, eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void resetAmFmToFactorySettings() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("Factory Reset request from FW, and mIsRadio = ").append(isRadioActive).log();
        }
        RadioData.resetAMFMTunerSettings();
        EntertainmentManagerCoreService entertainmentManagerCoreService = (EntertainmentManagerCoreService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = ManagerTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService);
        if (null != entertainmentManagerCoreService && entertainmentManagerCoreService.getContext() == 1) {
            if (!RadioCurrentWaveband.isFm()) {
                this.fireModelActivateBandEvent(1);
            } else {
                this.send(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 2139554048));
            }
        } else {
            EntertainmentManagerResponder entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER);
            entertainmentManagerResponder.weakRequest(1);
            this.mLastTuner = this.mTuner[1];
        }
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

