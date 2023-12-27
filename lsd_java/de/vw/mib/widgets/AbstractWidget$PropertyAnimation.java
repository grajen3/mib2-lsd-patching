/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;

public class AbstractWidget$PropertyAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final int easingIndex;
    private final AbstractWidget$ValueAccessor valueAccessor;
    private final /* synthetic */ AbstractWidget this$0;

    public AbstractWidget$PropertyAnimation(AbstractWidget abstractWidget, int n, AbstractWidget$ValueAccessor abstractWidget$ValueAccessor) {
        this.this$0 = abstractWidget;
        super(abstractWidget);
        this.easingIndex = n;
        this.valueAccessor = abstractWidget$ValueAccessor;
    }

    public final boolean startAnimation(float f2) {
        if (!Util.equalsEpsilon(f2, this.getTargetValue())) {
            return this.startAnimation(this.valueAccessor.getValue(), f2, false);
        }
        return true;
    }

    public final boolean startAnimation(float f2, EasingParams easingParams) {
        if (!Util.equalsEpsilon(f2, this.getTargetValue())) {
            return this.startAnimation(this.valueAccessor.getValue(), f2, easingParams, false);
        }
        return true;
    }

    public final boolean startAnimation(float f2, float f3, boolean bl) {
        EasingParams easingParams = this.this$0.getEasing(this.easingIndex);
        if (easingParams == null) {
            return false;
        }
        return this.startAnimation(f2, f3, easingParams, bl);
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        this.setValue(f2);
    }

    protected final void setValue(float f2) {
        float f3 = this.valueAccessor.getValue();
        if (f3 != f2) {
            this.valueAccessor.setValue(f2);
            this.valueAccessor.valueChanged(f3);
        }
    }

    private float getTargetValue() {
        return this.isActive() ? this.getStartValue() + this.getDeltaValue() : this.valueAccessor.getValue();
    }

    public boolean startAnimation(float f2, float f3, EasingParams easingParams, boolean bl) {
        boolean bl2 = this.isStarted();
        if (!bl2) {
            this.this$0.stopInternalAnimation(this);
        }
        this.setEasingParams(easingParams);
        this.setStartValue(f2);
        this.setDeltaValue(f3 - f2);
        return bl2 || this.this$0.startInternalAnimation(this, bl);
    }
}

