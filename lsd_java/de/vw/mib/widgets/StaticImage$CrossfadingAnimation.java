/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.StaticImage;

final class StaticImage$CrossfadingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final StaticImage staticImage;
    private final /* synthetic */ StaticImage this$0;

    public StaticImage$CrossfadingAnimation(StaticImage staticImage, EasingParams easingParams, StaticImage staticImage2) {
        this.this$0 = staticImage;
        super(staticImage, easingParams, 0.0f, 1.0f);
        this.staticImage = staticImage2;
        this.staticImage.setBlendAlpha(0.0f);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.staticImage.setBlendAlpha(f2);
    }

    @Override
    public void stop() {
        super.stop();
        this.staticImage.setBlendAlpha(1.0f);
        this.staticImage.setPreviousImage(null);
    }
}

