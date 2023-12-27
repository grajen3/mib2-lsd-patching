/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.browser.MediaBrowserService;
import de.vw.mib.asl.api.media.services.browser.MediaEntriesCallback;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.media.services.browser.SpeakableElementsListener;
import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.player.MediaPlaySimilarListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayViewListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListFetcher;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.bap.MediaBapBrowser;
import de.vw.mib.asl.internal.media.browser.bap.MediaHasBrowser;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.clients.ClientUpdater;
import de.vw.mib.asl.internal.media.clients.attributes.PlaySimilarAttribute;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserFolderPath;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserListHandler;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.HASUtil;
import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.MediaController$1;
import de.vw.mib.asl.internal.media.controller.MediaController$10;
import de.vw.mib.asl.internal.media.controller.MediaController$11;
import de.vw.mib.asl.internal.media.controller.MediaController$2;
import de.vw.mib.asl.internal.media.controller.MediaController$3;
import de.vw.mib.asl.internal.media.controller.MediaController$4;
import de.vw.mib.asl.internal.media.controller.MediaController$5;
import de.vw.mib.asl.internal.media.controller.MediaController$6;
import de.vw.mib.asl.internal.media.controller.MediaController$7;
import de.vw.mib.asl.internal.media.controller.MediaController$8;
import de.vw.mib.asl.internal.media.controller.MediaController$9;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandQueue;
import de.vw.mib.asl.internal.media.controller.commands.base.CmdFactorySettings;
import de.vw.mib.asl.internal.media.controller.commands.base.CmdStartupMedia;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdExecuteBAPAction;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdMoveFolderLevelUp;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdOpenFolder;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdRequestPickList;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser;
import de.vw.mib.asl.internal.media.controller.commands.has.CmdExecuteHASAction;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSlot;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayCurrentFolder;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFolder;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaySimilar;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSeek;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetPlaybackMode;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetVideoFormat;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSetVideoSize;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdSkip;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdTrack2Time;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForDelete;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdChooseSourceForImport;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdDeleteAll;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdResetSelection;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdSelectActiveFolder;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdSelectEntry;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdStartDelete;
import de.vw.mib.asl.internal.media.controller.commands.recording.CmdStartImport;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdClose;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdDeleteChar;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdInitialize;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdSetChar;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdSetCursorPos;
import de.vw.mib.asl.internal.media.controller.commands.search.CmdSetSearchFilter;
import de.vw.mib.asl.internal.media.controller.commands.sound.CmdRequestDummyAudioConnection;
import de.vw.mib.asl.internal.media.controller.commands.sound.CmdRestoreAudioConnection;
import de.vw.mib.asl.internal.media.controller.commands.speech.CmdOpenDatabaseCategory;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.asl.internal.media.targets.TargetMediaStartup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserCurrentActionStatusCollector;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.contexts.media.MediaResults;
import java.util.List;
import org.dsi.ifc.media.ListEntry;

public class MediaController
extends AbstractMediaTarget
implements MediaPlayerService,
MediaBrowserService,
FactoryResetParticipant {
    public static final boolean USE_PROXIMITY_TO_CLOSE_BROWSER;
    private boolean mFollowModeEnabled = true;
    private boolean mHasFollowModeEnabled = false;
    public TargetMediaStartup mStartup;
    private final MediaComponents allComponents = new MediaComponents();
    private final CommandQueue mCommandQue = new CommandQueue();
    private final ClientUpdater mMediaClients = new ClientUpdater();
    private static final int CLOSE_BROWSER_TIMEOUT;
    private final Runnable mCloseBrowserRunnable = new MediaController$1(this);
    private final MediaTimer mCloseBrowserTimer = new MediaTimer(this.mCloseBrowserRunnable, 5000, "CLOSE_BROWSER");
    public static final int ASL_MEDIA_SOURCES_AVAILABLE;
    public static final int ASL_MEDIA_SOURCES_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_PLAYER_AVAILABLE;
    public static final int ASL_MEDIA_PLAYER_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_SOUND_AVAILABLE;
    public static final int ASL_MEDIA_SOUND_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_BROWSER_AVAILABLE;
    public static final int ASL_MEDIA_BROWSER_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_RECORDER_AVAILABLE;
    public static final int ASL_MEDIA_RECORDER_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_SETTINGS_AVAILABLE;
    public static final int ASL_MEDIA_SETTINGS_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_SYNCHRONIZE_BROWSERS_TO_PLAYER;
    public static final int ASL_MEDIA_HANDLE_STOPPED_WITH_ERRORS;
    public static final int ASL_MEDIA_DUMMY_CONNECTION;
    public static final int ASL_MEDIA_HANDLE_AUDIBLE;
    public static final int ASL_MEDIA_HANDLE_NOT_AUDIBLE;
    public static final int ASL_MEDIA_RELEASE_USER_MUTE;
    public static final int ASL_MEDIA_REQUEST_USER_MUTE;
    public static final int ASL_MEDIA_STARTUP_AVAILABLE;
    public static final int ASL_MEDIA_STARTUP_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_MEDIA_HAS_SET_PLAY_MODE;
    public static final int ASL_MEDIA_HAS_SET_PLAY_MODE_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_SET_PLAY_MODE_P1_PLAYMODE_OBJ;
    private static final int EV_HANDLE_MULTIPLE_SKIP_WINDOW_TIMEOUT;
    public static final int ASL_MEDIA_HAS_NEXT_TRACK;
    public static final int ASL_MEDIA_HAS_NEXT_TRACK_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_PREVIOUS_TRACK;
    public static final int ASL_MEDIA_HAS_PREVIOUS_TRACK_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_PLAY_MEDIA;
    public static final int ASL_MEDIA_HAS_PLAY_MEDIA_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_PAUSE_MEDIA;
    public static final int ASL_MEDIA_HAS_PAUSE_MEDIA_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_SET_TRACK_TO_TIME;
    public static final int ASL_MEDIA_HAS_SET_TRACK_TO_TIME_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_SET_TRACK_TO_TIME_P1_TIME_POSITION_INT;
    public static final int ASL_MEDIA_HAS_SELECT_BROWSER_SOURCE;
    public static final int ASL_MEDIA_HAS_SELECT_BROWSER_SOURCE_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_SELECT_BROWSER_SOURCE_P1_SOURCE_ID_INT;
    public static final int ASL_MEDIA_HAS_ENABLE_FOLLOW_MODE;
    public static final int ASL_MEDIA_HAS_ENABLE_FOLLOW_MODE_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_DISABLE_FOLLOW_MODE;
    public static final int ASL_MEDIA_HAS_DISABLE_FOLLOW_MODE_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_OPEN_FOLDER;
    public static final int ASL_MEDIA_HAS_OPEN_FOLDER_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_OPEN_FOLDER_P1_PATH_OBJECT;
    public static final int ASL_MEDIA_HAS_PLAY_ENTRY;
    public static final int ASL_MEDIA_HAS_PLAY_ENTRY_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_PLAY_ENTRY_P1_ENTRY;
    public static final int ASL_MEDIA_HAS_PMLT;
    public static final int ASL_MEDIA_HAS_PMLT_P0_CALL_ID_INT;
    public static final int ASL_MEDIA_HAS_PMLT_P1_ENABLE_BOOLEAN;
    public static final int ASL_MEDIA_SOUND_LOSS;
    public static final int ASL_MEDIA_SOUND_RESTORE;
    public static final int ASL_MEDIA_DOMAIN_RESTARTED;
    private static final int[] OBSERVER_MEDIA_PLAYBACK_AUDIO_CONTROL;
    private static final int[] OBSERVER_MEDIA_BROWSER;
    private static final int[] OBSERVER_MEDIA_RECORDER;
    private static final int[] OBSERVER_MEDIA_BAP;
    private int mPendingSkipCount = 0;
    private boolean mPendingSkipConsiderTimePos = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile;

    public MediaController(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 279909120;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 1024;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                MediaObjectAccessor.mMediaController = this;
                ServiceManager.aslPropertyManager.valueChangedBoolean(33, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(35, true);
                this.addObservers(OBSERVER_MEDIA_PLAYBACK_AUDIO_CONTROL);
                this.addObservers(OBSERVER_MEDIA_BROWSER);
                this.addObservers(OBSERVER_MEDIA_RECORDER);
                this.addObservers(OBSERVER_MEDIA_BAP);
                this.addObserver(513622272);
                this.addObserver(1275723840);
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this, FactoryResetComponents.MEDIA);
                this.initPersistence();
                this.mCommandQue.addCommand(new CmdStartupMedia());
                break;
            }
            case 107: {
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.removeParticipant(this, FactoryResetComponents.MEDIA);
                this.removeObservers(OBSERVER_MEDIA_PLAYBACK_AUDIO_CONTROL);
                this.removeObservers(OBSERVER_MEDIA_BROWSER);
                this.removeObservers(OBSERVER_MEDIA_RECORDER);
                this.removeObservers(OBSERVER_MEDIA_BAP);
                break;
            }
            case 100014: {
                this.mStartup = (TargetMediaStartup)eventGeneric.getObject(0);
                if (!this.isTraceEnabled()) break;
                this.trace("MEDIA CONTROLLER ~ STARTUP AVAILABLE");
                break;
            }
            case 100001: {
                ISources iSources = (ISources)eventGeneric.getObject(0);
                this.sourcesAvailable(iSources);
                break;
            }
            case 100002: {
                this.allComponents.setPlayer((MediaPlayer)eventGeneric.getObject(0));
                this.mMediaClients.registerPlayerStateListener(this.allComponents.getPlayer().getPlayerState());
                if (!this.isTraceEnabled()) break;
                this.trace("MEDIA CONTROLLER ~ PLAYER AVAILABLE");
                break;
            }
            case 100005: {
                this.allComponents.setRecorder((MediaRecorder)eventGeneric.getObject(0));
                this.mMediaClients.registerRecorderStateListener(this.allComponents.getRecorder().getRecorderState());
                this.valueChangedInteger(4022, this.allComponents.getRecorder().getUserEncodingQuality());
                if (!this.isTraceEnabled()) break;
                this.trace("MEDIA CONTROLLER ~ RECORDER AVAILABLE");
                break;
            }
            case 100003: {
                this.allComponents.setSound((MediaAudioManager)eventGeneric.getObject(0));
                if (!this.isTraceEnabled()) break;
                this.trace("MEDIA CONTROLLER ~ SOUND AVAILABLE");
                break;
            }
            case 100006: {
                this.allComponents.setSettings((MediaSettings)eventGeneric.getObject(0));
                if (!this.isTraceEnabled()) break;
                this.trace("MEDIA CONTROLLER ~ SETTINGS AVAILABLE");
                break;
            }
            case 100004: {
                AbstractMediaBrowser abstractMediaBrowser = (AbstractMediaBrowser)eventGeneric.getObject(0);
                switch (abstractMediaBrowser.getTargetId()) {
                    case 1290007: {
                        this.allComponents.setBrowser_MainView((MediaMainBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerHeadunitBrowserStateListener(this.allComponents.getBrowser_MainView());
                        if (this.isTraceEnabled()) {
                            this.trace("MEDIA CONTROLLER ~ MAIN_BROWSER AVAILABLE");
                        }
                        this.synchronizeHeadunitBrowserToPlayer();
                        break block0;
                    }
                    case 1290009: {
                        this.allComponents.setBrowser_Cover((MediaCoverBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerCoverBrowserStateListener(this.allComponents.getBrowser_Cover());
                        if (this.isTraceEnabled()) {
                            this.trace("MEDIA CONTROLLER ~ COVER_BROWSER AVAILABLE");
                        }
                        this.synchronizeCoverBrowserToPlayer();
                        break block0;
                    }
                    case 1290008: {
                        this.allComponents.setBrowser_Kombi((MediaBapBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerKombiBrowserStateListener(this.allComponents.getBrowser_Kombi());
                        if (this.isTraceEnabled()) {
                            this.trace("MEDIA CONTROLLER ~ BAP_BROWSER AVAILABLE");
                        }
                        this.synchronizeKombiBrowserToPlayer(false);
                        break block0;
                    }
                    case 1290012: {
                        this.allComponents.setBrowser_Has((MediaHasBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerHasBrowserStateListener(this.allComponents.getBrowser_Has());
                        if (this.isTraceEnabled()) {
                            this.trace("MEDIA CONTROLLER ~ HAS_BROWSER AVAILABLE");
                        }
                        this.synchronizeHasBrowserToPlayer();
                        break block0;
                    }
                    case 1290011: {
                        this.allComponents.setBrowser_Speech((MediaSpeechBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerSpeechBrowserStateListener(this.allComponents.getBrowser_Speech());
                        if (!this.isTraceEnabled()) break block0;
                        this.trace("MEDIA CONTROLLER ~ SPEECH_BROWSER AVAILABLE");
                        break block0;
                    }
                    case 1290010: {
                        this.allComponents.setBrowser_Recorder((MediaRecorderBrowser)abstractMediaBrowser);
                        abstractMediaBrowser.registerListFetcher(new MediaBrowserListFetcher(abstractMediaBrowser, this.mCommandQue));
                        this.mMediaClients.registerRecorderBrowserStateListener(this.allComponents.getBrowser_Recorder());
                        if (!this.isTraceEnabled()) break block0;
                        this.trace("MEDIA CONTROLLER ~ RECORDER_BROWSER AVAILABLE");
                        break block0;
                    }
                }
                break;
            }
            case 4300062: {
                this.initPersistence();
                break;
            }
            case 1073744460: {
                this.mCommandQue.addCommand(new CmdFactorySettings(this.allComponents, 8));
                break;
            }
            case 1073744649: {
                this.activatePartitionList(eventGeneric.getInt(0), eventGeneric.getLong(1));
                break;
            }
            case 1074541846: {
                int n = eventGeneric.getInt(0);
                Object object = ListManager.getGenericASLList(1096551424).getRowItem(n);
                if (!ListManager.getGenericASLList(1096551424).isValidItem(object)) break;
                MediaCollector mediaCollector = (MediaCollector)object;
                CmdActivateSource cmdActivateSource = new CmdActivateSource(this.allComponents, mediaCollector, true, true);
                this.mCommandQue.addCommand(cmdActivateSource);
                break;
            }
            case 1074541847: {
                int n = eventGeneric.getInt(0);
                Object object = ListManager.getGenericASLList(1096551424).getRowItem(n);
                if (!ListManager.getGenericASLList(1096551424).isValidItem(object)) break;
                MediaCollector mediaCollector = (MediaCollector)object;
                CmdActivateSource cmdActivateSource = new CmdActivateSource(this.allComponents, mediaCollector, true, true);
                cmdActivateSource.setCommandCallback(new MediaController$2(this, mediaCollector));
                this.mCommandQue.addCommand(cmdActivateSource);
                break;
            }
            case 100007: {
                this.synchronizeHeadunitBrowserToPlayer();
                this.synchronizeHasBrowserToPlayer();
                this.synchronizeCoverBrowserToPlayer();
                if (this.allComponents.getBrowser_Kombi() == null || this.allComponents.getBrowser_Kombi().isBrowsingAvailable()) break;
                this.trace("KOMBI # synchronizing kombi browser");
                this.synchronizeKombiBrowserToPlayer(true);
                break;
            }
            case 100008: {
                if (this.allComponents.getBrowser_MainView() == null) break;
                this.mCommandQue.addCommand(new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_MainView()));
                break;
            }
            case 1073743431: {
                int n = eventGeneric.getInt(0);
                this.mCommandQue.addCommand(CmdPlayFolder.createByIndex(this.allComponents, this.allComponents.getBrowser_Cover(), n, true));
                break;
            }
            case 0x40000034: {
                MediaMainBrowser mediaMainBrowser = this.allComponents.getBrowser_MainView();
                if (mediaMainBrowser.isBrowsingAvailable() && !mediaMainBrowser.getBrowseMedia().isBT() && !mediaMainBrowser.getBrowseMedia().isIPod()) {
                    this.mCommandQue.addCommand(new CmdPlayCurrentFolder(this.allComponents));
                    break;
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(308022272);
                this.mCommandQue.addCommand(new CmdActivateSource(this.allComponents, mediaMainBrowser.getBrowseMedia(), true, true));
                break;
            }
            case 1073741878: {
                int n = eventGeneric.getInt(0);
                this.mCommandQue.addCommand(CmdPlayFile.createByIndex(this.allComponents, this.allComponents.getBrowser_MainView(), n, true, false));
                break;
            }
            case 1073741883: {
                boolean bl;
                boolean bl2 = eventGeneric.getInt(0) == 1;
                MediaPlayerState mediaPlayerState = this.allComponents.getPlayer().getPlayerState();
                MediaCollector mediaCollector = mediaPlayerState.getActiveMedia();
                MediaPlaybackModes mediaPlaybackModes = mediaPlayerState.getPlaybackModeList();
                PlayMode playMode = mediaPlayerState.getPlaybackMode();
                MediaCollector mediaCollector2 = this.allComponents.getBrowser_MainView().getBrowseMedia();
                PlayMode playMode2 = PlayMode.UNKNOWN;
                boolean bl3 = bl = mediaCollector == mediaCollector2 && mediaCollector.storesOwnPlaybackState();
                if (bl2) {
                    playMode2 = bl ? mediaPlaybackModes.addMix(playMode) : PlayMode.DUMMY_MIX;
                } else if (mediaPlayerState.involvesMix()) {
                    playMode2 = bl ? mediaPlaybackModes.removeMix(playMode) : PlayMode.DUMMY_PLAY_DEFAULT;
                } else {
                    this.warn("Dropping SET_MIX_MODE = OFF if MIX is already OFF");
                    return;
                }
                if (playMode2 != PlayMode.UNKNOWN) {
                    CmdSetPlaybackMode cmdSetPlaybackMode = new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_MainView(), playMode2, false, this.mFollowModeEnabled);
                    this.mCommandQue.addCommand(cmdSetPlaybackMode);
                    break;
                }
                this.error("Dropping SET_MIX_MODE since mode could not be derived");
                break;
            }
            case 1073741887: {
                int n = eventGeneric.getInt(0);
                MediaPlayerState mediaPlayerState = this.allComponents.getPlayer().getPlayerState();
                MediaCollector mediaCollector = this.allComponents.getPlayer().getActiveMedia();
                MediaPlaybackModes mediaPlaybackModes = mediaPlayerState.getPlaybackModeList();
                PlayMode playMode = mediaPlayerState.getPlaybackMode();
                MediaCollector mediaCollector3 = this.allComponents.getBrowser_MainView().getBrowseMedia();
                PlayMode playMode3 = PlayMode.UNKNOWN;
                boolean bl = mediaCollector == mediaCollector3 && mediaCollector.storesOwnPlaybackState();
                switch (n) {
                    case 1: {
                        playMode3 = bl ? mediaPlaybackModes.addRepeat(playMode) : PlayMode.DUMMY_REPEAT;
                        break;
                    }
                    case 2: {
                        playMode3 = bl ? mediaPlaybackModes.addRepeatFile(playMode) : PlayMode.DUMMY_REPEAT_FILE;
                        break;
                    }
                    case 0: {
                        if (mediaPlayerState.involvesRepeat()) {
                            playMode3 = bl ? mediaPlaybackModes.removeRepeat(playMode) : PlayMode.DUMMY_PLAY_DEFAULT;
                            break;
                        }
                        this.warn("Dropping SET_REPEAT_MODE = OFF if REPEAT is already disabled");
                        return;
                    }
                }
                if (playMode3 != PlayMode.UNKNOWN) {
                    CmdSetPlaybackMode cmdSetPlaybackMode = new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_MainView(), playMode3, false, this.mFollowModeEnabled);
                    this.mCommandQue.addCommand(cmdSetPlaybackMode);
                    break;
                }
                this.error("Dropping SET_REPEAT_MODE since mode could not be derived");
                break;
            }
            case 1073741885: {
                if (eventGeneric.getBoolean(0)) {
                    this.mCommandQue.addCommand(new CmdPlaySimilar(this.allComponents.getPlayer(), this.allComponents.getSound(), this.allComponents.getBrowser_MainView()));
                    break;
                }
                this.mCommandQue.addCommand(new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_MainView(), PlayMode.DUMMY_PLAY_DEFAULT, false, true));
                break;
            }
            case 1073744425: {
                boolean bl = eventGeneric.getBoolean(0);
                int n = Math.abs(eventGeneric.getInt(1)) * -1;
                this.debounceSkip(n, bl);
                break;
            }
            case 1073744426: {
                int n = Math.abs(eventGeneric.getInt(0));
                this.debounceSkip(n, false);
                break;
            }
            case 100016: {
                if (this.mPendingSkipCount == 0) break;
                this.insertSkipCmd(this.mPendingSkipCount, this.mPendingSkipConsiderTimePos);
                this.mPendingSkipCount = 0;
                this.retriggerOrStartTimer(-1333395200, (long)0, false);
                break;
            }
            case 1073741842: {
                this.mCommandQue.addCommand(new CmdTrack2Time(this.allComponents, eventGeneric.getInt(0)));
                break;
            }
            case 1073741855: {
                this.allComponents.getSettings().toggleIncludeSubfolder();
                if (this.allComponents.getPlayer().getActiveMedia().isBT() || this.allComponents.getPlayer().getActiveMedia().isIPod() || this.allComponents.getPlayer().getPlaySelection() != null && !this.allComponents.getPlayer().getPlaySelection().isRAWSelection()) break;
                PlayMode playMode = this.allComponents.getPlayer().getPlaybackMode().getDummy();
                CmdSetPlaybackMode cmdSetPlaybackMode = new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_MainView(), playMode, this.allComponents.getPlayer().isPaused());
                this.mCommandQue.addCommand(cmdSetPlaybackMode);
                break;
            }
            case 0x40000011: {
                switch (eventGeneric.getInt(0)) {
                    case 1: {
                        this.mCommandQue.addCommand(new CmdPlaybackResume(this.allComponents.getPlayer(), this.allComponents.getSound()));
                        break block0;
                    }
                    case 2: {
                        this.mCommandQue.addCommand(CmdPlaybackPause.createUserPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()));
                        break block0;
                    }
                    case 3: {
                        this.warn("Received SET_PLAYER_STATE__STATE__C2_STOP. Model should send pause. stop not even supported by eso dsi.");
                        this.mCommandQue.addCommand(CmdPlaybackPause.createUserPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()));
                        break block0;
                    }
                }
                break;
            }
            case 100011: {
                this.mCommandQue.addCommand(CmdPlaybackPause.createSystemPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 100013: {
                this.mCommandQue.addCommand(CmdPlaybackPause.createUserPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 100010: 
            case 100012: {
                this.mCommandQue.addCommand(new CmdPlaybackResume(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 100009: {
                this.mCommandQue.addCommand(new CmdRequestDummyAudioConnection(this.allComponents.getSound()));
                break;
            }
            case 1073741848: {
                this.mCommandQue.addCommand(CmdSeek.createSeekBw(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 1073741847: {
                this.mCommandQue.addCommand(CmdSeek.createSeekFw(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 1073741849: 
            case 1073741850: {
                this.allComponents.getPlayer().abortSeek();
                break;
            }
            case 0x40000940: {
                this.mCommandQue.addCommand(new CmdSetVideoSize(this.allComponents.getPlayer(), eventGeneric.getBoolean(0)));
                break;
            }
            case 1073741946: {
                this.mCommandQue.addCommand(new CmdSetVideoFormat(this.allComponents.getPlayer(), eventGeneric.getInt(0)));
                break;
            }
            case 1073743739: {
                this.mMediaClients.onRecorderEntered(true);
                break;
            }
            case 1073743740: {
                this.mMediaClients.onRecorderEntered(false);
                this.synchronizeHeadunitBrowserToPlayer();
                this.synchronizeCoverBrowserToPlayer();
                break;
            }
            case 1073744453: {
                int n = (int)eventGeneric.getLong(0);
                CmdChooseSourceForImport cmdChooseSourceForImport = new CmdChooseSourceForImport(this.allComponents, n);
                this.mCommandQue.addCommand(cmdChooseSourceForImport);
                break;
            }
            case 1073741862: {
                CmdChooseSourceForDelete cmdChooseSourceForDelete = new CmdChooseSourceForDelete(this.allComponents);
                this.mCommandQue.addCommand(cmdChooseSourceForDelete);
                break;
            }
            case 0x4000000E: {
                Command command = CmdSetupBrowser.createDeactivationCmd(this.allComponents.getBrowser_Cover());
                this.mCommandQue.addCommand(command);
                CmdStartImport cmdStartImport = CmdStartImport.createStartCmd(this.allComponents);
                this.mCommandQue.addCommand(cmdStartImport);
                break;
            }
            case 0x4000000C: {
                this.allComponents.getRecorder().abortImport();
                break;
            }
            case 0x4000000D: {
                CmdStartDelete cmdStartDelete = new CmdStartDelete(this.allComponents);
                this.mCommandQue.addCommand(cmdStartDelete);
                break;
            }
            case 1073743434: {
                CmdDeleteAll cmdDeleteAll = new CmdDeleteAll(this.allComponents);
                this.mCommandQue.addCommand(cmdDeleteAll);
                break;
            }
            case 0x4000000B: {
                this.allComponents.getRecorder().abortDelete();
                break;
            }
            case 0x40000042: {
                int n = eventGeneric.getInt(0);
                boolean bl = n == 1;
                CmdSelectActiveFolder cmdSelectActiveFolder = new CmdSelectActiveFolder(this.allComponents.getBrowser_Recorder(), this.allComponents.getRecorder(), bl);
                this.mCommandQue.addCommand(cmdSelectActiveFolder);
                break;
            }
            case 1073744424: {
                int n = eventGeneric.getInt(1);
                boolean bl = n == 1;
                int n2 = eventGeneric.getInt(0);
                ExtendedListEntry extendedListEntry = this.allComponents.getBrowser_Recorder().getListHandler().getListEntryByIndex(n2);
                CmdSelectEntry cmdSelectEntry = new CmdSelectEntry(this.allComponents.getBrowser_Recorder(), this.allComponents.getRecorder(), extendedListEntry, bl);
                this.mCommandQue.addCommand(cmdSelectEntry);
                break;
            }
            case 0x40000010: {
                CmdResetSelection cmdResetSelection = new CmdResetSelection(this.allComponents.getBrowser_Recorder(), this.allComponents.getRecorder());
                this.mCommandQue.addCommand(cmdResetSelection);
                break;
            }
            case 1073744674: {
                int n = eventGeneric.getInt(0);
                this.valueChangedInteger(4022, n);
                this.allComponents.getRecorder().setUserEncodingQuality(n);
                break;
            }
            case 1073744429: {
                int n;
                int n3 = (int)eventGeneric.getLong(0);
                MediaCollector mediaCollector = this.allComponents.getSources().getSourceByID(n3);
                int n4 = n = mediaCollector != null && mediaCollector.supportsContentModeOnly() ? 1 : 0;
                if (!this.allComponents.getSources().checkSource(mediaCollector)) break;
                this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_MainView(), mediaCollector, n));
                break;
            }
            case 1073741880: {
                int n = -1;
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        n = 0;
                        break;
                    }
                    case 1: {
                        n = 1;
                        break;
                    }
                    default: {
                        n = -1;
                    }
                }
                MediaCollector mediaCollector = this.allComponents.getBrowser_MainView().getBrowseMedia();
                this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_MainView(), mediaCollector, n));
                break;
            }
            case 1073741907: {
                this.mMediaClients.onFollowModeEnabled();
                if (this.mFollowModeEnabled) break;
                this.mFollowModeEnabled = true;
                this.valueChangedBoolean(90, true);
                this.synchronizeHeadunitBrowserToPlayer();
                this.synchronizeCoverBrowserToPlayer();
                break;
            }
            case 1073741910: {
                if (!this.mFollowModeEnabled) break;
                this.mFollowModeEnabled = false;
                this.valueChangedBoolean(90, false);
                break;
            }
            case 1073741869: {
                int n = eventGeneric.getInt(0);
                if (n < 0) break;
                if (this.mMediaClients.isRecorderEntered()) {
                    this.mCommandQue.addCommand(new CmdMoveFolderLevelUp(this.allComponents.getBrowser_Recorder(), n));
                    break;
                }
                int n5 = this.mMediaClients.getSteps(n);
                if (n5 <= 0) break;
                this.mCommandQue.addCommand(new CmdMoveFolderLevelUp(this.allComponents.getBrowser_MainView(), n5));
                break;
            }
            case 1073741871: {
                this.mMediaClients.showList();
                int n = eventGeneric.getInt(0);
                if (this.mMediaClients.isRecorderEntered()) {
                    ExtendedListEntry extendedListEntry = this.allComponents.getBrowser_Recorder().getListHandler().getListEntryByIndex(n);
                    this.mCommandQue.addCommand(CmdOpenFolder.createRelativeCmd(this.allComponents.getBrowser_Recorder(), extendedListEntry, null));
                    break;
                }
                ExtendedListEntry extendedListEntry = this.allComponents.getBrowser_MainView().getListHandler().getListEntryByIndex(n);
                this.mCommandQue.addCommand(CmdOpenFolder.createRelativeCmd(this.allComponents.getBrowser_MainView(), extendedListEntry, null));
                break;
            }
            case 1073744584: {
                int n = eventGeneric.getInt(0);
                MediaCollector mediaCollector = this.allComponents.getSources().getSourceByID(n);
                int n6 = mediaCollector != null && mediaCollector.supportsContentModeOnly() ? 1 : 0;
                this.mCommandQue.addCommand(new CmdExecuteBAPAction(new CmdSetupBrowser(this.allComponents.getBrowser_Kombi(), mediaCollector, n6), 0));
                break;
            }
            case 1073744586: {
                int n = eventGeneric.getInt(0);
                this.mCommandQue.addCommand(new CmdExecuteBAPAction(new CmdMoveFolderLevelUp(this.allComponents.getBrowser_Kombi(), n), 2));
                break;
            }
            case 1074541838: {
                long l = eventGeneric.getLong(0);
                int n = eventGeneric.getInt(1);
                switch (eventGeneric.getInt(1)) {
                    case 0: {
                        n = 0;
                        break;
                    }
                    case 1: {
                        n = 4;
                        break;
                    }
                    case 2: {
                        n = 5;
                        break;
                    }
                    case 3: {
                        n = 6;
                        break;
                    }
                    case 4: {
                        n = 7;
                        break;
                    }
                    case 5: {
                        n = 8;
                        break;
                    }
                    case 6: {
                        n = 9;
                        break;
                    }
                    case 7: {
                        n = 10;
                        break;
                    }
                    case 8: {
                        n = 11;
                        break;
                    }
                    case 9: {
                        n = 13;
                        break;
                    }
                    case 10: {
                        n = 14;
                        break;
                    }
                    case 11: {
                        n = 15;
                        break;
                    }
                    case 12: {
                        n = 16;
                        break;
                    }
                    case 13: {
                        n = 17;
                        break;
                    }
                    case 14: {
                        n = 18;
                        break;
                    }
                    case 15: {
                        n = 19;
                        break;
                    }
                    case 16: {
                        n = 20;
                        break;
                    }
                    default: {
                        n = 0;
                    }
                }
                ExtendedListEntry extendedListEntry = this.allComponents.getBrowser_Kombi().getListHandler().getListEntryById(l, n);
                this.mCommandQue.addCommand(new CmdExecuteBAPAction(CmdOpenFolder.createRelativeCmd(this.allComponents.getBrowser_Kombi(), extendedListEntry, null), 1));
                break;
            }
            case 1074541839: {
                long l = eventGeneric.getLong(0);
                int n = 0;
                switch (eventGeneric.getInt(1)) {
                    case 0: {
                        n = 0;
                        break;
                    }
                    case 1: {
                        n = 1;
                        break;
                    }
                    case 2: {
                        n = 2;
                        break;
                    }
                    case 3: {
                        n = 3;
                        break;
                    }
                    case 4: {
                        n = 4;
                        break;
                    }
                    case 5: {
                        n = 5;
                        break;
                    }
                    case 6: {
                        n = 6;
                        break;
                    }
                    case 7: {
                        n = 7;
                        break;
                    }
                    case 8: {
                        n = 8;
                        break;
                    }
                    case 9: {
                        n = 9;
                        break;
                    }
                    case 10: {
                        n = 10;
                        break;
                    }
                    case 11: {
                        n = 11;
                        break;
                    }
                    case 12: {
                        n = 13;
                        break;
                    }
                    case 13: {
                        n = 14;
                        break;
                    }
                    case 14: {
                        n = 15;
                        break;
                    }
                    case 15: {
                        n = 16;
                        break;
                    }
                    case 16: {
                        n = 17;
                        break;
                    }
                    case 17: {
                        n = 7;
                        break;
                    }
                    case 18: {
                        n = 19;
                        break;
                    }
                    case 19: {
                        n = 20;
                        break;
                    }
                    default: {
                        n = 0;
                    }
                }
                Command command = CmdPlayFile.createById(this.allComponents, this.allComponents.getBrowser_Kombi(), l, n, true);
                this.mCommandQue.addCommand(new CmdExecuteBAPAction(command, 4));
                break;
            }
            case 1073744587: {
                if (this.isTraceEnabled()) {
                    this.trace("Received event ASLAVDCAudioBapMediaBrowserSetter.TRIGGER_FOLLOW_MODE.");
                }
                if (this.synchronizeKombiBrowserToPlayer(true)) break;
                GenericASLList genericASLList = ListManager.getGenericASLList(3834);
                Object[] objectArray = null;
                objectArray = (AVDCAudioBapMediaBrowserCurrentActionStatusCollector[])genericASLList.getDSIObjects();
                objectArray[0].avdc_audio_bap_mediabrowser_action_type = 3;
                objectArray[0].avdc_audio_bap_mediabrowser_action_status = 3;
                genericASLList.updateList(objectArray);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(556);
                break;
            }
            case 1074541841: {
                Command command = CmdPlaybackPause.createUserPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound());
                this.mCommandQue.addCommand(new CmdExecuteBAPAction(command, 6));
                break;
            }
            case 1074541844: {
                boolean bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1073741912: {
                break;
            }
            case 1073741913: {
                this.mCommandQue.addCommand(new CmdClose(this.allComponents.getBrowser_MainView()));
                break;
            }
            case 1073741914: {
                this.mCommandQue.addCommand(new CmdDeleteChar(this.allComponents.getBrowser_MainView()));
                break;
            }
            case 1073741915: 
            case 1073741916: {
                this.mCommandQue.addCommand(new CmdInitialize(this.allComponents.getBrowser_MainView()));
                break;
            }
            case 1074541848: {
                String string = eventGeneric.getString(0);
                int n = eventGeneric.getInt(2);
                int n7 = eventGeneric.getInt(3);
                int n8 = eventGeneric.getInt(1);
                CmdSetChar cmdSetChar = new CmdSetChar(this.allComponents.getBrowser_MainView(), string, n, n7, n8);
                this.mCommandQue.addCommand(cmdSetChar);
                break;
            }
            case 1073743742: {
                int n = eventGeneric.getInt(0);
                CmdSetCursorPos cmdSetCursorPos = new CmdSetCursorPos(this.allComponents.getBrowser_MainView(), n);
                this.mCommandQue.addCommand(cmdSetCursorPos);
                break;
            }
            case 1073741918: {
                this.mCommandQue.addCommand(new CmdSetSearchFilter(this.allComponents.getBrowser_MainView()));
                break;
            }
            case 4300043: {
                break;
            }
            case 100017: {
                this.debounceSkip(1, false);
                break;
            }
            case 100018: {
                this.debounceSkip(-1, true);
                break;
            }
            case 100015: {
                MediaCollector mediaCollector = this.allComponents.getPlayer().getActiveMedia();
                MediaPlaybackModes mediaPlaybackModes = this.allComponents.getPlayer().getPlayerState().getPlaybackModeList();
                PlayMode playMode = this.allComponents.getPlayer().getPlayerState().getPlaybackMode();
                MediaCollector mediaCollector4 = this.allComponents.getBrowser_MainView().getBrowseMedia();
                PlayMode playMode4 = (PlayMode)eventGeneric.getObject(1);
                if (mediaCollector == mediaCollector4 && mediaCollector.storesOwnPlaybackState()) {
                    if (playMode4 == PlayMode.DUMMY_MIX) {
                        playMode4 = mediaPlaybackModes.toggleMix(playMode);
                    } else if (playMode4 == PlayMode.DUMMY_REPEAT) {
                        playMode4 = mediaPlaybackModes.toggleRepeat(playMode);
                    } else if (playMode4 == PlayMode.DUMMY_REPEAT_FILE) {
                        playMode4 = mediaPlaybackModes.toggleRepeatFile(playMode);
                    }
                }
                this.trace("HAS_SET_PLAYMODE: ");
                this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_Has(), this.allComponents.getPlayer()));
                this.mCommandQue.addCommand(new CmdExecuteHASAction(new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_Has(), playMode4, false, true), eventGeneric.getInt(0), 6));
                break;
            }
            case 100027: {
                if (eventGeneric.getBoolean(1)) {
                    this.trace("ASL_MEDIA_HAS_PMLT: true, enable play more like this");
                    this.mCommandQue.addCommand(new CmdExecuteHASAction(new CmdPlaySimilar(this.allComponents.getPlayer(), this.allComponents.getSound(), this.allComponents.getBrowser_MainView()), eventGeneric.getInt(0), 6));
                    break;
                }
                this.trace("ASL_MEDIA_HAS_PMLT: false, sync browser, set default playmode");
                this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_Has(), this.allComponents.getPlayer()));
                this.mCommandQue.addCommand(new CmdExecuteHASAction(new CmdSetPlaybackMode(this.allComponents, this.allComponents.getBrowser_Has(), PlayMode.DUMMY_PLAY_DEFAULT, false, true), eventGeneric.getInt(0), 6));
                break;
            }
            case 100019: {
                this.mCommandQue.addCommand(new CmdExecuteHASAction(new CmdPlaybackResume(this.allComponents.getPlayer(), this.allComponents.getSound()), eventGeneric.getInt(0), 15));
                break;
            }
            case 100020: {
                this.mCommandQue.addCommand(new CmdExecuteHASAction(CmdPlaybackPause.createUserPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()), eventGeneric.getInt(0), 16));
                break;
            }
            case 100021: {
                this.mCommandQue.addCommand(new CmdExecuteHASAction(new CmdTrack2Time(this.allComponents, eventGeneric.getInt(1)), eventGeneric.getInt(0), 17));
                break;
            }
            case 100022: {
                int n = eventGeneric.getInt(0);
                int n9 = eventGeneric.getInt(1);
                MediaCollector mediaCollector = this.allComponents.getSources().getSourceByID(HASUtil.convertHASSourceIdASL(n9));
                if (mediaCollector.supportsBrowsing()) {
                    int n10 = mediaCollector != null && mediaCollector.supportsContentModeOnly() ? 1 : 0;
                    CmdSetupBrowser cmdSetupBrowser = new CmdSetupBrowser(this.allComponents.getBrowser_Has(), mediaCollector, n10);
                    this.mCommandQue.addCommand(new CmdExecuteHASAction(cmdSetupBrowser, n, 19));
                    break;
                }
                HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
                HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
                ((MediaResults)hASContext.getResultsImpl()).selectMediaBrowserSourceResult(n, 2);
                break;
            }
            case 100023: {
                if (this.mHasFollowModeEnabled) break;
                this.mHasFollowModeEnabled = true;
                this.synchronizeHasBrowserToPlayer();
                break;
            }
            case 100024: {
                if (!this.mHasFollowModeEnabled) break;
                this.mHasFollowModeEnabled = false;
                break;
            }
            case 100025: {
                if (this.mHasFollowModeEnabled) {
                    this.mHasFollowModeEnabled = false;
                }
                MediaHasBrowser mediaHasBrowser = this.allComponents.getBrowser_Has();
                int n = eventGeneric.getInt(0);
                MediaBrowserPathContainer mediaBrowserPathContainer = (MediaBrowserPathContainer)eventGeneric.getObject(1);
                MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray = mediaBrowserPathContainer.getEntries();
                int n11 = HasBrowserFolderPath.getSourceId(mediaBrowserEntryContainerArray);
                MediaCollector mediaCollector = this.allComponents.getSources().getSourceByID(HASUtil.convertHASSourceIdASL(n11));
                int n12 = HasBrowserFolderPath.getPathMode(mediaBrowserEntryContainerArray);
                ListEntry[] listEntryArray = HasBrowserFolderPath.getListEntryPath(mediaBrowserEntryContainerArray);
                CmdSetupBrowser cmdSetupBrowser = new CmdSetupBrowser(mediaHasBrowser, mediaCollector, n12, listEntryArray);
                this.mCommandQue.addCommand(new CmdExecuteHASAction(cmdSetupBrowser, n, 35));
                break;
            }
            case 100026: {
                int n = eventGeneric.getInt(0);
                MediaBrowserEntryContainer mediaBrowserEntryContainer = (MediaBrowserEntryContainer)eventGeneric.getObject(1);
                ListEntry listEntry = HasBrowserListHandler.getListEntry(mediaBrowserEntryContainer);
                if (listEntry == null) break;
                Command command = CmdPlayFile.createById(this.allComponents, this.allComponents.getBrowser_Has(), listEntry.entryID, listEntry.contentType, true);
                this.mCommandQue.addCommand(new CmdExecuteHASAction(command, n, 36));
                break;
            }
            case 100028: {
                if (!this.isMediaContext()) break;
                this.mCommandQue.addCommand(CmdPlaybackPause.createSystemPauseCmd(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 100029: {
                if (!this.isMediaContext()) break;
                this.mCommandQue.addCommand(new CmdRestoreAudioConnection(this.allComponents.getPlayer(), this.allComponents.getSound()));
                break;
            }
            case 100099: {
                break;
            }
            case 2200011: {
                boolean bl = eventGeneric.getBoolean(0);
                MediaController.writeBooleanToDatapool(945556480, bl);
                break;
            }
        }
    }

    public void sourcesAvailable(ISources iSources) {
        this.allComponents.setSources(iSources);
        if (this.isTraceEnabled()) {
            this.trace("MEDIA CONTROLLER ~ SOURCES AVAILABLE");
        }
    }

    private void debounceSkip(int n, boolean bl) {
        if (!this.isTimerActive(-1333395200)) {
            this.mPendingSkipCount = 0;
            this.mPendingSkipConsiderTimePos = bl;
            this.insertSkipCmd(n, bl);
            this.retriggerOrStartTimer(-1333395200, (long)0, false);
        } else {
            this.mPendingSkipCount += n;
        }
    }

    private void insertSkipCmd(int n, boolean bl) {
        CmdSkip cmdSkip = new CmdSkip(this.allComponents.getPlayer(), n, bl);
        this.mCommandQue.addCommand(cmdSkip);
    }

    public Command insertActivateSourceCmd(MediaCollector mediaCollector, boolean bl) {
        CmdActivateSource cmdActivateSource = new CmdActivateSource(this.allComponents, mediaCollector, true, true, bl);
        this.mCommandQue.addCommand(cmdActivateSource);
        return cmdActivateSource;
    }

    public void insertDeactivatePlayerCmd(boolean bl, boolean bl2, CommandCallback commandCallback) {
        CmdDeactivatePlayer cmdDeactivatePlayer = new CmdDeactivatePlayer(this.allComponents.getSound(), this.allComponents.getPlayer(), this.allComponents.getSources(), bl, bl2);
        if (commandCallback != null) {
            cmdDeactivatePlayer.setCommandCallback(commandCallback);
        }
        this.mCommandQue.addCommand(cmdDeactivatePlayer);
    }

    private void initPersistence() {
        MediaObjectAccessor.getPersistence();
    }

    public void syncCoverFlow() {
        MediaPlayer mediaPlayer = this.allComponents.getPlayer();
        if (!(mediaPlayer == null || mediaPlayer.getActiveMedia() == null || mediaPlayer.getActiveMedia().supportsBrowsing() && mediaPlayer.getPlaySelection() == null)) {
            ServiceManager.logger.trace(1024).append("recorder got idle, sync main view").log();
            if (this.allComponents.getBrowser_Cover() != null) {
                this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_Cover(), mediaPlayer));
            }
        }
    }

    private void synchronizeHeadunitBrowserToPlayer() {
        boolean bl;
        MediaPlayer mediaPlayer = this.allComponents.getPlayer();
        MediaMainBrowser mediaMainBrowser = this.allComponents.getBrowser_MainView();
        if (mediaMainBrowser != null && mediaPlayer != null && mediaPlayer.getActiveMedia() != null && (!(bl = mediaPlayer.getActiveMedia().supportsBrowsing()) || mediaPlayer.getPlaySelection() != null) && this.isHeadunitFollowModeActive()) {
            this.mCommandQue.addCommand(new CmdSetupBrowser(mediaMainBrowser, mediaPlayer));
        }
    }

    private void synchronizeCoverBrowserToPlayer() {
        boolean bl;
        MediaPlayer mediaPlayer = this.allComponents.getPlayer();
        MediaCoverBrowser mediaCoverBrowser = this.allComponents.getBrowser_Cover();
        if (!(mediaCoverBrowser == null || mediaPlayer == null || mediaPlayer.getActiveMedia() == null || (bl = mediaPlayer.getActiveMedia().supportsBrowsing()) && mediaPlayer.getPlaySelection() == null || !this.isHeadunitFollowModeActive() || this.allComponents.getRecorder() != null && !this.allComponents.getRecorder().getRecorderState().isRecorderIdle())) {
            this.mCommandQue.addCommand(new CmdSetupBrowser(mediaCoverBrowser, mediaPlayer));
        }
    }

    private boolean synchronizeKombiBrowserToPlayer(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace("synchronizeKombiBrowserToPlayer called!");
        }
        if (!(this.allComponents.getPlayer() == null || this.allComponents.getPlayer().getActiveMedia() == null || this.allComponents.getPlayer().getActiveMedia() == MediaCollector.EMPTY && bl || this.allComponents.getPlayer().getPlaySelection() == null && this.allComponents.getPlayer().getActiveMedia().supportsBrowsing() || this.allComponents.getBrowser_Kombi() == null)) {
            if (this.isTraceEnabled()) {
                this.trace("Add CmdSetupBrowser now ...");
            }
            this.mCommandQue.addCommand(new CmdExecuteBAPAction(new CmdSetupBrowser(this.allComponents.getBrowser_Kombi(), this.allComponents.getPlayer()), 3));
            return true;
        }
        return false;
    }

    private void synchronizeHasBrowserToPlayer() {
        ServiceManager.logger.trace(1024, new StringBuffer().append("synchronizeHasBrowserToPlayer: ").append(this.mHasFollowModeEnabled).toString());
        if (this.allComponents.getPlayer() != null && this.allComponents.getPlayer().getActiveMedia() != null && (this.allComponents.getPlayer().getPlaySelection() != null || !this.allComponents.getPlayer().getActiveMedia().supportsBrowsing()) && this.allComponents.getBrowser_Has() != null && this.mHasFollowModeEnabled) {
            ServiceManager.logger.trace(1024, "   CmdSetupBrowser -> Has to Player");
            this.mCommandQue.addCommand(new CmdSetupBrowser(this.allComponents.getBrowser_Has(), this.allComponents.getPlayer()));
        }
    }

    public void activatePartitionList(int n, long l) {
        switch (n) {
            case 0: {
                this.reportPartitions(SourceIconController.getInstance().getDeviceCollector());
                break;
            }
            case 2: {
                this.reportPartitions(this.allComponents.getBrowser_MainView().getBrowseMedia().getParentDevice());
                break;
            }
            case 4: {
                this.reportPartitions(this.allComponents.getBrowser_Recorder().getBrowseMedia().getParentDevice());
                break;
            }
            case 3: 
            case 5: {
                this.reportPartitions(this.allComponents.getSources().getSourceByID((int)l).getParentDevice());
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("MediaController.activatePartitionList() unhandled type: ").append(n).log();
            }
        }
    }

    private void reportPartitions(DeviceCollector deviceCollector) {
        if (deviceCollector.isSeveralAvailablePartitionsAvailable()) {
            deviceCollector.fillPartitionModelList();
            ServiceManager.aslPropertyManager.valueChangedInteger(3987, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(3987, 3);
        }
    }

    @Override
    public int getComponentId() {
        throw new UnsupportedOperationException();
    }

    public void removeDBLPlaySelection() {
        Selection selection = this.allComponents.getPlayer().getPlaySelection();
        if (selection != null && selection.isDBLSelection()) {
            this.allComponents.getPlayer().resetPlaySelectionForActiveMediaLocally();
        }
    }

    public void resynchronize(AbstractMediaBrowser abstractMediaBrowser) {
        this.warn(new StringBuffer().append("MEDIA CONTROLLER # resynchronization required for: ").append(MediaBrowserHelper.getInstanceIdStr(abstractMediaBrowser)).append("(triggering sync)").toString());
        switch (abstractMediaBrowser.getInstanceId()) {
            case 0: {
                this.synchronizeHeadunitBrowserToPlayer();
                break;
            }
            case 1: {
                this.synchronizeCoverBrowserToPlayer();
                break;
            }
            case 4: {
                this.synchronizeHasBrowserToPlayer();
                break;
            }
            case 3: {
                this.synchronizeKombiBrowserToPlayer(false);
                break;
            }
            case 7: {
                break;
            }
            case 2: {
                break;
            }
        }
    }

    public boolean isHeadunitFollowModeActive() {
        return this.mFollowModeEnabled && !this.mMediaClients.isRecorderEntered();
    }

    private boolean isMediaContext() {
        return this.allComponents.getSources() != null && this.allComponents.getSources().isMediaContext();
    }

    public void synchronizeBrowser(boolean bl, String string) {
        ServiceManager.logger.trace(1024, new StringBuffer().append("synchronizeBrowser: ").append(string).toString());
        this.synchronizeHeadunitBrowserToPlayer();
        this.synchronizeHasBrowserToPlayer();
        this.synchronizeCoverBrowserToPlayer();
        if (bl) {
            this.synchronizeKombiBrowserToPlayer(false);
        }
    }

    public void addCommand(Command command) {
        this.mCommandQue.addCommand(command);
    }

    public void resumeImport() {
        CmdStartImport cmdStartImport = CmdStartImport.createResumeCmd(this.allComponents);
        this.mCommandQue.addCommand(cmdStartImport);
    }

    @Override
    public void addMediaPlayViewListener(MediaPlayViewListener mediaPlayViewListener) {
        this.allComponents.getPlayer().getPlayerState().addPlayViewListener(mediaPlayViewListener);
    }

    @Override
    public void addMediaPlaySimilarListener(MediaPlaySimilarListener mediaPlaySimilarListener) {
        PlaySimilarAttribute playSimilarAttribute = new PlaySimilarAttribute(this.allComponents.getPlayer().getPlayerState());
        playSimilarAttribute.addListener(mediaPlaySimilarListener);
    }

    @Override
    public void addMediaActivationStateListener(MediaActivationStateListener mediaActivationStateListener) {
        this.allComponents.getPlayer().getPlayerState().addActivationStateListener(mediaActivationStateListener);
    }

    @Override
    public void activateMediaSource(SourceId sourceId, Callback callback) {
        this.activateMediaSource(sourceId, this.sourceCallbackFromCallback(callback));
    }

    private SourceCallback sourceCallbackFromCallback(Callback callback) {
        return new MediaController$3(this, callback);
    }

    @Override
    public void activateMediaSource(SourceId sourceId, SourceCallback sourceCallback) {
        MediaCollector mediaCollector = this.allComponents.getSources().getCollector(sourceId);
        this.activateMediaSource(mediaCollector, sourceCallback);
    }

    private void activateMediaSource(MediaCollector mediaCollector, SourceCallback sourceCallback) {
        CmdActivateSource cmdActivateSource = new CmdActivateSource(this.allComponents, mediaCollector, true, true);
        if (sourceCallback != null) {
            MediaController$4 mediaController$4 = new MediaController$4(this, sourceCallback, mediaCollector);
            cmdActivateSource.setCommandCallback(mediaController$4);
        }
        this.mCommandQue.addCommand(cmdActivateSource);
    }

    public void changeSlot() {
        CmdActivateSlot cmdActivateSlot = new CmdActivateSlot(this.allComponents);
        this.mCommandQue.addCommand(cmdActivateSlot);
    }

    @Override
    public void activateMediaSourceByHasId(int n, SourceCallback sourceCallback) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(458);
        MediaCollector mediaCollector = this.allComponents.getSources().getSourceByID(HASUtil.convertHASSourceIdASL(n));
        this.activateMediaSource(mediaCollector, sourceCallback);
    }

    @Override
    public void playEntry(MediaEntry mediaEntry, Callback callback) {
        MediaSpeechBrowser mediaSpeechBrowser = this.allComponents.getBrowser_Speech();
        Command command = mediaEntry.getContentType() == 1 || mediaEntry.getContentType() == 2 ? CmdPlayFile.createById(this.allComponents, mediaSpeechBrowser, mediaEntry.getEntryId(), mediaEntry.getContentType(), false) : CmdPlayFolder.createById(this.allComponents, this.allComponents.getBrowser_Speech(), mediaEntry.getEntryId(), mediaEntry.getContentType(), false);
        MediaController$5 mediaController$5 = new MediaController$5(this, command, callback);
        command.setCommandCallback(mediaController$5);
        this.mCommandQue.addCommand(command);
    }

    @Override
    public void playEntry(int n, Callback callback) {
        MediaSpeechBrowser mediaSpeechBrowser = this.allComponents.getBrowser_Speech();
        Command command = CmdPlayFile.createByIndex(this.allComponents, mediaSpeechBrowser, n, false, false);
        if (callback != null) {
            command.setCommandCallback(this.getDefaultCommandCallback(callback));
        }
        this.mCommandQue.addCommand(command);
    }

    private CommandCallback getDefaultCommandCallback(Callback callback) {
        MediaController$6 mediaController$6 = new MediaController$6(this, callback);
        return mediaController$6;
    }

    @Override
    public void playSimilar(Callback callback) {
        CmdPlaySimilar cmdPlaySimilar = new CmdPlaySimilar(this.allComponents.getPlayer(), this.allComponents.getSound(), this.allComponents.getBrowser_MainView());
        cmdPlaySimilar.setCommandCallback(new MediaController$7(this, callback));
        this.mCommandQue.addCommand(cmdPlaySimilar);
    }

    @Override
    public void requestEntries(List list, int n, MediaEntriesCallback mediaEntriesCallback) {
        MediaSpeechBrowser mediaSpeechBrowser = this.allComponents.getBrowser_Speech();
        MediaController$8 mediaController$8 = new MediaController$8(this, mediaEntriesCallback);
        CmdRequestPickList cmdRequestPickList = new CmdRequestPickList(mediaSpeechBrowser, list, n, mediaController$8);
        this.mCommandQue.addCommand(cmdRequestPickList);
    }

    @Override
    public void browseDatabase(SourceId sourceId, int n, Callback callback) {
        MediaSpeechBrowser mediaSpeechBrowser = this.allComponents.getBrowser_Speech();
        MediaCollector mediaCollector = this.allComponents.getSources().getCollector(sourceId);
        CmdOpenDatabaseCategory cmdOpenDatabaseCategory = new CmdOpenDatabaseCategory(mediaSpeechBrowser, mediaCollector, n);
        cmdOpenDatabaseCategory.setCommandCallback(new MediaController$9(this, callback));
        this.mCommandQue.addCommand(cmdOpenDatabaseCategory);
    }

    @Override
    public void addSpeakableElementsListener(SpeakableElementsListener speakableElementsListener) {
        this.allComponents.getBrowser_Speech().getState().addDatabaseCategoryListener(speakableElementsListener);
    }

    @Override
    public void browseRaw(SourceId sourceId, Callback callback) {
        MediaSpeechBrowser mediaSpeechBrowser = this.allComponents.getBrowser_Speech();
        MediaCollector mediaCollector = this.allComponents.getSources().getCollector(sourceId);
        CmdSetupBrowser cmdSetupBrowser = new CmdSetupBrowser(mediaSpeechBrowser, mediaCollector, 0);
        cmdSetupBrowser.setCommandCallback(new MediaController$10(this, mediaSpeechBrowser, callback));
        this.mCommandQue.addCommand(cmdSetupBrowser);
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        int n2 = 7;
        if (n == 1) {
            n2 = 1;
        }
        CmdFactorySettings cmdFactorySettings = new CmdFactorySettings(this.allComponents, n2);
        cmdFactorySettings.setCommandCallback(new MediaController$11(this, factoryResetCallback));
        this.mCommandQue.addCommand(cmdFactorySettings);
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    static /* synthetic */ MediaComponents access$000(MediaController mediaController) {
        return mediaController.allComponents;
    }

    static /* synthetic */ CommandQueue access$100(MediaController mediaController) {
        return mediaController.mCommandQue;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVER_MEDIA_PLAYBACK_AUDIO_CONTROL = new int[]{0x11000040, 688521280, 705298496, 385876032, 402653248, 419430464, 436207680, 301989952, 1191575616, 0x34000040, 905969728, 989855808, 1056964672, 1023410240, 2046820416, 0x40090040, -879681280};
        OBSERVER_MEDIA_BROWSER = new int[]{151715904, 372575296, 389352512, 755630144, 1392508992, 1442840640, 0xF000040, 939524160, 754974784, 788529216, 520093760, 339020864, 1476395072, 1493172288, 1509949504, 1526726720, 1543503936, 406129728, 2114388032, 1577058368, 339020864, 194855168};
        OBSERVER_MEDIA_RECORDER = new int[]{2064056384, 2080833600, 571146304, 1158283328, 0xE000040, 0xC000040, 637534272, 0xD000040, 1241907264, 0xB000040, 0x42000040, 0x10000040, 671744064};
        OBSERVER_MEDIA_BAP = new int[]{-938868672, -905314240, 238357568, -888537024, 255134784, 288689216};
    }
}

