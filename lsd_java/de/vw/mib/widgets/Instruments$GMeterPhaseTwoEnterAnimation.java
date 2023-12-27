/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$InstrumentsCascadeAnimation;

final class Instruments$GMeterPhaseTwoEnterAnimation
extends Instruments$InstrumentsCascadeAnimation {
    static final int START_ANGLE;
    static final int DELTA_ANGLE;
    private int radius;
    private final /* synthetic */ Instruments this$0;

    public Instruments$GMeterPhaseTwoEnterAnimation(Instruments instruments, EasingParams easingParams, int n) {
        this.this$0 = instruments;
        super(instruments, easingParams, n);
        int n2 = instruments.getPointerImageCount();
        this.radius = n2 != 0 ? (int)((float)n * ((float)instruments.get_valueMax() / (float)n2)) + 1 : 0;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        if (this.doStartNextAnim(f2)) {
            this.this$0.startGMeterPhaseTwoEnterAnimation(this.idx + 1);
            this.setNextAnimStarted(true);
            this.this$0.setHaloAlphaInternal(this.idx, 255);
        }
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        int n = 46274 + f2 * 34627;
        this.this$0.haloCreator.addHaloInput(this.radius, n);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        if (this.idx == this.this$0.getPointerImageCount() - 1) {
            this.this$0.startGMeterPhaseThreeEnterAnimation(this.idx);
        }
    }
}

