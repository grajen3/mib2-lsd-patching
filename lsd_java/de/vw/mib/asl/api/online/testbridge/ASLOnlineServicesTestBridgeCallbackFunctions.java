/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.testbridge;

public interface ASLOnlineServicesTestBridgeCallbackFunctions {
    default public void registerCallback() {
    }

    default public void startupDoneCallback() {
    }

    default public void getFeatureFlagForServiceCallback(int n, int n2, boolean bl) {
    }

    default public void testBackendAvailabilityCallback(int n, int n2, boolean bl) {
    }

    default public void unknownCallback(int n) {
    }
}

