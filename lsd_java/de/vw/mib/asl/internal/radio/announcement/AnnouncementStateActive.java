/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.internal.radio.announcement.AnnouncementAudio;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementData;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class AnnouncementStateActive
extends AbstractHsmState {
    private final AnnouncementTarget mTarget;
    private final AnnouncementAudio mAnnouncementAudio;
    private final AnnouncementData mAnnouncementData;
    private boolean mDabOtherAnnouncementVolumeLockActive = false;
    private boolean mDabTrafficAnnouncementtVolumeLockActive = false;
    private boolean mDabAlarmAnnouncementtVolumeLockActive = false;

    AnnouncementStateActive(AnnouncementTarget announcementTarget, HsmState hsmState, AnnouncementAudio announcementAudio, AnnouncementData announcementData) {
        super(announcementTarget.getHsm(), "stateRunning", hsmState);
        this.mTarget = announcementTarget;
        this.mAnnouncementAudio = announcementAudio;
        this.mAnnouncementData = announcementData;
    }

    private void abortDueAudioLost() {
        this.mAnnouncementAudio.reset();
        this.mTarget.abortAndClosePopup();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mAnnouncementData.notifyStatus();
                break;
            }
            case 4: {
                AudioConnectionUtils.requestVolumeLockForDabAnnouncementWithConnection(this.mDabAlarmAnnouncementtVolumeLockActive, this.mDabTrafficAnnouncementtVolumeLockActive, this.mDabOtherAnnouncementVolumeLockActive, false, this.mTarget);
                this.mDabAlarmAnnouncementtVolumeLockActive = false;
                this.mDabTrafficAnnouncementtVolumeLockActive = false;
                this.mDabOtherAnnouncementVolumeLockActive = false;
                this.mAnnouncementData.notifyServiceState(0);
                this.mAnnouncementAudio.release();
                break;
            }
            case 100001: {
                int n;
                int n2 = eventGeneric.getInt(1670643712);
                if (!this.mAnnouncementAudio.isValidResponse(n2) || (n = eventGeneric.getResult()) == 0) break;
                this.abortDueAudioLost();
                break;
            }
            case 1073743084: {
                int n = eventGeneric.getInt(0);
                this.mAnnouncementData.setAudioComponent(n);
                if (!this.mAnnouncementData.isAnnouncementSuppressed()) break;
                this.mTarget.transIdle();
                break;
            }
            case 41805: {
                boolean bl = eventGeneric.getBoolean(0);
                this.mAnnouncementData.setDabMuted(bl);
                if (!this.mAnnouncementData.isDABActive()) break;
                if (this.mAnnouncementData.getDabMuted()) {
                    this.mDabAlarmAnnouncementtVolumeLockActive = this.mAnnouncementData.isPTY31TypeDAB();
                    this.mDabTrafficAnnouncementtVolumeLockActive = this.mAnnouncementData.isDABTrafficType();
                    this.mDabOtherAnnouncementVolumeLockActive = this.mAnnouncementData.isDABOtherAnnouncement();
                    AudioConnectionUtils.requestVolumeLockForDabAnnouncementWithConnection(this.mDabAlarmAnnouncementtVolumeLockActive, this.mDabTrafficAnnouncementtVolumeLockActive, this.mDabOtherAnnouncementVolumeLockActive, true, this.mTarget);
                    this.mAnnouncementData.notifyServiceState(1);
                    break;
                }
                AudioConnectionUtils.requestVolumeLockForDabAnnouncementWithConnection(this.mDabAlarmAnnouncementtVolumeLockActive, this.mDabTrafficAnnouncementtVolumeLockActive, this.mDabOtherAnnouncementVolumeLockActive, false, this.mTarget);
                this.mDabAlarmAnnouncementtVolumeLockActive = false;
                this.mDabTrafficAnnouncementtVolumeLockActive = false;
                this.mDabOtherAnnouncementVolumeLockActive = false;
                this.mAnnouncementData.notifyServiceState(0);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) break;
                if (n == 0) {
                    this.mAnnouncementData.setNoAudioManagement(true);
                    this.abortDueAudioLost();
                    break;
                }
                if (n != 1) break;
                break;
            }
            case 100004: {
                int n = eventGeneric.getInt(0);
                this.mAnnouncementData.updateAnnouncementValue(n);
                if (this.mAnnouncementData.isNothing()) {
                    this.mTarget.transIdle();
                    break;
                }
                this.mAnnouncementData.notifyStatus();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

