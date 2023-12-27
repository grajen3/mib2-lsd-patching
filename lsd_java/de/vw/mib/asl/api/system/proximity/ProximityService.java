/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.proximity;

import de.vw.mib.asl.api.system.proximity.ProximityListener;

public interface ProximityService {
    default public void addListener(ProximityListener proximityListener) {
    }

    default public boolean getCurrentProximityState() {
    }

    default public boolean getCurrentUserInteractionState() {
    }
}

