/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PureAir;

final class PureAir$IonisationAnimation
extends AbstractWidget$WidgetInternalAnimation {
    float lastValue;
    private final /* synthetic */ PureAir this$0;

    public PureAir$IonisationAnimation(PureAir pureAir, EasingParams easingParams, float f2, float f3) {
        this.this$0 = pureAir;
        super(pureAir, easingParams, f2, f3);
        this.lastValue = f2;
    }

    public float getEndValue() {
        return this.getStartValue() + this.getDeltaValue();
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        int n = new Double(Math.floor(f2)).intValue();
        int n2 = new Double(Math.ceil(f2)).intValue();
        if (n >= 0 && n < this.this$0.stepX.length && n < this.this$0.stepY.length && n2 >= 0 && n2 < this.this$0.stepX.length && n2 < this.this$0.stepY.length) {
            float f3 = Math.abs(f2 / (float)(this.this$0.stepX.length - 1));
            int n3 = this.this$0.stepX[n2] - this.this$0.stepX[n];
            int n4 = this.this$0.stepY[n2] - this.this$0.stepY[n];
            if (f2 < this.lastValue) {
                this.this$0.setIonisationLoop(this.this$0.getIonisationLoop() + 1);
            }
            this.lastValue = f2;
            this.setLooped(this.this$0.getIonisationLoop() < this.this$0.getIonisationLoopCount());
            if (this.isLooped()) {
                this.this$0.setIonistaionAnimationPercentage(f3);
                this.this$0.setIonisationAlphaX(Math.round((float)this.this$0.stepX[n] + (float)n3 * (f2 - (float)n)));
                this.this$0.setIonisationAlphaY(Math.round((float)this.this$0.stepY[n] + (float)n4 * (f2 - (float)n)));
            }
            this.this$0.setIonisationStep(Math.round(f2));
            this.this$0.repaint();
        }
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }
}

