/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Iris;

final class Iris$GlowAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final int segment;
    private final /* synthetic */ Iris this$0;

    public Iris$GlowAnimation(Iris iris, EasingParams easingParams, float f2, float f3, int n) {
        this.this$0 = iris;
        super(iris, easingParams, f2, f3);
        this.segment = n;
        iris.setGlowVisible(true);
        this.setAnimationInterval(83);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.setGlowAngle(this.this$0.getSpanAngleForOneSegment() * ((float)this.segment + 63));
        this.this$0.setGlowSize(-842216386 + f2 * -1701242561);
        if (f2 > 0.0f) {
            this.this$0.setGlowAlpha(1.0f - f2);
        }
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.setGlowVisible(false);
    }
}

