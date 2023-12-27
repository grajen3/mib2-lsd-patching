/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.GenericCarAdjuster;

final class GenericCarAdjuster$SingleFeatureValueAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private int featureId;
    private int start;
    private boolean doStop;
    private final /* synthetic */ GenericCarAdjuster this$0;

    public GenericCarAdjuster$SingleFeatureValueAnimation(GenericCarAdjuster genericCarAdjuster, EasingParams easingParams, int n, int n2, int n3, boolean bl) {
        this.this$0 = genericCarAdjuster;
        super(genericCarAdjuster, easingParams, n, n2 - n);
        this.featureId = n3;
        this.start = n;
        this.doStop = bl;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.setAnimationFeatureValueForId(this.featureId, Math.round(f2));
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.setAnimationFeatureValueForId(this.featureId, this.this$0.get_featureValues()[this.featureId]);
        if (!this.doStop) {
            this.this$0.startFeatureValueAnimationPartTwo(this.featureId, this.start);
        }
    }
}

