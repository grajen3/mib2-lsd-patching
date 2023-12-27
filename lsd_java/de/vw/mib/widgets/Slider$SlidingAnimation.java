/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Slider;

final class Slider$SlidingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final Slider slider;
    private final int endValue;
    private final /* synthetic */ Slider this$0;

    public Slider$SlidingAnimation(Slider slider, Slider slider2, EasingParams easingParams, int n, int n2) {
        this.this$0 = slider;
        super(slider, easingParams, n, n2 - n);
        this.endValue = n2;
        this.slider = slider2;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.slider.set_value(Math.round(f2));
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
        if (!this.slider.isPressed()) {
            this.slider.updateSliderImageGeometry();
        }
        this.slider.updateProgressImageGeometry();
        this.slider.repaint();
    }

    @Override
    public void stop() {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.slider.set_value(this.endValue);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
        super.stop();
    }
}

