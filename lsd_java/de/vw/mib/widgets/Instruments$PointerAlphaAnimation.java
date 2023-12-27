/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments;

final class Instruments$PointerAlphaAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final int index;
    private final /* synthetic */ Instruments this$0;

    public Instruments$PointerAlphaAnimation(Instruments instruments, EasingParams easingParams, int n, int n2, int n3) {
        this.this$0 = instruments;
        super(instruments, easingParams, n2, n3 - n2);
        this.setAnimationInterval(125);
        this.index = n;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.setHaloAlphaInternal(this.index, Math.round(f2));
    }
}

