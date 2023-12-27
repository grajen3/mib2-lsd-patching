/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.genericevents.AbstractTarget;

public final class RefreshTimer {
    private int mEventId;
    private long mTimeout;
    private AbstractTarget mTarget;
    private boolean mRefreshTimer = false;

    public RefreshTimer(AbstractTarget abstractTarget, int n, long l) {
        this.mEventId = n;
        this.mTimeout = l;
        this.mTarget = abstractTarget;
    }

    public void refresh() {
        if (!this.mRefreshTimer) {
            this.mRefreshTimer = true;
            this.mTarget.startTimer(this.mEventId, this.mTimeout, false);
        } else {
            this.mTarget.retriggerTimer(this.mEventId);
        }
    }

    public void refresh(long l) {
        if (this.mRefreshTimer) {
            this.mTarget.stopTimer(this.mEventId);
        }
        this.mRefreshTimer = true;
        this.mTarget.startTimer(this.mEventId, l, false);
    }

    public void refreshed() {
        this.mRefreshTimer = false;
    }

    public void stopTimer() {
        this.mTarget.stopTimer(this.mEventId);
        this.mRefreshTimer = false;
    }
}

