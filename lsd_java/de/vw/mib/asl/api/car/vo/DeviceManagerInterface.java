/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo;

import de.vw.mib.asl.api.car.vo.DeviceManagerListener;

public interface DeviceManagerInterface {
    default public void addListener(DeviceManagerListener deviceManagerListener) {
    }

    default public void removeListener(DeviceManagerListener deviceManagerListener) {
    }
}

