/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.SpinLabel;

public final class SpinLabel$SpinLabelFlippingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final SpinLabel spinLabel;
    private final /* synthetic */ SpinLabel this$0;

    public SpinLabel$SpinLabelFlippingAnimation(SpinLabel spinLabel, SpinLabel spinLabel2, EasingParams easingParams, float f2, float f3) {
        this.this$0 = spinLabel;
        super(spinLabel, easingParams, f2, f3);
        this.spinLabel = spinLabel2;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        int n = (int)f2;
        this.spinLabel.setScrollPosition(n);
        if (n == (int)(this.getStartValue() + this.getDeltaValue())) {
            this.swapLayouts();
        }
    }

    @Override
    public void stop() {
        super.stop();
        this.swapLayouts();
    }

    private void swapLayouts() {
        if (this.spinLabel.get_mode() == 0 && this.this$0.textLayouts[1] != null) {
            if (this.this$0.textLayouts[0] != null) {
                this.this$0.textLayouts[0].reference();
            }
            if (this.this$0.textLayouts[1] != null) {
                this.this$0.textLayouts[1].dispose();
            }
            this.this$0.textLayouts[1] = this.this$0.textLayouts[0];
            this.this$0.textLayouts[1] = null;
            this.this$0.repaint();
        }
    }
}

