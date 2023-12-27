/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.DesktopManagerProxy;
import de.vw.mib.viewmanager.internal.ViewHandler;

class DesktopManagerProxy$5
implements Runnable {
    private final /* synthetic */ ViewHandler val$view;
    private final /* synthetic */ String[] val$screenAreaPath;
    private final /* synthetic */ DesktopManagerProxy this$0;

    DesktopManagerProxy$5(DesktopManagerProxy desktopManagerProxy, ViewHandler viewHandler, String[] stringArray) {
        this.this$0 = desktopManagerProxy;
        this.val$view = viewHandler;
        this.val$screenAreaPath = stringArray;
    }

    @Override
    public void run() {
        this.this$0.desktopManager.closePopup(this.val$view, this.val$screenAreaPath);
    }
}

