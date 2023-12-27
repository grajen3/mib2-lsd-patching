/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.EmergencyAnnouncementLockComponent;

class EmergencyAnnouncementLockComponent$1
implements EmergencyAnnouncementListener {
    private final /* synthetic */ EmergencyAnnouncementLockComponent this$0;

    EmergencyAnnouncementLockComponent$1(EmergencyAnnouncementLockComponent emergencyAnnouncementLockComponent) {
        this.this$0 = emergencyAnnouncementLockComponent;
    }

    @Override
    public void leaveEmergencyAnnouncement() {
        this.this$0.setLocked(false);
    }

    @Override
    public void enterEmergencyAnnouncement() {
        this.this$0.setLocked(true);
    }
}

