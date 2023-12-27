/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.media.services.sources.SourceId;

public interface Devices {
    default public int count() {
    }

    default public Device get(int n) {
    }

    default public int countPassing(DeviceFilter deviceFilter) {
    }

    default public Device getByDeviceId(long l) {
    }

    default public int getDeviceTypeCount(int n) {
    }

    default public Device getByDeviceType(int n, int n2) {
    }

    default public Device getBySourceId(SourceId sourceId) {
    }

    default public Device getInternalOptical() {
    }

    default public boolean isUpdateDeviceList() {
    }

    default public boolean isInitialized() {
    }
}

