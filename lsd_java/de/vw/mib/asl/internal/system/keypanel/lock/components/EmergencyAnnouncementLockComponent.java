/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.EmergencyAnnouncementLockComponent$1;

public class EmergencyAnnouncementLockComponent
extends AbstractLockStateComponent {
    public EmergencyAnnouncementLockComponent(EmergencyAnnouncementService emergencyAnnouncementService) {
        this.setLocked(emergencyAnnouncementService.isEmergencyAnnouncementInProgress());
        emergencyAnnouncementService.addListener(new EmergencyAnnouncementLockComponent$1(this));
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                return true;
            }
        }
        return false;
    }
}

