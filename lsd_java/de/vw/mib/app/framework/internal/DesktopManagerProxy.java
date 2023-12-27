/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.DesktopManagerProxy$1;
import de.vw.mib.app.framework.internal.DesktopManagerProxy$2;
import de.vw.mib.app.framework.internal.DesktopManagerProxy$3;
import de.vw.mib.app.framework.internal.DesktopManagerProxy$4;
import de.vw.mib.app.framework.internal.DesktopManagerProxy$5;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt;
import de.vw.mib.viewmanager.internal.ViewHandler;

final class DesktopManagerProxy
implements DesktopManager {
    final DesktopManager desktopManager;
    private final StatemachineEventDispatcherExt statemachineEventDispatcher;

    DesktopManagerProxy(DesktopManager desktopManager, StatemachineEventDispatcherExt statemachineEventDispatcherExt) {
        this.desktopManager = desktopManager;
        this.statemachineEventDispatcher = statemachineEventDispatcherExt;
    }

    @Override
    public void enterView(AppDefinition appDefinition, ViewHandlerProvider viewHandlerProvider, String string, String[] stringArray, boolean bl, int n) {
        this.statemachineEventDispatcher.invoke(new DesktopManagerProxy$1(this, appDefinition, viewHandlerProvider, string, stringArray, bl, n));
    }

    @Override
    public void leaveView(String string, String[] stringArray, int n, boolean bl) {
        this.statemachineEventDispatcher.invoke(new DesktopManagerProxy$2(this, string, stringArray, n, bl));
    }

    @Override
    public void clearScreenArea(String[] stringArray) {
        this.statemachineEventDispatcher.invoke(new DesktopManagerProxy$3(this, stringArray));
    }

    @Override
    public void openPopup(ViewHandler viewHandler, String[] stringArray) {
        this.statemachineEventDispatcher.invoke(new DesktopManagerProxy$4(this, viewHandler, stringArray));
    }

    @Override
    public void closePopup(ViewHandler viewHandler, String[] stringArray) {
        this.statemachineEventDispatcher.invoke(new DesktopManagerProxy$5(this, viewHandler, stringArray));
    }

    @Override
    public boolean isShowDebugOverlayEnabled() {
        return false;
    }

    @Override
    public void setShowDebugOverlayEnabled(boolean bl) {
    }

    @Override
    public boolean isShowBoundingBoxesEnabled() {
        return false;
    }

    @Override
    public void setShowBoundingBoxesEnabled(boolean bl) {
    }
}

