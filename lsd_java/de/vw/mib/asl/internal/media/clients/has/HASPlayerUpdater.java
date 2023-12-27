/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioCurrentTrackInfoCollector;
import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.contexts.media.MediaProperties;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;

public class HASPlayerUpdater {
    public static final boolean WORKAROUND_FOCUSED_ENTRY;
    private static MediaProperties mHASProperties;
    private static MediaPlayInfoContainer mMediaPlayInfoContainer;
    private static MediaPlayModeContainer mMediaPlayModeContainer;
    private static TrackInfoContainer mTrackInfoContainer;
    private static final GenericASLList CURRENT_TRACK_INFO;
    private static AVDCAudioCurrentTrackInfoCollector mMetaInfo;

    public static void update(MediaPlayerState mediaPlayerState, int n) {
        if (Util.isBitSet(2, n)) {
            HASPlayerUpdater.setTrackInfoContainer(mediaPlayerState);
        }
        HASPlayerUpdater.setMediaPlayInfoContainer(mediaPlayerState);
        if (Util.isBitSet(4, n)) {
            HASPlayerUpdater.setMediaPlayModeContainer(mediaPlayerState);
        }
    }

    private static void setMediaPlayModeContainer(MediaPlayerState mediaPlayerState) {
        mMediaPlayModeContainer.unsetMixMode();
        mMediaPlayModeContainer.unsetRepeatMode();
        mMediaPlayModeContainer.unsetPMLTMode();
        if (mediaPlayerState != null) {
            if (mediaPlayerState.involvesRepeat()) {
                if (mediaPlayerState.involvesRepeatFolder()) {
                    mMediaPlayModeContainer.setRepeatMode(1);
                } else {
                    mMediaPlayModeContainer.setRepeatMode(2);
                }
            } else {
                mMediaPlayModeContainer.setRepeatMode(0);
            }
            mMediaPlayModeContainer.setMixMode(mediaPlayerState.involvesMix());
            mMediaPlayModeContainer.setPMLTMode(mediaPlayerState.isPlaySimilar());
        }
        mHASProperties.updateMediaPlayMode(mMediaPlayModeContainer);
    }

    private static void setTrackInfoContainer(MediaPlayerState mediaPlayerState) {
        if (Util.isNullOrEmpty(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__album)) {
            mTrackInfoContainer.unsetAlbum();
        } else {
            mTrackInfoContainer.setAlbum(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__album);
        }
        if (Util.isNullOrEmpty(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__artist)) {
            mTrackInfoContainer.unsetArtist();
        } else {
            mTrackInfoContainer.setArtist(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__artist);
        }
        if (Util.isNullOrEmpty(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__title.trim())) {
            mTrackInfoContainer.unsetTitle();
        } else {
            mTrackInfoContainer.setTitle(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__title);
        }
        if (HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__cover != null) {
            mTrackInfoContainer.setCover(HASPlayerUpdater.mMetaInfo.avdc_audio_current_track_info__cover);
        } else {
            mTrackInfoContainer.unsetCover();
        }
        if (mediaPlayerState.getCapabilities().isTotalPlaytime() && mediaPlayerState.getCapabilities().isPlayTime() && mediaPlayerState.getPlayTime() != null) {
            mTrackInfoContainer.setLength(mediaPlayerState.getPlayTime().getTotalTime());
        } else {
            mTrackInfoContainer.unsetLength();
        }
        mHASProperties.updateCurrentTrackInfo(mTrackInfoContainer);
    }

    private static void setMediaPlayInfoContainer(MediaPlayerState mediaPlayerState) {
        PlayTime playTime = null;
        EntryInfo entryInfo = null;
        boolean bl = false;
        if (mediaPlayerState != null) {
            playTime = mediaPlayerState.getPlayTime();
            entryInfo = mediaPlayerState.getPlaybackEntry();
            Capabilities capabilities = mediaPlayerState.getCapabilities();
            boolean bl2 = bl = capabilities != null ? capabilities.isPlayTime() : false;
        }
        if (entryInfo == null) {
            mMediaPlayInfoContainer.unsetEntryId();
        } else {
            mMediaPlayInfoContainer.setEntryId(entryInfo.getEntryID());
        }
        mMediaPlayInfoContainer.setState(HASPlayerUpdater.getHASPlayerState(mediaPlayerState));
        mMediaPlayInfoContainer.setEntryType(HASPlayerUpdater.getHASEntryType(mediaPlayerState));
        if (bl && playTime != null) {
            mMediaPlayInfoContainer.setTrackPosition(playTime.getPlayTime());
        } else {
            mMediaPlayInfoContainer.unsetTrackPosition();
        }
        mHASProperties.updateMediaPlayInfo(mMediaPlayInfoContainer);
    }

    public static void updateEntryId(long l) {
        mMediaPlayInfoContainer.setEntryId(l);
        mHASProperties.updateMediaPlayInfo(mMediaPlayInfoContainer);
    }

    private static int getHASEntryType(MediaPlayerState mediaPlayerState) {
        if (mediaPlayerState == null || mediaPlayerState.getActiveMedia() == null || mediaPlayerState.getActiveMedia() == MediaCollector.EMPTY || mediaPlayerState.getPlaybackEntry() == null) {
            return 0;
        }
        switch (mediaPlayerState.getPlaybackEntry().getContentType()) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    private static int getHASPlayerState(MediaPlayerState mediaPlayerState) {
        if (mediaPlayerState == null || mediaPlayerState.getActiveMedia() == null || mediaPlayerState.getActiveMedia() == MediaCollector.EMPTY || mediaPlayerState.getPlaybackPath() == null) {
            return 4;
        }
        switch (mediaPlayerState.getPlaybackState()) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 6: {
                return 3;
            }
            case 7: {
                return 2;
            }
        }
        return 4;
    }

    public static void onFocusedEntryChanged(ExtendedListEntry extendedListEntry) {
        if (extendedListEntry == null) {
            mTrackInfoContainer.unsetTrackNumber();
        } else {
            ServiceManager.logger.trace(1024, new StringBuffer().append("HAS # focusedEntry/trackNumber: ").append(extendedListEntry.listIndex).toString());
            mTrackInfoContainer.setTrackNumber(extendedListEntry.listIndex + 1);
        }
        mHASProperties.updateCurrentTrackInfo(mTrackInfoContainer);
    }

    static {
        CURRENT_TRACK_INFO = ListManager.getGenericASLList(58);
        mMetaInfo = (AVDCAudioCurrentTrackInfoCollector)CURRENT_TRACK_INFO.getDSIObjects()[0];
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        mHASProperties = (MediaProperties)hASContext.getPropertiesImpl();
        HASFactory hASFactory = HAS.getInstance().getFactory();
        mTrackInfoContainer = (TrackInfoContainer)hASFactory.createContainer(22);
        mMediaPlayInfoContainer = (MediaPlayInfoContainer)hASFactory.createContainer(23);
        mMediaPlayModeContainer = (MediaPlayModeContainer)hASFactory.createContainer(24);
    }
}

