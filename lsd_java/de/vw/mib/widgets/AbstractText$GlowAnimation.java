/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;

final class AbstractText$GlowAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ AbstractText this$0;

    public AbstractText$GlowAnimation(AbstractText abstractText, EasingParams easingParams, float f2, float f3) {
        this.this$0 = abstractText;
        super(abstractText, easingParams, f2, f3);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.glowAlpha = f2;
        this.this$0.repaintParent();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.glowAlpha = this.getStartValue() + this.getDeltaValue();
        this.this$0.repaintParent();
    }
}

