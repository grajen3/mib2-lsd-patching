/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.player;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.common.MediaConstants;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioCurrentTrackInfoCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;

public class TrackInfo {
    public static final GenericASLList CURRENT_TRACK_INFO = ListManager.getGenericASLList(58);
    public static AVDCAudioCurrentTrackInfoCollector[] mMetaInfos = (AVDCAudioCurrentTrackInfoCollector[])CURRENT_TRACK_INFO.getDSIObjects();

    public static void updateTrackInfos(MediaPlayerState mediaPlayerState) {
        MediaCollector mediaCollector = null;
        Capabilities capabilities = null;
        EntryInfo entryInfo = null;
        ResourceLocator resourceLocator = null;
        PlayTime playTime = null;
        boolean bl = false;
        if (mediaPlayerState != null) {
            mediaCollector = mediaPlayerState.getActiveMedia();
            capabilities = mediaPlayerState.getCapabilities();
            entryInfo = mediaPlayerState.getPlaybackEntry();
            resourceLocator = mediaPlayerState.getTrackCover();
            playTime = mediaPlayerState.getPlayTime();
            bl = mediaPlayerState.isActivated();
        }
        if (bl && mediaCollector != null && capabilities != null) {
            if (entryInfo != null) {
                String string = entryInfo.title == null || Util.isNullOrEmpty(entryInfo.title.trim()) ? entryInfo.filename : entryInfo.title;
                string = MediaConstants.deleteI18nTags(string);
                string = TrackInfo.deleteIfOnlyWhitespace(string);
                String string2 = entryInfo.filename;
                String string3 = MediaConstants.deleteI18nTags(entryInfo.album);
                string3 = TrackInfo.deleteIfOnlyWhitespace(string3);
                String string4 = MediaConstants.deleteI18nTags(entryInfo.artist);
                string4 = TrackInfo.deleteIfOnlyWhitespace(string4);
                if (mediaCollector.isCDDA()) {
                    string = entryInfo.title == null || !Util.isNullOrEmpty(entryInfo.title.trim()) && entryInfo.title.startsWith("cdda") ? "" : entryInfo.title;
                    string2 = "";
                }
                boolean bl2 = capabilities != null && capabilities.detailInfos && !mediaCollector.isBT() || !Util.isNullOrEmpty(string) || !Util.isNullOrEmpty(string2) || !Util.isNullOrEmpty(string3) || !Util.isNullOrEmpty(string4);
                ServiceManager.aslPropertyManager.valueChangedBoolean(2781, bl2);
                if (bl2) {
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__tracknumber = (int)entryInfo.trackNo;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__title = string;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__filename = string2;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__album = string3;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__artist = string4;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__cover = resourceLocator;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_video_podcast = entryInfo.contentType == 2 && !mediaCollector.isIPod();
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__total_time = playTime != null ? playTime.getTotalTime() : 0;
                    TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_vbr_coded = entryInfo.getAvgBitrate() == -1L || entryInfo.getAvgBitrate() == 0;
                    CURRENT_TRACK_INFO.updateList(mMetaInfos);
                }
            } else if (!capabilities.isDetailInfos()) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(2781, false);
            }
        } else {
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__tracknumber = 0;
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__title = " ";
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__filename = "";
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__album = "";
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__artist = "";
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__cover = null;
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_video_podcast = mediaCollector != null && mediaCollector.isDVDVideo();
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__total_time = playTime != null ? playTime.getTotalTime() : 0;
            TrackInfo.mMetaInfos[0].avdc_audio_current_track_info__is_vbr_coded = false;
            CURRENT_TRACK_INFO.updateList(mMetaInfos);
        }
    }

    private static String deleteIfOnlyWhitespace(String string) {
        return Util.isNullOrEmpty(string) ? "" : string.trim();
    }

    public static void updateChapterInfos(MediaPlayerState mediaPlayerState) {
        MediaCollector mediaCollector = null;
        EntryInfo entryInfo = null;
        boolean bl = false;
        if (mediaPlayerState != null) {
            mediaCollector = mediaPlayerState.getActiveMedia();
            entryInfo = mediaPlayerState.getPlaybackEntry();
            bl = mediaPlayerState.isInitialized();
        }
        if (mediaCollector != null && mediaCollector.isDVDVideoAudio()) {
            int n = 0;
            int n2 = 0;
            if (bl && entryInfo != null) {
                n2 = (int)entryInfo.getTrackNo();
                n = (int)entryInfo.getNumTracks();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(124, n2);
            ServiceManager.aslPropertyManager.valueChangedInteger(125, n);
        }
    }
}

