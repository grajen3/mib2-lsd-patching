/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;

public interface CompositeBackground {
    public static final int IMAGE_BACKGROUND;
    public static final int IMAGE_MASK_BACKGROUND;
    public static final int IMAGE_MASK_ARROW;
    public static final int IMAGE_BORDER_BACKGROUND;
    public static final int IMAGE_BORDER_ARROW;
    public static final int IMAGE_COUNT;
    public static final int COLOR_BACKGROUND;
    public static final int COLOR_MASK_BACKGROUND;
    public static final int COLOR_MASK_ARROW;
    public static final int COLOR_BORDER_BACKGROUND;
    public static final int COLOR_BORDER_ARROW;
    public static final int COLOR_COUNT;
    public static final int COMPOSITE_BACKGROUND_MODE_NONE;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_OFF;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_TOP;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_BOTTOM;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_LEFT;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_RIGHT;
    public static final int COMPOSITE_BACKGROUND_MODE_SIMPLE;
    public static final int COMPOSITE_BACKGROUND_MODE_ARROW_BOTTOM_CENTERED;

    default public Image[] get_compositeBackgroundImages() {
    }

    default public void set_compositeBackgroundImages(Image[] imageArray) {
    }

    default public Color[] get_compositeBackgroundColors() {
    }

    default public void set_compositeBackgroundColors(Color[] colorArray) {
    }

    default public int get_compositeBackgroundMode() {
    }

    default public void set_compositeBackgroundMode(int n) {
    }

    default public int get_compositeBackgroundArrowOffsetX() {
    }

    default public void set_compositeBackgroundArrowOffsetX(int n) {
    }

    default public int get_compositeBackgroundArrowOffsetY() {
    }

    default public void set_compositeBackgroundArrowOffsetY(int n) {
    }

    default public Rectangle getBackgroundArea() {
    }

    default public Point getArrowPosition() {
    }

    default public void setArrowDestinationArea(Rectangle rectangle) {
    }
}

