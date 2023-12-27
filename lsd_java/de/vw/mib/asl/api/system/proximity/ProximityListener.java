/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.proximity;

public interface ProximityListener {
    default public void onProximityChanged(boolean bl) {
    }

    default public void onUserInteractionProximityChanged(boolean bl) {
    }
}

