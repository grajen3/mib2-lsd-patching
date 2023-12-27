/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaAction;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaActiveTrackInfo;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaBrowsedFolder;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaBrowsedFolderActiveElement;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaCurrentTrackInfo;
import java.util.Iterator;

public interface MediaService {
    default public void addMediaServiceListener(MediaServiceListener mediaServiceListener, int[] nArray) {
    }

    default public void removeMediaServiceListener(MediaServiceListener mediaServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public int getCurrentAudioSource() {
    }

    default public int getCurrrentAudioSourceState() {
    }

    default public boolean getWlanDeviceConnected() {
    }

    default public MediaCurrentTrackInfo getCurrentTrackInfo() {
    }

    default public MediaActiveTrackInfo getActiveTrackInfo() {
    }

    default public int getCDMediumType() {
    }

    default public int getCDContentType() {
    }

    default public int getDvdChapter() {
    }

    default public int getDvdChapterCount() {
    }

    default public boolean isDvdMainMenuActive() {
    }

    default public boolean isDVDRegionCodeMismatched() {
    }

    default public boolean isBapMediaBrowserAvailable() {
    }

    default public int getBapMediaBrowserState() {
    }

    default public String getCurrentlyPlayedFolderName() {
    }

    default public boolean isRepeatSupported() {
    }

    default public boolean isRepeatActive() {
    }

    default public int getRepeatMode() {
    }

    default public boolean isMixSupported() {
    }

    default public boolean isMixActive() {
    }

    default public boolean areSubfoldersIncluded() {
    }

    default public boolean isPlayMoreLikeThisActive() {
    }

    default public boolean isSkipForwardSupported() {
    }

    default public boolean isSkipBackwardSupported() {
    }

    default public int getPlayerState() {
    }

    default public int getRemoteControlPlayerState() {
    }

    default public int getConnectedMitsumiAdapter() {
    }

    default public int getCurrentImportSource() {
    }

    default public int getCurrentImportState() {
    }

    default public int getCurrentImportProgress() {
    }

    default public int getJukeboxDeletionState() {
    }

    default public MediaAction getCurrentAction() {
    }

    default public MediaBrowsedFolder getCurrentlyBrowsedFolder() {
    }

    default public MediaBrowsedFolderActiveElement getBrowsedFolderActiveElement() {
    }

    default public Iterator getFileBrowser() {
    }

    default public Iterator getWindowedFileBrowser(int[] nArray) {
    }

    default public boolean isDatabaseBrowsingActive() {
    }

    default public boolean isSecondUSBSocketAvailable() {
    }

    default public boolean isMetaInfoRequestSupported() {
    }

    default public Iterator getAvailableAudioSources() {
    }

    default public int getBapContentTypeForActiveTrack(int n) {
    }

    default public int getPlayEntryContentTypeForFileBrowserContentType(int n) {
    }

    default public int getFolderContentTypeForFilerBrowserContentType(int n) {
    }

    default public int getBapContentTypeForBrowsedFolderActiveElement(int n) {
    }

    default public int getBapContentTypeForBrowsedFolder(int n) {
    }

    default public void toggleSubfolderInclusionState() {
    }

    default public void startFastForward() {
    }

    default public void startFastRewind() {
    }

    default public void stopFastForward() {
    }

    default public void stopFastRewind() {
    }

    default public void activateAudioSourceByID(int n) {
    }

    default public void skipForwardWithCounter(int n) {
    }

    default public void skipBackwardWithCounter(int n) {
    }

    default public void activateNextDVDChapter() {
    }

    default public void activatePreviousDVDChapter() {
    }

    default public void activateSelectedDVDMenuItem() {
    }

    default public void setRepeatMode(int n) {
    }

    default public void setMixMode(int n) {
    }

    default public void setPlayMoreLikeThisState(boolean bl) {
    }

    default public void startBrowsingSourceById(int n) {
    }

    default public void openFolderEntry(long l, int n) {
    }

    default public void moveFolderLevelUp(int n) {
    }

    default public void triggerFollowMode() {
    }

    default public void playFileEntry(long l, int n) {
    }

    default public void setPlayerPaused() {
    }
}

