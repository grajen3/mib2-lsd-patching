/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.widgets.AbstractWidget;

final class AbstractWidget$VisibleAnimationNotifier
implements AnimationListener {
    private final /* synthetic */ AbstractWidget this$0;

    public AbstractWidget$VisibleAnimationNotifier(AbstractWidget abstractWidget) {
        this.this$0 = abstractWidget;
    }

    @Override
    public void animationStarted(Animation animation) {
    }

    @Override
    public void animationStopped(Animation animation) {
        if (!this.this$0.isVisibleRelevantAnimationRunning()) {
            this.this$0.parentVisibilityChanged(!this.this$0.is_visible());
        }
        animation.removeAnimationListener(this);
    }

    @Override
    public void animationRunning(Animation animation) {
    }

    @Override
    public void animationProgress(Animation animation, int n) {
    }
}

