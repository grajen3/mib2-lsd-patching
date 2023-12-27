/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class TargetTVTuner
extends AbstractASLTarget {
    private boolean isTVContextEntered = false;
    private boolean isAudioAvailable = false;
    private boolean isTVTunerAvailable = false;
    private boolean isEntertainmentActivated = false;
    private static final int[] OBSERVERS = new int[]{1929838656, 2013724736, 2030501952, -2130247616, -2113470400, -1979252672, -1962475456, -1643708352, -1626931136, -1610153920, -1559822272, -1526267840, -1509490624, -452526016, -351862720, -83427264, 201850944, 218628160, 302514240, 537395264, 554172480, -234422208, 235405376, -1995964352, -2012741568, 1560805440, -1073217472, -1056440256, -1022885824, -620232640, -586678208, 84475968, 17367104, 1174995008, -1574623680, 1678442560, -1557846464, 0x4A040040, -1398603776, -301334464, 352926976, -1608178112, -1591400896};
    static /* synthetic */ Class class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService;

    public TargetTVTuner(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.trace("Target TVTuner - Initialising Target TVTuner!");
    }

    public TargetTVTuner(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.trace("Target TVTuner - Initialising Target TVTuner!");
    }

    @Override
    public int getDefaultTargetId() {
        return 16323840;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTuner#gotEvent - received EventGeneric: ").append(eventGeneric.toString()).toString());
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event POWER_ON");
                }
                TVTunerObjectAccessor.setTargetTVTuner(this);
                this.addObservers();
                this.initPersistence();
                ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(TVTunerObjectAccessor.getResetParticipant(), FactoryResetComponents.TVTUNER);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5602, 5);
                this.send(eventGeneric2);
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(-899934976);
                eventGeneric3.setInt(0, 5);
                eventGeneric3.setInt(1, -1);
                this.send(eventGeneric3);
                ServiceManager.componentRegistry.registerAPI(class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService == null ? (class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService = TargetTVTuner.class$("de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService")) : class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService, TVTunerObjectAccessor.getTileService());
                break;
            }
            case 1076241827: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event DTV_MAIN_ENTERED");
                }
                TVTunerObjectAccessor.getCioHandler().activate3DGesture();
                break;
            }
            case 1073743731: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SELECTED_TV_NORM");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setSelectedTVNorm(eventGeneric.getInt(0));
                break;
            }
            case 1073743736: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ACTIVATE_NEXT_STATION");
                }
                TVTunerObjectAccessor.getTuningHandler().tuneToNextStation(1);
                break;
            }
            case 1073743737: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ACTIVATE_PREVIOUS_STATION");
                }
                TVTunerObjectAccessor.getTuningHandler().tuneToNextStation(2);
                break;
            }
            case 1073743745: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event DECREASE_FREQUENCY");
                }
                TVTunerObjectAccessor.getTuningHandler().seekNextChannel(2, 0);
                break;
            }
            case 1073743746: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event INCREASE_FREQUENCY");
                }
                TVTunerObjectAccessor.getTuningHandler().seekNextChannel(1, 0);
                break;
            }
            case 1073743754: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event MANUAL_TUNING_MODE_ENTERED");
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(2491, 1);
                break;
            }
            case 1073743755: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event MANUAL_TUNING_MODE_EXITED");
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(2491, 0);
                break;
            }
            case 1073743775: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event START_NON_STOP_SEEKING_DOWN");
                }
                TVTunerObjectAccessor.getTuningHandler().seekNextChannel(2, 1);
                break;
            }
            case 1073743774: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event START_NON_STOP_SEEKING_UP");
                }
                TVTunerObjectAccessor.getTuningHandler().seekNextChannel(1, 1);
                break;
            }
            case 1073743776: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event STOP_NON_STOP_SEEKING_BOTH_DIRECTIONS");
                }
                TVTunerObjectAccessor.getTuningHandler().stopNonStopChannelSeeking();
                break;
            }
            case 1076241826: {
                TVTunerObjectAccessor.getCioHandler().fire3DGestureCio(eventGeneric.getInt(0));
                break;
            }
            case 1073744740: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ABORT_MANUAL_SEEK");
                }
                TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().abortSeek();
                break;
            }
            case 1073743779: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TV_SERVICE_LINKING_STATE");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setServiceLinking(eventGeneric.getBoolean(0));
                break;
            }
            case 1073743781: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event STATION_LIST_ENTERED");
                }
                TVTunerObjectAccessor.getStationListHandler().setStationListEntered(true);
                break;
            }
            case 1073743782: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event STATION_LIST_EXITED");
                }
                TVTunerObjectAccessor.getStationListHandler().setStationListEntered(false);
                TVTunerObjectAccessor.getStationListHandler().updateStationListAfterExiting();
                break;
            }
            case 1073743845: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SCOPE_OF_ARROW_KEY_MODE");
                }
                TVTunerObjectAccessor.getTuningHandler().setArrowButtonMode(eventGeneric.getInt(0), false);
                break;
            }
            case 1073743851: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SOURCE");
                }
                TVTunerObjectAccessor.getTvAvSourceHandler().setSource(eventGeneric.getInt(0));
                break;
            }
            case 1073743858: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SELECTED_PRESET_LIST_ENTRY");
                }
                TVTunerObjectAccessor.getPresetListHandler().activateSelectedPreset(eventGeneric.getInt(0));
                break;
            }
            case 1073743867: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SELECTED_PRESET_STORE_LIST_ENTRY");
                }
                TVTunerObjectAccessor.getPresetListHandler().saveStationAtPresetPosition(eventGeneric.getInt(0));
                break;
            }
            case 1073743884: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetTVTuner#gotEvent: received Event PRESET_STORE_LIST_ENTERED");
                break;
            }
            case 1073743885: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event PRESET_STORE_LIST_EXITED");
                }
                TVTunerObjectAccessor.getStationListHandler().setSaveStation(false);
                break;
            }
            case 1073743890: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TV_SUBTITLE_STATE");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setSubtitleState(eventGeneric.getBoolean(0));
                break;
            }
            case 1073743904: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event TV_SETUP_DELETE_ALL_PRESETS");
                }
                TVTunerObjectAccessor.getPresetListHandler().deleteAllPresets();
                break;
            }
            case 1073743905: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event TV_SETUP_DELETE_PRESET");
                }
                TVTunerObjectAccessor.getPresetListHandler().deletePresetAtPosition(eventGeneric.getInt(0));
                break;
            }
            case 1073743886: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_ASPECT_RATIO_MODE");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setAspectRatioMode(eventGeneric.getInt(0), false);
                break;
            }
            case 1073744009: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_AV_NORM");
                }
                TVTunerObjectAccessor.getTvTunerAVSettings().setAVNorm(eventGeneric.getInt(0));
                break;
            }
            case 0x40000888: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_AV_ASPECT_RATIO_MODE");
                }
                TVTunerObjectAccessor.getTvTunerAVSettings().setAspectRatioMode(eventGeneric.getInt(0), false);
                break;
            }
            case 1073743965: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SELECTED_AUDIO_CHANNEL");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setAudioChannel(eventGeneric.getInt(0));
                break;
            }
            case 1073744091: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_INC_MOVED");
                }
                TVTunerObjectAccessor.getTMHandler().setIncMoved(eventGeneric.getInt(0));
                break;
            }
            case 1073744093: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TMTV_KEY");
                }
                TVTunerObjectAccessor.getTMHandler().setTMTVKey(eventGeneric.getInt(1), eventGeneric.getInt(0));
                break;
            }
            case 1076241825: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SHOW_EWS_MESSAGE_STATE");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setShowEWSMessages(eventGeneric.getBoolean(0), false);
                break;
            }
            case 1073744064: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_VISUAL_AUDIO_SHOW_PICTURES_STATE");
                }
                TVTunerObjectAccessor.getTvTunerSettings().setVisualAudioShowPictures(eventGeneric.getBoolean(0), false);
                break;
            }
            case 1073744067: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TERMINAL_MODE");
                }
                TVTunerObjectAccessor.getTMHandler().setTerminalMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744065: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TERMINAL_MODE_ENTERED_STATE");
                }
                TVTunerObjectAccessor.getTMHandler().setTerminalModeEntered(eventGeneric.getBoolean(0));
                break;
            }
            case 1400003: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ACTIVATE");
                }
                this.isTVContextEntered = true;
                this.setEntertainmentActivated(false);
                TVTunerObjectAccessor.getTvTunerAudio().requestTVAudioConnection();
                TVTunerObjectAccessor.getTvAvSourceHandler().wakeUpTuner(false);
                TVTunerObjectAccessor.getTvBAP().updateBAPStationList();
                TVTunerObjectAccessor.getTvBAP().updateBAPIndices();
                break;
            }
            case 1400004: {
                boolean bl;
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ACTIVATE_STARTUP");
                }
                boolean bl2 = bl = eventGeneric.getInt(0) == 5;
                if (ServiceManager.logger2.isTraceEnabled(4)) {
                    ServiceManager.logger2.trace(4).append("Received IdService.ASL_ENTERTAINMENT_MANAGER_ACTIVATE_STARTUP: tuner = ").append(bl).log();
                }
                int n = eventGeneric.getInt(1);
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetTVTuner.gotEvent(): Received ASL_ENTERTAINMENT_MANAGER_ACTIVATE_STARTUP, tvLastSubcontext = ").append(n).log();
                }
                this.setEntertainmentActivated(false);
                if (bl) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: last mode was tv - request audio connection");
                    }
                    this.isTVContextEntered = true;
                    TVTunerObjectAccessor.getTvTunerAudio().requestTVAudioConnection();
                    TVTunerObjectAccessor.getTvAvSourceHandler().wakeUpTuner(false);
                    TVTunerObjectAccessor.getTvBAP().updateBAPStationList();
                    TVTunerObjectAccessor.getTvBAP().updateBAPIndices();
                    break;
                }
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: last mode was not tv - do nothing");
                }
                this.isTVContextEntered = false;
                break;
            }
            case 0x155CC5: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event DEACTIVATE");
                }
                if (eventGeneric.getResult() == 0) {
                    // empty if block
                }
                if (TVTunerObjectAccessor.getTMHandler().getCurrentTerminalMode() != 0) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: TM is still open - close it");
                    }
                    TVTunerObjectAccessor.getTMHandler().setTerminalMode(0);
                }
                EventGeneric eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent(-1050929920);
                this.sendSafe(eventGeneric4);
                this.setEntertainmentActivated(true);
                this.isTVContextEntered = false;
                break;
            }
            case 1400006: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event CANCEL");
                }
                if (TVTunerObjectAccessor.getTMHandler().getCurrentTerminalMode() != 0) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: TM is still open - close it");
                    }
                    TVTunerObjectAccessor.getTMHandler().setTerminalMode(0);
                }
                EventGeneric eventGeneric5 = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
                this.sendSafe(eventGeneric5);
                this.setEntertainmentActivated(true);
                this.isTVContextEntered = false;
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: received Event ASL_SOUND_AUDIOMNGMNT_UNAVAILABLE");
                    }
                    this.setAudioAvailable(false);
                } else if (n == 1) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: received Event ASL_SOUND_AUDIOMNGMNT_AVAILABLE");
                    }
                    this.setAudioAvailable(true);
                } else if (n == 2) {
                    if (this.isTraceEnabled()) {
                        this.trace("TargetTVTuner#gotEvent: received Event ASL_SOUND_AUDIOMNGMNT_AVAILABLE_RESTORE_CONNECTIONS");
                    }
                    this.setAudioAvailable(true);
                }
                if (!this.isTVContextEntered) break;
                TVTunerObjectAccessor.getTvTunerAudio().requestTVAudioConnection();
                break;
            }
            case 1073744133: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_SELECTED_SERVICES_LIST_ENTRY");
                }
                long l = eventGeneric.getLong(1);
                int n = eventGeneric.getInt(2);
                int n2 = eventGeneric.getInt(3);
                boolean bl = eventGeneric.getBoolean(4);
                TVTunerObjectAccessor.getStationListHandler().activateSelectedService(l, n, n2, bl);
                break;
            }
            case 1073744129: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event CLOSE_EWS_MESSAGE");
                }
                TVTunerObjectAccessor.getEWSHandler().lastEWSMessageClosed();
                break;
            }
            case 1073744198: {
                TVTunerObjectAccessor.getTMHandler().setTerminalMode(12);
                if (!this.isTraceEnabled()) break;
                this.trace("TargetTVTuner#gotEvent: received Event SET_TMCAS");
                break;
            }
            case 100000: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event EV_TVTUNER_SOUND_SET_CONNECTION_ANSWER");
                }
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("TargetTVTuner#gotEvent - answer tv tuner audio connection ").append(eventGeneric.getInt(0)).append(" - Result = ").append(eventGeneric.getResult()).toString());
                }
                if (eventGeneric.getResult() == 0) {
                    // empty if block
                }
                if (this.isEntertainmentActivated() || !this.isTVContextEntered) break;
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: sending entertainmentmanager an activated");
                }
                this.setEntertainmentActivated(true);
                EventGeneric eventGeneric6 = ServiceManager.mGenericEventFactory.newEvent(-1067707136);
                this.sendSafe(eventGeneric6);
                break;
            }
            case 100003: {
                if (!this.isTraceEnabled()) break;
                this.trace(new StringBuffer().append("TargetTVTuner#gotEvent - received Event EV_TVTUNER_SOUND_SET_VOLUME_LOCK_ANSWER - Result = ").append(eventGeneric.getResult()).toString());
                break;
            }
            case 100004: {
                if (!this.isTraceEnabled()) break;
                this.trace(new StringBuffer().append("TargetTVTuner#gotEvent - received Event EV_TVTUNER_SOUND_RELEASE_VOLUME_LOCK_ANSWER - Result = ").append(eventGeneric.getResult()).toString());
                break;
            }
            case 100001: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event EV_TVTUNER_SERVICE_INFO_LIFETIME_TIMER");
                }
                TVTunerObjectAccessor.getStationListHandler().checkMarkedServiceInfos();
                break;
            }
            case 4300050: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ASL_SYSTEM_VIDEO_DISCLAIMER_SHOWN");
                }
                TVTunerObjectAccessor.getTMHandler().updateScreenMode(eventGeneric.getBoolean(0));
                break;
            }
            case 4300062: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ASL_SYSTEM_RELOAD_PERSISTABLES");
                }
                this.initPersistence();
                break;
            }
            case 0x4000044A: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ACTIVATE_STATION_BY_ID");
                }
                if (!this.isTVContextEntered || TVTunerObjectAccessor.getTvTunerSettings().getCasStatus() == 5) break;
                TVTunerObjectAccessor.getTvBAP().setStationFromBAP(eventGeneric.getLong(0), eventGeneric.getInt(1));
                break;
            }
            case 41900: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event ASL_TV_TUNER_TESTMODE_ENABLED");
                }
                boolean bl = eventGeneric.getBoolean(0);
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("TargetTVTuner#gotEvent - TV Engineering Mode is ").append(bl ? "enabled" : "disabled").toString());
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(3806, bl);
                break;
            }
            case 1073744622: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event SET_TM_CANVAS_XY_DELTA");
                }
                TVTunerObjectAccessor.getTMHandler().handleGesture(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1076241824: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTuner#gotEvent: received Event setBrowserListSortingMode");
                }
                int n = eventGeneric.getInt(0);
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("TargetTVTuner#gotEvent: sending new mode ").append(n).append(" to dsi").toString());
                }
                TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setBrowserListSort(n);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace(new StringBuffer().append("TargetTVTuner#gotEvent: event not handled - ").append(eventGeneric.toString()).toString());
            }
        }
    }

    private void initPersistence() {
        TVTunerObjectAccessor.getTvTunerDB().initPresetsFromPersistence();
        TVTunerObjectAccessor.getTvTunerDB().initSettingsPersistence();
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    private void addObservers() {
        this.addObservers(OBSERVERS);
    }

    public boolean isTVContextEntered() {
        return this.isTVContextEntered;
    }

    public void setTVTunerAvailable(boolean bl) {
        this.isTVTunerAvailable = bl;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTuner# tv tuner is now ").append(this.isTVTunerAvailable ? "active" : "inactive").toString());
        }
    }

    public boolean isTVTunerAvailable() {
        return this.isTVTunerAvailable;
    }

    public void setAudioAvailable(boolean bl) {
        this.isAudioAvailable = bl;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTuner# audio management is now ").append(this.isAudioAvailable ? "available" : "not available").toString());
        }
    }

    public boolean isAudioAvailable() {
        return this.isAudioAvailable;
    }

    public void setEntertainmentActivated(boolean bl) {
        this.isEntertainmentActivated = bl;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTuner# entertainment manager is now ").append(this.isEntertainmentActivated ? "activated" : "not activated").toString());
        }
    }

    public boolean isEntertainmentActivated() {
        return this.isEntertainmentActivated;
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

