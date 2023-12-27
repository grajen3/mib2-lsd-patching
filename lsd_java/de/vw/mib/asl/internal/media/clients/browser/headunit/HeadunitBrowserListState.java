/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserListState$1;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserListState$2;
import de.vw.mib.asl.internal.media.common.MediaTimer;

public class HeadunitBrowserListState {
    private static boolean mLockedByLoading = false;
    private static int mModelListState = 0;
    private static int mModelListStatePending = 0;
    private static Runnable mShowLoadingRunnable = new HeadunitBrowserListState$1();
    private static final int SHOW_LOADING_ANIMATION_TIMEOUT;
    private static final MediaTimer SHOW_LOADING_TIMER;
    private static Runnable mUnlockLoadingRunnable;
    private static final int UNLOCK_LOADING_ANIMATION_TIMEOUT;
    private static final MediaTimer UNLOCK_LOADING_TIMER;

    private static void reset() {
        mLockedByLoading = false;
        mModelListStatePending = 0;
        HeadunitBrowserListState.setModelListState(0, false);
    }

    public static void update(int n, int n2, int n3) {
        block0 : switch (n) {
            case -1: {
                HeadunitBrowserListState.reset();
                HeadunitBrowserListState.setModelListState(4, true);
                break;
            }
            case 0: {
                HeadunitBrowserListState.setModelListState(4, true);
                break;
            }
            case 1: {
                HeadunitBrowserListState.setModelListState(3, true);
                break;
            }
            case 2: {
                switch (n2) {
                    case -1: {
                        HeadunitBrowserListState.reset();
                        break block0;
                    }
                    case 0: {
                        HeadunitBrowserListState.setModelListState(4, true);
                        break block0;
                    }
                    case 2: {
                        HeadunitBrowserListState.setModelListState(0, true);
                        break block0;
                    }
                    case 1: {
                        HeadunitBrowserListState.setModelListState(2, true);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private static void setModelListState(int n, boolean bl) {
        if (mLockedByLoading) {
            mModelListStatePending = n;
        } else if (mModelListState != n) {
            mModelListState = n;
            if (bl && n == 4) {
                SHOW_LOADING_TIMER.start();
            }
            if (ServiceManager.logger.isTraceEnabled(32)) {
                ServiceManager.logger.trace(32, new StringBuffer().append("LIST STATE: ").append(HeadunitBrowserListState.getListStateStr(mModelListState)).toString());
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(82, mModelListState);
        }
    }

    protected static void showLoadingAnimation() {
        if (mModelListState == 4) {
            HeadunitBrowserListState.setModelListState(1, true);
            mModelListStatePending = mModelListState;
            mLockedByLoading = true;
            UNLOCK_LOADING_TIMER.start();
        }
    }

    protected static void unlockLoadingAnimation() {
        mLockedByLoading = false;
        HeadunitBrowserListState.setModelListState(mModelListStatePending, true);
    }

    private static String getListStateStr(int n) {
        switch (n) {
            case 0: {
                return "browser_ready";
            }
            case 1: {
                return "loading";
            }
            case 2: {
                return "empty";
            }
            case 3: {
                return "not_available";
            }
            case 4: {
                return "preparing";
            }
        }
        return "unknown";
    }

    static {
        SHOW_LOADING_TIMER = new MediaTimer(mShowLoadingRunnable, 1500, "show_loading_animation");
        mUnlockLoadingRunnable = new HeadunitBrowserListState$2();
        UNLOCK_LOADING_TIMER = new MediaTimer(mUnlockLoadingRunnable, 500, "unlock_loading_animation");
    }
}

