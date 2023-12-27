/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.DynamicImage$Transition$FadeIn;
import de.vw.mib.widgets.DynamicImage$Transition$FadeOut;
import de.vw.mib.widgets.DynamicImage$Transition$FlapIn;
import de.vw.mib.widgets.DynamicImage$Transition$FlapOut;
import de.vw.mib.widgets.DynamicImage$Transition$FlyInEast;
import de.vw.mib.widgets.DynamicImage$Transition$FlyInWest;
import de.vw.mib.widgets.DynamicImage$Transition$FlyOutEast;
import de.vw.mib.widgets.DynamicImage$Transition$FlyOutWest;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;

public interface DynamicImage$Transition {
    public static final DynamicImage$Transition FLY_IN_EAST = new DynamicImage$Transition$FlyInEast();
    public static final DynamicImage$Transition FLY_IN_WEST = new DynamicImage$Transition$FlyInWest();
    public static final DynamicImage$Transition FLY_OUT_EAST = new DynamicImage$Transition$FlyOutEast();
    public static final DynamicImage$Transition FLY_OUT_WEST = new DynamicImage$Transition$FlyOutWest();
    public static final DynamicImage$Transition FADE_IN = new DynamicImage$Transition$FadeIn();
    public static final DynamicImage$Transition FADE_OUT = new DynamicImage$Transition$FadeOut();
    public static final DynamicImage$Transition FLAP_IN = new DynamicImage$Transition$FlapIn();
    public static final DynamicImage$Transition FLAP_OUT = new DynamicImage$Transition$FlapOut();

    default public float getStartValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
    }

    default public float getDeltaValue(DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
    }

    default public void modifyValue(float f2, DynamicImageModel$Picture dynamicImageModel$Picture, DynamicImageModel dynamicImageModel) {
    }
}

