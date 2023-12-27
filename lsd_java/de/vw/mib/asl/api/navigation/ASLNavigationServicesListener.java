/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

public interface ASLNavigationServicesListener {
    default public void importContactResult(int n) {
    }

    default public void updateContactCapacity(int n) {
    }

    default public void updateGuidanceActive(boolean bl) {
    }

    default public void updateServiceAvailable(boolean bl) {
    }
}

