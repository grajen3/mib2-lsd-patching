/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.adapter;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;

public interface CoreServiceAdapterUpdateListener {
    default public void updateDevice(Device device, int n) {
    }

    default public void updateUserList(User[] userArray, int n) {
    }

    default public void updateServiceList(Service[] serviceArray, int n) {
    }

    default public void updateService(Service service, int n) {
    }

    default public void updateRegistrationStatus(int n, int n2) {
    }

    default public void updateDeviceStatus(int n, int n2) {
    }

    default public void updateTrackingServicesActivation(TrackingService[] trackingServiceArray, int n) {
    }

    default public void updatePrimaryUserDeviceStatus(boolean bl, int n) {
    }

    default public void updatePrivacyModeStatus(boolean bl, int n) {
    }

    default public void updateServiceListState(int n, int n2) {
    }

    default public void updateCumulativeServiceListState(int n, int n2) {
    }
}

