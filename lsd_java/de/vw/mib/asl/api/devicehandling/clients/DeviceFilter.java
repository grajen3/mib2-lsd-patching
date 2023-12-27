/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter$1;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter$2;

public interface DeviceFilter {
    public static final DeviceFilter IS_LISTED = new DeviceFilter$1();
    public static final DeviceFilter REMOVABLE = new DeviceFilter$2();

    default public boolean passes(Device device) {
    }
}

