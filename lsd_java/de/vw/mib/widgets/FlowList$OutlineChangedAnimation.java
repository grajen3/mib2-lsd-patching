/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.FlowList;

final class FlowList$OutlineChangedAnimation
extends AbstractWidget$WidgetInternalAnimation {
    public float currentAnimationValue;
    public final int oldOutline;
    private final /* synthetic */ FlowList this$0;

    public FlowList$OutlineChangedAnimation(FlowList flowList, EasingParams easingParams, int n) {
        this.this$0 = flowList;
        super(flowList, easingParams);
        this.oldOutline = n;
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.currentAnimationValue = f2;
        this.this$0.invalidateFlowLayout();
    }
}

