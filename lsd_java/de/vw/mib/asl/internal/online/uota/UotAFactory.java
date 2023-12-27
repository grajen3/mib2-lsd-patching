/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.internal.online.uota.common.UotAErrorHandling;
import de.vw.mib.asl.internal.online.uota.common.UotAPropertyManager;
import de.vw.mib.asl.internal.online.uota.common.UotASessionManager;
import de.vw.mib.asl.internal.online.uota.lists.UotAPacketListController;
import de.vw.mib.asl.internal.online.uota.sequence.UotAPacketController;
import de.vw.mib.asl.internal.online.uota.service.UotAGuidanceService;
import de.vw.mib.asl.internal.online.uota.service.UotAInstallationService;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;

public final class UotAFactory {
    private static UotAPacketController _packetController;
    private static UotAPacketListController _packetListController;
    private static UotASessionManager _sessionManager;
    private static NavigationGuidanceService _navGuidanceService;
    private static UotAInstallationService _installationService;

    private UotAFactory() {
    }

    public static UotAPacketController getPacketController(UotATarget uotATarget) {
        if (_packetController == null && uotATarget != null) {
            _packetController = new UotAPacketController(uotATarget);
        }
        return _packetController;
    }

    public static UotAErrorHandling getErrorHandler() {
        return new UotAErrorHandling();
    }

    public static UotAPacketListController getPacketListController() {
        if (_packetListController == null) {
            _packetListController = new UotAPacketListController();
        }
        return _packetListController;
    }

    public static UotAPropertyManager getPropertyManager() {
        return new UotAPropertyManager();
    }

    public static UotASessionManager getSessionManager() {
        if (_sessionManager == null) {
            _sessionManager = new UotASessionManager();
        }
        return _sessionManager;
    }

    public static NavigationGuidanceService getNavigationGuidanceService(UotATarget uotATarget) {
        if (_navGuidanceService == null && uotATarget != null && ASLNavigationFactory.getNavigationApi() != null) {
            try {
                _navGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(new UotAGuidanceService(uotATarget));
            }
            catch (NavigationServiceException navigationServiceException) {
                // empty catch block
            }
        }
        return _navGuidanceService;
    }

    public static UotAInstallationService getInstallationService(UotATarget uotATarget) {
        if (_installationService == null && uotATarget != null) {
            _installationService = new UotAInstallationService(uotATarget);
        }
        return _installationService;
    }
}

