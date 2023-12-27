/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.ScreenArea;
import de.vw.mib.widgets.models.ViewModel;

final class ScreenArea$MoveOutViewAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final ViewModel view;
    private final /* synthetic */ ScreenArea this$0;

    public ScreenArea$MoveOutViewAnimation(ScreenArea screenArea, EasingParams easingParams, float f2, float f3, ViewModel viewModel) {
        this.this$0 = screenArea;
        super(screenArea, easingParams, f2, f3);
        this.view = viewModel;
    }

    public float getEndValue() {
        return this.getStartValue() + this.getDeltaValue();
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.view.set_x(Math.round(f2));
        this.this$0.repaint();
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }
}

