/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.internal.radio.announcement.AnnouncementDamper;

final class AnnouncementFreezer {
    private final AnnouncementDamper mAnnouncementDamper;
    private boolean mFreezed;
    private int mCurrAvailability;
    private int mNextAvailability;

    AnnouncementFreezer(AnnouncementDamper announcementDamper) {
        this.mAnnouncementDamper = announcementDamper;
        this.mFreezed = false;
        this.mNextAvailability = 2048;
        this.mCurrAvailability = 2048;
    }

    void updateAvailability(int n) {
        if (!this.mFreezed) {
            this.mCurrAvailability = this.mNextAvailability = n;
            this.mAnnouncementDamper.updateAvailability(n);
        } else {
            this.mNextAvailability = n;
        }
    }

    void freeze() {
        this.mFreezed = true;
    }

    void reheat() {
        this.mFreezed = false;
        if (this.mCurrAvailability != this.mNextAvailability) {
            this.mAnnouncementDamper.updateAvailability(this.mCurrAvailability);
            this.mCurrAvailability = this.mNextAvailability;
            this.mAnnouncementDamper.updateAvailability(this.mCurrAvailability);
        }
    }
}

