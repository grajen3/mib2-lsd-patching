/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;

public interface NavigationExtService {
    public static final int SERVICE_STATE_UNAVAILABLE;
    public static final int SERVICE_STATE_INSTANTIATED;
    public static final int SERVICE_STATE_FULLY_OPERABLE;

    default public int getNavigationServiceState() {
    }

    default public NavigationGuidanceService getNavigationGuidanceService(NavigationGuidanceListener navigationGuidanceListener) {
    }

    default public NavigationMemoryService getNavigationMemoryService(NavigationMemoryListener navigationMemoryListener) {
    }

    default public NavigationLocationinputService getNavigationLocationinputService(NavigationLocationinputListener navigationLocationinputListener) {
    }
}

