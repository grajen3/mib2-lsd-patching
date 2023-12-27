/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.DesktopManagerImpl;

class DesktopManagerImpl$3
implements Runnable {
    private final /* synthetic */ int val$newSkinMode;
    private final /* synthetic */ DesktopManagerImpl this$0;

    DesktopManagerImpl$3(DesktopManagerImpl desktopManagerImpl, int n) {
        this.this$0 = desktopManagerImpl;
        this.val$newSkinMode = n;
    }

    @Override
    public void run() {
        this.this$0.doPropagateSkinMode(this.val$newSkinMode);
    }
}

