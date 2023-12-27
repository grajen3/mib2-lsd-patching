/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PictureViewer;

final class PictureViewer$SnappingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private int startX;
    private int startY;
    private int deltaX;
    private int deltaY;
    private final /* synthetic */ PictureViewer this$0;

    public PictureViewer$SnappingAnimation(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
        super(pictureViewer, null);
    }

    public void setAnimationParams(EasingParams easingParams, int n, int n2) {
        this.setEasingParams(easingParams);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
        this.startX = this.this$0.getViewportX();
        this.startY = this.this$0.getViewportY();
        this.deltaX = n - this.startX;
        this.deltaY = n2 - this.startY;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        int n = (int)((float)this.startX + f2 * (float)this.deltaX);
        int n2 = (int)((float)this.startY + f2 * (float)this.deltaY);
        this.this$0.setViewportPosition(n, n2);
    }
}

