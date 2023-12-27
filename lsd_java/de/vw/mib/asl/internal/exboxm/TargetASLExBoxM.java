/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentActivation;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudio;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudioEntertainment;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudioEntertainmentEvents;
import de.vw.mib.asl.internal.exboxm.ExBoxMDisplay_SM;
import de.vw.mib.asl.internal.exboxm.ExBoxMVolume;
import de.vw.mib.asl.internal.exboxm.IntStringMap;
import de.vw.mib.asl.internal.exboxm.factoryreset.AudioFactoryResetParticipant;
import de.vw.mib.asl.internal.exboxm.factoryreset.SystemFactoryResetParticipant;
import de.vw.mib.asl.internal.exboxm.persistence.KoreaProfileChangeListener;
import de.vw.mib.asl.internal.exboxm.persistence.PersistableExBoxOptions;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicantFactory;
import de.vw.mib.asl.internal.exboxm.state.ExboxOperationStateListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.DSIExBoxM;
import org.dsi.ifc.exboxm.DSIExBoxMListener;

public class TargetASLExBoxM
extends AbstractASLTarget
implements ExboxOperationStateListener {
    private ExboxServices exboxServices = ExboxServicesProvider.getExBoxServices();
    private final ExboxLogger exboxLogger = new ExboxLogger(this.exboxServices.getLogger(), class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM == null ? (class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM = TargetASLExBoxM.class$("de.vw.mib.asl.internal.exboxm.TargetASLExBoxM")) : class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM);
    private static final boolean FORCE_ERROR_LOG = Boolean.getBoolean("asl.exboxm.log.error");
    private DSIExBoxM dsiExBoxM;
    private DSISound dsiSound;
    private DSIAudioManagement dsiAudioManagement;
    private PersistableExBoxOptions persistableExBoxOptions;
    private ExBoxMDisplay_SM exBoxMDisplay_SM;
    private ExBoxMAudio exBoxMAudio;
    private ExBoxMAudioEntertainment exBoxMAudioEntertainment;
    private ExboxStateService exboxStateService;
    private ExBoxMVolume exBoxMVolume;
    private static final IntStringMap AUXAUDIOSOURCE_TO_NAME_MAP = new IntStringMap("Unknown", new int[]{0, 1, 2, 3, 4, 5}, new String[]{"None", "Phone", "BT", "SDS", "Ringtone", "TTS"});
    private static final IntStringMap VDAAUDIOSOURCE_TO_NAME_MAP = new IntStringMap("Unknown", new int[]{0, 1, 2}, new String[]{"None", "Nav", "EA"});
    private static final IntStringMap ACTIVATE_CONTEXT_TO_NAME_MAP = new IntStringMap("Unknown", new int[]{0, 1, 3, 4, 7, 8}, new String[]{"Standby", "DMB", "Navigation", "TPEG", "EA", "SDS"});
    private int uniqueId = 0;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$DSIExBoxM;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$DSIExBoxMListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;

    public TargetASLExBoxM(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1329327616;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 106: {
                this.processAslEventPowerOn();
                break;
            }
            case 4300054: {
                break;
            }
            case 4300062: {
                this.persistableExBoxOptions.writePersistenceValuesToModel();
                break;
            }
            case 100000: {
                this.exboxLogger.trace("Received EV_EXBOX_SOUND_SET_ENTERTAINMENT_CONNECTION_ANSWER.");
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getResult();
                this.exBoxMAudioEntertainment.handleSoundEntConnectionAnswer(n, n2 == 0);
                if (n2 == 0) break;
                this.errorEx().append("EX:ASL>ASL AudioManager Entertainment source connection failed: ").append(n).append(" result: ").append(n2).log();
                break;
            }
            case 100003: {
                this.exboxLogger.trace("Received EV_EXBOX_SOUND_SET_INDICATION_CONNECTION_ANSWER.");
                int n = eventGeneric.getInt(0);
                if (eventGeneric.getResult() == 0) {
                    this.exBoxMAudio.markDsiAudioConnectionAsEstablished(n);
                    break;
                }
                this.exboxLogger.error(new StringBuffer().append("ASL>ASL AudioManager Audio source connection failed: ").append(n).toString());
                this.exBoxMAudio.markDsiAudioConnectionAsNotConnected(n);
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                this.exboxLogger.trace(new Object[]{"Received ASL event ASL_SOUND_AUDIO_CONNECTION_RELEASED for connection ", new Integer(n), "."});
                if (n == 220 || n == 221) {
                    if (this.exBoxMAudio.isNavRequestedOrConnected()) {
                        if (this.isExBoxOperationStateNormal()) {
                            if (n == 220) {
                                this.dsiExBoxM.audioRequestRejected(1, 1);
                                this.exboxLogger.trace("ASL>DSI Audio Connection was released, Reject NAV_TEL to ExBox");
                            } else {
                                this.dsiExBoxM.audioRequestRejected(0, 1);
                                this.exboxLogger.trace("ASL>DSI Audio Connection was released, Reject NAV to ExBox");
                            }
                        } else {
                            this.exboxLogger.trace("ASL>?DSI? Audio Connection was released, but not communicated to Exbox, because operation state is not normal.");
                        }
                    } else {
                        this.exboxLogger.trace("ASL>DSI Audio Connection was released, but no connection was requested. Doing nothing.");
                    }
                }
                this.exBoxMAudio.markDsiAudioConnectionAsNotConnected(n);
                break;
            }
            case 4000021: {
                this.exboxLogger.trace("Received ASL event ASL_SOUND_AUDIOMNGMNT_STATUS.");
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        this.exboxLogger.trace("Received, that audio management is not available.");
                        this.setAudioManagerAvailable(false);
                        break block0;
                    }
                    case 1: 
                    case 2: {
                        this.exboxLogger.trace("Received, that audio management is available.");
                        this.setAudioManagerAvailable(true);
                        this.exBoxMAudio.restoreAudioConnections();
                        this.exBoxMAudioEntertainment.restoreEntertainmentAudioConnection();
                        break block0;
                    }
                }
                break;
            }
            case 4000020: {
                boolean bl = eventGeneric.getBoolean(0);
                this.exboxLogger.trace(new Object[]{"Received ASL event ASL_SOUND_MUTESYMBOL_IS_ACTIVE with muteSymbolIsActive = ", new Boolean(bl), "."});
                this.exBoxMVolume.setUserMute(bl);
                break;
            }
            case 1073743106: {
                this.exboxLogger.trace("Received ASL event TOGGLE_NAV_VOLUME_DURING_PHONE_CALL.");
                boolean bl = this.persistableExBoxOptions.isNavAnnouncementDuringPhoneCallEnabled();
                this.exboxLogger.trace(new Object[]{"Toggling mute nav announcement during phone: ", bl ? "enable -> mute" : "mute -> enable"});
                this.persistableExBoxOptions.toggleMuteNavAnnouncementDuringPhone();
                break;
            }
            case 100005: {
                int n = eventGeneric.getInt(0);
                if (this.exBoxMDisplay_SM.getFadeOutTimerCurrentId() == n) {
                    this.exboxLogger.trace("ASL>ASL FadeOutTimer received.");
                    this.exBoxMDisplay_SM.processEvent(1);
                    break;
                }
                if (this.exBoxMDisplay_SM.getFadeInTimerCurrentId() == n) {
                    this.exboxLogger.trace("ASL>ASL FadeInTimer received.");
                    this.exBoxMDisplay_SM.processEvent(2);
                    break;
                }
                this.exboxLogger.trace(new Object[]{"ASL>ASL old timer received id: ", new Integer(n), "."});
                break;
            }
            case 1073744317: {
                this.exboxLogger.trace("Model>ASL REFRESH_VOLUME-Event received.");
                this.exBoxMVolume.refreshVolume();
                break;
            }
            case 1073744465: {
                this.exboxLogger.trace("Model>ASL SOFT_CONTEXT-Event received.");
                this.processHMIContextSoftReq(eventGeneric.getInt(0));
                break;
            }
            case 1073743955: {
                this.exboxLogger.trace("Received ASL-Down event ACTIVATE_CONTEXT.");
                this.processHMIContextActivateReq(eventGeneric.getInt(0));
                break;
            }
            case 1073743956: {
                this.exboxLogger.trace("Received ASL-Down event SWITCH_DISPLAY_CONTROL.");
                this.processHMIDisplayChangeReq();
                break;
            }
            case 1074441825: {
                this.exboxLogger.trace("Model>ASL DISPLAY_CURRENTLY_OFF-Event received.");
                this.exBoxMDisplay_SM.setDisplayAsleep();
                break;
            }
            case 1074441826: {
                this.exboxLogger.trace("Model>ASL DISPLAY_CURRENTLY_ON-Event received.");
                this.exBoxMDisplay_SM.setDisplayAwake();
                break;
            }
            case 1073744127: {
                this.exboxLogger.trace("Model>ASL KEEP_DISPLAY_CONTROL-Event received.");
                this.processHMIKeepDisplayChangeRes();
                break;
            }
            case 1073744092: {
                this.exboxLogger.trace("Model>ASL SWITCH_DISPLAY_CONTROL_FINISH-Event received.");
                break;
            }
            case 0x155CC5: {
                this.exboxLogger.trace("ASL>ASL EntertainmentManager-DEACTIVATE-Event received.");
                this.exBoxMAudioEntertainment.handleEntManagerDeactivate();
                break;
            }
            case 1400006: {
                this.exboxLogger.trace("ASL>ASL EntertainmentManager-CANCEL-Event received.");
                this.exBoxMAudioEntertainment.handleEntManagerCancel();
                break;
            }
            case 1400004: {
                this.exboxLogger.trace("ASL>ASL EntertainmentManager-ACTIVATE_STARTUP-Event received.");
                int n = eventGeneric.getInt(0);
                int n3 = eventGeneric.getInt(1);
                this.exBoxMAudioEntertainment.handleEntManagerActivateStartup(n, n3);
                break;
            }
            case 1400003: {
                this.exboxLogger.trace("ASL>ASL EntertainmentManager-ACTIVATE-Event received.");
                EntertainmentActivation entertainmentActivation = (EntertainmentActivation)eventGeneric.getObject(0);
                int n = entertainmentActivation.getSubcontext();
                this.exBoxMAudioEntertainment.handleEntManagerActivate(entertainmentActivation.getContext(), n);
                break;
            }
            case 1400013: {
                this.exboxLogger.trace("ASL>ASL EntertainmentManager-ACTIVATION_LOST-Event received.");
                break;
            }
            default: {
                this.errorEx().append("EX: Event could not be handled in Korea!: ").append(eventGeneric).log();
            }
        }
    }

    private void processAslEventPowerOn() {
        this.initDsiListener();
        this.initObserver();
        this.initAslExbox();
        this.initFactoryResetParticipants();
        this.exboxLogger.trace("POWER_ON event processed.");
    }

    private void initFactoryResetParticipants() {
        FactoryResetService factoryResetService = ExboxServicesProvider.getExBoxServices().getFactoryResetService();
        AudioFactoryResetParticipant audioFactoryResetParticipant = new AudioFactoryResetParticipant(this.dsiSound, this.exBoxMVolume);
        SystemFactoryResetParticipant systemFactoryResetParticipant = new SystemFactoryResetParticipant(this.dsiExBoxM, this.persistableExBoxOptions);
        factoryResetService.addParticipant(audioFactoryResetParticipant, FactoryResetComponents.AUDIO);
        factoryResetService.addParticipant(systemFactoryResetParticipant, FactoryResetComponents.SYSTEM);
    }

    private void initAslExbox() {
        this.exBoxMAudio = new ExBoxMAudio(this);
        this.exBoxMAudioEntertainment = new ExBoxMAudioEntertainment(this, new ExBoxMAudioEntertainmentEvents(ExboxServicesProvider.getExBoxServices().getEventFactory()), ExboxServicesProvider.getExBoxServices().getAslPropertyManager());
        ExboxSpeechApplicant exboxSpeechApplicant = ExboxSpeechApplicantFactory.createSpeechApplicant(ExboxServicesProvider.getExBoxServices(), this.exBoxMAudio);
        exboxSpeechApplicant.registerService();
        AbstractASLTarget.writeBooleanToDatapool(340, true);
        this.exBoxMVolume = new ExBoxMVolume(this, this.dsiExBoxM);
        this.exboxStateService = ExboxServicesProvider.getExBoxServices().getExboxStateService();
        this.exboxStateService.addExboxOperationStateListener(this);
        this.exBoxMDisplay_SM = new ExBoxMDisplay_SM(this);
        this.exBoxMDisplay_SM.connectAndStart(this.dsiExBoxM);
        this.exBoxMDisplay_SM.initialize();
        EntertainmentManagerResponder entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(4, this.getTargetId());
        ExboxKoreaPersistenceServiceImpl exboxKoreaPersistenceServiceImpl = ExboxKoreaPersistenceServiceImpl.getInstance();
        Logger logger = ExboxServicesProvider.getExBoxServices().getLogger();
        this.persistableExBoxOptions = new PersistableExBoxOptions(logger, exboxKoreaPersistenceServiceImpl.loadExboxKorea(), entertainmentManagerResponder);
        exboxKoreaPersistenceServiceImpl.addProfileChangeListener(new KoreaProfileChangeListener(this.persistableExBoxOptions));
    }

    private void initObserver() {
        this.exboxLogger.trace("initObserver called! Register target as observer for several events.");
        this.addObserver(-1123483584);
        this.addObserver(1359609920);
        this.addObserver(1393033280);
        this.addObserver(1409810496);
        this.addObserver(-603455424);
        this.addObserver(-16252864);
        this.addObserver(1638795840);
        this.addObserver(1655573056);
        this.addObserver(33882176);
        this.addObserver(352926976);
        this.addObserver(336149760);
        this.addObserver(252263680);
        this.addObserver(513622272);
        this.addObserver(379404544);
        this.addObserver(-1017375488);
        this.addObserver(-1000598272);
        this.addObserver(-983821056);
        this.addObserver(-967043840);
    }

    private void initDsiListener() {
        DSIProxy dSIProxy = ExboxServicesProvider.getExBoxServices().getDSIProxy();
        this.registerOnExboxDsi(dSIProxy);
        this.registerOnSoundDsi(dSIProxy);
        this.registerOnAudioManagementDsi(dSIProxy);
    }

    private void registerOnExboxDsi(DSIProxy dSIProxy) {
        this.exboxLogger.trace("registerOnExboxDsi called.");
        this.dsiExBoxM = (DSIExBoxM)dSIProxy.getService(this, class$org$dsi$ifc$exboxm$DSIExBoxM == null ? (class$org$dsi$ifc$exboxm$DSIExBoxM = TargetASLExBoxM.class$("org.dsi.ifc.exboxm.DSIExBoxM")) : class$org$dsi$ifc$exboxm$DSIExBoxM);
        DSIExBoxMListener dSIExBoxMListener = (DSIExBoxMListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$exboxm$DSIExBoxMListener == null ? (class$org$dsi$ifc$exboxm$DSIExBoxMListener = TargetASLExBoxM.class$("org.dsi.ifc.exboxm.DSIExBoxMListener")) : class$org$dsi$ifc$exboxm$DSIExBoxMListener);
        this.dsiExBoxM.setNotification(new int[]{1, 2}, (DSIListener)dSIExBoxMListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$exboxm$DSIExBoxMListener == null ? (class$org$dsi$ifc$exboxm$DSIExBoxMListener = TargetASLExBoxM.class$("org.dsi.ifc.exboxm.DSIExBoxMListener")) : class$org$dsi$ifc$exboxm$DSIExBoxMListener, dSIExBoxMListener);
    }

    private void registerOnSoundDsi(DSIProxy dSIProxy) {
        this.exboxLogger.trace("registerOnSoundDsi called.");
        this.dsiSound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        DSISoundListener dSISoundListener = (DSISoundListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener);
        this.dsiSound.setNotification(new int[]{24, 26}, (DSIListener)dSISoundListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener, dSISoundListener);
    }

    private void registerOnAudioManagementDsi(DSIProxy dSIProxy) {
        this.exboxLogger.trace("registerOnAudioManagementDsi called.");
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        this.dsiAudioManagement.setNotification(new int[]{1, 2}, (DSIListener)dSIAudioManagementListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener, dSIAudioManagementListener);
    }

    private void getVolumeSettingVolumes() {
        this.exBoxMVolume.requestVolumeRanges(this.dsiSound);
    }

    private void processHMIContextSoftReq(int n) {
        if (this.exBoxMDisplay_SM.isInIDLE()) {
            this.exboxLogger.trace(new Object[]{"Model>ASL HMI inform about DisplayContext change: ", new Integer(n)});
            this.exBoxMDisplay_SM.setCurrentAslContext(n);
            this.exBoxMDisplay_SM.signalContextChangeToHMI();
        } else {
            this.exboxLogger.trace(new Object[]{"Model>ASL HMI want inform about DisplayContext change - request is pending because running context switch: ", new Integer(n)});
            this.exBoxMDisplay_SM.setNextASLContext(n, 2);
        }
    }

    private void processHMIContextActivateReq(int n) {
        this.exboxLogger.trace(new Object[]{"processHMIContextActivateReq called! ASL context: ", new Integer(n), " (", ACTIVATE_CONTEXT_TO_NAME_MAP.get(n), ")"});
        if (this.exBoxMDisplay_SM.isAtRecovery()) {
            this.exboxLogger.trace(new Object[]{"Pending request because display is recovering: ", new Integer(n)});
            this.exBoxMDisplay_SM.setNextASLContext(n, 2);
        } else if (this.exBoxMDisplay_SM.isInIDLE()) {
            this.exBoxMDisplay_SM.setCurrentAslContext(n);
            this.displaySMAction();
        } else {
            this.exboxLogger.trace(new Object[]{"Model>ASL HMI want change DisplayContext - request is pending because running context switch: ", new Integer(n)});
            this.exBoxMDisplay_SM.setNextASLContext(n, 1);
        }
    }

    private void displaySMAction() {
        if (this.exBoxMDisplay_SM.isEntertainmentDMBAudioSourceFromCurrentDisplayContext()) {
            this.exBoxMAudioEntertainment.switchDsiDMBEntertainmentSource();
        } else {
            this.exboxLogger.trace("No entertainment source will be switched - no entertainment connection.");
        }
        this.exBoxMDisplay_SM.processEvent(6);
    }

    private void processHMIKeepDisplayChangeRes() {
        this.exboxLogger.trace(new Object[]{"Model>ASL HMI send Keep Display Context on: ", this.exBoxMDisplay_SM.getCurrentDSIContext4log()});
        this.exBoxMDisplay_SM.processEvent(4);
        this.idleProcessing();
    }

    private void processHMIDisplayChangeReq() {
        this.exboxLogger.trace(new Object[]{"Model>ASL HMI send Context change to: ", this.exBoxMDisplay_SM.getCurrentDSIContext4log()});
        this.exBoxMDisplay_SM.processEvent(3);
    }

    private void processDsiDisplayContextChangeRes(int n, int n2) {
        this.exboxLogger.trace(new Object[]{"DSI>Display context change response. DisplayContext/resultCode ", new Integer(n), "/", new Integer(n2), " with sleep/recovery ", new Boolean(this.exBoxMDisplay_SM.isAtSleep()), "/", new Boolean(this.exBoxMDisplay_SM.isAtRecovery())});
        if (n2 == 0) {
            if (this.exBoxMDisplay_SM.isAtSleep() && n == 0) {
                return;
            }
            if (this.exBoxMDisplay_SM.isAtRecovery()) {
                this.exBoxMDisplay_SM.clearSleepState();
            } else {
                this.exBoxMDisplay_SM.processEvent(0);
                if (!this.exBoxMDisplay_SM.isCurrentContext(n)) {
                    this.exboxLogger.trace(new Object[]{"DSI>ASL Display Context not available - alternative context confirmed ", new Integer(n)});
                    this.exBoxMDisplay_SM.indicateDisplayRequest(n);
                }
            }
        } else {
            this.errorEx().append("EX:DSI>ASL send Display Context Changed Error. DisplayContext/resultCode: ").append(n).append("/").append(n2).log();
            this.exBoxMDisplay_SM.setCurrentAslContext(-1);
            this.exBoxMDisplay_SM.processEvent(5);
        }
        this.idleProcessing();
    }

    private void idleProcessing() {
        this.exboxLogger.trace(new Object[]{"Idle processing ", new Integer(this.exBoxMDisplay_SM.getNextASLContext()), "/", new Integer(this.exBoxMDisplay_SM.hasNextASLContext())});
        switch (this.exBoxMDisplay_SM.hasNextASLContext()) {
            case 2: {
                int n = this.exBoxMDisplay_SM.getNextASLContext();
                this.exBoxMDisplay_SM.clearNextASLContext();
                this.exboxLogger.trace(new Object[]{"HMI wanted inform Display Context change during context switch to: ", this.exBoxMDisplay_SM.getCurrentDSIContext4log()});
                this.exBoxMDisplay_SM.setCurrentAslContext(n);
                this.displaySMAction();
                break;
            }
            case 1: {
                int n = this.exBoxMDisplay_SM.getNextASLContext();
                this.exBoxMDisplay_SM.clearNextASLContext();
                this.exboxLogger.trace(new Object[]{"HMI wanted inform Display Context change during context switch to: ", this.exBoxMDisplay_SM.getCurrentDSIContext4log()});
                this.exBoxMDisplay_SM.setCurrentAslContext(n);
                this.exBoxMDisplay_SM.signalContextChangeToHMI();
                break;
            }
        }
    }

    public int startUniqueTimer(int n, int n2) {
        int n3 = this.getUniqueId();
        EventGeneric eventGeneric = this.getEventFactory().newEvent();
        eventGeneric.setInt(0, n3);
        eventGeneric.setSenderTargetId(this.getTargetId());
        eventGeneric.setReceiverTargetId(this.getTargetId());
        eventGeneric.setReceiverEventId(n);
        this.startTimer(eventGeneric, n2, false, true);
        this.exboxLogger.trace(new Object[]{"Timer with id=", new Integer(n3), " started."});
        return n3;
    }

    public int getUniqueId() {
        ++this.uniqueId;
        if (this.uniqueId <= 0) {
            this.uniqueId = 1;
        }
        return this.uniqueId;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    public void dsiExBoxMUpdateDisplayRequest(int n, int n2) {
        this.exboxLogger.trace("dsiExBoxMUpdateDisplayRequest called!");
        if (n2 != 1) {
            this.exboxLogger.error("dsiExBoxMUpdateDisplayRequest invalid!");
            return;
        }
        this.exboxLogger.trace(new Object[]{"Display context is ", new Integer(n), "."});
        if (n == 8) {
            this.exboxLogger.trace("Ignore updateDisplayRequest for SDS.");
            return;
        }
        if (this.isExBoxOperationStateNormal()) {
            this.exBoxMDisplay_SM.indicateDisplayRequest(n);
        } else {
            this.exboxLogger.trace("Operation state is not normal. No call of indicateDisplayRequest.");
        }
    }

    public void dsiExBoxMUpdateAudioRequest(AudioRequest audioRequest, int n) {
        if (n == 1) {
            int n2 = audioRequest.getAuxAudioSource();
            String string = AUXAUDIOSOURCE_TO_NAME_MAP.get(n2);
            int n3 = audioRequest.getVdaAudioSource();
            String string2 = VDAAUDIOSOURCE_TO_NAME_MAP.get(n3);
            this.exboxLogger.trace(new Object[]{"dsiExBoxMUpdateAudioRequest called! ", "AUX: ", new Integer(n2), " (", string, ") ", "VDA: ", new Integer(n3), " (", string2, ")"});
            if (this.isExBoxOperationStateNormal()) {
                switch (n2) {
                    case 0: {
                        this.exBoxMAudio.releaseAllAuxAudioConnections();
                        break;
                    }
                }
                switch (n3) {
                    case 0: {
                        this.exBoxMAudio.releaseAllVdaAudioConnections();
                        break;
                    }
                    case 1: {
                        boolean bl = this.isNavAnnouncementDuringPhoneCallEnabled();
                        this.exBoxMAudio.requestAudioConnectionNav(bl);
                        break;
                    }
                    case 2: {
                        this.exBoxMAudio.requestAudioConnectionEmergencyAnnouncement();
                        break;
                    }
                }
            } else {
                this.exboxLogger.trace("Exbox is not in operation state normal.");
            }
        } else {
            this.exboxLogger.trace("DSI>ASL: ExBoxMUpdateAudioRequest with invalid flag.");
        }
    }

    private boolean isNavAnnouncementDuringPhoneCallEnabled() {
        return this.persistableExBoxOptions.isNavAnnouncementDuringPhoneCallEnabled();
    }

    @Override
    public void onExboxStateChange(boolean bl) {
        this.exBoxMDisplay_SM.resetDisplayFlags();
        this.exBoxMAudioEntertainment.operationStateChanged(bl);
        if (bl) {
            this.exBoxMVolume.refreshVolumeSettings(true);
        } else {
            this.exboxLogger.trace("ASL>ASL ExBox operation stated changed to not normal.");
            this.exBoxMAudio.resetInternalData();
            this.exBoxMDisplay_SM.processEvent(7);
            this.exBoxMDisplay_SM.clearNextASLContext();
            this.exBoxMDisplay_SM.setCurrentAslContext(-1);
        }
    }

    boolean isExBoxOperationStateNormal() {
        return this.exboxStateService.isExboxOperationStateNormal();
    }

    protected final boolean isTraceEnabledEx() {
        if (FORCE_ERROR_LOG) {
            return true;
        }
        return this.isTraceEnabled();
    }

    protected final LogMessage traceEx() {
        if (FORCE_ERROR_LOG) {
            return this.error();
        }
        return this.trace();
    }

    protected final LogMessage errorEx() {
        return this.error();
    }

    public void dsiSoundUpdateVolume(int n, int n2, short s, int n3) {
        this.exBoxMVolume.updateVolume(n, s, n3);
    }

    public void dsiSoundUpdateVolumeRange(int n, int n2, int n3) {
        this.exboxLogger.trace(new Object[]{"dsiSoundUpdateVolumeRange called! minRange=", new Integer(n), " maxRange=", new Integer(n2)});
        if (n3 != 1) {
            this.error("[TargetASLExBoxM] Receiving invalid DSI messages.");
            return;
        }
        this.exBoxMVolume.setVolumeRange(0, n, n2);
    }

    private void setAudioManagerAvailable(boolean bl) {
        if (this.exBoxMAudio.isAudioManagerAvailable() != bl) {
            this.exboxLogger.trace(new Object[]{"setAudioManagerAvailable called. Availability changed from ", new Boolean(this.exBoxMAudio.isAudioManagerAvailable()), " to ", new Boolean(bl), "."});
            if (bl) {
                ExboxServicesProvider.getExBoxServices().getDSIProxy().setUnexpectedResponsePassing(class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TargetASLExBoxM.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound, "getMenuVolumeRange", true);
                this.getVolumeSettingVolumes();
            }
            this.exBoxMAudio.setAudioManagerAvailable(bl);
        } else {
            this.exboxLogger.trace("setAudioManagerAvailable called. Availability did not change.");
        }
        this.exBoxMAudioEntertainment.setAudioManagerAvailable(bl);
    }

    public void dsiAudioManagementUpdateActiveConnection(int n, int n2, int n3) {
        this.exBoxMVolume.setActiveConnection(n);
    }

    public void dsiExBoxMResponseDisplayControl(int n, int n2) {
        this.processDsiDisplayContextChangeRes(n, n2);
    }

    public void dsiSoundMenuVolumeRange(int n, int n2, int n3, int n4) {
    }

    public void dsiExBoxMResponseVolumeRange(int n) {
        this.exboxLogger.trace(new Object[]{"dsiExBoxMResponseVolumeRange called! Result code: ", new Integer(n)});
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

