/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipant;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.Timer;
import de.vw.mib.asl.internal.media.sourcehandling.clients.AutoplayDetector;
import de.vw.mib.asl.internal.media.sourcehandling.clients.DeviceAvailabilityMonitor;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaListObservers;
import de.vw.mib.asl.internal.media.sourcehandling.clients.StartupRestorer;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaContextController;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaSourceController;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaSourcesAudio;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$1;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$2;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$DirectRequest;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$IndependentBrowsingRequest;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class MediaInternalSourceHandlingTarget
extends AbstractMediaTarget
implements ISources,
EntertainmentManagerParticipant {
    private final MediaListObservers mediaListObservers;
    private final DeviceAvailabilityMonitor powerController;
    private final MediaContextController mediaContextController;
    private final StartupRestorer startupRestorer;
    private final AutoplayDetector autoplayDetector;
    private final MediaDevices mediaDevices;
    private static final int EV_DEVICE_UNAVAILABLE;
    private static final int[] OBSERVER_MEDIA_BASE;
    private static final int RT_REQUEST_SOURCE;
    private MediaCollector mRequestedSource = null;
    private Runnable activatedCallback = null;
    private Runnable deactivatedCallback = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService;

    public MediaInternalSourceHandlingTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        MediaContextController mediaContextController = this.mediaContextController = new MediaContextController();
        this.mediaListObservers = new MediaListObservers();
        this.mediaDevices = this.mediaListObservers.getMediaDevices();
        MediaSourcesAudio mediaSourcesAudio = new MediaSourcesAudio(this.mediaListObservers, mediaContextController, this.mediaDevices);
        this.mediaContextController.setMediaSourcesAudio(mediaSourcesAudio);
        this.powerController = new DeviceAvailabilityMonitor(this.mediaListObservers.getDeviceFilter(), mediaContextController, mediaSourcesAudio, new Timer(this, -1585053440));
        this.startupRestorer = new StartupRestorer(this.mediaDevices, mediaSourcesAudio);
        this.autoplayDetector = new AutoplayDetector(this.mediaListObservers.getDeviceFilter(), mediaContextController);
        SourceHandlingPersistence.getInstance(this).registerProfileChangeHandler(this);
        this.mediaListObservers.register(this.mediaDevices, new MediaListObserver[]{this.powerController, this.startupRestorer, this.autoplayDetector, mediaSourcesAudio});
    }

    @Override
    public int getDefaultTargetId() {
        return 313463552;
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
                this.addObservers(OBSERVER_MEDIA_BASE);
                this.mediaContextController.reset();
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService = MediaInternalSourceHandlingTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService, new MediaInternalSourceHandlingTarget$1(this));
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = MediaInternalSourceHandlingTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService, new MediaInternalSourceHandlingTarget$2(this));
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER_MEDIA_BASE);
                SourceHandlingPersistence.getInstance().deregisterProfileChangeHandler();
                break;
            }
            case 1073744428: {
                this.request((int)eventGeneric.getLong(0), true);
                break;
            }
            case 0x40000002: {
                this.request(eventGeneric.getInt(0), false);
                break;
            }
            case 0x40000005: {
                if (this.isTraceEnabled()) {
                    this.trace("MISHT Received ACTIVATE_NEXT_AUDIO_SOURCE");
                }
                this.request(SourceIconController.getInstance().skipAvailableMediaSources(1));
                break;
            }
            case 0x40000008: {
                this.request(SourceIconController.getInstance().skipAvailableMediaSources(-1));
                break;
            }
            case 1200003: {
                this.request(eventGeneric.getInt(0), false);
                break;
            }
            case 4300053: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received ASLSystemServiceIds.TRANSITION_TO_STANDBY").log();
                }
                this.powerController.setStandby(true);
                break;
            }
            case 4300054: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received ASL_SYSTEM_TRANSITION_TO_ON").log();
                }
                this.powerController.setStandby(false);
                CurrentAudioSourceState.setWaitingForMedia();
                break;
            }
            case 100001: {
                this.deviceTimedOut();
                break;
            }
        }
    }

    private void request(int n, boolean bl) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(458);
        SourceIconController sourceIconController = SourceIconController.getInstance();
        if ((n & 0xFFFF0000) == 0) {
            n = sourceIconController.skipAvailableMediaSources(0).getAslDeviceID();
        }
        MediaCollector mediaCollector = this.mediaDevices.mediaCollectorFromObjectId(n);
        if (this.mediaDevices.isPartitionChoice(n) && bl) {
            sourceIconController.setCurrentAudioSource(this.mediaDevices.mediaCollectorFromObjectId(n));
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(534);
            return;
        }
        if (MediaSourceController.getInstance().checkSource(mediaCollector, true)) {
            this.request(mediaCollector);
        }
    }

    private void request(MediaCollector mediaCollector) {
        EntertainmentManagerCoreService entertainmentManagerCoreService = (EntertainmentManagerCoreService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = MediaInternalSourceHandlingTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService);
        entertainmentManagerCoreService.request(new MediaInternalSourceHandlingTarget$DirectRequest(this, mediaCollector));
    }

    @Override
    public void doRequest(EntertainmentManagerCoreService entertainmentManagerCoreService) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(458);
        MediaCollector mediaCollector = SourceIconController.getInstance().getDeviceCollector().getMainPartition();
        entertainmentManagerCoreService.request(new MediaInternalSourceHandlingTarget$DirectRequest(this, mediaCollector));
    }

    private void deviceTimedOut() {
        if (this.isTraceEnabled()) {
            this.trace().append("Received MediaEvents.EV_MEDIA_DEVICE_UNAVAILABLE_TIMER").log();
        }
        this.powerController.deviceTimedOut();
    }

    private void handleActivateStartup(boolean bl, int n) {
        this.startupRestorer.setLastEntertainmentContextMedia(bl);
        MediaCollector mediaCollector = this.mediaDevices.mediaCollectorFromObjectId(n);
        if (bl) {
            if (mediaCollector != null && mediaCollector != MediaCollector.EMPTY) {
                this.mediaContextController.setMediaActive(mediaCollector);
            } else {
                this.startupRestorer.checkRestart(n);
            }
        }
        if (this.isTraceEnabled()) {
            this.trace().append("Received LSM event: media = ").append(bl).log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("MediaInternalSourceHandlingTarget.handleActivateStartup(): Received ASL_ENTERTAINMENT_MANAGER_ACTIVATE_STARTUP, isMedia/activeSubcontext = ").append(bl).append("/").append(n).log();
        }
        if (ServiceManager.perfService != null) {
            ServiceManager.perfService.performanceLogMsgByID(6);
        }
        SourceHandlingPersistence.getInstance().setDomainAvailable(n);
    }

    private void handleDeactivate() {
        if (this.isRegisteredForResponse(RT_REQUEST_SOURCE)) {
            this.fireResponse(false);
        }
        this.mediaContextController.deactivateEntertainment();
        this.startupRestorer.cancel();
    }

    @Override
    public void rqRequestSourceActivation(MediaCollector mediaCollector, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_REQUEST_SOURCE, responseHandler)) {
            if (!this.isMediaContext()) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(458);
            }
            SourceIconController.getInstance().setCurrentAudioSource(mediaCollector.getAslDeviceID());
            this.mRequestedSource = mediaCollector;
            EntertainmentManagerCoreService entertainmentManagerCoreService = (EntertainmentManagerCoreService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = MediaInternalSourceHandlingTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService);
            entertainmentManagerCoreService.request(new MediaInternalSourceHandlingTarget$IndependentBrowsingRequest(this, this.mRequestedSource));
            if (this.isTraceEnabled()) {
                this.trace().append("Requested source ").append(mediaCollector).append(" for independent browsing.").log();
            }
        }
    }

    @Override
    public void beginActivation() {
        this.mediaContextController.beginActivation();
        this.startupRestorer.activation();
    }

    @Override
    public void endActivation(MediaCollector mediaCollector, CommandState commandState, boolean bl) {
        this.mediaContextController.handleActiveMedia(mediaCollector, commandState, false);
        if (commandState.isCompleted() && bl) {
            this.powerController.stopTimer();
            CurrentAudioSourceState.setIgnoreError(false);
        }
        if (this.activatedCallback != null) {
            Runnable runnable = this.activatedCallback;
            this.activatedCallback = null;
            runnable.run();
        } else {
            this.trace("received endActivation, but there is no entertainmentCallback");
        }
    }

    @Override
    public void endDeactivation(MediaCollector mediaCollector, CommandState commandState, boolean bl) {
        this.mediaContextController.handleActiveMedia(mediaCollector, commandState, false);
        if (commandState.isCompleted() && bl) {
            this.powerController.stopTimer();
            CurrentAudioSourceState.setIgnoreError(false);
        }
        if (this.deactivatedCallback != null) {
            Runnable runnable = this.deactivatedCallback;
            this.deactivatedCallback = null;
            runnable.run();
        } else {
            this.trace("received endDeactivation, but there is no entertainmentCallback");
        }
    }

    @Override
    public MediaCollector getSourceByID(int n) {
        return this.mediaDevices.mediaCollectorFromObjectId(n);
    }

    @Override
    public MediaCollector getHDD() {
        return this.powerController.getHdd();
    }

    @Override
    public MediaCollector getCollector(SourceId sourceId) {
        return DeviceCollector.get(this.powerController.getDevices().getBySourceId(sourceId)).getMainPartition();
    }

    @Override
    public MediaCollector getSourceById(long l, long l2) {
        return MediaCollector.get(this.powerController.getDevices().getByDeviceId(l).getMediumById(l2));
    }

    @Override
    public boolean isCancelPending() {
        return this.mediaContextController.isCancelledPending();
    }

    @Override
    public boolean isDeviceValid(MediaCollector mediaCollector) {
        return mediaCollector.getParentDevice().isDeviceInValidState();
    }

    @Override
    public boolean checkSource(MediaCollector mediaCollector) {
        return MediaSourceController.getInstance().checkSource(mediaCollector, true);
    }

    @Override
    public void resetToFactorySettings() {
        SourceHandlingPersistence.getInstance().clear();
    }

    @Override
    public void setDisconnectedState(MediaCollector mediaCollector) {
        this.mediaContextController.setDisconnectedState(mediaCollector);
    }

    @Override
    public void setDisconnectedStateWithCallback(CommandCallback commandCallback) {
        this.mediaContextController.setDisconnectedStateWithCallback(commandCallback);
    }

    @Override
    public int getComponentId() {
        return 4;
    }

    @Override
    public boolean isMediaContext() {
        return this.mediaContextController.isMedia();
    }

    @Override
    public void disconnectBluetooth(MediaCollector mediaCollector) {
        Device device;
        if (mediaCollector.getMediaType() == 20 && (device = ASLDeviceHandlingFactory.getDeviceHandlingApi().getDevices().getByDeviceType(10, 0)) != null && device.getMedium(0).getCurrentInfo().getName().equals(mediaCollector.getName())) {
            ServiceManager.eventMain.getEventDispatcher().sendSafe(ServiceManager.mGenericEventFactory.newEvent(-2115095040));
            ServiceManager.logger.info(128, "Sending request to disconnect A2DP!");
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

    static /* synthetic */ void access$000(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, boolean bl, int n) {
        mediaInternalSourceHandlingTarget.handleActivateStartup(bl, n);
    }

    static /* synthetic */ MediaDevices access$100(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        return mediaInternalSourceHandlingTarget.mediaDevices;
    }

    static /* synthetic */ void access$200(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, MediaCollector mediaCollector) {
        mediaInternalSourceHandlingTarget.request(mediaCollector);
    }

    static /* synthetic */ Runnable access$402(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, Runnable runnable) {
        mediaInternalSourceHandlingTarget.activatedCallback = runnable;
        return mediaInternalSourceHandlingTarget.activatedCallback;
    }

    static /* synthetic */ MediaContextController access$500(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        return mediaInternalSourceHandlingTarget.mediaContextController;
    }

    static /* synthetic */ EventGeneric access$600(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, int n, int n2) {
        return mediaInternalSourceHandlingTarget.newEvent(n, n2);
    }

    static /* synthetic */ MediaCollector access$700(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        return mediaInternalSourceHandlingTarget.mRequestedSource;
    }

    static /* synthetic */ int access$800() {
        return RT_REQUEST_SOURCE;
    }

    static /* synthetic */ void access$900(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, boolean bl, int n, String string) {
        mediaInternalSourceHandlingTarget.fireResponse(bl, n, string);
    }

    static /* synthetic */ EventGeneric access$1000(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, int n, int n2) {
        return mediaInternalSourceHandlingTarget.newEvent(n, n2);
    }

    static /* synthetic */ Runnable access$1102(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, Runnable runnable) {
        mediaInternalSourceHandlingTarget.deactivatedCallback = runnable;
        return mediaInternalSourceHandlingTarget.deactivatedCallback;
    }

    static /* synthetic */ void access$1200(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        mediaInternalSourceHandlingTarget.handleDeactivate();
    }

    static {
        OBSERVER_MEDIA_BASE = new int[]{379404544, 513622272, 362627328, 379404544, 0x2000040, 738852928, 0x5000040, 0x8000040, -2091970048};
        RT_REQUEST_SOURCE = MediaInternalSourceHandlingTarget.assignRequestId();
    }
}

