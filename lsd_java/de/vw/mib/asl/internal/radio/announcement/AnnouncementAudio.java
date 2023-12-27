/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;

final class AnnouncementAudio {
    private final AnnouncementTarget mTarget;
    private int mAudioConnection;
    private int mSequenceNumber;

    AnnouncementAudio(AnnouncementTarget announcementTarget) {
        this.mTarget = announcementTarget;
        this.mAudioConnection = 0;
        this.mSequenceNumber = 0;
    }

    void request(int n) {
        if (this.mAudioConnection != 0) {
            AudioConnectionUtils.releaseLastAnnouncementAudioConnection(this.mTarget);
        }
        this.mAudioConnection = n;
        AudioConnectionUtils.requestAnnouncementAudioConnection(n, this.mTarget, -1585053440, 1670643712, ++this.mSequenceNumber);
    }

    void release() {
        if (this.mAudioConnection != 0) {
            this.mAudioConnection = 0;
            AudioConnectionUtils.releaseLastAnnouncementAudioConnection(this.mTarget);
            if (HsmTarget.mIsTASliderActive) {
                this.mTarget.triggerObserver(453590272, null);
            }
        }
    }

    void reset() {
        if (this.mAudioConnection != 0) {
            this.mAudioConnection = 0;
        }
    }

    boolean isValidResponse(int n) {
        return this.mSequenceNumber == n;
    }
}

