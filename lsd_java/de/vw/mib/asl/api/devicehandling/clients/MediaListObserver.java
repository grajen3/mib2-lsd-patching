/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Devices;

public interface MediaListObserver {
    default public void onUpdate(Devices devices) {
    }
}

