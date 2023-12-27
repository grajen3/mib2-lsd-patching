/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.view2view;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.view2view.TransitionManagerConcurrentImpl;

class TransitionManagerConcurrentImpl$2
implements AnimationListener {
    private int internalTransitionNumber;
    private final /* synthetic */ TransitionManagerConcurrentImpl this$0;

    TransitionManagerConcurrentImpl$2(TransitionManagerConcurrentImpl transitionManagerConcurrentImpl) {
        this.this$0 = transitionManagerConcurrentImpl;
        this.internalTransitionNumber = this.this$0.currentTransitionNumber;
    }

    @Override
    public void animationStarted(Animation animation) {
        this.this$0.onEnterAnimationStarted(this.internalTransitionNumber);
    }

    @Override
    public void animationRunning(Animation animation) {
        this.this$0.onEnterAnimationRunning(this.internalTransitionNumber);
    }

    @Override
    public void animationProgress(Animation animation, int n) {
        this.this$0.onEnterAnimationProgress(this.internalTransitionNumber, animation, n);
    }

    @Override
    public void animationStopped(Animation animation) {
        this.this$0.onEnterAnimationStopped(this.internalTransitionNumber);
    }
}

