/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

public interface TrackingService {
    default public String getServiceID() {
    }

    default public void setServiceID(String string) {
    }

    default public boolean isServiceActivatedInCurrentLifeCycle() {
    }

    default public void setServiceToActivationInCurrentLifeCycle(boolean bl) {
    }

    default public boolean isTrackingActivated() {
    }

    default public void setTrackingActivated(boolean bl) {
    }
}

