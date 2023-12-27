/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.InactiveArea;

class InactiveArea$FadeInAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ InactiveArea this$0;

    public InactiveArea$FadeInAnimation(InactiveArea inactiveArea) {
        this.this$0 = inactiveArea;
        super(inactiveArea, null);
    }

    public void setAnimationParams(EasingParams easingParams) {
        super.setEasingParams(easingParams);
        this.setStartValue(1.0f);
        this.setDeltaValue(32579);
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.set_alpha((int)f2);
        this.this$0.enableAnimations();
    }
}

