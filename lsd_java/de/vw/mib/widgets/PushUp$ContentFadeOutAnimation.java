/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.PushUp;
import de.vw.mib.widgets.PushUp$ContentFadeInAnimation;

public final class PushUp$ContentFadeOutAnimation
extends PushUp$ContentFadeInAnimation {
    private final /* synthetic */ PushUp this$0;

    public PushUp$ContentFadeOutAnimation(PushUp pushUp) {
        this.this$0 = pushUp;
        super(pushUp);
    }

    @Override
    public void setAnimationParams(EasingParams easingParams) {
        super.setEasingParams(easingParams);
        this.setStartValue(this.this$0.getContentAlpha());
        this.setDeltaValue(-this.this$0.getContentAlpha());
    }
}

