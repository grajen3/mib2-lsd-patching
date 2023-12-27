/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.persistence;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence$1;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.media.persistence.MediaPersistenceService;
import de.vw.mib.asl.media.persistence.MediaPersistenceServiceImpl;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.asl.media.persistence.PlayerPersistence;

public final class MediaPersistence {
    private final MediaPersistenceService mediaPersistenceService = MediaPersistenceServiceImpl.getInstance();
    private PlayerPersistence playerPersistence;

    public static int getVideoFormatDefault() {
        return 0;
    }

    public static boolean getIncludeSubfoldersDefault() {
        return true;
    }

    public static boolean isVideoMaximizedDefault() {
        return true;
    }

    public MediaPersistence() {
        this.clear();
        this.loadPersi2_0();
        this.registerProfileChangeHandler();
    }

    void loadPersi2_0() {
        this.playerPersistence = this.mediaPersistenceService.loadPlayerPersistence();
    }

    public void clear() {
        ServiceManager.logger.info(1024).append("MediaPersistence.clear()").log();
        if (this.playerPersistence != null) {
            this.playerPersistence.resetToDefaults();
        } else {
            this.playerPersistence = this.mediaPersistenceService.loadPlayerPersistence();
        }
    }

    public boolean isIncludeSubfolders() {
        return this.playerPersistence.isIncludeSubfolder();
    }

    public void setIsIncludeSubfolders(boolean bl) {
        this.playerPersistence.setIncludeSubfolder(bl);
    }

    public void setVideoFormat(int n) {
        this.playerPersistence.setVideoFormat(n);
    }

    public int getVideoFormat() {
        return this.playerPersistence.getVideoFormat();
    }

    public boolean isVideoMaximized() {
        return this.playerPersistence.isVideoMaximized();
    }

    public void setVideoMaximized(boolean bl) {
        this.playerPersistence.setVideoMaximized(bl);
    }

    public String getParentalManagementPin() {
        return this.playerPersistence.getParentalManagementPin();
    }

    public void setParentalManagementPin(String string) {
        this.playerPersistence.setParentalManagementPin(string);
    }

    public int getParentalManagementLevel() {
        return this.playerPersistence.getParentalManagementLevel();
    }

    public void setParentalManagementLevel(int n) {
        this.playerPersistence.setParentalManagementLevel(n);
    }

    public void storePlaySelection(int n, Selection selection) {
        if (selection == null || !selection.isValid()) {
            ServiceManager.logger.warn(1024).append("Invalid Selection passed to persistence: ").append(selection).log();
        }
        if (selection != null && selection.getUniqueMediaId() != null) {
            this.playerPersistence.getSelections().put(n, selection.createPersistedSelection(this.mediaPersistenceService));
        }
    }

    public Selection getPlaySelection(MediaPlaybackModes mediaPlaybackModes, MediaCollector mediaCollector) {
        return this.getPlaySelection(mediaPlaybackModes, mediaCollector.getObjectId(), mediaCollector.getUniqueMediaID());
    }

    private Selection getPlaySelection(MediaPlaybackModes mediaPlaybackModes, int n, String string) {
        PersistedSelection persistedSelection;
        if (string != null && (persistedSelection = (PersistedSelection)this.playerPersistence.getSelections().get(n)) != null && string.equals(persistedSelection.getUniqeMediaId())) {
            return Selection.copyFromPersi2(mediaPlaybackModes, persistedSelection);
        }
        return null;
    }

    public void removePlaySelection(int n) {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("Removing selection and play mode from persistence for mediaObjectId ").append(n).log();
        }
        this.playerPersistence.getSelections().remove(n);
    }

    public String toString() {
        return new StringBuffer().append("MediaPersistence [, playSelections=").append(this.playerPersistence.getSelections()).append(", videoMaximized=").append(this.playerPersistence.isVideoMaximized()).append(", parentalManagementPin=").append(this.playerPersistence.getParentalManagementPin()).append(", parentalManagementLevel=").append(this.playerPersistence.getParentalManagementLevel()).append("]").toString();
    }

    private void registerProfileChangeHandler() {
        MediaPersistence$1 mediaPersistence$1 = new MediaPersistence$1(this);
        this.mediaPersistenceService.addProfileChangeListener(mediaPersistence$1);
    }
}

