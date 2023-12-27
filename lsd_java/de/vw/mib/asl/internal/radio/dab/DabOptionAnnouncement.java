/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.genericevents.EventGeneric;

public final class DabOptionAnnouncement {
    private boolean mAlarmActivated = false;

    public void reset() {
        this.setOtherAnnouncement(true);
        this.setTrafficAnnouncement(true);
    }

    public void notifyHMIAboutOtherAnnouncement() {
        GuiApiDab.setOtherAnnouncementsActivated(this.getOtherAnnouncement());
    }

    public void notifyHMIAboutTrafficAnnouncement() {
        GuiApiDab.setTrafficAnnouncementsActivated(this.getTrafficAnnouncement());
    }

    public void notifyFriendsAboutOtherAnnouncement() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.getOtherAnnouncement());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-778174464, eventGeneric);
        if (!this.mAlarmActivated) {
            this.notifyAboutAlarmAnnouncement();
        }
    }

    public void notifyFriendsAboutTrafficAnnouncement() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.getTrafficAnnouncement());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-727842816, eventGeneric);
    }

    public void setAlarmActivatd(boolean bl) {
        this.mAlarmActivated = bl;
        this.notifyAboutAlarmAnnouncement();
    }

    public void setOtherAnnouncement(boolean bl) {
        RadioData.getDabDatabase().mPersistable.setOtherAnnouncementOption(bl);
        this.log();
        this.notifyHMIAboutOtherAnnouncement();
        this.notifyFriendsAboutOtherAnnouncement();
    }

    public void setTrafficAnnouncement(boolean bl) {
        RadioData.getDabDatabase().mPersistable.setTrafficAnnouncementOption(bl);
        this.log();
        this.notifyHMIAboutTrafficAnnouncement();
        this.notifyFriendsAboutTrafficAnnouncement();
    }

    public boolean getAlarmOptionActivated() {
        return this.mAlarmActivated;
    }

    public boolean getOtherAnnouncement() {
        return RadioData.getDabDatabase().mPersistable.getOtherAnnouncementOption();
    }

    public boolean getTrafficAnnouncement() {
        return RadioData.getDabDatabase().mPersistable.getTrafficAnnouncementOption();
    }

    private void log() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256, this.toString());
        }
    }

    public String toString() {
        return new StringBuffer().append("DAB Announcement: Other = ").append(this.getOtherAnnouncement()).append(" Traffic = ").append(this.getTrafficAnnouncement()).toString();
    }

    private void notifyAboutAlarmAnnouncement() {
        boolean bl = this.mAlarmActivated || this.getOtherAnnouncement();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-845283328, eventGeneric);
    }
}

