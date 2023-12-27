/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PictureViewer;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

final class PictureViewer$RotationAnimation
extends AbstractWidget$WidgetInternalAnimation {
    DynamicImageModel$Picture picture;
    float rotationStartValue;
    float rotationDelta;
    float xStartValue;
    float xDelta;
    float yStartValue;
    float yDelta;
    private final /* synthetic */ PictureViewer this$0;

    public PictureViewer$RotationAnimation(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
        super(pictureViewer, null);
    }

    public void setAnimationParams(DynamicImageModel$Picture dynamicImageModel$Picture, EasingParams easingParams, float f2) {
        super.setEasingParams(easingParams);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
        this.picture = dynamicImageModel$Picture;
        this.rotationStartValue = dynamicImageModel$Picture.getRotationZ();
        this.rotationDelta = f2 - this.rotationStartValue;
        this.xStartValue = dynamicImageModel$Picture.getCenterX();
        this.xDelta = -this.xStartValue;
        this.yStartValue = dynamicImageModel$Picture.getCenterY();
        this.yDelta = -this.yStartValue;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.picture.setRotationZ(this.rotationStartValue + f2 * this.rotationDelta);
        this.picture.setCenterX(this.xStartValue + f2 * this.xDelta);
        this.picture.setCenterY(this.yStartValue + f2 * this.yDelta);
        this.this$0.repaint();
    }
}

