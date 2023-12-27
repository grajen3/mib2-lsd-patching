/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.ScrollableText;
import de.vw.mib.widgets.models.ScrollableTextModel;

final class ScrollableText$ScrollingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final ScrollableTextModel scrollableText;
    private final /* synthetic */ ScrollableText this$0;

    public ScrollableText$ScrollingAnimation(ScrollableText scrollableText, ScrollableTextModel scrollableTextModel, EasingParams easingParams, float f2, float f3) {
        this.this$0 = scrollableText;
        super(scrollableText, easingParams, f2, f3);
        this.scrollableText = scrollableTextModel;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.scrollableText.setViewportPosition(0, (int)f2);
    }
}

