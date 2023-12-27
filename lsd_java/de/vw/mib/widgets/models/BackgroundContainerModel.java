/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.interfaces.CompositeBackground;
import de.vw.mib.widgets.models.ContainerModel;

public interface BackgroundContainerModel
extends ContainerModel,
CompositeBackground {
    public static final int PID_BASE;
    public static final int PID_COMPOSITE_BACKGROUND_IMAGES;
    public static final int PID_COMPOSITE_BACKGROUND_COLORS;
    public static final int PID_COMPOSITE_BACKGROUND_MODE;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_X;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_Y;
    public static final int PID_FLYING_WINDOW_MODE;
    public static final int PID_FLYING_WINDOW_IMAGES;
    public static final int PID_FLYING_WINDOW_ARROWS_OFFSET_X;
    public static final int PID_FLYING_WINDOW_ARROWS_OFFSET_Y;
    public static final int PID_COUNT_BACKGROUND_CONTAINER;
    public static final int SID_BASE;
    public static final int SID_COUNT_BACKGROUND_CONTAINER;
    public static final int FLYING_WINDOW_MODE_BASE;
    public static final int FLYING_WINDOW_MODE_NONE;
    public static final int FLYING_WINDOW_MODE_HORIZONTAL;
    public static final int FLYING_WINDOW_MODE_VERTICAL;
    public static final int FLYING_WINDOW_MODE_BOTH;
    public static final int FLYING_WINDOW_MODE_COUNT_BACKGROUND_CONTAINER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_BACKGROUND_CONTAINER;

    default public float getBackgroundAlpha() {
    }

    default public float getContentAlpha() {
    }

    default public int get_flyingWindowMode() {
    }

    default public void set_flyingWindowMode(int n) {
    }

    default public Image[] get_flyingWindowImages() {
    }

    default public void set_flyingWindowImages(Image[] imageArray) {
    }

    default public int[] get_flyingWindowArrowsOffsetX() {
    }

    default public void set_flyingWindowArrowsOffsetX(int[] nArray) {
    }

    default public int[] get_flyingWindowArrowsOffsetY() {
    }

    default public void set_flyingWindowArrowsOffsetY(int[] nArray) {
    }
}

