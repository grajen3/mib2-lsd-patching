/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Climate;

public abstract class Climate$ClimateInternalAnimation
extends AbstractWidget$WidgetInternalAnimation {
    protected Climate climate;
    private int from;
    private int to;
    private int diff;
    private final /* synthetic */ Climate this$0;

    protected Climate$ClimateInternalAnimation(Climate climate, Climate climate2) {
        this(climate, climate2, new EasingParams(0, 11, 1000, 0));
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
    }

    protected Climate$ClimateInternalAnimation(Climate climate, Climate climate2, EasingParams easingParams) {
        this.this$0 = climate;
        super(climate, easingParams);
        this.climate = climate2;
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        int n = this.from + (int)((float)this.diff * f2);
        this.onAnimate(this.from, this.to, n);
    }

    protected void onAnimate(int n, int n2, int n3) {
    }

    public final void setAnimationParams(int n, int n2) {
        this.from = n;
        this.to = n2;
        if (this.to < this.from) {
            this.setDeltaValue(this.getDeltaValue() * 32959);
        }
        this.diff = Math.abs(this.from - this.to);
    }
}

