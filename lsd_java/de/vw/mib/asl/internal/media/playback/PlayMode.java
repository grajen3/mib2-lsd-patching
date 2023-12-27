/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.PlaybackMode;

public final class PlayMode {
    private final MediaPlaybackModes mParentList;
    private final PlaybackMode mDsiObject;
    static final int PLAYBACKMODE_DUMMY_EXTERNAL;
    static final int PLAYBACKMODE_UNKNOWN;
    static final int PLAYBACKMODE_PLAY_DEFAULT;
    static final int PLAYBACKMODE_MIX_FOLDER;
    static final int PLAYBACKMODE_REPEAT_FOLDER;
    static final int PLAYBACKMODE_REPEAT_FOLDER_MIX;
    static final int PLAYBACKMODE_REPEAT_FILE;
    static final int PLAYBACKMODE_REPEAT_FILE_MIX;
    private final int mGivenPlayMode;
    public static final PlayMode DUMMY_EXTERNAL;
    public static final PlayMode UNKNOWN;
    public static final PlayMode DUMMY_PLAY_DEFAULT;
    public static final PlayMode DUMMY_MIX;
    public static final PlayMode DUMMY_REPEAT;
    public static final PlayMode DUMMY_REPEAT_MIX;
    public static final PlayMode DUMMY_REPEAT_FILE;
    public static final PlayMode DUMMY_REPEAT_FILE_MIX;

    public PlayMode getDummy() {
        switch (this.getAslPlaymodeID()) {
            case 0: {
                return DUMMY_PLAY_DEFAULT;
            }
            case 1: {
                return DUMMY_MIX;
            }
            case 2: {
                return DUMMY_REPEAT;
            }
            case 3: {
                return DUMMY_REPEAT;
            }
            case 4: {
                return DUMMY_REPEAT_FILE;
            }
            case 5: {
                return DUMMY_REPEAT_MIX;
            }
        }
        return UNKNOWN;
    }

    public PlayMode(MediaPlaybackModes mediaPlaybackModes, PlaybackMode playbackMode) {
        this.mGivenPlayMode = -2;
        this.mParentList = mediaPlaybackModes;
        this.mDsiObject = playbackMode;
    }

    private PlayMode(int n) {
        this.mGivenPlayMode = n;
        this.mParentList = null;
        this.mDsiObject = null;
    }

    public int getModeId() {
        return this.mDsiObject != null ? this.mDsiObject.getModeID() : -1;
    }

    private int getScope() {
        return this.mDsiObject != null ? this.mDsiObject.getScope() : -1;
    }

    public boolean isMediumSelection() {
        return this.getScope() == 3;
    }

    public boolean usesSelections() {
        return this.getScope() == 6;
    }

    protected boolean isPlayDefault() {
        return this.getAslPlaymodeID() == 0;
    }

    public boolean isMix() {
        return this.getAslPlaymodeID() == 1;
    }

    public boolean isRepeatFolder() {
        return this.getAslPlaymodeID() == 2;
    }

    protected boolean isRepeatFile() {
        return this.getAslPlaymodeID() == 4;
    }

    protected boolean isRepeatFolderMix() {
        return this.getAslPlaymodeID() == 3;
    }

    protected boolean isRepeatFileMix() {
        return this.getAslPlaymodeID() == 5;
    }

    public int getAslPlaymodeID() {
        if (this.mParentList == null) {
            return this.mGivenPlayMode;
        }
        int n = -1;
        if (this.mParentList.isUsedForDefault(this)) {
            n = 0;
        } else if (this.mParentList.isUsedForMix(this)) {
            n = 1;
        } else if (this.mParentList.isUsedForRepeat(this)) {
            n = 2;
        } else if (this.mParentList.isUsedForRepeatMix(this)) {
            n = 3;
        } else if (this.mParentList.isUsedForRepeatFile(this)) {
            n = 4;
        } else if (this.mParentList.isUsedForRepeatFileMix(this)) {
            n = 5;
        } else if (DUMMY_EXTERNAL == this) {
            n = 128;
        }
        return n;
    }

    public String toString() {
        return new StringBuffer().append(PlayMode.getPlaybackModeStr(this.getAslPlaymodeID())).append("=").append(PlayMode.getPlaybackModeStr(this.mDsiObject)).toString();
    }

    protected static String getPlaybackModeStr(PlaybackMode playbackMode) {
        if (playbackMode != null) {
            String string = PlayMode.getPlaybackModeScopeStr(playbackMode.scope);
            String string2 = PlayMode.getPlaybackModeFlagsStr(playbackMode.modeFlag);
            return new StringBuffer().append("[").append(playbackMode.modeID).append(":").append(string).append("(").append(string2).append(")]").toString();
        }
        return "null";
    }

    private static String getPlaybackModeStr(int n) {
        String string = "null";
        switch (n) {
            case -1: {
                string = "UNKNOWN";
                break;
            }
            case 0: {
                string = "PLAY_DEFAULT";
                break;
            }
            case 1: {
                string = "MIX_FOLDER";
                break;
            }
            case 2: {
                string = "REPEAT_FOLDER";
                break;
            }
            case 3: {
                string = "REPEAT_FOLDER_MIX";
                break;
            }
            case 5: {
                string = "REPEAT_FILE_MIX";
                break;
            }
        }
        return string;
    }

    protected static String getPlaybackModeScopeStr(int n) {
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

    protected static String getPlaybackModeFlagsStr(int n) {
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

    static {
        DUMMY_EXTERNAL = new PlayMode(-1);
        UNKNOWN = new PlayMode(-1);
        DUMMY_PLAY_DEFAULT = new PlayMode(0);
        DUMMY_MIX = new PlayMode(1);
        DUMMY_REPEAT = new PlayMode(2);
        DUMMY_REPEAT_MIX = new PlayMode(3);
        DUMMY_REPEAT_FILE = new PlayMode(4);
        DUMMY_REPEAT_FILE_MIX = new PlayMode(5);
    }
}

