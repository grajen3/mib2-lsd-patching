/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Compass;

final class Compass$CompassHeadingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final Compass compass;
    private final /* synthetic */ Compass this$0;

    public Compass$CompassHeadingAnimation(Compass compass, Compass compass2, EasingParams easingParams, float f2, float f3) {
        this.this$0 = compass;
        super(compass, easingParams, f2, f3);
        this.compass = compass2;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.compass.setHeadingToDraw(f2);
    }
}

