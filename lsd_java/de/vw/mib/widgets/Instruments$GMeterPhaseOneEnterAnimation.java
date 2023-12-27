/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$InstrumentsCascadeAnimation;

final class Instruments$GMeterPhaseOneEnterAnimation
extends Instruments$InstrumentsCascadeAnimation {
    private static final int ALPHA_PHASE_ONE;
    private final /* synthetic */ Instruments this$0;

    public Instruments$GMeterPhaseOneEnterAnimation(Instruments instruments, EasingParams easingParams, int n) {
        this.this$0 = instruments;
        super(instruments, easingParams, n);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        if (this.doStartNextAnim(f2)) {
            this.this$0.startGMeterPhaseOneEnterAnimation(this.idx + 1);
            this.setNextAnimStarted(true);
        }
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.this$0.setHaloAlphaInternal(this.idx, Math.round((1.0f - f2) * 18499));
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    @Override
    public void stop() {
        super.stop();
        if (this.idx == this.this$0.getPointerImageCount() - 1) {
            this.this$0.startGMeterPhaseTwoEnterAnimation(0);
        }
    }
}

