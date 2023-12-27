/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiAnnouncement;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmFixedStationListPersistable;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementAudio;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;

public final class AnnouncementView {
    private final AnnouncementAudio mAnnouncementAudio;
    private String mStationName;
    private int mStationFrequency;
    private static boolean mActiveTA;
    private boolean mActiveDAB;
    private boolean mActivePTY;
    private int mDabType;

    AnnouncementView(AnnouncementAudio announcementAudio) {
        this.mAnnouncementAudio = announcementAudio;
        this.mStationName = "";
        this.mStationFrequency = 0;
        mActiveTA = false;
        this.mActiveDAB = false;
        this.mActivePTY = false;
        this.mDabType = 0;
    }

    void updateStationIdentification(String string, int n, int n2) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementPresenter>updateStationIdentification:").append(string).append(",").append(n).append(",").append(n2).log();
        }
        this.mStationFrequency = n2;
        this.mStationName = "";
        AmFmFixedStationListPersistable amFmFixedStationListPersistable = RadioData.getAmfmDatabase().getFixedStationList();
        String string2 = amFmFixedStationListPersistable.getName(n, n2);
        if (string2 != null && string2.length() > 0) {
            this.mStationName = string2;
        } else if (string != null && string.trim().length() > 0) {
            this.mStationName = string;
        }
        if (mActiveTA) {
            GuiApiAnnouncement.updateFmTAStationName(this.mStationName);
            GuiApiAnnouncement.updateFmTAFrequency(this.mStationFrequency);
            RadioHASUpdater.updateTAStatus(mActiveTA, this.mStationFrequency, this.mStationName);
        }
        if (this.mActivePTY) {
            GuiApiAnnouncement.updatePtyStationName(this.mStationName);
            GuiApiAnnouncement.updatePtyFrequency(this.mStationFrequency);
            RadioHASUpdater.updateTAStatus(this.mActivePTY, this.mStationFrequency, this.mStationName);
        }
        if (this.mActiveDAB) {
            this.mStationName = this.mStationName.trim();
            GuiApiAnnouncement.updateDabAnnouncementStationName(this.mStationName);
            RadioHASUpdater.updateTAStatus(this.mActiveDAB, -1, this.mStationName);
        }
    }

    private void updateView(boolean bl, boolean bl2, boolean bl3, int n) {
        if (mActiveTA != bl) {
            mActiveTA = bl;
            GuiApiAnnouncement.updateTaActive(bl);
            if (bl) {
                GuiApiAnnouncement.updateFmTAStationName(this.mStationName);
                GuiApiAnnouncement.updateTASourceAsFm();
                if (n == 8192) {
                    this.mAnnouncementAudio.request(32);
                } else {
                    GuiApiAnnouncement.updateFmTAFrequency(this.mStationFrequency);
                    this.mAnnouncementAudio.request(31);
                }
            }
            RadioHASUpdater.updateTAStatus(bl, this.mStationFrequency, this.mStationName);
        }
        if (this.mActivePTY != bl3) {
            this.mActivePTY = bl3;
            GuiApiAnnouncement.updatePtyAnnouncementActive(bl3);
            if (bl3) {
                GuiApiAnnouncement.updatePtyStationName(this.mStationName);
                GuiApiAnnouncement.updatePtyFrequency(this.mStationFrequency);
                GuiApiAnnouncement.updateTASourceAsFm();
                this.mAnnouncementAudio.request(33);
            }
            RadioHASUpdater.updateTAStatus(bl3, this.mStationFrequency, this.mStationName);
        }
        if (this.mActiveDAB != bl2 || this.mDabType != n) {
            this.mActiveDAB = bl2;
            this.mDabType = n;
            GuiApiAnnouncement.updateDabAnnouncementActive(bl2);
            if (bl2) {
                GuiApiAnnouncement.updateDabAnnouncementStationName(this.mStationName);
                GuiApiAnnouncement.updateDABAnnouncementType(n);
                if (n != 0) {
                    this.mAnnouncementAudio.request(32);
                } else {
                    this.mAnnouncementAudio.request(34);
                }
            }
            RadioHASUpdater.updateTAStatus(bl2, -1, this.mStationName);
        }
    }

    void clear() {
        this.updateView(false, false, false, 0);
    }

    public static boolean getTaActive() {
        return mActiveTA;
    }

    void updateStatus(int n) {
        if (ServiceManager.logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementPresenter>updateStatus:").append(n).log();
        }
        if ((n & 2) != 0) {
            this.updateView(false, false, true, 0);
        } else if ((n & 8) != 0) {
            this.updateView(false, true, false, 0);
        } else if ((n & 5) != 0) {
            this.updateView(true, false, false, 0);
        } else if ((n & 0x2000) != 0) {
            this.updateView(true, false, false, 8192);
        } else if ((n & 0x30) != 0) {
            this.updateView(false, true, false, 1);
        } else if ((n & 0x4000) != 0) {
            this.updateView(false, true, false, 11);
        } else if ((n & 0x800000) != 0) {
            this.updateView(false, true, false, 12);
        } else if ((n & 0x100) != 0) {
            this.updateView(false, true, false, 13);
        } else if ((n & 0x200) != 0) {
            this.updateView(false, true, false, 14);
        } else if ((n & 0x400) != 0) {
            this.updateView(false, true, false, 15);
        } else if ((n & 0x100) != 0) {
            this.updateView(false, true, false, 5);
        } else if ((n & 0x200) != 0) {
            this.updateView(false, true, false, 6);
        } else if ((n & 0x2000) != 0) {
            this.updateView(false, true, false, 10);
        } else if ((n & 0x80) != 0) {
            this.updateView(false, true, false, 4);
        } else if ((n & 0x800) != 0) {
            this.updateView(false, true, false, 8);
        } else if ((n & 0x400) != 0) {
            this.updateView(false, true, false, 7);
        } else if ((n & 0x1000) != 0) {
            this.updateView(false, true, false, 9);
        } else if ((n & 0x40) != 0) {
            this.updateView(false, true, false, 3);
        } else {
            this.updateView(false, false, false, 0);
        }
    }

    void updateAvailability(int n) {
        if ((n & 0x35) != 0) {
            RadioData.mGlobalTAAvailability = true;
            GuiApiTunerCommon.updateTpState(0);
        } else {
            RadioData.mGlobalTAAvailability = false;
            GuiApiTunerCommon.updateTpState(1);
        }
    }

    void updateDabAnnouncementSyncState(int n) {
        GuiApiAnnouncement.updateDabAnnouncementSyncState(n);
    }
}

