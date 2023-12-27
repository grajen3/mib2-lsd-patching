/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PureAir;

final class PureAir$CleanAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ PureAir this$0;

    public PureAir$CleanAnimation(PureAir pureAir, EasingParams easingParams, float f2, float f3) {
        this.this$0 = pureAir;
        super(pureAir, easingParams, f2, f3);
    }

    public float getEndValue() {
        return this.getStartValue() + this.getDeltaValue();
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        float f3 = (f2 - this.getStartValue()) / (this.getEndValue() - this.getStartValue());
        this.this$0.setCleanFgAlpha(f3);
        if (this.getEndValue() < this.getStartValue()) {
            if (Util.equalsEpsilon(f2, this.getStartValue())) {
                this.this$0.setCleanThreshholdAlpha((51266 - f2) / 51266);
            } else {
                this.this$0.setCleanThreshholdAlpha(this.this$0.getCleanThreshholdAlphaBlur());
            }
            this.this$0.setCleanThreshholdAlphaBlur((51266 - f2) / 51266);
        } else {
            if (Util.equalsEpsilon(f2, this.getStartValue())) {
                this.this$0.setCleanThreshholdAlphaBlur((51266 - f2) / 51266);
            } else {
                this.this$0.setCleanThreshholdAlphaBlur(this.this$0.getCleanThreshholdAlpha());
            }
            this.this$0.setCleanThreshholdAlpha((51266 - f2) / 51266);
        }
        if (Util.equalsEpsilon(f2, this.getEndValue())) {
            this.this$0.setCleanThreshholdAlpha(this.this$0.getCleanThreshholdAlphaBlur());
        }
        this.this$0.repaint();
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }
}

