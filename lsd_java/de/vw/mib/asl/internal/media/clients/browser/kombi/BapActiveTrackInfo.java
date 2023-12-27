/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.kombi;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.clients.player.TrackInfo;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserActiveTrackInfoCollector;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.MediaCapabilities;

public class BapActiveTrackInfo {
    private static final GenericASLList BAP_ACTIVE_TRACK_INFO = ListManager.getGenericASLList(526126080);
    private final AVDCAudioBapMediaBrowserActiveTrackInfoCollector[] mActiveTrackInfo = (AVDCAudioBapMediaBrowserActiveTrackInfoCollector[])BAP_ACTIVE_TRACK_INFO.getDSIObjects();
    private ExtendedListEntry mActiveListElement = null;
    private EntryInfo mActiveTrackEntry = null;
    private boolean playerCoverArtSupported;

    public void updateActiveEntry(ExtendedListEntry extendedListEntry) {
        this.mActiveListElement = extendedListEntry;
        this.update(this.mActiveTrackEntry, this.mActiveListElement);
    }

    public void update(MediaPlayerState mediaPlayerState) {
        this.invalidateCoverArt(mediaPlayerState);
        this.mActiveTrackEntry = mediaPlayerState != null && mediaPlayerState.getActiveMedia() != MediaCollector.EMPTY ? mediaPlayerState.getPlaybackEntry() : null;
        this.update(this.mActiveTrackEntry, this.mActiveListElement);
    }

    private void update(EntryInfo entryInfo, ExtendedListEntry extendedListEntry) {
        if (entryInfo == null) {
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_entry_id = -1L;
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_content_type = 0;
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_abs_pos = -1;
        } else if (extendedListEntry != null && MediaBrowserHelper.isFile(extendedListEntry)) {
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_entry_id = extendedListEntry.entryID;
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_content_type = this.getActiveTrackInfoType(extendedListEntry.contentType);
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_abs_pos = extendedListEntry.listIndex;
        } else {
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_entry_id = entryInfo.entryID;
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_content_type = this.getActiveTrackInfoType(entryInfo.contentType);
            this.mActiveTrackInfo[0].avdc_audio_bap_mediabrowser_abs_pos = -1;
        }
        BAP_ACTIVE_TRACK_INFO.updateList(this.mActiveTrackInfo);
    }

    private int getActiveTrackInfoType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    public void onActiveMediaChanged(MediaPlayerState mediaPlayerState) {
        MediaCapabilities mediaCapabilities;
        MediaCollector mediaCollector;
        this.playerCoverArtSupported = false;
        if (mediaPlayerState != null && (mediaCollector = mediaPlayerState.getActiveMedia()) != null && (mediaCapabilities = mediaCollector.getMediaCaps()) != null) {
            this.playerCoverArtSupported = mediaCapabilities.playerCoverArt || mediaCapabilities.coverArt;
        }
        TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_cover_available = !this.playerCoverArtSupported;
    }

    public void updateCoverArt(MediaPlayerState mediaPlayerState) {
        if (this.playerCoverArtSupported) {
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_cover_available = true;
        }
    }

    private void invalidateCoverArt(MediaPlayerState mediaPlayerState) {
        if (this.playerCoverArtSupported) {
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_cover_available = false;
            TrackInfo.CURRENT_TRACK_INFO.updateList(TrackInfo.mMetaInfos);
        }
    }
}

