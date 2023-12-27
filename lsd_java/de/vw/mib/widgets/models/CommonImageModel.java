/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractImageModel;

public interface CommonImageModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_IMAGE_FILE;
    public static final int PID_IMAGE_TYPE;
    public static final int PID_SCALE_MODE;
    public static final int PID_COUNT_COMMON_IMAGE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_COMMON_IMAGE;
    public static final int IMAGE_TYPE_COMMON;
    public static final int IMAGE_TYPE_CAR;
    public static final int SCALE_MODE_UNSCALED;
    public static final int SCALE_MODE_FIT;

    default public void set_imageFile(String string) {
    }

    default public String get_imageFile() {
    }

    default public void set_imageType(int n) {
    }

    default public int get_imageType() {
    }

    default public void set_scaleMode(int n) {
    }

    default public int get_scaleMode() {
    }
}

