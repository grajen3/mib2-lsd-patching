/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class RadioSystemEventsUtil {
    private RadioSystemEventsUtil() {
    }

    public static void sendInitialAutoStoreFinished() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(216);
    }

    public static void sendTPSeekFinished() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(222);
    }

    public static void sendTPSeekStarted() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(223);
    }

    public static void sendAutoStoreStarted() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(201);
    }

    public static void sendAutoStoreCanceled() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(202);
    }

    public static void sendListUpdateFinished() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(221);
    }

    public static void sendSelectStationFinished(boolean bl) {
        int n = bl ? 215 : 214;
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public static void sendOpenEnsembleFinished() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(561);
    }

    public static void sendSelectEnsembleFinished(boolean bl) {
        int n = bl ? 220 : 219;
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public static void sendNoServicesAvailable() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(426);
    }

    public static void sendPresetStored() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(520);
    }

    public static void sendReturnToMain() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(555);
    }
}

