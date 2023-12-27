/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.desktop.DesktopManager;

public class RenderingInfoService
extends KeyAdapter {
    private final DesktopManager desktopManager;

    public RenderingInfoService(DesktopManager desktopManager) {
        this.desktopManager = desktopManager;
    }

    @Override
    public void onUltraLongPressed(int n) {
        this.desktopManager.setShowDebugOverlayEnabled(!this.desktopManager.isShowDebugOverlayEnabled());
    }
}

