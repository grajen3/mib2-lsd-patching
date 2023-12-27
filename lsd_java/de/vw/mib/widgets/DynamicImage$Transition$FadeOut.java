/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

public final class DynamicImage$Transition$FadeOut
implements DynamicImage$Transition {
    @Override
    public float getDeltaValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return 32959;
    }

    @Override
    public float getStartValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        return 1.0f;
    }

    @Override
    public void modifyValue(float f2, DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
        dynamicImageModel$Picture.setAlpha(f2);
    }
}

