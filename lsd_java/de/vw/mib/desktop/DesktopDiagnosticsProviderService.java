/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop;

import de.vw.mib.desktop.DesktopDiagnosticsNotificationReceiver;

public interface DesktopDiagnosticsProviderService {
    default public void addDesktopDiagnosticsNotificationReceiver(DesktopDiagnosticsNotificationReceiver desktopDiagnosticsNotificationReceiver) {
    }

    default public String getViewTreeAsShortString() {
    }
}

