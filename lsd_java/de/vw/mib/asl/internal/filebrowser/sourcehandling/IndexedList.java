/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;

public class IndexedList
extends DeviceAslList {
    private Device[] sorted;

    public IndexedList(int n, DeviceFilter deviceFilter) {
        super(n, deviceFilter);
    }

    @Override
    protected Device[] sort(Device[] deviceArray) {
        this.sorted = super.sort(deviceArray);
        return this.sorted;
    }

    public Device getByIndex(int n) {
        return this.sorted[n];
    }
}

