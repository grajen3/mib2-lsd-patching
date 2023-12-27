/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.PushUp;
import de.vw.mib.widgets.PushUp$FadeInAnimation;

public final class PushUp$FadeOutAnimation
extends PushUp$FadeInAnimation {
    private final /* synthetic */ PushUp this$0;

    public PushUp$FadeOutAnimation(PushUp pushUp) {
        this.this$0 = pushUp;
        super(pushUp);
    }

    @Override
    public void setAnimationParams(EasingParams easingParams) {
        super.setEasingParams(easingParams);
        this.setStartValue(this.this$0.getBackgroundAlpha());
        this.setDeltaValue(-this.this$0.getBackgroundAlpha());
    }
}

