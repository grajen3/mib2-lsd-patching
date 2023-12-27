/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public interface PlayerStateListener {
    default public void onPlaybackMediaChanged(MediaCollector mediaCollector) {
    }

    default public void onPlaybackModesChanged(MediaPlaybackModes mediaPlaybackModes) {
    }

    default public void onPlaybackModeChanged(PlayMode playMode) {
    }

    default public void onPlayTimeChanged(PlayTime playTime) {
    }

    default public void onPlaySelectionChanged(Selection selection) {
    }

    default public void onPlaybackEntryChanged(ListEntry[] listEntryArray, EntryInfo entryInfo) {
    }

    default public void onCoverArtChanged(ResourceLocator resourceLocator, long l) {
    }

    default public void onActivationStateChanged(int n) {
    }

    default public void onPlaybackStateChanged(int n) {
    }

    default public void onCapabilitiesChanged(Capabilities capabilities) {
    }

    default public void onCmdBlockingMaskChanged(int n) {
    }
}

