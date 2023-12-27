/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementData;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTimer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class AnnouncementStateTop
extends AbstractHsmState {
    private final AnnouncementTarget mTarget;
    private final AnnouncementData mAnnouncementData;

    AnnouncementStateTop(AnnouncementTarget announcementTarget, HsmState hsmState, AnnouncementData announcementData) {
        super(announcementTarget.getHsm(), "stateTop", hsmState);
        this.mTarget = announcementTarget;
        this.mAnnouncementData = announcementData;
    }

    private void abortIfFm(boolean bl) {
        if (!bl && this.mAnnouncementData.isFMTrafficType()) {
            this.mTarget.abortAndClosePopup();
        }
    }

    private void abortIfActive(boolean bl) {
        if (bl && !this.mAnnouncementData.isNothing()) {
            this.mTarget.abortAndClosePopup();
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.transIdle();
                break;
            }
            case 4000049: {
                if (ServiceManager.logger.isTraceEnabled(8192)) {
                    ServiceManager.logger.trace(8192).append("ASL_SOUND_ENTERTAINMENT_CONNECTION_CHANGED").log();
                }
            }
            case 0x400004D4: 
            case 1073743061: 
            case 0x400004DD: {
                if (this.mAnnouncementData.isNothing()) break;
                this.mTarget.abortAndClosePopup();
                break;
            }
            case 40652: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl && this.mAnnouncementData.isPTY31TypeFM()) {
                    this.mTarget.abortAndClosePopup();
                }
                this.mAnnouncementData.updateFMAlarmAnnouncements(bl);
                break;
            }
            case 40657: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl && this.mAnnouncementData.isDABOtherAnnouncement()) {
                    this.mTarget.abortAndClosePopup();
                }
                this.mAnnouncementData.updateDABOtherAnnouncements(bl);
                break;
            }
            case 40653: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl && this.mAnnouncementData.isPTY31TypeDAB()) {
                    this.mTarget.abortAndClosePopup();
                }
                this.mAnnouncementData.updateDABAlarmAnnouncements(bl);
                break;
            }
            case 40660: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl && this.mAnnouncementData.isDABTrafficType()) {
                    this.mTarget.abortAndClosePopup();
                }
                this.mAnnouncementData.updateDABTrafficAnnouncements(bl);
                break;
            }
            case 41803: {
                boolean bl = eventGeneric.getBoolean(0);
                this.abortIfFm(bl);
                this.mAnnouncementData.updateGlobalTrafficAnnouncements(bl);
                break;
            }
            case 41804: {
                boolean bl = eventGeneric.getBoolean(0);
                this.abortIfFm(bl);
                this.mAnnouncementData.updateRDSOption(bl);
                break;
            }
            case 40648: {
                boolean bl = eventGeneric.getBoolean(0);
                this.abortIfActive(bl);
                this.mAnnouncementData.setScanMode(bl);
                break;
            }
            case 41806: {
                boolean bl = eventGeneric.getBoolean(0);
                this.abortIfActive(bl);
                this.mAnnouncementData.setInitialAutostoreMode(bl);
                break;
            }
            case 41807: {
                boolean bl = eventGeneric.getBoolean(0);
                this.abortIfActive(bl);
                this.mAnnouncementData.setSetupTaVolumeMode(bl);
                break;
            }
            case 100005: {
                AnnouncementTimer announcementTimer = (AnnouncementTimer)eventGeneric.getObject(0);
                announcementTimer.timeout();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

