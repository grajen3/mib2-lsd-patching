/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl;

import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMap;

public interface NavigationMapService
extends NavigationMap {
    default public int getKombiMapStatus() {
    }

    default public int getKombiMapVisibility() {
    }

    default public int getMapSwitchState() {
    }

    default public int getMapInAbtVisibility() {
    }

    default public boolean isNavigationServiceStateFullyOperable() {
    }

    default public void failedToPerformMapSwitch() {
    }

    default public int getNavigationMapServiceState() {
    }

    default public boolean isMapSwitchPossible() {
    }
}

