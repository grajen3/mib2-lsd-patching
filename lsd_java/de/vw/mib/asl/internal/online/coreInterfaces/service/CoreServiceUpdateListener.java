/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.service;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;

public interface CoreServiceUpdateListener {
    default public void updateRegisteredDeviceType(int n) {
    }

    default public void updateUserList(OnlineUser[] onlineUserArray) {
    }

    default public void updateServiceList(OnlineService[] onlineServiceArray) {
    }

    default public void updateService(OnlineService onlineService) {
    }

    default public void updateRegistrationStatus(int n) {
    }

    default public void updateDeviceReadyForUse(int n) {
    }

    default public void updateTrackingServicesActivation(OnlineTrackingService[] onlineTrackingServiceArray) {
    }

    default public void updatePrimaryUserPopupActivation(OnlineUser onlineUser) {
    }

    default public void updatePrivacyModeStatus(boolean bl) {
    }

    default public void updateCumulativeServiceListState(int n) {
    }
}

