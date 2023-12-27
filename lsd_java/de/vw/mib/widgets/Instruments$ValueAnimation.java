/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments;

final class Instruments$ValueAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ Instruments this$0;

    public Instruments$ValueAnimation(Instruments instruments, EasingParams easingParams, float f2, float f3) {
        this.this$0 = instruments;
        super(instruments, easingParams, f2, f3);
        this.setAnimationInterval(125);
    }

    public float getEndValue() {
        return this.getStartValue() + this.getDeltaValue();
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.this$0.setInternalAngle(this.this$0.calcAngleForValue(f2));
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
        this.this$0.set_valueOut(Math.round(f2));
    }
}

