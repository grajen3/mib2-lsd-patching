/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.DesktopManagerProxy;
import de.vw.mib.desktop.ViewHandlerProvider;

class DesktopManagerProxy$1
implements Runnable {
    private final /* synthetic */ AppDefinition val$appDefinition;
    private final /* synthetic */ ViewHandlerProvider val$viewHandlerProvider;
    private final /* synthetic */ String val$viewName;
    private final /* synthetic */ String[] val$screenAreaPath;
    private final /* synthetic */ boolean val$resetView;
    private final /* synthetic */ int val$ddpGroupId;
    private final /* synthetic */ DesktopManagerProxy this$0;

    DesktopManagerProxy$1(DesktopManagerProxy desktopManagerProxy, AppDefinition appDefinition, ViewHandlerProvider viewHandlerProvider, String string, String[] stringArray, boolean bl, int n) {
        this.this$0 = desktopManagerProxy;
        this.val$appDefinition = appDefinition;
        this.val$viewHandlerProvider = viewHandlerProvider;
        this.val$viewName = string;
        this.val$screenAreaPath = stringArray;
        this.val$resetView = bl;
        this.val$ddpGroupId = n;
    }

    @Override
    public void run() {
        this.this$0.desktopManager.enterView(this.val$appDefinition, this.val$viewHandlerProvider, this.val$viewName, this.val$screenAreaPath, this.val$resetView, this.val$ddpGroupId);
    }
}

