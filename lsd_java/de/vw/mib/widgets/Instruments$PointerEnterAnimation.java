/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments;

final class Instruments$PointerEnterAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private static final int PHASE_INVALID;
    private int phase;
    private final /* synthetic */ Instruments this$0;

    public Instruments$PointerEnterAnimation(Instruments instruments, EasingParams easingParams, float f2, float f3, int n) {
        this(instruments, easingParams, f2, f3);
        this.phase = n;
    }

    public Instruments$PointerEnterAnimation(Instruments instruments, EasingParams easingParams, float f2, float f3) {
        this.this$0 = instruments;
        super(instruments, easingParams, f2, f3 - f2);
        this.phase = -1;
    }

    public float getEndValue() {
        return this.getStartValue() + this.getDeltaValue();
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.this$0.setInternalAngle(f2);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    @Override
    public void stop() {
        super.stop();
        if (this.phase == 0) {
            this.this$0.startPointerEnterAnimation(1);
        } else if (this.phase == 1) {
            this.this$0.setEnterAnimationFinished(true);
            this.this$0.valueChanged(this.this$0.getValueMin());
        }
    }
}

