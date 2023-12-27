/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.browser.MediaBrowserService;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.media.services.browser.SpeakableElementsListener;
import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.player.MediaPlaySimilarListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayViewListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListService;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.framework.api.entertainmentmanager.DefaultEntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.controller.ActivationHandler;
import de.vw.mib.asl.internal.speechmedia.controller.ActivationHandlerSimple;
import de.vw.mib.asl.internal.speechmedia.controller.EntertainmentSourceListener;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController$1;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController$2;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController$3;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController;
import de.vw.mib.asl.internal.speechmedia.controller.SourceListObserver;
import de.vw.mib.asl.internal.speechmedia.sources.util.SourceUtil;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaServiceManager;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.osgi.framework.BundleContext;

public class MediaServiceController
extends DefaultEntertainmentManagerUpdates
implements MediaListListener,
CurrentMediaSourceListener,
SpeakableElementsListener,
MediaPlaySimilarListener,
MediaPlayViewListener,
MediaActivationStateListener {
    public static final int T_SOURCE_CHANGE;
    public static final int MEDIA_CONTEXT;
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[MediaServiceController] ");
    protected final SlotController slotController;
    protected final SpeechMediaServiceManager smServices;
    protected EntertainmentManagerService emService;
    protected MediaListService mediaListService;
    protected CurrentMediaSourceService currentMediaSourceService;
    protected MediaPlayerService mediaPlayerService;
    protected MediaBrowserService mediaBrowserService;
    protected BundleContext bundleContext;
    protected boolean available = false;
    protected boolean active = false;
    protected List sourceStates = null;
    protected Source currentMediaSource;
    protected boolean currentMediaSourceValid = false;
    protected boolean sourceCodingsUpdated = false;
    protected int currentItemCount = 0;
    protected int maxItemCount = 0;
    protected SourceListObserver sourceListObserver = null;
    protected boolean playSimilarAvailable = false;
    protected int playViewSize = 0;
    protected int activationState = 1;
    protected ActivationHandler activationHandler;
    protected ActivationHandlerSimple activationHandlerSimple;
    protected Set currentSourceListeners;
    protected Set entertainmentSourceListeners;
    protected Set activationStateListeners;
    protected SourceCallback activateMediaSourceCallback = new MediaServiceController$1(this);
    private DataService sourceListService = new MediaServiceController$2(this);
    private ASLComponentAPICallback contextApiListener = new MediaServiceController$3(this);
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$player$MediaPlayerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;

    public MediaServiceController(SlotController slotController, SpeechMediaServiceManager speechMediaServiceManager) {
        this.slotController = slotController;
        this.smServices = speechMediaServiceManager;
        this.currentSourceListeners = new HashSet();
        this.entertainmentSourceListeners = new HashSet();
        this.activationStateListeners = new HashSet();
        this.activationHandler = new ActivationHandler(slotController, this);
        this.activationHandlerSimple = new ActivationHandlerSimple(this);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaListService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService, this.contextApiListener);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService == null ? (class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService")) : class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService, this.contextApiListener);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$player$MediaPlayerService == null ? (class$de$vw$mib$asl$api$media$services$player$MediaPlayerService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.player.MediaPlayerService")) : class$de$vw$mib$asl$api$media$services$player$MediaPlayerService, this.contextApiListener);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService == null ? (class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.browser.MediaBrowserService")) : class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService, this.contextApiListener);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = MediaServiceController.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService, this.contextApiListener);
    }

    public void registerCurrentSourceListener(CurrentMediaSourceListener currentMediaSourceListener) {
        this.currentSourceListeners.add(currentMediaSourceListener);
    }

    public void registerEntertainmentSourceListener(EntertainmentSourceListener entertainmentSourceListener) {
        this.entertainmentSourceListeners.add(entertainmentSourceListener);
    }

    public void registerActivateionStateListener(MediaActivationStateListener mediaActivationStateListener) {
        this.activationStateListeners.add(mediaActivationStateListener);
    }

    protected void notifyMediaActive(boolean bl) {
        if (this.active == bl) {
            return;
        }
        this.active = bl;
        if (this.logger.isTraceEnabled()) {
            if (bl) {
                this.logger.trace("Media is active entertainment source.");
            } else {
                this.logger.trace("Media is NOT active entertainment source.");
            }
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(-1249824256, bl);
        Iterator iterator = this.entertainmentSourceListeners.iterator();
        while (iterator.hasNext()) {
            EntertainmentSourceListener entertainmentSourceListener = (EntertainmentSourceListener)iterator.next();
            entertainmentSourceListener.onEntertainmentSourceChanged(bl);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean isPlaySimilarAvailable() {
        return this.playSimilarAvailable;
    }

    public Source getCurrentMediaSource() {
        return this.currentMediaSource;
    }

    public int getActivationState() {
        return this.activationState;
    }

    public int getPlayViewSize() {
        return this.playViewSize;
    }

    public boolean isCurrentMediaSourceValid() {
        return this.currentMediaSourceValid;
    }

    public MediaBrowserService getMediaBrowserService() {
        return this.mediaBrowserService;
    }

    protected void notifyMediaDomainAvailable(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            if (bl) {
                this.logger.trace("Media domain is available.");
            } else {
                this.logger.trace("Media domain is NOT available.");
            }
        }
        this.available = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(-1266601472, bl);
    }

    private void updateSourceCodings() {
        if (this.sourceStates == null) {
            return;
        }
        this.sourceCodingsUpdated = true;
        AbstractASLHsmTarget.writeBooleanToDatapool(-1082052096, SourceUtil.containsSource(this.sourceStates, 8));
        AbstractASLHsmTarget.writeBooleanToDatapool(-1098829312, SourceUtil.containsSource(this.sourceStates, 10));
        if (SourceUtil.containsSource(this.sourceStates, 3)) {
            AbstractASLHsmTarget.writeBooleanToDatapool(-1165938176, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1149160960, true);
        } else {
            AbstractASLHsmTarget.writeBooleanToDatapool(-1149160960, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1165938176, SourceUtil.containsSource(this.sourceStates, 4));
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(-1182715392, SourceUtil.containsSource(this.sourceStates, 0));
        AbstractASLHsmTarget.writeBooleanToDatapool(-1132383744, SourceUtil.containsSource(this.sourceStates, 1));
        AbstractASLHsmTarget.writeBooleanToDatapool(-1115606528, SourceUtil.containsSource(this.sourceStates, 2));
        AbstractASLHsmTarget.writeBooleanToDatapool(-1065274880, SourceUtil.containsSource(this.sourceStates, 9));
    }

    private void doError(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(-1048497664, n);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1233047040, 4);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1065274880);
    }

    public void doFatalError() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-612290048);
    }

    public void activateSource(int n) {
        if (!this.isActive()) {
            this.activate();
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("triggered activateSource() with sourceId: ").append(n).log();
        }
        if (n == -1) {
            this.logger.error("activateSource() failed, due tu unknown sourceId.");
            this.doFatalError();
            return;
        }
        if (!this.isAvailable()) {
            this.logger.warn("activateSource() failed, due tu unavailable MediaService.");
            this.doError(n);
            return;
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1048497664, n);
        Source source = this.getAvailableSource(n);
        if (source == null || !source.isUserVisible()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("source is not available");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-964611584);
            return;
        }
        if (this.isActive() && this.isSourceActive(source)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Source is already active.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-947834368);
            int n2 = source.getInsertion();
            if (n2 == 14) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-931057152);
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-897502720);
            }
            return;
        }
        if (!source.isPlayable() && source.getInsertion() != 14) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Source is uservisible but not playable -> error state");
            }
            if (source.getSourceId().getDeviceType() == 10) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Source is BT -> go to BT screen");
                }
                this.gotoBluetothSetup();
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-964611584);
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-981388800);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Activate the source. Call MediaService.");
        }
        this.mediaPlayerService.activateMediaSource(source.getSourceId(), this.activateMediaSourceCallback);
    }

    private void gotoBluetothSetup() {
        CioIntent cioIntent = this.smServices.getCioDictionary().getCioIntent("ShowBluetoothMediaDeviceSelection");
        this.smServices.getCioDispatcher().dispatch(cioIntent);
    }

    protected Source getAvailableSource(int n) {
        if (n == 20) {
            Source source = null;
            for (int i2 = 0; i2 < 4; ++i2) {
                Source source2 = SourceUtil.getSourceState(this.sourceStates, 5 + i2);
                if (source2 == null || !source2.isUserVisible()) continue;
                source = source2;
                if (!this.isActive() || this.isActive() && !this.isSourceActive(source2)) break;
            }
            return source;
        }
        if (n == 30) {
            Source source = null;
            for (int i3 = 0; i3 < 2; ++i3) {
                Source source3 = SourceUtil.getSourceState(this.sourceStates, 3 + i3);
                if (source3 == null || !source3.isUserVisible()) continue;
                source = source3;
                if (!this.isActive() || this.isActive() && !this.isSourceActive(source3)) break;
            }
            return source;
        }
        return SourceUtil.getSourceState(this.sourceStates, n);
    }

    public void playSimilar(Callback callback) {
        this.mediaPlayerService.playSimilar(callback);
    }

    public void play(MediaEntry mediaEntry, Callback callback) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append("triggered play(), mediaEntry: ");
            logMessage.append(String.valueOf(mediaEntry));
            logMessage.log();
        }
        try {
            this.mediaBrowserService.playEntry(mediaEntry, callback);
        }
        catch (Exception exception) {
            this.logger.error("playEntry(...) failed with exception in Media, call NOK on callback.", exception);
            callback.response(ResultCode.NOK);
        }
    }

    public void playTrack(int n, Callback callback) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append("triggered playTrack(), index: ");
            logMessage.append(n);
            logMessage.log();
        }
        try {
            this.mediaBrowserService.playEntry(n, callback);
        }
        catch (Exception exception) {
            this.logger.error("playTrack(...) failed with exception in Media, call NOK on callback.", exception);
            callback.response(ResultCode.NOK);
        }
    }

    private int categoryFromUseCase(int n) {
        switch (n) {
            case 0: {
                return 5;
            }
            case 1: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 2;
            }
        }
        this.logger.error().append("Unknown useCase: ").append(n).log();
        return 0;
    }

    public void browseCurrentSource(int n, Callback callback) {
        SourceId sourceId = this.currentMediaSource.getSourceId();
        if (SourceUtil.isOptical(sourceId)) {
            this.mediaBrowserService.browseRaw(sourceId, callback);
            return;
        }
        try {
            this.mediaBrowserService.browseDatabase(sourceId, this.categoryFromUseCase(n), callback);
        }
        catch (Exception exception) {
            this.logger.error("browseCurrentSource(...) failed with exception in Media, call NOK on callback.", exception);
            callback.response(ResultCode.NOK);
        }
    }

    public boolean exceedsMaxTitles() {
        return this.currentItemCount > this.maxItemCount;
    }

    public int getCurrentItemCount() {
        return this.currentItemCount;
    }

    public void activate() {
        if (this.active) {
            return;
        }
        this.emService.requestContext(2);
    }

    public void activate(Callback callback) {
        this.activationHandlerSimple.activate(callback);
    }

    public void activate(int n, Callback callback) {
        this.activationHandler.activate(n, callback);
    }

    public boolean isSourceActive(Source source) {
        return source.getSourceId().getDeviceType() == this.currentMediaSource.getSourceId().getDeviceType() && source.getSourceId().getSlot() == this.currentMediaSource.getSourceId().getSlot();
    }

    public int getAlbumState() {
        return this.slotController.getAlbumState();
    }

    public int getArtistState() {
        return this.slotController.getArtistState();
    }

    public int getGenreState() {
        return this.slotController.getGenreState();
    }

    public int getTrackState() {
        return this.slotController.getTrackState();
    }

    public int getTitleState() {
        return this.slotController.getTitleState();
    }

    public int getUseCaseSlotState(int n) {
        switch (n) {
            case 1: {
                return this.getAlbumState();
            }
            case 2: {
                return this.getArtistState();
            }
            case 3: {
                return this.getGenreState();
            }
            case 0: {
                return this.getTitleState();
            }
            case 4: {
                return this.getTrackState();
            }
        }
        this.logger.error().append("getUseCaseSlotState() - Unknown usecase: ").append(n).log();
        return -1;
    }

    public void setSourceListObserver(SourceListObserver sourceListObserver) {
        this.sourceListObserver = sourceListObserver;
    }

    public SpeechMediaServiceManager getSpeechMediaServiceManager() {
        return this.smServices;
    }

    public DataService getSourceListService() {
        return this.sourceListService;
    }

    @Override
    public void onUpdateEntertainmentSource(int n, int n2) {
        this.notifyMediaActive(n == 2);
    }

    @Override
    public void updateCurrentMediaSource(Source source) {
        if (source == null || source.getSourceId().getDeviceType() < 0) {
            if (this.currentMediaSource == null) {
                this.currentMediaSource = source;
            }
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Current media source not set.");
            }
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Current media source changed: ").append(source.toString()).log();
        }
        this.currentMediaSourceValid = true;
        this.currentMediaSource = source;
        Iterator iterator = this.currentSourceListeners.iterator();
        while (iterator.hasNext()) {
            CurrentMediaSourceListener currentMediaSourceListener = (CurrentMediaSourceListener)iterator.next();
            currentMediaSourceListener.updateCurrentMediaSource(this.currentMediaSource);
        }
    }

    @Override
    public void updateSources(List list) {
        this.sourceStates = list;
        if (this.sourceListObserver != null) {
            this.sourceListObserver.onUpdateSourceList(SourceUtil.fromSourceStates(this.sourceStates));
        }
        if (!this.sourceCodingsUpdated) {
            this.smServices.getAslListManager().getGenericASLList(-1300155904).updateList(SourceUtil.fromSourceStates(this.sourceStates));
            this.updateSourceCodings();
        }
    }

    @Override
    public void updateSpeakableElementCount(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Count DB entries: ").append(n).append(", max: ").append(n2).log();
        }
        this.currentItemCount = n;
        this.maxItemCount = n2;
    }

    @Override
    public void updatePlaySimilarAvailable(boolean bl) {
        this.playSimilarAvailable = bl;
    }

    @Override
    public void updatePlayViewSize(int n) {
        this.playViewSize = n;
    }

    @Override
    public void updateActivationState(int n) {
        if (this.activationState == n) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("changed source activation state from ").append(this.activationStateToString(this.activationState)).append(" to ").append(this.activationStateToString(n)).log();
        }
        this.activationState = n;
        Iterator iterator = this.activationStateListeners.iterator();
        while (iterator.hasNext()) {
            MediaActivationStateListener mediaActivationStateListener = (MediaActivationStateListener)iterator.next();
            mediaActivationStateListener.updateActivationState(n);
        }
    }

    private String activationStateToString(int n) {
        switch (n) {
            case 3: {
                return "ACTIVATION_STATE_ACTIVATED";
            }
            case 2: {
                return "ACTIVATION_STATE_ACTIVATING";
            }
            case 1: {
                return "ACTIVATION_STATE_DEACTIVATED";
            }
            case 0: {
                return "ACTIVATION_STATE_DEACTIVATING";
            }
        }
        return new StringBuffer().append("Unknown[").append(n).append("]").toString();
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

