/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.internal.system.processor.stage.AbstractStageContentRequestPermission;
import de.vw.mib.asl.internal.system.util.Preconditions;

public class CarPreventClimateOnKoreaEwsPermission
extends AbstractStageContentRequestPermission {
    private EmergencyAnnouncementService emergencyAnnouncementService;

    public CarPreventClimateOnKoreaEwsPermission(EmergencyAnnouncementService emergencyAnnouncementService) {
        super("HMI_CLIMATE", "Permission refused, because Korea EWS / EA is currently active.");
        Preconditions.checkArgumentNotNull(emergencyAnnouncementService, "The provided instance of EmergencyAnnouncementService must not be null.");
        this.emergencyAnnouncementService = emergencyAnnouncementService;
    }

    @Override
    protected boolean isGranted() {
        return !this.emergencyAnnouncementService.isEmergencyAnnouncementInProgress();
    }
}

