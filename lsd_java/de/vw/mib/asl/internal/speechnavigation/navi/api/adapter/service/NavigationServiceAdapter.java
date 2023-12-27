/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationService;

public final class NavigationServiceAdapter
implements NavigationService {
    private static NavigationService instance = null;

    private NavigationServiceAdapter() {
    }

    public static NavigationService getNavigationService() {
        if (instance == null) {
            instance = new NavigationServiceAdapter();
        }
        return instance;
    }

    @Override
    public boolean isNavigationServiceAvailable() {
        return ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100;
    }
}

