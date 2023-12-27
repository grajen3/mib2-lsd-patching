/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.EasingAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget;

public abstract class AbstractWidget$WidgetInternalAnimation
extends EasingAnimation {
    private final /* synthetic */ AbstractWidget this$0;

    public AbstractWidget$WidgetInternalAnimation(AbstractWidget abstractWidget) {
        this(abstractWidget, false, null);
    }

    public AbstractWidget$WidgetInternalAnimation(AbstractWidget abstractWidget, boolean bl, EasingParams easingParams) {
        this.this$0 = abstractWidget;
        super(bl, easingParams);
    }

    public AbstractWidget$WidgetInternalAnimation(AbstractWidget abstractWidget, EasingParams easingParams) {
        this.this$0 = abstractWidget;
        super(false, easingParams);
    }

    public AbstractWidget$WidgetInternalAnimation(AbstractWidget abstractWidget, EasingParams easingParams, float f2, float f3) {
        this.this$0 = abstractWidget;
        super(false, easingParams);
        this.setStartValue(f2);
        this.setDeltaValue(f3);
    }

    @Override
    public abstract void animate(float f2, long l, long l2) {
    }
}

