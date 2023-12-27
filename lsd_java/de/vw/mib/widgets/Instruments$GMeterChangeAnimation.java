/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$HaloKindImageMapping;

final class Instruments$GMeterChangeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final float startX;
    private final float deltaX;
    private final float startY;
    private final float deltaY;
    private final Instruments$HaloKindImageMapping halo;
    private final /* synthetic */ Instruments this$0;

    public Instruments$GMeterChangeAnimation(Instruments instruments, EasingParams easingParams, Instruments$HaloKindImageMapping instruments$HaloKindImageMapping, Point2f point2f, Point2f point2f2) {
        this.this$0 = instruments;
        super(instruments, easingParams, 0.0f, 1.0f);
        this.setAnimationInterval(125);
        this.startX = point2f.x;
        this.deltaX = point2f2.x - point2f.x;
        this.startY = point2f.y;
        this.deltaY = point2f2.y - point2f.y;
        this.halo = instruments$HaloKindImageMapping;
    }

    public float getEndXValue() {
        return this.startX + this.deltaX;
    }

    public float getEndYValue() {
        return this.startY + this.deltaY;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        float f3 = this.startX + this.deltaX * f2;
        float f4 = this.startY + this.deltaY * f2;
        this.halo.addInterpolatedHaloPosition(f3, f4);
        this.this$0.repaint();
    }
}

