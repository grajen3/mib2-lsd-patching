/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractImageModel;

public interface CompassModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_HEADING;
    public static final int PID_ROSE_IMAGE;
    public static final int PID_DISTANCE;
    public static final int PID_ROTATION;
    public static final int PID_INVERT_HEADING;
    public static final int PID_COUNT_COMPASS;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_HEADING_ANIMATION;
    public static final int EASING_INDEX_COUNT_COMPASS;
    public static final int SID_BASE;
    public static final int SID_INVERT_HEADING;
    public static final int SID_COUNT_COMPASS;

    default public int get_heading() {
    }

    default public void set_heading(int n) {
    }

    default public int get_rotation() {
    }

    default public void set_rotation(int n) {
    }

    default public int get_distance() {
    }

    default public void set_distance(int n) {
    }

    default public Image get_roseImage() {
    }

    default public void set_roseImage(Image image) {
    }

    default public boolean is_invertHeading() {
    }

    default public void set_invertHeading(boolean bl) {
    }

    default public float getHeadingToDraw() {
    }
}

