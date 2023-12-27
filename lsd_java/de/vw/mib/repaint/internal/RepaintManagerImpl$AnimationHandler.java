/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.animation.control.AnimationManagerListener;
import de.vw.mib.repaint.internal.RepaintManagerImpl;

final class RepaintManagerImpl$AnimationHandler
implements AnimationManagerListener {
    private final /* synthetic */ RepaintManagerImpl this$0;

    public RepaintManagerImpl$AnimationHandler(RepaintManagerImpl repaintManagerImpl) {
        this.this$0 = repaintManagerImpl;
    }

    @Override
    public void animationManagerChanged(int n) {
        if (!RepaintManagerImpl.IGNORE_ANIMATION_MODE && this.this$0.repaintMode != 2) {
            if (this.this$0.repaintMode != 1 && n == 3) {
                this.this$0.repaintMode = 1;
                this.this$0.logger.trace(2048, "Repaint-Mode: ANIMATION");
            } else if (this.this$0.repaintMode != 0 && n == 2) {
                this.this$0.repaintMode = 0;
                this.this$0.logger.trace(2048, "Repaint-Mode: NORMAL");
            } else if (this.this$0.repaintMode == 1 && n == 1) {
                this.this$0.logger.trace(2048, "Repaint requested by AnimationManager");
                this.this$0.submitRepaintEvent();
            }
        }
    }
}

