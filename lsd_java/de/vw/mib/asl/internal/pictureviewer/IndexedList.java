/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;

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

    public FileBrowserSourceInfo getByIndex(int n) {
        return FileBrowserSourceInfo.get(this.sorted[n]);
    }
}

