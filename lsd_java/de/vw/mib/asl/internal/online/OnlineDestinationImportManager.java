/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.internal.online.OnlineDestinationImportController;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportTarget;

public final class OnlineDestinationImportManager {
    private static OnlineDestinationImportTarget _target;
    private static OnlineDestinationImportController _controller;
    private static ASLNavigationServices _navServices;

    public static OnlineDestinationImportTarget getOnlineDestinationImportTarget() {
        return _target;
    }

    public static void setOnlineDestinationImportTarget(OnlineDestinationImportTarget onlineDestinationImportTarget) {
        _target = onlineDestinationImportTarget;
    }

    public static OnlineDestinationImportController getOnlineDestinationImportController() {
        if (_controller == null) {
            _controller = new OnlineDestinationImportController();
        }
        return _controller;
    }

    public static ASLNavigationServices getNaviServices() {
        if (_navServices == null && ASLNavigationFactory.getNavigationApi() != null) {
            _navServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(OnlineDestinationImportManager.getOnlineDestinationImportController());
        }
        return _navServices;
    }
}

