/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.interfaces.Glowable;
import de.vw.mib.widgets.models.AbstractImageModel;

public interface StaticImageModel
extends AbstractImageModel,
Glowable {
    public static final int PID_BASE;
    public static final int PID_IMAGE;
    public static final int PID_GLOW_TYPE;
    public static final int PID_GLOW_COLOR;
    public static final int PID_GLOW_VISIBLE;
    public static final int PID_GRADIENT;
    public static final int PID_GRADIENT_COLORS;
    public static final int PID_COUNT_STATIC_IMAGE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_CROSSFADING_ANIMATION;
    public static final int EASING_INDEX_GLOW_IN;
    public static final int EASING_INDEX_GLOW_OUT;
    public static final int EASING_INDEX_COUNT_STATIC_IMAGE;
    public static final int SID_BASE;
    public static final int SID_GLOW_VISIBLE;
    public static final int SID_COUNT_STATIC_IMAGE;

    default public Image get_image() {
    }

    default public void set_image(Image image) {
    }

    default public Gradient get_gradient() {
    }

    default public void set_gradient(Gradient gradient) {
    }

    default public Color[] get_gradientColors() {
    }

    default public void set_gradientColors(Color[] colorArray) {
    }

    default public void setCrossfadeEasing(EasingParams easingParams) {
    }

    default public Image getPreviousImage() {
    }

    default public float getBlendAlpha() {
    }
}

