/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.internal.media.playback.PlayMode;

public final class HASUtil {
    private HASUtil() {
    }

    public static PlayMode convertPlaybackModeHAS2DummyPlayMode(int n, boolean bl) {
        switch (n) {
            case 0: {
                return bl ? PlayMode.DUMMY_MIX : PlayMode.DUMMY_PLAY_DEFAULT;
            }
            case 1: {
                return PlayMode.DUMMY_REPEAT;
            }
            case 2: {
                return PlayMode.DUMMY_REPEAT_FILE;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int getRepeatModeHAS(boolean bl, boolean bl2) {
        if (bl) {
            return 2;
        }
        if (bl2) {
            return 1;
        }
        return 0;
    }

    public static int convertASLDeviceId2HAS(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 8: {
                return 8;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 13: {
                return 13;
            }
        }
        return 0;
    }

    public static int convertHASSourceIdASL(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 8: {
                return 8;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 13: {
                return 13;
            }
        }
        return 0;
    }
}

