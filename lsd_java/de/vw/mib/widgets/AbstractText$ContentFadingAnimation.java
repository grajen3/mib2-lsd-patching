/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;

final class AbstractText$ContentFadingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ AbstractText this$0;

    public AbstractText$ContentFadingAnimation(AbstractText abstractText, EasingParams easingParams, float f2, float f3) {
        this.this$0 = abstractText;
        super(abstractText, easingParams, f2, f3 - f2);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.setValue(f2);
    }

    private void setValue(float f2) {
        if (this == this.this$0.contentFadeOutAnimation) {
            this.this$0.contentFadeOutAlpha = f2;
        } else if (this == this.this$0.contentFadeInAnimation) {
            this.this$0.contentFadeInAlpha = f2;
        }
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        this.setValue(this.getStartValue() + this.getDeltaValue());
        if (this == this.this$0.contentFadeOutAnimation) {
            this.this$0.contentFadeOutAnimation = null;
            if (this.this$0.fadeOutAnimationTextLayout != null) {
                this.this$0.fadeOutAnimationTextLayout.dispose();
                this.this$0.fadeOutAnimationTextLayout = null;
            }
        } else if (this == this.this$0.contentFadeInAnimation) {
            if (this.this$0.textLayout != null) {
                this.this$0.textLayout.dispose();
                this.this$0.textLayout = null;
            }
            if (this.this$0.fadeInAnimationTextLayout != null) {
                this.this$0.fadeInAnimationTextLayout.reference();
            }
            this.this$0.textLayout = this.this$0.fadeInAnimationTextLayout;
            if (this.this$0.fadeInAnimationTextLayout != null) {
                this.this$0.fadeInAnimationTextLayout.dispose();
                this.this$0.fadeInAnimationTextLayout = null;
            }
            this.this$0.contentFadeInAlpha = 1.0f;
            this.this$0.contentFadeInAnimation = null;
        }
    }
}

