/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

public final class DynamicImage$Transition$FlyOutWest
implements DynamicImage$Transition {
    @Override
    public float getStartValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return dynamicImageModel$Picture.getCenterX();
    }

    @Override
    public float getDeltaValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return (float)(-(dynamicImageModel.get_width() + dynamicImageModel$Picture.getZoomedBoundingBoxWidth() >> 1)) - dynamicImageModel$Picture.getCenterX();
    }

    @Override
    public void modifyValue(float f2, DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        dynamicImageModel$Picture.setCenterX(f2);
    }
}

