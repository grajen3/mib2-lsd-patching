/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

final class DynamicImage$TransitionAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final DynamicImageModel$Picture picture;
    private final DynamicImage$Transition transition;
    private final /* synthetic */ DynamicImage this$0;

    public DynamicImage$TransitionAnimation(DynamicImage dynamicImage, DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImage$Transition dynamicImage$Transition, EasingParams easingParams) {
        this.this$0 = dynamicImage;
        super(dynamicImage, easingParams);
        this.picture = dynamicImageModel$Picture;
        this.transition = dynamicImage$Transition;
        this.setStartValue(this.transition.getStartValue(dynamicImageModel$Picture, dynamicImage));
        this.setDeltaValue(this.transition.getDeltaValue(dynamicImageModel$Picture, dynamicImage));
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.transition.modifyValue(f2, this.picture, this.this$0);
        this.this$0.repaintParent();
    }

    @Override
    public void stop() {
        super.stop();
        this.transition.modifyValue(this.getStartValue() + this.getDeltaValue(), this.picture, this.this$0);
        if (this == this.this$0.newPictureInAnimation) {
            this.this$0.nextPictureAnimationFinished();
        } else if (this == this.this$0.currentPictureOutAnimation) {
            this.this$0.currentPictureOutAnimationFinished();
        }
    }
}

