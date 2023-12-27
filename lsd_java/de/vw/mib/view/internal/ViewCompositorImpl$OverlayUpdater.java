/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.view.internal.ViewCompositorImpl;

public final class ViewCompositorImpl$OverlayUpdater
implements Runnable {
    private final /* synthetic */ ViewCompositorImpl this$0;

    protected ViewCompositorImpl$OverlayUpdater(ViewCompositorImpl viewCompositorImpl) {
        this.this$0 = viewCompositorImpl;
    }

    @Override
    public void run() {
        if (this.this$0.systemPerformanceOverlay != null) {
            this.this$0.systemPerformanceOverlay.update();
        }
        ViewCompositorImpl.triggerRepaint();
    }
}

