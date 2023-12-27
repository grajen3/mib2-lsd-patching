/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Slider;

final class Slider$ProgressImageValueChangeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ Slider this$0;

    public Slider$ProgressImageValueChangeAnimation(Slider slider, EasingParams easingParams, int n, int n2) {
        this.this$0 = slider;
        super(slider, false, easingParams);
        this.setStartValue(n);
        this.setDeltaValue(n2 - n);
        this.setAnimationInterval(easingParams.getDuration() / (Math.abs(n2 - n) * 3));
    }

    @Override
    public void animate(float f2, long l, long l2) {
        int n = Math.round(f2);
        this.this$0.updateImageIndexAndImageReferenceProperties(n);
    }

    @Override
    public void stop() {
        super.stop();
    }
}

