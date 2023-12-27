/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.radio.DSITunerAnnouncement;

final class AnnouncementTuner {
    private int mFilter = 0;
    private int mAnnouncement = 0;
    private boolean mPendingFilter = false;
    private boolean mPendingAbort = false;
    private DSITunerAnnouncement mDsiTunerAnnouncement = null;

    AnnouncementTuner() {
    }

    void setDsiTunerAnnouncement(DSITunerAnnouncement dSITunerAnnouncement) {
        this.mDsiTunerAnnouncement = dSITunerAnnouncement;
        if (this.mPendingFilter) {
            this.mPendingFilter = false;
            this.mDsiTunerAnnouncement.setFilter(this.mFilter);
        }
        if (this.mPendingAbort) {
            this.mPendingAbort = false;
            this.mDsiTunerAnnouncement.abort(this.mAnnouncement);
        }
    }

    void setFilter(int n) {
        if (this.mDsiTunerAnnouncement != null) {
            if (ServiceManager.logger.isTraceEnabled(8192)) {
                ServiceManager.logger.trace(8192).append("<AnnouncementTuner>setFilter:").append(n).log();
            }
            this.mDsiTunerAnnouncement.setFilter(n);
        } else {
            this.mFilter = n;
            this.mPendingFilter = true;
        }
    }

    void abort(int n) {
        if (this.mDsiTunerAnnouncement != null) {
            this.mDsiTunerAnnouncement.abort(n);
        } else {
            this.mAnnouncement = n;
            this.mPendingAbort = true;
        }
    }
}

