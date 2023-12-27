/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.pso;

public interface PersonalizationListener {
    default public void onResetStateChanged(int n) {
    }

    default public void updateActiveProfile(String string, int n) {
    }

    default public void updateActive(boolean bl) {
    }
}

