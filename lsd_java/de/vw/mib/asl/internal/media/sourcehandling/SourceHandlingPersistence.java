/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence$1;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.asl.media.persistence.MediaPersistenceService;
import de.vw.mib.asl.media.persistence.MediaPersistenceServiceImpl;
import de.vw.mib.asl.media.persistence.SourcesPersistence;

public final class SourceHandlingPersistence {
    private static SourceHandlingPersistence instance;
    private final MediaPersistenceService mediaPersistenceService;
    private SourcesPersistence sourcesPersistence;
    private boolean mediaDomainStatusUpdated = false;
    private DsiAwareProfileChangeListener profileChangeListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$player$MediaPlayerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService;

    public static SourceHandlingPersistence getInstance() {
        if (instance == null) {
            throw new IllegalStateException("SourceHandling not properly initialized!");
        }
        return instance;
    }

    public static SourceHandlingPersistence getInstance(ISources iSources) {
        if (instance == null) {
            instance = new SourceHandlingPersistence(MediaPersistenceServiceImpl.getInstance());
        }
        return instance;
    }

    private SourceHandlingPersistence(MediaPersistenceService mediaPersistenceService) {
        this.mediaPersistenceService = mediaPersistenceService;
        this.sourcesPersistence = mediaPersistenceService.loadSourcesPersistence();
    }

    public void clear() {
        ServiceManager.logger.info(128).append("SourceHandlingPersistence.clear()").log();
        this.sourcesPersistence.resetToDefaults();
    }

    public void setDomainAvailable(int n) {
        if (!this.mediaDomainStatusUpdated) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Setting media domain available! ").append(n).append(", mediaType=").append(this.sourcesPersistence.getMediaType()).log();
            }
            MediaObjectAccessor.getModelController().setCDContentFormat(this.sourcesPersistence.getMediaType());
            if (n == 0) {
                n = SourceIconController.getInstance().skipAvailableMediaSources(0).getAslDeviceID();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(4139, 2);
            SourceIconController.getInstance().setCurrentAudioSource(n);
            ServiceManager.aslPropertyManager.valueChangedInteger(4139, 0);
            MediaController mediaController = MediaObjectAccessor.mMediaController;
            ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$media$services$player$MediaPlayerService == null ? (class$de$vw$mib$asl$api$media$services$player$MediaPlayerService = SourceHandlingPersistence.class$("de.vw.mib.asl.api.media.services.player.MediaPlayerService")) : class$de$vw$mib$asl$api$media$services$player$MediaPlayerService, mediaController);
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService == null ? (class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService = SourceHandlingPersistence.class$("de.vw.mib.asl.api.media.services.browser.MediaBrowserService")) : class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService, mediaController);
            CurrentAudioSourceState.setWaitingForMedia();
            ServiceManager.aslPropertyManager.valueChangedInteger(1674, 1);
            this.mediaDomainStatusUpdated = true;
        }
    }

    public void storePartition(MediaCollector mediaCollector) {
        if (mediaCollector != MediaCollector.EMPTY) {
            if (mediaCollector.getParentDevice().getPartitions().length > 1) {
                this.sourcesPersistence.getPartitionLSM().put(mediaCollector.getAslDeviceID(), mediaCollector.getSlotNumber());
            }
        } else {
            ServiceManager.logger.warn(128).append("storing MediaCollector.EMPTY").attachThrowable(new IllegalArgumentException("storing MediaCollector.EMPTY")).log();
        }
        this.sourcesPersistence.setObjectId(mediaCollector.getObjectId());
    }

    public void setOpticalContentType(int n) {
        if (this.sourcesPersistence.getMediaType() != n) {
            this.sourcesPersistence.setMediaType(n);
        }
        MediaObjectAccessor.getModelController().setCDContentFormat(n);
    }

    public static int getContentTypeDefault() {
        return 1;
    }

    public int getPartitionLSM(int n) {
        if (this.sourcesPersistence.getPartitionLSM().containsKey(n)) {
            return this.sourcesPersistence.getPartitionLSM().get(n);
        }
        return -1;
    }

    public void resetPartitionLSM(int n) {
        this.sourcesPersistence.getPartitionLSM().remove(n);
    }

    public boolean getDatabaseFullReported(int n) {
        return this.sourcesPersistence.getDatabaseFullReported().contains(n);
    }

    public void setDatabaseFullReported(int n, boolean bl) {
        if (bl) {
            this.sourcesPersistence.getDatabaseFullReported().add(n);
        } else {
            this.sourcesPersistence.getDatabaseFullReported().remove(n);
        }
    }

    public boolean isVirgin(MediaCollector mediaCollector) {
        Integer n = new Integer(mediaCollector.getObjectId());
        if (!this.sourcesPersistence.getDeflowered().containsKey(n)) {
            return true;
        }
        String string = (String)this.sourcesPersistence.getDeflowered().get(n);
        return !string.equals(mediaCollector.getUniqueMediaID());
    }

    public void markDeflowered(MediaCollector mediaCollector) {
        this.sourcesPersistence.getDeflowered().put(new Integer(mediaCollector.getObjectId()), mediaCollector.getUniqueMediaID());
    }

    public void checkVirginity(MediaCollector mediaCollector) {
        Integer n = new Integer(mediaCollector.getObjectId());
        if (!this.sourcesPersistence.getDeflowered().containsKey(n)) {
            return;
        }
        String string = (String)this.sourcesPersistence.getDeflowered().get(n);
        if (!string.equals(mediaCollector.getUniqueMediaID())) {
            this.sourcesPersistence.getDeflowered().remove(n);
            return;
        }
        if (mediaCollector.getMedium().isJustLoaded() || mediaCollector.getMedium().isJustFullyRemoved()) {
            this.sourcesPersistence.getDeflowered().remove(n);
        }
    }

    public String toString() {
        return new StringBuffer().append("SourceHandlingPersistence [, mediaType=").append(this.sourcesPersistence.getMediaType()).append(", partitionLSM=").append(this.sourcesPersistence.getPartitionLSM().toString()).append("]").toString();
    }

    public void domainUnavailable() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1674, 0);
        this.mediaDomainStatusUpdated = false;
    }

    public void deregisterProfileChangeHandler() {
        if (this.profileChangeListener != null) {
            this.mediaPersistenceService.removeProfileChangeListener(this.profileChangeListener);
            this.profileChangeListener = null;
        }
    }

    public void registerProfileChangeHandler(ISources iSources) {
        this.profileChangeListener = new SourceHandlingPersistence$1(this, iSources);
        this.mediaPersistenceService.addProfileChangeListener(this.profileChangeListener);
    }

    public int getObjectId() {
        int n = this.sourcesPersistence.getObjectId();
        if ((n & 0xFFFF0000) == 0) {
            n = SourceIconController.getInstance().getFirstAvailable().getObjectId();
        }
        return n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ SourcesPersistence access$002(SourceHandlingPersistence sourceHandlingPersistence, SourcesPersistence sourcesPersistence) {
        sourceHandlingPersistence.sourcesPersistence = sourcesPersistence;
        return sourceHandlingPersistence.sourcesPersistence;
    }

    static /* synthetic */ MediaPersistenceService access$100(SourceHandlingPersistence sourceHandlingPersistence) {
        return sourceHandlingPersistence.mediaPersistenceService;
    }
}

