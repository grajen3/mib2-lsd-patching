/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.DesktopManagerProxy;

class DesktopManagerProxy$3
implements Runnable {
    private final /* synthetic */ String[] val$screenAreaPath;
    private final /* synthetic */ DesktopManagerProxy this$0;

    DesktopManagerProxy$3(DesktopManagerProxy desktopManagerProxy, String[] stringArray) {
        this.this$0 = desktopManagerProxy;
        this.val$screenAreaPath = stringArray;
    }

    @Override
    public void run() {
        this.this$0.desktopManager.clearScreenArea(this.val$screenAreaPath);
    }
}

