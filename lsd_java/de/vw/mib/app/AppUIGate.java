/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app;

import de.vw.mib.app.AppLifecycleService;
import de.vw.mib.app.AppUIService;
import de.vw.mib.desktop.ViewHandlerProvider;

public interface AppUIGate
extends ViewHandlerProvider {
    default public void ready() {
    }

    default public void start(AppLifecycleService appLifecycleService, AppUIService appUIService) {
    }

    default public void stop() {
    }

    default public void denyVisibility(String string) {
    }

    default public void grantVisibility(String string) {
    }

    default public void revokeVisibility(String string) {
    }

    default public void onBusinessComponentAvailable(String string, Object object) {
    }

    default public void onBusinessComponentUnavailable(String string, Object object) {
    }
}

