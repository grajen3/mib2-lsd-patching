/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTimer;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;

final class AnnouncementDamper
implements AnnouncementTimer {
    private static final int TIMEOUT;
    private final AnnouncementTarget mTarget;
    private final AnnouncementView mAnnouncementView;
    private boolean mBlocked;
    private int mCurrAvailability;
    private int mNextAvailability;

    AnnouncementDamper(AnnouncementTarget announcementTarget, AnnouncementView announcementView) {
        this.mTarget = announcementTarget;
        this.mAnnouncementView = announcementView;
        this.mBlocked = false;
        this.mNextAvailability = 2048;
        this.mCurrAvailability = 2048;
    }

    private void update() {
        this.mBlocked = true;
        this.mTarget.startTimer(this, 0);
        this.mCurrAvailability = this.mNextAvailability;
        this.mAnnouncementView.updateAvailability(this.mCurrAvailability);
    }

    void updateAvailability(int n) {
        this.mNextAvailability = n;
        if (!this.mBlocked) {
            this.update();
        }
    }

    @Override
    public void timeout() {
        this.mBlocked = false;
        if (this.mCurrAvailability != this.mNextAvailability) {
            this.update();
        }
    }
}

