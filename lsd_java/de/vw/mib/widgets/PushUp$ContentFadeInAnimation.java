/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PushUp;

class PushUp$ContentFadeInAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ PushUp this$0;

    public PushUp$ContentFadeInAnimation(PushUp pushUp) {
        this.this$0 = pushUp;
        super(pushUp, null);
    }

    public void setAnimationParams(EasingParams easingParams) {
        super.setEasingParams(easingParams);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        this.this$0.setContentAlpha(f2);
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.setContentAlpha(this.getStartValue() + this.getDeltaValue());
    }
}

