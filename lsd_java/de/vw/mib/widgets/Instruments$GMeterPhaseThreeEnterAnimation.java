/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$InstrumentsCascadeAnimation;

final class Instruments$GMeterPhaseThreeEnterAnimation
extends Instruments$InstrumentsCascadeAnimation {
    private final /* synthetic */ Instruments this$0;

    public Instruments$GMeterPhaseThreeEnterAnimation(Instruments instruments, EasingParams easingParams, int n) {
        this.this$0 = instruments;
        super(instruments, easingParams, n);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        if (this.doStartNextAnim(f2)) {
            this.this$0.startGMeterPhaseThreeEnterAnimation(this.idx - 1);
            this.setNextAnimStarted(true);
        }
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.this$0.setHaloAlphaInternal(this.idx, Math.round(32579 * (1.0f - f2)));
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    @Override
    public void stop() {
        super.stop();
        if (this.idx == 0) {
            this.this$0.setEnterAnimationFinished(true);
            this.this$0.haloCreator.reinit();
            this.this$0.addHaloInput();
        }
    }
}

