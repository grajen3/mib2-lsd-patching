/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.emergency;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementListener;

public interface EmergencyAnnouncementService {
    default public boolean isEmergencyAnnouncementInProgress() {
    }

    default public void addListener(EmergencyAnnouncementListener emergencyAnnouncementListener) {
    }

    default public void removeListener(EmergencyAnnouncementListener emergencyAnnouncementListener) {
    }

    default public void setEmergencyAnnouncementState(boolean bl) {
    }
}

