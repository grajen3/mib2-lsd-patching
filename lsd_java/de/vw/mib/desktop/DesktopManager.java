/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.viewmanager.internal.ViewHandler;

public interface DesktopManager {
    default public void enterView(AppDefinition appDefinition, ViewHandlerProvider viewHandlerProvider, String string, String[] stringArray, boolean bl, int n) {
    }

    default public void leaveView(String string, String[] stringArray, int n, boolean bl) {
    }

    default public void clearScreenArea(String[] stringArray) {
    }

    default public void openPopup(ViewHandler viewHandler, String[] stringArray) {
    }

    default public void closePopup(ViewHandler viewHandler, String[] stringArray) {
    }

    default public boolean isShowDebugOverlayEnabled() {
    }

    default public void setShowDebugOverlayEnabled(boolean bl) {
    }

    default public boolean isShowBoundingBoxesEnabled() {
    }

    default public void setShowBoundingBoxesEnabled(boolean bl) {
    }
}

