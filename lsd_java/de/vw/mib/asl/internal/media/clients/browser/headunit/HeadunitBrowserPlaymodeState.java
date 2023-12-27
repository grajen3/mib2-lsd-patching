/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public class HeadunitBrowserPlaymodeState {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;
    private static boolean mSearchEnabled;

    public static void onSearchEnabledChanged(MediaBrowserState mediaBrowserState, MediaPlayerState mediaPlayerState, boolean bl) {
        mSearchEnabled = bl;
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(mediaBrowserState, mediaPlayerState);
    }

    public static void updateSupportedPlaymodes(MediaBrowserState mediaBrowserState, MediaPlayerState mediaPlayerState) {
        MediaCollector mediaCollector = MediaCollector.EMPTY;
        Object[] objectArray = null;
        boolean bl = false;
        boolean bl2 = false;
        if (mediaBrowserState != null) {
            mediaCollector = mediaBrowserState.getBrowseMedia();
            objectArray = mediaBrowserState.getBrowseFolder();
            bl2 = mediaBrowserState.isBrowsingAvailable();
            bl = mediaBrowserState.isBrowsingInitialized();
        }
        boolean bl3 = false;
        MediaPlaybackModes mediaPlaybackModes = null;
        EntryInfo entryInfo = null;
        if (mediaPlayerState != null) {
            bl3 = mediaPlayerState.getActivationState() == 3 || mediaPlayerState.getActivationState() == 1;
            mediaPlaybackModes = mediaPlayerState.getPlaybackModeList();
            entryInfo = mediaPlayerState.getPlaybackEntry();
        }
        boolean bl4 = mSearchEnabled;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        boolean bl10 = false;
        if (bl && bl3) {
            if (mediaCollector == null) {
                HeadunitBrowserPlaymodeState.resetSupportedFlags();
                return;
            }
            if (bl2 && mediaCollector == MediaCollector.EMPTY) {
                HeadunitBrowserPlaymodeState.resetSupportedFlags();
                return;
            }
            bl5 = true;
            boolean bl11 = !Util.isNullOrEmpty(objectArray);
            boolean bl12 = MediaBrowserHelper.isRootFolder((ListEntry[])objectArray) && MediaBrowserHelper.isRAWFolder((ListEntry[])objectArray);
            boolean bl13 = MediaBrowserHelper.isDBLRootFolder((ListEntry[])objectArray);
            boolean bl14 = MediaBrowserHelper.isDBLPlaylistsFolder((ListEntry[])objectArray);
            boolean bl15 = mediaCollector != null && mediaCollector.isCDDA();
            boolean bl16 = mediaCollector != null && mediaCollector.isDVDChanger();
            boolean bl17 = mediaCollector.hasPlaymodeSupport();
            if (mediaCollector.isMediaActive()) {
                if (bl17 && mediaPlaybackModes != null) {
                    if (!bl13 && !bl14) {
                        bl7 = bl11 && !bl4 && (mediaPlaybackModes.supportsRepeatFolder() || bl15 && mediaPlaybackModes.supportsRepeatMedia());
                        bl8 = !bl4 && (mediaPlaybackModes.supportsMixFolder() || mediaPlaybackModes.supportsMixMedia());
                        bl9 = !bl4 && mediaPlaybackModes.supportsRepeatFolder() && !bl15 || bl15 && bl16;
                    }
                    bl10 = mediaPlaybackModes.supportsRepeatFile();
                }
                bl6 = mediaCollector.hasPlaymodeSupportInBrowser() && (bl7 || bl8 || bl9);
            } else if (bl2) {
                if (bl17) {
                    if (bl11 && !bl13 && !bl14) {
                        bl7 = !bl4;
                        bl8 = !bl4 && !mediaCollector.isBT() && !mediaCollector.isIPod();
                        bl9 = !bl4 && !bl15 && !mediaCollector.isBT() && !mediaCollector.isIPod() || bl15 && bl16;
                    }
                    bl10 = true;
                }
                bl6 = !(!mediaCollector.hasPlaymodeSupportInBrowser() && (!bl12 || !mediaCollector.isMediaPlayable() && mediaCollector != MediaCollector.EMPTY) || !bl7 && !bl8 && !bl9);
            } else {
                bl7 = true;
                bl8 = false;
                bl9 = false;
                bl10 = false;
                bl6 = true;
            }
            DATA_POOL.valueChangedBoolean(3628, bl6);
            if (mediaBrowserState != null) {
                mediaBrowserState.setPlayModeBarVisible(bl6);
            }
            DATA_POOL.valueChangedBoolean(2782, bl7);
            DATA_POOL.valueChangedBoolean(45, bl8);
            DATA_POOL.valueChangedBoolean(50, bl9);
            DATA_POOL.valueChangedBoolean(2736, bl9);
            DATA_POOL.valueChangedBoolean(2783, bl10);
            DATA_POOL.valueChangedBoolean(861670400, mediaCollector.isFlagSet(2048) && MediaBrowserHelper.isAudioFile(entryInfo));
        } else if (!bl) {
            HeadunitBrowserPlaymodeState.resetSupportedFlags();
        }
        DATA_POOL.valueChangedBoolean(37, bl5);
    }

    private static void resetSupportedFlags() {
        DATA_POOL.valueChangedBoolean(2782, false);
        DATA_POOL.valueChangedBoolean(45, false);
        DATA_POOL.valueChangedBoolean(50, false);
        DATA_POOL.valueChangedBoolean(2736, false);
        DATA_POOL.valueChangedBoolean(2783, false);
        DATA_POOL.valueChangedBoolean(861670400, false);
    }

    public static void updateActivePlaymodes(MediaPlayerState mediaPlayerState, MediaBrowserState mediaBrowserState) {
        boolean bl = false;
        int n = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        if (mediaPlayerState != null) {
            bl = mediaPlayerState.involvesRepeat();
            if (bl) {
                n = mediaPlayerState.involvesRepeatFolder() ? 1 : 2;
            }
            bl2 = mediaPlayerState.involvesMix();
            bl3 = mediaPlayerState.isPlaySimilar();
            if (mediaBrowserState != null) {
                boolean bl6 = mediaBrowserState.isCurrentFolderPartOfPlaySelection(mediaPlayerState);
                bl4 = mediaPlayerState.involvesRepeat() && bl6;
                bl5 = mediaPlayerState.involvesMix() && bl6;
            }
        }
        DATA_POOL.valueChangedInteger(85, n);
        DATA_POOL.valueChangedBoolean(49, bl);
        DATA_POOL.valueChangedBoolean(44, bl2);
        DATA_POOL.valueChangedBoolean(46, bl3);
        DATA_POOL.valueChangedBoolean(95, bl4);
        DATA_POOL.valueChangedBoolean(94, bl5);
    }
}

