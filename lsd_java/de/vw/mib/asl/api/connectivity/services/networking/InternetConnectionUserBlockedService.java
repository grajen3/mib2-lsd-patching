/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.connectivity.services.networking;

import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedUpdate;

public interface InternetConnectionUserBlockedService {
    default public void register(InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate) {
    }

    default public void unregister(InternetConnectionUserBlockedUpdate internetConnectionUserBlockedUpdate) {
    }
}

