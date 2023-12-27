/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.emergency;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementListener;
import de.vw.mib.asl.internal.system.emergency.EmergencyAnnouncementServiceImpl;

class EmergencyAnnouncementServiceImpl$1
implements Runnable {
    private final /* synthetic */ boolean val$isEaInProgress;
    private final /* synthetic */ EmergencyAnnouncementListener val$listener;
    private final /* synthetic */ EmergencyAnnouncementServiceImpl this$0;

    EmergencyAnnouncementServiceImpl$1(EmergencyAnnouncementServiceImpl emergencyAnnouncementServiceImpl, boolean bl, EmergencyAnnouncementListener emergencyAnnouncementListener) {
        this.this$0 = emergencyAnnouncementServiceImpl;
        this.val$isEaInProgress = bl;
        this.val$listener = emergencyAnnouncementListener;
    }

    @Override
    public void run() {
        if (this.val$isEaInProgress) {
            this.val$listener.enterEmergencyAnnouncement();
        } else {
            this.val$listener.leaveEmergencyAnnouncement();
        }
    }
}

