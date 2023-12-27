/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.popup.PopupEntry;

class PopupEntry$1
implements AnimationListener {
    private int internalSequenceNr;
    private final /* synthetic */ PopupEntry this$0;

    PopupEntry$1(PopupEntry popupEntry) {
        this.this$0 = popupEntry;
        this.internalSequenceNr = this.this$0.sequenceNr;
    }

    @Override
    public void animationStarted(Animation animation) {
        this.this$0.onEnterAnimationStarted(this.internalSequenceNr);
    }

    @Override
    public void animationRunning(Animation animation) {
        this.this$0.onEnterAnimationRunning(this.internalSequenceNr);
    }

    @Override
    public void animationProgress(Animation animation, int n) {
        this.this$0.onEnterAnimationProgress(this.internalSequenceNr, animation, n);
    }

    @Override
    public void animationStopped(Animation animation) {
        this.this$0.onEnterAnimationStopped(this.internalSequenceNr);
    }
}

