/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.InactiveArea;
import de.vw.mib.widgets.InactiveArea$FadeInAnimation;

final class InactiveArea$FadeOutAnimation
extends InactiveArea$FadeInAnimation {
    private final /* synthetic */ InactiveArea this$0;

    public InactiveArea$FadeOutAnimation(InactiveArea inactiveArea) {
        this.this$0 = inactiveArea;
        super(inactiveArea);
    }

    @Override
    public void setAnimationParams(EasingParams easingParams) {
        super.setEasingParams(easingParams);
        this.setStartValue(this.this$0.get_alpha());
        this.setDeltaValue(-this.getStartValue());
    }
}

