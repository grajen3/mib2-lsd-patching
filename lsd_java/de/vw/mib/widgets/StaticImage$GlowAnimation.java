/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.StaticImage;

final class StaticImage$GlowAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ StaticImage this$0;

    public StaticImage$GlowAnimation(StaticImage staticImage, EasingParams easingParams, float f2, float f3) {
        this.this$0 = staticImage;
        super(staticImage, easingParams, f2, f3);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.setGlowAlpha(f2);
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.setGlowAlpha(this.getStartValue() + this.getDeltaValue());
    }
}

