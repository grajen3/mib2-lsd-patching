/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Iris;

final class Iris$ChangeAccelerationAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ Iris this$0;

    public Iris$ChangeAccelerationAnimation(Iris iris, EasingParams easingParams, float f2, float f3) {
        this.this$0 = iris;
        super(iris, easingParams, f2, f3 - f2);
        this.setAnimationInterval(83);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.this$0.setIndicatorRotation(f2);
        this.this$0.updateIndicatorColors();
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.propertyChanged(23);
    }
}

