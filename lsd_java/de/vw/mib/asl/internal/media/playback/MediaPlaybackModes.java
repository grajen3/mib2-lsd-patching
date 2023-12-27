/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.PlaybackMode;

public final class MediaPlaybackModes {
    private final PlaybackMode[] mPlaybackModeList;
    private final PlayMode mDefaultMode;
    private final PlayMode mMixMode;
    private final PlayMode mRepeatMode;
    private final PlayMode mRepeatMixMode;
    private final PlayMode mRepeatFileMode;
    private final PlayMode mRepeatFileMixMode;

    public MediaPlaybackModes(PlaybackMode[] playbackModeArray, MediaPlayerState mediaPlayerState, boolean bl) {
        PlaybackMode playbackMode;
        this.mPlaybackModeList = playbackModeArray;
        PlaybackMode playbackMode2 = null;
        PlaybackMode playbackMode3 = null;
        PlaybackMode playbackMode4 = null;
        PlaybackMode playbackMode5 = null;
        PlaybackMode playbackMode6 = null;
        PlaybackMode playbackMode7 = null;
        PlaybackMode playbackMode8 = null;
        PlaybackMode playbackMode9 = null;
        PlaybackMode playbackMode10 = null;
        PlaybackMode playbackMode11 = null;
        PlaybackMode playbackMode12 = null;
        PlaybackMode playbackMode13 = null;
        PlaybackMode playbackMode14 = null;
        PlaybackMode playbackMode15 = null;
        PlaybackMode playbackMode16 = null;
        PlaybackMode playbackMode17 = null;
        if (playbackModeArray != null && playbackModeArray.length > 0) {
            for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
                boolean bl2;
                playbackMode = playbackModeArray[i2];
                boolean bl3 = playbackMode.scope == 6;
                boolean bl4 = playbackMode.scope == 3;
                boolean bl5 = playbackMode.scope == 2;
                boolean bl6 = playbackMode.scope == 1;
                boolean bl7 = Util.isBitSet(1, playbackMode.modeFlag);
                boolean bl8 = Util.isBitSet(2, playbackMode.modeFlag);
                boolean bl9 = !bl7 & !bl8 && bl3;
                boolean bl10 = !bl7 & bl8 && bl3;
                boolean bl11 = bl7 & !bl8 && bl3;
                boolean bl12 = bl7 & bl8 && bl3;
                boolean bl13 = !bl7 & !bl8 && bl4;
                boolean bl14 = !bl7 & bl8 && bl4;
                boolean bl15 = bl7 & !bl8 && bl4;
                boolean bl16 = bl7 & bl8 && bl4;
                boolean bl17 = !bl7 & !bl8 && bl5;
                boolean bl18 = !bl7 & bl8 && bl5;
                boolean bl19 = bl7 & !bl8 && bl5;
                boolean bl20 = bl7 & bl8 && bl5;
                boolean bl21 = !bl7 & !bl8 && bl6;
                boolean bl22 = !bl7 & bl8 && bl6;
                boolean bl23 = bl7 & !bl8 && bl6;
                boolean bl24 = bl2 = bl7 & bl8 && bl6;
                if (playbackMode2 == null && bl9) {
                    playbackMode2 = playbackMode;
                } else if (playbackMode3 == null && bl10) {
                    playbackMode3 = playbackMode;
                } else if (playbackMode4 == null && bl11) {
                    playbackMode4 = playbackMode;
                } else if (playbackMode5 == null && bl12) {
                    playbackMode5 = playbackMode;
                }
                if (playbackMode6 == null && bl13) {
                    playbackMode6 = playbackMode;
                } else if (playbackMode7 == null && bl14) {
                    playbackMode7 = playbackMode;
                } else if (playbackMode8 == null && bl15) {
                    playbackMode8 = playbackMode;
                } else if (playbackMode9 == null && bl16) {
                    playbackMode9 = playbackMode;
                }
                if (playbackMode10 == null && bl17) {
                    playbackMode10 = playbackMode;
                } else if (playbackMode11 == null && bl18) {
                    playbackMode11 = playbackMode;
                } else if (playbackMode12 == null && bl19) {
                    playbackMode12 = playbackMode;
                } else if (playbackMode13 == null && bl20) {
                    playbackMode13 = playbackMode;
                }
                if (playbackMode14 == null && bl21) {
                    playbackMode14 = playbackMode;
                    continue;
                }
                if (playbackMode15 == null && bl22) {
                    playbackMode15 = playbackMode;
                    continue;
                }
                if (playbackMode16 == null && bl23) {
                    playbackMode16 = playbackMode;
                    continue;
                }
                if (playbackMode17 != null || !bl2) continue;
                playbackMode17 = playbackMode;
            }
        }
        if (bl) {
            PlaybackMode playbackMode18 = this.prefer(playbackMode6, playbackMode2, playbackMode8, playbackMode4);
            playbackMode = this.prefer(playbackMode4, playbackMode8);
            this.mDefaultMode = new PlayMode(this, playbackMode18);
            this.mMixMode = new PlayMode(this, this.prefer(playbackMode3, playbackMode7, playbackMode5));
            this.mRepeatMode = playbackMode18 == playbackMode ? PlayMode.UNKNOWN : new PlayMode(this, playbackMode);
            this.mRepeatMixMode = new PlayMode(this, this.prefer(playbackMode5, playbackMode9));
            this.mRepeatFileMode = new PlayMode(this, this.prefer(playbackMode16, playbackMode4));
            this.mRepeatFileMixMode = new PlayMode(this, this.prefer(playbackMode17, playbackMode15, playbackMode4));
        } else {
            this.mDefaultMode = new PlayMode(this, this.prefer(playbackMode12, playbackMode8, playbackMode4));
            this.mMixMode = new PlayMode(this, this.prefer(playbackMode5, playbackMode3, playbackMode9, playbackMode7));
            this.mRepeatMode = playbackMode4 == playbackMode8 ? PlayMode.UNKNOWN : new PlayMode(this, this.prefer(playbackMode4, playbackMode8));
            this.mRepeatMixMode = PlayMode.UNKNOWN;
            this.mRepeatFileMode = new PlayMode(this, this.prefer(playbackMode16, playbackMode4));
            this.mRepeatFileMixMode = PlayMode.UNKNOWN;
        }
    }

    public PlayMode getPlayModeDefault() {
        return this.mDefaultMode;
    }

    public boolean isUsedForDefault(PlayMode playMode) {
        return this.mDefaultMode == playMode;
    }

    public boolean isUsedForRepeat(PlayMode playMode) {
        return this.mRepeatMode == playMode;
    }

    public boolean isUsedForRepeatFile(PlayMode playMode) {
        return this.mRepeatFileMode == playMode;
    }

    public boolean isUsedForMix(PlayMode playMode) {
        return this.mMixMode == playMode;
    }

    public boolean isUsedForRepeatFileMix(PlayMode playMode) {
        return this.mRepeatFileMixMode == playMode;
    }

    public boolean isUsedForRepeatMix(PlayMode playMode) {
        return this.mRepeatMixMode == playMode;
    }

    public PlayMode getPlayModeByASLConstant(int n) {
        switch (n) {
            case 2: {
                return this.mRepeatMode;
            }
            case 4: {
                return this.mRepeatFileMode;
            }
            case 1: {
                return this.mMixMode;
            }
        }
        return this.mDefaultMode;
    }

    public PlayMode getPlayModeByDSIConstant(int n, Selection selection) {
        if (this.mDefaultMode != PlayMode.UNKNOWN && this.mDefaultMode.getModeId() == n && (selection == null || selection.isDefault())) {
            return this.mDefaultMode;
        }
        if (this.mMixMode != PlayMode.UNKNOWN && this.mMixMode.getModeId() == n) {
            return this.mMixMode;
        }
        if (this.mRepeatMode != PlayMode.UNKNOWN && this.mRepeatMode.getModeId() == n) {
            return this.mRepeatMode;
        }
        if (this.mRepeatMixMode != PlayMode.UNKNOWN && this.mRepeatMixMode.getModeId() == n) {
            return this.mRepeatMixMode;
        }
        if (this.mRepeatFileMode != PlayMode.UNKNOWN && this.mRepeatFileMode.getModeId() == n) {
            return this.mRepeatFileMode;
        }
        if (this.mRepeatFileMixMode != PlayMode.UNKNOWN && this.mRepeatFileMixMode.getModeId() == n) {
            return this.mRepeatFileMixMode;
        }
        return PlayMode.UNKNOWN;
    }

    public PlayMode getPlayModeByDummyPlaymode(PlayMode playMode) {
        return this.getPlayModeByDummyPlaymode(playMode, null);
    }

    public PlayMode getPlayModeByDummyPlaymode(PlayMode playMode, Selection selection) {
        if (playMode == PlayMode.DUMMY_PLAY_DEFAULT) {
            if (selection != null && selection.getSelectionPath().length > 1 && this.mRepeatMode != PlayMode.UNKNOWN) {
                return this.mRepeatMode;
            }
            return this.mDefaultMode;
        }
        if (playMode == PlayMode.DUMMY_MIX) {
            return this.mMixMode;
        }
        if (playMode == PlayMode.DUMMY_REPEAT) {
            return this.mRepeatMode;
        }
        if (playMode == PlayMode.DUMMY_REPEAT_MIX) {
            return this.mRepeatMixMode;
        }
        if (playMode == PlayMode.DUMMY_REPEAT_FILE) {
            return this.mRepeatFileMode;
        }
        if (playMode == PlayMode.DUMMY_REPEAT_FILE_MIX) {
            return this.mRepeatFileMixMode;
        }
        return playMode;
    }

    public boolean supportsMixMedia() {
        return this.mMixMode != PlayMode.UNKNOWN;
    }

    public boolean supportsMixFolder() {
        return this.mMixMode != PlayMode.UNKNOWN && this.mMixMode.usesSelections();
    }

    public boolean supportsRepeatMedia() {
        return this.mRepeatMode != PlayMode.UNKNOWN;
    }

    public boolean supportsRepeatFolder() {
        return this.mRepeatMode != PlayMode.UNKNOWN && this.mRepeatMode.usesSelections();
    }

    public boolean supportsRepeatFile() {
        return this.mRepeatFileMode != PlayMode.UNKNOWN;
    }

    private PlayMode prefer(PlayMode playMode, PlayMode playMode2) {
        return playMode != null && playMode != PlayMode.UNKNOWN ? playMode : playMode2;
    }

    private PlaybackMode prefer(PlaybackMode playbackMode, PlaybackMode playbackMode2) {
        return playbackMode != null ? playbackMode : playbackMode2;
    }

    private PlaybackMode prefer(PlaybackMode playbackMode, PlaybackMode playbackMode2, PlaybackMode playbackMode3) {
        return this.prefer(playbackMode, this.prefer(playbackMode2, playbackMode3));
    }

    private PlaybackMode prefer(PlaybackMode playbackMode, PlaybackMode playbackMode2, PlaybackMode playbackMode3, PlaybackMode playbackMode4) {
        return this.prefer(playbackMode, this.prefer(playbackMode2, playbackMode3, playbackMode4));
    }

    public String toString() {
        String string = "";
        if (!Util.isNullOrEmpty(this.mPlaybackModeList)) {
            for (int i2 = 0; i2 < this.mPlaybackModeList.length; ++i2) {
                String string2 = MediaPlaybackModes.getPlaybackModeStr(this.mPlaybackModeList[i2]);
                int n = this.mPlaybackModeList[i2].modeID;
                if (n == this.mDefaultMode.getModeId()) {
                    string2 = new StringBuffer().append("Default=").append(string2).toString();
                }
                if (n == this.mMixMode.getModeId()) {
                    string2 = new StringBuffer().append("Mix=").append(string2).toString();
                }
                if (n == this.mRepeatMode.getModeId()) {
                    string2 = new StringBuffer().append("Repeat=").append(string2).toString();
                }
                if (n == this.mRepeatMixMode.getModeId()) {
                    string2 = new StringBuffer().append("RepeatMix=").append(string2).toString();
                }
                if (n == this.mRepeatFileMode.getModeId()) {
                    string2 = new StringBuffer().append("RepeatFile=").append(string2).toString();
                }
                if (n == this.mRepeatFileMixMode.getModeId()) {
                    string2 = new StringBuffer().append("RepeatFileMix=").append(string2).toString();
                }
                string = new StringBuffer().append(string).append(" | ").append(string2).toString();
            }
        }
        if (string.trim().length() == 0) {
            return "null";
        }
        return string.substring(3);
    }

    private static String getPlaybackModeStr(PlaybackMode playbackMode) {
        if (playbackMode != null) {
            String string = MediaPlaybackModes.getPlaybackModeScopeStr(playbackMode.scope);
            String string2 = MediaPlaybackModes.getPlaybackModeFlagsStr(playbackMode.modeFlag);
            return new StringBuffer().append("[").append(playbackMode.modeID).append(":").append(string).append("(").append(string2).append(")]").toString();
        }
        return "null";
    }

    private static String getPlaybackModeScopeStr(int n) {
        String string = "unknown";
        switch (n) {
            case 1: {
                string = "FILE";
                break;
            }
            case 6: {
                string = "SELECTION";
                break;
            }
            case 3: {
                string = "MEDIA";
                break;
            }
            case 2: {
                string = "DEVICE";
                break;
            }
        }
        return string;
    }

    private static String getPlaybackModeFlagsStr(int n) {
        String string = "";
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append(",R").toString();
        }
        if (Util.isBitSet(2, n)) {
            string = new StringBuffer().append(string).append(",M").toString();
        }
        if (string.trim().length() == 0) {
            return "none";
        }
        return string.substring(1);
    }

    public PlayMode toggleMix(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mMixMode;
            }
            case 1: {
                return this.mDefaultMode;
            }
            case 2: {
                return this.prefer(this.mRepeatMixMode, this.mMixMode);
            }
            case 3: {
                return this.mRepeatMode;
            }
            case 4: {
                return this.prefer(this.mRepeatFileMixMode, this.mMixMode);
            }
            case 5: {
                return this.mRepeatFileMode;
            }
        }
        return this.mMixMode;
    }

    public PlayMode addMix(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mMixMode;
            }
            case 1: {
                return this.mMixMode;
            }
            case 2: {
                return this.prefer(this.mRepeatMixMode, this.mMixMode);
            }
            case 3: {
                return this.mRepeatMixMode;
            }
            case 4: {
                return this.prefer(this.mRepeatFileMixMode, this.mMixMode);
            }
            case 5: {
                return this.mRepeatFileMixMode;
            }
        }
        return this.mMixMode;
    }

    public PlayMode removeMix(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mDefaultMode;
            }
            case 1: {
                return this.mDefaultMode;
            }
            case 2: {
                return this.mRepeatMode;
            }
            case 3: {
                return this.mRepeatMode;
            }
            case 4: {
                return this.mRepeatFileMode;
            }
            case 5: {
                return this.mRepeatFileMode;
            }
        }
        return playMode;
    }

    public PlayMode toggleRepeat(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mRepeatMode;
            }
            case 1: {
                return this.prefer(this.mRepeatMixMode, this.mRepeatMode);
            }
            case 2: {
                return this.mDefaultMode;
            }
            case 3: {
                return this.mMixMode;
            }
            case 4: {
                return this.mRepeatMode;
            }
            case 5: {
                return this.prefer(this.mRepeatMixMode, this.mRepeatMode);
            }
        }
        return this.mRepeatMode;
    }

    public PlayMode toggleRepeatFile(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mRepeatFileMode;
            }
            case 1: {
                return this.prefer(this.mRepeatFileMixMode, this.mRepeatFileMode);
            }
            case 2: {
                return this.mRepeatFileMode;
            }
            case 3: {
                return this.prefer(this.mRepeatFileMixMode, this.mRepeatFileMode);
            }
            case 4: {
                return this.mDefaultMode;
            }
            case 5: {
                return this.mMixMode;
            }
        }
        return this.mRepeatFileMode;
    }

    public PlayMode addRepeat(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mRepeatMode;
            }
            case 1: {
                return this.prefer(this.mRepeatMixMode, this.mRepeatMode);
            }
            case 2: {
                return this.mRepeatMode;
            }
            case 3: {
                return this.prefer(this.mRepeatMixMode, this.mRepeatMode);
            }
            case 4: {
                return this.mRepeatMode;
            }
            case 5: {
                return this.prefer(this.mRepeatMixMode, this.mRepeatMode);
            }
        }
        return this.mRepeatMode;
    }

    public PlayMode addRepeatFile(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mRepeatFileMode;
            }
            case 1: {
                return this.prefer(this.mRepeatFileMixMode, this.mRepeatFileMode);
            }
            case 2: {
                return this.mRepeatFileMode;
            }
            case 3: {
                return this.prefer(this.mRepeatFileMixMode, this.mRepeatFileMode);
            }
            case 4: {
                return this.mRepeatFileMode;
            }
            case 5: {
                return this.prefer(this.mRepeatFileMixMode, this.mRepeatFileMode);
            }
        }
        return this.mRepeatFileMode;
    }

    public PlayMode removeRepeat(PlayMode playMode) {
        switch (playMode.getAslPlaymodeID()) {
            case 0: {
                return this.mDefaultMode;
            }
            case 1: {
                return this.mMixMode;
            }
            case 2: {
                return this.mDefaultMode;
            }
            case 3: {
                return this.mMixMode;
            }
            case 4: {
                return this.mDefaultMode;
            }
            case 5: {
                return this.mMixMode;
            }
        }
        return this.mDefaultMode;
    }
}

