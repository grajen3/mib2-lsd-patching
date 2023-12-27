/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.repaint.internal.RepaintManagerImpl;

final class RepaintManagerImpl$RepaintTimerHandler
implements Runnable {
    private final /* synthetic */ RepaintManagerImpl this$0;

    public RepaintManagerImpl$RepaintTimerHandler(RepaintManagerImpl repaintManagerImpl) {
        this.this$0 = repaintManagerImpl;
    }

    @Override
    public void run() {
        if (this.this$0.repaintMode == 0 && this.this$0.repaintRequested.compareAndSet(true, false)) {
            this.this$0.logger.trace(2048, "Performing periodic repaint request (due to aggregation timeout)");
            this.this$0.submitRepaintEvent();
        } else {
            this.this$0.logger.trace(2048, "Stopping periodic repaint handler (no repaints requested)");
            this.this$0.repaintTimer.stop();
        }
    }
}

