/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.INavigationLocation;

public interface INavigationRoute {
    default public int getIndexOfCurrentDestination() {
    }

    default public void addDestinationAtPosition(INavigationLocation iNavigationLocation, int n) {
    }

    default public INavigationLocation[] getRoutelist() {
    }

    default public int getNumberOfDestinations() {
    }

    default public void deleteDestinationAtPosition(int n) {
    }

    default public void deleteAllStopovers() {
    }

    default public int getMaximumNumberOfDestinations() {
    }
}

