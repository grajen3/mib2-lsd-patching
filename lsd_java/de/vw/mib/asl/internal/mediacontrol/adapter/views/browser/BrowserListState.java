/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListState;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserListState$1;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserListState$2;
import de.vw.mib.asl.internal.mediacontrol.common.MediaControlTimer;

public class BrowserListState
implements MediaControlListenerListState {
    final MediaControlAPI mMediaControlAPI;
    private boolean mLockedByLoading = false;
    private int mModelListState = 0;
    private int mModelListStatePending = 0;
    private Runnable mShowLoadingRunnable = new BrowserListState$1(this);
    private static final int SHOW_LOADING_ANIMATION_TIMEOUT;
    private final MediaControlTimer SHOW_LOADING_TIMER = new MediaControlTimer(this.mShowLoadingRunnable, 1500, "show_loading_animation");
    private Runnable mUnlockLoadingRunnable = new BrowserListState$2(this);
    private static final int UNLOCK_LOADING_ANIMATION_TIMEOUT;
    private final MediaControlTimer UNLOCK_LOADING_TIMER = new MediaControlTimer(this.mUnlockLoadingRunnable, 500, "unlock_loading_animation");

    public BrowserListState(MediaControlAPI mediaControlAPI) {
        this.mMediaControlAPI = mediaControlAPI;
        mediaControlAPI.getBrowserService().addListStateListener(this);
    }

    @Override
    public void updateListState(int n) {
        this.setModelListState(Helper.getListState(n));
    }

    protected void showLoadingAnimation() {
        if (this.mModelListState == 1) {
            this.setModelListState(2);
            this.mModelListStatePending = this.mModelListState;
            this.mLockedByLoading = true;
            this.UNLOCK_LOADING_TIMER.start();
        }
    }

    protected void unlockLoadingAnimation() {
        this.mLockedByLoading = false;
        this.setModelListState(this.mModelListStatePending);
    }

    private void setModelListState(int n) {
        if (this.mLockedByLoading) {
            this.mModelListStatePending = n;
        } else if (this.mModelListState != n) {
            this.mModelListState = n;
            if (n == 1) {
                this.SHOW_LOADING_TIMER.start();
            }
            if (ServiceManager.logger.isTraceEnabled(8)) {
                ServiceManager.logger.trace(8, new StringBuffer().append("LIST STATE: ").append(this.getListStateStr(this.mModelListState)).toString());
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(-1021290752, this.mModelListState);
        }
    }

    private String getListStateStr(int n) {
        switch (n) {
            case 0: {
                return "browser_ready";
            }
            case 1: {
                return "preparing";
            }
            case 2: {
                return "loading";
            }
            case 3: {
                return "empty";
            }
        }
        return "unknown";
    }
}

