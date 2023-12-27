/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public interface DSIMediaPlayerListener
extends DSIListener {
    default public void updateVideoFormat(int n, int n2) {
    }

    default public void updateVideoNorm(int n, int n2) {
    }

    default public void updateCmdBlockingMask(int n, int n2) {
    }

    default public void updateNumVideoAngles(int n, int n2) {
    }

    default public void updatePlaybackModeList(PlaybackMode[] playbackModeArray, int n) {
    }

    default public void updatePlaybackMode(int n, int n2) {
    }

    default public void updatePlaybackState(int n, int n2) {
    }

    default public void updateActiveMedia(long l, long l2, int n, int n2, int n3) {
    }

    default public void updatePlaybackFolder(ListEntry[] listEntryArray, int n) {
    }

    default public void updateCapabilities(Capabilities capabilities, int n) {
    }

    default public void updatePlayPosition(long l, int n, int n2, int n3) {
    }

    default public void updatePlayViewSize(int n, int n2, int n3) {
    }

    default public void updateActiveVideoAngle(int n, int n2) {
    }

    default public void updateAudioStreamList(AudioStream[] audioStreamArray, int n) {
    }

    default public void updateActiveAudioStream(int n, int n2) {
    }

    default public void updateSubtitleList(int[] nArray, int n) {
    }

    default public void updateActiveSubtitle(int n, int n2) {
    }

    default public void responseCmdBlocked(int n) {
    }

    default public void responseRating(long l, int n) {
    }

    default public void responseFullyQualifiedName(long l, String string) {
    }

    default public void responseCoverArt(long l, ResourceLocator resourceLocator) {
    }

    default public void responsePlayView(ListEntry[] listEntryArray, int n, int n2, int n3) {
    }

    default public void responseDetailInfo(EntryInfo entryInfo) {
    }

    default public void indicationDvdEvent(int n) {
    }

    default public void responseSetPlaySelection(int n, int n2) {
    }

    default public void responseSetPlaySelectionAB(int n, boolean bl) {
    }

    default public void responseSetPlaybackURL(String string) {
    }

    default public void responseSetVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void responsePlaySimilarEntry(long l, boolean bl) {
    }

    default public void tempPMLRequest(int n) {
    }

    default public void updatePlaybackContentFolder(ListEntry[] listEntryArray, int n) {
    }
}

