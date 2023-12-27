/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.internal.radio.announcement.AnnouncementData;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class AnnouncementStateIdle
extends AbstractHsmState {
    private final AnnouncementTarget mTarget;
    private final AnnouncementData mAnnouncementData;

    AnnouncementStateIdle(AnnouncementTarget announcementTarget, HsmState hsmState, AnnouncementData announcementData) {
        super(announcementTarget.getHsm(), "stateIdle", hsmState);
        this.mTarget = announcementTarget;
        this.mAnnouncementData = announcementData;
    }

    private void transActiveWithGuard() {
        if (!this.mAnnouncementData.isNothing() && !this.mAnnouncementData.isAnnouncementSuppressed()) {
            this.mTarget.transActive();
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mAnnouncementData.clearHmi();
                break;
            }
            case 8: {
                this.mTarget.register();
                break;
            }
            case 1073743084: {
                int n = eventGeneric.getInt(0);
                this.mAnnouncementData.setAudioComponent(n);
                this.transActiveWithGuard();
                break;
            }
            case 41805: {
                boolean bl = eventGeneric.getBoolean(0);
                this.mAnnouncementData.setDabMuted(bl);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) {
                    this.mAnnouncementData.setNoAudioManagement(false);
                    this.transActiveWithGuard();
                    break;
                }
                if (n == 0) {
                    this.mAnnouncementData.setNoAudioManagement(true);
                    break;
                }
                if (n != 1) break;
                break;
            }
            case 100004: {
                int n = eventGeneric.getInt(0);
                this.mAnnouncementData.updateAnnouncementValue(n);
                if (this.mAnnouncementData.isNothing()) break;
                this.transActiveWithGuard();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

