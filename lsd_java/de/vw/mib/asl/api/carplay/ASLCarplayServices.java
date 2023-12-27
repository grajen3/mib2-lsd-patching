/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.carplay;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesListener;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;

public interface ASLCarplayServices {
    default public void registerListener(ASLCarplayServicesListener aSLCarplayServicesListener) {
    }

    default public void unregisterListener(ASLCarplayServicesListener aSLCarplayServicesListener) {
    }

    default public boolean isReady() {
    }

    default public void sendCompleteUpdate() {
    }

    default public boolean isCarPlayActive() {
    }

    default public ASLCarplayServicesTelephonyState getCarPlayTelephonyState() {
    }

    default public boolean isCarPlayRouteGuidanceActive() {
    }

    default public ASLCarplayServicesCallState[] getCarPlayCallStates() {
    }

    default public void requestAcceptCall() {
    }

    default public void requestEndCall() {
    }
}

