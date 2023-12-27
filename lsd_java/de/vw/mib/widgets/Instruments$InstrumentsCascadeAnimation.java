/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments;

abstract class Instruments$InstrumentsCascadeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    protected int idx;
    private boolean nextAnimStarted;
    public static final int ALPHA_MAX;
    public static final float DEFAULT_START;
    public static final float DEFAULT_DELTA;
    private final /* synthetic */ Instruments this$0;

    public Instruments$InstrumentsCascadeAnimation(Instruments instruments, EasingParams easingParams, float f2, float f3, int n) {
        this.this$0 = instruments;
        super(instruments, easingParams, f2, f3);
        this.idx = n;
        this.nextAnimStarted = false;
    }

    public Instruments$InstrumentsCascadeAnimation(Instruments instruments, EasingParams easingParams, int n) {
        this(instruments, easingParams, 0.0f, 1.0f, n);
    }

    public void setNextAnimStarted(boolean bl) {
        this.nextAnimStarted = bl;
    }

    public boolean doStartNextAnim(float f2) {
        return !this.nextAnimStarted && f2 > 0.0f;
    }
}

