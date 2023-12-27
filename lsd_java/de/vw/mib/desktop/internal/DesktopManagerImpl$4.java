/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.DesktopManagerImpl;

class DesktopManagerImpl$4
implements Runnable {
    private final /* synthetic */ DesktopManagerImpl this$0;

    DesktopManagerImpl$4(DesktopManagerImpl desktopManagerImpl) {
        this.this$0 = desktopManagerImpl;
    }

    @Override
    public void run() {
        this.this$0.doReleaseResourcesForSkinChange();
    }
}

