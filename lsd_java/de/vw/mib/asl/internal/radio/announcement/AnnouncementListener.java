/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementData;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTarget;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.radio.DSITunerAnnouncementListener;

final class AnnouncementListener
implements DSITunerAnnouncementListener {
    private final AnnouncementTarget mTarget;

    AnnouncementListener(AnnouncementTarget announcementTarget) {
        this.mTarget = announcementTarget;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateAvailability(int n, int n2) {
        AnnouncementData announcementData = this.mTarget.getmAnnouncementData();
        if (null != announcementData) {
            announcementData.updateAvailability(n);
        }
    }

    @Override
    public void updateFilter(int n, int n2) {
    }

    @Override
    public void updateStationName(String string, int n, long l, int n2) {
        AnnouncementView announcementView = this.mTarget.getAnnouncementView();
        if (null != announcementView) {
            announcementView.updateStationIdentification(string.trim(), n, (int)l);
        } else {
            ServiceManager.logger.error(8192).append("AnnouncementListener - updateStationName() - null == announcementView").log();
        }
    }

    @Override
    public void updateStatus(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.mTarget.triggerMe(eventGeneric, -1534721792);
    }
}

