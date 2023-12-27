/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.popup.PopupEntry;

class PopupEntry$2
implements AnimationListener {
    private int internalSequenceNr;
    private final /* synthetic */ PopupEntry this$0;

    PopupEntry$2(PopupEntry popupEntry) {
        this.this$0 = popupEntry;
        this.internalSequenceNr = this.this$0.sequenceNr;
    }

    @Override
    public void animationStarted(Animation animation) {
        this.this$0.onLeaveAnimationStarted(this.internalSequenceNr);
    }

    @Override
    public void animationRunning(Animation animation) {
        this.this$0.onLeaveAnimationRunning(this.internalSequenceNr);
    }

    @Override
    public void animationProgress(Animation animation, int n) {
        this.this$0.onLeaveAnimationProgress(this.internalSequenceNr, animation, n);
    }

    @Override
    public void animationStopped(Animation animation) {
        this.this$0.onLeaveAnimationStopped(this.internalSequenceNr);
    }
}

