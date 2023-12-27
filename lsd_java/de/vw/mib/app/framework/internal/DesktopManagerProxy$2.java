/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.DesktopManagerProxy;

class DesktopManagerProxy$2
implements Runnable {
    private final /* synthetic */ String val$viewName;
    private final /* synthetic */ String[] val$screenAreaPath;
    private final /* synthetic */ int val$sequenceNumber;
    private final /* synthetic */ boolean val$viewFollows;
    private final /* synthetic */ DesktopManagerProxy this$0;

    DesktopManagerProxy$2(DesktopManagerProxy desktopManagerProxy, String string, String[] stringArray, int n, boolean bl) {
        this.this$0 = desktopManagerProxy;
        this.val$viewName = string;
        this.val$screenAreaPath = stringArray;
        this.val$sequenceNumber = n;
        this.val$viewFollows = bl;
    }

    @Override
    public void run() {
        this.this$0.desktopManager.leaveView(this.val$viewName, this.val$screenAreaPath, this.val$sequenceNumber, this.val$viewFollows);
    }
}

