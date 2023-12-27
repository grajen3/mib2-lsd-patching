/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState$1;

public final class CurrentAudioSourceState {
    private static int mAudioSourceState = 0;
    private static final int LOADING_TO_ERROR_TIMEOUT;
    private static Runnable mShowErrorRunnable;
    private static MediaTimer mShowErrorTimer;
    private static boolean ignoreError;

    private CurrentAudioSourceState() {
    }

    public static int get() {
        return mAudioSourceState;
    }

    public static void set(int n) {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("CurrentAudioSourceState: ").append(CurrentAudioSourceState.getAudioSourceStateStr(n)).append('(').append(n).append(')').log();
        }
        if (mAudioSourceState == 6 && n == 5) {
            n = mAudioSourceState;
            ServiceManager.logger.trace(1024, "Suppressing change from C6_WAITING to C5_DISCONNECTED, waiting for timer");
        }
        mAudioSourceState = n;
        CurrentAudioSourceState.resubmit();
    }

    public static void resubmit() {
        if (!ignoreError || mAudioSourceState != 3) {
            ServiceManager.aslPropertyManager.valueChangedInteger(9, mAudioSourceState);
        }
    }

    public static int audioSourceStateFromMediumState(int n) {
        switch (n) {
            case 0: 
            case 12: {
                return 0;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 7;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 7;
            }
            case 6: {
                return 7;
            }
            case 8: {
                return 3;
            }
            case 9: {
                return 7;
            }
            case 10: {
                return 7;
            }
            case 11: {
                return 5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("unknown errorType ").append(n).toString());
    }

    private static String getAudioSourceStateStr(int n) {
        switch (n) {
            case 0: {
                return "CurrentAudioSourceState_ok";
            }
            case 1: {
                return "CurrentAudioSourceState_loading";
            }
            case 2: {
                return "CurrentAudioSourceState_no_files";
            }
            case 3: {
                return "CurrentAudioSourceState_error";
            }
            case 4: {
                return "CurrentAudioSourceState_loading_title";
            }
            case 5: {
                return "CurrentAudioSourceState_not_connected";
            }
            case 6: {
                return "CurrentAudioSourceState_waiting_for_media";
            }
            case 7: {
                return "CurrentAudioSourceState_error_not_supported";
            }
        }
        return "unknown";
    }

    public static void setLoading() {
        CurrentAudioSourceState.set(1);
        mShowErrorTimer.start(1625948160);
    }

    public static void setWaitingForMedia() {
        if (mAudioSourceState == 5 || mAudioSourceState == 3) {
            CurrentAudioSourceState.set(6);
            mShowErrorTimer.start(IMediaConstants.MEDIALIAST_START_UP_TIMER);
        }
    }

    public static void setIgnoreError(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("CurrentAudioSourceState.setIgnoreError( ").append(bl).append(" )").log();
        }
        ignoreError = bl;
    }

    static /* synthetic */ int access$000() {
        return mAudioSourceState;
    }

    static /* synthetic */ int access$002(int n) {
        mAudioSourceState = n;
        return mAudioSourceState;
    }

    static {
        mShowErrorRunnable = new CurrentAudioSourceState$1();
        mShowErrorTimer = new MediaTimer(mShowErrorRunnable, 1625948160, "show_audio_source_state_error");
    }
}

