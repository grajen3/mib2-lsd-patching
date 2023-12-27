/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map.instrumentcluster;

public interface ICMapListener {
    default public void updateKombiMapStatus(int n) {
    }

    default public void updateKombiMapVisibility(int n) {
    }

    default public void updateMapSwitchState(int n) {
    }

    default public void updateNavigationMapInAbtVisibility(int n) {
    }

    default public void switchMapToAbt() {
    }

    default public void switchMapToKombi() {
    }

    default public void updateICMapServiceState(int n) {
    }
}

