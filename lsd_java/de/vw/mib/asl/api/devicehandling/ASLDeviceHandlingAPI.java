/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import java.util.Collection;

public interface ASLDeviceHandlingAPI {
    default public void register(MediaListObserver mediaListObserver) {
    }

    default public void registerArray(MediaListObserver[] mediaListObserverArray) {
    }

    default public void registerAll(Collection collection) {
    }

    default public boolean deregister(MediaListObserver mediaListObserver) {
    }

    default public Devices getDevices() {
    }

    default public boolean is2ndUsbAvailable() {
    }

    default public boolean is2ndSdAvailable() {
    }

    default public int getDeviceCount(int n) {
    }
}

