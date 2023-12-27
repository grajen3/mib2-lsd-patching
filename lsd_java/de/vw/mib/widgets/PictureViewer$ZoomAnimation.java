/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PictureViewer;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

final class PictureViewer$ZoomAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private DynamicImageModel$Picture picture;
    private float zoomFactorStart;
    private float zoomFactorDelta;
    private float xStart;
    private float xDelta;
    private float yStart;
    private float yDelta;
    private final /* synthetic */ PictureViewer this$0;

    public PictureViewer$ZoomAnimation(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
        super(pictureViewer, null);
    }

    public void setAnimationParams(DynamicImageModel$Picture dynamicImageModel$Picture, EasingParams easingParams, float f2, float f3, float f4) {
        this.setEasingParams(easingParams);
        this.picture = dynamicImageModel$Picture;
        this.zoomFactorStart = dynamicImageModel$Picture.getZoomFactor();
        this.zoomFactorDelta = f2 - this.zoomFactorStart;
        this.xStart = dynamicImageModel$Picture.getCenterX();
        this.xDelta = f3 - this.xStart;
        this.yStart = dynamicImageModel$Picture.getCenterY();
        this.yDelta = f4 - this.yStart;
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.picture.setZoomFactor(this.zoomFactorStart + f2 * this.zoomFactorDelta);
        this.picture.setCenterX(this.xStart + this.xDelta * f2);
        this.picture.setCenterY(this.yStart + this.yDelta * f2);
        this.this$0.repaint();
    }
}

