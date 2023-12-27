/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.internal.online.tourimport.common.TourImportPropertyManager;
import de.vw.mib.asl.internal.online.tourimport.sequence.TourImportController;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;

public final class TourImportFactory {
    private static TourImportTarget _target;
    private static TourImportController _controller;
    private static TourImportPropertyManager _propertyManager;
    private static NavigationMemoryService _navServices;

    public static TourImportTarget getOnlineTourImportTarget() {
        return _target;
    }

    public static void setOnlineTourImportTarget(TourImportTarget tourImportTarget) {
        _target = tourImportTarget;
    }

    public static TourImportController getOnlineTourImportController() {
        if (_controller == null) {
            _controller = new TourImportController();
        }
        return _controller;
    }

    public static NavigationMemoryService getNaviServices() {
        if (_navServices == null && ASLNavigationFactory.getNavigationApi() != null) {
            _navServices = ASLNavigationFactory.getNavigationApi().getNavigationMemoryService(TourImportFactory.getOnlineTourImportController());
        }
        return _navServices;
    }

    public static TourImportPropertyManager getImportPropertyManager() {
        if (_propertyManager == null) {
            _propertyManager = new TourImportPropertyManager();
        }
        return _propertyManager;
    }
}

