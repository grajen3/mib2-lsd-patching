/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.carplay;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;

public interface ASLCarplayServicesListener {
    default public void updateCarPlayIsReady(boolean bl) {
    }

    default public void updateCarPlayActive(boolean bl) {
    }

    default public void updateCarPlaTelefonyState(ASLCarplayServicesTelephonyState aSLCarplayServicesTelephonyState) {
    }

    default public void updateCarPlayRouteGuidanceActive(boolean bl) {
    }

    default public void updateCarPlayCallStates(ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray) {
    }
}

