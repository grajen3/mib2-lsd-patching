/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;

public class CircularLinkingAslList
extends DeviceAslList {
    private final SourceIconController sourceIconController;

    public CircularLinkingAslList(SourceIconController sourceIconController, int n, DeviceFilter deviceFilter) {
        super(n, deviceFilter);
        this.sourceIconController = sourceIconController;
    }

    @Override
    protected Device[] sort(Device[] deviceArray) {
        Device[] deviceArray2 = super.sort(deviceArray);
        this.sourceIconController.linkCircular(deviceArray2);
        return deviceArray2;
    }
}

