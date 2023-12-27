/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataObserver;

public interface ASLNavigationDataContainer {
    default public void notifyObserversNavigationDataChanged() {
    }

    default public void addObserver(ASLNavigationDataObserver aSLNavigationDataObserver) {
    }

    default public void removeObserver(ASLNavigationDataObserver aSLNavigationDataObserver) {
    }
}

